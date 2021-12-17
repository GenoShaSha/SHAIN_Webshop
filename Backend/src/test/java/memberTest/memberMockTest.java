//package memberTest;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.SpringBootConfiguration;
//import web_application.model.Member;
//import web_application.dummyData.FakeData;
//
//@SpringBootConfiguration
//public class memberMockTest {
//
//    @Test
//    public void AddAndRemoveMemberTest()
//    {
//        FakeData fake = new FakeData();
//
//        fake.addMember(new Member("Shanessa","Kostaman","23 September 2002","shanessa.m7493@gmail.com","081932550943","Heerkensveld 22","Eindhoven","Netherlands","5641PD","gnvshanessa","tiwi9318", "USER"));
//
//        Member test = fake.getMember(5L);
//
//        Assertions.assertEquals(test.getFirstName(),"Shanessa");
//
//        fake.deleteMember(5L);
//
//        Member test2 = fake.getMember(5L);
//
//        Assertions.assertEquals(test2,null);
//    }
//
//
//    @Test
//    public void UpdateMemberTest()
//    {
//        FakeData fake = new FakeData();
//
//        fake.addMember(new Member("Shanessa","Kostaman","23 September 2002","shanessa.m7493@gmail.com","081932550943","Heerkensveld 22","Eindhoven","Netherlands","5641PD","gnvshanessa","tiwi9318", "USER"));
//
//        Member test = fake.getMember(5L);
//
//        Assertions.assertEquals(test.getFirstName(),"Shanessa");
//
//        fake.updateMember(5L,new Member("Nessa","Kostaman","23 September 2002","shanessa.m7493@gmail.com","081932550943","Heerkensveld 22","Eindhoven","Netherlands","5641PD","gnvshanessa","tiwi9318", "USER"));
//
//        Member test2 = fake.getMember(5L);
//
//        Assertions.assertEquals("Nessa",test2.getFirstName());
//
//    }
//
//
//}
