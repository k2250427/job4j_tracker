package ru.job4j.streams;

public class Product {
    private int id;
    private String name;
    private MeasUnits unit;
    private int qty;
    private String article;
    private double cost;
    private double tax;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit=" + unit +
                ", qty=" + qty +
                ", article='" + article + '\'' +
                ", cost=" + cost +
                ", tax=" + tax +
                '}';
    }

    static class Builder {
        private int id;
        private String name;
        private MeasUnits unit;
        private int qty;
        private String article;
        private double cost;
        private double tax;

        Builder buildId(int id) {
            this.id = id;
            return this;
        }

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildUnit(MeasUnits unit) {
            this.unit = unit;
            return this;
        }

        Builder buildQty(int qty) {
            this.qty = qty;
            return this;
        }

        Builder buildArticle(String article) {
            this.article = article;
            return this;
        }

        Builder buildCost(double cost) {
            this.cost = cost;
            return this;
        }

        Builder buildTax(double tax) {
            this.tax = tax;
            return this;
        }

        Product build() {
            Product product = new Product();
            product.id = id;
            product.name = name;
            product.unit = unit;
            product.qty = qty;
            product.article = article;
            product.cost = cost;
            product.tax = tax;
            return product;
        }
    }

    public static void main(String[] args) {
        Product product = new Builder()
                .buildId((int) (Math.random() * 999999))
                .buildName("boss")
                .buildUnit(MeasUnits.Piece)
                .buildQty(32)
                .buildArticle("B-04523")
                .buildCost(2500.00)
                .buildTax(2500.00 * 0.2)
                .build();
        System.out.println(product);
    }
}
