public interface Multiples {
	/* should be implemented by Spy class and Field class (classes which make multiple objects) */

	// part of the observer pattern:
	// allows spies and field bases to have the encryption algorithm and key chosen by home base to be pushed to them
	public void getEncryption(Encryption encryption, int key);
	public void unregister();
}
