package be.intecbrussel;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class App {
    public static void main(String[] args) throws FileNotFoundException {

        Path path = Path.of("..\\..\\FromNadiraToPearl\\message.txt");

        try {
            if (Files.notExists(path.getParent())) {
                Files.createDirectory(path.getParent());
            }
            if (Files.notExists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toString()))) {
            bufferedWriter.write("Er komt een Nederlander in Belgie en ziet 2 belgen. De één graaft een lange geul" +
                    "  en de ander gooit hem weer dicht." +
                    " Dus vraagt de Nederlander:waarom doen jullie dat?" +
                    " Zegt een van de belgen: We leggen een draadloze telefoon verbinding aan!!");

        } catch (IOException e) {
            throw new RuntimeException(e);

        }

        FavoriteAnimal horse = new FavoriteAnimal("Lana", true);
        Path horsePath= Path.of("..\\..\\FromNadiraToPearl\\animal.txt");
        Path path1 = Path.of(horsePath.toString() + "\\" + horse.getName() + horse.isEdible());


        try {
            if (Files.notExists(horsePath)) {
                Files.createFile(horsePath);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(horsePath.toString()))) {
            objectOutputStream.writeObject(horse);

        } catch (IOException e) {
            e.printStackTrace();


        }

    }
}

