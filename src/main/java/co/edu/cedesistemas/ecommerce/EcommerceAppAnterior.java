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

import java.util.List;
import java.util.Set;

public class EcommerceAppAnterior {
    public static void main(String[] args) {
        loadFromAnnotations();
        //loadFromXML();
    }

    private static void loadFromXML() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml",
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
        List<Store> found = storeService.getByName("the");
        found.forEach(System.out::println);

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
        System.out.println("\ntodos los usuarios =\n");
        Iterable<User> allUsers = userService.getAllUser();
        allUsers.forEach(System.out::println);

        //buscar por email
        System.out.println("\nBuscar por email =\n");
        List<User> userByEmail = userService.getByEmail("@prueba.com");
        userByEmail.forEach(System.out::println);
        System.out.println("\n");

        //eliminar
        System.out.println("\nEliminar por ID =\n");
        //userService.delete("049e7214-0ea6-48a2-a05b-f30f94b7d9f9");
        //userService.delete("3e0629d4-7bdc-4cbf-9a88-1a668b05493d");
        //userService.delete("403f6b32-ed2b-4037-8ca4-eca91219aff8");
        //userService.delete("41b666ca-ca00-4dd0-b26d-cafc8de52e9b");
        //userService.delete("49f2d849-65c6-41fa-a9af-2acf740c8257");
    }

    private static void loadFromAnnotations() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CommerceConfig.class);
        ctx.scan("co.edu.cedesistemas.ecommerce");
        StoreService storeService = ctx.getBean(StoreService.class);
        System.out.println(storeService);
        UserService userService = ctx.getBean(UserService.class);
        System.out.println(userService);
        //Instancia ProductService
        ProductService productService = ctx.getBean(ProductService.class);
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
