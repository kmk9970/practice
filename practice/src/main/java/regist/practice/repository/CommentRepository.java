package regist.practice.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import regist.practice.domain.Comment;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {
    private final EntityManager EM;

    public void save(Comment comment) {
        EM.persist(comment);
    }

    public void edit(Comment comment) {
        EM.merge(comment);
    }

    public void delete(int id) {
        Comment comment= EM.find(Comment.class,id);
        if(comment!=null){
            EM.remove(comment);
        }
    }

    public List<Comment> findAll(int contentId) {
//        return new ArrayList<>(EM.createQuery("SELECT c FROM Comment c WHERE c.order=IDENTITY", Comment.class).setParameter("IDENTITY",order).getResultList());
        return new ArrayList<>(EM.createQuery("SELECT c.userId, c.text FROM Comment c WHERE c.order = :order", Comment.class)
                .setParameter("order", contentId)
                .getResultList());

    }

    public Comment findById(int id) {
        return EM.find(Comment.class,id);
    }
}
