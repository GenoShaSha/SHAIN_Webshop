package WebApplication.controller;

import WebApplication.model.Member;
import WebApplication.repository.FakeData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/member")

public class MemberController {
    private static final FakeData fakeData = new FakeData();

    @GetMapping("/welcome")
    @ResponseBody
    public String SayWelcome()
    {
        String message = "Welcome to our website!";
        return message;
    }
    @GetMapping //Get All Members
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = null;
        members = fakeData.getMembersList();
        if(members != null) {
            return ResponseEntity.ok().body(members);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{accNumb}") //GET at http://localhost:XXXX/accNumb/1
    public ResponseEntity<Member> getMemberPath(@PathVariable(value = "accNumb") int accNumb) {
        Member members = fakeData.getMember(accNumb);
        if(members != null) {
            return ResponseEntity.ok().body(members);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("{name}") //GET at http://localhost:XXXX/name/Shanessa
    public ResponseEntity<Member> getMemberPath(@PathVariable(value = "name") String name) {
        Member members = fakeData.getMember(name);
        if(members != null) {
            return ResponseEntity.ok().body(members);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping()
    //POST at http://localhost:XXXX/member/
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        if (!fakeData.addMember(member)){
            String entity =  "This member with the ID : " + member.getMemberID() + " already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            String url = "member" + "/" + member.getMemberID();
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }
    }

    @DeleteMapping("{id}")
    //DELETE at http://localhost:XXXX/member/3
    public ResponseEntity deleteMember(@PathVariable int id)
    {
        fakeData.deleteMember(id);
        return ResponseEntity.ok().build();
    }

}
