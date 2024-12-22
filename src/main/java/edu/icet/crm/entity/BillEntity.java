package edu.icet.crm.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Bill")
@Setter
@Getter
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Bill_Id;
    private Long  customer_Id;
    private Double Bill_Total;
}
