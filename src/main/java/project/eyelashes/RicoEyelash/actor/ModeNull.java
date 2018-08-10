package project.eyelashes.RicoEyelash.actor;

public class ModeNull extends Actor {

	public ModeNull(){
		super("ModeNULL");
	}

	@Override
	public void action() {
		System.out.println("Modeが規定外です。");
	}

}
