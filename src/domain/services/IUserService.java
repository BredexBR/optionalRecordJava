package domain.services;

import domain.entities.UserDTO;
import java.util.Optional;

public interface IUserService {
    Optional<UserDTO> getUserById(Long id);
}