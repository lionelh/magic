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

import be.lionelh.magic.listing.data.domain.entities.Rarity;

/**
 * @author Lionel
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext("spring-applicationContext-persistence.xml")
public class RarityDaoTest {

    @TestedObject
    @SpringBeanByType
    private RarityDao rarityDao;

    @Test
    public void testCreate() {
        Rarity r = new Rarity();
        r.setAbbreviation("F");
        r.setDescription("Rarity 001");

        Rarity newRarity = this.rarityDao.create(r);
        assertNotNull(newRarity);
        assertEquals(new Long(4), newRarity.getId());
        assertEquals("Rarity 001", newRarity.getDescription());
        assertEquals("F", newRarity.getAbbreviation());
    }

    @Test
    public void testFindAll() {
        List<Rarity> l = this.rarityDao.findAll();
        assertNotNull(l);
        assertEquals(3, l.size());
    }

    @Test
    public void testFindById() {
        Rarity r = this.rarityDao.findById(1L);
        assertNotNull(r);
        assertEquals("C", r.getAbbreviation());
    }

    @Test
    public void testFindByAbbreviation() {
        Rarity r = this.rarityDao.findByAbbreviation("U");
        assertNotNull(r);
        assertEquals(new Long(2), r.getId());
    }

    @Test
    public void testUpdate() {
        Rarity r = this.rarityDao.findById(3L);
        assertEquals("R", r.getAbbreviation());
        Rarity oldRarity = new Rarity();
        oldRarity.setId(r.getId());
        oldRarity.setAbbreviation(r.getAbbreviation());
        oldRarity.setDescription(r.getDescription());
        oldRarity.setCreationDate(r.getCreationDate());
        oldRarity.setLastUpdateDate(r.getLastUpdateDate());

        r.setDescription("Rare");
        Rarity updatedRarity = this.rarityDao.update(r);
        assertEquals("Rare", updatedRarity.getDescription()); // Was null
        
        assertNotEquals(oldRarity.getLastUpdateDate(), updatedRarity.getLastUpdateDate()); // This date must have change !
        assertEquals(oldRarity.getCreationDate(), updatedRarity.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testDelete() {
        Rarity r = this.rarityDao.findById(2L);

        this.rarityDao.delete(r);
        assertNull(this.rarityDao.findById(2L));
        assertEquals(2, this.rarityDao.findAll().size());
    }
}
