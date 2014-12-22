package molk.javadrinkup;

public class Drink {

    private long id;
    private long category; // alkosoda, beer, cider, drink, wine, ...

    private String name;
    private String info;
    private String url;
    private long imageResource;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getImageResource() {
        return imageResource;
    }

    public void setImageResource(long imageResource) {
        this.imageResource = imageResource;
    }
}
