package org.wirecard.puzzle;

public class FruitBoxImplementation implements FruitBoxBuilder{
	
	private FruitBox box;
	
	public FruitBoxImplementation(){
		box = new FruitBox();
	}

	@Override
	public FruitBox constructBox(int input, int random) {
		box.setBoxNo(input);
		switch(random){
		case 1:
			box.setFruits(FruitNameEnum.ORANGE);
			box.setLabels(FruitNameEnum.APPLE);
			
			break;
		case 2:
			box.setFruits(FruitNameEnum.APPLE);
			box.setLabels(FruitNameEnum.APPLE_ORANGE);	
			break;
		case 3:
			box.setFruits(FruitNameEnum.APPLE_ORANGE);
			box.setLabels(FruitNameEnum.ORANGE);
			break;
		}
		
		return box;
		
	}
}
