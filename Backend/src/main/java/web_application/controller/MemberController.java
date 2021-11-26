package web_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import web_application.interfaces.IUserService;
import web_application.model.Member;
import web_application.dummyData.FakeData;
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
    IUserService logic;

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

    @PostMapping("/login")
    //POST at http://localhost:XXXX/member/
    public ResponseEntity LoginMember(@RequestBody Member member) {
        for (Member other : logic.GetAllMembers()) {
            if (other.getUsername().equals(member.getUsername()) & other.getPassword().equals(member.getPassword())) {
                return new ResponseEntity(HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    @PostMapping()
    //POST at http://localhost:XXXX/member/
    public ResponseEntity createMember(@RequestBody Member member) {
        if (member == null){
            String entity =  "This member already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            logic.AddMember(member);
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
