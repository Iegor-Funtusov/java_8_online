package ua.com.alevel.persistence.repositoty.token;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.token.Token;
import ua.com.alevel.persistence.repositoty.BaseRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends BaseRepository<Token> {

    Optional<Token> findByToken(String token);
    List<Token> findByUserId(Long userId);
}
