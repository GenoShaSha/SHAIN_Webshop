package web_application.interfaces;

import web_application.model.Member;

import java.util.List;
import java.util.Optional;

public interface IUserRepo {

    void AddMember(Member m);
    List<Member> GetAllMembers();
    void RemoveMember(Member m);
    Member UpdateMember(Member m);
    Optional<Member> getMemberByUsername(String username);


}
