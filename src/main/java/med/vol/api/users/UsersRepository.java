package med.vol.api.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsersRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String username);
}
