import axios from "axios";

const member_API_URL = "http://localhost:8080/member";
class MemberService {
    getMembers(){
        return axios.get(member_API_URL);
    }
}
export default new MemberService()