package olorin.bulletinBoard.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import olorin.bulletinBoard.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User getByEmail(String email);
}
