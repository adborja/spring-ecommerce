package co.edu.cedesistemas.ecommerce.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import co.edu.cedesistemas.ecommerce.EcommerceApp;
import co.edu.cedesistemas.ecommerce.common.TestUtils;
import co.edu.cedesistemas.ecommerce.model.document.Store;
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

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EcommerceApp.class)
@AutoConfigureMockMvc
public class StoreControllerIT {
    @Autowired private MockMvc mvc;
    @Autowired private ObjectMapper objectMapper;

    private static final String DEFAULT_STORE_NAME = "the pet store";
    private static final String DEFAULT_STORE_ADDRESS = "Cra. 81 # 33 - 76";
    private static final String DEFAULT_STORE_PHONE = "+5748996574";

    @Test
    public void testCreateStore() throws Exception {
        Store store = TestUtils.buildStore(DEFAULT_STORE_NAME, DEFAULT_STORE_PHONE,
                DEFAULT_STORE_ADDRESS, Store.Type.PETS);
        MvcResult result = mvc.perform(post("/stores")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(store)))
                .andExpect(status().isCreated())
                .andReturn();

        // Getting created store ..
        MockHttpServletResponse response = result.getResponse();
        Store created = objectMapper.readValue(response.getContentAsString(), Store.class);

        String storeId = created.getId();

        MvcResult getResult = mvc.perform(get("/stores/" + storeId))
                .andExpect(status().isOk())
                .andReturn();
        Store found = objectMapper.readValue(getResult.getResponse().getContentAsString(), Store.class);
        assertThat(found.getName(), equalTo(DEFAULT_STORE_NAME));
        assertThat(found.getType(), equalTo(Store.Type.PETS));
    }

    @Test
    public void testGetByName() throws Exception {
        String prefix = "test_controller_" + RandomString.make(3) + "_";
        Store store1 = TestUtils.buildStore(prefix + "" + RandomString.make(10), DEFAULT_STORE_PHONE,
                DEFAULT_STORE_ADDRESS, Store.Type.BOOKS);
        Store store2 = TestUtils.buildStore(prefix + "" + RandomString.make(10), DEFAULT_STORE_PHONE,
                DEFAULT_STORE_ADDRESS, Store.Type.FOOD);
        Store store3 = TestUtils.buildStore(prefix + "" + RandomString.make(10), DEFAULT_STORE_PHONE,
                DEFAULT_STORE_ADDRESS, Store.Type.TECHNOLOGY);

        mvc.perform(post("/stores")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(store1)))
                .andExpect(status().isCreated())
                .andReturn();

        mvc.perform(post("/stores")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(store2)))
                .andExpect(status().isCreated())
                .andReturn();

        mvc.perform(post("/stores")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(store3)))
                .andExpect(status().isCreated())
                .andReturn();

        // Getting stores by name ...
        MvcResult getResult = mvc.perform(get("/stores/by-name")
                .queryParam("name", prefix))
                .andExpect(status().isOk())
                .andReturn();

        Store[] found = objectMapper.readValue(getResult.getResponse().getContentAsString(), Store[].class);

        assertThat(found.length, equalTo(3));
        assertThat(found[1].getType(), equalTo(Store.Type.FOOD));
    }

    @Test
    public void testGetStoresByType() throws Exception {
        String prefix = "test_controller_" + RandomString.make(3) + "_";
        Store store1 = TestUtils.buildStore(prefix + "" + RandomString.make(10), DEFAULT_STORE_PHONE,
                DEFAULT_STORE_ADDRESS, Store.Type.FITNESS);
        Store store2 = TestUtils.buildStore(prefix + "" + RandomString.make(10), DEFAULT_STORE_PHONE,
                DEFAULT_STORE_ADDRESS, Store.Type.FITNESS);

        mvc.perform(post("/stores")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(store1)))
                .andExpect(status().isCreated())
                .andReturn();

        mvc.perform(post("/stores")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(store2)))
                .andExpect(status().isCreated())
                .andReturn();

        // Getting stores by type ...
        MvcResult getResult = mvc.perform(get("/stores/by-type")
                .queryParam("type", Store.Type.FITNESS.name()))
                .andExpect(status().isOk())
                .andReturn();

        Store[] found = objectMapper.readValue(getResult.getResponse().getContentAsString(), Store[].class);

        assertThat(found.length, equalTo(2));
        assertThat(found[1].getType(), equalTo(Store.Type.FITNESS));
    }

    @Test
    public void testGetAllStores() throws Exception {
        String prefix = "test_controller_" + RandomString.make(3) + "_";
        Store store1 = TestUtils.buildStore(prefix + "" + RandomString.make(10), DEFAULT_STORE_PHONE,
                DEFAULT_STORE_ADDRESS, Store.Type.AUTO_PARTS);
        Store store2 = TestUtils.buildStore(prefix + "" + RandomString.make(10), DEFAULT_STORE_PHONE,
                DEFAULT_STORE_ADDRESS, Store.Type.FOOD);
        Store store3 = TestUtils.buildStore(prefix + "" + RandomString.make(10), DEFAULT_STORE_PHONE,
                DEFAULT_STORE_ADDRESS, Store.Type.BOOKS);

        mvc.perform(post("/stores")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(store1)))
                .andExpect(status().isCreated())
                .andReturn();
        mvc.perform(post("/stores")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(store2)))
                .andExpect(status().isCreated())
                .andReturn();
        mvc.perform(post("/stores")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(store2)))
                .andExpect(status().isCreated())
                .andReturn();

        // Getting all stores ...
        MvcResult getResult = mvc.perform(get("/stores"))
                .andExpect(status().isOk())
                .andReturn();

        Store[] found = objectMapper.readValue(getResult.getResponse().getContentAsString(), Store[].class);

        assertThat(found.length, greaterThan(0));
    }
}
