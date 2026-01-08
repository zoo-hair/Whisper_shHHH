public interface Cipher {
    String encrypt(String message, String key);
    String decrypt(String message, String key);
    String getName();
    String context();
}
