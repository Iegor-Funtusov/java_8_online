package ua.com.alevel;

import ua.com.alevel.controller.MainController;

import java.io.IOException;

public class SqlMain {
    public static void main(String[] args) {
        try {
            new MainController().start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}