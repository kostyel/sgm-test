package sgm.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDto {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String author;
    @NotNull
    private Long bookshelf;
    @NotNull
    private Long level;
}
