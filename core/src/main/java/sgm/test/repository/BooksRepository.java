package sgm.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgm.test.entity.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {
}
