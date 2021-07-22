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
@SequenceGenerator(name = "level_seq_id", schema = "bs",
        sequenceName = "level_seq_id", allocationSize = 1)
@Table(schema = "bs")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "level_seq_id")
    private Long id;

    @Column
    private String name;

}
