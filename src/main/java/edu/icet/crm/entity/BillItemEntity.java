package edu.icet.crm.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="billItem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BillItem_Id;
    private Long Bill_Id;
    private Long  product_ID;
    private Integer Qty;
    private Double Total_Amount;
}
