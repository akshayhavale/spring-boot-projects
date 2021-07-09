package com.example.demo;

 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExcelUtil {

	private XSSFFormulaEvaluator evaluator;
	private DataFormatter formatter;

	public  static int determineRowCount(XSSFWorkbook workbook){
		evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		formatter = new DataFormatter( true );
		XSSFSheet sheet = workbook.getSheetAt(0);
		int lastRowIndex = -1;
		if( sheet.getPhysicalNumberOfRows() > 0 ){
			// getLastRowNum() actually returns an index, not a row number
			lastRowIndex = sheet.getLastRowNum();
			// now, start at end of spreadsheet and work our way backwards until we find a row having data
			for( ; lastRowIndex >= 0; lastRowIndex-- ){
				Row row = sheet.getRow( lastRowIndex );
				if( !isRowEmpty( row ) ){
					break;
				}
			}
		}
		return lastRowIndex;
	}
	private boolean isRowEmpty( Row row )
	{
		if( row == null ){
			return true;
		}

		int cellCount = row.getLastCellNum() + 1;
		for( int i = 0; i < cellCount; i++ ){
			String cellValue = getCellValue( row, i );
			if( cellValue != null && cellValue.length() > 0 ){
				return false;
			}
		}
		return true;
	}

	public static String getCellValue( Row row, int columnIndex ){
		String cellValue;
		Cell cell = row.getCell( columnIndex );
		if( cell == null ){
			// no data in this cell
			cellValue = null;
		}
		else{
			if( cell.getCellType() != CellType.FORMULA){
				// cell has a value, so format it into a string
				cellValue = formatter.formatCellValue( cell );
			}
			else {
				// cell has a formula, so evaluate it
				cellValue = formatter.formatCellValue( cell, evaluator );
			}
		}
		return cellValue;
	}

}
