package co.edu.cedesistemas.ecommerce;

import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.model.User;
import co.edu.cedesistemas.ecommerce.service.StoreService;
import co.edu.cedesistemas.ecommerce.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

public class EcommerceApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml",
                "spring-sample-stores.xml", "spring-sample-users.xml");
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

        System.out.println("");
        System.out.println("Create Users:");

        //Punto f del taller 6.
        UserService userService = context.getBean("userService", UserService.class);

        User user1 = context.getBean("user1", User.class);
        User user2 = context.getBean("user2", User.class);
        User user3 = context.getBean("user3", User.class);

        //Created Users
        user1 = userService.createUser(user1);
        System.out.println("user created: " + user1 + " " + user1.getName());

        user2 = userService.createUser(user2);
        System.out.println("user created: " + user2 + " " + user2.getName());

        user3 = userService.createUser(user3);
        System.out.println("user created: " + user3 + " " + user3.getName());

        System.out.println("");

        //Getting all users
        System.out.println("Getting all Users:");
        Iterable<User> allUsers = userService.getAllUsers();
        allUsers.forEach(System.out::println);

        System.out.println("");

        //Finding user by email
        //Finding user by email
        System.out.println("Finding user by email:");
        Set<User> foundUser = userService.getByEmail("juan.perez@pruebas.com");
        foundUser.forEach(System.out::println);
    }
}
