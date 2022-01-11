package web_application.interfaces;

import web_application.model.Category;
import web_application.model.Member;

import java.util.List;
import java.util.Optional;

public interface IMemberRepo {

    void AddMember(Member m);
    List<Member> GetAllMembers();
    void RemoveMember(Member m);
    Optional<Member> getMemberByUsername(String username);
    Member getAMemberByUsername(String username);



}
