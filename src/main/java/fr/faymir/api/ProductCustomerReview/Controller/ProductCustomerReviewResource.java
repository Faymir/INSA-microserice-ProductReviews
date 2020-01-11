package fr.faymir.api.ProductCustomerReview.Controller;

import fr.faymir.api.ProductCustomerReview.Model.CustomerReview;
import fr.faymir.api.ProductCustomerReview.Model.DB;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("reviews")
public class ProductCustomerReviewResource {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<CustomerReview> addReviews(@RequestBody List<CustomerReview> reviews){
        reviews.forEach(r -> DB.getInstance().addCustomerReview(r));
        return reviews;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable("id") Integer id){
        DB.getInstance().deleteReview(id);
    }

    @PostMapping("/one")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerReview addReview(@RequestBody CustomerReview review){
        DB.getInstance().addCustomerReview(review);
        return review;
    }



    @GetMapping("/{id}")
    public List<CustomerReview> getReview(@PathVariable("id") Integer id){
        return DB.getInstance().reviews().stream().filter(
                review -> review.getId().equals(id)).collect(Collectors.toList());
    }

    @GetMapping
    public List<CustomerReview> listAll(){
        return DB.getInstance().reviews();
    }
}
