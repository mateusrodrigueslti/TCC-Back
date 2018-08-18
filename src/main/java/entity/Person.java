package entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "person")
public class Person implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column
    private String rg;

    @Column
    private String cpf;

    @Column
    private String occupation;

    @Column
    private String gender;

    @Column
    private String maritalStatus;

    @Column
    private String phone;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Address address;
}
