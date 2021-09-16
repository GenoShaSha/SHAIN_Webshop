package WebApplication.model;

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

/*    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Categories categories = (Categories) obj;
        return catID == categories.catID;
    }

    @Override
    public int hashCode(){
        return Objects.hash(catID);
    }*/

    @Override
    public String toString(){
        return "Categories: " +
                "category Code =" + catCode +
                "name =" + name;
    }
}
