package be.lionelh.magic.lsiting.data.ejb.client.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Lionel
 */
@SuppressWarnings("serial")
public class CardDTO implements Serializable {

    private Long id;
    private String name;
    private String nom;
    private Date creationDate;
    private Date lastUpdateDate;
    private String text;
    private TypeCardDTO typeCardDTO;
    private ColorDTO colorDTO;
    private List<FamilyDTO> familyDTOs;

    public CardDTO() {
        this.familyDTOs = new ArrayList<FamilyDTO>();
    }

    public CardDTO(Long id, String name, String nom, Date creationDate, Date lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.nom = nom;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public CardDTO(Long id, String name, String nom, Date creationDate, Date lastUpdateDate, ColorDTO inColor, TypeCardDTO inTypeCard) {
        this.id = id;
        this.name = name;
        this.nom = nom;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.colorDTO = inColor;
        this.typeCardDTO = inTypeCard;
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

    public TypeCardDTO getTypeCard() {
        return typeCardDTO;
    }

    public void setTypeCard(TypeCardDTO typeCardDTO) {
        this.typeCardDTO = typeCardDTO;
    }

    public ColorDTO getColor() {
        return colorDTO;
    }

    public void setColor(ColorDTO colorDTO) {
        this.colorDTO = colorDTO;
    }

    public List<FamilyDTO> getFamilies() {
        return familyDTOs;
    }

    public void setFamilies(List<FamilyDTO> familyDTOs) {
        this.familyDTOs = familyDTOs;
    }

    @Override
    public String toString() {
        return "CardDTO{" + "id=" + id + ", name=" + name + ", nom=" + nom + ", creationDate=" + creationDate + ", lastUpdateDate=" + lastUpdateDate + '}';
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
        if (!(obj instanceof CardDTO)) {
            return false;
        }
        CardDTO other = (CardDTO) obj;
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
