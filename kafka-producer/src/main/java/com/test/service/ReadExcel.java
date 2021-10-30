package com.test.service;

import com.test.entity.Payment;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ReadExcel {
    private static final String fileName = "C:/Users/Jerem/OneDrive/Documentos/DATATEST.xlsx";

    public  List<Payment> read() {
        List<Payment> payments = new ArrayList<>();
        try {
            FileInputStream arquivo = new FileInputStream(ReadExcel.fileName);

            Workbook workbook = new XSSFWorkbook(arquivo);

            Sheet sheetAlunos = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheetAlunos.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Payment payment = new Payment();
                payments.add(payment);
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            payment.setCode((long) cell.getNumericCellValue());
                            break;
                        case 1:
                            payment.setCreditCardNumber(cell.getStringCellValue());
                            break;
                        case 2:
                            payment.setMethod(cell.getStringCellValue());
                            break;
                        case 3:
                            payment.setValue(cell.getNumericCellValue());
                            break;

                    }
                }
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not found");
        } catch (IOException e) {

            e.printStackTrace();
            System.out.println("no payments found");
        }
        return payments;
    }
}