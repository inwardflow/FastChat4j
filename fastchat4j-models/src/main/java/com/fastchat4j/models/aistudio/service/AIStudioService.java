package com.fastchat4j.models.aistudio.service;

import cn.hutool.json.JSONObject;
import com.fastchat4j.core.entity.ChatContext;
import lombok.AllArgsConstructor;
import okhttp3.*;

import java.io.IOException;

/**
 * AIStudioService
 * @author InwardFlow
 * @date 2023/12/10
 */
@AllArgsConstructor
public class AIStudioService {

    private static final String AISTUDIO_API_URL = "https://aistudio.baidu.com/llm/lmapi/v1";

    private final String apiKey;
    private final OkHttpClient httpClient;

    public AIStudioService(String apiKey) {
        this.apiKey = apiKey;
        this.httpClient = new OkHttpClient();
    }

    /**
     * 聊天对话功能
     * @param model 使用的模型
     * @param chatContext 对话上下文
     * @return 文心一言返回的内容（String 暂定）
     * @date 2023/12/11
     */
    public String completeChat(String model, ChatContext chatContext) {
        // 设置API的URL
        String apiUrl = AISTUDIO_API_URL + "/chat/completions";

        // 构建请求体数据
        MediaType json = MediaType.parse("application/json; charset=utf-8");
        String requestBodyJson = "{\"model\": \"" + model + "\", \"messages\": " + chatContext.toString() + "}";
        RequestBody requestBody = RequestBody.create(requestBodyJson, json);

        // 创建请求
        Request request = new Request.Builder()
                .url(apiUrl)
                .post(requestBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "token " + apiKey)
                .build();

        // 发送请求并处理响应
        try (Response response = httpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                // 响应成功
                return new JSONObject(response.body().string()).getJSONObject("result").getStr("result");
            } else {
                // 响应失败
                return "Error: " + response.code() + ", " + response.message();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    /**
     * 获取 token 剩余额度
     * @param aiStudioTicket AIStudioTicket（可从浏览器Cookie获取）
     * @return 当前剩余Token
     * @see <a href="https://aistudio.baidu.com/token/manage">AIStudio Token 额度查询</a>
     */
    public static Long getBalance(String aiStudioTicket) {
        String cookie = "Hm_lvt_; ai-studio-ticket=" + aiStudioTicket + ";";
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request requestWithCookie = original.newBuilder()
                            .header("Cookie", cookie)
                            .build();
                    return chain.proceed(requestWithCookie);
                })
                .build();

        Request request = new Request.Builder()
                .url("https://aistudio.baidu.com/studio/trade/token/my/balance")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                // 响应成功
                return new JSONObject(response.body().string()).getLong("result");
            } else {
                // 响应失败
                System.out.println("Error: " + response.code() + ", " + response.message());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // error
        return -1L;
    }


}
