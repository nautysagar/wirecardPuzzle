package org.wirecard.puzzle;



public class FruitBox {
	
	private int boxNo = 0;
	
	private FruitBox nextBox = null;
	
	private String labels;
	
	private String fruits ;

	public int getBoxNo() {
		return boxNo;
	}

	public void setBoxNo(int boxNo) {
		this.boxNo = boxNo;
	}

	public FruitBox getNextBox() {
		return nextBox;
	}

	public void setNextBox(FruitBox nextBox) {
		this.nextBox = nextBox;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getFruits() {
		return fruits;
	}

	public void setFruits(String fruits) {
		this.fruits = fruits;
	}

	public String toString(){
		return "Box "+boxNo+" is labeled as "+labels;
	}
	
	
	public String toStringWithContains() {
		return "Box "+getBoxNo()+" is labeled as "+getLabels()+" but contains "+getFruits();
	}

	
	public String fruitToString() {
		return "Box "+getBoxNo()+" but contains "+getFruits();
	}

	

}
