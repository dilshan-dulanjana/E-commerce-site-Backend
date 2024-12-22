package edu.icet.crm.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    private String contactNumber;
    private String Email;
    private String password;
    private String address;
    private String category="admin";
}
