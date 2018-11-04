package com.aliadnan.bookrecommendationservice.util;

import com.aliadnan.bookrecommendationservice.domain.Book;
import com.aliadnan.bookrecommendationservice.service.BookService;
import de.siegmar.fastcsv.reader.CsvParser;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

/**
 * @author Ali
 * @createdOn 2018/10/28
 */
@Component
public class BooksLoader implements CommandLineRunner {

    private final BookService bookService;

    private final PropsUtils propsUtils;

    private Integer totalRecords = 0;

    private final Logger logger = Logger.getLogger(BooksLoader.class.getName());

    @Autowired
    public BooksLoader(BookService bookService, PropsUtils propsUtils) {
        this.bookService = bookService;
        this.propsUtils = propsUtils;
    }

    @Override
    public void run(String... args) {
        loadBooks();
    }

    public void loadBooks() {
        File file = new File(getClass().getClassLoader().getResource(propsUtils.getValue("csv.file.name")).getFile());
        CsvReader csvReader = new CsvReader();
        csvReader.setContainsHeader(true);
        csvReader.setFieldSeparator(';');
        try (CsvParser csvParser = csvReader.parse(file, StandardCharsets.UTF_8)) {
            CsvRow row;
            while ((row = csvParser.nextRow()) != null) {
                Book book = new Book(row.getField(1),row.getField(2),row.getField(0),row.getField(3));
                bookService.insert(book);
                totalRecords++;
            }
        } catch (IOException e) {
            logger.severe("Couldn't load the books from the file "+ e.getMessage());
        }
        catch (Exception e) {
            logger.severe("Couldn't load the books from the file "+ e.getMessage());
        }
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }
}
