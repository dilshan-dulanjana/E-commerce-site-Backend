package edu.icet.crm.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillItem {

    private Long BillItem_Id;
    private Long Bill_Id;
    private Long  product_ID;
    private Integer Qty;
    private Double Total_Amount;
}
