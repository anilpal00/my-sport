package com.mysport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysport.entities.User;
import com.mysport.exceptions.ResourceNotFoundException;
import com.mysport.repository.UserRepository;
import com.mysport.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User updatedUserProfile(User userProfile, Long userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));

		user.setFirstName(userProfile.getFirstName());
		user.setLastName(userProfile.getLastName());
		user.setMobileNo(userProfile.getMobileNo());
		user.setDateOfBirth(userProfile.getDateOfBirth());
		user.setCountry(userProfile.getCountry());
		user.setStreet(userProfile.getStreet());
		user.setCity(userProfile.getCity());
		user.setState(userProfile.getState());
		user.setPan(userProfile.getPan());
		User updatedUser = this.userRepo.save(user);
		return updatedUser;
	}

	@Override
	public User getUser(Long userId) {
		User user = this.userRepo.findById(userId).get();
		return user;
	}

}
