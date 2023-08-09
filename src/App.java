public class App {
    public static void main(String[] args) {
        new App().run();
    }
    private void run() {
        String pesel = Reader.getInstance().getText("Wprowadź numer pesel");
        printIsPESELcorrect(PeselValidator.getInstance().ValidatePesel(pesel), pesel);
    }

    private void printIsPESELcorrect(boolean p, String pesel) {
        if(p)
            System.out.printf("Numer pesel: %s jest prawidłowy", pesel);
        else
            System.out.printf("Numer pesel: %s jest nieprawiłowy", pesel);
    }
}
