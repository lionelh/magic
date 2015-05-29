package be.lionelh.magic.listing.data.domain.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.lionelh.magic.listing.data.domain.dao.FamilyDao;
import be.lionelh.magic.listing.data.domain.entities.Family;

/**
 * @author lh
 *
 */
@Named("familyDao")
public class FamilyDaoImpl implements FamilyDao {

	@PersistenceContext
    private EntityManager em;

	/**
	 * @see be.lionelh.magic.data.domain.dao.FamilyDao#create(be.lionelh.magic.listing.data.domain.entities.Family)
	 */
	@Override
	public Family create(Family inFamily) {
		em.persist(inFamily);
		return inFamily;
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.FamilyDao#findAll()
	 */
	@Override
	public List<Family> findAll() {
		return this.em.createNamedQuery("Family.FINDALL", Family.class).getResultList();
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.FamilyDao#findById(java.lang.Long)
	 */
	@Override
	public Family findById(Long inId) {
		return em.find(Family.class, inId);
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.FamilyDao#findByName(java.lang.String)
	 */
	@Override
	public Family findByName(String inName) {
		TypedQuery<Family> query = em.createNamedQuery("Family.FINDBYNAME", Family.class);
        query.setParameter("name", inName);
        List<Family> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.FamilyDao#findByNom(java.lang.String)
	 */
	@Override
	public Family findByNom(String inNom) {
		TypedQuery<Family> query = em.createNamedQuery("Family.FINDBYNOM", Family.class);
        query.setParameter("nom", inNom);
        List<Family> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.FamilyDao#update(be.lionelh.magic.listing.data.domain.entities.Family)
	 */
	@Override
	public Family update(Family inFamily) {
		em.merge(inFamily);
        em.flush();

        return em.find(Family.class, inFamily.getId());
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.FamilyDao#delete(be.lionelh.magic.listing.data.domain.entities.Family)
	 */
	@Override
	public void delete(Family inFamily) {
		Family mo = em.merge(inFamily);
        em.remove(mo);
	}

}
