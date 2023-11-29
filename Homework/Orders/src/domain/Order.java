/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author alexa
 */
import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Item> items;
    private String shippingAddress;
    private String paymentMethod;
    private String status;

    public Order() {
        this.items = new ArrayList<>();
        status = "нове";
    }

    public void addItem(Item item) {
        // Додавання товару до замовлення
        items.add(item);

    }

    public int getNumberOfItems() {
        return items.size();
    }

    public void removeItem(Item item) {
        // Видалення товару з замовлення
        items.remove(item);
    }

    public double calculateTotal() {
        // Розрахунок загальної суми замовлення
        double total = 0;
        for (Item item : items) {
            total = total + item.price;
        }
        return total;
    }

    public void placeOrder() throws EmptyOrderException {
        // Оформлення замовлення
        if (items.isEmpty()) {
            status = "відхилене";
            throw new EmptyOrderException("Неможливо оформити порожнє замовлення");
        }
        // Реалізація оформлення замовлення
        status = "прийняте";
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nІнформація про замовлення:\n\tСтатус: " + status + "\n\tСклад замовлення:");
        if (items.size() == 0) {
            s.append(" не додано жодного товару");
            return s.toString();
        }
        s.append("\n\tНазва товару\tКількість\tВартість");
        s.append("\n\t------------------------------------------");
        for (Item item : items) {
            s.append("\n\t" + item.name + "\t" + item.quantity + "шт.\t\t" + item.quantity * item.price + "грн.");
        }
        s.append("\n\t------------------------------------------");
        s.append("\n\tЗагальна вартість (до оплати): " + calculateTotal() + "грн.");
        return s.toString();
    }

    // Геттери та сеттери для shippingAddress та paymentMethod
    // Вкладений клас для представлення товарів у замовленні
    public static class Item {

        private String name;
        private double price;
        private int quantity;

        public Item(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        // Геттери та сеттери для name та price
    }
}
