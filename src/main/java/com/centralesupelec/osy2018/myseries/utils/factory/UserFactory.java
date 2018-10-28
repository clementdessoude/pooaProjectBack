package com.centralesupelec.osy2018.myseries.utils.factory;

import java.time.ZonedDateTime;

import com.centralesupelec.osy2018.myseries.models.User;
import com.centralesupelec.osy2018.myseries.models.dto.ManagedUserVM;
import com.centralesupelec.osy2018.myseries.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFactory {

    @Autowired UserRepository userRepository;

    public static User createUser(ManagedUserVM managedUserVM) {
        User newUser = new User();
		newUser.setLogin(managedUserVM.getLogin());
		newUser.setLastName(managedUserVM.getLastName());
		newUser.setFirstName(managedUserVM.getFirstName());
		newUser.setBirthdate(managedUserVM.getBirthdate());
		newUser.setPassword(managedUserVM.getPassword());
		newUser.setEmail(managedUserVM.getEmail());
		newUser.setDescription(managedUserVM.getDescription());
		newUser.setDateCreation(ZonedDateTime.now());

		return newUser;
    }

    public User createAndSaveUser(ManagedUserVM managedUserVM) {
        User newUser = UserFactory.createUser(managedUserVM);

        this.userRepository.save(newUser);

        return newUser;
    }
}