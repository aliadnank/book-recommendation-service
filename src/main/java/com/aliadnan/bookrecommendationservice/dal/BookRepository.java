package com.aliadnan.bookrecommendationservice.dal;

import com.aliadnan.bookrecommendationservice.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Ali
 * @createdOn 2018/10/28
 */
public interface BookRepository extends CrudRepository<Book, Long> {
    @Query(value = "select * from Book order by RAND() Limit 20",nativeQuery = true)
    List<Book> findRandomBooks();
}
