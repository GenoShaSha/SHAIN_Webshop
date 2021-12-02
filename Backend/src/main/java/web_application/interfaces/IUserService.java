package web_application.interfaces;

import web_application.model.Member;
import web_application.security.UserCreateRequest;

import java.util.List;

public interface IUserService {

    public void registerMember(UserCreateRequest userCreateRequest);
    List<Member> GetAllMembers();
    void RemoveMember(Member m);
    Member getMemberByUsername(String username);

}
