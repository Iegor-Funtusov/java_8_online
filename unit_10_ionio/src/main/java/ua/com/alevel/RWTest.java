package ua.com.alevel;

import java.io.*;

public class RWTest {

//    Reader reader;
//    Writer writer;
//
//    InputStream inputStream;
//    OutputStream outputStream;

    private final File file = new File(AppUtil.FILE_NAME.getPath());

    public void test() {
//        symbolWrite();
//        byteWrite();
//        symbolRead();
        byteRead();
    }

    private void symbolWrite() {
        try(FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write("\n");
            fileWriter.write("Hello World 2");
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void byteWrite() {
        byte[] bytes = new byte[]{72,101,108,108,111};
        try(OutputStream outputStream = new FileOutputStream(file, true)) {
            outputStream.write(10);
            outputStream.write(bytes);
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void symbolRead() {
        try(
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
//            while (fileReader.ready()) {
//                int b = fileReader.read();
//                System.out.println("b = " + (char)b);
//            }
            String text = "";
            while (bufferedReader.ready()) {
                text = bufferedReader.readLine();
                System.out.println("text = " + text);
            }
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void byteRead() {
        try(InputStream inputStream = new FileInputStream(file)) {
            byte[] bytes = inputStream.readAllBytes();
            for (byte aByte : bytes) {
                System.out.println("aByte = " + (char)aByte);
            }
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }
}
