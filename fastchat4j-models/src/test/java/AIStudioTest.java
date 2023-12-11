import com.fastchat4j.core.entity.ChatContext;
import com.fastchat4j.models.aistudio.service.AIStudioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.fastchat4j.models.aistudio.enums.AIStudioModelEnum.ERNIE_BOT;

public class AIStudioTest {
    private final static String APIKEY = "Your api key";
    private final static String LOGIN_TICKET = "Your ticket";
    @DisplayName("测试 AIStudioService 对话聊天功能")
    @Test
    public void AIStudioServiceTest() {
        // 示例用法
        AIStudioService aiStudioService = new AIStudioService(APIKEY);

        ChatContext chatContext = new ChatContext.Builder()
                .add("user", "你好文心一言")
                .build();

        String response = aiStudioService.completeChat(ERNIE_BOT.name(), chatContext);
        System.out.println("Response: " + response);
    }

    @DisplayName("测试 AIStudio 获取 总共 剩余额度功能")
    @Test
    public void AIStudioServiceBalanceTest() {
        System.out.println(AIStudioService.getBalance(LOGIN_TICKET));
    }
}
