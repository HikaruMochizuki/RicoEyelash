package project.eyelashes.RicoEyelash.actor;

public abstract class Actor {

	protected final String name;

	protected Actor(){
		this.name = "Null";
	}

	protected Actor(String name){
		this.name = name;
	}

	public final String getName() {
		return name;
	}

	public abstract void action();
}
