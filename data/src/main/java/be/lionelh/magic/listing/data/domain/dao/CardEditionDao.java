package be.lionelh.magic.listing.data.domain.dao;

import java.util.List;

import be.lionelh.magic.listing.data.domain.entities.Card;
import be.lionelh.magic.listing.data.domain.entities.CardEdition;
import be.lionelh.magic.listing.data.domain.entities.CardEditionPK;

public interface CardEditionDao {

	CardEdition create(CardEdition inCardEdition);
    List<CardEdition> findAll();
    CardEdition findById(CardEditionPK inId);
    List<CardEdition> findByCard(Card inCard);
    CardEdition update(CardEdition inCardEdition);
    void delete(CardEdition inCardEdition);
}
