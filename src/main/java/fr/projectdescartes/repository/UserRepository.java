package fr.projectdescartes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.projectdescartes.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String username);

	User findByUsernameAndPassword(String login, String password);
}