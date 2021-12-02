package web_application.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import web_application.interfaces.IUserRepo;
import web_application.interfaces.IUserService;
import web_application.model.Member;
import web_application.security.UserCreateRequest;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements IUserService {

    private final IUserRepo repo;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public void registerMember(UserCreateRequest userCreateRequest) {
        Member user = new Member();
        Optional<Member> byUsername = repo.getMemberByUsername(userCreateRequest.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }
        user.setUsername(userCreateRequest.getUsername());
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
    public Member UpdateMember(Member m) {
        return repo.UpdateMember(m);
    }

    @Override
    public Member getMemberByUsername(String username) {
        return repo.getMemberByUsername(username).orElseThrow(EntityNotFoundException::new);
    }
}
