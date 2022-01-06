package web_application.interfaces;

import web_application.model.Member;
import web_application.security.UserCreateRequest;

import java.util.List;
import java.util.Optional;

public interface IMemberService {

    public void registerMember(UserCreateRequest userCreateRequest);
    List<Member> GetAllMembers();
    void RemoveMember(Member m);
    Member UpdateMember(Member m);
    Member getMemberByUsername(String username);

}
