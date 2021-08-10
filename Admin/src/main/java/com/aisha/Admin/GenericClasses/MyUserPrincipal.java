package com.aisha.Admin.GenericClasses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.aisha.Admin.Entity.RoleTB;
import com.aisha.Admin.Entity.User;



@Component
public class MyUserPrincipal implements UserDetails {
    /**
	 * 
	 */
	
	private static final long serialVersionUID = 226115655855124734L;
	@Autowired
	private User user;
	
	
	 public MyUserPrincipal() {
	        
	    }

    public MyUserPrincipal(User user) {
        this.setUser(user);
    }
    //...
    public int getStatus() {
    	return user.getStatus();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<RoleTB> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (RoleTB role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole_name()));
        }
         
        return authorities;
    }
	

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}