package be.lionelh.magic.listing.data.domain.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.lionelh.magic.listing.data.domain.dao.RarityDao;
import be.lionelh.magic.listing.data.domain.entities.Rarity;

/**
 * @author lh
 *
 */
@Named("rarityDao")
public class RarityDaoImpl implements RarityDao {

	@PersistenceContext
    private EntityManager em;

	/**
	 * @see be.lionelh.magic.data.domain.dao.RarityDao#create(be.lionelh.magic.listing.data.domain.entities.Rarity)
	 */
	@Override
	public Rarity create(Rarity inRarity) {
		em.persist(inRarity);
		return inRarity;
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.RarityDao#findAll()
	 */
	@Override
	public List<Rarity> findAll() {
		return this.em.createNamedQuery("Rarity.FINDALL", Rarity.class).getResultList();
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.RarityDao#findById(java.lang.Long)
	 */
	@Override
	public Rarity findById(Long inId) {
		return em.find(Rarity.class, inId);
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.RarityDao#findByAbbreviation(java.lang.String)
	 */
	@Override
	public Rarity findByAbbreviation(String inAbbreviation) {
		TypedQuery<Rarity> query = em.createNamedQuery("Rarity.FINDBYABBREVIATION", Rarity.class);
        query.setParameter("abbreviation", inAbbreviation);
        List<Rarity> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.RarityDao#update(be.lionelh.magic.listing.data.domain.entities.Rarity)
	 */
	@Override
	public Rarity update(Rarity inRarity) {
		em.merge(inRarity);
        em.flush();

        return em.find(Rarity.class, inRarity.getId());
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.RarityDao#delete(be.lionelh.magic.listing.data.domain.entities.Rarity)
	 */
	@Override
	public void delete(Rarity inRarity) {
		Rarity mo = em.merge(inRarity);
        em.remove(mo);
	}

}
