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

import be.lionelh.magic.listing.data.domain.entities.TypeCard;

/**
 * @author Lionel
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext("spring-applicationContext-persistence.xml")
public class TypeCardDaoTest {

    @TestedObject
    @SpringBeanByType
    private TypeCardDao typeCardDao;

    @Test
    public void testCreate() {
        TypeCard tc = new TypeCard();
        tc.setName("TypeCard 001");

        TypeCard newTypeCard = this.typeCardDao.create(tc);
        assertNotNull(newTypeCard);
        assertEquals(new Long(13), newTypeCard.getId());
        assertEquals("TypeCard 001", newTypeCard.getName());
    }

    @Test
    public void testFindAll() {
        List<TypeCard> l = this.typeCardDao.findAll();
        assertNotNull(l);
        assertEquals(12, l.size());
    }

    @Test
    public void testFindById() {
        TypeCard tc = this.typeCardDao.findById(2L);
        assertNotNull(tc);
        assertEquals("Creature", tc.getName());
    }

    @Test
    public void testFindByName() {
        TypeCard tc = this.typeCardDao.findByName("Instant");
        assertNotNull(tc);
        assertEquals(new Long(3), tc.getId());
    }

    @Test
    public void testFindByNom() {
        TypeCard tc = this.typeCardDao.findByNom("Rituel");
        assertNotNull(tc);
        assertEquals("Sorcery", tc.getName());
        assertEquals(new Long(7), tc.getId());
    }

    @Test
    public void testUpdate() {
        TypeCard tc = this.typeCardDao.findById(11L);
        assertEquals("Legendary Creature", tc.getName());
        TypeCard oldTypeCard = new TypeCard();
        oldTypeCard.setId(tc.getId());
        oldTypeCard.setName(tc.getName());
        oldTypeCard.setNom(tc.getNom());
        oldTypeCard.setCreationDate(tc.getCreationDate());
        oldTypeCard.setLastUpdateDate(tc.getLastUpdateDate());

        tc.setNom("Creature legendaire");
        TypeCard updatedTypeCard = this.typeCardDao.update(tc);
        assertEquals("Creature legendaire", updatedTypeCard.getNom()); // Was null
        
        assertNotEquals(oldTypeCard.getLastUpdateDate(), updatedTypeCard.getLastUpdateDate()); // This date must have change !
        assertEquals(oldTypeCard.getCreationDate(), updatedTypeCard.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testDelete() {
        TypeCard tc = this.typeCardDao.findById(11L);

        this.typeCardDao.delete(tc);
        assertNull(this.typeCardDao.findById(11L));
        assertEquals(11, this.typeCardDao.findAll().size());
    }
}
