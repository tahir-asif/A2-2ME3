public class Message<S extends Communication, R extends Communication> {
	/* should be extended by field base, home base, and spies. R is type of receiver, S is type of sender */
	
	public void send(String msg, int key, S sender, R receiver) {
		// encrypt message
		String encryptedMsg = sender.encryptionAlg.encrypt(msg, key);

		// then send message to receiver
		receiver.receive(encryptedMsg, key, receiver);
	}

	public void receive(String encryptedMsg, int key, R receiver) {
		// saves the decryptedMsg as the receiver's latest message
		receiver.setLastMsg(receiver.encryptionAlg.decrypt(encryptedMsg, key));
	}
}
