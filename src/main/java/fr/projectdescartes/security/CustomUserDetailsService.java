package fr.projectdescartes.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import fr.projectdescartes.domain.Role;
import fr.projectdescartes.domain.User;
import fr.projectdescartes.repository.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService  {

@Autowired UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException
	{
		User user = repo.findByUsername(username);
		System.out.println("Username : "+username+", User : "+user);
		if(user == null) throw new UsernameNotFoundException("User not found");
		return new org.springframework.security.core.userdetails.User(
                user.getUsername(), 
                user.getPassword(),
                getAuthorities(user)
                );
    }

    
    private Collection<? extends GrantedAuthority> getAuthorities(User user)
    {
        Set<String> userRoles = new HashSet<>();
        Collection<Role> roles = user.getRoles();
        
        for (Role role : roles)
        {
            userRoles.add(role.getName());
        }
        String[] roleNames = new String[userRoles.size()];
        Collection<GrantedAuthority> authorities = 
            AuthorityUtils.createAuthorityList(userRoles.toArray(roleNames));
        return authorities;
    }

}
