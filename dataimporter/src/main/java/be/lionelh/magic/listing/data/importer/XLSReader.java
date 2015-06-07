package be.lionelh.magic.listing.data.importer;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSReader {

	public static void main(String[] args) {
		try {
			new XLSReader().read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void read() throws Exception {
		FileInputStream file = new FileInputStream(new File(
				"c:\\users\\lionel\\desktop\\master_new.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int cardToProcess = 0;
		String[] edtToProcess = "4E,5E,6E,7E,8E,9E,10E,A,AL,ALA,AN,AP,AQ,ARB,AVR,B,BNG,BOK,CFX,CHK,CS,DGM,DIS,DK,DKA,DS,DTK,EVE,EX,FD,FE,FRF,FUT,GP,GTC,HL,IA,IN,ISD,JOU,JU,KTK,LE,LG,LRW,M10,M11,M12,M13,M14,M15,MBS,MI,MM,MOR,MR,NE,NPH,OD,ON,P2,P3,PLC,PS,PT,PY,R,RAV,ROE,RTR,SC,SH,SHM,SOK,SOM,TE,THS,TO,TSB,TSP,U,UD,UL,US,VI,WL,WWK,ZEN"
				.split(",");
		List<String> editionsToProcess = Arrays.asList(edtToProcess);
		for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
			// Start at row 1 to skip the header row
			Row r = sheet.getRow(rowNum);
			String edition = r.getCell(1).getStringCellValue();
			if (editionsToProcess.contains(edition)) {
				cardToProcess++;
				Iterator<Cell> itCell = r.cellIterator();
				int cellNum = 0;

				// Name Edition Cost Rarity Color P/T Type Artist Text
				while (itCell.hasNext()) {
					Cell c = itCell.next();
					switch (cellNum) {
					case 0: // name
						System.out.println((rowNum + 1) + " => "
								+ c.getStringCellValue());
						break;
					case 1: // edition
						break;
					case 2: // cost
						break;
					case 3: // rarity
						break;
					case 4: // color
						break;
					case 5: // P/T
						break;
					case 6: // type
						break;
					case 7: // artist
						break;
					case 8: // text
						break;
					}
					cellNum++;
				}
			}
		}
		System.out.println("card to Process : " + cardToProcess);
		workbook.close();
		file.close();
	}
}
