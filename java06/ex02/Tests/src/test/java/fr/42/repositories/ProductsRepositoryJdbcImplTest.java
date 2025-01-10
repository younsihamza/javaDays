import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import  org.junit.jupiter.api.AfterEach;

import models.Product;
import repository.*;

import  org.junit.jupiter.api.BeforeEach;


public class ProductsRepositoryJdbcImplTest {

    private ProductsRepositoryJdbcImpl productsRepositoryJdbcImpl;
    DataSource dataSource;
    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = List.of(   new Product(0l,"PC", 100l),
                                                                new Product(1l,"MIC", 10l),
                                                                new Product(2l,"TESLA", 100000l),
                                                                new Product(3l,"BMW", 300000l),
                                                                new Product(4l,"plane", 22100000l));
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(0l, "PC", 100l);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(1l, "laptop", 90l);

    
    @BeforeEach
    public void init() {
        this.dataSource = new EmbeddedDatabaseBuilder()
                            .setType(EmbeddedDatabaseType.HSQL)
                            .addScript("classpath:schema.sql")
                            .addScript("classpath:data.sql")
                            .build();
        this.productsRepositoryJdbcImpl = new ProductsRepositoryJdbcImpl(dataSource);
    }

    @Test
    public void testFindAll() {
        assertIterableEquals(EXPECTED_FIND_ALL_PRODUCTS, this.productsRepositoryJdbcImpl.findAll());
    } 

    @Test
    public void testFindId() {
        Product tmp = this.productsRepositoryJdbcImpl.findById(0l).get();
        System.out.println(tmp.getName()  + "  " + tmp.getId() + " " + tmp.getPrice());
        assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, tmp);
    }
    @AfterEach
    void createDatabase() {
        try{
            this.dataSource.getConnection().createStatement().execute("SHUTDOWN");

        } catch(Exception e) {

        }
    }

}
