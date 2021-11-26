package web_application.interfaces;

import web_application.model.Member;

import java.util.List;

public interface IUserRepo {

    void AddMember(Member m);
    List<Member> GetAllMembers();
    void RemoveMember(Member m);

}
