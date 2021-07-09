package com.example.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class ExcelReportGenerationServiceImpl {


	@Autowired
    private ApplicationProps props;
 

    /**
     * @param List<ExcelGenerationRequest>, list of excel sheets
     * @param ReportType,                   report type to be generated
     * @param HttpServletResponse,          httpServletResponse to write excel contents
     * @throws UnableToGenerateReport
     */
    public void generateExcel(List<ExcelContents> request,
    		ServerHttpResponse response)
        throws  Exception {
    	
    	HttpHeaders responseHeaders  = response.getHeaders();
    	
    		
         String headerKey = VSPConstants.CONTENT_DISPOSITION;
         String headerValue = VSPConstants.FILENAME + getFileName();
//         responseHeaders.setHeader(headerKey, headerValue);
//        response.setHeader(headerKey, headerValue);
         responseHeaders.set(headerKey, headerValue);
         responseHeaders.setContentType(
                 MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));


        // get report header
        String[] excelHeader = getColumns();

        List<Map<Integer, String[]>> listOfExcelSheets = getExcelContents(request, excelHeader);

        try (XSSFWorkbook workBook = new XSSFWorkbook()) {

            List<Integer> sheetName = new ArrayList<>();
            sheetName.add(1);

            listOfExcelSheets.forEach(eachSheet -> {

                XSSFSheet spreadsheet = workBook.createSheet("Sheet" + sheetName.get(0));
                XSSFRow row;

                Set<Integer> keyid = eachSheet.keySet();
                int rowid = 0;

                for (Integer key : keyid) {
                    row = spreadsheet.createRow(rowid++);
                    String[] eachRowData = eachSheet.get(key);
                    int cellid = 0;

                    for (String eachCell : eachRowData) {
                        Cell cell = row.createCell(cellid++);
                        if (null != eachCell) {
                            String cellValue = eachCell;
                            cell.setCellValue(cellValue);
                        }
                    }
                }
                sheetName.set(0, sheetName.get(0) + 1);
            });

            // write contents into HttpServletResponse
            writeContentsAsServletResponse( response, workBook);

        } catch (Exception ex) {
          //  log.error("Exception occured while generating excel file for report type {}", type);
         ///   log.error(VSPConstants.EXCEPTION, ex);
       //     throw new UnableToGenerateReport("Unable to generate report, please try again later");
        }

    }

    private void writeContentsAsServletResponse( ServerHttpResponse  response, XSSFWorkbook workBook) {
        try (ByteArrayOutputStream outByteStream = new ByteArrayOutputStream()) {
            workBook.write(outByteStream);

            byte[] outArray = outByteStream.toByteArray();
            OutputStream outStream = response.bufferFactory().allocateBuffer().asOutputStream();
            outStream.write(outArray);
            outStream.flush();
            workBook.close();
        } catch (IOException ex) {
          //  log.error("Exception occured forming HttpServletResponse for report type {}", type);
           // log.error(VSPConstants.EXCEPTION, ex);
        }
    }

    private List<Map<Integer, String[]>> getExcelContents(List<ExcelContents> request, String[] excelHeader) {

        List<Map<Integer, String[]>> listOfSheets = new ArrayList<>();

        request.forEach(eachSheet -> {

            Map<Integer, String[]> excelContentsMap = new TreeMap<>();
            excelContentsMap.put(1, excelHeader);
            List<Integer> rowNumList = new ArrayList<>();
            rowNumList.add(2);

            eachSheet.getExcelContents().forEach(eachRow -> {
                excelContentsMap.put(rowNumList.get(0), eachRow);
                rowNumList.set(0, rowNumList.get(0) + 1);
            });

            listOfSheets.add(excelContentsMap);

        });

        return listOfSheets;
    }

    private String[] getColumns() {
    	 String[] columnHeader = new String[10];
    	 columnHeader[0] = ReportType.RESET_ID.name();
    	 columnHeader[1] = ReportType.STORE_NUMBER.name();
    	 columnHeader[2] = ReportType.INSTANCE_ID.name();
    	 columnHeader[3] = ReportType.AILE.name();
    	 columnHeader[4] = ReportType.POG_FLOW_BAY.name();
    	 columnHeader[5] = ReportType.MPOG_NAME.name();
    	 columnHeader[6] = ReportType.FIXTURE_HWD.name();
    	 columnHeader[7] = ReportType.MULTIPROGRAM.name();
    	 columnHeader[8] = ReportType.MPOG_FUTURE.name();
    	 columnHeader[9] = ReportType.POG_FLOW_FUTURE.name();
    	 
    	 return columnHeader;
    	 
//        switch (reportType) {
//            case RESET_ID:
//                return props.getExcelHeader().getResetId();
//            case STORE_NUMBER:
//                return props.getExcelHeader().getStoreNumber();
//            case INSTANCE_ID:
//                return props.getExcelHeader().getInstanceId();
//            case AILE:
//                return props.getExcelHeader().getAile();
//            case POG_FLOW_BAY:
//                return props.getExcelHeader().getPogFlow();
//            case MPOG_ID:
//                return props.getExcelHeader().getMpogId();
//            case MPOG_NAME:
//                return props.getExcelHeader().getMpogName();
//            case FIXTURE_HWD:
//                return props.getExcelHeader().getFixtureHwd();
//            case MULTIPROGRAM:
//                return props.getExcelHeader().getMultiprogram();
//            case MPOG_FUTURE:
//                return props.getExcelHeader().getMpogFuture();
//            case POG_FLOW_FUTURE:
//                return props.getExcelHeader().getPogFlowFuture();
//                
//                
//            default:
//                String[] temp = null;
//                return temp;
         
    }

    private String getFileName() {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String currentDateTimeStr = currentDateTime.replace(" ", "_");
        return "BulkUpload" + "_" + currentDateTimeStr + ".xlsx";
    }
}
