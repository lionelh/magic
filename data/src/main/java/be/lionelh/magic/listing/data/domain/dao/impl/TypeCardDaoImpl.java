package be.lionelh.magic.listing.data.domain.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.lionelh.magic.listing.data.domain.dao.TypeCardDao;
import be.lionelh.magic.listing.data.domain.entities.TypeCard;

/**
 * @author lh
 *
 */
@Named("typeCardDao")
public class TypeCardDaoImpl implements TypeCardDao {

	@PersistenceContext
    private EntityManager em;

	/**
	 * @see be.lionelh.magic.data.domain.dao.TypeCardDao#create(be.lionelh.magic.data.domain.entities.TypeCard)
	 */
	@Override
	public TypeCard create(TypeCard inTypeCard) {
		em.persist(inTypeCard);
		return inTypeCard;
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.TypeCardDao#findAll()
	 */
	@Override
	public List<TypeCard> findAll() {
		return this.em.createNamedQuery("TypeCard.FINDALL", TypeCard.class).getResultList();
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.TypeCardDao#findById(java.lang.Long)
	 */
	@Override
	public TypeCard findById(Long inId) {
		return em.find(TypeCard.class, inId);
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.TypeCardDao#findByName(java.lang.String)
	 */
	@Override
	public TypeCard findByName(String inName) {
		TypedQuery<TypeCard> query = em.createNamedQuery("TypeCard.FINDBYNAME", TypeCard.class);
        query.setParameter("name", inName);
        List<TypeCard> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.TypeCardDao#findByNom(java.lang.String)
	 */
	@Override
	public TypeCard findByNom(String inNom) {
		TypedQuery<TypeCard> query = em.createNamedQuery("TypeCard.FINDBYNOM", TypeCard.class);
        query.setParameter("nom", inNom);
        List<TypeCard> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.TypeCardDao#update(be.lionelh.magic.data.domain.entities.TypeCard)
	 */
	@Override
	public TypeCard update(TypeCard inTypeCard) {
		em.merge(inTypeCard);
        em.flush();

        return em.find(TypeCard.class, inTypeCard.getId());
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.TypeCardDao#delete(be.lionelh.magic.data.domain.entities.TypeCard)
	 */
	@Override
	public void delete(TypeCard inTypeCard) {
		TypeCard mo = em.merge(inTypeCard);
        em.remove(mo);
	}

}
