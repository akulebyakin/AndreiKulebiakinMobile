package utils;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.io.IOException;

import static utils.GetTestProperties.TESSDATA_DIRECTORY_PATH;

public class TesseractImageAnalyzer {

    public String getTextFromScreenshot(File imageFile) throws TesseractException {
        ITesseract instance = new Tesseract();          // JNA Interface Mapping.
//        ITesseract instance = new Tesseract1();       // JNA Direct Mapping
        instance.setDatapath(TESSDATA_DIRECTORY_PATH);  // path to tessdata directory

        String result = instance.doOCR(imageFile);
//        System.out.println(result);
        return result;
    }

}
