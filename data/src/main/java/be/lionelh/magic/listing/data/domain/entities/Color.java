package be.lionelh.magic.listing.data.domain.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "magic_color")
@EntityListeners({DatesListener.class})
@NamedQueries({
    @NamedQuery(name = "Color.FINDALL", query = "SELECT new be.lionelh.magic.listing.data.domain.entities.Color(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate) FROM Color c"),
    @NamedQuery(name = "Color.FINDBYNAME", query = "SELECT new be.lionelh.magic.listing.data.domain.entities.Color(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate) FROM Color c WHERE c.name = :name"),
    @NamedQuery(name = "Color.FINDBYABBREVIATION", query = "SELECT new be.lionelh.magic.listing.data.domain.entities.Color(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate) FROM Color c WHERE c.abbreviation = :abbreviation"),
    @NamedQuery(name = "Color.FINDBYNOM", query = "SELECT new be.lionelh.magic.listing.data.domain.entities.Color(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate) FROM Color c WHERE c.nom = :nom")
})
public class Color implements Serializable, Storable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_ID", insertable = true, nullable = false, precision = 20, scale = 0, unique = true, updatable = true)
    private Long id;

    @Column(name = "CO_NAME", insertable = true, nullable = false, length = 255, unique = true, updatable = true)
    private String name;

    @Column(name = "CO_NOM", insertable = true, nullable = true, length = 255, unique = false, updatable = true)
    private String nom;

    @Column(name = "CO_ABBREVIATION", insertable = true, nullable = true, length = 20, unique = false, updatable = true)
    private String abbreviation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CO_CREATION_DATE", insertable = true, nullable = false, unique = false, updatable = true)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CO_LAST_UPDATE_DATE", insertable = true, nullable = false, unique = false, updatable = true)
    private Date lastUpdateDate;

    @OneToMany(mappedBy = "color", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<Card> cards;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "magic_color_mana_abbreviation", joinColumns = @JoinColumn(name = "CMA_CO_ID"), inverseJoinColumns = @JoinColumn(name = "CMA_MA_ID"))
    private List<ManaAbbreviation> manaAbbreviations;

    public Color() {
    }

    public Color(Long id, String name, String nom, Date creationDate, Date lastUpdateDate) {
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

    /**
	 * @return the manaAbbreviations
	 */
	public List<ManaAbbreviation> getManaAbbreviations() {
		return manaAbbreviations;
	}

	/**
	 * @param manaAbbreviations the manaAbbreviations to set
	 */
	public void setManaAbbreviations(List<ManaAbbreviation> manaAbbreviations) {
		this.manaAbbreviations = manaAbbreviations;
	}

	@Override
    public String toString() {
        return "Color{" + "id=" + id + ", name=" + name + ", nom=" + nom + ", creationDate=" + creationDate + ", lastUpdateDate=" + lastUpdateDate + '}';
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Color)) {
            return false;
        }
        Color other = (Color) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
}
