package web_application.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web_application.dataConnection.IMember;
import web_application.interfaces.IUserRepo;
import web_application.model.Member;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepo implements IUserRepo {
    @Autowired
    IMember repo;

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

    @Override
    public Optional<Member> getMemberByUsername(String username) {
       return repo.getMemberByUsername(username);
    }
}

