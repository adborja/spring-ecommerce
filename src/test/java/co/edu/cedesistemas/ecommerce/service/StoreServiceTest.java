package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.common.TestUtils;
import co.edu.cedesistemas.ecommerce.model.document.Store;
import co.edu.cedesistemas.ecommerce.repository.mongo.StoreRepository;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StoreServiceTest {
    @Mock private StoreRepository repository;
    @InjectMocks private StoreService service;

    @Test
    public void testCreateStore() {
        String prefix = "test_service_" + RandomString.make(3) + "_";
        Store store = TestUtils.buildStore(prefix + RandomString.make(10),
                "987456321", "cl. 88 # 70 - 50", Store.Type.SPORTS);

        when(repository.save(store)).thenReturn(store);

        Store created = service.createStore(store);

        assertThat(created.getId(), notNullValue());
        assertThat(created.getCreatedAt(), notNullValue());
    }

    @Test
    public void testGetById() {
        String prefix = "test_service_" + RandomString.make(3) + "_";
        Store store = TestUtils.buildStore(prefix + RandomString.make(10),
                "987456321", "cl. 88 # 70 - 50", Store.Type.TECHNOLOGY);

        when(repository.save(store)).thenReturn(store);

        Store created = service.createStore(store);

        when(repository.findById(created.getId())).thenReturn(Optional.of(created));

        String id = created.getId();

        Store found = service.getById(id);

        assertThat(found, notNullValue());
    }
}