package entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column
    private String fathersName;

    @Column
    private String mothersName;

    @Column
    private String nationality;

    @Column
    private String naturalness;

    @Column(columnDefinition = "TEXT")
    private String criminalPattern;

    //@OneToOne(fetch = FetchType.EAGER)
    //@MapsId
    //private CriminalPattern criminalPattern;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Address address;

}
