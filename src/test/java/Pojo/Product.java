package Pojo;

public class Product {

    private String name;
    private String description;
    private double pricePounds;
    private double priceEuro;
    private double priceDollar;

    public Product(String name, String description, double pricePounds, double priceEuro, double priceDollar) {
        this.name = name;
        this.description = description;
        this.pricePounds = pricePounds;
        this.priceEuro = priceEuro;
        this.priceDollar = priceDollar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPricePounds() {
        return pricePounds;
    }

    public void setPricePounds(double pricePounds) {
        this.pricePounds = pricePounds;
    }

    public double getPriceEuro() {
        return priceEuro;
    }

    public void setPriceEuro(double priceEuro) {
        this.priceEuro = priceEuro;
    }

    public double getPriceDollar() {
        return priceDollar;
    }

    public void setPriceDollar(double priceDollar) {
        this.priceDollar = priceDollar;
    }
}
