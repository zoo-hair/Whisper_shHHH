public class LetHimCook implements Cipher {

    @Override
    public String encrypt(String message, String key) {
        int k = Integer.parseInt(key);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            int enc = (c + k + i) % 256;
            result.append((char) enc);
        }
        return result.toString();
    }

    @Override
    public String decrypt(String message, String key) {
        int k = Integer.parseInt(key);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            int dec = (c - k - i + 256) % 256;
            result.append((char) dec);
        }
        return result.toString();
    }

    @Override
    public String getName() {
        return "LetHimCook cipher (Made out of inspiration)";
    }

    @Override
    public String context() {
        return "LetHimCook Cipher (Custom Position-Shift):\n" +
                "Origin: Crafted by their excellency Team Alpha, full time AURA farmer.\n" +
                "Usage: Each character is shifted based on its position and a string key.\n" +
                "Purpose: Demonstrates evolving secrets, where repeated letters encrypt differently,\n" +
                "         simulating how messages change as they travel unseen.";
    }
}
