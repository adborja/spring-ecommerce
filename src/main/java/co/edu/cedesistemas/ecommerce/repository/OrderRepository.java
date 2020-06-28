package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Store;

import java.util.List;

public interface OrderRepository extends Repository<Store,String> {
    List<Store> findByName(String name);
}
