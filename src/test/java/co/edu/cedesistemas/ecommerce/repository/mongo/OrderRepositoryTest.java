package co.edu.cedesistemas.ecommerce.repository.mongo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import co.edu.cedesistemas.ecommerce.common.TestUtils;
import co.edu.cedesistemas.ecommerce.model.document.Address;
import co.edu.cedesistemas.ecommerce.model.document.Order;
import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
import co.edu.cedesistemas.ecommerce.model.document.Product;
import co.edu.cedesistemas.ecommerce.model.document.Store;
import co.edu.cedesistemas.ecommerce.model.document.User;
import co.edu.cedesistemas.ecommerce.repository.AddressRepository;
import co.edu.cedesistemas.ecommerce.repository.OrderRepository;
import co.edu.cedesistemas.ecommerce.repository.ProductRepository;
import co.edu.cedesistemas.ecommerce.repository.UserRepository;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class OrderRepositoryTest {
    @Autowired private OrderRepository orderRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private AddressRepository addressRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private StoreRepository storeRepository;

    @Test
    public void testSave() {
        Store store = TestUtils.buildStore("mystore", "+572337845",
                "mystore address", Store.Type.FOOD);
        store.setId(UUID.randomUUID().toString());
        store.setCreatedAt(LocalDateTime.now());
        store = storeRepository.save(store);

        User user = TestUtils.buildUser(RandomString.make(5) + "@company.com",
                RandomString.make(10), RandomString.make(10));
        user.setId(UUID.randomUUID().toString());
        user = userRepository.save(user);

        Address shippingAddress = TestUtils.buildAddress();
        shippingAddress = addressRepository.save(shippingAddress);

        Product product1 = TestUtils.buildProduct(RandomString.make(5), RandomString.make(5));
        product1.setId(UUID.randomUUID().toString());
        product1.setCreatedAt(LocalDateTime.now());
        product1 = productRepository.save(product1);

        Product product2 = TestUtils.buildProduct(RandomString.make(5), RandomString.make(5));
        product2.setId(UUID.randomUUID().toString());
        product2.setCreatedAt(LocalDateTime.now());
        product2 = productRepository.save(product2);


        Order order = TestUtils.buildOrder(store, user, shippingAddress);
        order.setId(UUID.randomUUID().toString());
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

        order = orderRepository.save(order);

        assertThat(order, notNullValue());
        assertThat(order.getUser().getId(), equalTo(user.getId()));
        assertThat(order.getStore().getId(), equalTo(store.getId()));
        assertThat(order.getShippingAddress().getId(), equalTo(shippingAddress.getId()));
        assertThat(order.getItems().size(), equalTo(2));
    }
}
