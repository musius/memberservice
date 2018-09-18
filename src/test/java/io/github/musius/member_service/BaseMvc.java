package io.github.musius.member_service;

import io.github.musius.member_service.model.Member;
import io.github.musius.member_service.respository.MemberRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.time.ZonedDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BaseMvc {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private WebApplicationContext applicationContext;

    @Before
    public void setup() {
        memberRepository.createMember(new Member(null, "Joe", "Dough",
                ZonedDateTime.parse("2001-12-03T10:15:30+01:00[Europe/Paris]"),
                "350451"));
        memberRepository.createMember(new Member(null, "Joe2", "Dough3",
                ZonedDateTime.parse("2002-12-03T10:15:30+01:00[Europe/Paris]"),
                "350452"));
        memberRepository.createMember(new Member(null, "Joe3", "Dough3",
                ZonedDateTime.parse("2003-12-03T10:15:30+01:00[Europe/Paris]"),
                "350453"));
        memberRepository.createMember(new Member(null, "Joe4", "Dough4",
                ZonedDateTime.parse("2004-12-03T10:15:30+01:00[Europe/Paris]"),
                "350454"));
        RestAssuredMockMvc.webAppContextSetup(applicationContext);
    }
}
