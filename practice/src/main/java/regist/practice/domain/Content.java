package regist.practice.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="texts")
    private String texts;

    @Column(name="writer")
    private String writer;
    @Column(name="password")
    private String password;

    @Column(name="updateDate")
    private String updateDate;
}
