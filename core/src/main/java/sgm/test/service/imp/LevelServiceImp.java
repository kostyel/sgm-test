package sgm.test.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sgm.test.dto.BookshelfDto;
import sgm.test.dto.LevelDto;
import sgm.test.mapper.BookshelfMapper;
import sgm.test.mapper.LevelMapper;
import sgm.test.repository.BookshelfRepository;
import sgm.test.repository.LevelRepository;
import sgm.test.service.BookshelfService;
import sgm.test.service.LevelService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelServiceImp implements LevelService {

    private final LevelRepository repository;
    private final LevelMapper mapper;

    public List<LevelDto> findAll(){
        return mapper.toDtoList(repository.findAll());
    }

    public Boolean checkLevel(Long id){
        return repository.existsById(id);
    }

}
