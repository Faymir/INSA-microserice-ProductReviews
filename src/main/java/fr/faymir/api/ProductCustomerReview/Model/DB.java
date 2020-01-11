package fr.faymir.api.ProductCustomerReview.Model;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DB {
    private static DB instance = null;
    private List<CustomerReview> reviews = null;

    private DB(){
        reviews = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 200; i++) {
            Faker faker = new Faker(new Locale("fr"));
            String comment = (i % 2 == 0) ? faker.chuckNorris().fact() : faker.backToTheFuture().quote();
            reviews.add(new CustomerReview(
                    rand.nextInt(100),
                    comment,
                    faker.number().numberBetween(0,5)
            ));
        }
    }

    public static DB getInstance(){
        if(instance == null){
            instance = new DB();
        }
        return instance;
    }

    public List<CustomerReview> reviews(){
        return reviews;
    }

    public void addCustomerReview(CustomerReview customerReview){
        reviews.add(customerReview);
    }

    public boolean deleteReview(int id){
        return reviews.removeIf(r -> r.getId().equals(id));
    }
}
