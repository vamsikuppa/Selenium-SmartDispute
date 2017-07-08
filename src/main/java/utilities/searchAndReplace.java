package utilities;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.junit.Test;

public class searchAndReplace {
    private BufferedReader br;
    private ArrayList<String> TClist;
    private ArrayList<String> excellist;
    private String projectPath = System.getProperty("user.dir");
    private File featureFolder = new File(projectPath.concat("\\features"));


    Map<String, String> testcases = new HashMap<String, String>();

    @Test
    public void findTestCasesandIds() throws IOException {
        listFilesForFolder(featureFolder);
        printTestCases(testcases);
    }

    private void printTestCases(Map<String, String> testcases) {

        for (Map.Entry<String, String> entry : testcases.entrySet())
            System.out.println(entry.getKey() + "=" + entry.getValue());
    }

    public void listFilesForFolder(final File featurePath) throws IOException {
        for (final File fileEntry : featurePath.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                testCaseIdMatch(fileEntry.getPath());

            }
        }
    }

    public void testCaseIdMatch(String featurePath) throws IOException {

        Pattern pattern1 = Pattern.compile("TC-[0-9]+");
        Pattern pattern2 = Pattern.compile("Scenario: .*");
        br = new BufferedReader(new FileReader(featurePath));
        String line, key = null, value = null;
        while ((line = br.readLine()) != null) {
            Matcher m1 = pattern1.matcher(line);
            while (m1.find()) {
                int startindex = m1.start(0);
                int endindex = m1.end(0);
                key = line.substring(startindex, endindex);
            }
            Matcher m2 = pattern2.matcher(line);
            while (m2.find()) {
                int startindex = m2.start(0);
                int endindex = m2.end(0);
                value = line.substring(startindex + 10, endindex);
            }
            if (key != null && value != null)
                testcases.put(key, value);
        }

    }


    /*String str = "abcde";
    char[] tmparray = new char[str.length()];
    char[] rev = new char[str.length()];
    int count = str.length();

    @Test
    public void rev() {
        tmparray = str.toCharArray();
        int mid = str.length() / 2;
        for (int i = 0; i != mid; i++) {
            char temp = tmparray[i];
            tmparray[i] = tmparray[count - 1];
            tmparray[count - 1] = temp;
            count--;
        }
        System.out.println(tmparray);
    }*/





	
	/*@Test
    public void excelDataRead() throws IOException {
		String excelpath = projectPath.concat("\\Data\\TestList.xls");
		FileInputStream inputstream = new FileInputStream(excelpath);
		Workbook wb = getWorkBook(inputstream,excelpath);
		Sheet firstsheet = wb.getSheet("Sheet1");
		Iterator<Row> itr = firstsheet.iterator();
		while(itr.hasNext()) {
			Row currentrow =  itr.next();
			if(currentrow.getRowNum()==0) {
				continue;
			}
			Iterator<Cell> currentcell = currentrow.cellIterator();
			
			while(currentcell.hasNext()) {
				Cell cell = currentcell.next();
				System.out.println(cell.getCellType());
				excellist.add(cell.getStringCellValue());
			}
			
		}
			
		//System.out.println(excellist);
	}

	private Workbook getWorkBook(FileInputStream inputstream, String excelpath) throws IOException {
		// TODO Auto-generated method stub
		Workbook workbook = null;
		
		if(excelpath.endsWith("xlsx")) {
			//workbook = new XSSFWorkbook(inputstream);
		}
		
		if(excelpath.endsWith("xls")|| excelpath.endsWith("csv")) {
			workbook = new HSSFWorkbook(inputstream);
		}
		return workbook;
	}*/
}



