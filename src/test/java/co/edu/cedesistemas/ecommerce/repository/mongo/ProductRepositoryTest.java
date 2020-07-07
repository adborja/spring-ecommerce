package co.edu.cedesistemas.ecommerce.repository.mongo;

import co.edu.cedesistemas.ecommerce.common.TestUtils;
import co.edu.cedesistemas.ecommerce.model.document.Product;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class ProductRepositoryTest {
    @Autowired private ProductRepository repository;

    @Test
    public void testSaveProduct() {
        String id = UUID.randomUUID().toString();
        Product product = TestUtils.buildProduct("test_repo_product", "product description");
        product.setId(id);
        product.setCreatedAt(LocalDateTime.now());

        Product saved = this.repository.save(product);

        assertThat(saved, notNullValue());
        assertThat(saved.getId(), equalTo(id));
    }

    @Test
    public void testFindById() {
        String id = UUID.randomUUID().toString();
        Product product = TestUtils.buildProduct("test_repo_product", "product description");
        product.setId(id);
        product.setCreatedAt(LocalDateTime.now());

        repository.save(product);

        Product found = repository.findById(id).orElse(null);

        assertThat(found, notNullValue());
        assertThat(found.getName(), equalTo("test_repo_product"));
    }

    @Test
    public void testFindByName() {
        String prefix = "test_repo_" + RandomString.make(3) + "_";
        Product product1 = TestUtils.buildProduct(prefix + RandomString.make(10),
                "product description");
        product1.setId(UUID.randomUUID().toString());
        product1.setCreatedAt(LocalDateTime.now());
        repository.save(product1);

        Product product2 = TestUtils.buildProduct(prefix + RandomString.make(10),
                "product description");
        product2.setId(UUID.randomUUID().toString());
        product2.setCreatedAt(LocalDateTime.now());
        repository.save(product2);

        List<Product> found = repository.findByNameLike(prefix);

        assertThat(found.size(), equalTo(2));
    }

    @Test
    public void testFindByDescription() {
        String prefix = "test_repo_" + RandomString.make(3) + "_";
        Product product1 = TestUtils.buildProduct(prefix + RandomString.make(10),
                prefix + RandomString.make(10) + "_desc");
        product1.setId(UUID.randomUUID().toString());
        product1.setCreatedAt(LocalDateTime.now());
        repository.save(product1);

        Product product2 = TestUtils.buildProduct(prefix + RandomString.make(10),
                prefix + RandomString.make(10) + "_desc");
        product2.setId(UUID.randomUUID().toString());
        product2.setCreatedAt(LocalDateTime.now());
        repository.save(product2);

        Product product3 = TestUtils.buildProduct(prefix + RandomString.make(10),
                prefix + RandomString.make(10) + "_desc");
        product3.setId(UUID.randomUUID().toString());
        product3.setCreatedAt(LocalDateTime.now());
        repository.save(product3);

        List<Product> found = repository.findByDescriptionLike(prefix);

        assertThat(found.size(), equalTo(3));
    }
}
