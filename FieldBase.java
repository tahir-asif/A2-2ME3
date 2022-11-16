import java.util.ArrayList;

public class FieldBase extends Message implements Multiples, Communication {

	private HomeBase homeBase;
	private ArrayList<Spy> spies = new ArrayList<Spy>();  // list of spy objects registed to this base
	private boolean isRegistered = false;
	private Encryption encryptionAlg;
	private int key;
	private String lastMsg;


	public FieldBase(HomeBase homeBase) {
		register(homeBase);
		getEncryption(homeBase.getEncryptionAlg(), homeBase.getKey());
	}

	// exact same as home base's remove but for add/remove spies
	public void remove(Spy spy) {
		for (int i = 0; i < spies.size(); i++) {
			if (spies.get(i) == spy) {
				spies.remove(i);
				break;
			}
		}
	}

	public void add(Spy spy) {
		spies.add(spy);
	}

	public void register(HomeBase homeBase) {
		this.homeBase = homeBase;
		isRegistered = true;
	}


	// overrides

	@Override  // to go dark
	public void unregister() {
		homeBase.remove(this);
		isRegistered = false;
	}

	@Override
	public void getEncryption(Encryption e, int key) {
		this.encryptionAlg = e;
        this.key = key;
		for (Spy s : spies) {
            s.getEncryption(this.encryptionAlg, this.key);
        }
	}


	// getters and setters

	public String getLastMsg() {
		return this.lastMsg;
	}

	public void setLastMsg(String lastMsg) {
		this.lastMsg = lastMsg;
	}
	
}
