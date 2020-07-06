package co.edu.cedesistemas.ecommerce.service;


import co.edu.cedesistemas.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository){
        this.repository = repository;
    }

}
