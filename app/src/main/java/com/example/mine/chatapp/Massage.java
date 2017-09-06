package com.example.mine.chatapp;

/**
 * Created by mine on 27/08/17.
 */

public class Massage {

    private String body, writer,sendTime;

    public String getBody() {
        return body;
    }

    public String getWriter() {
        return writer;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
