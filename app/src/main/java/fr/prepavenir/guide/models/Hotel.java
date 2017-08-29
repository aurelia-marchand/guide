package fr.prepavenir.guide.models;

/**
 * Created by aurel on 25/08/2017.
 */

public class Hotel {
    public Hotel(String name, String category, String phone, String email, String url, String etoile, String image) {
        this.name = name;
        this.category = category;
        this.phone = phone;
        this.email = email;
        this.url = url;
        this.etoile = etoile;
        this.image = image;
    }

    private String name;
    private String category;
    private String phone;
    private String email;
    private String url;
    private String etoile;
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEtoile() {
        return etoile;
    }

    public void setEtoile(String etoile) {
        this.etoile = etoile;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}