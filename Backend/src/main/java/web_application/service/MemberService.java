package web_application.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web_application.interfaces.IUserRepo;
import web_application.interfaces.IUserService;
import web_application.model.Member;

import java.util.List;

@Service
public class MemberService implements IUserService {

    IUserRepo repo;

    @Autowired
    public MemberService(IUserRepo repo) {
        this.repo = repo;
    }

    @Override
    public void AddMember(Member m) {
        repo.AddMember(m);
    }

    @Override
    public List<Member> GetAllMembers() {
        return repo.GetAllMembers();
    }

    @Override
    public void RemoveMember(Member m) {
        repo.RemoveMember(m);
    }
}
