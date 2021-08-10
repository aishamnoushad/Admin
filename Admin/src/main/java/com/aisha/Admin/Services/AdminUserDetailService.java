package com.aisha.Admin.Services;








import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aisha.Admin.Entity.User;
import com.aisha.Admin.GenericClasses.MyUserPrincipal;
import com.aisha.Admin.Repository.UserRepository;


@Service
@Primary
public class AdminUserDetailService implements UserDetailsService {
	private static final Logger log = LoggerFactory.getLogger(AdminUserDetailService.class);
	@Autowired
    private UserRepository userRepository;
    @Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(email);
        if (user == null ) {
//            throw new UsernameNotFoundException(email);
        	throw new UsernameNotFoundException(email+" The user is not authorised to access admin module");
        }
        log.info("loadUserByUsername() : {}", email);

        return new MyUserPrincipal(user);
		
	}

}


	
