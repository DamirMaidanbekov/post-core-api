package kz.dar.university.repository;

import kz.dar.university.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    PostEntity findByPostId(String postId);
}
