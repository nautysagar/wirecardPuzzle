package org.wirecard.puzzle;

public abstract class AbstractFruitEngine {
	
	public final void start(){
		intializeEngine();
		EnterInput();
	//	startEngine();
	}
	
	public abstract void intializeEngine();
	
	public abstract void EnterInput();
	
//	public abstract void startEngine();

}
