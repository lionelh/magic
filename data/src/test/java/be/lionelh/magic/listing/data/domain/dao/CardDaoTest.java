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

import be.lionelh.magic.listing.data.domain.entities.Card;
import be.lionelh.magic.listing.data.domain.entities.Color;
import be.lionelh.magic.listing.data.domain.entities.Family;
import be.lionelh.magic.listing.data.domain.entities.TypeCard;

/**
 * @author Lionel
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext("spring-applicationContext-persistence.xml")
@Transactional(value = TransactionMode.ROLLBACK)
@DataSet("/dataset.xml")
public class CardDaoTest {

    @TestedObject
    @SpringBeanByType
    private CardDao cardDao;

    @SpringBeanByType
    private ColorDao colorDao;
    
    @Test
    public void testCreate() {
        Card c = new Card();
        c.setName("Card003");
        Color color = new Color();
        color.setName("CO 001");
        color.setAbbreviation("C1");
        TypeCard tc = new TypeCard();
        tc.setName("TC 001");
        c.setColor(color);
        c.setTypeCard(tc);

        Family f1 = new Family();
        f1.setName("FA 001");
        c.getFamilies().add(f1);
        Family f2 = new Family();
        f2.setName("FA 002");
        c.getFamilies().add(f2);
        Card newCard = this.cardDao.create(c);
        assertNotNull(newCard);
        assertNotNull(newCard.getId());
        assertEquals(6, this.cardDao.findAll().size());
        assertEquals(new Long(528), newCard.getId());
        assertEquals("Card003", newCard.getName());
    }

    @Test
    public void testFindAll() {
        List<Card> l = this.cardDao.findAll();
        assertNotNull(l);
        assertEquals(5, l.size());
    }

    @Test
    public void testFindById() {
        Card c = this.cardDao.findById(1L);
        assertNotNull(c);
        assertEquals("AEther Spellbomb", c.getName());
    }

    @Test
    public void testFindByName() {
        Card c = this.cardDao.findByName("Black Vise");
        assertNotNull(c);
        assertEquals(new Long(48), c.getId());
    }

    @Test
    public void testFindByNom() {
        Card c = this.cardDao.findByNom("Etau du supplice");
        assertNotNull(c);
        assertEquals("Black Vise", c.getName());
        assertEquals(new Long(48), c.getId());
    }

    @Test
    public void testFindByColorWithAbbreviation() {
    	Color color = this.colorDao.findByName("Red");
    	List<Card> l = this.cardDao.findByColor(color.getId());
    	assertNotNull(l);
    	assertEquals(2, l.size());
    }

    @Test
    public void testFindByColorWithoutAbbreviation() {
    	Color color = this.colorDao.findByName("Land");
    	List<Card> l = this.cardDao.findByColor(color.getId());
    	assertNotNull(l);
    	assertEquals(1, l.size());
    }

    @Test
    public void testFindByTypeCard() {
    	List<Card> l = this.cardDao.findByTypeCard(1L);
    	assertNotNull(l);
    	assertEquals(2, l.size());
    }

    @Test
    public void testFindByFamily() {
    	List<Card> l = this.cardDao.findByFamily(34L);
    	assertNotNull(l);
    	assertEquals(1, l.size());
    }

    @Test
    public void testFindByEdition() {
    	List<Card> l = this.cardDao.findByEdition(2L);
    	assertNotNull(l);
    	assertEquals(3, l.size());
    }

    @Test
    public void testFindByRarity() {
    	List<Card> l = this.cardDao.findByRarity(3L);
    	assertNotNull(l);
    	assertEquals(2, l.size());
    }

    @Test
    public void testFindByCapacity() {
    	List<Card> l = this.cardDao.findByCapacity(1L);
    	assertNotNull(l);
    	assertEquals(1, l.size());
    }

    @Test
    public void testUpdate() {
        Card c = this.cardDao.findById(527L);
        assertEquals("Swamp", c.getName());
        Card oldCard = new Card();
        oldCard.setId(c.getId());
        oldCard.setName(c.getName());
        oldCard.setNom(c.getNom());
        oldCard.setCreationDate(c.getCreationDate());
        oldCard.setLastUpdateDate(c.getLastUpdateDate());

        c.setNom("Marais");
        Card updatedCard = this.cardDao.update(c);
        assertEquals("Marais", updatedCard.getNom()); // Was null
        
        assertNotEquals(oldCard.getLastUpdateDate(), updatedCard.getLastUpdateDate()); // This date must have change !
        assertEquals(oldCard.getCreationDate(), updatedCard.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testDelete() {
        Card c = this.cardDao.findById(221L);

        this.cardDao.delete(c);
        assertNull(this.cardDao.findById(221L));
        assertEquals(4, this.cardDao.findAll().size());
    }
}
