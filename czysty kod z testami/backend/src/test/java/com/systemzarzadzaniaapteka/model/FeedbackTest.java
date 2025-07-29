package com.systemzarzadzaniaapteka.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FeedbackTest {

    @Test
    void shouldSubmitFeedback() {
        Feedback feedback = new Feedback(1, "Świetna obsluga!", 5);
        assertDoesNotThrow(feedback::submitFeedback);
    }
}
