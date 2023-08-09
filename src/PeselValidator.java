public class PeselValidator {
    private static PeselValidator instance;
    private final byte[] PESEL_DIGITS_WEIGHTS;
    private PeselValidator() {
        PESEL_DIGITS_WEIGHTS = new byte[] {
                1, 3, 7, 9, 1, 3, 7, 9, 1, 3
        };
    }

    public static PeselValidator getInstance() {
        if(instance == null)
            instance = new PeselValidator();
        return instance;
    }
    public boolean ValidatePesel(String pesel) {
        return ValidatePesel(pesel.trim().toCharArray());
    }
    private boolean ValidatePesel(char[] pesel) {
        final byte PESEL_LENGTH = 11;
        int checkDigit;
        if(pesel.length != PESEL_LENGTH)
            return false;
        else {
            if(consistsOnlyOfNumbers(pesel)) {
                checkDigit = calculateCheckDigit(pesel);
                return checkDigit == Character.getNumericValue(pesel[pesel.length-1]);
            }
            return false;
        }
    }

    private boolean consistsOnlyOfNumbers(char[] pesel) {
        for (char c : pesel) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    private int calculateCheckDigit(char[] pesel) {
        int sum = 0;
        int[] peselDigits = parseCharsToInt(pesel);

        for (int i = 0; i < peselDigits.length - 1; i++) {
            sum += multiply(peselDigits[i], i);
        }

        while(sum > 9) {
            sum %= 10;
        }
        return 10 - sum;
    }

    private int[] parseCharsToInt(char[] pesel) {
        int[] peselDigits = new int[pesel.length];
        for(int i = 0; i < pesel.length; i++)
            peselDigits[i] = Character.getNumericValue(pesel[i]);
        return peselDigits;
    }

    private int multiply(int digit, int i) {
        int multiplicationResult = digit * PESEL_DIGITS_WEIGHTS[i];
        if(multiplicationResult > 9)
            multiplicationResult %= 10;
        return multiplicationResult;
    }
}