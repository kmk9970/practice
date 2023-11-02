package regist.practice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User_info {
    @Id
    @GeneratedValue
    @Column(name = "Id",nullable = false)
    private Long Id;

    private String a;
    private String b;
    private String c;

}
