package com.fastchat4j.models;

import lombok.Builder;
import okhttp3.OkHttpClient;

import java.util.List;

/**
 * LLM 大语言模型 抽象类
 * @author InwardFlow
 * @date 2023/12/10
 */
public abstract class AbstractLLM {

    public static final Long DEFAULT_TOKEN_BALANCE = -1L;

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
     * DefaultApi 接口地址
     */
    private String apiHost;

    /**
     * OKHttpClient
     */
    private OkHttpClient okHttpClient;

    /**
     * Token 剩余额度, -1代表无限
     */
    @Builder.Default
    private Long balance = DEFAULT_TOKEN_BALANCE;

}
