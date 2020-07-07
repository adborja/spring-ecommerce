package co.edu.cedesistemas.ecommerce;

import co.edu.cedesistemas.ecommerce.config.CommerceConfig;
import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.service.StoreService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EcommerceApp {
    public static void main(String[] args) {
        loadFromAnnotations();
        //loadFromXML();
    }

    private static void loadFromXML() {
        ApplicationContext context = new AnnotationConfigApplicationContext("spring-service.xml",
                "spring-sample-stores.xml");
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

        // Finding stores by type ...
        List<Store> foundByType = (List<Store>) storeService.getStoresByType(Store.Type.AUTO_PARTS);
        foundByType.forEach(System.out::println);
    }

    private static void loadFromAnnotations() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CommerceConfig.class);
        ctx.scan("co.edu.cedesistemas.ecommerce");
        StoreService storeService = ctx.getBean(StoreService.class);
        System.out.println(storeService);
    }
}
