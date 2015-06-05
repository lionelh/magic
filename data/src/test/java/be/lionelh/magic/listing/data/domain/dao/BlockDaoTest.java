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

import be.lionelh.magic.listing.data.domain.entities.Block;

/**
 * @author Lionel
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext("spring-applicationContext-persistence.xml")
@Transactional(value = TransactionMode.ROLLBACK)
@DataSet("/dataset.xml")
public class BlockDaoTest {

    @TestedObject
    @SpringBeanByType
    private BlockDao blockDao;

    @Test
    public void testCreate() {
        Block b = new Block();
        b.setName("Block 001");

        Block newBlock = this.blockDao.create(b);
        assertNotNull(newBlock);
        assertNotNull(newBlock.getId());
        assertEquals(3, this.blockDao.findAll().size());
        assertEquals("Block 001", newBlock.getName());
    }

    @Test
    public void testFindAll() {
        List<Block> l = this.blockDao.findAll();
        assertNotNull(l);
        assertEquals(2, l.size());
    }

    @Test
    public void testFindById() {
        Block b = this.blockDao.findById(1L);
        assertNotNull(b);
        assertEquals("Mirrodin", b.getName());
    }

    @Test
    public void testFindByName() {
        Block b = this.blockDao.findByName("Ice age");
        assertNotNull(b);
        assertEquals(new Long(2), b.getId());
    }

    @Test
    public void testFindByNom() {
        Block b = this.blockDao.findByNom("Ere glaciaire");
        assertNotNull(b);
        assertEquals("Ice age", b.getName());
        assertEquals(new Long(2), b.getId());
    }

    @Test
    public void testUpdate() {
        Block b = this.blockDao.findById(1L);
        assertEquals("Mirrodin", b.getName());
        Block oldBlock = new Block();
        oldBlock.setId(b.getId());
        oldBlock.setName(b.getName());
        oldBlock.setNom(b.getNom());
        oldBlock.setCreationDate(b.getCreationDate());
        oldBlock.setLastUpdateDate(b.getLastUpdateDate());

        b.setNom("Mirrodin");
        Block updatedBlock = this.blockDao.update(b);
        assertEquals("Mirrodin", updatedBlock.getNom()); // Was null
        
        assertNotEquals(oldBlock.getLastUpdateDate(), updatedBlock.getLastUpdateDate()); // This date must have change !
        assertEquals(oldBlock.getCreationDate(), updatedBlock.getCreationDate()); // This date must not have changed !
    }

    @Test
    public void testDelete() {
        Block b = this.blockDao.findById(2L);

        this.blockDao.delete(b);
        assertNull(this.blockDao.findById(2L));
        assertEquals(1, this.blockDao.findAll().size());
    }
}
