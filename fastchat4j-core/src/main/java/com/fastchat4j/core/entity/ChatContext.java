package com.fastchat4j.core.entity;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * 对话上下文
 * @author InwardFlow
 * @date 2023/12/10
 */
public final class ChatContext {

    // 创建 "messages" 数组
    private final JSONArray messages;

    private ChatContext(JSONArray messages) {
        this.messages = new JSONArray(messages);
    }

    private ChatContext() {
        this.messages = new JSONArray();
    }

    public static ChatContext create(JSONArray messages) {
        return new ChatContext(messages);
    }

    public JSONArray getChat() {
        return new JSONArray(messages);
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(messages);
    }

    public static class Builder {
        // 创建 "messages" 数组
        private final JSONArray messages = new JSONArray();

        public Builder add(String role, String content) {
            // 创建单个消息节点
            JSONObject message = new JSONObject();
            message.set("role", role);
            message.set("content", content);

            // 将消息节点添加到 messages 数组中
            messages.put(message);

            return this;
        }

        public ChatContext build() {
            return new ChatContext(messages);
        }
    }
}
