package com.fastchat4j.models.aistudio.enums;

import lombok.AllArgsConstructor;

/**
 * 百度文心 AIStudioService 模型
 * @author InwardFlow
 * @date 2023/12/10
 */
@AllArgsConstructor
public enum AIStudioModelEnum {
    ERNIE_BOT("ernie-bot", "文心一言模型（ernie-bot）"),
    ERNIE_BOT_TURBO("ernie-bot-turbo", "文心一言模型（ernie-bot-turbo）"),
    ERNIE_BOT_4("ernie-bot-4", "文心一言模型（ernie-bot-4）"),
    ERNIE_BOT_8K("ernie-bot-8k", "文心一言模型（ernie-bot-8k）"),
    ERNIE_TEXT_EMBEDDING("ernie-text-embedding", "文心百中语义模型"),
    ERNIE_VILG_V2("ernie-vilg-v2", "文心一格模型");

    private final String name;
    private final String description;

}
