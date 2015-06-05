/*
 * Copyright (c) Smals
 */
package be.lionelh.magic.lsiting.data.ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import be.lionelh.magic.listing.data.domain.dao.DaoFacade;
import be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal;
import be.lionelh.magic.lsiting.data.ejb.client.dto.ArtistDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.BlockDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.CapacityDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.CardDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.CardEditionDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.ColorDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.EditionDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.FamilyDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.RarityDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.TypeCardDTO;


/**
 * @author lh
 */
@SuppressWarnings("serial")
@Stateless(name = "FMSBusinessEJB", description = "EJB Wrapper for MAgic Listing application")
@Local(MagicDataBusinessLocal.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class MagicDataBusinessBean implements MagicDataBusinessLocal, Serializable {

    @Inject
    private DaoFacade daoFacade;

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createArtist(be.lionelh.magic.lsiting.data.ejb.client.dto.ArtistDTO)
     */
    @Override
    public ArtistDTO createArtist(ArtistDTO inArtist) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteArtist(be.lionelh.magic.lsiting.data.ejb.client.dto.ArtistDTO)
     */
    @Override
    public ArtistDTO updteArtist(ArtistDTO inArtist) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllArtists()
     */
    @Override
    public List<ArtistDTO> findAllArtists() {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findArtistById(java.lang.Long)
     */
    @Override
    public ArtistDTO findArtistById(Long inId) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findArtistByName(java.lang.String)
     */
    @Override
    public ArtistDTO findArtistByName(String inName) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeArtist(be.lionelh.magic.lsiting.data.ejb.client.dto.ArtistDTO)
     */
    @Override
    public void removeArtist(ArtistDTO inArtist) {
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createBlock(be.lionelh.magic.lsiting.data.ejb.client.dto.BlockDTO)
     */
    @Override
    public BlockDTO createBlock(BlockDTO inBlock) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteBlock(be.lionelh.magic.lsiting.data.ejb.client.dto.BlockDTO)
     */
    @Override
    public BlockDTO updteBlock(BlockDTO inBlock) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllBlocks()
     */
    @Override
    public List<BlockDTO> findAllBlocks() {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findBlockById(java.lang.Long)
     */
    @Override
    public BlockDTO findBlockById(Long inId) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findBlockByName(java.lang.String)
     */
    @Override
    public BlockDTO findBlockByName(String inName) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findBlockByNom(java.lang.String)
     */
    @Override
    public BlockDTO findBlockByNom(String inNom) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeBlock(be.lionelh.magic.lsiting.data.ejb.client.dto.BlockDTO)
     */
    @Override
    public void removeBlock(BlockDTO inBlock) {

    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createCapacity(be.lionelh.magic.lsiting.data.ejb.client.dto.CapacityDTO)
     */
    @Override
    public CapacityDTO createCapacity(CapacityDTO inCapacity) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteCapacity(be.lionelh.magic.lsiting.data.ejb.client.dto.CapacityDTO)
     */
    @Override
    public CapacityDTO updteCapacity(CapacityDTO inCapacity) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllCapacities()
     */
    @Override
    public List<CapacityDTO> findAllCapacities() {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCapacityById(java.lang.Long)
     */
    @Override
    public CapacityDTO findCapacityById(Long inId) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCapacityByName(java.lang.String)
     */
    @Override
    public CapacityDTO findCapacityByName(String inName) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCapacityByNom(java.lang.String)
     */
    @Override
    public CapacityDTO findCapacityByNom(String inNom) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeCapacity(be.lionelh.magic.lsiting.data.ejb.client.dto.CapacityDTO)
     */
    @Override
    public void removeCapacity(CapacityDTO inCapacity) {

    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createCard(be.lionelh.magic.lsiting.data.ejb.client.dto.CardDTO)
     */
    @Override
    public CardDTO createCard(CardDTO inCard) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteCard(be.lionelh.magic.lsiting.data.ejb.client.dto.CardDTO)
     */
    @Override
    public CardDTO updteCard(CardDTO inCard) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllCards()
     */
    @Override
    public List<CardDTO> findAllCards() {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardById(java.lang.Long)
     */
    @Override
    public CardDTO findCardById(Long inId) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardByName(java.lang.String)
     */
    @Override
    public CardDTO findCardByName(String inName) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardByNom(java.lang.String)
     */
    @Override
    public CardDTO findCardByNom(String inNom) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardsByColor(be.lionelh.magic.lsiting.data.ejb.client.dto.ColorDTO)
     */
    @Override
    public List<CardDTO> findCardsByColor(ColorDTO inColor) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardsByTypeCard(be.lionelh.magic.lsiting.data.ejb.client.dto.TypeCardDTO)
     */
    @Override
    public List<CardDTO> findCardsByTypeCard(TypeCardDTO inTypeCard) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardsByFamily(be.lionelh.magic.lsiting.data.ejb.client.dto.FamilyDTO)
     */
    @Override
    public List<CardDTO> findCardsByFamily(FamilyDTO inFamily) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardsByEdition(be.lionelh.magic.lsiting.data.ejb.client.dto.EditionDTO)
     */
    @Override
    public List<CardDTO> findCardsByEdition(EditionDTO inEdition) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardsByRarity(be.lionelh.magic.lsiting.data.ejb.client.dto.RarityDTO)
     */
    @Override
    public List<CardDTO> findCardsByRarity(RarityDTO inRarity) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardsByCapacity(be.lionelh.magic.lsiting.data.ejb.client.dto.CapacityDTO)
     */
    @Override
    public List<CardDTO> findCardsByCapacity(CapacityDTO inCapacity) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeCard(be.lionelh.magic.lsiting.data.ejb.client.dto.CardDTO)
     */
    @Override
    public void removeCard(CardDTO inCard) {

    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createCardEdition(be.lionelh.magic.lsiting.data.ejb.client.dto.CardEditionDTO)
     */
    @Override
    public CardEditionDTO createCardEdition(CardEditionDTO inCardEdition) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteCardEdition(be.lionelh.magic.lsiting.data.ejb.client.dto.CardEditionDTO)
     */
    @Override
    public CardEditionDTO updteCardEdition(CardEditionDTO inCardEdition) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeCardEdition(be.lionelh.magic.lsiting.data.ejb.client.dto.CardEditionDTO)
     */
    @Override
    public void removeCardEdition(CardEditionDTO inCardEdition) {

    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createColor(be.lionelh.magic.lsiting.data.ejb.client.dto.ColorDTO)
     */
    @Override
    public ColorDTO createColor(ColorDTO inColor) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteColor(be.lionelh.magic.lsiting.data.ejb.client.dto.ColorDTO)
     */
    @Override
    public ColorDTO updteColor(ColorDTO inColor) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllColors()
     */
    @Override
    public List<ColorDTO> findAllColors() {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findColorById(java.lang.Long)
     */
    @Override
    public ColorDTO findColorById(Long inId) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findColorByName(java.lang.String)
     */
    @Override
    public ColorDTO findColorByName(String inName) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findColorByNom(java.lang.String)
     */
    @Override
    public ColorDTO findColorByNom(String inNom) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findColorByAbbreviation(java.lang.String)
     */
    @Override
    public ColorDTO findColorByAbbreviation(String inAbbreviation) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeColor(be.lionelh.magic.lsiting.data.ejb.client.dto.ColorDTO)
     */
    @Override
    public void removeColor(ColorDTO inColor) {

    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createEdition(be.lionelh.magic.lsiting.data.ejb.client.dto.EditionDTO)
     */
    @Override
    public EditionDTO createEdition(EditionDTO inEdition) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteEdition(be.lionelh.magic.lsiting.data.ejb.client.dto.EditionDTO)
     */
    @Override
    public EditionDTO updteEdition(EditionDTO inEdition) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllEditions()
     */
    @Override
    public List<EditionDTO> findAllEditions() {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findEditionById(java.lang.Long)
     */
    @Override
    public EditionDTO findEditionById(Long inId) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findEditionByName(java.lang.String)
     */
    @Override
    public EditionDTO findEditionByName(String inName) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findEditionByNom(java.lang.String)
     */
    @Override
    public EditionDTO findEditionByNom(String inNom) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findEditionByAbbreviation(java.lang.String)
     */
    @Override
    public EditionDTO findEditionByAbbreviation(String inAbbreviation) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeEdition(be.lionelh.magic.lsiting.data.ejb.client.dto.EditionDTO)
     */
    @Override
    public void removeEdition(EditionDTO inEdition) {

    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createFamily(be.lionelh.magic.lsiting.data.ejb.client.dto.FamilyDTO)
     */
    @Override
    public FamilyDTO createFamily(FamilyDTO inFamily) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteFamily(be.lionelh.magic.lsiting.data.ejb.client.dto.FamilyDTO)
     */
    @Override
    public FamilyDTO updteFamily(FamilyDTO inFamily) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllFamilies()
     */
    @Override
    public List<FamilyDTO> findAllFamilies() {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findFamilyById(java.lang.Long)
     */
    @Override
    public FamilyDTO findFamilyById(Long inId) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findFamilyByName(java.lang.String)
     */
    @Override
    public FamilyDTO findFamilyByName(String inName) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findFamilyByNom(java.lang.String)
     */
    @Override
    public FamilyDTO findFamilyByNom(String inNom) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeFamily(be.lionelh.magic.lsiting.data.ejb.client.dto.FamilyDTO)
     */
    @Override
    public void removeFamily(FamilyDTO inFamily) {

    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createRarity(be.lionelh.magic.lsiting.data.ejb.client.dto.RarityDTO)
     */
    @Override
    public RarityDTO createRarity(RarityDTO inRarity) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteRarity(be.lionelh.magic.lsiting.data.ejb.client.dto.RarityDTO)
     */
    @Override
    public RarityDTO updteRarity(RarityDTO inRarity) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllRarities()
     */
    @Override
    public List<RarityDTO> findAllRarities() {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findRarityById(java.lang.Long)
     */
    @Override
    public RarityDTO findRarityById(Long inId) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findRarityByAbbreviation(java.lang.String)
     */
    @Override
    public RarityDTO findRarityByAbbreviation(String inAbbreviation) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeRarity(be.lionelh.magic.lsiting.data.ejb.client.dto.RarityDTO)
     */
    @Override
    public void removeRarity(RarityDTO inRarity) {

    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createTypeCard(be.lionelh.magic.lsiting.data.ejb.client.dto.TypeCardDTO)
     */
    @Override
    public TypeCardDTO createTypeCard(TypeCardDTO inTypeCard) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteTypeCard(be.lionelh.magic.lsiting.data.ejb.client.dto.TypeCardDTO)
     */
    @Override
    public TypeCardDTO updteTypeCard(TypeCardDTO inTypeCard) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllTypeCards()
     */
    @Override
    public List<TypeCardDTO> findAllTypeCards() {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findTypeCardById(java.lang.Long)
     */
    @Override
    public TypeCardDTO findTypeCardById(Long inId) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findTypeCardByName(java.lang.String)
     */
    @Override
    public TypeCardDTO findTypeCardByName(String inName) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findTypeCardByNom(java.lang.String)
     */
    @Override
    public TypeCardDTO findTypeCardByNom(String inNom) {
        return null;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeTypeCard(be.lionelh.magic.lsiting.data.ejb.client.dto.TypeCardDTO)
     */
    @Override
    public void removeTypeCard(TypeCardDTO inTypeCard) {

    }

}
