package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.EcommerceApp;
import co.edu.cedesistemas.ecommerce.common.TestUtils;
import co.edu.cedesistemas.ecommerce.model.document.Product;
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
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EcommerceApp.class)
@AutoConfigureMockMvc
public class ProductControllerIT {
    @Autowired private MockMvc mvc;
    @Autowired private ObjectMapper objectMapper;

    @Test
    public void testCreateProduct() throws Exception {
        String prefix = "test_controller_" + RandomString.make(3) + "_";
        Product product = TestUtils.buildProduct(prefix + RandomString.make(10),
                "product description");
        MvcResult result = mvc.perform(post("/products")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isCreated())
                .andReturn();

        // Getting created store ..
        MockHttpServletResponse response = result.getResponse();
        Product created = objectMapper.readValue(response.getContentAsString(), Product.class);

        String productId = created.getId();

        MvcResult getResult = mvc.perform(get("/products/" + productId))
                .andExpect(status().isOk())
                .andReturn();
        Product found = objectMapper.readValue(getResult.getResponse().getContentAsString(), Product.class);
        assertThat(found.getName(), startsWith(prefix));
        assertThat(found.getDescription(), equalTo("product description"));
    }

    @Test
    public void testGetByName() throws Exception {
        String prefix = "test_controller_" + RandomString.make(3) + "_";
        Product product1 = TestUtils.buildProduct(prefix + RandomString.make(10),
                "product description");
        Product product2 = TestUtils.buildProduct(prefix + RandomString.make(10),
                "product description");
        mvc.perform(post("/products")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(product1)))
                .andExpect(status().isCreated())
                .andReturn();
        mvc.perform(post("/products")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(product2)))
                .andExpect(status().isCreated())
                .andReturn();

        // Getting products by name ...
        MvcResult getResult = mvc.perform(get("/products/by-name")
                .queryParam("name", prefix))
                .andExpect(status().isOk())
                .andReturn();

        Product[] found = objectMapper.readValue(getResult.getResponse().getContentAsString(), Product[].class);

        assertThat(found.length, equalTo(2));
    }

    @Test
    public void testGetByDescription() throws Exception {
        String prefix = "test_controller_" + RandomString.make(3) + "_";
        Product product1 = TestUtils.buildProduct(prefix + RandomString.make(10),
                prefix + RandomString.make(10) + "_desc");
        Product product2 = TestUtils.buildProduct(prefix + RandomString.make(10),
                prefix + RandomString.make(10) + "_desc");
        Product product3 = TestUtils.buildProduct(prefix + RandomString.make(10),
                prefix + RandomString.make(10) + "_desc");

        mvc.perform(post("/products")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(product1)))
                .andExpect(status().isCreated())
                .andReturn();
        mvc.perform(post("/products")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(product2)))
                .andExpect(status().isCreated())
                .andReturn();
        mvc.perform(post("/products")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(product3)))
                .andExpect(status().isCreated())
                .andReturn();

        // Getting products by description ...
        MvcResult getResult = mvc.perform(get("/products/by-description")
                .queryParam("desc", prefix))
                .andExpect(status().isOk())
                .andReturn();

        Product[] found = objectMapper.readValue(getResult.getResponse().getContentAsString(), Product[].class);

        assertThat(found.length, equalTo(3));
    }

    @Test
    public void testGetAll() throws Exception {
        String prefix = "test_controller_" + RandomString.make(3) + "_";
        Product product1 = TestUtils.buildProduct(prefix + RandomString.make(10),
                prefix + RandomString.make(10) + "_desc");
        Product product2 = TestUtils.buildProduct(prefix + RandomString.make(10),
                prefix + RandomString.make(10) + "_desc");
        Product product3 = TestUtils.buildProduct(prefix + RandomString.make(10),
                prefix + RandomString.make(10) + "_desc");

        mvc.perform(post("/products")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(product1)))
                .andExpect(status().isCreated())
                .andReturn();
        mvc.perform(post("/products")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(product2)))
                .andExpect(status().isCreated())
                .andReturn();
        mvc.perform(post("/products")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(product3)))
                .andExpect(status().isCreated())
                .andReturn();

        // Getting products by description ...
        MvcResult getResult = mvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andReturn();

        Product[] found = objectMapper.readValue(getResult.getResponse().getContentAsString(), Product[].class);

        assertThat(found.length, greaterThan(0));
    }
}
