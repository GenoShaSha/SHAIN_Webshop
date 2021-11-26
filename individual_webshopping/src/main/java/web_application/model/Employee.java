package web_application.model;

public class Employee extends User{
    private int bsnNumber;

    private Employee(String firstName, String lastName, String birthDate, String email, int bsnNumber, String phoneNumb, String address, String city, String country, String postalCode, String username, String password){
        super(firstName,lastName,birthDate,email,phoneNumb,address,city,country,postalCode,username,password);
        this.bsnNumber = bsnNumber;
    }
    private Employee(){

    }
    public int GetBsnNumber(){
        return bsnNumber;
    }
    public void SetBsnNumber(int bsnNumber){
        this.bsnNumber = bsnNumber;
    }
}
