package web_application.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import web_application.interfaces.IMemberRepo;
import web_application.interfaces.IMemberService;
import web_application.model.Member;
import web_application.security.UserCreateRequest;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements IMemberService {

    private final IMemberRepo repo;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void registerMember(UserCreateRequest userCreateRequest) {
        Member user = new Member();
        Optional<Member> byUsername = repo.getMemberByUsername(userCreateRequest.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }
        user.setUsername(userCreateRequest.getUsername());
        user.setEmail(userCreateRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
        user.setRole("USER");
        repo.AddMember(user);
    }

    @Override
    public List<Member> GetAllMembers() {
        return repo.GetAllMembers();
    }

    @Override
    public void RemoveMember(Member m) {
        repo.RemoveMember(m);
    }

    @Override
    public void UpdateMember(Member member, String username){
        BCryptPasswordEncoder code = new BCryptPasswordEncoder();
        Member m = repo.getAMemberByUsername(username);
        m.setFirstName(member.getFirstName());
        m.setRole(member.getRole());
        m.setLastName(member.getLastName());
        m.setBirthDate(member.getBirthDate());
        m.setEmail(member.getEmail());
        m.setPhoneNumb(member.getPhoneNumb());
        m.setAddress(member.getAddress());
        m.setCity(member.getCity());
        m.setCountry(member.getCountry());
        m.setPostalCode(member.getPostalCode());
        m.setPassword(code.encode(member.getPassword()));
        repo.AddMember(m);
    }

    @Override
    public Member getMemberByUsername(String username) {
        return repo.getAMemberByUsername(username);
    }
}
