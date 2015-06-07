package be.lionelh.magic.listing.data.domain.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "magic_card")
@EntityListeners({DatesListener.class})
@NamedQueries({
    @NamedQuery(name = "Card.FINDALL", query = "SELECT new be.lionelh.magic.listing.data.domain.entities.Card(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate,c.color,c.typeCard) FROM Card c"),
    @NamedQuery(name = "Card.FINDBYNAME", query = "SELECT new be.lionelh.magic.listing.data.domain.entities.Card(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate,c.color,c.typeCard) FROM Card c WHERE c.name = :name"),
    @NamedQuery(name = "Card.FINDBYNOM", query = "SELECT new be.lionelh.magic.listing.data.domain.entities.Card(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate,c.color,c.typeCard) FROM Card c WHERE c.nom = :nom"),
    @NamedQuery(name = "Card.FINDBYTYPECARD", query = "SELECT new be.lionelh.magic.listing.data.domain.entities.Card(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate,c.color,c.typeCard) FROM Card c WHERE c.typeCard.id = :typeCardId"),
    @NamedQuery(name = "Card.FINDBYCOLOR", query = "SELECT new be.lionelh.magic.listing.data.domain.entities.Card(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate,c.color,c.typeCard) FROM Card c WHERE c.color.id = :colorId"),
    @NamedQuery(name = "Card.FINDBYFAMILY", query = "SELECT new be.lionelh.magic.listing.data.domain.entities.Card(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate,c.color,c.typeCard) FROM Card c, in(c.families) f WHERE f.id = :familyId"),
    @NamedQuery(name = "Card.FINDBYEDITION", query = "SELECT new be.lionelh.magic.listing.data.domain.entities.Card(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate,c.color,c.typeCard) FROM Card c, in(c.cardEditions) ce WHERE ce.edition.id = :editionId"),
    @NamedQuery(name = "Card.FINDBYRARITY", query = "SELECT new be.lionelh.magic.listing.data.domain.entities.Card(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate,c.color,c.typeCard) FROM Card c, in(c.cardEditions) ce WHERE ce.rarity.id = :rarityId"),
    @NamedQuery(name = "Card.FINDBYCAPACITY", query = "SELECT new be.lionelh.magic.listing.data.domain.entities.Card(c.id,c.name,c.nom,c.creationDate,c.lastUpdateDate,c.color,c.typeCard) FROM Card c, in(c.cardEditions) ce, IN(ce.capacities) cp WHERE cp.id = :capacityId"),
})
public class Card implements Serializable, Storable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CA_ID", insertable = true, nullable = false, precision = 20, scale = 0, unique = true, updatable = true)
    private Long id;

    @Column(name = "CA_NAME", insertable = true, nullable = false, length = 255, unique = true, updatable = true)
    private String name;

    @Column(name = "CA_NOM", insertable = true, nullable = true, length = 255, unique = false, updatable = true)
    private String nom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CA_CREATION_DATE", insertable = true, nullable = false, unique = false, updatable = true)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CA_LAST_UPDATE_DATE", insertable = true, nullable = false, unique = false, updatable = true)
    private Date lastUpdateDate;

    @Lob
    @Column(name = "CA_TEXT", insertable = true, nullable = true, unique = false, updatable = true)
    private String text;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "CA_TC_ID", nullable = false)
    private TypeCard typeCard;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "CA_CO_ID", nullable = false)
    private Color color;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "magic_card_family", joinColumns = @JoinColumn(name = "CAF_CA_ID"), inverseJoinColumns = @JoinColumn(name = "CAF_FA_ID"))
    private List<Family> families;

    @OneToMany(mappedBy = "card", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<CardEdition> cardEditions;

    public Card() {
        this.families = new ArrayList<Family>();
    }

    public Card(Long id, String name, String nom, Date creationDate, Date lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.nom = nom;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Card(Long id, String name, String nom, Date creationDate, Date lastUpdateDate, Color inColor, TypeCard inTypeCard) {
        this.id = id;
        this.name = name;
        this.nom = nom;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.color = inColor;
        this.typeCard = inTypeCard;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TypeCard getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(TypeCard typeCard) {
        this.typeCard = typeCard;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<Family> getFamilies() {
        return families;
    }

    public void setFamilies(List<Family> families) {
        this.families = families;
    }

    @Override
    public String toString() {
        return "Card{" + "id=" + id + ", name=" + name + ", nom=" + nom + ", creationDate=" + creationDate + ", lastUpdateDate=" + lastUpdateDate + '}';
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
        if (!(obj instanceof Card)) {
            return false;
        }
        Card other = (Card) obj;
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
