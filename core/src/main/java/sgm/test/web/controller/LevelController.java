package sgm.test.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgm.test.web.dto.LevelWebDto;

import java.util.List;

@Tag(name = "Уровни")
@RestController
@RequestMapping(value = "/api/level")
public interface LevelController {

    @Operation(summary = "Получение списка уровней")
    @GetMapping("/all")
    ResponseEntity<List<LevelWebDto>> findAll();

}
