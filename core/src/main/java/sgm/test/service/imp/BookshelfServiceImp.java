package sgm.test.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sgm.test.dto.BookshelfDto;
import sgm.test.mapper.BookshelfMapper;
import sgm.test.repository.BookshelfRepository;
import sgm.test.service.BookshelfService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookshelfServiceImp implements BookshelfService {

    private final BookshelfRepository repository;
    private final BookshelfMapper mapper;

    public List<BookshelfDto> findAll(){
        return mapper.toDtoList(repository.findAll());
    }

    public Boolean checkBookshelf(Long id){
        return repository.existsById(id);
    }

}
