package sgm.test.service;

import sgm.test.dto.LevelDto;

import java.util.List;

public interface LevelService {

    /**
     * Найти все значения уровней
     * @return список уровней
     */
    List<LevelDto> findAll();

    /**
     * Проверка наличия уровня в хранилище
     * @param id id уровня
     * @return
     */
    Boolean checkLevel(Long id);

}
