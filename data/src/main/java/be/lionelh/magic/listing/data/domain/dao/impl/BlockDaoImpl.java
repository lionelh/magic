package be.lionelh.magic.listing.data.domain.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.lionelh.magic.listing.data.domain.dao.BlockDao;
import be.lionelh.magic.listing.data.domain.entities.Block;

/**
 * @author lh
 *
 */
@Named("blockDao")
public class BlockDaoImpl implements BlockDao {

	@PersistenceContext
    private EntityManager em;

	/**
	 * @see be.lionelh.magic.data.domain.dao.BlockDao#create(be.lionelh.magic.listing.data.domain.entities.Block)
	 */
	@Override
	public Block create(Block inBlock) {
		em.persist(inBlock);
		em.flush();
		return inBlock;
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.BlockDao#findAll()
	 */
	@Override
	public List<Block> findAll() {
		return this.em.createNamedQuery("Block.FINDALL", Block.class).getResultList();
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.BlockDao#findById(java.lang.Long)
	 */
	@Override
	public Block findById(Long inId) {
		return em.find(Block.class, inId);
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.BlockDao#findByName(java.lang.String)
	 */
	@Override
	public Block findByName(String inName) {
		TypedQuery<Block> query = em.createNamedQuery("Block.FINDBYNAME", Block.class);
        query.setParameter("name", inName);
        List<Block> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.BlockDao#findByNom(java.lang.String)
	 */
	@Override
	public Block findByNom(String inNom) {
		TypedQuery<Block> query = em.createNamedQuery("Block.FINDBYNOM", Block.class);
        query.setParameter("nom", inNom);
        List<Block> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.BlockDao#update(be.lionelh.magic.listing.data.domain.entities.Block)
	 */
	@Override
	public Block update(Block inBlock) {
		em.merge(inBlock);
        em.flush();

        return em.find(Block.class, inBlock.getId());
	}

	/**
	 * @see be.lionelh.magic.data.domain.dao.BlockDao#delete(be.lionelh.magic.listing.data.domain.entities.Block)
	 */
	@Override
	public void delete(Block inBlock) {
		Block mo = em.merge(inBlock);
        em.remove(mo);
	}
}
