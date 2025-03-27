package application.services;

import domain.entities.UserDTO;
import domain.repositories.IUserRepository;
import domain.services.IUserService;
import java.util.Optional;

public class UserService implements IUserService {
    private final IUserRepository repository;

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        return repository.findById(id).map(UserDTO::fromUser);
    }
}