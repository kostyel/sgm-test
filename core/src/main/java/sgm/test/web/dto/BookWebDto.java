package sgm.test.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookWebDto {

    private Long id;
    private String name;
    private String author;
    private Long bookshelf;
    private Long level;
}
