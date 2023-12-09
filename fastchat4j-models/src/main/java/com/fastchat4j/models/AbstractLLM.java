package com.fastchat4j.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import okhttp3.OkHttpClient;

import java.util.List;

@Data
@AllArgsConstructor
public abstract class AbstractLLM {

    /**
     * 模型名称
     */
    private String name;

    /**
     * ApiKey
     */
    private String apiKey;

    /**
     * ApiKey 列表
     */
    private List<String> apiKeyList;

    /**
     * Api 接口地址
     */
    private String apiHost;

    /**
     * OKHttpClient
     */
    private OkHttpClient okHttpClient;

}
