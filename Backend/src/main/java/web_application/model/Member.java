package web_application.model;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class Member{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role;
    @Column(name = "FirstLame")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "BirthDate")
    private String birthDate;
    @Column(name = "Email")
    private String email;
    @Column(name = "PhoneNumber")
    private String phoneNumb;
    @Column(name = "Address")
    private String address;
    @Column(name = "City")
    private String city;
    @Column(name = "Country")
    private String country;
    @Column(name = "PostalCode")
    private String postalCode;
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;


    public Member(String firstName, String lastName, String birthDate, String email, String phoneNumb, String address, String city, String country, String postalCode, String username, String password,String role){
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumb = phoneNumb;
        this.address = address;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.username = username;
        this.password = password;
    }

    public Member(Long id,String firstName, String lastName, String birthDate, String email, String phoneNumb, String address, String city, String country, String postalCode, String username, String password,String role){
        this.id = id;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumb = phoneNumb;
        this.address = address;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.username = username;
        this.password = password;
    }

    public Member(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
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
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getBirthDate(){
        return birthDate;
    }
    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPhoneNumb(){
        return phoneNumb;
    }
    public void setPhoneNumb(String phoneNumb){
        this.phoneNumb = phoneNumb;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getCountry(){
        return country;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getPostalCode(){
        return postalCode;
    }
    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    @Override
    public String toString() {
        return "Member: " +
                "First Name =" + firstName +
                "Last Name =" + lastName +
                "Date of Birth =" + birthDate +
                "Email =" + email +
                "Phone Number =" + phoneNumb +
                "Address =" + address +
                "City =" + city +
                "Country =" + country +
                "Postal Code =" + postalCode +
                "Username =" + username +
                "Password =" + password;
    }
}
