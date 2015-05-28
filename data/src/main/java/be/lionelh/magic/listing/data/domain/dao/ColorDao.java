package be.lionelh.magic.listing.data.domain.dao;

import java.util.List;

import be.lionelh.magic.listing.data.domain.entities.Color;

public interface ColorDao {

	Color create(Color inColor);
    List<Color> findAll();
    Color findById(Long inId);
    Color findByName(String inName);
    Color findByNom(String inNom);
    Color findByAbbreviation(String inAbbreviation);
    Color update(Color inColor);
    void delete(Color inColor);
}
