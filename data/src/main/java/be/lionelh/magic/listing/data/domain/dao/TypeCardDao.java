package be.lionelh.magic.listing.data.domain.dao;

import java.util.List;

import be.lionelh.magic.listing.data.domain.entities.TypeCard;

public interface TypeCardDao {
	TypeCard create(TypeCard inTypeCard);
    List<TypeCard> findAll();
    TypeCard findById(Long inId);
    TypeCard findByName(String inName);
    TypeCard findByNom(String inNom);
    TypeCard update(TypeCard inTypeCard);
    void delete(TypeCard inTypeCard);
}
