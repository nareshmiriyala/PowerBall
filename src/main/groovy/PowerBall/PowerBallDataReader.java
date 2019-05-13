package PowerBall;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * Created by nareshm on 12/11/2015.
 */
class PowerBallDataReader {

    public List<PowerBallResult> readerDataFromCSV(String path){
        Reader in = null;
        List<PowerBallResult> powerBallResults = new ArrayList<>();
        try {
            in = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Iterable<CSVRecord> records = null;
        try {
            records = CSVFormat.EXCEL.parse(Objects.requireNonNull(in));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CSVRecord record : Objects.requireNonNull(records)) {
            if(record.getRecordNumber()==1){
                continue;
            }
           powerBallResults.add(createPowerBallRecord(record));
        }
        return powerBallResults;
    }

    private PowerBallResult createPowerBallRecord(CSVRecord record) {
        PowerBallResult powerBallResult=new PowerBallResult();
        powerBallResult.setDrawDate(parsedDate(record.get(0)));

        powerBallResult.setNumberOne(Integer.parseInt(getParsedRecord(record, 1)));
        powerBallResult.setNumberTwo(Integer.parseInt(getParsedRecord(record, 2)));
        powerBallResult.setNumberThree(Integer.parseInt(getParsedRecord(record, 3)));
        powerBallResult.setNumberFour(Integer.parseInt(getParsedRecord(record, 4)));
        powerBallResult.setNumberFive(Integer.parseInt(getParsedRecord(record, 5)));
        powerBallResult.setNumberSix(Integer.parseInt(getParsedRecord(record, 6)));
        powerBallResult.setNumberSeven(Integer.parseInt(getParsedRecord(record, 7)));
        powerBallResult.setPowerBall(Integer.parseInt(getParsedRecord(record, 8)));

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
        SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");

        try {

            return fromUser.parse(inDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
