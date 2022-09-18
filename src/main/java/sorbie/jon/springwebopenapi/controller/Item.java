package sorbie.jon.springwebopenapi.controller;

public class Item {

    public Long itemNumber;
    public String name;
    public String description;

    public Item(Long itemNumber, String name, String description) {
        this.itemNumber = itemNumber;
        this.name = name;
        this.description = description;
    }
}
