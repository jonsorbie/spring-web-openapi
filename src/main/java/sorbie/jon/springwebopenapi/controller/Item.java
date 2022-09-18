package sorbie.jon.springwebopenapi.controller;

public class Item {

    public Integer itemNumber;
    public String name;
    public String description;

    public Item(Integer itemNumber, String name, String description) {
        this.itemNumber = itemNumber;
        this.name = name;
        this.description = description;
    }
}
