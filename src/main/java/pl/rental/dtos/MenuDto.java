package pl.rental.dtos;

public class MenuDto {

    private String name;
    private String link;

    public MenuDto(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public MenuDto() {
    }

    public String getName() {
        return name;
    }

    public MenuDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getLink() {
        return link;
    }

    public MenuDto setLink(String link) {
        this.link = link;
        return this;
    }
}
