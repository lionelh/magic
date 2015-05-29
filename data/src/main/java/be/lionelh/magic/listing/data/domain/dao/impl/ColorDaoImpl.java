package be.lionelh.magic.listing.data.domain.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.lionelh.magic.listing.data.domain.dao.ColorDao;
import be.lionelh.magic.listing.data.domain.entities.Color;

/**
 * @author lh
 *
 */
@Named("colorDao")
public class ColorDaoImpl implements ColorDao {

	@PersistenceContext
    private EntityManager em;

	/**
	 * @see be.lionelh.magic.data.domain.dao.ColorDao#create(be.lionelh.magic.listing.data.domain.entities.Color)
	 */
	@Override
	public Color create(Color inColor) {
		em.persist(inColor);
		em.flush();
		return inColor;
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.ColorDao#findAll()
	 */
	@Override
	public List<Color> findAll() {
		return this.em.createNamedQuery("Color.FINDALL", Color.class).getResultList();
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.ColorDao#findById(java.lang.Long)
	 */
	@Override
	public Color findById(Long inId) {
		return em.find(Color.class, inId);
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.ColorDao#findByName(java.lang.String)
	 */
	@Override
	public Color findByName(String inName) {
		TypedQuery<Color> query = em.createNamedQuery("Color.FINDBYNAME", Color.class);
        query.setParameter("name", inName);
        List<Color> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.ColorDao#findByNom(java.lang.String)
	 */
	@Override
	public Color findByNom(String inNom) {
		TypedQuery<Color> query = em.createNamedQuery("Color.FINDBYNOM", Color.class);
        query.setParameter("nom", inNom);
        List<Color> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.ColorDao#findByAbbreviation(java.lang.String)
	 */
	@Override
	public Color findByAbbreviation(String inAbbreviation) {
		TypedQuery<Color> query = em.createNamedQuery("Color.FINDBYABBREVIATION", Color.class);
        query.setParameter("abbreviation", inAbbreviation);
        List<Color> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.ColorDao#update(be.lionelh.magic.listing.data.domain.entities.Color)
	 */
	@Override
	public Color update(Color inColor) {
		em.merge(inColor);
        em.flush();

        return em.find(Color.class, inColor.getId());
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.ColorDao#delete(be.lionelh.magic.listing.data.domain.entities.Color)
	 */
	@Override
	public void delete(Color inColor) {
		Color mo = em.merge(inColor);
        em.remove(mo);
	}

}
