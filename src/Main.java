public class Main {

    private static final Cipher[] ciphers = {
            new CaesarCipher(),
            new XorCipher(),
            new SubstitutionCipher(),
            new LetHimCook(),
    };

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Whisper_shHHH ===");
            System.out.println("Secrets Traveling Unseen");
            System.out.println("1. Encrypt Message");
            System.out.println("2. Decrypt Message");
            System.out.println("3. Exit");

            int choice = Utils.inputInt("Choose option: ");

            // deals with choices

            switch (choice) {
                case 1 -> process(true);
                case 2 -> process(false);
                case 3 -> {
                    System.out.println("Exiting WhisperNet...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void process(boolean encrypt) {
        System.out.println("\nChoose Cipher:");
        for (int i = 0; i < ciphers.length; i++) {
            System.out.println((i + 1) + ". " + ciphers[i].getName());
        }

        int cipherChoice = Utils.inputInt("Select: ") - 1;
        if (cipherChoice < 0 || cipherChoice >= ciphers.length) {
            System.out.println("Invalid cipher.");
            return;
        }

        Cipher cipher = ciphers[cipherChoice];

        if (cipher instanceof CaesarCipher) {
            System.out.println(cipher.context());
        } else if (cipher instanceof XorCipher) {
            System.out.println(cipher.context());
        } else if (cipher instanceof SubstitutionCipher) {
            System.out.println(cipher.context());
        } else {
            System.out.println(cipher.context());
        };

        String message = Utils.input("Enter message: ");
        String key;

        if (cipher instanceof CaesarCipher) {
            key = Utils.input("Enter shift value: ");
        } else if (cipher instanceof XorCipher) {
            key = Utils.input("Enter single character key: ");
        } else if (cipher instanceof SubstitutionCipher) {
            key = Utils.input("Enter 26-letter substitution key (A-Z shuffled): ");
        } else {
            key = Utils.input("Enter single character key: ");
        };

        String result = encrypt ? cipher.encrypt(message, key) : cipher.decrypt(message, key);

        System.out.println("\nResult:");
        System.out.println(result);

        System.out.println("\n[Theme-w9]");
        System.out.println(
                "This cipher demonstrates how messages historically traveled unseen,\n" +
                        "using codes, signals, and hidden patterns."
        );

        Utils.pause();
    }
}
