package ua.com.alevel;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class IoTest {

    public void test() {
        System.out.println("IoTest.test");
//        createFile(AppUtil.FILE_NAME.getPath());
//        createDirectory(AppUtil.DIR_NAME.getPath());
//        createDirectories(AppUtil.DIRS_NAME.getPath());
//        dropFile(AppUtil.FILE_NAME.getPath());
//        dropDir(AppUtil.DIR_NAME.getPath());
//        readDirectory(AppUtil.DIR_NAME.getPath());
        update(AppUtil.FILE_NAME.getPath(), "test1.txt");
    }

    private void createFile(String filePath) {
        File file = new File(filePath);
        System.out.println("file = " + file.getPath());
        System.out.println("file = " + file.getAbsolutePath());
        System.out.println("isFile before create = " + file.isFile());
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("isFile after create = " + file.isFile());
    }

    private void createDirectory(String dirPath) {
        File file = new File(dirPath);
        boolean isCreatedDir = file.mkdir();
        System.out.println("isCreatedDir = " + isCreatedDir);
    }

    private void createDirectories(String dirPath) {
        File file = new File(dirPath);
        file.mkdirs();
    }

    private void dropFile(String filePath) {
        File file = new File(filePath);
        file.delete();
    }

    private void dropDir(String dirPath) {
        File file = new File(dirPath);
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readDirectory(String dirPath) {
        File file = new File(dirPath);
        System.out.println("file = " + file);
        if (file.isDirectory()) {
            readFile(file);
        }
    }

    private void readFile(File dir) {
        System.out.println("dir = " + dir.getAbsolutePath());
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                readFile(file);
            } else {
                System.out.println("file = " + file.getAbsolutePath());
            }
        }
    }

    private void update(String oldFilePath, String newFilePath) {
        File file = new File(oldFilePath);
        if (file.exists()) {
            file.renameTo(new File(newFilePath));
        }
    }
}
