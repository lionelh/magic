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
@Table(name = "magic_type_card")
@EntityListeners({DatesListener.class})
@NamedQueries({
    @NamedQuery(name = "TypeCard.FINDALL", query = "SELECT new be.lionelh.magic.data.domain.entities.TypeCard(tc.id,tc.name,tc.nom,tc.creationDate,tc.lastUpdateDate) FROM TypeCard tc"),
    @NamedQuery(name = "TypeCard.FINDBYNAME", query = "SELECT new be.lionelh.magic.data.domain.entities.TypeCard(tc.id,tc.name,tc.nom,tc.creationDate,tc.lastUpdateDate) FROM TypeCard tc WHERE tc.name = :name"),
    @NamedQuery(name = "TypeCard.FINDBYNOM", query = "SELECT new be.lionelh.magic.data.domain.entities.TypeCard(tc.id,tc.name,tc.nom,tc.creationDate,tc.lastUpdateDate) FROM TypeCard tc WHERE tc.nom = :nom")
})
public class TypeCard implements Serializable, Storable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TC_ID", insertable = true, nullable = false, precision = 20, scale = 0, unique = true, updatable = true)
    private Long id;

    @Column(name = "TC_NAME", insertable = true, nullable = false, length = 255, unique = true, updatable = true)
    private String name;

    @Column(name = "TC_NOM", insertable = true, nullable = true, length = 255, unique = false, updatable = true)
    private String nom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TC_CREATION_DATE", insertable = true, nullable = false, unique = false, updatable = true)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TC_LAST_UPDATE_DATE", insertable = true, nullable = false, unique = false, updatable = true)
    private Date lastUpdateDate;

    @OneToMany(mappedBy = "typeCard", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<Card> cards;

    public TypeCard() {
    }

    public TypeCard(Long id, String name, String nom, Date creationDate, Date lastUpdateDate) {
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
        final TypeCard other = (TypeCard) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TypeCard{" + "id=" + id + ", name=" + name + ", nom=" + nom + ", creationDate=" + creationDate + ", lastUpdateDate=" + lastUpdateDate + '}';
    }
}
