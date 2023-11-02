package regist.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import regist.practice.domain.Comment;
import regist.practice.repository.CommentRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void writeContent(Comment comment){
        commentRepository.save(comment);
    }

    public void editContent(int id, String text,String password){
        Comment comment=commentRepository.findById(id);
        if(!comment.getPassword().equals(password)){
            return;
        }

        comment.setText(text);

        commentRepository.edit(comment);
    }

    public void deleteContent(int id, String password) {
        Comment comment = commentRepository.findById(id);
        if(!comment.getPassword().equals(password)) {
            return;
        }
        commentRepository.delete(id);
    }

    public List<Comment> getAllComments(int order) {
        return commentRepository.findAll(order);
    }

    public Comment getComment(int id) {
        return commentRepository.findById(id);
    }
}
