package com.example.restservice.service.impl;

import crud.operations.entity.User;
import crud.operations.repository.UserRepository;
import crud.operations.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

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
	public void saveUserTest() {
		User user = new User(4L, null, "username", "password", "firstN", "lastN", "email", 12345, "sponsor");
		Mockito.when(userRepositoryMock.save(user)).thenReturn(user);
		User userResult = userService.createUser(user);
		Mockito.verify(userRepositoryMock).save(user);
		assertEquals(userResult, user);
	}
}