package be.lionelh.magic.listing.data.domain.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.lionelh.magic.listing.data.domain.dao.CardDao;
import be.lionelh.magic.listing.data.domain.entities.Card;
import be.lionelh.magic.listing.data.domain.entities.Color;
import be.lionelh.magic.listing.data.domain.entities.ManaAbbreviation;

/**
 * @author Lionel
 */
@Named("cardDao")
public class CardDaoImpl implements CardDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Card create(Card inCard) {
		em.persist(inCard);
		em.flush();
		return inCard;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Card> findAll() {
		return this.em.createNamedQuery("Card.FINDALL").getResultList();
	}

	@Override
	public Card findById(Long inId) {
		return em.find(Card.class, inId);
	}

	@Override
	public Card findByName(String inName) {
		TypedQuery<Card> query = em.createNamedQuery("Card.FINDBYNAME", Card.class);
		query.setParameter("name", inName);
		List<Card> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}
	}

	@Override
	public Card findByNom(String inNom) {
		TypedQuery<Card> query = em.createNamedQuery("Card.FINDBYNOM", Card.class);
		query.setParameter("nom", inNom);
		List<Card> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}
	}

	@Override
	public List<Card> findByTypeCard(Long inTypeCardId) {
		TypedQuery<Card> query = em.createNamedQuery("Card.FINDBYTYPECARD", Card.class);
		query.setParameter("typeCardId", inTypeCardId);
		return query.getResultList();
	}

	@Override
	public List<Card> findByColor(Long inColorId) {
		// 1) Retrieve the ManaAbbreviation
		Color c = em.find(Color.class, inColorId);
		List<ManaAbbreviation> l = c.getManaAbbreviations();
		// 2.0) Test to see if the color has some ManaAbbreviation
		if (!l.isEmpty()) {
			// 2.1a) Color has some ManaAbbreviation. so build a Qury base on this ManaAbbreviation
			// 2.2a) Build the fixed part of the query
			String selectClause = "SELECT new be.lionelh.magic.listing.data.domain.entities.Card(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate,c.color,c.typeCard)";
			String fromClause = "FROM Card c, IN(c.cardEditions) ce";
			// 2.3a) Build the whereClause
			String whereClause = "WHERE";
			for(ManaAbbreviation ma : l) {
				if (whereClause.length() > 5) {
					whereClause += " OR";
				}
				whereClause += " ce.cost LIKE '%" + ma.getRepresentation() + "%'";
			}
			// 4) Build the full query
			String query = selectClause + " " + fromClause;
			if (whereClause.length() > 4) {
				query = query + " " + whereClause;
			}
			System.out.println(query);
			// 5) Execute the query and return its result
			TypedQuery<Card> tq = em.createQuery(query, Card.class);
			return tq.getResultList();
		} else {
			// 2.1b) Color has no ManaAbbreviation so simply use the NamedQuery Card.FINDBYCOLOr
			TypedQuery<Card> tq = em.createNamedQuery("Card.FINDBYCOLOR", Card.class);
			tq.setParameter("colorId", inColorId);
			return tq.getResultList();
		}
	}

	@Override
	public List<Card> findByFamily(Long inFamilyId) {
		TypedQuery<Card> query = em.createNamedQuery("Card.FINDBYFAMILY", Card.class);
		query.setParameter("familyId", inFamilyId);
		return query.getResultList();
	}

	@Override
	public List<Card> findByEdition(Long inEditionId) {
		TypedQuery<Card> query = em.createNamedQuery("Card.FINDBYEDITION", Card.class);
		query.setParameter("editionId", inEditionId);
		return query.getResultList();
	}

	@Override
	public List<Card> findByCapacity(Long inCapacityId) {
		TypedQuery<Card> query = em.createNamedQuery("Card.FINDBYCAPACITY", Card.class);
		query.setParameter("capacityId", inCapacityId);
		return query.getResultList();
	}

	@Override
	public List<Card> findByRarity(Long inRarityId) {
		TypedQuery<Card> query = em.createNamedQuery("Card.FINDBYRARITY", Card.class);
		query.setParameter("rarityId", inRarityId);
		return query.getResultList();
	}

	@Override
	public Card update(Card inCard) {
		em.merge(inCard);
		em.flush();

		return em.find(Card.class, inCard.getId());
	}

	@Override
	public void delete(Card inCard) {
		Card mo = em.merge(inCard);
		em.remove(mo);
	}
}
