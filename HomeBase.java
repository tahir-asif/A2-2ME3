import java.util.ArrayList;

public class HomeBase extends Message implements Communication {

    private ArrayList<FieldBase> fieldBases = new ArrayList<FieldBase>();
    private Encryption encryptionAlg;
    private int key;
    private String lastMsg;


	public HomeBase() {
        AlgorithimA encryptionAlg = new AlgorithimA();
        key = 1;
        chooseEncryption(this.encryptionAlg, this.key);
    }

    // strategy pattern--chose which encryption algorithm just by passing an instance of that class
    public void chooseEncryption(Encryption encryptionAlg, int key) {
        this.encryptionAlg = encryptionAlg;
        this.key = key;

        // observer pattern--field bases observe home base which sends out new encryption, and spies observe field bases
        for (FieldBase f : fieldBases) {
            f.getEncryption(this.encryptionAlg, this.key);  // essentially update()
        }
    }

    // polymorphism--same method different type parameters (other ones are in FieldBase class)
    // add/remove bases
    public void remove(FieldBase base) {
        for (int i = 0; i < fieldBases.size(); i++) {
            if (fieldBases.get(i) == base) {
                fieldBases.remove(i);
                break;
            }
        }
    }

    public void add(FieldBase base) {
        fieldBases.add(base);
    }


    // getters and setters

    public Encryption getEncryptionAlg() {
        return this.encryptionAlg;
    }

    public void setEncryptionAlg(Encryption encryptionAlg) {
        this.encryptionAlg = encryptionAlg;
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getLastMsg() {
        return this.lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }
}
