package be.lionelh.magic.listing.data.domain.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.lionelh.magic.listing.data.domain.dao.CapacityDao;
import be.lionelh.magic.listing.data.domain.entities.Capacity;

/**
 * @author lh
 *
 */
@Named("capacityDao")
public class CapacityDaoImpl implements CapacityDao {

	@PersistenceContext
    private EntityManager em;

	/**
	 * @see be.lionelh.magic.data.domain.dao.CapacityDao#create(be.lionelh.magic.listing.data.domain.entities.Capacity)
	 */
	@Override
	public Capacity create(Capacity inCapacity) {
		em.persist(inCapacity);
		return inCapacity;
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.CapacityDao#findAll()
	 */
	@Override
	public List<Capacity> findAll() {
		return this.em.createNamedQuery("Capacity.FINDALL", Capacity.class).getResultList();
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.CapacityDao#findById(java.lang.Long)
	 */
	@Override
	public Capacity findById(Long inId) {
		return em.find(Capacity.class, inId);
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.CapacityDao#findByName(java.lang.String)
	 */
	@Override
	public Capacity findByName(String inName) {
		TypedQuery<Capacity> query = em.createNamedQuery("Capacity.FINDBYNAME", Capacity.class);
        query.setParameter("name", inName);
        List<Capacity> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.CapacityDao#findByNom(java.lang.String)
	 */
	@Override
	public Capacity findByNom(String inNom) {
		TypedQuery<Capacity> query = em.createNamedQuery("Capacity.FINDBYNAME", Capacity.class);
        query.setParameter("nom", inNom);
        List<Capacity> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.CapacityDao#update(be.lionelh.magic.listing.data.domain.entities.Capacity)
	 */
	@Override
	public Capacity update(Capacity inCapacity) {
		em.merge(inCapacity);
        em.flush();

        return em.find(Capacity.class, inCapacity.getId());
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.CapacityDao#delete(be.lionelh.magic.listing.data.domain.entities.Capacity)
	 */
	@Override
	public void delete(Capacity inCapacity) {
		Capacity mo = em.merge(inCapacity);
        em.remove(mo);
	}

}
