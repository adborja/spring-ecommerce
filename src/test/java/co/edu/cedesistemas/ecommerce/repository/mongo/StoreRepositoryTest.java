package co.edu.cedesistemas.ecommerce.repository.mongo;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import co.edu.cedesistemas.ecommerce.common.TestUtils;
import co.edu.cedesistemas.ecommerce.model.document.Store;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class StoreRepositoryTest {
    @Autowired private StoreRepository storeRepository;

    @Test
    public void testSaveStore() {
        String id = UUID.randomUUID().toString();
        Store store = TestUtils.buildStore("test_repo_store", "+578963211",
                "Cl. 45 # 74 - 55", Store.Type.AUTO_PARTS);
        store.setId(id);
        store.setCreatedAt(LocalDateTime.now());

        Store saved = storeRepository.save(store);

        assertThat(saved, notNullValue());
        assertThat(saved.getId(), equalTo(id));
    }

    @Test
    public void testFindByNameLike() {
        String prefix = "test_repo_" + RandomString.make(3) + "_";
        Store store1 = TestUtils.buildStore(prefix + RandomString.make(10),
                "123456789", "some address", Store.Type.AUTO_PARTS);
        store1.setId(UUID.randomUUID().toString());
        store1.setCreatedAt(LocalDateTime.now());
        storeRepository.save(store1);

        Store store2 = TestUtils.buildStore(prefix + RandomString.make(10),
                "123456789", "some address", Store.Type.AUTO_PARTS);
        store2.setId(UUID.randomUUID().toString());
        store2.setCreatedAt(LocalDateTime.now());
        storeRepository.save(store2);

        Store store3 = TestUtils.buildStore(prefix + RandomString.make(10),
                "123456789", "some address", Store.Type.AUTO_PARTS);
        store3.setId(UUID.randomUUID().toString());
        store3.setCreatedAt(LocalDateTime.now());
        storeRepository.save(store3);

        List<Store> stores = storeRepository.findByNameLike(prefix);
        assertThat(stores.size(), equalTo(3));
    }

    @Test
    public void testFindByType() {
        String prefix = "test_repo_" + RandomString.make(3) + "_";
        Store store1 = TestUtils.buildStore(prefix + RandomString.make(10),
                "123456789", "some address", Store.Type.SPORTS);
        store1.setId(UUID.randomUUID().toString());
        store1.setCreatedAt(LocalDateTime.now());
        storeRepository.save(store1);

        Store store2 = TestUtils.buildStore(prefix + RandomString.make(10),
                "123456789", "some address", Store.Type.SPORTS);
        store2.setId(UUID.randomUUID().toString());
        store2.setCreatedAt(LocalDateTime.now());
        storeRepository.save(store2);

        List<Store> stores = storeRepository.findByType(Store.Type.SPORTS);
        assertThat(stores.size(), equalTo(2));
    }
}
