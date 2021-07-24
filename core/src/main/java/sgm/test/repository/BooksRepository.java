package sgm.test.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;
import sgm.test.entity.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {

    @Query(value = "from Book b where b.name like %:name%")
    Page<Book> findAllByNameLike(@Param(value = "name") String name, Pageable pageable);
}
