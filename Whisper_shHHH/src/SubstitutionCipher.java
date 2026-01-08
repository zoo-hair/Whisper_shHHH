public class SubstitutionCipher implements Cipher {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private boolean isValidKey(String key) {
        if (key.length() != 26) return false;

        key = key.toUpperCase();
        for (char c = 'A'; c <= 'Z'; c++) {
            if (key.indexOf(c) == -1) return false;
        }
        return true;
    }

    @Override
    public String encrypt(String message, String key) {
        key = key.toUpperCase();

        if (!isValidKey(key)) {
            return "[ERROR] Invalid substitution key. Must contain all 26 letters A-Z exactly once.";
        }

        StringBuilder result = new StringBuilder();

        for (char ch : message.toUpperCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                int index = ALPHABET.indexOf(ch);
                result.append(key.charAt(index));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt(String message, String key) {
        key = key.toUpperCase();

        if (!isValidKey(key)) {
            return "[ERROR] Invalid substitution key. Must contain all 26 letters A-Z exactly once.";
        }

        StringBuilder result = new StringBuilder();

        for (char ch : message.toUpperCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                int index = key.indexOf(ch);
                result.append(ALPHABET.charAt(index));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    @Override
    public String getName() {
        return "Substitution Cipher (Historical Espionage)";
    }

    @Override
    public String context() {
        return "Substitution Cipher (Historical Espionage):\n" +
                "Origin: Used in Europe during the Middle Ages and Renaissance.\n" +
                "Usage: Each letter in the plaintext is replaced by a fixed substitute.\n" +
                "Purpose: Hides information from unintended readers in diplomatic or military messages.";
    }
}
