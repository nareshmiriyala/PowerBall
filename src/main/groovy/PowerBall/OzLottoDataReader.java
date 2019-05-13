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
class OzLottoDataReader {

    public List<OzLottoResult> readerDataFromCSV(String path){
        Reader in = null;
        List<OzLottoResult> ozResults = new ArrayList<>();
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
           ozResults.add(createOzLottoRecord(record));
        }
        return ozResults;
    }

    private OzLottoResult createOzLottoRecord(CSVRecord record) {
        OzLottoResult ozResult=new OzLottoResult();
        ozResult.setDrawDate(parsedDate(record.get(0)));

        ozResult.setNumberOne(Integer.parseInt(getParsedRecord(record, 1)));
        ozResult.setNumberTwo(Integer.parseInt(getParsedRecord(record, 2)));
        ozResult.setNumberThree(Integer.parseInt(getParsedRecord(record, 3)));
        ozResult.setNumberFour(Integer.parseInt(getParsedRecord(record, 4)));
        ozResult.setNumberFive(Integer.parseInt(getParsedRecord(record, 5)));
        ozResult.setNumberSix(Integer.parseInt(getParsedRecord(record, 6)));
        ozResult.setNumberSeven(Integer.parseInt(getParsedRecord(record, 7)));
        ozResult.setSupplOne(Integer.parseInt(getParsedRecord(record, 8)));
        ozResult.setSuppTwo(Integer.parseInt(getParsedRecord(record, 9)));

        return ozResult;
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
