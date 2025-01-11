package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import javax.sql.DataSource;


import models.*;
public class ProductsRepositoryJdbcImpl implements ProductRepository{
    private DataSource dataSource;

    public ProductsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<Product> findAll() {
        try(Connection connection = dataSource.getConnection()) {
            String query = "SELECT * FROM Product;";
            try(PreparedStatement statement = connection.prepareStatement(query)) {
                try(ResultSet result =  statement.executeQuery()){
                    List<Product>  productsList = new ArrayList<>();
                    while(result.next()) {
                        productsList.add(new Product(result.getLong("id"),
                                            result.getString("name"),
                                            result.getLong("price")));
                    }
                    return productsList;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Optional<Product> findById(Long id) {
        Optional<Product> product = Optional.empty();
        try(Connection connection = dataSource.getConnection()){
            String query = "SELECT * FROM Product WHERE id = ?";
            try(PreparedStatement statement =  connection.prepareStatement(query)){
                statement.setLong(1, id);
                try(ResultSet result = statement.executeQuery()) {
                    result.next();
                    product = Optional.of(new Product(result.getLong("id"),
                                            result.getString("name"),
                                            result.getLong("price")));
                }
            }
        }catch(Exception e) {
            throw new NoDatabaseNotUpdateIt("object not found");
        }
        return product;
    }

    public void update(Product product) {
        try(Connection connection = dataSource.getConnection()) {
            String query = "UPDATE product SET name = ? , price = ? WHERE id = ? ";
            try(PreparedStatement statment = connection.prepareStatement(query)) {
                    statment.setString(1, product.getName());
                    statment.setLong(2, product.getPrice());
                    statment.setLong(3, product.getId());
                int rs = statment.executeUpdate();

            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void save(Product product) {
        try(Connection connection =  dataSource.getConnection()) {
            String query = "INSERT INTO product (name, price) VALUES (?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
                statement.setString(1, product.getName());
                statement.setLong(2, product.getPrice());
                int rs = statement.executeUpdate();
                if(rs == 0)
                    throw new NoDatabaseNotUpdateIt("data base not update it ");
                try(ResultSet resultSource = statement.getGeneratedKeys()){
                    if(resultSource.next())
                        product.setId(resultSource.getLong(1));
                    else 
                        throw new NoDatabaseNotUpdateIt("data base not update it ");
                }  
            }
        }catch(Exception e) {
            throw new NoDatabaseNotUpdateIt(e.getMessage());
        }
    }

    public void delete(Long id){
        try(Connection connection = dataSource.getConnection()) {
            String query = "DELETE FROM product WHERE id = ?";
            try(PreparedStatement statment = connection.prepareStatement(query)){
                statment.setLong(1, id);
                int result = statment.executeUpdate();
                if(result == 0)
                    throw new NoDatabaseNotUpdateIt("No rows affected, ID not found");
            }
        } catch(Exception e) {
            throw new NoDatabaseNotUpdateIt(e.getMessage());
        }
    }

    public class  NoDatabaseNotUpdateIt extends RuntimeException {
        NoDatabaseNotUpdateIt(String message){
            super(message);
        }
    }
}
