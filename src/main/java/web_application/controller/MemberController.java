package web_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import web_application.dataConnection.IMember;
import web_application.model.Member;
import web_application.repository.FakeData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/member")

public class MemberController {
    private static final FakeData fakeData = new FakeData();

    @Autowired
    IMember repo;

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
        members = repo.findAll();
        if(members != null) {
            return ResponseEntity.ok().body(members);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
//
//    @GetMapping("{accNumb}") //GET at http://localhost:XXXX/accNumb/1
//    public ResponseEntity<Member> getMemberPath(@PathVariable(value = "accNumb") int accNumb) {
//        Member members = fakeData.getMember(accNumb);
//        if(members != null) {
//            return ResponseEntity.ok().body(members);
//        }
//        else {
//            return ResponseEntity.notFound().build();
//        }
//    }
    @GetMapping("/name/{firstName}") //GET at http://localhost:XXXX/member/Shanessa
    public ResponseEntity<List<Member>> getByFirstName(@PathVariable(value = "firstName") String firstName) {
        List<Member> members = fakeData.getMemberByFirstName(firstName);
        if(members != null) {
            return ResponseEntity.ok().body(members);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/name/{lastName}") //GET at http://localhost:XXXX/member/Shanessa
    public ResponseEntity<List<Member>> getByLastName(@PathVariable(value = "lastName") String lastName) {
        List<Member> members = fakeData.getMemberByLastName(lastName);
        if(members != null) {
            return ResponseEntity.ok().body(members);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    //POST at http://localhost:XXXX/member/
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        if (member == null){
            String entity =  "This member with the ID : " + member.getId() + " already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            repo.save(member);
            String url = "member" + "/" + member.getId();
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }
    }
//
//    @DeleteMapping("{id}")
//    //DELETE at http://localhost:XXXX/member/3
//    public ResponseEntity deleteMember(@PathVariable int id)
//    {
//        fakeData.deleteMember(id);
//        return ResponseEntity.ok().build();
//    }

}
