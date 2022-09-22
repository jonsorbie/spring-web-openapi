package sorbie.jon.springwebopenapi.controller;

import static org.springframework.http.HttpStatus.OK;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/** A demonstration controller showing several API endpoints.
 * @author c071919
 *
 */
/**
 * @param item
 * @return
 */
/**
 * @param item
 * @return
 */
/**
 * @param item
 * @return
 */
@RestController
public class OurController {

	Logger log = LoggerFactory.getLogger(OurController.class);

	/**
	 * Returns the customer with the specified account number.
	 * 
	 * @param accountNumber the customer's account number
	 * @return the customer with the specified account number
	 */
	@SecurityRequirement( //
			name = "oauth2", //
			scopes = { "openapidemo.view" } //
	)
	@ResponseStatus(code = HttpStatus.OK, reason = "The customer was found")
	@GetMapping("/customers/{accountNumber}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer accountNumber) {
		log.info("GET /customers, accountNumber: {}", accountNumber);
		Customer customer = new Customer(accountNumber, "John Doe", "a@b.com");
		return new ResponseEntity<>(customer, OK);
	}

	/**
	 * Returns the item with the specified item number
	 * 
	 * @param itemNumber the item number
	 * @return the item with the specified item number
	 */
	@SecurityRequirement( //
			name = "oauth2", //
			scopes = { "openapidemo.view" } //
	)
	@ResponseStatus(code = HttpStatus.OK, reason = "The item was found")
	@GetMapping("/items/{itemNumber}")
	public ResponseEntity<Item> getItem(@PathVariable Long itemNumber) {
		log.info("GET /items, itemNumber: {}", itemNumber);
		Item item = new Item(itemNumber, "Haribo Goldbears", "Delicious Gummy Candy");
		return new ResponseEntity<>(item, OK);
	}

	/**
	 * Creates a new item.
	 * 
	 * @param item the item to create
	 * @return the item that was created
	 */
	@SecurityRequirement( //
			name = "oauth2", //
			scopes = { "openapidemo.view", "openapidemo.all" } //
	)
	@ResponseStatus(code = HttpStatus.OK, reason = "The item was created")
	@PostMapping("/items")
	public ResponseEntity<Item> postItem(@RequestBody Item item) {
		log.info("POST /items, itemNumber: {}", item.itemNumber);
		return new ResponseEntity<>(item, OK);
	}
}
