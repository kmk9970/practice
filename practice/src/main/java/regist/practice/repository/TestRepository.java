package regist.practice.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import regist.practice.User_info;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestRepository {
    private final EntityManager EM; //엔티티 매니저 생성
    public void TestMethod(User_info user){ //user_info 객체를 받아서
        EM.persist(user); //DB에 저장한다.
    }

    public List<User_info> getData(String id){ //id를 받아와서 데이터를 찾는 함수
        return EM.createQuery("select m from User_info m where m.a =: Identity").setParameter("Identity",id).getResultList();//jpql을 쓴다
        //여기서 identity가 일종의 변수로 쓰이고 그 변수에 id값이 들어간다(setParameter). 그래서 id가 쿼리문에 들어간다
    }
}
