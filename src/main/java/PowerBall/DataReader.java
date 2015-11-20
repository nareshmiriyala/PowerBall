package PowerBall;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nareshm on 12/11/2015.
 */
public class DataReader {

    public List<PowerBallResult> readerDataFromCSV(String path){
        Reader in = null;
        List<PowerBallResult> powerBallResults=new ArrayList<PowerBallResult>();
        try {
            in = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Iterable<CSVRecord> records = null;
        try {
            records = CSVFormat.EXCEL.parse(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CSVRecord record : records) {
            if(record.getRecordNumber()==1){
                continue;
            }
           powerBallResults.add(createPowerBallRecord(record));
        }
        return powerBallResults;
    }

    private PowerBallResult createPowerBallRecord(CSVRecord record) {
        PowerBallResult powerBallResult=new PowerBallResult();
        powerBallResult.setId(Integer.parseInt(record.get(0)));
        powerBallResult.setDrawDate(parsedDate(record.get(1)));

            powerBallResult.setNumberOne(Integer.parseInt(getParsedRecord(record,2)));
            powerBallResult.setNumberTwo(Integer.parseInt(getParsedRecord(record,3)));
            powerBallResult.setNumberThree(Integer.parseInt(getParsedRecord(record,4)));
            powerBallResult.setNumberFour(Integer.parseInt(getParsedRecord(record,5)));
            powerBallResult.setNumberFive(Integer.parseInt(getParsedRecord(record,6)));
            powerBallResult.setNumberSix(Integer.parseInt(getParsedRecord(record,7)));
            powerBallResult.setPowerBall(Integer.parseInt(getParsedRecord(record,8)));
            powerBallResult.setDivisionOneMoney(BigDecimal.valueOf(Double.parseDouble(getParsedRecord(record,9))));
            powerBallResult.setDivisionTwoMoney(BigDecimal.valueOf(Double.parseDouble(getParsedRecord(record,10))));
            powerBallResult.setDivisionThreeMoney(BigDecimal.valueOf(Double.parseDouble(getParsedRecord(record,11))));
            powerBallResult.setDivisionFourMoney(BigDecimal.valueOf(Double.parseDouble(getParsedRecord(record,12))));
            powerBallResult.setDivisionFiveMoney(BigDecimal.valueOf(Double.parseDouble(getParsedRecord(record,13))));
            powerBallResult.setDivisionSixMoney(BigDecimal.valueOf(Double.parseDouble(getParsedRecord(record,14))));
            powerBallResult.setDivisionSevenMoney(BigDecimal.valueOf(Double.parseDouble(getParsedRecord(record,15))));

        return powerBallResult;
    }

    private String getParsedRecord(CSVRecord record,int number) {
        String s = record.get(number);
        String s1=s.replace("$","");
        String s2=s1.replace("-","");
        String fina=s2.replace(",","");
        if(fina.isEmpty()){
            fina="0";
        }
        return fina;
    }

    private Date parsedDate(String inDate){
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyyMMdd");

        try {

            return fromUser.parse(inDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
