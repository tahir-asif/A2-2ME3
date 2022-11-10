public class Spy {

	private int ID;
	private boolean isDead = false;
	private boolean isRegistered = false;
	private int fieldBase;

	public Spy(int ID, int fieldBaseID) {
		this.ID = ID;
		this.fieldBase = fieldBaseID;
		isRegistered = true;
	}

	public void dead(){
		this.isDead = false;
		// send message to field base to unregister
		this.isRegistered = false;
		// condition so they can reregister to any field bases

	}
}
