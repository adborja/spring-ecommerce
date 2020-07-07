package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.common.TestUtils;
import co.edu.cedesistemas.ecommerce.model.document.Product;
import co.edu.cedesistemas.ecommerce.repository.mongo.ProductRepository;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock private ProductRepository repository;
    @InjectMocks private ProductService service;

    @Test
    public void testCreateProduct() {
        String prefix = "test_product_" + RandomString.make(3) + "_";
        Product product = TestUtils.buildProduct(prefix + RandomString.make(10),
                "product description");

        when(repository.save(product)).thenReturn(product);

        Product created = service.createProduct(product);

        assertThat(created.getId(), notNullValue());
        assertThat(created.getCreatedAt(), notNullValue());
    }

    @Test
    public void testGetById() {
        String prefix = "test_product_" + RandomString.make(3) + "_";
        Product product = TestUtils.buildProduct(prefix + RandomString.make(10),
                "product description");

        when(repository.save(product)).thenReturn(product);

        Product created = service.createProduct(product);

        when(repository.findById(created.getId())).thenReturn(Optional.of(created));

        String id = created.getId();

        Product found = service.getById(id);

        assertThat(found, notNullValue());
    }

    @Test
    public void testGetByName() {
        String prefix = "test_product_" + RandomString.make(3) + "_";
        Product product1 = TestUtils.buildProduct(prefix + RandomString.make(10),
                "product description");
        Product product2 = TestUtils.buildProduct(prefix + RandomString.make(10),
                "product description");

        List<Product> products = Arrays.asList(product1, product2);

        when(repository.findByNameLike(prefix)).thenReturn(products);

        List<Product> found = service.getByName(prefix);

        assertThat(found.size(), equalTo(2));
    }

    @Test
    public void testGetByDescription() {
        String prefix = "test_product_" + RandomString.make(3) + "_";
        Product product1 = TestUtils.buildProduct(prefix + RandomString.make(10),
                prefix + RandomString.make(10) + "_desc");
        Product product2 = TestUtils.buildProduct(prefix + RandomString.make(10),
                prefix + RandomString.make(10) + "_desc");

        List<Product> products = Arrays.asList(product1, product2);

        when(repository.findByDescriptionLike(prefix)).thenReturn(products);

        List<Product> found = service.getByDescription(prefix);

        assertThat(found.size(), equalTo(2));
    }
}