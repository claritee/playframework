package javaguide.templates;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import play.test.WithApplication;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class JavaTemplate extends WithApplication {

    @Before
    public void setUp() {
    }

    @Test
    public void global() {
    }

    @Test
    public void exampleTemplate() {
        Customer customer = new Customer("mr customer");
        List<Order> orders = new ArrayList<Order>(Arrays.asList([new Order("foo"), new Order("bar")]));

        //#invoke-template
        Content html = views.html.Application.index.render(customer, orders);
        //#invoke-template

        String body = html.body;

        assertTrue(body.contains("mr customer"));
        assertTrue(body.contains("foo"));
        assertTrue(body.contains("bar"));
    }

    public static class Customer {
        private String name;
        public Customer(String name) {
            this.name = name;
        }
    }

    public static class Order {
        private String title;
        public Order(String title) {
            this.title = title;
        }
    }

    public static class Product {
        private String name;
        private String price;
        public Product(String name, String price) {
            this.name = name;
            this.price = price;
        }
    }

    public static class User {
        private String firstName;
        private String lastName;
        public User(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    public static class Article {
        private String name;
        public Article(String name) {
            this.name = name;
        }
    }
}