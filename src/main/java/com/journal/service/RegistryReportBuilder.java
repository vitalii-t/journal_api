package com.journal.service;

import com.journal.data.entities.Registry;
import com.journal.repository.RegistryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static com.journal.util.DatesUtil.getDatesBetween;

@RequiredArgsConstructor
@Component
@Slf4j
public class RegistryReportBuilder {

    private static final String[] COLUMNS_EN = {"Student", "Subject", "Presence"};
    private static final String[] COLUMNS_UA = {"Студент", "Предмет", "Присутність"};

    private final RegistryRepository registryRepository;

    private Workbook buildReport(LocalDate from, LocalDate to, String lang) {
        boolean isEnglish = lang.equalsIgnoreCase("en");
        Workbook workbook = new HSSFWorkbook();

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 13);
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        List<LocalDate> dates = getDatesBetween(from, to);
        for (LocalDate date : dates) {
            List<Registry> registryByDateOfLesson = registryRepository.findAllByDateOfLesson(date);

                CreationHelper helper = workbook.getCreationHelper();

            if (!registryByDateOfLesson.isEmpty()) {
                Sheet sheet = workbook.createSheet(date.toString());

                CellStyle headerCellStyle = workbook.createCellStyle();
                headerCellStyle.setFont(headerFont);

                Row headerRow = sheet.createRow(0);

                for (int i = 0; i < COLUMNS_EN.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(isEnglish? COLUMNS_EN[i] : COLUMNS_UA[i]);
                    cell.setCellStyle(headerCellStyle);
                }

                CellStyle dataCellStyle = workbook.createCellStyle();
                dataCellStyle.setDataFormat(helper.createDataFormat().getFormat("dd-MM-yyyy"));

                int rowNumber = 1;

                for (Registry reg : registryByDateOfLesson) {
                    Row row = sheet.createRow(rowNumber++);

                    row.createCell(0).setCellValue(isEnglish ? reg.getUser().getFirstNameEn() + " " + reg.getUser().getLastNameEn()
                            : reg.getUser().getFirstNameUa() + " " + reg.getUser().getLastNameUa() );
                    row.createCell(1).setCellValue(isEnglish ? reg.getSubject().getSubjectNameEn() : reg.getSubject().getSubjectNameUa());
                    row.createCell(2).setCellValue(reg.isPresent() ? "+" : "-");
                }
                for (int i = 0; i < COLUMNS_EN.length; i++) {
                    sheet.autoSizeColumn(i);
                }
            }else {
                Sheet sheet = workbook.createSheet(date.toString());
                CellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setFont(headerFont);
                Row headerRow = sheet.createRow(0);
                Cell cell = headerRow.createCell(1);
                cell.setCellValue(isEnglish ? "No data in registry today.": "Немає записів у журналі за сьогодні.");
                cell.setCellStyle(cellStyle);
            }
        }
        return workbook;
    }

    public ByteArrayInputStream export(LocalDate from, LocalDate to, String lang) {
        Workbook report = buildReport(from, to, lang);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            report.write(out);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}