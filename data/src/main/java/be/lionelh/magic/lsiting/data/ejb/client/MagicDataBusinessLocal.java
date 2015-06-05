/*
 * Copyright (c) Smals
 */
package be.lionelh.magic.lsiting.data.ejb.client;

import java.util.List;

import be.lionelh.magic.lsiting.data.ejb.client.dto.ArtistDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.BlockDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.CapacityDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.CardDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.CardDetailsDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.CardEditionDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.ColorDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.EditionDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.FamilyDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.RarityDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.TypeCardDTO;


/**
 * @author lh
 */
public interface MagicDataBusinessLocal {

    ArtistDTO createArtist(ArtistDTO inArtist);
    ArtistDTO updteArtist(ArtistDTO inArtist);
    List<ArtistDTO> findAllArtists();
    ArtistDTO findArtistById(Long inId);
    ArtistDTO findArtistByName(String inName);
    void removeArtist(ArtistDTO inArtist);

    BlockDTO createBlock(BlockDTO inBlock);
    BlockDTO updteBlock(BlockDTO inBlock);
    List<BlockDTO> findAllBlocks();
    BlockDTO findBlockById(Long inId);
    BlockDTO findBlockByName(String inName);
    BlockDTO findBlockByNom(String inNom);
    void removeBlock(BlockDTO inBlock);

    CapacityDTO createCapacity(CapacityDTO inCapacity);
    CapacityDTO updteCapacity(CapacityDTO inCapacity);
    List<CapacityDTO> findAllCapacities();
    CapacityDTO findCapacityById(Long inId);
    CapacityDTO findCapacityByName(String inName);
    CapacityDTO findCapacityByNom(String inNom);
    void removeCapacity(CapacityDTO inCapacity);

    CardDTO createCard(CardDTO inCard);
    CardDTO updteCard(CardDTO inCard);
    List<CardDTO> findAllCards();
    CardDTO findCardById(Long inId);
    CardDTO findCardByName(String inName);
    CardDTO findCardByNom(String inNom);
    List<CardDTO> findCardsByColor(ColorDTO inColor);
    List<CardDTO> findCardsByTypeCard(TypeCardDTO inTypeCard);
    List<CardDTO> findCardsByFamily(FamilyDTO inFamily);
    List<CardDTO> findCardsByEdition(EditionDTO inEdition);
    List<CardDTO> findCardsByRarity(RarityDTO inRarity);
    List<CardDTO> findCardsByCapacity(CapacityDTO inCapacity);
    void removeCard(CardDTO inCard);

    CardDetailsDTO getCardDetails(CardDTO inCard);

    CardEditionDTO createCardEdition(CardEditionDTO inCardEdition);
    CardEditionDTO updteCardEdition(CardEditionDTO inCardEdition);
    void removeCardEdition(CardEditionDTO inCardEdition);

    ColorDTO createColor(ColorDTO inColor);
    ColorDTO updteColor(ColorDTO inColor);
    List<ColorDTO> findAllColors();
    ColorDTO findColorById(Long inId);
    ColorDTO findColorByName(String inName);
    ColorDTO findColorByNom(String inNom);
    ColorDTO findColorByAbbreviation(String inAbbreviation);
    void removeColor(ColorDTO inColor);

    EditionDTO createEdition(EditionDTO inEdition);
    EditionDTO updteEdition(EditionDTO inEdition);
    List<EditionDTO> findAllEditions();
    EditionDTO findEditionById(Long inId);
    EditionDTO findEditionByName(String inName);
    EditionDTO findEditionByNom(String inNom);
    EditionDTO findEditionByAbbreviation(String inAbbreviation);
    void removeEdition(EditionDTO inEdition);

    FamilyDTO createFamily(FamilyDTO inFamily);
    FamilyDTO updteFamily(FamilyDTO inFamily);
    List<FamilyDTO> findAllFamilies();
    FamilyDTO findFamilyById(Long inId);
    FamilyDTO findFamilyByName(String inName);
    FamilyDTO findFamilyByNom(String inNom);
    void removeFamily(FamilyDTO inFamily);

    RarityDTO createRarity(RarityDTO inRarity);
    RarityDTO updteRarity(RarityDTO inRarity);
    List<RarityDTO> findAllRarities();
    RarityDTO findRarityById(Long inId);
    RarityDTO findRarityByAbbreviation(String inAbbreviation);
    void removeRarity(RarityDTO inRarity);

    TypeCardDTO createTypeCard(TypeCardDTO inTypeCard);
    TypeCardDTO updteTypeCard(TypeCardDTO inTypeCard);
    List<TypeCardDTO> findAllTypeCards();
    TypeCardDTO findTypeCardById(Long inId);
    TypeCardDTO findTypeCardByName(String inName);
    TypeCardDTO findTypeCardByNom(String inNom);
    void removeTypeCard(TypeCardDTO inTypeCard);
}
