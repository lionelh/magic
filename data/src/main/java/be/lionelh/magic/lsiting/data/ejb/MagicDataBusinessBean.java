/*
 * Copyright (c) Smals
 */
package be.lionelh.magic.lsiting.data.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import be.lionelh.magic.listing.data.domain.dao.facade.DaoFacade;
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
import be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal;
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
import be.lionelh.magic.lsiting.data.ejb.utils.DTOConverter;


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
    
    @Inject
    private DTOConverter converter;

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createArtist(be.lionelh.magic.lsiting.data.ejb.client.dto.ArtistDTO)
     */
    @Override
    public ArtistDTO createArtist(ArtistDTO inArtist) {
        return this.converter.getArtistDTO(this.daoFacade.createArtist(converter.getArtist(inArtist))); 
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteArtist(be.lionelh.magic.lsiting.data.ejb.client.dto.ArtistDTO)
     */
    @Override
    public ArtistDTO updteArtist(ArtistDTO inArtist) {
    	return this.converter.getArtistDTO(this.daoFacade.updateArtist(converter.getArtist(inArtist)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllArtists()
     */
    @Override
    public List<ArtistDTO> findAllArtists() {
    	List<ArtistDTO> l = new ArrayList<ArtistDTO>();
    	for(Artist a : this.daoFacade.findAllArtists()) {
    		l.add(this.converter.getArtistDTO(a));
    	}
        return l;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findArtistById(java.lang.Long)
     */
    @Override
    public ArtistDTO findArtistById(Long inId) {
    	return this.converter.getArtistDTO(this.daoFacade.findArtistById(inId));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findArtistByName(java.lang.String)
     */
    @Override
    public ArtistDTO findArtistByName(String inName) {
    	return this.converter.getArtistDTO(this.daoFacade.findArtistByName(inName));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeArtist(be.lionelh.magic.lsiting.data.ejb.client.dto.ArtistDTO)
     */
    @Override
    public void removeArtist(ArtistDTO inArtist) {
    	this.daoFacade.removeArtist(this.converter.getArtist(inArtist));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createBlock(be.lionelh.magic.lsiting.data.ejb.client.dto.BlockDTO)
     */
    @Override
    public BlockDTO createBlock(BlockDTO inBlock) {
    	return this.converter.getBlockDTO(this.daoFacade.createBlock(converter.getBlock(inBlock)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteBlock(be.lionelh.magic.lsiting.data.ejb.client.dto.BlockDTO)
     */
    @Override
    public BlockDTO updteBlock(BlockDTO inBlock) {
    	return this.converter.getBlockDTO(this.daoFacade.updateBlock(converter.getBlock(inBlock)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllBlocks()
     */
    @Override
    public List<BlockDTO> findAllBlocks() {
    	List<BlockDTO> l = new ArrayList<BlockDTO>();
    	for(Block b : this.daoFacade.findAllBlocks()) {
    		l.add(this.converter.getBlockDTO(b));
    	}
        return l;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findBlockById(java.lang.Long)
     */
    @Override
    public BlockDTO findBlockById(Long inId) {
    	return this.converter.getBlockDTO(this.daoFacade.findBlockById(inId));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findBlockByName(java.lang.String)
     */
    @Override
    public BlockDTO findBlockByName(String inName) {
    	return this.converter.getBlockDTO(this.daoFacade.findBlockByName(inName));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findBlockByNom(java.lang.String)
     */
    @Override
    public BlockDTO findBlockByNom(String inNom) {
    	return this.converter.getBlockDTO(this.daoFacade.findBlockByNom(inNom));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeBlock(be.lionelh.magic.lsiting.data.ejb.client.dto.BlockDTO)
     */
    @Override
    public void removeBlock(BlockDTO inBlock) {
    	this.daoFacade.removeBlock(this.converter.getBlock(inBlock));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createCapacity(be.lionelh.magic.lsiting.data.ejb.client.dto.CapacityDTO)
     */
    @Override
    public CapacityDTO createCapacity(CapacityDTO inCapacity) {
    	return this.converter.getCapacityDTO(this.daoFacade.createCapacity(converter.getCapacity(inCapacity)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteCapacity(be.lionelh.magic.lsiting.data.ejb.client.dto.CapacityDTO)
     */
    @Override
    public CapacityDTO updteCapacity(CapacityDTO inCapacity) {
    	return this.converter.getCapacityDTO(this.daoFacade.updateCapacity(converter.getCapacity(inCapacity)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllCapacities()
     */
    @Override
    public List<CapacityDTO> findAllCapacities() {
    	List<CapacityDTO> l = new ArrayList<CapacityDTO>();
    	for(Capacity c : this.daoFacade.findAllCapacities()) {
    		l.add(this.converter.getCapacityDTO(c));
    	}
        return l;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCapacityById(java.lang.Long)
     */
    @Override
    public CapacityDTO findCapacityById(Long inId) {
    	return this.converter.getCapacityDTO(this.daoFacade.findCapacityById(inId));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCapacityByName(java.lang.String)
     */
    @Override
    public CapacityDTO findCapacityByName(String inName) {
    	return this.converter.getCapacityDTO(this.daoFacade.findCapacityByName(inName));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCapacityByNom(java.lang.String)
     */
    @Override
    public CapacityDTO findCapacityByNom(String inNom) {
    	return this.converter.getCapacityDTO(this.daoFacade.findCapacityByNom(inNom));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeCapacity(be.lionelh.magic.lsiting.data.ejb.client.dto.CapacityDTO)
     */
    @Override
    public void removeCapacity(CapacityDTO inCapacity) {
    	this.daoFacade.removeCapacity(this.converter.getCapacity(inCapacity));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createCard(be.lionelh.magic.lsiting.data.ejb.client.dto.CardDTO)
     */
    @Override
    public CardDTO createCard(CardDTO inCard) {
    	return this.converter.getCardDTO(this.daoFacade.createCard(converter.getCard(inCard)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteCard(be.lionelh.magic.lsiting.data.ejb.client.dto.CardDTO)
     */
    @Override
    public CardDTO updteCard(CardDTO inCard) {
    	return this.converter.getCardDTO(this.daoFacade.updateCard(converter.getCard(inCard)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllCards()
     */
    @Override
    public List<CardDTO> findAllCards() {
    	List<CardDTO> l = new ArrayList<CardDTO>();
    	for(Card c : this.daoFacade.findAllCards()) {
    		l.add(this.converter.getCardDTO(c));
    	}
        return l;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardById(java.lang.Long)
     */
    @Override
    public CardDTO findCardById(Long inId) {
    	return this.converter.getCardDTO(this.daoFacade.findCardById(inId));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardByName(java.lang.String)
     */
    @Override
    public CardDTO findCardByName(String inName) {
    	return this.converter.getCardDTO(this.daoFacade.findCardByName(inName));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardByNom(java.lang.String)
     */
    @Override
    public CardDTO findCardByNom(String inNom) {
    	return this.converter.getCardDTO(this.daoFacade.findCardByNom(inNom));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardsByColor(be.lionelh.magic.lsiting.data.ejb.client.dto.ColorDTO)
     */
    @Override
    public List<CardDTO> findCardsByColor(ColorDTO inColor) {
    	throw new RuntimeException("Not yet implemented !");
    	//List<ArtistDTO> l = new ArrayList<ArtistDTO>();
    	//for(Artist a : this.daoFacade.findAllArtists()) {
    	//	l.add(this.converter.getArtistDTO(a));
    	//}
        //return l;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardsByTypeCard(be.lionelh.magic.lsiting.data.ejb.client.dto.TypeCardDTO)
     */
    @Override
    public List<CardDTO> findCardsByTypeCard(TypeCardDTO inTypeCard) {
    	throw new RuntimeException("Not yet implemented !");
    	//List<ArtistDTO> l = new ArrayList<ArtistDTO>();
    	//for(Artist a : this.daoFacade.findAllArtists()) {
    	//	l.add(this.converter.getArtistDTO(a));
    	//}
        //return l;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardsByFamily(be.lionelh.magic.lsiting.data.ejb.client.dto.FamilyDTO)
     */
    @Override
    public List<CardDTO> findCardsByFamily(FamilyDTO inFamily) {
    	throw new RuntimeException("Not yet implemented !");
    	//List<ArtistDTO> l = new ArrayList<ArtistDTO>();
    	//for(Artist a : this.daoFacade.findAllArtists()) {
    	//	l.add(this.converter.getArtistDTO(a));
    	//}
        //return l;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardsByEdition(be.lionelh.magic.lsiting.data.ejb.client.dto.EditionDTO)
     */
    @Override
    public List<CardDTO> findCardsByEdition(EditionDTO inEdition) {
    	throw new RuntimeException("Not yet implemented !");
    	//List<ArtistDTO> l = new ArrayList<ArtistDTO>();
    	//for(Artist a : this.daoFacade.findAllArtists()) {
    	//	l.add(this.converter.getArtistDTO(a));
    	//}
        //return l;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardsByRarity(be.lionelh.magic.lsiting.data.ejb.client.dto.RarityDTO)
     */
    @Override
    public List<CardDTO> findCardsByRarity(RarityDTO inRarity) {
    	throw new RuntimeException("Not yet implemented !");
    	//List<ArtistDTO> l = new ArrayList<ArtistDTO>();
    	//for(Artist a : this.daoFacade.findAllArtists()) {
    	//	l.add(this.converter.getArtistDTO(a));
    	//}
        //return l;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findCardsByCapacity(be.lionelh.magic.lsiting.data.ejb.client.dto.CapacityDTO)
     */
    @Override
    public List<CardDTO> findCardsByCapacity(CapacityDTO inCapacity) {
    	throw new RuntimeException("Not yet implemented !");
    	//List<ArtistDTO> l = new ArrayList<ArtistDTO>();
    	//for(Artist a : this.daoFacade.findAllArtists()) {
    	//	l.add(this.converter.getArtistDTO(a));
    	//}
        //return l;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeCard(be.lionelh.magic.lsiting.data.ejb.client.dto.CardDTO)
     */
    @Override
    public void removeCard(CardDTO inCard) {
    	this.daoFacade.removeCard(this.converter.getCard(inCard));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#getCardDetils(be.lionelh.magic.lsiting.data.ejb.client.dto.CardDTO)
     */
    @Override
    public CardDetailsDTO getCardDetails(CardDTO inCard) {
    	List<CardEdition> ces = this.daoFacade.findCardEditionByCard(this.converter.getCard(inCard));
    	CardDetailsDTO cd = new CardDetailsDTO();
    	for(CardEdition ce : ces) {
    		// 1) Conversion of the CardEdition object
    		CardEditionDTO ceDto = this.converter.getCardEditionDTO(ce);
    		// 2) Conversion of Artists linked to the CardEdition
    		for(Artist art : ce.getArtists()) {
    			ceDto.getArtists().add(this.converter.getArtistDTO(art));
    		}
    		// 3) Conversion of Capacities linked to the CardEdition
    		for(Capacity c : ce.getCapacities()) {
    			ceDto.getCapacities().add(this.converter.getCapacityDTO(c));
    		}
    		// 4) Conversion of the Block linked to the Edtion of this CardEdition
    		ceDto.getEdition().setBlock(this.converter.getBlockDTO(ce.getEdition().getBlock()));
    		// 5) Conversion of the Famailies linked to the Card of this CardEdition
    		for(Family f : ce.getCard().getFamilies()) {
    			ceDto.getCard().getFamilies().add(this.converter.getFamilyDTO(f));
    		}
    		// 6) Add the CardEditionDTO object to the List in CardDetailsDto object
    		cd.getCardEditions().add(ceDto);

    	}
    	return cd;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createCardEdition(be.lionelh.magic.lsiting.data.ejb.client.dto.CardEditionDTO)
     */
    @Override
    public CardEditionDTO createCardEdition(CardEditionDTO inCardEdition) {
    	return this.converter.getCardEditionDTO(this.daoFacade.createCardEdition(converter.getCardEdition(inCardEdition)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteCardEdition(be.lionelh.magic.lsiting.data.ejb.client.dto.CardEditionDTO)
     */
    @Override
    public CardEditionDTO updteCardEdition(CardEditionDTO inCardEdition) {
    	return this.converter.getCardEditionDTO(this.daoFacade.updateCardEdition(converter.getCardEdition(inCardEdition)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeCardEdition(be.lionelh.magic.lsiting.data.ejb.client.dto.CardEditionDTO)
     */
    @Override
    public void removeCardEdition(CardEditionDTO inCardEdition) {
    	this.daoFacade.removeCardEdition(this.converter.getCardEdition(inCardEdition));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createColor(be.lionelh.magic.lsiting.data.ejb.client.dto.ColorDTO)
     */
    @Override
    public ColorDTO createColor(ColorDTO inColor) {
    	return this.converter.getColorDTO(this.daoFacade.createColor(converter.getColor(inColor)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteColor(be.lionelh.magic.lsiting.data.ejb.client.dto.ColorDTO)
     */
    @Override
    public ColorDTO updteColor(ColorDTO inColor) {
    	return this.converter.getColorDTO(this.daoFacade.updateColor(converter.getColor(inColor)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllColors()
     */
    @Override
    public List<ColorDTO> findAllColors() {
    	List<ColorDTO> l = new ArrayList<ColorDTO>();
    	for(Color c : this.daoFacade.findAllColors()) {
    		l.add(this.converter.getColorDTO(c));
    	}
        return l;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findColorById(java.lang.Long)
     */
    @Override
    public ColorDTO findColorById(Long inId) {
    	return this.converter.getColorDTO(this.daoFacade.findColorById(inId));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findColorByName(java.lang.String)
     */
    @Override
    public ColorDTO findColorByName(String inName) {
    	return this.converter.getColorDTO(this.daoFacade.findColorByName(inName));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findColorByNom(java.lang.String)
     */
    @Override
    public ColorDTO findColorByNom(String inNom) {
    	return this.converter.getColorDTO(this.daoFacade.findColorByNom(inNom));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findColorByAbbreviation(java.lang.String)
     */
    @Override
    public ColorDTO findColorByAbbreviation(String inAbbreviation) {
    	return this.converter.getColorDTO(this.daoFacade.findColorByAbbreviation(inAbbreviation));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeColor(be.lionelh.magic.lsiting.data.ejb.client.dto.ColorDTO)
     */
    @Override
    public void removeColor(ColorDTO inColor) {
    	this.daoFacade.removeColor(this.converter.getColor(inColor));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createEdition(be.lionelh.magic.lsiting.data.ejb.client.dto.EditionDTO)
     */
    @Override
    public EditionDTO createEdition(EditionDTO inEdition) {
    	return this.converter.getEditionDTO(this.daoFacade.createEdition(converter.getEdition(inEdition)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteEdition(be.lionelh.magic.lsiting.data.ejb.client.dto.EditionDTO)
     */
    @Override
    public EditionDTO updteEdition(EditionDTO inEdition) {
    	return this.converter.getEditionDTO(this.daoFacade.updateEdition(converter.getEdition(inEdition)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllEditions()
     */
    @Override
    public List<EditionDTO> findAllEditions() {
    	List<EditionDTO> l = new ArrayList<EditionDTO>();
    	for(Edition e : this.daoFacade.findAllEditions()) {
    		l.add(this.converter.getEditionDTO(e));
    	}
        return l;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findEditionById(java.lang.Long)
     */
    @Override
    public EditionDTO findEditionById(Long inId) {
    	return this.converter.getEditionDTO(this.daoFacade.findEditionById(inId));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findEditionByName(java.lang.String)
     */
    @Override
    public EditionDTO findEditionByName(String inName) {
    	return this.converter.getEditionDTO(this.daoFacade.findEditionByName(inName));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findEditionByNom(java.lang.String)
     */
    @Override
    public EditionDTO findEditionByNom(String inNom) {
    	return this.converter.getEditionDTO(this.daoFacade.findEditionByNom(inNom));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findEditionByAbbreviation(java.lang.String)
     */
    @Override
    public EditionDTO findEditionByAbbreviation(String inAbbreviation) {
    	return this.converter.getEditionDTO(this.daoFacade.findEditionByAbbreviation(inAbbreviation));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeEdition(be.lionelh.magic.lsiting.data.ejb.client.dto.EditionDTO)
     */
    @Override
    public void removeEdition(EditionDTO inEdition) {
    	this.daoFacade.removeEdition(this.converter.getEdition(inEdition));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createFamily(be.lionelh.magic.lsiting.data.ejb.client.dto.FamilyDTO)
     */
    @Override
    public FamilyDTO createFamily(FamilyDTO inFamily) {
    	return this.converter.getFamilyDTO(this.daoFacade.createFamily(converter.getFamily(inFamily)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteFamily(be.lionelh.magic.lsiting.data.ejb.client.dto.FamilyDTO)
     */
    @Override
    public FamilyDTO updteFamily(FamilyDTO inFamily) {
    	return this.converter.getFamilyDTO(this.daoFacade.updateFamily(converter.getFamily(inFamily)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllFamilies()
     */
    @Override
    public List<FamilyDTO> findAllFamilies() {
    	List<FamilyDTO> l = new ArrayList<FamilyDTO>();
    	for(Family f : this.daoFacade.findAllFamilies()) {
    		l.add(this.converter.getFamilyDTO(f));
    	}
        return l;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findFamilyById(java.lang.Long)
     */
    @Override
    public FamilyDTO findFamilyById(Long inId) {
    	return this.converter.getFamilyDTO(this.daoFacade.findFamilyById(inId));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findFamilyByName(java.lang.String)
     */
    @Override
    public FamilyDTO findFamilyByName(String inName) {
    	return this.converter.getFamilyDTO(this.daoFacade.findFamilyByName(inName));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findFamilyByNom(java.lang.String)
     */
    @Override
    public FamilyDTO findFamilyByNom(String inNom) {
    	return this.converter.getFamilyDTO(this.daoFacade.findFamilyByNom(inNom));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeFamily(be.lionelh.magic.lsiting.data.ejb.client.dto.FamilyDTO)
     */
    @Override
    public void removeFamily(FamilyDTO inFamily) {
    	this.daoFacade.removeFamily(this.converter.getFamily(inFamily));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createRarity(be.lionelh.magic.lsiting.data.ejb.client.dto.RarityDTO)
     */
    @Override
    public RarityDTO createRarity(RarityDTO inRarity) {
    	return this.converter.getRarityDTO(this.daoFacade.createRarity(converter.getRarity(inRarity)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteRarity(be.lionelh.magic.lsiting.data.ejb.client.dto.RarityDTO)
     */
    @Override
    public RarityDTO updteRarity(RarityDTO inRarity) {
    	return this.converter.getRarityDTO(this.daoFacade.updateRarity(converter.getRarity(inRarity)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllRarities()
     */
    @Override
    public List<RarityDTO> findAllRarities() {
    	List<RarityDTO> l = new ArrayList<RarityDTO>();
    	for(Rarity r : this.daoFacade.findAllRarities()) {
    		l.add(this.converter.getRarityDTO(r));
    	}
        return l;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findRarityById(java.lang.Long)
     */
    @Override
    public RarityDTO findRarityById(Long inId) {
    	return this.converter.getRarityDTO(this.daoFacade.findRarityById(inId));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findRarityByAbbreviation(java.lang.String)
     */
    @Override
    public RarityDTO findRarityByAbbreviation(String inAbbreviation) {
    	return this.converter.getRarityDTO(this.daoFacade.findRarityByAbbreviation(inAbbreviation));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeRarity(be.lionelh.magic.lsiting.data.ejb.client.dto.RarityDTO)
     */
    @Override
    public void removeRarity(RarityDTO inRarity) {
    	this.daoFacade.removeRarity(this.converter.getRarity(inRarity));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#createTypeCard(be.lionelh.magic.lsiting.data.ejb.client.dto.TypeCardDTO)
     */
    @Override
    public TypeCardDTO createTypeCard(TypeCardDTO inTypeCard) {
    	return this.converter.getTypeCardDTO(this.daoFacade.createTypeCard(converter.getTypeCard(inTypeCard)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#updteTypeCard(be.lionelh.magic.lsiting.data.ejb.client.dto.TypeCardDTO)
     */
    @Override
    public TypeCardDTO updteTypeCard(TypeCardDTO inTypeCard) {
    	return this.converter.getTypeCardDTO(this.daoFacade.updateTypeCard(converter.getTypeCard(inTypeCard)));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findAllTypeCards()
     */
    @Override
    public List<TypeCardDTO> findAllTypeCards() {
    	List<TypeCardDTO> l = new ArrayList<TypeCardDTO>();
    	for(TypeCard tc : this.daoFacade.findAllTypeCards()) {
    		l.add(this.converter.getTypeCardDTO(tc));
    	}
        return l;
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findTypeCardById(java.lang.Long)
     */
    @Override
    public TypeCardDTO findTypeCardById(Long inId) {
    	return this.converter.getTypeCardDTO(this.daoFacade.findTypeCardById(inId));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findTypeCardByName(java.lang.String)
     */
    @Override
    public TypeCardDTO findTypeCardByName(String inName) {
    	return this.converter.getTypeCardDTO(this.daoFacade.findTypeCardByName(inName));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#findTypeCardByNom(java.lang.String)
     */
    @Override
    public TypeCardDTO findTypeCardByNom(String inNom) {
    	return this.converter.getTypeCardDTO(this.daoFacade.findTypeCardByNom(inNom));
    }

    /**
     * @see be.lionelh.magic.lsiting.data.ejb.client.MagicDataBusinessLocal#removeTypeCard(be.lionelh.magic.lsiting.data.ejb.client.dto.TypeCardDTO)
     */
    @Override
    public void removeTypeCard(TypeCardDTO inTypeCard) {
    	this.daoFacade.removeTypeCard(this.converter.getTypeCard(inTypeCard));
    }

}
