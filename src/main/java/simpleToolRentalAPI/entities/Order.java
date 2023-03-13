package simpleToolRentalAPI.entities;

public class Order {
    private int toolId;
    private String customerName;
    private String comment;

    public Order(int toolId, String customerName, String comment) {
        this.toolId = toolId;
        this.customerName = customerName;
        this.comment = comment;
    }

    public Order() {
    }

    public int getToolId() {
        return toolId;
    }

    public void setToolId(int toolId) {
        this.toolId = toolId;
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
        return "Order{" +
                "toolId=" + toolId +
                ", customerName='" + customerName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
