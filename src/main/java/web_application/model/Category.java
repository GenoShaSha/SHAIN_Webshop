package web_application.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String catCode;
    private String name;
    private String gender;

    public Category(String catCode, String name){
        this.catCode = catCode;
        this.name = name;
    }

    public Category(String catCode, String name,String gender){
        this.catCode = catCode;
        this.name = name;
        this.gender = gender;
    }

    public String getCatCode(){
        return catCode;
    }
    public void setCatCode(String catCode){
        this.catCode = catCode;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Categories: " +
                "category Code =" + catCode +
                "name =" + name;
    }
}
