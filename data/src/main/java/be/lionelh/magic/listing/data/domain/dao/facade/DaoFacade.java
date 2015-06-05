package be.lionelh.magic.listing.data.domain.dao.facade;

import java.util.List;

import be.lionelh.magic.listing.data.domain.entities.Artist;
import be.lionelh.magic.listing.data.domain.entities.Block;
import be.lionelh.magic.listing.data.domain.entities.Capacity;
import be.lionelh.magic.listing.data.domain.entities.Card;
import be.lionelh.magic.listing.data.domain.entities.CardEdition;
import be.lionelh.magic.listing.data.domain.entities.Color;
import be.lionelh.magic.listing.data.domain.entities.Edition;
import be.lionelh.magic.listing.data.domain.entities.Family;
import be.lionelh.magic.listing.data.domain.entities.Rarity;
import be.lionelh.magic.listing.data.domain.entities.TypeCard;

/**
 * @author Lionel
 */
public interface DaoFacade {

	Artist createArtist(Artist inArtist);
    Artist updateArtist(Artist inArtist);
    List<Artist> findAllArtists();
    Artist findArtistById(Long inId);
    Artist findArtistByName(String inName);
    void removeArtist(Artist inArtist);

    Block createBlock(Block inBlock);
    Block updateBlock(Block inBlock);
    List<Block> findAllBlocks();
    Block findBlockById(Long inId);
    Block findBlockByName(String inName);
    Block findBlockByNom(String inNom);
    void removeBlock(Block inBlock);

    Capacity createCapacity(Capacity inCapacity);
    Capacity updateCapacity(Capacity inCapacity);
    List<Capacity> findAllCapacities();
    Capacity findCapacityById(Long inId);
    Capacity findCapacityByName(String inName);
    Capacity findCapacityByNom(String inNom);
    void removeCapacity(Capacity inCapacity);

    Card createCard(Card inCard);
    Card updateCard(Card inCard);
    List<Card> findAllCards();
    Card findCardById(Long inId);
    Card findCardByName(String inName);
    Card findCardByNom(String inNom);
    List<Card> findCardsByColor(Color inColor);
    List<Card> findCardsByTypeCard(TypeCard inTypeCard);
    List<Card> findCardsByFamily(Family inFamily);
    List<Card> findCardsByEdition(Edition inEdition);
    List<Card> findCardsByRarity(Rarity inRarity);
    List<Card> findCardsByCapacity(Capacity inCapacity);
    void removeCard(Card inCard);

    CardEdition createCardEdition(CardEdition inCardEdition);
    CardEdition updateCardEdition(CardEdition inCardEdition);
    void removeCardEdition(CardEdition inCardEdition);

    Color createColor(Color inColor);
    Color updateColor(Color inColor);
    List<Color> findAllColors();
    Color findColorById(Long inId);
    Color findColorByName(String inName);
    Color findColorByNom(String inNom);
    Color findColorByAbbreviation(String inAbbreviation);
    void removeColor(Color inColor);

    Edition createEdition(Edition inEdition);
    Edition updateEdition(Edition inEdition);
    List<Edition> findAllEditions();
    Edition findEditionById(Long inId);
    Edition findEditionByName(String inName);
    Edition findEditionByNom(String inNom);
    Edition findEditionByAbbreviation(String inAbbreviation);
    void removeEdition(Edition inEdition);

    Family createFamily(Family inFamily);
    Family updateFamily(Family inFamily);
    List<Family> findAllFamilies();
    Family findFamilyById(Long inId);
    Family findFamilyByName(String inName);
    Family findFamilyByNom(String inNom);
    void removeFamily(Family inFamily);

    Rarity createRarity(Rarity inRarity);
    Rarity updateRarity(Rarity inRarity);
    List<Rarity> findAllRarities();
    Rarity findRarityById(Long inId);
    Rarity findRarityByAbbreviation(String inAbbreviation);
    void removeRarity(Rarity inRarity);

    TypeCard createTypeCard(TypeCard inTypeCard);
    TypeCard updateTypeCard(TypeCard inTypeCard);
    List<TypeCard> findAllTypeCards();
    TypeCard findTypeCardById(Long inId);
    TypeCard findTypeCardByName(String inName);
    TypeCard findTypeCardByNom(String inNom);
    void removeTypeCard(TypeCard inTypeCard);
}
