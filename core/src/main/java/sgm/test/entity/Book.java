package sgm.test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "book_seq_id", schema = "bs",
        sequenceName = "book_seq_id", allocationSize = 1)
@Table(schema = "bs")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String author;

    @Column(name = "bookshelf_id")
    private Long bookshelf;

    @Column(name = "level_id")
    private Long level;
}
