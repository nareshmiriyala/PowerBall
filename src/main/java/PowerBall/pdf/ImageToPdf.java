package PowerBall.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nmiriyal on 9/02/2016.
 */
public class ImageToPdf {

    public static final String CONTRACT_OF_SALE = "C:\\Users\\nmiriyal\\Downloads\\Brady Road House Contract\\Contract Of Sale";
    public static final String CONTRACT_PDF = "C:\\Users\\nmiriyal\\Desktop\\contract.pdf";
    public static final String CONTRACT_REPLACE_STRING = "C:\\Users\\nmiriyal\\Downloads\\Brady Road House Contract\\Contract Of Sale\\108_Brady_Road_Page_";
    public static final String VENDOR_STATEMENT = "C:\\Users\\nmiriyal\\Downloads\\Brady Road House Contract\\Vendor Statement";
    public static final String VENDOR_STATEMENT_PDF = "C:\\Users\\nmiriyal\\Desktop\\Vendor_Statement.pdf";
    public static final String VENDOR_STATEMENT_REPLACE_STRING = "C:\\Users\\nmiriyal\\Downloads\\Brady Road House Contract\\Vendor Statement\\Vendor_statement_Page_";

    public static void main(String[] args) throws DocumentException, IOException {
        createPDF(CONTRACT_PDF, CONTRACT_OF_SALE, CONTRACT_REPLACE_STRING);
        createPDF(VENDOR_STATEMENT_PDF, VENDOR_STATEMENT, VENDOR_STATEMENT_REPLACE_STRING);

    }

    private static void createPDF(String pdfPath, String folderPath, String replaceString) throws IOException, DocumentException {
        //        Document document = new Document(PageSize.A4, 20, 20, 20, 20);
        Document document = new Document(PageSize.A4);
        File file = new File(pdfPath);
        file.createNewFile();
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();
        Map<Integer, String> contractPages = new HashMap<>();
        Files.walk(Paths.get(folderPath)).forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                String s = filePath.toString();
                String replace = s.replace(replaceString, "");
                String replace1 = replace.replace(".png", "");
                int i = Integer.parseInt(replace1.trim());
                contractPages.put(i, s);
            }
        });

        contractPages.forEach((k, v) -> {
            Image image = null;
            try {
                image = Image.getInstance(v);
            } catch (BadElementException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            image.scalePercent(30);
            try {
                System.out.println("Adding page:" + k);
                document.add(image);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        });
        document.close();
    }
}
