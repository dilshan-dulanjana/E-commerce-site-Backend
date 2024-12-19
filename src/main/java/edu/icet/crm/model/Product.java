package edu.icet.crm.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private Long id;
    private String Name;
    private String catagory;
    private String size;
    private String barcode;
    private Integer qty;
    private Double unitPrice;
    private String imageUrl;
}

