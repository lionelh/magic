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

import be.lionelh.magic.listing.data.domain.entities.Card;
import be.lionelh.magic.listing.data.domain.entities.Color;
import be.lionelh.magic.listing.data.domain.entities.Family;
import be.lionelh.magic.listing.data.domain.entities.TypeCard;

/**
 * @author Lionel
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext("spring-applicationContext-persistence.xml")
public class CardDaoTest {

    @TestedObject
    @SpringBeanByType
    private CardDao cardDao;

    @Test
    public void testCreate() {
        Card c = new Card();
        c.setName("Card003");
        Color color = new Color();
        color.setName("Color003");
        TypeCard tc = new TypeCard();
        tc.setName("Type003");
        c.setColor(color);
        c.setTypeCard(tc);

        Family f1 = new Family();
        f1.setName("Family001");
        f1.setNom("Famille001");
        c.getFamilies().add(f1);
        Family f2 = new Family();
        f2.setName("Family002");
        f2.setNom("Famille002");
        c.getFamilies().add(f2);
        Card newC = this.cardDao.create(c);
        System.out.println(newC);
        assertNotNull(newC);
        assertEquals(new Long(649), newC.getId());
        assertEquals("Card003", newC.getName());
    }

    @Test
    public void testFindAll() {
        List<Card> l = this.cardDao.findAll();
        assertNotNull(l);
        assertEquals(648, l.size());
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
        //assertEquals("Basic Land", c.getTypeCard().getName());
    }

    @Test
    public void testFindByNom() {
        Card c = this.cardDao.findByNom("Etau du supplice");
        assertNotNull(c);
        assertEquals("Black Vise", c.getName());
        assertEquals(new Long(48), c.getId());
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
        Card c = this.cardDao.findById(221L); // 527L

        this.cardDao.delete(c);
        assertNull(this.cardDao.findById(221L)); // 527L
        assertEquals(647, this.cardDao.findAll().size());
    }
}
