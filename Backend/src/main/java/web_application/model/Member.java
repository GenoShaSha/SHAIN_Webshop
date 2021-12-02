package web_application.model;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class Member extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role;

    public Member(String firstName, String lastName, String birthDate, String email, String phoneNumb, String address, String city, String country, String postalCode, String username, String password,String role){
        super(firstName,lastName,birthDate,email,phoneNumb,address,city,country,postalCode,username,password);
        this.role = role;
    }

    public Member(Long id,String firstName, String lastName, String birthDate, String email, String phoneNumb, String address, String city, String country, String postalCode, String username, String password,String role){
        super(firstName,lastName,birthDate,email,phoneNumb,address,city,country,postalCode,username,password);
        this.id = id;
        this.role = role;
    }

    public Member(String email, String username, String password) {
        super(email, username, password);
    }

    public Member(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
