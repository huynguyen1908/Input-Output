import java.io.*;

public class Utils {
    public static String readContentFromFile(String path) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bf.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ;
        return content.toString();
    }

    public static void writeContentToFile(String path, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendContentToFile(String path, String content) throws IOException {
        String stringContent = readContentFromFile(path) + "\n" + content;
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));

        writer.write(stringContent);

        writer.close();
    }
}
