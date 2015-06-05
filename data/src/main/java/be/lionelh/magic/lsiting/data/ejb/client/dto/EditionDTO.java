package be.lionelh.magic.lsiting.data.ejb.client.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Lionel
 */
@SuppressWarnings("serial")
public class EditionDTO implements Serializable {

    private Long id;
    private String name;
    private String nom;
    private String abbreviation;
    private String dateOut;
    private int symbol;
    private Date creationDate;
    private Date lastUpdateDate;
    private BlockDTO blockDTO;

    public EditionDTO() {
    }

    public EditionDTO(Long id, String name, String nom, Date creationDate, Date lastUpdateDate) {
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

    public BlockDTO getBlock() {
        return blockDTO;
    }

    public void setBlock(BlockDTO blockDTO) {
        this.blockDTO = blockDTO;
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
    public String toString() {
        return "EditionDTO{" + "id=" + id + ", name=" + name + ", nom=" + nom + ", abbreviation=" + abbreviation + ", dateOut=" + dateOut + ", symbol=" + symbol + ", creationDate=" + creationDate + ", lastUpdateDate=" + lastUpdateDate + '}';
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
        if (!(obj instanceof EditionDTO)) {
            return false;
        }
        EditionDTO other = (EditionDTO) obj;
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
