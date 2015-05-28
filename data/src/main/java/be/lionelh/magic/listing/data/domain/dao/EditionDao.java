package be.lionelh.magic.listing.data.domain.dao;

import java.util.List;

import be.lionelh.magic.listing.data.domain.entities.Edition;

public interface EditionDao {

	Edition create(Edition inEdition);
    List<Edition> findAll();
    Edition findById(Long inId);
    Edition findByName(String inName);
    Edition findByNom(String inNom);
    Edition findByAbbreviation(String inAbbreviation);
    Edition update(Edition inEdition);
    void delete(Edition inEdition);
}
