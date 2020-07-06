package co.edu.cedesistemas.ecommerce;

import co.edu.cedesistemas.ecommerce.config.CommerceConfig;
import co.edu.cedesistemas.ecommerce.model.Product;
import co.edu.cedesistemas.ecommerce.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.model.User;
import co.edu.cedesistemas.ecommerce.service.StoreService;
import co.edu.cedesistemas.ecommerce.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

public class EcommerceApp {
    public static void main(String[] args) {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml",
                "spring-sample-stores.xml","spring-sample-user.xml");
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

        // Finding stores by name ...
        //Set<Store> found = storeService.getByName("the");
        //found.forEach(System.out::println);

        //Users
        User user1= context.getBean("user1", User.class);
        User user2= context.getBean("user2", User.class);
        User user3= context.getBean("user3", User.class);

        UserService userService = context.getBean("userService",UserService.class);

        //almacenar los tres ususario
        user1 = userService.createUser(user1);
        System.out.println("\nuser1 created" + user1);
        user2 = userService.createUser(user2);
        System.out.println("\nuser2 created" + user2);
        user3 = userService.createUser(user3);
        System.out.println("\nuser3 created" + user3);

        //Consultar todos los usuarios
        //System.out.println("\ntodos los usuarios =\n");
        //Iterable<User> allUsers = userService.getAllUser();
        //allUsers.forEach(System.out::println);

        //buscar por email
        //System.out.println("\nBuscar por email =\n");
        //Set<User> userByEmail = userService.getByEmail("@prueba.com");
        //userByEmail.forEach(System.out::println);
        //System.out.println("\n");*/
        loadFromAnnotations();
    }

    private static void loadFromAnnotations() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CommerceConfig.class);
        ctx.scan("co.edu.cedesistemas.ecommerce");
        StoreService storeService = ctx.getBean(StoreService.class);
        System.out.println(storeService);
        UserService userService = ctx.getBean(UserService.class);
        System.out.println(userService);
        ProductService productService = ctx.getBean(ProductService.class);
        System.out.println(productService);

        Product product1 = new Product();
        product1.setName("laptop");
        product1.setDescription("portatil laptop");
        productService.createProduct(product1);

        Product product2 = new Product();
        product2.setName("laptop2");
        product2.setDescription("portatil laptop 2");
        productService.createProduct(product2);

        Product product3 = new Product();
        product3.setName("laptop3");
        product3.setDescription("portatil laptop 3");
        productService.createProduct(product3);

        Product product4 = new Product();
        product4.setName("laptop4");
        product4.setDescription("portatil laptop 4");
        productService.createProduct(product4);

        Product product5 = new Product();
        product5.setName("laptop5");
        product5.setDescription("portatil laptop 5");
        productService.createProduct(product5);

    }
}

