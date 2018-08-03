package project.eyelashes.RicoEyelash.elements.impl;

import project.eyelashes.RicoEyelash.elements.type.Molgana;

public class TypeNull implements Molgana {

	public TypeNull() {
	}

	@Override
	public void action() {
		System.out.println("Typeが指定外です。");
	}

}
