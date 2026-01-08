public class CaesarCipher implements Cipher {

    private Integer parseShift(String key) {
        try {
            return Integer.parseInt(key);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String encrypt(String message, String key) {
        Integer shiftValue = parseShift(key);

        if (shiftValue == null) {
            return "[ERROR] Shift key must be a valid number.";
        }

        int shift = ((shiftValue % 26) + 26) % 26;
        StringBuilder result = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((ch - base + shift) % 26 + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt(String message, String key) {
        Integer shiftValue = parseShift(key);

        if (shiftValue == null) {
            return "[ERROR] Shift key must be a valid number.";
        }

        int shift = ((shiftValue % 26) + 26) % 26;
        return encrypt(message, String.valueOf(26 - shift));
    }

    @Override
    public String getName() {
        return "Caesar Cipher (Ancient Rome)";
    }

    @Override
    public String context() {
        return "Caesar Cipher (Ancient Rome):\n" +
                "Origin: Julius Caesar used this cipher around 58-50 BC.\n" +
                "Usage: Simple shift of letters to hide military messages.\n" +
                "Purpose: Allowed secret communication across enemy lines.";
    }
}
