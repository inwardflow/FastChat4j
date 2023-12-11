package com.fastchat4j.core;

import com.fastchat4j.core.entity.ChatContext;
import org.junit.jupiter.api.Test;

public class ChatContextTest {
    @Test
    public void outputTest() {
        ChatContext chatContext = new ChatContext.Builder()
                .add("user", "hello")
                .build();
        System.out.println(chatContext);
    }
}
