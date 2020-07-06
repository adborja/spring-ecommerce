package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.EcommerceApp;
import co.edu.cedesistemas.ecommerce.common.TestUtils;
import co.edu.cedesistemas.ecommerce.model.document.Address;
import co.edu.cedesistemas.ecommerce.model.document.Order;
import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
import co.edu.cedesistemas.ecommerce.model.document.Product;
import co.edu.cedesistemas.ecommerce.model.document.Store;
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

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EcommerceApp.class)
@AutoConfigureMockMvc
public class OrderControllerIT {
    @Autowired private MockMvc mvc;
    @Autowired private ObjectMapper objectMapper;

    @Test
    public void testCreateOrder() throws Exception {
        Store store = TestUtils.buildStore("test_controller_" + RandomString.make(10),
                "+572549628", "Dg. 2 # 75a - 55", Store.Type.FOOD);
        mvc.perform(post("/stores")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(store)))
                .andExpect(status().isCreated())
                .andReturn();

        User user = TestUtils.buildUser(RandomString.make(5) + "@company.com",
                RandomString.make(10), RandomString.make(10));
        mvc.perform(post("/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andReturn();

        Address shippingAddress = TestUtils.buildAddress();
        mvc.perform(post("/users/addresses")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(shippingAddress)))
                .andExpect(status().isCreated())
                .andReturn();

        Product product1 = TestUtils.buildProduct(RandomString.make(8), RandomString.make(8));
        mvc.perform(post("/products")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(product1)))
                .andExpect(status().isCreated())
                .andReturn();

        Product product2 = TestUtils.buildProduct(RandomString.make(8), RandomString.make(8));
        mvc.perform(post("/products")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(product2)))
                .andExpect(status().isCreated())
                .andReturn();

        Order order = TestUtils.buildOrder(store, user, shippingAddress);
        OrderItem item1 = TestUtils.buildOrderItem(product1, 2, 5000F);
        OrderItem item2 = TestUtils.buildOrderItem(product1, 3, 10000F);
        List<OrderItem> items = Arrays.asList(item1, item2);
        order.setItems(items);

        MvcResult result = mvc.perform(post("/orders")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isCreated())
                .andReturn();

        // Getting created order ..
        MockHttpServletResponse response = result.getResponse();
        Order created = objectMapper.readValue(response.getContentAsString(), Order.class);

        String id = created.getId();

        MvcResult getResult = mvc.perform(get("/orders/" + id))
                .andExpect(status().isOk())
                .andReturn();

        Order found = objectMapper.readValue(getResult.getResponse().getContentAsString(), Order.class);

        assertThat(found, notNullValue());
        assertThat(found.getItems().size(), equalTo(2));
    }

    @Test
    public void testGetOrderItems() throws Exception {
        Store store = TestUtils.buildStore("test_controller_" + RandomString.make(10),
                "+572549628", "Dg. 2 # 75a - 55", Store.Type.FOOD);
        mvc.perform(post("/stores")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(store)))
                .andExpect(status().isCreated())
                .andReturn();

        User user = TestUtils.buildUser(RandomString.make(5) + "@company.com",
                RandomString.make(10), RandomString.make(10));
        mvc.perform(post("/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andReturn();

        Address shippingAddress = TestUtils.buildAddress();
        mvc.perform(post("/users/addresses")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(shippingAddress)))
                .andExpect(status().isCreated())
                .andReturn();

        Product product1 = TestUtils.buildProduct(RandomString.make(8), RandomString.make(8));
        mvc.perform(post("/products")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(product1)))
                .andExpect(status().isCreated())
                .andReturn();

        Product product2 = TestUtils.buildProduct(RandomString.make(8), RandomString.make(8));
        mvc.perform(post("/products")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(product2)))
                .andExpect(status().isCreated())
                .andReturn();

        Order order = TestUtils.buildOrder(store, user, shippingAddress);
        OrderItem item1 = TestUtils.buildOrderItem(product1, 2, 5000F);
        OrderItem item2 = TestUtils.buildOrderItem(product1, 3, 10000F);
        List<OrderItem> items = Arrays.asList(item1, item2);
        order.setItems(items);

        MvcResult result = mvc.perform(post("/orders")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isCreated())
                .andReturn();

        // Getting created order ..
        MockHttpServletResponse response = result.getResponse();
        Order created = objectMapper.readValue(response.getContentAsString(), Order.class);

        String id = created.getId();

        MvcResult orderItemsResult = mvc.perform(get("/orders/" + id + "/items"))
                .andExpect(status().isOk())
                .andReturn();

        OrderItem[] found = objectMapper.readValue(orderItemsResult.getResponse().getContentAsString(),
                OrderItem[].class);

        assertThat(found.length, equalTo(2));
        assertThat(found[1].getQuantity(), equalTo(3));
    }
}
