package sgm.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgm.test.entity.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
}
