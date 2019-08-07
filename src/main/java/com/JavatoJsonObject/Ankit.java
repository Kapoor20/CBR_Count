package com.JavatoJsonObject;

import java.util.List;

public class Ankit {

	private List<Cbrvo> cbrvo;

	public List<Cbrvo> getCbrvo() {
		return cbrvo;
	}

	public void setCbrvo(final List<Cbrvo> cbrvo) {
		this.cbrvo = cbrvo;
	}

	@Override
	public String toString() {
		return "Ankit [cbrvo=" + cbrvo + "]";
	}

	/*
	 * public Cbrvo[] getCbrvo() { return cbrvo; }
	 * 
	 * public void setCbrvo(final Cbrvo[] cbrvo) { this.cbrvo = cbrvo; }
	 * 
	 * @Override public String toString() { return "ClassPojo [cbrvo = " + cbrvo
	 * + "]"; }
	 */

}
