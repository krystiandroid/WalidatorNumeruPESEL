import java.util.Scanner;

public class Reader {
    static Reader instance;
    private final Scanner scanner;
    private Reader() {
        scanner = new Scanner(System.in);
    }
    public static Reader getInstance() {
        if(instance == null)
            instance = new Reader();
        return instance;
    }

    public String getText(String label) {
        System.out.printf("%s: ", label);
        return scanner.nextLine();
    }
}
