package com.fastchat4j.core.entity;

import cn.hutool.json.JSONUtil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 对话上下文
 * @author InwardFlow
 * @date 2023/12/10
 */
public final class ChatContext {

    private final Map<String, String> chat;

    private ChatContext(Map<String, String> chat) {
        this.chat = new LinkedHashMap<>(chat);
    }

    public static ChatContext create(Map<String, String> chat) {
        return new ChatContext(chat);
    }

    public Map<String, String> getChat() {
        return new LinkedHashMap<>(chat);
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(chat);
    }

    public static class Builder {
        private Map<String, String> chat = new LinkedHashMap<>();

        public Builder add(String role, String message) {
            chat.put(role, message);
            return this;
        }

        public ChatContext build() {
            return new ChatContext(chat);
        }
    }
}
