package co.edu.cedesistemas.ecommerce.repository.mongo;

import co.edu.cedesistemas.ecommerce.model.document.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address,String> {

}