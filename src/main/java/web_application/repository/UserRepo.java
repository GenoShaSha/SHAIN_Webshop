package web_application.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web_application.dataConnection.IMember;
import web_application.interfaces.IUserRepo;
import web_application.model.Member;

import java.util.List;

@Repository
public class UserRepo implements IUserRepo {
    @Autowired
    IMember repo;
    public UserRepo(){}


    @Override
    public void AddMember(Member m) {
        repo.save(m);
    }

    @Override
    public List<Member> GetAllMembers() {
        return repo.findAll();
    }

    @Override
    public void RemoveMember(Member m) {
        repo.delete(m);
    }
}

