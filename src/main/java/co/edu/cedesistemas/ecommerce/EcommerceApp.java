package co.edu.cedesistemas.ecommerce;

import co.edu.cedesistemas.ecommerce.config.CommerceConfig;
import co.edu.cedesistemas.ecommerce.model.Product;
import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.model.User;
import co.edu.cedesistemas.ecommerce.service.ProductService;
import co.edu.cedesistemas.ecommerce.service.StoreService;
import co.edu.cedesistemas.ecommerce.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

public class EcommerceApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("spring-context.xml",
                "spring-sample-stores.xml","spring-sampleusers.xml");
        Store store1 = context.getBean("store1", Store.class);
        Store store2 = context.getBean("store2", Store.class);
        Store store3 = context.getBean("store3", Store.class);

        StoreService storeService = context.getBean("storeService", StoreService.class);

        // Storing stores ..
        store1 = storeService.createStore(store1);
        System.out.println("store created: " + store1);

        store2 = storeService.createStore(store2);
        System.out.println("store created: " + store2);

        store3 = storeService.createStore(store3);
        System.out.println("store created: " + store3);

        // Getting all stores ...
        Iterable<Store> allStores = storeService.getAllStores();
        allStores.forEach(System.out::println);

        // Finding store by name
        // Finding stores by name ...
        Set<Store> found = storeService.getByName("the");
        found.forEach(System.out::println);

        User user1 = context.getBean("user1",User.class);
        User user2 = context.getBean("user2",User.class);
        User user3 = context.getBean("user3",User.class);


        System.out.println(storeService);
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService);
        //Instancia ProductService
        ProductService productService = context.getBean(ProductService.class);
        System.out.println(productService);
        Product product1 = new Product();
        product1.setName("laptoMac1");
        product1.setDescription("laptoMacV1");
        productService.createProduct(product1);
        Product product2 = new Product();
        product2.setName("laptoMac2");
        product2.setDescription("laptoMacV2");
        productService.createProduct(product2);
        Product product3 = new Product();
        product3.setName("laptoMac3");
        product3.setDescription("laptoMacV3");
        productService.createProduct(product3);
        Product product4 = new Product();
        product4.setName("laptoMac4");
        product4.setDescription("laptoMacV4");
        product4 = productService.createProduct(product4);
        String prueba = product4.getId();

    }
}
