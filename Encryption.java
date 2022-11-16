public interface Encryption {
    /* should be implemented by all encryption algorithms */

    public String encrypt(String msg, int key);
    public String decrypt(String encryptedMsg, int key);

}
