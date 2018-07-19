package com.omega.mtest;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.omega.mtest.models.User;
import com.omega.mtest.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MTestApplicationTests {

	@Autowired MockMvc mockMvc;
	@MockBean UserService userService;
    
    @Test
    public void shouldReturnAllUsers() throws Exception {
    	User john = new User(1, "John", 31, "New York");
    	User doe = new User(2, "Doe", 22, "Vancouver");
    	
    	when(userService.findAll()).thenReturn(Arrays.asList(john, doe));
    	
    	mockMvc.perform(get("/users").header("access-token", "test-token"))
    			.andExpect(status().isOk())
    			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    			.andExpect(jsonPath("$", hasSize(2)))
    			.andExpect(jsonPath("$[0].id", is(john.getId())))
    			.andExpect(jsonPath("$[0].name", is(john.getName())))
    			.andExpect(jsonPath("$[0].age", is(john.getAge())))
    			.andExpect(jsonPath("$[0].city", is(john.getCity())))
    			.andExpect(jsonPath("$[1].id", is(doe.getId())))
    			.andExpect(jsonPath("$[1].name", is(doe.getName())))
    			.andExpect(jsonPath("$[1].age", is(doe.getAge())))
    			.andExpect(jsonPath("$[1].city", is(doe.getCity())));
    }
    
    @Test
    public void shouldReturnEmptyListWhenNoRecordIsFound() throws Exception {
    	when(userService.findAll()).thenReturn(Collections.emptyList());
    	
    	mockMvc.perform(get("/users").header("access-token", "test-token"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(0)));
    }
    
    @Test
    public void shouldReturnUserDoeWhenIdIs2() throws Exception {
    	User doe = new User(2, "Doe", 22, "Vancouver");
    	
    	when(userService.findById(2)).thenReturn(doe);
    	
    	mockMvc.perform(get("/users/2").header("access-token", "test-token"))
    			.andExpect(status().isOk())
    			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    			.andExpect(jsonPath("$.id", is(doe.getId())))
    			.andExpect(jsonPath("$.name", is(doe.getName())))
    			.andExpect(jsonPath("$.age", is(doe.getAge())))
    			.andExpect(jsonPath("$.city", is(doe.getCity())));
    }
    
    @Test
    public void shouldReturnBadRequestWhenUserIdDoesNotExists() throws Exception {
    	when(userService.findById(22)).thenReturn(null);
    	
    	mockMvc.perform(get("/users/22").header("access-token", "test-token"))
				.andExpect(status().isBadRequest());
    }
}
