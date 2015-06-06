package be.lionelh.magic.listing.data.domain.dao.facade.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import be.lionelh.magic.listing.data.domain.dao.ArtistDao;
import be.lionelh.magic.listing.data.domain.dao.BlockDao;
import be.lionelh.magic.listing.data.domain.dao.CapacityDao;
import be.lionelh.magic.listing.data.domain.dao.CardDao;
import be.lionelh.magic.listing.data.domain.dao.CardEditionDao;
import be.lionelh.magic.listing.data.domain.dao.ColorDao;
import be.lionelh.magic.listing.data.domain.dao.EditionDao;
import be.lionelh.magic.listing.data.domain.dao.FamilyDao;
import be.lionelh.magic.listing.data.domain.dao.RarityDao;
import be.lionelh.magic.listing.data.domain.dao.TypeCardDao;
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

/**
 * @author Lionel
 */
@Named("daoFacade")
public class DaoFacadeImpl implements DaoFacade {

    @Inject
    private ArtistDao artistDao;

    @Inject
    private BlockDao blockDao;

    @Inject
    private CapacityDao capacityDao;

    @Inject
    private CardDao cardDao;

    @Inject
    private CardEditionDao cardEditionDao;

    @Inject
    private ColorDao colorDao;

    @Inject
    private EditionDao editionDao;

    @Inject
    private FamilyDao familyDao;

    @Inject
    private RarityDao rarityDao;

    @Inject
    private TypeCardDao typeCardDao;

    public DaoFacadeImpl() { }

	@Override
	public Artist createArtist(Artist inArtist) {
		return this.artistDao.create(inArtist);
	}

	@Override
	public Artist updateArtist(Artist inArtist) {
		return this.artistDao.update(inArtist);
	}

	@Override
	public List<Artist> findAllArtists() {
		return this.artistDao.findAll();
	}

	@Override
	public Artist findArtistById(Long inId) {
		return this.artistDao.findById(inId);
	}

	@Override
	public Artist findArtistByName(String inName) {
		return this.artistDao.findByName(inName);
	}

	@Override
	public void removeArtist(Artist inArtist) {
		this.artistDao.delete(inArtist);
	}

	@Override
	public Block createBlock(Block inBlock) {
		return this.blockDao.create(inBlock);
	}

	@Override
	public Block updateBlock(Block inBlock) {
		return this.blockDao.update(inBlock);
	}

	@Override
	public List<Block> findAllBlocks() {
		return this.blockDao.findAll();
	}

	@Override
	public Block findBlockById(Long inId) {
		return this.blockDao.findById(inId);
	}

	@Override
	public Block findBlockByName(String inName) {
		return this.blockDao.findByName(inName);
	}

	@Override
	public Block findBlockByNom(String inNom) {
		return this.blockDao.findByNom(inNom);
	}

	@Override
	public void removeBlock(Block inBlock) {
		this.blockDao.delete(inBlock);
	}

	@Override
	public Capacity createCapacity(Capacity inCapacity) {
		return this.capacityDao.create(inCapacity);
	}

	@Override
	public Capacity updateCapacity(Capacity inCapacity) {
		return this.capacityDao.update(inCapacity);
	}

	@Override
	public List<Capacity> findAllCapacities() {
		return this.capacityDao.findAll();
	}

	@Override
	public Capacity findCapacityById(Long inId) {
		return this.capacityDao.findById(inId);
	}

	@Override
	public Capacity findCapacityByName(String inName) {
		return this.capacityDao.findByName(inName);
	}

	@Override
	public Capacity findCapacityByNom(String inNom) {
		return this.capacityDao.findByNom(inNom);
	}

	@Override
	public void removeCapacity(Capacity inCapacity) {
		this.capacityDao.delete(inCapacity);
	}

	@Override
	public Card createCard(Card inCard) {
		return this.cardDao.create(inCard);
	}

	@Override
	public Card updateCard(Card inCard) {
		return this.cardDao.update(inCard);
	}

	@Override
	public List<Card> findAllCards() {
		return this.cardDao.findAll();
	}

	@Override
	public Card findCardById(Long inId) {
		return this.cardDao.findById(inId);
	}

	@Override
	public Card findCardByName(String inName) {
		return this.cardDao.findByName(inName);
	}

	@Override
	public Card findCardByNom(String inNom) {
		return this.cardDao.findByNom(inNom);
	}

	@Override
	public List<Card> findCardsByColor(Color inColor) {
		throw new RuntimeException("Not yet implemented !");
	}

	@Override
	public List<Card> findCardsByTypeCard(TypeCard inTypeCard) {
		throw new RuntimeException("Not yet implemented !");
	}

	@Override
	public List<Card> findCardsByFamily(Family inFamily) {
		throw new RuntimeException("Not yet implemented !");
	}

	@Override
	public List<Card> findCardsByEdition(Edition inEdition) {
		throw new RuntimeException("Not yet implemented !");
	}

	@Override
	public List<Card> findCardsByRarity(Rarity inRarity) {
		throw new RuntimeException("Not yet implemented !");
	}

	@Override
	public List<Card> findCardsByCapacity(Capacity inCapacity) {
		throw new RuntimeException("Not yet implemented !");
	}

	@Override
	public void removeCard(Card inCard) {
		this.cardDao.delete(inCard);
	}

	@Override
	public CardEdition createCardEdition(CardEdition inCardEdition) {
		return this.cardEditionDao.create(inCardEdition);
	}

	@Override
	public CardEdition updateCardEdition(CardEdition inCardEdition) {
		return this.cardEditionDao.update(inCardEdition);
	}

	@Override
	public List<CardEdition> findCardEditionByCard(Card inCard) {
		return this.cardEditionDao.findByCard(inCard);
	}

	@Override
	public void removeCardEdition(CardEdition inCardEdition) {
		this.cardEditionDao.delete(inCardEdition);
	}

	@Override
	public Color createColor(Color inColor) {
		return this.colorDao.create(inColor);
	}

	@Override
	public Color updateColor(Color inColor) {
		return this.colorDao.update(inColor);
	}

	@Override
	public List<Color> findAllColors() {
		return this.colorDao.findAll();
	}

	@Override
	public Color findColorById(Long inId) {
		return this.colorDao.findById(inId);
	}

	@Override
	public Color findColorByName(String inName) {
		return this.colorDao.findByName(inName);
	}

	@Override
	public Color findColorByNom(String inNom) {
		return this.colorDao.findByNom(inNom);
	}

	@Override
	public Color findColorByAbbreviation(String inAbbreviation) {
		return this.colorDao.findByAbbreviation(inAbbreviation);
	}

	@Override
	public void removeColor(Color inColor) {
		this.colorDao.delete(inColor);
	}

	@Override
	public Edition createEdition(Edition inEdition) {
		return this.editionDao.create(inEdition);
	}

	@Override
	public Edition updateEdition(Edition inEdition) {
		return this.editionDao.update(inEdition);
	}

	@Override
	public List<Edition> findAllEditions() {
		return this.editionDao.findAll();
	}

	@Override
	public Edition findEditionById(Long inId) {
		return this.editionDao.findById(inId);
	}

	@Override
	public Edition findEditionByName(String inName) {
		return this.editionDao.findByName(inName);
	}

	@Override
	public Edition findEditionByNom(String inNom) {
		return this.editionDao.findByNom(inNom);
	}

	@Override
	public Edition findEditionByAbbreviation(String inAbbreviation) {
		return this.editionDao.findByAbbreviation(inAbbreviation);
	}

	@Override
	public void removeEdition(Edition inEdition) {
		this.editionDao.delete(inEdition);
	}

	@Override
	public Family createFamily(Family inFamily) {
		return this.familyDao.create(inFamily);
	}

	@Override
	public Family updateFamily(Family inFamily) {
		return this.familyDao.update(inFamily);
	}

	@Override
	public List<Family> findAllFamilies() {
		return this.familyDao.findAll();
	}

	@Override
	public Family findFamilyById(Long inId) {
		return this.familyDao.findById(inId);
	}

	@Override
	public Family findFamilyByName(String inName) {
		return this.familyDao.findByName(inName);
	}

	@Override
	public Family findFamilyByNom(String inNom) {
		return this.familyDao.findByNom(inNom);
	}

	@Override
	public void removeFamily(Family inFamily) {
		this.familyDao.delete(inFamily);
	}

	@Override
	public Rarity createRarity(Rarity inRarity) {
		return this.rarityDao.create(inRarity);
	}

	@Override
	public Rarity updateRarity(Rarity inRarity) {
		return this.rarityDao.update(inRarity);
	}

	@Override
	public List<Rarity> findAllRarities() {
		return this.rarityDao.findAll();
	}

	@Override
	public Rarity findRarityById(Long inId) {
		return this.rarityDao.findById(inId);
	}

	@Override
	public Rarity findRarityByAbbreviation(String inAbbreviation) {
		return this.rarityDao.findByAbbreviation(inAbbreviation);
	}

	@Override
	public void removeRarity(Rarity inRarity) {
		this.rarityDao.delete(inRarity);
	}

	@Override
	public TypeCard createTypeCard(TypeCard inTypeCard) {
		return this.typeCardDao.create(inTypeCard);
	}

	@Override
	public TypeCard updateTypeCard(TypeCard inTypeCard) {
		return this.typeCardDao.update(inTypeCard);
	}

	@Override
	public List<TypeCard> findAllTypeCards() {
		return this.typeCardDao.findAll();
	}

	@Override
	public TypeCard findTypeCardById(Long inId) {
		return this.typeCardDao.findById(inId);
	}

	@Override
	public TypeCard findTypeCardByName(String inName) {
		return this.typeCardDao.findByName(inName);
	}

	@Override
	public TypeCard findTypeCardByNom(String inNom) {
		return this.typeCardDao.findByNom(inNom);
	}

	@Override
	public void removeTypeCard(TypeCard inTypeCard) {
		this.typeCardDao.delete(inTypeCard);
	}

}
