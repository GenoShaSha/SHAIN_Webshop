package web_application.model;

public class Category {
    private String catCode;
    private String name;

    public Category(String catCode, String name){
        this.catCode = catCode;
        this.name = name;
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

    @Override
    public String toString(){
        return "Categories: " +
                "category Code =" + catCode +
                "name =" + name;
    }
}
