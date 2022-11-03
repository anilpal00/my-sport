package com.mysport.service;

import com.mysport.entities.User;

public interface UserService {

	User updatedUserProfile(User userProfile,Long userId);
	User getUser(Long userId);
}
