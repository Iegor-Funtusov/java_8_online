package ua.com.alevel.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.alevel.exception.EntityNotFoundException;
import ua.com.alevel.exception.EntityUnexistsException;
import ua.com.alevel.exception.NotValidFieldDataException;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.repositoty.product.ProductRepository;
import ua.com.alevel.service.product.impl.ProductServiceImpl;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static ua.com.alevel.util.ExceptionUtil.*;

@SpringBootTest
public class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl service;

    @Mock
    private ProductRepository productRepository;

    private Product product = new Product();
    private static final Long TEST_ID = 1L;

    @Test
    public void shouldBeCreateProductThenProductIsNull() {
        // given
        product = null;

        // when
        EntityUnexistsException exception = Assertions.assertThrows(EntityUnexistsException.class, () -> service.create(product));

        // then
        assertThat(exception).isInstanceOf(EntityUnexistsException.class);
        assertThat(exception.getMessage()).isEqualTo(ENTITY_UNEXISTS_EXCEPTION);
    }

    @Test
    public void shouldBeCreateProductThenProductNameIsNull() {
        // given
        product = new Product();
        product.setName(null);

        // when
        NotValidFieldDataException exception = Assertions.assertThrows(NotValidFieldDataException.class, () -> service.create(product));

        // then
        assertThat(exception).isInstanceOf(NotValidFieldDataException.class);
        assertThat(exception.getMessage()).isEqualTo(NOT_VALID_FIELD_DATA_EXCEPTION);
    }

    @Test
    public void shouldBeCreateProductThenProductNameIsValid() {
        // given
        product = new Product();
        product.setName("Test name");

        // when
        service.create(product);

        // then
        Mockito.verify(productRepository, Mockito.times(1)).save(product);
    }

    @Test
    public void shouldBeFindProductThenProductIdIsNull() {
        // given
        Long id = null;

        // when
        NotValidFieldDataException exception = Assertions.assertThrows(NotValidFieldDataException.class, () -> service.findById(id));

        // then
        assertThat(exception).isInstanceOf(NotValidFieldDataException.class);
        assertThat(exception.getMessage()).isEqualTo(NOT_VALID_ID_EXCEPTION);
    }

    @Test
    public void shouldBeFindProductThenProductIdIsNotNullButProductNotExists() {
        // given
        Long id = TEST_ID;

        // when
        EntityNotFoundException exception = Assertions.assertThrows(EntityNotFoundException.class, () -> service.findById(id));

        // then
        assertThat(exception).isInstanceOf(EntityNotFoundException.class);
        assertThat(exception.getMessage()).isEqualTo(ENTITY_NOT_FOUND_EXCEPTION);
    }

    @Test
    public void shouldBeFindProductThenProductIdIsCorrect() {
        // given
        product.setId(TEST_ID);
        Mockito.when(productRepository.findById(TEST_ID)).thenReturn(Optional.of(product));

        // when
        product = service.findById(TEST_ID);

        // then
        assertThat(product).isNotNull();
        assertThat(product.getId()).isEqualTo(TEST_ID);
    }
}
