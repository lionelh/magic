/**
 * 
 */
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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import be.lionelh.magic.listing.data.domain.utils.DatesListener;
import be.lionelh.magic.listing.data.domain.utils.Storable;

/**
 * @author Lionel
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "magic_mana_abbreviation")
@EntityListeners({DatesListener.class})
public class ManaAbbreviation implements Serializable, Storable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MA_ID", insertable = true, nullable = false, precision = 20, scale = 0, unique = true, updatable = true)
    private Long id;

	@Column(name = "MA_REPRESENTATION", insertable = true, nullable = false, length = 10, unique = true, updatable = true)
	private String representation;

	@Column(name = "MA_IMG_URL", insertable = true, nullable = true, length = 10, unique = true, updatable = true)
	private String imageUrl;

	@Column(name = "MA_READABLE_VALUE", insertable = true, nullable = false, length = 255, unique = true, updatable = true)
	private String readableValue;

	@Column(name = "MA_MULTI", insertable = true, nullable = false, precision = 1, scale = 0, unique = false, updatable = true)
	private int multiColor;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MA_CREATION_DATE", insertable = true, nullable = false, unique = false, updatable = true)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MA_LAST_UPDATE_DATE", insertable = true, nullable = false, unique = false, updatable = true)
    private Date lastUpdateDate;

    @ManyToMany(mappedBy = "manaAbbreviations", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<Color> colors;

    public ManaAbbreviation() {
    }

    public ManaAbbreviation(Long inId, String inRepresentation, String inImgUrl, String inReadableValue, Date inCreationDate, Date inLastUpdateDate) {
    	this.id = inId;
    	this.representation = inRepresentation;
    	this.imageUrl = inImgUrl;
    	this.readableValue = inReadableValue;
    	this.creationDate = inCreationDate;
    	this.lastUpdateDate = inLastUpdateDate;
    }

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the representation
	 */
	public String getRepresentation() {
		return representation;
	}

	/**
	 * @param representation the representation to set
	 */
	public void setRepresentation(String representation) {
		this.representation = representation;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the readableValue
	 */
	public String getReadableValue() {
		return readableValue;
	}

	/**
	 * @param readableValue the readableValue to set
	 */
	public void setReadableValue(String readableValue) {
		this.readableValue = readableValue;
	}

	/**
	 * @return the multiColor
	 */
	public int getMultiColor() {
		return multiColor;
	}

	/**
	 * @param multiColor the multiColor to set
	 */
	public void setMultiColor(int multiColor) {
		this.multiColor = multiColor;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the lastUpdateDate
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ManaAbbreviation [id=");
		builder.append(id);
		builder.append(", representation=");
		builder.append(representation);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", readableValue=");
		builder.append(readableValue);
		builder.append(", multiColor=");
		builder.append(multiColor);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append(", lastUpdateDate=");
		builder.append(lastUpdateDate);
		builder.append("]");
		return builder.toString();
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
		if (!(obj instanceof ManaAbbreviation)) {
			return false;
		}
		ManaAbbreviation other = (ManaAbbreviation) obj;
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
