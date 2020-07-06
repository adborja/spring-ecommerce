package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.EcommerceApp;
import co.edu.cedesistemas.ecommerce.common.TestUtils;
import co.edu.cedesistemas.ecommerce.model.document.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EcommerceApp.class)
@AutoConfigureMockMvc
public class UserControllerIT {
    @Autowired private MockMvc mvc;
    @Autowired private ObjectMapper objectMapper;

    @Test
    public void testCreateUser() throws Exception {
        String name = RandomString.make(10);
        User user = TestUtils.buildUser(RandomString.make(5) + "@company.com",
               name , RandomString.make(10));
        MvcResult result = mvc.perform(post("/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andReturn();

        // Getting created store ..
        MockHttpServletResponse response = result.getResponse();
        User created = objectMapper.readValue(response.getContentAsString(), User.class);

        String id = created.getId();

        MvcResult getResult = mvc.perform(get("/users/" + id))
                .andExpect(status().isOk())
                .andReturn();
        User found = objectMapper.readValue(getResult.getResponse().getContentAsString(), User.class);
        assertThat(found.getName(), equalTo(name));
    }

    @Test
    public void testGetByEmail() throws Exception {
        String email = RandomString.make(5) + "@company.com";
        User user = TestUtils.buildUser(email,
                RandomString.make(10), RandomString.make(10));

        MvcResult result = mvc.perform(post("/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andReturn();

        // Getting created store ..
        MockHttpServletResponse response = result.getResponse();
        User created = objectMapper.readValue(response.getContentAsString(), User.class);

        String id = created.getId();

        MvcResult getResult = mvc.perform(get("/users/by-email")
                .queryParam("email", email))
                .andExpect(status().isOk())
                .andReturn();

        User found = objectMapper.readValue(getResult.getResponse().getContentAsString(), User.class);
        assertThat(found.getId(), equalTo(id));
        assertThat(found.getEmail(), equalTo(email));
    }

    @Test
    public void testUpdateEmail() throws Exception {
        String email = RandomString.make(5) + "@company.com";
        String newEmail = RandomString.make(5) + "@company.com";
        String name = RandomString.make(10);

        User user = TestUtils.buildUser(email,
               name , RandomString.make(10));

        MvcResult result = mvc.perform(post("/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andReturn();

        // Getting created store ..
        MockHttpServletResponse response = result.getResponse();
        User created = objectMapper.readValue(response.getContentAsString(), User.class);

        String id = created.getId();

        String requestBody = "{\"email\": \"" + newEmail + "\"}";

        MvcResult updateEmailResult = mvc.perform(put("/users/" + id)
                .contentType("application/json")
                .content(requestBody))
                .andExpect(status().isOk())
                .andReturn();

        User updated = objectMapper.readValue(updateEmailResult.getResponse().getContentAsString(), User.class);
        assertThat(updated.getId(), equalTo(id));
        assertThat(updated.getName(), equalTo(name));
        assertThat(updated.getEmail(), equalTo(newEmail));
    }
}