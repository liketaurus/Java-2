package domain;

/**
 * Клас, який моделює клієнта банку
 *
 * @author Олександр
 */
public class Customer {

    /**
     * Ідентифікатор клієнта
     */
    private int ID;
    /**
     * новий клієнт чи існуючий
     */
    private boolean isNew;
    /**
     * сума покупок за рік
     */
    private double total;

    public Customer(int ID, double total) {
        if (!setID(ID)) {
            System.out.println("ERROR! ID cannot be negative!");
            System.exit(0);
        }
        this.isNew = true;
        this.setTotal(total);
    }

    public Customer() {
        this.ID = 1;
        this.isNew = true;
        this.total = 1000;
    }

    private boolean setID(int ID) {
        if (ID > 0) {
            this.ID = ID;
            return true;
        }
        return false;
    }

    private void setExisting() {
        if (this.total != 0) {
            this.isNew = false;
        }
    }
/** 
 * Метод для зміни суми продажів
 * @param total - нова сума
 * @return {@code true} якщо операція успішна {@code false} якщо була помилка (ідентифікатор від'ємний)
 */
    public boolean setTotal(double total) {
        if (total > 0) {
            this.total = total;
            setExisting();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
//        String status="existing client";
//        if (this.isNew) 
//            status="new client";
        String status = this.isNew ? "new client" : "existing client";

        return "Customer Info:\n\tID: " + ID + "\n\t" + status + "\n\ttotal: $" + total;
    }

}
