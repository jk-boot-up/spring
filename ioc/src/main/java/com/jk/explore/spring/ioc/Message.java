package com.jk.explore.spring.ioc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Locale;


@Getter
@Setter
@NoArgsConstructor
public class Message {

    private Locale locale;
    private String welcomeMessage;
    private String thanksMessage;

    public Message(Locale locale, String welcomeMessage, String thanksMessage) {
        this.locale = locale;
        this.welcomeMessage = welcomeMessage;
        this.thanksMessage = thanksMessage;
    }


}
