package be.lionelh.magic.listing.data.domain.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.lionelh.magic.listing.data.domain.dao.EditionDao;
import be.lionelh.magic.listing.data.domain.entities.Edition;

/**
 * @author lh
 *
 */
@Named("editionDao")
public class EditionDaoImpl implements EditionDao {

	@PersistenceContext
    private EntityManager em;


	/**
	 * @see be.lionelh.magic.data.domain.dao.EditionDao#create(be.lionelh.magic.listing.data.domain.entities.Edition)
	 */
	@Override
	public Edition create(Edition inEdition) {
		em.persist(inEdition);
		em.flush();
		return inEdition;
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.EditionDao#findAll()
	 */
	@Override
	public List<Edition> findAll() {
		return this.em.createNamedQuery("Edition.FINDALL", Edition.class).getResultList();
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.EditionDao#findById(java.lang.Long)
	 */
	@Override
	public Edition findById(Long inId) {
		return em.find(Edition.class, inId);
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.EditionDao#findByName(java.lang.String)
	 */
	@Override
	public Edition findByName(String inName) {
		TypedQuery<Edition> query = em.createNamedQuery("Edition.FINDBYNAME", Edition.class);
        query.setParameter("name", inName);
        List<Edition> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.EditionDao#findByNom(java.lang.String)
	 */
	@Override
	public Edition findByNom(String inNom) {
		TypedQuery<Edition> query = em.createNamedQuery("Edition.FINDBYNOM", Edition.class);
        query.setParameter("nom", inNom);
        List<Edition> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.EditionDao#findByAbbreviation(java.lang.String)
	 */
	@Override
	public Edition findByAbbreviation(String inAbbreviation) {
		TypedQuery<Edition> query = em.createNamedQuery("Edition.FINDBYABBREVIATION", Edition.class);
        query.setParameter("abbreviation", inAbbreviation);
        List<Edition> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.EditionDao#update(be.lionelh.magic.listing.data.domain.entities.Edition)
	 */
	@Override
	public Edition update(Edition inEdition) {
		em.merge(inEdition);
        em.flush();

        return em.find(Edition.class, inEdition.getId());
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.EditionDao#delete(be.lionelh.magic.listing.data.domain.entities.Edition)
	 */
	@Override
	public void delete(Edition inEdition) {
		Edition mo = em.merge(inEdition);
        em.remove(mo);
	}

}
