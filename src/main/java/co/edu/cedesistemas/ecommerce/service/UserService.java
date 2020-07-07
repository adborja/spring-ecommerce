package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.Address;
import co.edu.cedesistemas.ecommerce.model.document.User;
import co.edu.cedesistemas.ecommerce.repository.UserMapRepository;
import co.edu.cedesistemas.ecommerce.repository.mongo.AddressRepository;
import co.edu.cedesistemas.ecommerce.repository.mongo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository repository;
    private final AddressRepository addressRepository;

    public UserService(final UserRepository repository, final AddressRepository addressRepository){
        this.repository = repository;
        this.addressRepository = addressRepository;
    }

    public User createUser(User user){
        user.setId(UUID.randomUUID().toString());
        return repository.save(user);
    }

    public User updateUser(User user, String id){
        User _user = repository.findById(id).orElse(null);
        _user.setEmail(user.getEmail());

        return  repository.save(_user);
    }

    public User getById(final String id){
        return repository.findById(id).orElse(null);
    }

    public void delete(final String id){
        repository.deleteById(id);
    }

    public User getByEmail(final String email){
        return repository.findByEmail(email);
    }

    public Address createAddress(Address address){
        address.setId(UUID.randomUUID().toString());
        return addressRepository.save(address);
    }
    public Iterable<User> getAllUser(){
        return repository.findAll();
    }

}
