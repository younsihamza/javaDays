import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import java.sql.Connection;
public class EmbeddedDataSourceTest {
    // DataSource datasource;
    // @BeforeEach
    // public void init() {
    //     datasource  = new EmbeddedDatabaseBuilder()
    //                     .setType(EmbeddedDatabaseType.HSQL)
    //                     .addScript("classpath:schema.sql")
    //                     .addScript("classpath:data.sql")
    //                     .build();
    // }
    // @Test
    // void checkConnection(){
    //     try(Connection connection = datasource.getConnection()) {
    //         assertNotNull(connection);
    //     } catch(Exception e) {
    //         System.out.println(e.getMessage());
    //     }
    // }
}