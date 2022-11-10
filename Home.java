public class Home extends Encryption<T>  Message<M>{

    private String location;
    private int[] fieldBases;
    private T encryptionAlg;
    private int key;

	public Home() {

    }

    public void chooseAlg(T encryption) {
        this.encryptionAlg = encryption;
    }

    public void chooseKey(int key) {
        this.key = key;
    }

    public void chooseEncryption(T encryption, int key) {
        chooseAlg(encryption);
        chooseKey(key);
    }
}
