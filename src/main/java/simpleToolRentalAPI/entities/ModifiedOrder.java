package simpleToolRentalAPI.entities;

public class ModifiedOrder {
    String customerName;
    String comment;

    public ModifiedOrder(String customerName, String comment) {
        this.customerName = customerName;
        this.comment = comment;
    }

    public ModifiedOrder() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ModifiedOrder{" +
                "customerName='" + customerName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
