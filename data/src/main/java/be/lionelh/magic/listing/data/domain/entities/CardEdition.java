package be.lionelh.magic.listing.data.domain.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import be.lionelh.magic.listing.data.domain.utils.DatesListener;
import be.lionelh.magic.listing.data.domain.utils.Storable;

/**
 * @author Lionel
 */
@Entity
@Table(name = "magic_card_edition")
@EntityListeners({DatesListener.class})
@SuppressWarnings("serial")
@NamedQueries({
    @NamedQuery(name = "CardEdition.FINDBYCARD", query = "SELECT ce FROM CardEdition ce WHERE ce.card.id = :cardId"),
})
public class CardEdition implements Serializable, Storable {

    @EmbeddedId
    CardEditionPK id;

    @MapsId("cardId")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "CE_CA_ID", referencedColumnName = "CA_ID")
    private Card card;

    @MapsId("editionId")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "CE_ED_ID", referencedColumnName = "ED_ID")
    private Edition edition;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "CE_RA_ID")
    private Rarity rarity;

    @Column(name = "CE_VERSIONS", insertable = true, nullable = false, precision = 3, scale = 0, unique = false, updatable = true)
    private int versions;

    @Column(name = "CE_COST", insertable = true, nullable = true, length = 100, unique = false, updatable = true)
    private String cost;

    @Column(name = "CE_POWER", insertable = true, nullable = true, length = 50, unique = false, updatable = true)
    private String power;

    @Column(name = "CE_TOUGHNESS", insertable = true, nullable = true, length = 50, unique = false, updatable = true)
    private String toughness;

    @Column(name = "CE_LOYALTY", insertable = true, nullable = true, length = 50, unique = false, updatable = true)
    private String loyalty;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CE_CREATION_DATE", insertable = true, nullable = false, unique = false, updatable = true)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CE_LAST_UPDATE_DATE", insertable = true, nullable = false, unique = false, updatable = true)
    private Date lastUpdateDate;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "magic_card_edition_artist", joinColumns = {
        @JoinColumn(name = "CEA_CA_ID", referencedColumnName = "CE_CA_ID"),
        @JoinColumn(name = "CEA_ED_ID", referencedColumnName = "CE_ED_ID", nullable = false)},
            inverseJoinColumns = @JoinColumn(name = "CEA_ART_ID", referencedColumnName = "ART_ID"))
    private List<Artist> artists;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "magic_card_edition_capacity", joinColumns = {
        @JoinColumn(name = "CEC_CA_ID", referencedColumnName = "CE_CA_ID"),
        @JoinColumn(name = "CEC_ED_ID", referencedColumnName = "CE_ED_ID", nullable = false)},
            inverseJoinColumns = @JoinColumn(name = "CEC_CP_ID", referencedColumnName = "CP_ID"))
    private List<Capacity> capacities;

    public CardEdition() {
        this.artists = new ArrayList<Artist>();
        this.capacities = new ArrayList<Capacity>();
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
        if (this.id == null) {
            this.id = new CardEditionPK();
        }
        this.id.setCardId(card.getId());
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
        if (this.id == null) {
            this.id = new CardEditionPK();
        }
        this.id.setEditionId(edition.getId());
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public int getVersions() {
        return versions;
    }

    public void setVersions(int versions) {
        this.versions = versions;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public String getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(String loyalty) {
        this.loyalty = loyalty;
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

    public CardEditionPK getId() {
        return id;
    }

    public void setId(CardEditionPK id) {
        this.id = id;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtitsts(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Capacity> getCapacities() {
        return capacities;
    }

    public void setCapacities(List<Capacity> capacities) {
        this.capacities = capacities;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((card == null) ? 0 : card.hashCode());
        result = prime * result + ((edition == null) ? 0 : edition.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CardEdition)) {
            return false;
        }
        CardEdition other = (CardEdition) obj;
        if (card == null) {
            if (other.card != null) {
                return false;
            }
        } else if (!card.equals(other.card)) {
            return false;
        }
        if (edition == null) {
            if (other.edition != null) {
                return false;
            }
        } else if (!edition.equals(other.edition)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CardEdition [card=" + card.getId() + ", edition=" + edition.getId() + ", rarity=" + rarity.getAbbreviation() + ", versions=" + versions + ", cost=" + cost + ", power=" + power + ", toughness=" + toughness + ", loyalty=" + loyalty + ", creationDate=" + creationDate + ", lastUpdateDate=" + lastUpdateDate + "]";
    }
}
