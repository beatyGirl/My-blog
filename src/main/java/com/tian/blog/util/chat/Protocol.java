package com.tian.blog.util.chat;

public class Protocol {
    private String userId;

    public Protocol(String userId) {
        this.userId = userId;
    }

    public String processInput(String input) {
        return (userId + ":" + input);
    }
}
