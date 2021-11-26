import axios from "axios";

const category_API_URL = "http://localhost:8080/category";
class CategoryService {
    getCategories(){
        return axios.get(category_API_URL);
    }
}
export default new CategoryService()