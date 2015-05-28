package be.lionelh.magic.listing.data.domain.dao;

import java.util.List;

import be.lionelh.magic.listing.data.domain.entities.Rarity;

public interface RarityDao {
	Rarity create(Rarity inRarity);
    List<Rarity> findAll();
    Rarity findById(Long inId);
    Rarity findByAbbreviation(String inAbbreviation);
    Rarity update(Rarity inRarity);
    void delete(Rarity inRarity);
}
