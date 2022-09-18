package sorbie.jon.springwebopenapi.controller;

import org.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
public class OurController {

    Logger log = LoggerFactory.getLogger(OurController.class);

    @GetMapping("/customers/{accountNumber}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer accountNumber) {
        log.info("GET /customers, accountNumber: {}", accountNumber);
        Customer customer = new Customer(accountNumber, "John Doe", "a@b.com");
        return new ResponseEntity<>(customer, OK);
    }

    @GetMapping("/items/{itemNumber}")
    public ResponseEntity<Item> getItem(@PathVariable Integer itemNumber) {
        log.info("GET /items, itemNumber: {}", itemNumber);
        Item item = new Item(itemNumber, "Haribo Goldbears", "Delicious Gummy Candy");
        return new ResponseEntity<>(item, OK);
    }
}
