package swd4ta022.ticketguru.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DetailsService implements UserDetailsService {
	
	@Autowired
	AppuserRepository appusers;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	
		Appuser appuser = appusers.findByUsername(username);
		if (appuser == null) {
			throw new UsernameNotFoundException(username + " not found");
		}
		return new org.springframework.security.core.userdetails.User(
				appuser.getUsername(), 
				appuser.getPassword(),
				AuthorityUtils.createAuthorityList(appuser.getRole())
		);
	}

}
