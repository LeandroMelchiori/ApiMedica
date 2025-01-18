package med.vol.api.users;

public record UserAuthenticateData(
        String login,
        String password) {
}
