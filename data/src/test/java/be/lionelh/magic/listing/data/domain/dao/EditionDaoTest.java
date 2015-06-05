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

import be.lionelh.magic.listing.data.domain.entities.Edition;

/**
 * @author Lionel
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext("spring-applicationContext-persistence.xml")
@Transactional(value = TransactionMode.ROLLBACK)
@DataSet("/dataset.xml")
public class EditionDaoTest {

    @TestedObject
    @SpringBeanByType
    private EditionDao editionDao;

    @Test
    public void testCreate() {
        Edition e = new Edition();
        e.setName("Edition 001");
        e.setAbbreviation("E1");

        Edition newEdition = this.editionDao.create(e);
        assertNotNull(newEdition);
        assertNotNull(newEdition.getId());
        assertEquals(3, this.editionDao.findAll().size());
        assertEquals("Edition 001", newEdition.getName());
    }

    @Test
    public void testFindAll() {
        List<Edition> l = this.editionDao.findAll();
        assertNotNull(l);
        assertEquals(2, l.size());
    }

    @Test
    public void testFindById() {
        Edition e = this.editionDao.findById(1L);
        assertNotNull(e);
        assertEquals("Mirrodin", e.getName());
    }

    @Test
    public void testFindByName() {
        Edition e = this.editionDao.findByName("Fourth edition");
        assertNotNull(e);
        assertEquals(new Long(2), e.getId());
    }

    @Test
    public void testFindByNom() {
        Edition e = this.editionDao.findByNom("4eme edition");
        assertNotNull(e);
        assertEquals("Fourth edition", e.getName());
        assertEquals(new Long(2), e.getId());
    }

    @Test
    public void testFindByAbbreviation() {
        Edition e = this.editionDao.findByAbbreviation("4E");
        assertNotNull(e);
        assertEquals("Fourth edition", e.getName());
        assertEquals(new Long(2), e.getId());
    }

    @Test
    public void testUpdate() {
        Edition e = this.editionDao.findById(1L);
        assertEquals("Mirrodin", e.getName());
        Edition oldEdition = new Edition();
        oldEdition.setId(e.getId());
        oldEdition.setName(e.getName());
        oldEdition.setNom(e.getNom());
        oldEdition.setCreationDate(e.getCreationDate());
        oldEdition.setLastUpdateDate(e.getLastUpdateDate());

        e.setNom("Mirrodin");
        Edition updatedEdition = this.editionDao.update(e);
        assertEquals("Mirrodin", updatedEdition.getNom()); // Was null
        
        assertNotEquals(oldEdition.getLastUpdateDate(), updatedEdition.getLastUpdateDate()); // This date must have change !
        assertEquals(oldEdition.getCreationDate(), updatedEdition.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testDelete() {
        Edition e = this.editionDao.findById(2L);

        this.editionDao.delete(e);
        assertNull(this.editionDao.findById(2L));
        assertEquals(1, this.editionDao.findAll().size());
    }
}
