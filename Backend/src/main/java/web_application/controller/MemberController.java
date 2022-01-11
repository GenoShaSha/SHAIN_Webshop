package web_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import web_application.interfaces.IMemberService;
import web_application.model.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web_application.security.UserCreateRequest;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/member")

public class MemberController {

    @Autowired
    IMemberService logic;

    @GetMapping("/welcome")
    @ResponseBody
    public String SayWelcome()
    {
        String message = "Welcome to our website!";
        return message;
    }
    @GetMapping //Get All Members
    public ResponseEntity<List<Member>> getAllMembers() {

        return ResponseEntity.ok().body(logic.GetAllMembers());
    }
    @PostMapping()
    //POST at http://localhost:XXXX/member/
    public ResponseEntity createMember(@RequestBody UserCreateRequest member) {
        logic.registerMember(member);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PutMapping("/{username}")
    public ResponseEntity<String> updateMember(@PathVariable String username, @RequestBody Member member){
        logic.UpdateMember(member,username);
        return ResponseEntity.ok().body("updated");
    }
    @PutMapping("/updateRole/{username}")
    public ResponseEntity<String> updateRoleAdmin(@PathVariable String username){
        Member m = logic.getMemberByUsername(username);
        if(m.getRole().equals("USER")){
            m.setRole("ADMIN");
        }
        else {
            m.setRole("USER");
        }
        logic.UpdateMember(m,username);
        return ResponseEntity.ok().body("updated");
    }
    @GetMapping("/{username}")
    public ResponseEntity<Member> getMemberbyUsername(@PathVariable String username){
        Member m = logic.getMemberByUsername(username);
        return ResponseEntity.ok().body(m);
    }
}
