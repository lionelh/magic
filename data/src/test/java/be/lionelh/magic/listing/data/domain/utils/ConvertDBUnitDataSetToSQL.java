package be.lionelh.magic.listing.data.doamin.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ConvertDBUnitDataSetToSQL {

	public ConvertDBUnitDataSetToSQL() {
	}

	public static void main(String[] args) {
		try {
			new ConvertDBUnitDataSetToSQL().convert();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void convert() throws Exception {
		BufferedWriter output = new BufferedWriter(new FileWriter("insert.sql"));
		BufferedReader input = new BufferedReader(new FileReader("C:/javadev/prj-git/magic/data/src/test/resources/dataset.xml"));
		String line;
		while((line = input.readLine()) != null) {
			if (line.toLowerCase().contains("<magic_color ")) {
				processColor(line.trim(), output);
			} else if (line.toLowerCase().contains("<magic_type_card ")) {
				processTypeCard(line.trim(), output);
			} else if (line.toLowerCase().contains("<magic_card ")) {
				processCard(line.trim(), output);
			} else if (line.toLowerCase().contains("<magic_edition ")) {
				processEdition(line.trim(), output);
			} else if (line.toLowerCase().contains("<magic_family ")) {
				processFamily(line.trim(), output);
			} else if (line.toLowerCase().contains("<magic_card_family ")) {
				processCardFamily(line.trim(), output);
			} else if (line.toLowerCase().contains("<magic_rarity ")) {
				processRarity(line.trim(), output);
			} else if (line.toLowerCase().contains("<magic_card_edition ")) {
				processCardEdition(line.trim(), output);
			} else if (line.toLowerCase().contains("<magic_artist ")) {
				processArtist(line.trim(), output);
			} else if (line.toLowerCase().contains("<magic_card_edition_artist ")) {
				processCardEditionArtist(line.trim(), output);
			}
		}

		input.close();
		output.close();
	}

	private void processColor(String inColor, BufferedWriter inOutput) throws Exception {
		String startLine = "INSERT INTO magic_color (co_id,co_name,co_abbreviation,co_creation_date,co_last_update_date) VALUES ";
		String line = inColor.replace("co_id=\"", "(").replace("\" co_name=", ",").replace(" co_creation_date=", ",").replace(" co_last_update_date=", ",").replace(" />", ");").replace(" co_abbreviation=", ",").replace("<magic_color ", startLine);
		line = line.replaceAll("'", "''").replaceAll("\"", "'");
		inOutput.write(line);
		inOutput.newLine();
		inOutput.flush();
	}

	private void processTypeCard(String inTypeCard, BufferedWriter inOutput) throws Exception {
		String startLine = "INSERT INTO magic_type_card (tc_id,tc_name,tc_creation_date,tc_last_update_date) VALUES ";
		String line = inTypeCard.replace("tc_id=\"", "(").replace("\" tc_name=", ",").replace(" tc_creation_date=", ",").replace(" tc_last_update_date=", ",").replace(" />", ");").replace("<magic_type_card ", startLine);
		line = line.replaceAll("'", "''").replaceAll("\"", "'");
		inOutput.write(line);
		inOutput.newLine();
		inOutput.flush();
	}

	private void processCard(String inCard, BufferedWriter inOutput) throws Exception {
		String startLine = "INSERT INTO magic_card (ca_id,ca_name,ca_creation_date,ca_last_update_date,ca_co_id,ca_tc_id) VALUES ";
		String line = inCard.replace("ca_id=\"", "(").replace("\" ca_name=", ",").replace(" ca_creation_date=", ",").replace(" ca_last_update_date=", ",").replace(" ca_co_id=\"", ",").replace("\" ca_tc_id=\"", ",").replace("\" />", ");").replace("<magic_card ", startLine);
		line = line.replaceAll("'", "''").replaceAll("\"", "'");
		inOutput.write(line);
		inOutput.newLine();
		inOutput.flush();
	}

	private void processEdition(String inEdition, BufferedWriter inOutput) throws Exception {
		String startLine = "INSERT INTO magic_edition (ed_id,ed_name,ed_creation_date,ed_last_update_date,ed_symbol,ed_nom,ed_abbreviation) VALUES ";
		String line = inEdition.replace("ed_id=\"", "(").replace("\" ed_name=", ",").replace(" ed_creation_date=", ",").replace(" ed_last_update_date=", ",").replace(" ed_symbol=\"", ",").replace("\" ed_nom=", ",").replace(" ed_abbreviation=", ",").replace(" />", ");").replace("<magic_edition ", startLine);
		line = line.replaceAll("'", "''").replaceAll("\"", "'");
		inOutput.write(line);
		inOutput.newLine();
		inOutput.flush();
	}

	private void processFamily(String inFamily, BufferedWriter inOutput) throws Exception {
		String startLine = "INSERT INTO magic_family (fa_id,fa_name,fa_creation_date,fa_last_update_date) VALUES ";
		String line = inFamily.replace("fa_id=\"", "(").replace("\" fa_name=", ",").replace(" fa_creation_date=", ",").replace(" fa_last_update_date=", ",").replace(" />", ");").replace("<magic_family ", startLine);
		line = line.replaceAll("'", "''").replaceAll("\"", "'");
		inOutput.write(line);
		inOutput.newLine();
		inOutput.flush();
	}

	private void processCardFamily(String inCardFamily, BufferedWriter inOutput) throws Exception {
		String startLine = "INSERT INTO magic_card_family (caf_ca_id,caf_fa_id) VALUES ";
		String line = inCardFamily.replace("caf_ca_id=\"", "(").replace("\" caf_fa_id=\"", ",").replace("\" />", ");").replace("<magic_card_family ", startLine);
		line = line.replaceAll("'", "''").replaceAll("\"", "'");
		inOutput.write(line);
		inOutput.newLine();
		inOutput.flush();
	}

	private void processRarity(String inRarity, BufferedWriter inOutput) throws Exception {
		String startLine = "INSERT INTO magic_rarity (ra_id,ra_abbreviation,ra_creation_date,ra_last_update_date) VALUES ";
		String line = inRarity.replace("ra_id=\"", "(").replace("\" ra_abbreviation=", ",").replace(" ra_creation_date=", ",").replace(" ra_last_update_date=", ",").replace(" />", ");").replace("<magic_rarity ", startLine);
		line = line.replaceAll("'", "''").replaceAll("\"", "'");
		inOutput.write(line);
		inOutput.newLine();
		inOutput.flush();
	}

	//<magic_card_edition ce_ca_id="1" ce_ed_id="1" ce_versions="1" ce_ra_id="1" ce_creation_date="2015-02-24 16:13:57" ce_last_update_date="2015-02-24 16:13:57" ce_cost="1"    />
	private void processCardEdition(String inCardEdition, BufferedWriter inOutput) throws Exception {
		String startLine = "INSERT INTO magic_card_edition (ce_ca_id,ce_ed_id,ce_versions,ce_ra_id,ce_creation_date,ce_last_update_date";
		if (inCardEdition.contains("ce_cost")) {
			startLine += ",ce_cost";
		}
		if (inCardEdition.contains("ce_power")) {
			startLine += ",ce_power";
		}
		if (inCardEdition.contains("ce_toughness")) {
			startLine += ",ce_toughness";
		}
		startLine += ") VALUES ";
		String line = inCardEdition.replace("ce_ca_id=\"", "(").replace("\" ce_ed_id=\"", ",").replace("\" ce_versions=\"", ",").replace("\" ce_ra_id=\"", ",").replace("\" ce_creation_date=", ",").replace(" ce_last_update_date=", ",").replace(" ce_cost=", ",").replace(" ce_power=", ",").replace(" ce_toughness=", ",").replace(" />", ");").replace("<magic_card_edition ", startLine);
		line = line.replaceAll("'", "''").replaceAll("\"", "'");
		inOutput.write(line);
		inOutput.newLine();
		inOutput.flush();
	}

	private void processArtist(String inArtist, BufferedWriter inOutput) throws Exception {
		String startLine = "INSERT INTO magic_artist (art_id,art_name,art_creation_date,art_last_update_date) VALUES ";
		String line = inArtist.replace("art_id=\"", "(").replace("\" art_name=", ",").replace(" art_creation_date=", ",").replace(" art_last_update_date=", ",").replace(" />", ");").replace("<magic_artist ", startLine);
		line = line.replaceAll("'", "''").replaceAll("\"", "'");
		inOutput.write(line);
		inOutput.newLine();
		inOutput.flush();
	}

	private void processCardEditionArtist(String inCardEditionArtist, BufferedWriter inOutput) throws Exception {
		String startLine = "INSERT INTO magic_card_edition_artist (cea_ca_id,cea_ed_id,cea_art_id) VALUES ";
		String line = inCardEditionArtist.replace("cea_ca_id=\"", "(").replace("\" cea_ed_id=\"", ",").replace("\" cea_art_id=\"", ",").replace("\" />", ");").replace("<magic_card_edition_artist ", startLine);
		line = line.replaceAll("'", "''").replaceAll("\"", "'");
		inOutput.write(line);
		inOutput.newLine();
		inOutput.flush();
	}
}
