package com.zorba.study.lombokannotation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MemberTest {

    @Test
    public void isSameAge() {
        Member member1 = new Member();
        member1.setName("jinhak");
        member1.setAge(30);

        Member member2 = new Member();
        member2.setName("zorba");
        member2.setAge(30);

        assertEquals(member1.getAge(), member2.getAge());
        assertTrue(member1.isSameAge(member2));
    }
}