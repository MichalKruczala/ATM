package pl.kruczala.michal;

public class PayOutResult {
    private final int nominal;
    private final int quantity;

    public PayOutResult(int nominal, int quantity) {
        this.nominal = nominal;
        this.quantity = quantity;
    }

    public int getNominal() {
        return this.nominal;
    }

    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public String toString() {
        return getNominal() + " złotych x " + getQuantity();
    }
}

