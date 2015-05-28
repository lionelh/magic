package be.lionelh.magic.listing.data.domain.dao;

import java.util.List;

import be.lionelh.magic.listing.data.domain.entities.Family;

public interface FamilyDao {
	Family create(Family inFamily);
    List<Family> findAll();
    Family findById(Long inId);
    Family findByName(String inName);
    Family findByNom(String inNom);
    Family update(Family inFamily);
    void delete(Family inFamily);
}
