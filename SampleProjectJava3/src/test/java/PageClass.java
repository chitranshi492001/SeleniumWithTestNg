public class PageClass {
    public String username() {
        return "//input[@id='user-name']";
    }

    public String password() {
        return "//input[@id='password']";
    }

    public String loginbtn() {
        return "//input[@id='login-button']";
    }

    public String item1() {
        return "//button[@id='add-to-cart-sauce-labs-bike-light']";
    }

    public String item2() {
        return "//button[@id='add-to-cart-sauce-labs-fleece-jacket']";
    }

    public String item3() {
        return "//button[@id='add-to-cart-sauce-labs-onesie']";
    }

    public String shopingCartLink() {
        return "//a[@class='shopping_cart_link']";
    }

    public String checkOut() {
        return "//button[@id='checkout']";
    }

    public String firstName() {
        return "//input[@id='first-name']";
    }

    public String lastName() {
        return "//input[@id='last-name']";
    }

    public String postalCode() {
        return "//input[@id='postal-code']";
    }

    public String continu() {
        return "//input[@id='continue']";
    }

    public String summary() {
        return "//div[@class='summary_total_label']";
    }

    public String finisg() {
        return "//button[@id='finish']";
    }

    public String back() {
        return "//button[@id='back-to-products']";
    }

    public String error() {
        return "h3[data-test='error']";

    }
}
