package be.lionelh.magic.listing.data.domain.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

import be.lionelh.magic.listing.data.domain.entities.Family;

/**
 * @author Lionel
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext("spring-applicationContext-persistence.xml")
public class FamilyDaoTest {

    @TestedObject
    @SpringBeanByType
    private FamilyDao familyDao;

    @Test
    public void testCreate() {
        Family f = new Family();
        f.setName("Family 001");

        Family newFamily = this.familyDao.create(f);
        assertNotNull(newFamily);
        System.out.println(this.familyDao.findAll());
        assertEquals(new Long(104), newFamily.getId());
        assertEquals("Family 001", newFamily.getName());
    }

    @Test
    public void testFindAll() {
        List<Family> l = this.familyDao.findAll();
        assertNotNull(l);
        assertEquals(103, l.size());
    }

    @Test
    public void testFindById() {
        Family f = this.familyDao.findById(24L);
        assertNotNull(f);
        assertEquals("Wall", f.getName());
    }

    @Test
    public void testFindByName() {
        Family f = this.familyDao.findByName("Knight");
        assertNotNull(f);
        assertEquals(new Long(16), f.getId());
    }

    @Test
    public void testFindByNom() {
        Family f = this.familyDao.findByNom("Soldat");
        assertNotNull(f);
        assertEquals("Soldier", f.getName());
        assertEquals(new Long(11), f.getId());
    }

    @Test
    public void testUpdate() {
        Family f = this.familyDao.findById(33L);
        assertEquals("Spirit", f.getName());
        Family oldFamily = new Family();
        oldFamily.setId(f.getId());
        oldFamily.setName(f.getName());
        oldFamily.setNom(f.getNom());
        oldFamily.setCreationDate(f.getCreationDate());
        oldFamily.setLastUpdateDate(f.getLastUpdateDate());

        f.setNom("Esprit");
        Family updatedFamily = this.familyDao.update(f);
        assertEquals("Esprit", updatedFamily.getNom()); // Was null
        
        assertNotEquals(oldFamily.getLastUpdateDate(), updatedFamily.getLastUpdateDate()); // This date must have change !
        assertEquals(oldFamily.getCreationDate(), updatedFamily.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testDelete() {
        Family f = this.familyDao.findById(2L);

        this.familyDao.delete(f);
        assertNull(this.familyDao.findById(2L));
        assertEquals(102, this.familyDao.findAll().size());
    }
}
