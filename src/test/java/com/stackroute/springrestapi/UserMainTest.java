package com.stackroute.springrestapi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.springrestapi.domain.UserModel;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserMain.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserMainTest {
	    String user1;
	    @LocalServerPort
	    private int port;
	    TestRestTemplate restTemplate = new TestRestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    UserModel usermodel;
	    @Before
	    public void setUp() throws Exception {
	    	usermodel = new UserModel(1,"dikshab9","diksha@gmail.com");
	    }
	    private String createURLWithPort(String uri) {
	        return "http://localhost:" + port + uri;
	    }
	    @After
	    public void tearDown() throws Exception {
	    }
	    @Test
	    public void testSaveUser() throws Exception {
	        HttpEntity<UserModel> entity = new HttpEntity<UserModel>(usermodel, headers);
	        ResponseEntity<String> response = restTemplate.exchange(
	                createURLWithPort("/v0.1/userprofile/save"),
	                HttpMethod.POST, entity, String.class);
	        assertNotNull(response);
	        String actual = response.getBody();
	        System.out.println(actual);
	        assertEquals("User Added",actual);
	    }
	    @Test
	    public void testGetUser() throws Exception {
	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	        ResponseEntity<String> response = restTemplate.exchange(
	                createURLWithPort("/v0.1/userprofile/get"),
	                HttpMethod.GET, entity, String.class);
	        assertNotNull(response);
	    }
	    
	    @Test
	    public void testUpdateUser() throws Exception {
	        HttpEntity<UserModel> entity = new HttpEntity<UserModel>(usermodel, headers);
	        ResponseEntity<String> response = restTemplate.exchange(
	                createURLWithPort("/v0.1/userprofile/update"),
	                HttpMethod.PUT, entity, String.class);
	        assertNotNull(response);
	        String actual = response.getBody();
	        System.out.println(actual);
	        assertEquals("user updated",actual);
	    }
	    
	    @Test
	    public void testgetById() throws Exception {
	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	        ResponseEntity<String> response = restTemplate.exchange(
	                createURLWithPort("/v0.1/userprofile/get/1"),
	                HttpMethod.GET, entity, String.class);
	        assertNotNull(response);
	    }
}
	    
	    
	    
	    
	    