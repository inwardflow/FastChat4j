package com.fastchat4j.models.aistudio;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fastchat4j.models.AbstractLLM;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AIStudio extends AbstractLLM {

    public AIStudio(String apiKey, List<String> apiKeyList, OkHttpClient okHttpClient) {
        super("AIStudio", apiKey, apiKeyList, "https://aistudio.baidu.com/llm/lmapi", okHttpClient);
    }


    public static void main(String[] args) {


        OkHttpClient client = new OkHttpClient();
        AIStudio aiStudio = new AIStudio("Your Api Key", null, client);

        // 设置API的URL
        String apiUrl =  aiStudio.getApiHost() + "/v1/chat/completions";

        // 构建请求体数据
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> messages = new ArrayList<>();
        Map<String, Object> message = new HashMap<>();

        map.put("model", "ernie-bot");
        message.put("role", "user");
        message.put("content", "你好，文心一言");
        messages.add(message);
        map.put("messages", messages);

        System.out.println(map);

        String requestBody = JSONUtil.toJsonStr(map);

        // 创建请求
        Request request = new Request.Builder()
                .url(apiUrl)
                .post(RequestBody.create(requestBody, MediaType.parse("application/json")))
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "token " + aiStudio.getApiKey())  // 替换为你的实际 API Key
                .build();

        // 发送请求并处理响应
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                // 响应成功
                System.out.println("Response Code: " + response.code());

                String responseData = response.body().string();
                System.out.println("Response Data: " + responseData);
                JSONObject jsonResponse = JSONUtil.parseObj(responseData);

                // Extract conversation record from "result" object
                if (jsonResponse.containsKey("result")) {
                    JSONObject resultObject = jsonResponse.getJSONObject("result");
                    String conversationRecord = resultObject.getStr("result");
                    System.out.println("Conversation Record: " + conversationRecord);
                }

            } else {
                // 响应失败
                System.err.println("Error: " + response.code() + ", " + response.message());
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
