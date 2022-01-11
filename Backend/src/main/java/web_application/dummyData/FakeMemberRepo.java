package web_application.dummyData;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import web_application.interfaces.IMemberRepo;
import web_application.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeMemberRepo implements IMemberRepo {
    ArrayList<Member> FakeMembers;

    public FakeMemberRepo() {
        FakeMembers = new ArrayList<>();
    }


    @Override
    public void AddMember(Member m) {
        FakeMembers.add(m);
    }

    @Override
    public List<Member> GetAllMembers() {
        return FakeMembers;
    }

    @Override
    public void RemoveMember(Member m) {
        FakeMembers.remove(m);
    }

    @Override
    public Optional<Member> getMemberByUsername(String username) {
        for(Member m : FakeMembers){
           if(m.getUsername().equals(username)){
               return Optional.of(m);
           }
        }
        return Optional.empty();
    }

    @Override
    public Member getAMemberByUsername(String username) {
        for(Member m : FakeMembers){
            if(m.getUsername().equals(username)){
                return m;
            }
        }
        return null;    }
}
