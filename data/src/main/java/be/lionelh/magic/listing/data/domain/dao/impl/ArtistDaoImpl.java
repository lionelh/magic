package be.lionelh.magic.listing.data.domain.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.lionelh.magic.listing.data.domain.dao.ArtistDao;
import be.lionelh.magic.listing.data.domain.entities.Artist;

/**
 * @author Lionel
 */
@Named("artistDao")
public class ArtistDaoImpl implements ArtistDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Artist create(Artist inArtist) {
        em.persist(inArtist);
        em.flush();
        return inArtist;
    }

    @Override
    public List<Artist> findAll() {
        return this.em.createNamedQuery("Artist.FINDALL", Artist.class).getResultList();
    }

    @Override
    public Artist findById(Long inId) {
        return em.find(Artist.class, inId);
    }

    @Override
    public Artist findByName(String inName) {
        TypedQuery<Artist> query = em.createNamedQuery("Artist.FINDBYNAME", Artist.class);
        query.setParameter("name", inName);
        List<Artist> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }

    @Override
    public Artist update(Artist inArtist) {
        em.merge(inArtist);
        em.flush();

        return em.find(Artist.class, inArtist.getId());
    }

    @Override
    public void delete(Artist inArtist) {
        Artist mo = em.merge(inArtist);
        em.remove(mo);
    }
}
