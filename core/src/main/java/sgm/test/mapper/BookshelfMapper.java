package sgm.test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import sgm.test.dto.BookshelfDto;
import sgm.test.entity.Bookshelf;
import sgm.test.web.dto.BookshelfWebDto;

import java.util.List;

@Mapper
public interface BookshelfMapper {

    BookshelfWebDto toWebDto(BookshelfDto dto);

    BookshelfDto toDto(BookshelfWebDto webDto);

    BookshelfDto toDto(Bookshelf entity);

    Bookshelf toEntity(BookshelfDto dto);

    List<BookshelfDto> toDtoList(List<Bookshelf> list);

    List<BookshelfWebDto> toWebDtoList(List<BookshelfDto> listDto);
}
