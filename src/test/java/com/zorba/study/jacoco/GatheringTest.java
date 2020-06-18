package com.zorba.study.jacoco;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GatheringTest {

    @Test
    public void isFull() {
        Gathering gathering = new Gathering();
        gathering.maxNumberOfAttendees = 100;
        gathering.numberOfEnrollment = 10;

        assertFalse(gathering.isEnrollmentFull());
    }

}