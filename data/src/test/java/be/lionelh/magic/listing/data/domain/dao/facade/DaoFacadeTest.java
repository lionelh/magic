package be.lionelh.magic.listing.data.domain.dao.facade;

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
import be.lionelh.magic.listing.data.domain.entities.Block;
import be.lionelh.magic.listing.data.domain.entities.Capacity;
import be.lionelh.magic.listing.data.domain.entities.Card;
import be.lionelh.magic.listing.data.domain.entities.Color;
import be.lionelh.magic.listing.data.domain.entities.Edition;
import be.lionelh.magic.listing.data.domain.entities.Family;
import be.lionelh.magic.listing.data.domain.entities.Rarity;
import be.lionelh.magic.listing.data.domain.entities.TypeCard;

/**
 * @author Lionel
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext("spring-applicationContext-persistence.xml")
@Transactional(value = TransactionMode.ROLLBACK)
@DataSet("/dataset.xml")
public class DaoFacadeTest {

    @TestedObject
    @SpringBeanByType
    private DaoFacade bean;

    @Test
    public void testCreateArtist() {
    	Artist art = new Artist();
    	art.setName("Artist 001");
        Artist newArtist = this.bean.createArtist(art);
        assertNotNull(newArtist);
        assertNotNull(newArtist.getId());
        assertEquals(12, this.bean.findAllArtists().size());
        assertEquals("Artist 001", newArtist.getName());
    }

    @Test
    public void testFindAllArtists() {
        List<Artist> l = this.bean.findAllArtists();
        assertNotNull(l);
        assertEquals(11, l.size());
    }

    @Test
    public void testFindArtistById() {
        Artist a = this.bean.findArtistById(110L);
        assertNotNull(a);
        assertEquals("Anthony Waters", a.getName());
    }

    @Test
    public void testFindArtistByName() {
    Artist a = this.bean.findArtistByName("Anthony Waters");
        assertNotNull(a);
        assertEquals(new Long(110), a.getId());
    }

    @Test
    public void testUpdateArtist() {
        Artist a = this.bean.findArtistById(109L);
        assertEquals("Mark Brill", a.getName());
        Artist oldArtist = new Artist();
        oldArtist.setId(a.getId());
        oldArtist.setName(a.getName());
        oldArtist.setCreationDate(a.getCreationDate());
        oldArtist.setLastUpdateDate(a.getLastUpdateDate());

        a.setName("Mark Brillant");
        Artist updatedArtist = this.bean.updateArtist(a);
        assertEquals("Mark Brillant", updatedArtist.getName()); // Was Mark Brill
        
        assertNotEquals(oldArtist.getLastUpdateDate(), updatedArtist.getLastUpdateDate()); // This date must have change !
        assertEquals(oldArtist.getCreationDate(), updatedArtist.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testRemoveArtist() {
        Artist a = this.bean.findArtistById(108L);

        this.bean.removeArtist(a);
        assertNull(this.bean.findArtistById(108L));
        assertEquals(10, this.bean.findAllArtists().size());
    }

    @Test
    public void testCreateBlock() {
        Block b = new Block();
        b.setName("Block 001");

        Block newBlock = this.bean.createBlock(b);
        assertNotNull(newBlock);
        assertNotNull(newBlock.getId());
        assertEquals(3, this.bean.findAllBlocks().size());
        assertEquals("Block 001", newBlock.getName());
    }

    @Test
    public void testFindAllBlocks() {
        List<Block> l = this.bean.findAllBlocks();
        assertNotNull(l);
        assertEquals(2, l.size());
    }

    @Test
    public void testFindBlockById() {
        Block b = this.bean.findBlockById(1L);
        assertNotNull(b);
        assertEquals("Mirrodin", b.getName());
    }

    @Test
    public void testFindBlockByName() {
        Block b = this.bean.findBlockByName("Ice age");
        assertNotNull(b);
        assertEquals(new Long(2), b.getId());
    }

    @Test
    public void testFindBlockByNom() {
        Block b = this.bean.findBlockByNom("Ere glaciaire");
        assertNotNull(b);
        assertEquals("Ice age", b.getName());
        assertEquals(new Long(2), b.getId());
    }

    @Test
    public void testUpdateBlock() {
        Block b = this.bean.findBlockById(1L);
        assertEquals("Mirrodin", b.getName());
        Block oldBlock = new Block();
        oldBlock.setId(b.getId());
        oldBlock.setName(b.getName());
        oldBlock.setNom(b.getNom());
        oldBlock.setCreationDate(b.getCreationDate());
        oldBlock.setLastUpdateDate(b.getLastUpdateDate());

        b.setNom("Mirrodin");
        Block updatedBlock = this.bean.updateBlock(b);
        assertEquals("Mirrodin", updatedBlock.getNom()); // Was null
        
        assertNotEquals(oldBlock.getLastUpdateDate(), updatedBlock.getLastUpdateDate()); // This date must have change !
        assertEquals(oldBlock.getCreationDate(), updatedBlock.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testRemoveBlock() {
        Block b = this.bean.findBlockById(2L);

        this.bean.removeBlock(b);
        assertNull(this.bean.findBlockById(2L));
        assertEquals(1, this.bean.findAllBlocks().size());
    }

    @Test
    public void testCreateCapacity() {
        Capacity c = new Capacity();
        c.setName("Capacity 001");

        Capacity newCapacity = this.bean.createCapacity(c);
        assertNotNull(newCapacity);
        assertNotNull(newCapacity.getId());
        assertEquals(3, this.bean.findAllCapacities().size());
        assertEquals("Capacity 001", newCapacity.getName());
    }

    @Test
    public void testFindAllCapacities() {
        List<Capacity> l = this.bean.findAllCapacities();
        assertNotNull(l);
        assertEquals(2, l.size());
    }

    @Test
    public void testFindCapacityById() {
        Capacity c = this.bean.findCapacityById(1L);
        assertNotNull(c);
        assertEquals("Haste", c.getName());
    }

    @Test
    public void testFindCapacityByName() {
        Capacity c = this.bean.findCapacityByName("Haste");
        assertNotNull(c);
        assertEquals(new Long(1), c.getId());
    }

    @Test
    public void testFindCapacityByNom() {
        Capacity c = this.bean.findCapacityByNom("Initiative");
        assertNotNull(c);
        assertEquals("First strike", c.getName());
        assertEquals(new Long(2), c.getId());
    }

    @Test
    public void testUpdateCapacity() {
        Capacity c = this.bean.findCapacityById(1L);
        assertEquals("Haste", c.getName());
        Capacity oldCapacity = new Capacity();
        oldCapacity.setId(c.getId());
        oldCapacity.setName(c.getName());
        oldCapacity.setNom(c.getNom());
        oldCapacity.setCreationDate(c.getCreationDate());
        oldCapacity.setLastUpdateDate(c.getLastUpdateDate());

        c.setNom("Celerite");
        Capacity updatedCapacity = this.bean.updateCapacity(c);
        assertEquals("Celerite", updatedCapacity.getNom()); // Was null
        
        assertNotEquals(oldCapacity.getLastUpdateDate(), updatedCapacity.getLastUpdateDate()); // This date must have change !
        assertEquals(oldCapacity.getCreationDate(), updatedCapacity.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testRemoveCaapcity() {
        Capacity c = this.bean.findCapacityById(2L);

        this.bean.removeCapacity(c);
        assertNull(this.bean.findCapacityById(2L));
        assertEquals(1, this.bean.findAllCapacities().size());
    }

    @Test
    public void testCreateCard() {
        Card c = new Card();
        c.setName("Card003");
        Color color = new Color();
        color.setName("COr 001");
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
        Card newCard = this.bean.createCard(c);
        assertNotNull(newCard);
        assertNotNull(newCard.getId());
        assertEquals(5, this.bean.findAllCards().size());
        assertEquals(new Long(528), newCard.getId());
        assertEquals("Card003", newCard.getName());
    }

    @Test
    public void testFindAllCards() {
        List<Card> l = this.bean.findAllCards();
        assertNotNull(l);
        assertEquals(4, l.size());
    }

    @Test
    public void testFindCardById() {
        Card c = this.bean.findCardById(1L);
        assertNotNull(c);
        assertEquals("AEther Spellbomb", c.getName());
    }

    @Test
    public void testFindCardByName() {
        Card c = this.bean.findCardByName("Black Vise");
        assertNotNull(c);
        assertEquals(new Long(48), c.getId());
    }

    @Test
    public void testFindCardByNom() {
        Card c = this.bean.findCardByNom("Etau du supplice");
        assertNotNull(c);
        assertEquals("Black Vise", c.getName());
        assertEquals(new Long(48), c.getId());
    }

    @Test
    public void testUpdateCard() {
        Card c = this.bean.findCardById(527L);
        assertEquals("Swamp", c.getName());
        Card oldCard = new Card();
        oldCard.setId(c.getId());
        oldCard.setName(c.getName());
        oldCard.setNom(c.getNom());
        oldCard.setCreationDate(c.getCreationDate());
        oldCard.setLastUpdateDate(c.getLastUpdateDate());

        c.setNom("Marais");
        Card updatedCard = this.bean.updateCard(c);
        assertEquals("Marais", updatedCard.getNom()); // Was null
        
        assertNotEquals(oldCard.getLastUpdateDate(), updatedCard.getLastUpdateDate()); // This date must have change !
        assertEquals(oldCard.getCreationDate(), updatedCard.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testRemoveCard() {
        Card c = this.bean.findCardById(221L);

        this.bean.removeCard(c);
        assertNull(this.bean.findCardById(221L));
        assertEquals(3, this.bean.findAllCards().size());
    }

    @Test
    public void testCreateColor() {
        Color c = new Color();
        c.setName("Color 001");

        Color newColor = this.bean.createColor(c);
        assertNotNull(newColor);
        assertNotNull(newColor.getId());
        assertEquals(8, this.bean.findAllColors().size());
        assertEquals("Color 001", newColor.getName());
    }

    @Test
    public void testFindAllColors() {
        List<Color> l = this.bean.findAllColors();
        assertNotNull(l);
        assertEquals(7, l.size());
    }

    @Test
    public void testFindColorById() {
        Color c = this.bean.findColorById(1L);
        assertNotNull(c);
        assertEquals("Artifact", c.getName());
    }

    @Test
    public void testFindColorByName() {
        Color c = this.bean.findColorByName("Black");
        assertNotNull(c);
        assertEquals(new Long(2), c.getId());
    }

    @Test
    public void testFindColorByNom() {
        Color c = this.bean.findColorByNom("Noir");
        assertNotNull(c);
        assertEquals("Black", c.getName());
        assertEquals(new Long(2), c.getId());
    }

    @Test
    public void testFindColorByAbbreviation() {
        Color c = this.bean.findColorByAbbreviation("U");
        assertNotNull(c);
        assertEquals(new Long(3), c.getId());
        assertEquals("Blue", c.getName());
    }

    @Test
    public void testUpdateColor() {
        Color c = this.bean.findColorById(7L);
        assertEquals("Green", c.getName());
        Color oldColor = new Color();
        oldColor.setId(c.getId());
        oldColor.setName(c.getName());
        oldColor.setNom(c.getNom());
        oldColor.setCreationDate(c.getCreationDate());
        oldColor.setLastUpdateDate(c.getLastUpdateDate());

        c.setNom("Vert");
        Color updatedColor = this.bean.updateColor(c);
        assertEquals("Vert", updatedColor.getNom()); // Was null
        
        assertNotEquals(oldColor.getLastUpdateDate(), updatedColor.getLastUpdateDate()); // This date must have change !
        assertEquals(oldColor.getCreationDate(), updatedColor.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testRemoveColor() {
        Color c = this.bean.findColorById(2L);

        this.bean.removeColor(c);
        assertNull(this.bean.findColorById(2L));
        assertEquals(6, this.bean.findAllColors().size());
    }

    @Test
    public void testCreateEdition() {
        Edition e = new Edition();
        e.setName("Edition 001");
        e.setAbbreviation("E1");

        Edition newEdition = this.bean.createEdition(e);
        assertNotNull(newEdition);
        assertNotNull(newEdition.getId());
        assertEquals(3, this.bean.findAllEditions().size());
        assertEquals("Edition 001", newEdition.getName());
    }

    @Test
    public void testFindAllEditions() {
        List<Edition> l = this.bean.findAllEditions();
        assertNotNull(l);
        assertEquals(2, l.size());
    }

    @Test
    public void testFindEditionById() {
        Edition e = this.bean.findEditionById(1L);
        assertNotNull(e);
        assertEquals("Mirrodin", e.getName());
    }

    @Test
    public void testFindEditionByName() {
        Edition e = this.bean.findEditionByName("Fourth edition");
        assertNotNull(e);
        assertEquals(new Long(2), e.getId());
    }

    @Test
    public void testFindEditionByNom() {
        Edition e = this.bean.findEditionByNom("4eme edition");
        assertNotNull(e);
        assertEquals("Fourth edition", e.getName());
        assertEquals(new Long(2), e.getId());
    }

    @Test
    public void testFindEditionByAbbreviation() {
        Edition e = this.bean.findEditionByAbbreviation("4E");
        assertNotNull(e);
        assertEquals("Fourth edition", e.getName());
        assertEquals(new Long(2), e.getId());
    }

    @Test
    public void testUpdateEdition() {
        Edition e = this.bean.findEditionById(1L);
        assertEquals("Mirrodin", e.getName());
        Edition oldEdition = new Edition();
        oldEdition.setId(e.getId());
        oldEdition.setName(e.getName());
        oldEdition.setNom(e.getNom());
        oldEdition.setCreationDate(e.getCreationDate());
        oldEdition.setLastUpdateDate(e.getLastUpdateDate());

        e.setNom("Mirrodin");
        Edition updatedEdition = this.bean.updateEdition(e);
        assertEquals("Mirrodin", updatedEdition.getNom()); // Was null
        
        assertNotEquals(oldEdition.getLastUpdateDate(), updatedEdition.getLastUpdateDate()); // This date must have change !
        assertEquals(oldEdition.getCreationDate(), updatedEdition.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testRemoveEdition() {
        Edition e = this.bean.findEditionById(2L);

        this.bean.removeEdition(e);
        assertNull(this.bean.findEditionById(2L));
        assertEquals(1, this.bean.findAllEditions().size());
    }

    @Test
    public void testCreateFAmily() {
        Family f = new Family();
        f.setName("Family 001");

        Family newFamily = this.bean.createFamily(f);
        assertNotNull(newFamily);
        assertNotNull(newFamily.getId());
        assertEquals(7, this.bean.findAllFamilies().size());
        assertEquals("Family 001", newFamily.getName());
    }

    @Test
    public void testFindAllFamilies() {
        List<Family> l = this.bean.findAllFamilies();
        assertNotNull(l);
        assertEquals(6, l.size());
    }

    @Test
    public void testFindFamilyById() {
        Family f = this.bean.findFamilyById(24L);
        assertNotNull(f);
        assertEquals("Wall", f.getName());
    }

    @Test
    public void testFindFamilyByName() {
        Family f = this.bean.findFamilyByName("Knight");
        assertNotNull(f);
        assertEquals(new Long(16), f.getId());
    }

    @Test
    public void testFindFamilyByNom() {
        Family f = this.bean.findFamilyByNom("Soldat");
        assertNotNull(f);
        assertEquals("Soldier", f.getName());
        assertEquals(new Long(11), f.getId());
    }

    @Test
    public void testUpdateFamily() {
        Family f = this.bean.findFamilyById(33L);
        assertEquals("Spirit", f.getName());
        Family oldFamily = new Family();
        oldFamily.setId(f.getId());
        oldFamily.setName(f.getName());
        oldFamily.setNom(f.getNom());
        oldFamily.setCreationDate(f.getCreationDate());
        oldFamily.setLastUpdateDate(f.getLastUpdateDate());

        f.setNom("Esprit");
        Family updatedFamily = this.bean.updateFamily(f);
        assertEquals("Esprit", updatedFamily.getNom()); // Was null
        
        assertNotEquals(oldFamily.getLastUpdateDate(), updatedFamily.getLastUpdateDate()); // This date must have change !
        assertEquals(oldFamily.getCreationDate(), updatedFamily.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testRemoveFamily() {
        Family f = this.bean.findFamilyById(50L);

        this.bean.removeFamily(f);
        assertNull(this.bean.findFamilyById(50L));
        assertEquals(5, this.bean.findAllFamilies().size());
    }

    @Test
    public void testCreateRrity() {
        Rarity r = new Rarity();
        r.setAbbreviation("R1");
        r.setDescription("Rarity 001");

        Rarity newRarity = this.bean.createRarity(r);
        assertNotNull(newRarity);
        assertNotNull(newRarity.getId());
        assertEquals(4, this.bean.findAllRarities().size());
        assertEquals("Rarity 001", newRarity.getDescription());
        assertEquals("R1", newRarity.getAbbreviation());
    }

    @Test
    public void testFindAllRarities() {
        List<Rarity> l = this.bean.findAllRarities();
        assertNotNull(l);
        assertEquals(3, l.size());
    }

    @Test
    public void testFindRarityById() {
        Rarity r = this.bean.findRarityById(1L);
        assertNotNull(r);
        assertEquals("C", r.getAbbreviation());
    }

    @Test
    public void testFindRarityByAbbreviation() {
        Rarity r = this.bean.findRarityByAbbreviation("U");
        assertNotNull(r);
        assertEquals(new Long(2), r.getId());
    }

    @Test
    public void testUpdateRarity() {
        Rarity r = this.bean.findRarityById(3L);
        assertEquals("R", r.getAbbreviation());
        Rarity oldRarity = new Rarity();
        oldRarity.setId(r.getId());
        oldRarity.setAbbreviation(r.getAbbreviation());
        oldRarity.setDescription(r.getDescription());
        oldRarity.setCreationDate(r.getCreationDate());
        oldRarity.setLastUpdateDate(r.getLastUpdateDate());

        r.setDescription("Rare");
        Rarity updatedRarity = this.bean.updateRarity(r);
        assertEquals("Rare", updatedRarity.getDescription()); // Was null
        
        assertNotEquals(oldRarity.getLastUpdateDate(), updatedRarity.getLastUpdateDate()); // This date must have change !
        assertEquals(oldRarity.getCreationDate(), updatedRarity.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testRemoveRarity() {
        Rarity r = this.bean.findRarityById(2L);

        this.bean.removeRarity(r);
        assertNull(this.bean.findRarityById(2L));
        assertEquals(2, this.bean.findAllRarities().size());
    }

    @Test
    public void testCreateTypeCard() {
        TypeCard tc = new TypeCard();
        tc.setName("TypeCard 001");

        TypeCard newTypeCard = this.bean.createTypeCard(tc);
        assertNotNull(newTypeCard);
        assertNotNull(newTypeCard.getId());
        assertEquals(13, this.bean.findAllTypeCards().size());
        assertEquals("TypeCard 001", newTypeCard.getName());
    }

    @Test
    public void testFindAllTypeCards() {
        List<TypeCard> l = this.bean.findAllTypeCards();
        assertNotNull(l);
        assertEquals(12, l.size());
    }

    @Test
    public void testFindTypeCardById() {
        TypeCard tc = this.bean.findTypeCardById(2L);
        assertNotNull(tc);
        assertEquals("Creature", tc.getName());
    }

    @Test
    public void testFindTypeCardByName() {
        TypeCard tc = this.bean.findTypeCardByName("Instant");
        assertNotNull(tc);
        assertEquals(new Long(3), tc.getId());
    }

    @Test
    public void testFindTypeCardByNom() {
        TypeCard tc = this.bean.findTypeCardByNom("Rituel");
        assertNotNull(tc);
        assertEquals("Sorcery", tc.getName());
        assertEquals(new Long(7), tc.getId());
    }

    @Test
    public void testUpdateTypeCard() {
        TypeCard tc = this.bean.findTypeCardById(11L);
        assertEquals("Legendary Creature", tc.getName());
        TypeCard oldTypeCard = new TypeCard();
        oldTypeCard.setId(tc.getId());
        oldTypeCard.setName(tc.getName());
        oldTypeCard.setNom(tc.getNom());
        oldTypeCard.setCreationDate(tc.getCreationDate());
        oldTypeCard.setLastUpdateDate(tc.getLastUpdateDate());

        tc.setNom("Creature legendaire");
        TypeCard updatedTypeCard = this.bean.updateTypeCard(tc);
        assertEquals("Creature legendaire", updatedTypeCard.getNom()); // Was null
        
        assertNotEquals(oldTypeCard.getLastUpdateDate(), updatedTypeCard.getLastUpdateDate()); // This date must have change !
        assertEquals(oldTypeCard.getCreationDate(), updatedTypeCard.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testRemoveTypeCard() {
        TypeCard tc = this.bean.findTypeCardById(11L);

        this.bean.removeTypeCard(tc);
        assertNull(this.bean.findTypeCardById(11L));
        assertEquals(11, this.bean.findAllTypeCards().size());
    }

}
