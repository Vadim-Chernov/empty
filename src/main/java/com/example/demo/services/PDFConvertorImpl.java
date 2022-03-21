package com.example.demo.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@Service
public class PDFConvertorImpl implements PDFConvertor {

    @Override
    public String convert(@NonNull String str) {
        if (str.isEmpty())
            return "";
        String fileName = str + ".pdf";
        File file = null;
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));

            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Chunk chunk = new Chunk(str, font);

            document.add(chunk);
            document.close();
            file = new File(fileName);
        } catch (IOException | DocumentException e) {
            log.error(e.toString());
        }
        if (file != null)
            return file.getAbsolutePath();
        return null;
    }
}
