package com.example.restservice.service.impl;

import crud.operations.entity.Project;
import crud.operations.entity.User;
import crud.operations.repository.UserRepository;
import crud.operations.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserServiceImplTests {
	@Mock
	private UserRepository userRepositoryMock;

	private UserServiceImpl userService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		userService = new UserServiceImpl(userRepositoryMock);
	}

	@Test
	public void createUserTest() {
		User user = new User(4L, null, "username", "password", "firstN", "lastN", "email", 12345, "sponsor");

		Mockito.when(userRepositoryMock.save(user)).thenReturn(user);

		User userResult = userService.createUser(user);
		Mockito.verify(userRepositoryMock).save(user);
		assertEquals(userResult, user);
	}

	@Test
	public void getUserByIdTest() {
		User user = new User(4L, null, "username", "password", "firstN", "lastN", "email", 12345, "sponsor");

		Mockito.when(userRepositoryMock.findById(user.getId())).thenReturn(Optional.of(user));

		User userResult = userService.getUserById(user.getId());
		Mockito.verify(userRepositoryMock).findById(user.getId());
		assertEquals(userResult, user);
	}

	@Test
	public void getAllUsersTest() {
		User user = new User(4L, null, "username", "password", "firstN", "lastN", "email", 12345, "sponsor");
		User user2 = new User(3L, null, "username", "password", "firstN", "lastN", "email", 12345, "sponsor");
		User user3 = new User(2L, null, "username", "password", "firstN", "lastN", "email", 12345, "sponsor");
		List<User> users = Arrays.asList(user, user2, user3);

		Mockito.when(userRepositoryMock.findAll()).thenReturn(users);

		List<User> usersResult = userService.getAllUsers();
		Mockito.verify(userRepositoryMock).findAll();
		assertEquals(usersResult, users);
	}

	@Test
	public void updateUserTest() {
		User user = new User(4L, null, "username", "password", "firstN", "lastN", "email", 12345, "sponsor");
		User modifiedUser = new User(4L, null, "modified username", "password", "firstN", "lastN", "email", 12345, "sponsor");

		Mockito.when(userRepositoryMock.findById(user.getId())).thenReturn(Optional.of(user));
		Mockito.when(userRepositoryMock.save(user)).thenReturn(modifiedUser);

		User modifiedUserResult = userService.updateUser(user);
		Mockito.verify(userRepositoryMock).save(user);
		assertEquals(modifiedUserResult, modifiedUser);
	}

	@Test
	public void deleteUserTest() {
		User user = new User(4L, null, "username", "password", "firstN", "lastN", "email", 12345, "sponsor");

		Mockito.doNothing().when(userRepositoryMock).deleteById(user.getId());

		userService.deleteUser(user.getId());
		Mockito.verify(userRepositoryMock).deleteById(user.getId());
		assertNull(null);
	}
}