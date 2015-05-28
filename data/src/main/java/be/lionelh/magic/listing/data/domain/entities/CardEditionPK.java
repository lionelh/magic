package be.lionelh.magic.listing.data.domain.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author Lionel
 */
@SuppressWarnings("serial")
@Embeddable
public class CardEditionPK implements Serializable {

	private Long cardId;
	private Long editionId;

	public CardEditionPK() {
		super();
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public Long getEditionId() {
		return editionId;
	}

	public void setEditionId(Long editionId) {
		this.editionId = editionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardId == null) ? 0 : cardId.hashCode());
		result = prime * result + ((editionId == null) ? 0 : editionId.hashCode());
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
		if (!(obj instanceof CardEditionPK)) {
			return false;
		}
		CardEditionPK other = (CardEditionPK) obj;
		if (cardId == null) {
			if (other.cardId != null) {
				return false;
			}
		} else if (!cardId.equals(other.cardId)) {
			return false;
		}
		if (editionId == null) {
			if (other.editionId != null) {
				return false;
			}
		} else if (!editionId.equals(other.editionId)) {
			return false;
		}
		return true;
	}
}
