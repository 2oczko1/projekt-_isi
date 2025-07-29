package com.systemzarzadzaniaapteka.model;


public class Feedback {
    private int id;
    private String comments;
    private int rating;

    public Feedback(int id, String comments, int rating) {
        this.id = id;
        this.comments = comments;
        this.rating = rating;
    }

    public void submitFeedback() {
        System.out.println("Feedback submitted: " + comments);
    }
}