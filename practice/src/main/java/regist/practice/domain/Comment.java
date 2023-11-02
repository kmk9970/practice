package regist.practice.domain;

import jakarta.persistence.*;
import lombok.*;

/*
댓글(comment){
순서(외래)
아이디(외래)
내용(댓글)
}
*/

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order", referencedColumnName = "id")
    private Content order;

    private String user_id;

    private String password;

    private String text;

}
