public class XorCipher implements Cipher {

    @Override
    public String encrypt(String message, String key) {
        char xorKey = key.charAt(0);
        StringBuilder hexResult = new StringBuilder();

        for (char ch : message.toCharArray()) {
            int xorValue = ch ^ xorKey;
            hexResult.append(String.format("%02X", xorValue));
        }
        return hexResult.toString();
    }

    @Override
    public String decrypt(String message, String key) {
        char xorKey = key.charAt(0);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length(); i += 2) {
            String hexByte = message.substring(i, i + 2);
            int value = Integer.parseInt(hexByte, 16);
            result.append((char) (value ^ xorKey));
        }
        return result.toString();
    }

    @Override
    public String getName() {
        return "XOR Cipher (Modern Digital Secrecy)";
    }

    @Override
    public String context() {
        return "XOR Cipher (Modern Digital Secrecy):\n" +
                "Origin: Widely used in modern computing and digital encryption.\n" +
                "Usage: Symmetric encryption where data is XORed with a key.\n" +
                "Purpose: Provides lightweight confidentiality for digital messages.";
    }
}
