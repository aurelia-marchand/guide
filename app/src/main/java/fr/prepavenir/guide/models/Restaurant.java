package fr.prepavenir.guide.models;

/**
 * Created by aurel on 24/08/2017.
 */

public class Restaurant {

    private String name;
    private String categorie;
    private String email;
    private String phone;
    private String url;
    private String image;

    public Restaurant(String name, String categorie, String email, String phone, String url, String image) {
        this.name = name;
        this.categorie = categorie;
        this.email = email;
        this.phone = phone;
        this.url = url;
        this.image = image;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
