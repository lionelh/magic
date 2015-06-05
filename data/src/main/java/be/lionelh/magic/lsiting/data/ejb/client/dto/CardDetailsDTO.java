package be.lionelh.magic.lsiting.data.ejb.client.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class CardDetailsDTO implements Serializable {

	private List<CardEditionDTO> cardEditions;

	public CardDetailsDTO() { }

	/**
	 * @return the cardEditions
	 */
	public List<CardEditionDTO> getCardEditions() {
		return cardEditions;
	}

	/**
	 * @param cardEditions the cardEditions to set
	 */
	public void setCardEditions(List<CardEditionDTO> cardEditions) {
		this.cardEditions = cardEditions;
	}

}
