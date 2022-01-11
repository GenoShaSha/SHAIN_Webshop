package memberTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import web_application.dummyData.FakeMemberRepo;
import web_application.model.Member;
import web_application.security.UserCreateRequest;
import web_application.service.MemberService;

@SpringBootConfiguration
public class memberMockTest {

    @Test
    public void AddAndRemoveMemberTest()
    {
        FakeMemberRepo fakerepo = new FakeMemberRepo();
        MemberService service = new MemberService(fakerepo,new BCryptPasswordEncoder());

        service.registerMember(new UserCreateRequest("username","email@gmail","password"));

        Member test = service.getMemberByUsername("username");

        Assertions.assertEquals(test.getEmail(),"email@gmail");

        service.RemoveMember(test);

        Member test2 = service.getMemberByUsername("username");

        Assertions.assertEquals(test2,null);
    }


    @Test
    public void UpdateMemberTest()
    {
        FakeMemberRepo fakerepo = new FakeMemberRepo();
        MemberService service = new MemberService(fakerepo,new BCryptPasswordEncoder());

        service.registerMember(new UserCreateRequest("username","email@gmail","password"));

        Member test = service.getMemberByUsername("username");

        Assertions.assertEquals(test.getEmail(),"email@gmail");

        service.UpdateMember(new Member("Shanessa","Kostaman","23 September 2002","shanessa.m7493@gmail.com","081932550943","Heerkensveld 22","Eindhoven","Netherlands","5641PD","username","tiwi9318", "USER"),"username");

        Member test2 = service.getMemberByUsername("username");

        Assertions.assertEquals("Shanessa",test2.getFirstName());

    }


}
