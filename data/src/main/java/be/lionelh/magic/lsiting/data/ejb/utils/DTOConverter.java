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
		art.setCreationDate(inArtist.getCreationDate());
		art.setId(inArtist.getId());
		art.setLastUpdateDate(inArtist.getLastUpdateDate());
		art.setName(inArtist.getName());
		return art;
	}

	public Artist getArtist(ArtistDTO inArtist) {
		Artist art = new Artist();
		art.setCreationDate(inArtist.getCreationDate());
		art.setId(inArtist.getId());
		art.setLastUpdateDate(inArtist.getLastUpdateDate());
		art.setName(inArtist.getName());
		return art;
	}

	public BlockDTO getBlockDTO(Block inBlock) {
		BlockDTO b =  new BlockDTO();
		b.setCreationDate(inBlock.getCreationDate());
		b.setId(inBlock.getId());
		b.setLastUpdateDate(inBlock.getLastUpdateDate());
		b.setName(inBlock.getName());
		b.setNom(inBlock.getNom());
		return b;
	}

	public Block getBlock(BlockDTO inBlock) {
		Block b = new Block();
		b.setCreationDate(inBlock.getCreationDate());
		b.setId(inBlock.getId());
		b.setLastUpdateDate(inBlock.getLastUpdateDate());
		b.setName(inBlock.getName());
		b.setNom(inBlock.getNom());
		return b;
	}

	public CapacityDTO getCapacityDTO(Capacity inCapacity) {
		CapacityDTO c =  new CapacityDTO();
		c.setCreationDate(inCapacity.getCreationDate());
		c.setId(inCapacity.getId());
		c.setLastUpdateDate(inCapacity.getLastUpdateDate());
		c.setName(inCapacity.getName());
		c.setNom(inCapacity.getNom());
		return c;
	}

	public Capacity getCapacity(CapacityDTO inCapacity) {
		Capacity c = new Capacity();
		c.setCreationDate(inCapacity.getCreationDate());
		c.setId(inCapacity.getId());
		c.setLastUpdateDate(inCapacity.getLastUpdateDate());
		c.setName(inCapacity.getName());
		c.setNom(inCapacity.getNom());
		return c;
	}

	public CardDTO getCardDTO(Card inCard) {
		CardDTO c =  new CardDTO();
		c.setColor(getColorDTO(inCard.getColor()));
		c.setCreationDate(inCard.getCreationDate());
		c.setId(inCard.getId());
		c.setLastUpdateDate(inCard.getLastUpdateDate());
		c.setName(inCard.getName());
		c.setNom(inCard.getNom());
		c.setText(inCard.getText());
		c.setTypeCard(getTypeCardDTO(inCard.getTypeCard()));
		return c;
	}

	public Card getCard(CardDTO inCard) {
		Card c = new Card();
		c.setColor(getColor(inCard.getColor()));
		c.setCreationDate(inCard.getCreationDate());
		c.setId(inCard.getId());
		c.setLastUpdateDate(inCard.getLastUpdateDate());
		c.setName(inCard.getName());
		c.setNom(inCard.getNom());
		c.setText(inCard.getText());
		c.setTypeCard(getTypeCard(inCard.getTypeCard()));
		return c;
	}

	public CardEditionDTO getCardEditionDTO(CardEdition inCardEdition) {
		CardEditionDTO c =  new CardEditionDTO();
		c.setCard(getCardDTO(inCardEdition.getCard()));
		c.setCost(inCardEdition.getCost());
		c.setCreationDate(inCardEdition.getCreationDate());
		c.setEdition(getEditionDTO(inCardEdition.getEdition()));
		c.setLastUpdateDate(inCardEdition.getLastUpdateDate());
		c.setLoyalty(inCardEdition.getLoyalty());
		c.setPower(inCardEdition.getPower());
		c.setRarity(getRarityDTO(inCardEdition.getRarity()));
		c.setToughness(inCardEdition.getToughness());
		c.setVersions(inCardEdition.getVersions());
		return c;
	}

	public CardEdition getCardEdition(CardEditionDTO inCardEdition) {
		CardEdition c = new CardEdition();
		c.setCard(getCard(inCardEdition.getCard()));
		c.setCost(inCardEdition.getCost());
		c.setCreationDate(inCardEdition.getCreationDate());
		c.setEdition(getEdition(inCardEdition.getEdition()));
		c.setLastUpdateDate(inCardEdition.getLastUpdateDate());
		c.setLoyalty(inCardEdition.getLoyalty());
		c.setPower(inCardEdition.getPower());
		c.setRarity(getRarity(inCardEdition.getRarity()));
		c.setToughness(inCardEdition.getToughness());
		c.setVersions(inCardEdition.getVersions());
		return c;
	}

	public ColorDTO getColorDTO(Color inColor) {
		ColorDTO c =  new ColorDTO();
		c.setAbbreviation(inColor.getAbbreviation());
		c.setCreationDate(inColor.getCreationDate());
		c.setId(inColor.getId());
		c.setLastUpdateDate(inColor.getLastUpdateDate());
		c.setName(inColor.getName());
		c.setNom(inColor.getNom());
		return c;
	}

	public Color getColor(ColorDTO inColor) {
		Color c = new Color();
		c.setAbbreviation(inColor.getAbbreviation());
		c.setCreationDate(inColor.getCreationDate());
		c.setId(inColor.getId());
		c.setLastUpdateDate(inColor.getLastUpdateDate());
		c.setName(inColor.getName());
		c.setNom(inColor.getNom());
		return c;
	}

	public EditionDTO getEditionDTO(Edition inEdition) {
		EditionDTO e =  new EditionDTO();
		e.setAbbreviation(inEdition.getAbbreviation());
		e.setBlock(getBlockDTO(inEdition.getBlock()));
		e.setCreationDate(inEdition.getCreationDate());
		e.setDateOut(inEdition.getDateOut());
		e.setId(inEdition.getId());
		e.setLastUpdateDate(inEdition.getLastUpdateDate());
		e.setName(inEdition.getName());
		e.setNom(inEdition.getNom());
		e.setSymbol(inEdition.getSymbol());
		return e;
	}

	public Edition getEdition(EditionDTO inEdition) {
		Edition e = new Edition();
		e.setAbbreviation(inEdition.getAbbreviation());
		e.setBlock(getBlock(inEdition.getBlock()));
		e.setCreationDate(inEdition.getCreationDate());
		e.setDateOut(inEdition.getDateOut());
		e.setId(inEdition.getId());
		e.setLastUpdateDate(inEdition.getLastUpdateDate());
		e.setName(inEdition.getName());
		e.setNom(inEdition.getNom());
		e.setSymbol(inEdition.getSymbol());
		return e;
	}

	public FamilyDTO getFamilyDTO(Family inFamily) {
		FamilyDTO f =  new FamilyDTO();
		f.setCreationDate(inFamily.getCreationDate());
		f.setId(inFamily.getId());
		f.setLastUpdateDate(inFamily.getLastUpdateDate());
		f.setName(inFamily.getName());
		f.setNom(inFamily.getNom());
		return f;
	}

	public Family getFamily(FamilyDTO inFamily) {
		Family f = new Family();
		f.setCreationDate(inFamily.getCreationDate());
		f.setId(inFamily.getId());
		f.setLastUpdateDate(inFamily.getLastUpdateDate());
		f.setName(inFamily.getName());
		f.setNom(inFamily.getNom());
		return f;
	}

	public RarityDTO getRarityDTO(Rarity inRarity) {
		RarityDTO r =  new RarityDTO();
		r.setAbbreviation(inRarity.getAbbreviation());
		r.setCreationDate(inRarity.getCreationDate());
		r.setDescription(inRarity.getDescription());
		r.setId(inRarity.getId());
		r.setLastUpdateDate(inRarity.getLastUpdateDate());
		return r;
	}

	public Rarity getRarity(RarityDTO inRarity) {
		Rarity r = new Rarity();
		r.setAbbreviation(inRarity.getAbbreviation());
		r.setCreationDate(inRarity.getCreationDate());
		r.setDescription(inRarity.getDescription());
		r.setId(inRarity.getId());
		r.setLastUpdateDate(inRarity.getLastUpdateDate());
		return r;
	}

	public TypeCardDTO getTypeCardDTO(TypeCard inTypeCard) {
		TypeCardDTO tc =  new TypeCardDTO();
		tc.setCreationDate(inTypeCard.getCreationDate());
		tc.setId(inTypeCard.getId());
		tc.setLastUpdateDate(inTypeCard.getLastUpdateDate());
		tc.setName(inTypeCard.getName());
		tc.setNom(inTypeCard.getNom());
		return tc;
	}

	public TypeCard getTypeCard(TypeCardDTO inTypeCard) {
		TypeCard tc = new TypeCard();
		tc.setCreationDate(inTypeCard.getCreationDate());
		tc.setId(inTypeCard.getId());
		tc.setLastUpdateDate(inTypeCard.getLastUpdateDate());
		tc.setName(inTypeCard.getName());
		tc.setNom(inTypeCard.getNom());
		return tc;
	}
}
