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
    public Member UpdateMember(Member m) {
        BCryptPasswordEncoder code = new BCryptPasswordEncoder();
        for(Member memb : FakeMembers){
            if(memb.getUsername().equals(m.getUsername())){
                memb.setFirstName(m.getFirstName());
                memb.setLastName(m.getLastName());
                memb.setBirthDate(m.getBirthDate());
                memb.setEmail(m.getEmail());
                memb.setPhoneNumb(m.getPhoneNumb());
                memb.setAddress(m.getAddress());
                memb.setCity(m.getCity());
                memb.setCountry(m.getCountry());
                memb.setPostalCode(m.getPostalCode());
                memb.setPassword(code.encode(m.getPassword()));
                FakeMembers.add(memb);
                return memb;
            }
        }
        return null;
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
}
