package be.lionelh.magic.listing.data.domain.dao;

import java.util.List;

import be.lionelh.magic.listing.data.domain.entities.Card;

/**
 * @author Lionel
 */
public interface CardDao {

    Card create(Card inCard);
    List<Card> findAll();
    Card findById(Long inId);
    Card findByName(String inName);
    Card findByNom(String inNom);
    Card update(Card inCard);
    void delete(Card inCard);
}
