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

import be.lionelh.magic.listing.data.domain.entities.Color;

/**
 * @author Lionel
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext("spring-applicationContext-persistence.xml")
@Transactional(value = TransactionMode.ROLLBACK)
@DataSet("/dataset.xml")
public class ColorDaoTest {

    @TestedObject
    @SpringBeanByType
    private ColorDao colorDao;

    @Test
    public void testCreate() {
        Color c = new Color();
        c.setName("Color 001");

        Color newColor = this.colorDao.create(c);
        assertNotNull(newColor);
        assertNotNull(newColor.getId());
        assertEquals(8, this.colorDao.findAll().size());
        assertEquals("Color 001", newColor.getName());
    }

    @Test
    public void testFindAll() {
        List<Color> l = this.colorDao.findAll();
        assertNotNull(l);
        assertEquals(7, l.size());
    }

    @Test
    public void testFindById() {
        Color c = this.colorDao.findById(1L);
        assertNotNull(c);
        assertEquals("Artifact", c.getName());
    }

    @Test
    public void testFindByName() {
        Color c = this.colorDao.findByName("Black");
        assertNotNull(c);
        assertEquals(new Long(2), c.getId());
    }

    @Test
    public void testFindByNom() {
        Color c = this.colorDao.findByNom("Noir");
        assertNotNull(c);
        assertEquals("Black", c.getName());
        assertEquals(new Long(2), c.getId());
    }

    @Test
    public void testFindByAbbreviation() {
        Color c = this.colorDao.findByAbbreviation("U");
        assertNotNull(c);
        assertEquals(new Long(3), c.getId());
        assertEquals("Blue", c.getName());
    }

    @Test
    public void testUpdate() {
        Color c = this.colorDao.findById(7L);
        assertEquals("Green", c.getName());
        Color oldColor = new Color();
        oldColor.setId(c.getId());
        oldColor.setName(c.getName());
        oldColor.setNom(c.getNom());
        oldColor.setCreationDate(c.getCreationDate());
        oldColor.setLastUpdateDate(c.getLastUpdateDate());

        c.setNom("Vert");
        Color updatedColor = this.colorDao.update(c);
        assertEquals("Vert", updatedColor.getNom()); // Was null
        
        assertNotEquals(oldColor.getLastUpdateDate(), updatedColor.getLastUpdateDate()); // This date must have change !
        assertEquals(oldColor.getCreationDate(), updatedColor.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testDelete() {
        Color c = this.colorDao.findById(2L);

        this.colorDao.delete(c);
        assertNull(this.colorDao.findById(2L));
        assertEquals(6, this.colorDao.findAll().size());
    }
}
