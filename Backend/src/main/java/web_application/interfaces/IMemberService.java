package web_application.interfaces;

import web_application.model.Member;
import web_application.security.UserCreateRequest;

import java.util.List;
import java.util.Optional;

public interface IMemberService {

    public void registerMember(UserCreateRequest userCreateRequest);
    List<Member> GetAllMembers();
    void RemoveMember(Member m);
    void UpdateMember(Member m, String username);
    Member getMemberByUsername(String username);

}
