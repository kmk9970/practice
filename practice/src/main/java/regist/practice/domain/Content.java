package regist.practice.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/*
게시판{
        아이디(외래키)
        순서(주키)
        글제목
        내용
        좋아요
        싫어요
}
*/

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
    private int id; //순서

    @Column(name="title")
    private String title; //제목

    @Column(name="texts")
    private String texts; //내용

    @Column(name="writer")
    private String writer; //작성자
    @Column(name="password")
    private String password; //비밀번호

    @Column(name="updateDate")
    private String updateDate; //수정일자

    @OneToMany(mappedBy = "order")
    private List<Comment> comments;
}
