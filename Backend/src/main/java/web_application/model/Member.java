package web_application.model;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class Member extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Member(String firstName, String lastName, String birthDate, String email, String phoneNumb, String address, String city, String country, String postalCode, String username, String password){
        super(firstName,lastName,birthDate,email,phoneNumb,address,city,country,postalCode,username,password);
    }

    public Member(Long id,String firstName, String lastName, String birthDate, String email, String phoneNumb, String address, String city, String country, String postalCode, String username, String password){
        super(firstName,lastName,birthDate,email,phoneNumb,address,city,country,postalCode,username,password);
        this.id = id;
    }

    public Member(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
