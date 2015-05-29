package be.lionelh.magic.listing.data.domain.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.lionelh.magic.listing.data.domain.dao.CardEditionDao;
import be.lionelh.magic.listing.data.domain.entities.Card;
import be.lionelh.magic.listing.data.domain.entities.CardEdition;
import be.lionelh.magic.listing.data.domain.entities.CardEditionPK;
import be.lionelh.magic.listing.data.domain.entities.Edition;

/**
 * @author lh
 *
 */
@Named("cardEditionDao")
public class CardEditionDaoImpl implements CardEditionDao {

	@PersistenceContext
    private EntityManager em;

	/**
	 * @see be.lionelh.magic.data.domain.dao.CardEditionDao#create(be.lionelh.magic.listing.data.domain.entities.CardEdition)
	 */
	@Override
	public CardEdition create(CardEdition inCardEdition) {
		em.persist(inCardEdition);
		em.flush();
		return inCardEdition;
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.CardEditionDao#findAll()
	 */
	@Override
	public List<CardEdition> findAll() {
		return this.em.createNamedQuery("CardEditionDto.FINDALL", CardEdition.class).getResultList();
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.CardEditionDao#findById(be.lionelh.magic.listing.data.domain.entities.CardEditionPK)
	 */
	@Override
	public CardEdition findById(CardEditionPK inId) {
		return em.find(CardEdition.class, inId);
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.CardEditionDao#findByCard(be.lionelh.magic.listing.data.domain.entities.Card)
	 */
	@Override
	public List<CardEdition> findByCard(Card inCard) {
		TypedQuery<CardEdition> query = em.createNamedQuery("CardEditionDto.FINDBYCARD", CardEdition.class);
        query.setParameter("cardId", inCard.getId());
        return query.getResultList();
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.CardEditionDao#findByEdition(be.lionelh.magic.listing.data.domain.entities.Edition)
	 */
	@Override
	public List<CardEdition> findByEdition(Edition inEdition) {
		TypedQuery<CardEdition> query = em.createNamedQuery("CardEditionDto.FINDBYEDITION", CardEdition.class);
        query.setParameter("editionId", inEdition.getId());
        return query.getResultList();
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.CardEditionDao#update(be.lionelh.magic.listing.data.domain.entities.CardEdition)
	 */
	@Override
	public CardEdition update(CardEdition inCardEdition) {
		em.merge(inCardEdition);
        em.flush();

        return em.find(CardEdition.class, inCardEdition.getId());
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.CardEditionDao#delete(be.lionelh.magic.listing.data.domain.entities.CardEdition)
	 */
	@Override
	public void delete(CardEdition inCardEdition) {
		CardEdition mo = em.merge(inCardEdition);
        em.remove(mo);
	}

}
