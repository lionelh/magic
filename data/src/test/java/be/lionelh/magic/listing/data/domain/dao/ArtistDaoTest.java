package be.lionelh.magic.listing.data.domain.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

import be.lionelh.magic.listing.data.domain.entities.Artist;

/**
 * @author Lionel
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext("spring-applicationContext-persistence.xml")
@Transactional(value = TransactionMode.ROLLBACK)
@DataSet("/dataset.xml")
public class ArtistDaoTest {

    @TestedObject
    @SpringBeanByType
    private ArtistDao artistDao;

    @Test
    public void testCreate() {
    	Artist art = new Artist();
    	art.setName("Artist 001");
        Artist newArtist = this.artistDao.create(art);
        assertNotNull(newArtist);
        assertNotNull(newArtist.getId());
        assertEquals(12, this.artistDao.findAll().size());
        assertEquals("Artist 001", newArtist.getName());
    }

    @Test
    public void testFindAll() {
        List<Artist> l = this.artistDao.findAll();
        assertNotNull(l);
        assertEquals(11, l.size());
    }

    @Test
    public void testFindById() {
        Artist a = this.artistDao.findById(110L);
        assertNotNull(a);
        assertEquals("Anthony Waters", a.getName());
    }

    @Test
    public void testFindByName() {
        Artist a = this.artistDao.findByName("Anthony Waters");
        assertNotNull(a);
        assertEquals(new Long(110), a.getId());
    }

    @Test
    public void testUpdate() {
        Artist a = this.artistDao.findById(109L);
        assertEquals("Mark Brill", a.getName());
        Artist oldArtist = new Artist();
        oldArtist.setId(a.getId());
        oldArtist.setName(a.getName());
        oldArtist.setCreationDate(a.getCreationDate());
        oldArtist.setLastUpdateDate(a.getLastUpdateDate());

        a.setName("Mark Brillant");
        Artist updatedArtist = this.artistDao.update(a);
        assertEquals("Mark Brillant", updatedArtist.getName()); // Was Mark Brill
        
        assertNotEquals(oldArtist.getLastUpdateDate(), updatedArtist.getLastUpdateDate()); // This date must have change !
        assertEquals(oldArtist.getCreationDate(), updatedArtist.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testDelete() {
        Artist a = this.artistDao.findById(108L);

        this.artistDao.delete(a);
        assertNull(this.artistDao.findById(108L));
        assertEquals(10, this.artistDao.findAll().size());
    }
}
