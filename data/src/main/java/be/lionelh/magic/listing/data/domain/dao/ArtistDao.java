package be.lionelh.magic.listing.data.domain.dao;

import java.util.List;

import be.lionelh.magic.listing.data.domain.entities.Artist;

/**
 * @author Lionel
 */
public interface ArtistDao {

    Artist create(Artist inArtist);
    List<Artist> findAll();
    Artist findById(Long inId);
    Artist findByName(String inName);
    Artist update(Artist inArtist);
    void delete(Artist inArtist);
}
