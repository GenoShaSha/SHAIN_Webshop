package WebApplication.model;

import java.util.List;



public class Member {
    private int memberID;
    private String name;
    private String email;
    //    private long phoneNumb;
    private String phoneNumb;
    private String address;
    private String password;

    public Member(int memberID, String name, String email, String phoneNumb, String address, String password){
        this.memberID = memberID;
        this.name = name;
        this.email = email;
        this.phoneNumb = phoneNumb;
        this.address = address;
        this.password = password;
    }

    public int getMemberID(){
        return memberID;
    }
    public void setMemberID(int memberID){
        this.memberID = memberID;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
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
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString(){
        return "Member: " +
                "member ID =" + memberID +
                "Name =" + name +
                "Email =" + email +
                "Phone Number =" + phoneNumb +
                "Address =" + address +
                "Password =" + password;
    }
}
