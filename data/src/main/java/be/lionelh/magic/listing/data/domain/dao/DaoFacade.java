package be.lionelh.magic.listing.data.domain.dao;

/**
 * @author Lionel
 */
public interface DaoFacade {

    ArtistDao getArtistDao();
    BlockDao getBlockDao();
    CapacityDao getCapacityDao();
    CardDao getCardDao();
    CardEditionDao getCardEditionDao();
    ColorDao getColorDao();
    EditionDao getEditionDao();
    FamilyDao getFamilyDao();
    RarityDao getRarityDao();
    TypeCardDao getTypeCardDao();
}
