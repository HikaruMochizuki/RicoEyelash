package project.eyelashes.RicoEyelash.main;

public class LoginUser {
	private int startPhase;

	public LoginUser(int nextPhase) {
		this.startPhase = nextPhase;
	}

	public int getStartPhase() {
		return startPhase;
	}

	public void setStartPhase(int nextPhase) {
		this.startPhase = nextPhase;
	}

}
