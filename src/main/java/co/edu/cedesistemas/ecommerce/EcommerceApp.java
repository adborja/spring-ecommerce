package co.edu.cedesistemas.ecommerce;

import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.model.User;
import co.edu.cedesistemas.ecommerce.service.StoreService;
import co.edu.cedesistemas.ecommerce.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Set;

public class EcommerceApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml",
                "spring-sample-stores.xml");
        Store store1 = context.getBean("store1", Store.class);
        Store store2 = context.getBean("store2", Store.class);
        Store store3 = context.getBean("store3", Store.class);

        User user1 = context.getBean("user1", User.class);
        User user2 = context.getBean("user2", User.class);
        User user3 = context.getBean("user3", User.class);

        StoreService storeService = context.getBean("storeService", StoreService.class);
        UserService userService = context.getBean("userService", UserService.class);

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

//        // Finding stores by name ...
//        Set<Store> found = storeService.getByName("the");
//        found.forEach(System.out::println);

//        // Finding stores by type ...
//        List<Store> foundByType = (List<Store>) storeService.getStoresByType(Store.Type.AUTO_PARTS);
//        foundByType.forEach(System.out::println);

        // Storing Users ..
        user1 = userService.createUser(user1);
        System.out.println("User created: " + user1);

        user2 = userService.createUser(user2);
        System.out.println("User created: " + user2);

        user3 = userService.createUser(user3);
        System.out.println("User created: " + user3);


        // Getting all stores ...
        Iterable<User> allUsers = userService.getAllUsers();
        allUsers.forEach(System.out::println);


        // Finding stores by name ...
        List<User> foundUser = userService.getByEmail("carlosrojas@mail.com");
        foundUser.forEach(System.out::println);


    }
}
