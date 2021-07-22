package sgm.test.mapper;

import org.mapstruct.Mapper;
import sgm.test.dto.BookDto;
import sgm.test.entity.Book;
import sgm.test.web.dto.BookWebDto;


import java.util.List;

@Mapper
public interface BookMapper {

    BookWebDto toWebDto(BookDto dto);

    BookDto toDto(BookWebDto webDto);

    BookDto toDto(Book entity);

    Book toEntity(BookDto dto);

    List<BookDto> toDtoList(List<Book> list);

    List<BookWebDto> toWebDtoList(List<BookDto> listDto);

}
