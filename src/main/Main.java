package main;

import application.services.UserService;
import domain.entities.User;
import domain.entities.UserDTO;
import domain.repositories.IUserRepository;
import domain.repositories.UserRepository;
import domain.services.IUserService;
import infrastructure.config.Config;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        IUserRepository userRepository = new UserRepository();
        IUserService userService = new UserService(userRepository);

        User user = new User(1L, "João Silva", "joao@email.com");
        userRepository.save(user);

        // Altere o valor para 0, caso deseje ver o que acontece sem optional.
        if (Config.USE_OPTIONAL == 1) { // Encontra-se um exemplo usando Optional
            Optional<UserDTO> foundUser = userService.getUserById(2L);
            foundUser.ifPresentOrElse(
                    u -> System.out.println("Usuário encontrado: " + u),
                    () -> System.out.println("Usuário não encontrado")
            );
        } else { // Sem Optional
            UserDTO foundUser = userService.getUserById(2L).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            System.out.println("Usuário encontrado: " + foundUser);
        }
    }
}