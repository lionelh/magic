/**
 * 
 */
package be.lionelh.magic.lsiting.data.ejb.utils;

import javax.inject.Named;

import be.lionelh.magic.listing.data.domain.entities.Artist;
import be.lionelh.magic.listing.data.domain.entities.Block;
import be.lionelh.magic.listing.data.domain.entities.Capacity;
import be.lionelh.magic.listing.data.domain.entities.Card;
import be.lionelh.magic.listing.data.domain.entities.CardEdition;
import be.lionelh.magic.listing.data.domain.entities.Color;
import be.lionelh.magic.listing.data.domain.entities.Edition;
import be.lionelh.magic.listing.data.domain.entities.Family;
import be.lionelh.magic.listing.data.domain.entities.Rarity;
import be.lionelh.magic.listing.data.domain.entities.TypeCard;
import be.lionelh.magic.lsiting.data.ejb.client.dto.ArtistDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.BlockDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.CapacityDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.CardDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.CardEditionDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.ColorDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.EditionDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.FamilyDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.RarityDTO;
import be.lionelh.magic.lsiting.data.ejb.client.dto.TypeCardDTO;

/**
 * @author Lionel
 */
@Named("DTOConverter")
public class DTOConverter {

	public ArtistDTO getArtistDTO(Artist inArtist) {
		ArtistDTO art =  new ArtistDTO();
		return art;
	}

	public Artist getArtist(ArtistDTO inArtist) {
		Artist art = new Artist();
		return art;
	}

	public BlockDTO getBlockDTO(Block inBlock) {
		BlockDTO b =  new BlockDTO();
		return b;
	}

	public Block getBlock(BlockDTO inBlock) {
		Block b = new Block();
		return b;
	}

	public CapacityDTO getCapacityDTO(Capacity inCapacity) {
		CapacityDTO c =  new CapacityDTO();
		return c;
	}

	public Capacity getCapacity(CapacityDTO inCapacity) {
		Capacity c = new Capacity();
		return c;
	}

	public CardDTO getCardDTO(Card inCard) {
		CardDTO c =  new CardDTO();
		return c;
	}

	public Card getCard(CardDTO inCard) {
		Card c = new Card();
		return c;
	}

	public CardEditionDTO getCardEditionDTO(CardEdition inCardEdition) {
		CardEditionDTO c =  new CardEditionDTO();
		return c;
	}

	public CardEdition getCardEdition(CardEditionDTO inCardEdition) {
		CardEdition c = new CardEdition();
		return c;
	}

	public ColorDTO getColorDTO(Color inColor) {
		ColorDTO c =  new ColorDTO();
		return c;
	}

	public Color getColor(ColorDTO inColor) {
		Color c = new Color();
		return c;
	}

	public EditionDTO getEditionDTO(Edition inEdition) {
		EditionDTO e =  new EditionDTO();
		return e;
	}

	public Edition getEdition(EditionDTO inEdition) {
		Edition e = new Edition();
		return e;
	}

	public FamilyDTO getFamilyDTO(Family inFamily) {
		FamilyDTO f =  new FamilyDTO();
		return f;
	}

	public Family getFamily(FamilyDTO inFamily) {
		Family f = new Family();
		return f;
	}

	public RarityDTO getRarityDTO(Rarity inRarity) {
		RarityDTO r =  new RarityDTO();
		return r;
	}

	public Rarity getRarity(RarityDTO inRarity) {
		Rarity r = new Rarity();
		return r;
	}

	public TypeCardDTO getTypeCardDTO(TypeCard inTypeCard) {
		TypeCardDTO tc =  new TypeCardDTO();
		return tc;
	}

	public TypeCard getTypeCard(TypeCardDTO inTypeCard) {
		TypeCard tc = new TypeCard();
		return tc;
	}
}
