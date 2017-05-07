package fr.projectdescartes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.projectdescartes.domain.User;
import fr.projectdescartes.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired 
	private UserRepository userRepository;
	
	public User login(String username, String password)
	{
		return userRepository.findByUsernameAndPassword(username, password);
	}
	
	public User createUser(User user)
	{
		return userRepository.save(user);
	}
	
}
