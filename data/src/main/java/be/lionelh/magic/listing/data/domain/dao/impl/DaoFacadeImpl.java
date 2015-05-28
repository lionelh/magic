package be.lionelh.magic.listing.data.domain.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import be.lionelh.magic.listing.data.domain.dao.ArtistDao;
import be.lionelh.magic.listing.data.domain.dao.BlockDao;
import be.lionelh.magic.listing.data.domain.dao.CapacityDao;
import be.lionelh.magic.listing.data.domain.dao.CardDao;
import be.lionelh.magic.listing.data.domain.dao.CardEditionDao;
import be.lionelh.magic.listing.data.domain.dao.ColorDao;
import be.lionelh.magic.listing.data.domain.dao.DaoFacade;
import be.lionelh.magic.listing.data.domain.dao.EditionDao;
import be.lionelh.magic.listing.data.domain.dao.FamilyDao;
import be.lionelh.magic.listing.data.domain.dao.RarityDao;
import be.lionelh.magic.listing.data.domain.dao.TypeCardDao;

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

    public DaoFacadeImpl() {
    }

	/**
	 * @return the artistDao
	 */
	public ArtistDao getArtistDao() {
		return artistDao;
	}

	/**
	 * @param artistDao the artistDao to set
	 */
	public void setArtistDao(ArtistDao artistDao) {
		this.artistDao = artistDao;
	}

	/**
	 * @return the blockDao
	 */
	public BlockDao getBlockDao() {
		return blockDao;
	}

	/**
	 * @param blockDao the blockDao to set
	 */
	public void setBlockDao(BlockDao blockDao) {
		this.blockDao = blockDao;
	}

	/**
	 * @return the capacityDao
	 */
	public CapacityDao getCapacityDao() {
		return capacityDao;
	}

	/**
	 * @param capacityDao the capacityDao to set
	 */
	public void setCapacityDao(CapacityDao capacityDao) {
		this.capacityDao = capacityDao;
	}

	/**
	 * @return the cardDao
	 */
	public CardDao getCardDao() {
		return cardDao;
	}

	/**
	 * @param cardDao the cardDao to set
	 */
	public void setCardDao(CardDao cardDao) {
		this.cardDao = cardDao;
	}

	/**
	 * @return the cardEditionDao
	 */
	public CardEditionDao getCardEditionDao() {
		return cardEditionDao;
	}

	/**
	 * @param cardEditionDao the cardEditionDao to set
	 */
	public void setCardEditionDao(CardEditionDao cardEditionDao) {
		this.cardEditionDao = cardEditionDao;
	}

	/**
	 * @return the colorDao
	 */
	public ColorDao getColorDao() {
		return colorDao;
	}

	/**
	 * @param colorDao the colorDao to set
	 */
	public void setColorDao(ColorDao colorDao) {
		this.colorDao = colorDao;
	}

	/**
	 * @return the editionDao
	 */
	public EditionDao getEditionDao() {
		return editionDao;
	}

	/**
	 * @param editionDao the editionDao to set
	 */
	public void setEditionDao(EditionDao editionDao) {
		this.editionDao = editionDao;
	}

	/**
	 * @return the familyDao
	 */
	public FamilyDao getFamilyDao() {
		return familyDao;
	}

	/**
	 * @param familyDao the familyDao to set
	 */
	public void setFamilyDao(FamilyDao familyDao) {
		this.familyDao = familyDao;
	}

	/**
	 * @return the rarityDao
	 */
	public RarityDao getRarityDao() {
		return rarityDao;
	}

	/**
	 * @param rarityDao the rarityDao to set
	 */
	public void setRarityDao(RarityDao rarityDao) {
		this.rarityDao = rarityDao;
	}

	/**
	 * @return the typeCardDao
	 */
	public TypeCardDao getTypeCardDao() {
		return typeCardDao;
	}

	/**
	 * @param typeCardDao the typeCardDao to set
	 */
	public void setTypeCardDao(TypeCardDao typeCardDao) {
		this.typeCardDao = typeCardDao;
	}
}
