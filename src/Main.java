import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {


//2023 oktober informatika érettségi


    public static void main(String[] args) {
        try {
            // 1. feladat
            Map<Integer, String> osvenyek = readFile("osvenyek.txt");
            Map<Integer, Integer> dobasok = readDobasok("dobasok.txt");

            // 2. feladat
            System.out.println("2. feladat: Ösvények száma: " + osvenyek.size() + ", Dobások száma: " + dobasok.size());

            // 3. feladat
            int legtobbMezo = findLegtobbMezo(osvenyek);
            System.out.println("3. feladat: Legtöbb mező az ösvényen: " + legtobbMezo);

            // 4. feladat
            int osvenySorszam = getUserInput("Adja meg az ösvény sorszámát: ");
            int jatekosSzam = getUserInput("Adja meg a játékosok számát (2-5): ");

            // 5. feladat
            int statisztikaSorszam = getUserInput("Adja meg a statisztika készítendő ösvény sorszámát: ");
            createStatisztika(osvenyek.get(statisztikaSorszam));

            // 6. feladat
            writeToKulonleges(osvenyek.get(osvenySorszam), "kulonleges.txt");

            // 7. feladat
            findLegmesszebbJatekos(osvenyek.get(osvenySorszam), dobasok, jatekosSzam);

            // 8. feladat
            findNyertes(osvenyek, dobasok, jatekosSzam);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<Integer, String> readFile(String filename) throws IOException {
        Map<Integer, String> osvenyek = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int sorszam = 1;
            while ((line = br.readLine()) != null) {
                osvenyek.put(sorszam++, line);
            }
        }
        return osvenyek;
    }

    private static Map<Integer, Integer> readDobasok(String filename) throws IOException {
        Map<Integer, Integer> dobasok = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int korszam = 1;
            while ((line = br.readLine()) != null) {
                dobasok.put(korszam++, Integer.parseInt(line));
            }
        }
        return dobasok;
    }

    static int findLegtobbMezo(Map<Integer, String> osvenyek) {
        int legtobbMezo = 0;
        int legtobbMezoSorszam = 0;

        for (Map.Entry<Integer, String> entry : osvenyek.entrySet()) {
            int mezokSzama = entry.getValue().length();
            if (mezokSzama > legtobbMezo) {
                legtobbMezo = mezokSzama;
                legtobbMezoSorszam = entry.getKey();
            }
        }
        return legtobbMezoSorszam;
    }

    private static int getUserInput(String message) {
        System.out.print(message);
        // Itt olvashatnánk be a felhasználó inputját (pl. Scanner használatával)
        // Ebben a példában most csak egy fix értéket adunk vissza.
        return 1;
    }

    private static void createStatisztika(String osveny) {
        // 5. feladat megvalósítása
        // Implementálja, hogy létrehozza a statisztikát
    }

    private static void writeToKulonleges(String osveny, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < osveny.length(); i++) {
                char mezotipus = osveny.charAt(i);
                if (mezotipus == 'K') {
                    writer.write((i + 1) + "\t" + mezotipus + "\n");
                }
            }
        }
    }

    private static void findLegmesszebbJatekos(String osveny, Map<Integer, Integer> dobasok, int jatekosSzam) {
        // 7. feladat megvalósítása
        // Implementálja, hogy megtalálja, melyik játékos jutna a legmesszebb
    }

    private static void findNyertes(Map<Integer, String> osvenyek, Map<Integer, Integer> dobasok, int jatekosSzam) {
        // 8. feladat megvalósítása
        // Implementálja, hogy megtalálja, ki nyer a mezők típusa alapján
    }
}
