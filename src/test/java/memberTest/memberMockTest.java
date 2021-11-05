package memberTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;
import web_application.dataConnection.IMember;
import web_application.model.Member;
import web_application.repository.FakeData;

import java.util.List;

import static org.mockito.Mockito.when;

@ContextConfiguration
public class memberMockTest {

    @Test
    public void AddAndRemoveMemberTest()
    {
        FakeData fake = new FakeData();

        fake.addMember(new Member(5L,"Shanessa","Kostaman","23 September 2002","shanessa.m7493@gmail.com","081932550943","Heerkensveld 22","Eindhoven","Netherlands","5641PD","gnvshanessa","tiwi9318"));

        Member test = fake.getMember(5L);

        Assertions.assertEquals(test.getFirstName(),"Shanessa");

        fake.deleteMember(5L);

        Member test2 = fake.getMember(5L);

        Assertions.assertEquals(test2,null);

    }


}
