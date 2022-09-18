package sorbie.jon.springwebopenapi.controller;

public class Customer {

    public Integer accountNumber;
    public String name;
    public String email;

    public Customer(Integer accountNumber, String name, String email) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.email = email;
    }
}
