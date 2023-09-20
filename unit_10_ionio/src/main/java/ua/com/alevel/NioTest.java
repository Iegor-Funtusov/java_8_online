package ua.com.alevel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioTest {

//    Path path;
//    Paths paths;
//    Files files;

    public void test() {
        System.out.println("NioTest.test");
//        createFile(AppUtil.FILE_NAME.getPath());
//        createDirectory(AppUtil.DIR_NAME.getPath());
//        createDirectories(AppUtil.DIRS_NAME.getPath());
        dropFile(AppUtil.FILE_NAME.getPath());
    }

    private void createFile(String filePath) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void createDirectory(String dirPath) {
        Path path = Paths.get(dirPath);
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void createDirectories(String dirPath) {
        Path path = Paths.get(dirPath);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void dropFile(String dirPath) {
        Path path = Paths.get(dirPath);
//        Files.deleteIfExists(path);
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void update(String oldFilePath, String newFilePath) {
        Path path = Paths.get(oldFilePath);
        if (Files.exists(path)) {
//            Files.move()
        }
    }
}
