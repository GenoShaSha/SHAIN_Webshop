package web_application.interfaces;

import web_application.model.Member;

import java.util.List;

public interface IUserService {

    void AddMember(Member m);
    List<Member> GetAllMembers();
    void RemoveMember(Member m);

}
