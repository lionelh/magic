package be.lionelh.magic.listing.data.domain.dao;

import java.util.List;

import be.lionelh.magic.listing.data.domain.entities.Block;

public interface BlockDao {

	Block create(Block inBlock);
    List<Block> findAll();
    Block findById(Long inId);
    Block findByName(String inName);
    Block findByNom(String inNom);
    Block update(Block inBlock);
    void delete(Block inBlock);
}
