public class Spy extends Message implements Multiples, Communication {

	private boolean isDead;
	private FieldBase fieldBase;
	private HomeBase homeBase;
	private String lastMsg;
	private Encryption encryptionAlg;
	private int key;

	public Spy(FieldBase fieldBase, HomeBase homeBase) {
		this.homeBase = homeBase;
		this.fieldBase = fieldBase;
		this.fieldBase.add(this);
		isDead = false;
		getEncryption(homeBase.getEncryptionAlg(), homeBase.getKey());
	}

	@Override  // when the spy dies
	public void unregister() {
		if (isDead == true) {
			fieldBase.remove(this);
			this.isDead = true;
		}
	}

	@Override
	public void getEncryption(Encryption e, int key) {
		this.encryptionAlg = e;
        this.key = key;
	}


	// getters and setters

	public String getLastMsg() {
		return this.lastMsg;
	}

	public void setLastMsg(String lastMsg) {
		this.lastMsg = lastMsg;
	}
}
