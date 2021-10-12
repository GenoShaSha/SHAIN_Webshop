package web_application.repository;

import web_application.model.Category;
import web_application.model.Member;
import web_application.model.Product;

import java.util.ArrayList;
import java.util.List;

public class FakeData {
    private final List<Product> productList = new ArrayList<>();
    private final List<Category> categoriesList = new ArrayList<>();
    private final List<Member> membersList = new ArrayList<>();

    public FakeData(){
        Category shirts = new Category("SRT","Shirts");
        Category jeans = new Category("JNS","Jeans");
        Category boots = new Category("BTS","Boots");
        categoriesList.add(shirts);
        categoriesList.add(jeans);
        categoriesList.add(boots);

        productList.add(new Product(10000,"MOLA",shirts,"L",10));
        productList.add(new Product(20000,"DENIM",jeans,"M",7));
        productList.add(new Product(30000,"BLACK",boots,"40",12));

        membersList.add(new Member(1,"Shanessa","shanessa.m7493@gmail.com","081932550943","Heerkensveld 22","gnvshanessa"));
        membersList.add(new Member(2,"Nevena","nevena.i.g@gmail.com","081293953498","Schans 3","nevena.i"));
    }
    public List<Product> getProduct(){
        return productList;
    }
    public Product getProduct(int artNumber){
        for(Product products : productList){
            if(products.getArticleNumber() == artNumber){
                return products;
            }
        }
        return null;
    }
    public Product getProduct(String name){
        for(Product products : productList){
            if(products.getProductName() == name){
                return products;
            }
        }
        return null;
    }
    public List<Product> getProduct(Category categories){
        List<Product> filteredByCat = new ArrayList<>();
        for(Product products : productList){
            if(products.getCategories().equals(categories)){
                filteredByCat.add(products);
            }
        }
        return filteredByCat;
    }
    public boolean addProduct(Product products){
        if(this.getProduct(products.getArticleNumber()) != null){
            return false;
        }
        productList.add(products);
        return true;
    }
    public boolean deleteProduct(int artNumb){
        Product products = getProduct(artNumb);
        if(products == null){
            return false;
        }
        productList.remove(products);
        return true;
    }
    public boolean updateProduct(Product products){
        Product previous = this.getProduct(products.getArticleNumber());
        if(previous == null){
            return false;
        }
        previous.setProductName(products.getProductName());
        previous.setArticleNumber(products.getArticleNumber());
        previous.setQuantity(products.getQuantity());
        return true;
    }
    public List<Category> getCategory(){
        return categoriesList;
    }
    public Category getCategory(String code){
        for(Category categories : categoriesList){
            if(categories.getCatCode().equals(code)){
                    return categories;
            }
        }
        return null;
    }
    public boolean addCategory(Category category){
        if(this.getMember(category.getCatCode()) != null){
            return false;
        }
        categoriesList.add(category);
        return true;
    }
    public boolean deleteCategory(String catCode){
        Category category = getCategory(catCode);
        if(category == null){
            return false;
        }
        membersList.remove(category);
        return true;
    }
    public boolean updateCategory(Category category){
        Category previous = this.getCategory(category.getCatCode());
        if(previous == null){
            return false;
        }
        previous.setCatCode(category.getCatCode());
        previous.setName(category.getName());
        return true;
    }


    public List<Member> getMembersList(){
        return membersList;
    }

    public Member getMember(int id){
        for(Member members : membersList){
            if(members.getMemberID() == id){
                return members;
            }
        }
        return null;
    }
    public List<Member> getMember(String name){

        List<Member> temp = new ArrayList<>();
        for(Member members : membersList){
            if(members.getName().equals(name)){
                temp.add(members);
            }
        }
        return temp;
    }
    public boolean addMember(Member members){
        if(this.getMember(members.getMemberID()) != null){
            return false;
        }
        membersList.add(members);
        return true;
    }
    public boolean deleteMember(int id){
        Member members = getMember(id);
        if(members == null){
            return false;
        }
        membersList.remove(members);
        return true;
    }
    public boolean updateMember(Member members){
        Member previous = this.getMember(members.getMemberID());
        if(previous == null){
            return false;
        }
        previous.setMemberID(members.getMemberID());
        previous.setName(members.getName());
        previous.setAddress(members.getAddress());
        previous.setEmail(members.getEmail());
        previous.setPhoneNumb(members.getPhoneNumb());
        previous.setPassword(members.getPassword());
        return true;
    }
}
