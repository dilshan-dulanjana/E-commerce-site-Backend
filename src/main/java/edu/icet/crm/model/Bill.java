package edu.icet.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    private Long Bill_Id;
    private Long  customer_Id;
    private Double Bill_Total;
}
