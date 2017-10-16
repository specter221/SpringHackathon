package com.stackroute.springrestapi;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.springrestapi.domain.UserModel;
import com.stackroute.springrestapi.repository.UserRepository;
import com.stackroute.springrestapi.service.DbUserService;
import com.stackroute.springrestapi.service.UserService;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class ServiceTest {
   
     
      private DbUserService dbuserService;
      private UserService userService;
       @Mock
       private UserRepository userRepository;
       @Mock
       private UserModel userModel;
       @Before
       public void setupMock() {
           MockitoAnnotations.initMocks(this);
           dbuserService=new DbUserService();
           dbuserService.setUserRepository(userRepository);
       }
       @Test
       //Test by id
       public void TestgetById() throws Exception {
           // Arrange
           when(userRepository.findOne(2)).thenReturn(userModel);
           // Act
           UserModel retrievedUser = dbuserService.getUserbyId(2);
           // Assert
           assertThat(retrievedUser, is(equalTo(userModel)));
      }
       
       @Test
       public void TestUpdate() throws Exception {
           // Arrange
           when(userRepository.save(userModel)).thenReturn(userModel);
           // Act
           dbuserService.updateUser(userModel);
           // Assert
           assertThat(userRepository.findOne(1), is(userRepository.findOne(1)));
       }
       @Test
       public void TestDelete() throws Exception {
           // Arrange
           doNothing().when(userRepository).delete(1);
           UserRepository my = Mockito.mock(UserRepository.class);
           // Act
          dbuserService.delete(1);
           // Assert
           verify(userRepository, times(1)).delete(1);
       }
   }