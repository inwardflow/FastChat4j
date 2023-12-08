package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author SanseYooyea
 */
public class FileUtils {
    private FileUtils() {
    }

    public static void createFile(File file) {
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readFile(File file) {
        try (FileChannel channel = new FileInputStream(file).getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
            channel.read(buffer);
            return new String(buffer.array());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeFile(File file, String content) {
        try (FileChannel channel = new FileOutputStream(file, false).getChannel()) {
            channel.write(ByteBuffer.wrap(content.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
