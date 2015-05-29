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
@Table(name = "magic_rarity")
@EntityListeners({DatesListener.class})
@NamedQueries({
    @NamedQuery(name = "Rarity.FINDALL", query = "SELECT new be.lionelh.magic.listing.data.domain.entities.Rarity(r.id,r.description,r.abbreviation,r.creationDate,r.lastUpdateDate) FROM Rarity r"),
    @NamedQuery(name = "Rarity.FINDBYABBREVIATION", query = "SELECT new be.lionelh.magic.listing.data.domain.entities.Rarity(r.id,r.description,r.abbreviation,r.creationDate,r.lastUpdateDate) FROM Rarity r WHERE r.abbreviation = :abbreviation")
})
public class Rarity implements Serializable, Storable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RA_ID", insertable = true, nullable = false, precision = 20, scale = 0, unique = true, updatable = true)
    private Long id;

    @Column(name = "RA_ABBREVIATION", insertable = true, nullable = false, length = 10, unique = true, updatable = true)
    private String abbreviation;

    @Column(name = "RA_DESCRIPTION", insertable = true, nullable = true, length = 255, unique = false, updatable = true)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RA_CREATION_DATE", insertable = true, nullable = false, unique = false, updatable = true)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RA_LAST_UPDATE_DATE", insertable = true, nullable = false, unique = false, updatable = true)
    private Date lastUpdateDate;

    @OneToMany(mappedBy = "rarity", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<CardEdition> cardEditions;

    public Rarity() {
    }

    public Rarity(Long id, String description, String abbreviation, Date creationDate, Date lastUpdateDate) {
        this.id = id;
        this.description = description;
        this.abbreviation = abbreviation;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        final Rarity other = (Rarity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rarity{" + "id=" + id + ", abbreviation=" + abbreviation + ", description=" + description + ", creationDate=" + creationDate + ", lastUpdateDate=" + lastUpdateDate + '}';
    }
}
