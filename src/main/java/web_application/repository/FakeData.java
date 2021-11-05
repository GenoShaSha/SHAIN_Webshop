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

        membersList.add(new Member("Shanessa","Kostaman","23 September 2002","shanessa.m7493@gmail.com","081932550943","Heerkensveld 22","Eindhoven","Netherlands","5641PD","gnvshanessa","tiwi9318"));
        membersList.add(new Member("Nevena Ivanova","Ginceva","18 September 2000","nevena.i.g@gmail.com","081293953498","Schans 3","Eindhoven","Netherlands","5641PP","nevenaGinceva","neveginceva"));
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
            if(products.getProductName().equals(name)){
                return products;
            }
        }
        return null;
    }
    //test
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
        if(this.getCategory(category.getCatCode()) != null){
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
        categoriesList.remove(category);
        return true;
    }
    public boolean updateCategory(Category category,Category newCat){
        if(category == null){
            return false;
        }
        category.setCatCode(newCat.getCatCode());
        category.setName(newCat.getName());
        return true;
    }


    public List<Member> getMembersList(){
        return membersList;
    }

    public Member getMember(Long id){
        for(Member members : membersList){
            if(members.getId() == id){
                return members;
            }
        }
        return null;
    }
    public List<Member> getMemberByFirstName(String firstName){

        List<Member> temp = new ArrayList<>();
        for(Member members : membersList){
            if(members.getFirstName().equals(firstName)){
                temp.add(members);
            }
        }
        return temp;
    }
    public List<Member> getMemberByLastName(String lastName){

        List<Member> temp = new ArrayList<>();
        for(Member members : membersList){
            if(members.getLastName().equals(lastName)){
                temp.add(members);
            }
        }
        return temp;
    }

    public boolean addMember(Member members){
        if(this.getMember(members.getId()) != null){
            return false;
        }
        membersList.add(members);
        return true;
    }
    public boolean deleteMember(Long id){
        Member members = getMember(id);
        if(members == null){
            return false;
        }
        membersList.remove(members);
        return true;
 }
        public void updateMember(Member members){
        Member previous = members;
        previous.setFirstName(members.getFirstName());
        previous.setLastName(members.getLastName());
        previous.setBirthDate(members.getBirthDate());
        previous.setEmail(members.getEmail());
        previous.setPhoneNumb(members.getPhoneNumb());
        previous.setAddress(members.getAddress());
        previous.setCity(members.getCity());
        previous.setCountry(members.getCountry());
        previous.setPostalCode(members.getPostalCode());
        previous.setUsername(members.getUsername());
        previous.setPassword(members.getPassword());
    }
}
