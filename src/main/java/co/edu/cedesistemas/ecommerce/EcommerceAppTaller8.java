package co.edu.cedesistemas.ecommerce;

import co.edu.cedesistemas.ecommerce.config.CommerceConfig;
import co.edu.cedesistemas.ecommerce.model.Order;
import co.edu.cedesistemas.ecommerce.model.OrderItem;
import co.edu.cedesistemas.ecommerce.model.Product;
import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.service.OrderItemService;
import co.edu.cedesistemas.ecommerce.service.ProductService;
import co.edu.cedesistemas.ecommerce.service.StoreService;
import co.edu.cedesistemas.ecommerce.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EcommerceAppTaller8 {
    public static void main(String[] args) {
        loadFromAnnotations();
        //loadFromXML();
    }

    private static void loadFromXML() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml",
                "spring-sample-stores.xml", "spring-sample-products.xml");
        Store store1 = context.getBean("store1", Store.class);
        Store store2 = context.getBean("store2", Store.class);
        Store store3 = context.getBean("store3", Store.class);

        StoreService storeService = context.getBean("storeService", StoreService.class);
        ProductService productService = context.getBean("productService", ProductService.class);
        OrderItemService orderItemService = context.getBean("orderItemService", OrderItemService.class);

        // Storing stores ..
        //store1 = storeService.createStore(store1);
        //System.out.println("store created: " + store1);

        //store2 = storeService.createStore(store2);
        //System.out.println("store created: " + store2);

        //store3 = storeService.createStore(store3);
        //System.out.println("store created: " + store3);

        // Getting all stores ...
        //Iterable<Store> allStores = storeService.getAllStores();
        //allStores.forEach(System.out::println);

        // Finding stores by name ...
        //List<Store> found = storeService.getByName("the");
        //found.forEach(System.out::println);

        // Finding stores by type ...
        //List<Store> foundByType = (List<Store>) storeService.getStoresByType(Store.Type.AUTO_PARTS);
        //foundByType.forEach(System.out::println);

        //Create Products
        Product product1 = context.getBean("product1", Product.class);
        Product product2 = context.getBean("product2", Product.class);
        Product product3 = context.getBean("product3", Product.class);

        product1 = productService.createProduct(product1);
        System.out.println("store product: " + product1);

        product2 = productService.createProduct(product2);
        System.out.println("store product: " + product2);

        product3 = productService.createProduct(product3);
        System.out.println("store product: " + product3);

        // Getting all products ...
        Iterable<Product> allProducts = productService.getAllProducts();
        allProducts.forEach(System.out::println);

        // Finding products by name ...
        //List<Product> listProductsName = productService.getByName("TV");
        //listProductsName.forEach(System.out::println);

        // Finding all information products by name ...
        //for (Product list: listProductsName) {
        //    Product product = productService.getById(list.getId());
        //System.out.println("ID: " + product.getId());
        //System.out.println("Name: " + product.getName());
        //System.out.println("Description: " + product.getDescription());
        //}

        //Found Product By ID
        //Product product = productService.getById("3c3b3a4d-972a-4f79-996e-888c299009d4");
        //System.out.println("ID: " + product.getId());
        //System.out.println("Name: " + product.getName());
        //System.out.println("Description: " + product.getDescription());

        //Finding all By Order
        System.out.println("Finding all By Order");
        List<OrderItem> listOrderItem = orderItemService.findAllByOrder("1");
        listOrderItem.forEach(System.out::println);
    }

    private static void loadFromAnnotations() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CommerceConfig.class);
        context.scan("co.edu.cedesistemas.ecommerce");
        StoreService storeService = context.getBean(StoreService.class);
        System.out.println(storeService);

        UserService userService = context.getBean(UserService.class);
        ProductService productService = context.getBean(ProductService.class);
        OrderItemService orderItemService = context.getBean(OrderItemService.class);

        //Create Products
        Product product1 = new Product();
        product1.setName("Iphone");
        product1.setDescription("Iphone 11");
        productService.createProduct(product1);
        System.out.println("store product: " + product1);

        Product product2 = new Product();
        product2.setName("Portatil");
        product2.setDescription("Portatil Lenovo");
        productService.createProduct(product2);
        System.out.println("store product: " + product2);

        Product product3 = new Product();
        product3.setName("Nevera");
        product3.setDescription("Nevera Haceb");
        productService.createProduct(product3);
        System.out.println("store product: " + product3);

        Product product4 = new Product();
        product4.setName("Carro");
        product4.setDescription("Automovil");
        productService.createProduct(product4);
        System.out.println("store product: " + product4);

        // Getting all products ...
        Iterable<Product> allProducts = productService.getAllProducts();
        allProducts.forEach(System.out::println);

        //Getting all order item
        System.out.println("Getting all order item");
        //List<OrderItem> item = orderItemService.findAllByOrder("1");
        //item.forEach(System.out::println);
    }
}
