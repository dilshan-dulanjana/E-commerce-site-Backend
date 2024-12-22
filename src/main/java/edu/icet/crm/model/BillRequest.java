package edu.icet.crm.model;

import java.util.List;

public class BillRequest {

    private Bill bill;
    private List<BillItem> billItems;

    // Getters and Setters
    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<BillItem> billItems) {
        this.billItems = billItems;
    }
}
