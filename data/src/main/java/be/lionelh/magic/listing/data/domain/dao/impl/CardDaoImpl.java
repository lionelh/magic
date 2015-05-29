package be.lionelh.magic.listing.data.domain.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.lionelh.magic.listing.data.domain.dao.CardDao;
import be.lionelh.magic.listing.data.domain.entities.Card;

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
