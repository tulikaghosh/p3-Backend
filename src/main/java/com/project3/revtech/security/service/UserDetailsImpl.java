package com.project3.revtech.security.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project3.revtech.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	  private static final long serialVersionUID = 1L;

	  private int user_id;

	  private String username;

	  private String email;
	  
	  private String first_name;
	  
	  private String last_name;
	  
	  private String address;
	  
	  private String contact;


	  @JsonIgnore
	  private String password;

	  private Collection<? extends GrantedAuthority> authorities;

	  public UserDetailsImpl(int user_id, String username, String email, String password,
	      Collection<? extends GrantedAuthority> authorities, String first_name, String last_name, String address, String contact) {
	    this.user_id = user_id;
	    this.username = username;
	    this.email = email;
	    this.password = password;
	    this.authorities = authorities;
	    this.first_name = first_name;
	    this.last_name = last_name;
	    this.address = address;
	    this.contact = contact;

	  }

	  public static UserDetailsImpl build(User user) {
	    List<GrantedAuthority> authorities = user.getRoles().stream()
	        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
	        .collect(Collectors.toList());

	    return new UserDetailsImpl(
	        user.getUser_id(), 
	        user.getUsername(), 
	        user.getEmail(),
	        user.getPassword(), 
	        authorities, user.getFirst_name(), user.getLast_name(), user.getAddress(), user.getContact());
	  }

	  @Override
	  public Collection<? extends GrantedAuthority> getAuthorities() {
	    return authorities;
	  }


	  public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
	    return email;
	  }

	  @Override
	  public String getPassword() {
	    return password;
	  }

	  @Override
	  public String getUsername() {
	    return username;
	  }
	  
	  public String getFirst_name() {
	    return first_name;
	  }
	  
	  public String getLast_name() {
		    return last_name;
		  }
	  
	  
	  public String getAddress() {
		return address;
	}

      public String getContact() {
		    return contact;
		  }

	@Override
	  public boolean isAccountNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isAccountNonLocked() {
	    return true;
	  }

	  @Override
	  public boolean isCredentialsNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isEnabled() {
	    return true;
	  }

	  @Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (o == null || getClass() != o.getClass())
	      return false;
	    UserDetailsImpl user = (UserDetailsImpl) o;
	    return Objects.equals(user_id, user.user_id);
	  }
	  
	  
	}