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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import  org.junit.jupiter.api.AfterEach;

import models.Product;
import repository.*;

import  org.junit.jupiter.api.BeforeEach;


public class ProductsRepositoryJdbcImplTest {

    private ProductsRepositoryJdbcImpl productsRepositoryJdbcImpl;
    DataSource dataSource;
    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = List.of(   new Product(1l,"PC", 100l),
                                                                new Product(2l,"MIC", 10l),
                                                                new Product(3l,"TESLA", 100000l),
                                                                new Product(4l,"BMW", 300000l),
                                                                new Product(5l,"plane", 22100000l));
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(1l, "PC", 100l);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(2l, "HAMZA", 100l);

    
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
        Product tmp = this.productsRepositoryJdbcImpl.findById(1l).get();
        assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, tmp);
    }

    @Test
    public void testUpdate() {
        this.productsRepositoryJdbcImpl.update(EXPECTED_UPDATED_PRODUCT);
        assertEquals(EXPECTED_UPDATED_PRODUCT, this.productsRepositoryJdbcImpl.findById(2l).get());
    }


    @Test
    void testSave(){
        Product p = new Product(null, "car", 10000l);
        this.productsRepositoryJdbcImpl.save(p);
        System.out.println(p.toString());
        System.out.println(this.productsRepositoryJdbcImpl.findById(p.getId()).get().toString());
        assertEquals(p, this.productsRepositoryJdbcImpl.findById(p.getId()).get());
    }


    @ParameterizedTest
    @ValueSource(longs= {1,2,3,4,5})
    void testDelete(long id) {
        this.productsRepositoryJdbcImpl.delete(id);
        assertThrows(RuntimeException.class, ()-> {
            this.productsRepositoryJdbcImpl.findById(id);
        });
    }
    @AfterEach
    void createDatabase() {
        try{
            this.dataSource.getConnection().createStatement().execute("SHUTDOWN");

        } catch(Exception e) {

        }
    }


}
