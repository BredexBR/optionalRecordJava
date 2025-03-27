package domain.repositories;

import domain.entities.User;
import java.util.Optional;

public interface IUserRepository {
    void save(User user);
    Optional<User> findById(Long id);
}