package domain.entities;

public record UserDTO(Long id, String name, String email) {
    public static UserDTO fromUser(User user) {
        return new UserDTO(user.id(), user.name(), user.email());
    }
}
