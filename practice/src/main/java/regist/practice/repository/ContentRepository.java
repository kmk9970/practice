package regist.practice.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import regist.practice.domain.Comment;
import regist.practice.domain.Content;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ContentRepository {
    private final EntityManager EM;
    public void save(Content content) {
        EM.persist(content);
    }

    public void edit(Content content) {
        EM.merge(content);
    }

    public void delete(int id) {
        Content content = EM.find(Content.class,id);
        if(content!=null){
            EM.remove(content);
        }
    }

    public List<Content> findAll() {
          return new ArrayList<>(EM.createQuery("SELECT c FROM Content c", Content.class).getResultList());
    }

    public Content findById(int id) {
        return EM.find(Content.class,id);
    }

    public List<Comment> findCommentsById(int id, int order) {
        String jpql = "SELECT c FROM Comment c WHERE c.content.id = :id AND c.order = :order";
        return EM.createQuery(jpql, Comment.class)
                .setParameter("id", id)
                .setParameter("order", order)
                .getResultList();
    }
}
