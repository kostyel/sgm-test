package sgm.test.facade;

import sgm.test.web.dto.LevelWebDto;

import java.util.List;

public interface LevelFacade {

    /**
     * Найти все значения уровней
     * @return список уровней
     */
    List<LevelWebDto> findAll();

}
