package be.lionelh.magic.listing.data.domain.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import be.lionelh.magic.listing.data.domain.utils.DatesListener;
import be.lionelh.magic.listing.data.domain.utils.Storable;

/**
 * @author Lionel
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "magic_edition")
@EntityListeners({DatesListener.class})
@NamedQueries({
    @NamedQuery(name = "Edition.FINDALL", query = "SELECT new be.lionelh.magic.data.domain.entities.Edition(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate) FROM Edition c"),
    @NamedQuery(name = "Edition.FINDBYNAME", query = "SELECT new be.lionelh.magic.data.domain.entities.Edition(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate) FROM Edition c WHERE c.name = :name"),
    @NamedQuery(name = "Edition.FINDBYNOM", query = "SELECT new be.lionelh.magic.data.domain.entities.Edition(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate) FROM Edition c WHERE c.nom = :nom")
})
public class Edition implements Serializable, Storable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ED_ID", insertable = true, nullable = false, precision = 20, scale = 0, unique = true, updatable = true)
    private Long id;

    @Column(name = "ED_NAME", insertable = true, nullable = false, length = 255, unique = true, updatable = true)
    private String name;

    @Column(name = "ED_NOM", insertable = true, nullable = true, length = 255, unique = false, updatable = true)
    private String nom;

    @Column(name = "ED_ABBREVIATION", insertable = true, nullable = false, length = 10, unique = true, updatable = true)
    private String abbreviation;

    @Column(name = "ED_DATE_OUT", insertable = true, nullable = true, length = 20, unique = false, updatable = true)
    private String dateOut;

    @Column(name = "ED_SYMBOL", insertable = true, nullable = false, precision = 20, scale = 0, unique = false, updatable = true)
    private int symbol;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ED_CREATION_DATE", insertable = true, nullable = false, unique = false, updatable = true)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ED_LAST_UPDATE_DATE", insertable = true, nullable = false, unique = false, updatable = true)
    private Date lastUpdateDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "ED_BL_ID", nullable = true)
    private Block block;

    @OneToMany(mappedBy = "edition", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<CardEdition> cardEditions;

    public Edition() {
    }

    public Edition(Long id, String name, String nom, Date creationDate, Date lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.nom = nom;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public int getSymbol() {
        return symbol;
    }

    public void setSymbol(int symbol) {
        this.symbol = symbol;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edition other = (Edition) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Edition{" + "id=" + id + ", name=" + name + ", nom=" + nom + ", abbreviation=" + abbreviation + ", dateOut=" + dateOut + ", symbol=" + symbol + ", creationDate=" + creationDate + ", lastUpdateDate=" + lastUpdateDate + '}';
    }

}
