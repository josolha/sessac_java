package example0728;

public class OrderFactory {

    public static Order createOrder(String type, String menu, int count, int price) {

        switch (type) {
            case "Delivery":
                return new DeliveryOrder(menu, count, price);
            case "HereOrder":
                return new HereOrder(menu, count, price);
            case "TakeoutOrder":
                return new TakeoutOrder(menu, count, price);
        }
        return null;
    }
}
