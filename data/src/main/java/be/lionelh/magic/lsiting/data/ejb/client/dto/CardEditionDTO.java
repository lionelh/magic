package be.lionelh.magic.lsiting.data.ejb.client.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Lionel
 */
@SuppressWarnings("serial")
public class CardEditionDTO implements Serializable {

    private CardDTO cardDTO;
    private EditionDTO editionDTO;
    private RarityDTO rarityDTO;
    private int versions;
    private String cost;
    private String power;
    private String toughness;
    private String loyalty;
    private Date creationDate;
    private Date lastUpdateDate;
    private List<ArtistDTO> artistDTOs;
    private List<CapacityDTO> capacityDTOs;

    public CardEditionDTO() {
        this.artistDTOs = new ArrayList<ArtistDTO>();
        this.capacityDTOs = new ArrayList<CapacityDTO>();
    }

    public CardDTO getCard() {
        return cardDTO;
    }

    public void setCard(CardDTO cardDTO) {
        this.cardDTO = cardDTO;
    }

    public EditionDTO getEdition() {
        return editionDTO;
    }

    public void setEdition(EditionDTO editionDTO) {
        this.editionDTO = editionDTO;
    }

    public RarityDTO getRarity() {
        return rarityDTO;
    }

    public void setRarity(RarityDTO rarityDTO) {
        this.rarityDTO = rarityDTO;
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

    public List<ArtistDTO> getArtists() {
        return artistDTOs;
    }

    public void setArtitsts(List<ArtistDTO> artistDTOs) {
        this.artistDTOs = artistDTOs;
    }

    public List<CapacityDTO> getCapacities() {
        return capacityDTOs;
    }

    public void setCapacities(List<CapacityDTO> capacityDTOs) {
        this.capacityDTOs = capacityDTOs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cardDTO == null) ? 0 : cardDTO.hashCode());
        result = prime * result + ((editionDTO == null) ? 0 : editionDTO.hashCode());
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
        if (!(obj instanceof CardEditionDTO)) {
            return false;
        }
        CardEditionDTO other = (CardEditionDTO) obj;
        if (cardDTO == null) {
            if (other.cardDTO != null) {
                return false;
            }
        } else if (!cardDTO.equals(other.cardDTO)) {
            return false;
        }
        if (editionDTO == null) {
            if (other.editionDTO != null) {
                return false;
            }
        } else if (!editionDTO.equals(other.editionDTO)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CardEditionDTO [cardDTO=" + cardDTO.getId() + ", editionDTO=" + editionDTO.getId() + ", rarityDTO=" + rarityDTO.getAbbreviation() + ", versions=" + versions + ", cost=" + cost + ", power=" + power + ", toughness=" + toughness + ", loyalty=" + loyalty + ", creationDate=" + creationDate + ", lastUpdateDate=" + lastUpdateDate + "]";
    }
}
