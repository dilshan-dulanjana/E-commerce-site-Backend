package edu.icet.crm.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin {
    private Long ID;
    private String name;
    private String contactNumber;
    private String Email;
    private String password;
    private String address;
    private String category;
}
