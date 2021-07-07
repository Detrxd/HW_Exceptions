import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.NotFoundException;
import repository.ProductRepository;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();

    private Product firstBook = new Product(1, "Сказки", 2000);

    private Product secondBook = new Product(2, "Пословицы", 1800);

    @BeforeEach
    public void fillProducts() {
        repository.save(firstBook);
        repository.save(secondBook);
    }

    @Test
    public void shouldRemoveByIdNotException() {
        repository.removeById(1);
        assertArrayEquals(new Product[]{secondBook}, repository.findAll());
    }

    @Test
    public void ShouldRemoveById() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(-96);
        });
    }
}
