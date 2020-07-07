package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.common.TestUtils;
import co.edu.cedesistemas.ecommerce.model.document.Address;
import co.edu.cedesistemas.ecommerce.model.document.Order;
import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
import co.edu.cedesistemas.ecommerce.model.document.Product;
import co.edu.cedesistemas.ecommerce.model.document.Store;
import co.edu.cedesistemas.ecommerce.model.document.User;
import co.edu.cedesistemas.ecommerce.repository.mongo.OrderRepository;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @Mock private OrderRepository repository;
    @InjectMocks private OrderService service;

    @Test
    public void testCreateOrder() {
        Store store = TestUtils.buildStore("mystore", "+572337845",
                "mystore address", Store.Type.FOOD);
        store.setId(UUID.randomUUID().toString());
        store.setCreatedAt(LocalDateTime.now());

        User user = TestUtils.buildUser(RandomString.make(5) + "@company.com",
                RandomString.make(10), RandomString.make(10));
        user.setId(UUID.randomUUID().toString());

        Address shippingAddress = TestUtils.buildAddress();

        Product product1 = TestUtils.buildProduct(RandomString.make(5), RandomString.make(5));
        product1.setId(UUID.randomUUID().toString());
        product1.setCreatedAt(LocalDateTime.now());

        Product product2 = TestUtils.buildProduct(RandomString.make(5), RandomString.make(5));
        product2.setId(UUID.randomUUID().toString());
        product2.setCreatedAt(LocalDateTime.now());

        Order order = TestUtils.buildOrder(store, user, shippingAddress);
        order.setCreatedAt(LocalDateTime.now());

        OrderItem item1 = new OrderItem();
        item1.setFinalPrice(5000F);
        item1.setProduct(product1);
        item1.setQuantity(2);

        OrderItem item2 = new OrderItem();
        item2.setFinalPrice(10000F);
        item2.setProduct(product2);
        item2.setQuantity(1);

        List<OrderItem> items = Arrays.asList(item1, item2);
        order.setItems(items);

        when(repository.save(order)).thenReturn(order);

        Order created = service.createOrder(order);

        assertThat(created, notNullValue());
        assertThat(created.getId(), notNullValue());
        assertThat(created.getItems().size(), equalTo(2));
    }

    @Test
    public void testGetOrderItems() {
        Store store = TestUtils.buildStore("mystore", "+572337845",
                "mystore address", Store.Type.FOOD);
        store.setId(UUID.randomUUID().toString());
        store.setCreatedAt(LocalDateTime.now());

        User user = TestUtils.buildUser(RandomString.make(5) + "@company.com",
                RandomString.make(10), RandomString.make(10));
        user.setId(UUID.randomUUID().toString());

        Address shippingAddress = TestUtils.buildAddress();

        Product product1 = TestUtils.buildProduct(RandomString.make(5), RandomString.make(5));
        product1.setId(UUID.randomUUID().toString());
        product1.setCreatedAt(LocalDateTime.now());

        Product product2 = TestUtils.buildProduct(RandomString.make(5), RandomString.make(5));
        product2.setId(UUID.randomUUID().toString());
        product2.setCreatedAt(LocalDateTime.now());

        Order order = TestUtils.buildOrder(store, user, shippingAddress);
        order.setCreatedAt(LocalDateTime.now());

        OrderItem item1 = new OrderItem();
        item1.setFinalPrice(5000F);
        item1.setProduct(product1);
        item1.setQuantity(2);

        OrderItem item2 = new OrderItem();
        item2.setFinalPrice(10000F);
        item2.setProduct(product2);
        item2.setQuantity(1);

        List<OrderItem> items = Arrays.asList(item1, item2);
        order.setItems(items);

        when(repository.save(order)).thenReturn(order);

        Order created = service.createOrder(order);

        when(repository.findById(created.getId())).thenReturn(Optional.of(created));

        Order found = service.getById(created.getId());

        assertThat(found, notNullValue());
        assertThat(found.getItems().size(), equalTo(2));
    }
}