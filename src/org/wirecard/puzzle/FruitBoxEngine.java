package org.wirecard.puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FruitBoxEngine extends AbstractFruitEngine {
	
	private FruitBox box1;
	private FruitBox box2;
	private FruitBox box3;
	private List<Integer> selectedCombination = new ArrayList<Integer>();
	public static Scanner scan ;
	private int input;
	
	public FruitBoxEngine(){}
	
	private static FruitBoxEngine instance = new FruitBoxEngine();
	
	
	public static FruitBoxEngine Instance(){
		return instance;
	}
	
	
	public static int randomInit(){
		Random rad = new Random();
		return rad.nextInt(4);
	}
	
	
	public void intializeEngine(){
		int randomNo = randomInit();
		boolean firstbox = false;
		boolean secondbox = false;
		boolean thirdbox = false;
		while(true){
			if(randomNo != 0 && !firstbox){
				if(!selectedCombination.contains(randomNo)){
					box1 = new FruitBoxImplementation().constructBox(1, randomNo);
					firstbox = true;
					selectedCombination.add(randomNo);
				}
			}else if(randomNo != 0 && !secondbox){
				if(!selectedCombination.contains(randomNo)){
					box2 = new FruitBoxImplementation().constructBox(2, randomNo);
					secondbox = true;
					selectedCombination.add(randomNo);
				}
			}else	if(randomNo != 0 && !thirdbox ){
				if(!selectedCombination.contains(randomNo)){
					box3 = new FruitBoxImplementation().constructBox(3, randomNo);
					selectedCombination.add(randomNo);
					break;
				}
			}
			randomNo = randomInit();
		}
		
		
		box1.setNextBox(box2);
		box2.setNextBox(box3);
		box3.setNextBox(box1);
	
		System.out.println("Please select any one of the below box. All these boxs are wrongly labelled and you get only one attempt to correct it. ");
		System.out.println("1. "+box1.toString());
		System.out.println("2. "+box2.toString());
		System.out.println("3. "+box3.toString());
		System.out.println("4. Exit:  ");
	}
	
	public void EnterInput(){
		scan = new Scanner(System.in);
		System.out.println("Please Pick the box to open?? 1, 2 or 3. or input 4 for exit");
		
		input = scan.nextInt();
		
		while(input != 4){
			if(input == 1){
				System.out.println(box1.toStringWithContains());
				 soultion(input,box1);
				 break;
				
			}else if (input == 2){
				System.out.println(box2.toStringWithContains()); 
				 soultion(input,box2);
				 break;
				
			}else if (input == 3){
				System.out.println(box3.toStringWithContains()); 
				 soultion(input, box3);
				 break;
			}else if (input == 4){
				System.exit(0);
			}else{
				System.out.println("Invalid input, please try again");
			}
			
			input = scan.nextInt();
		}
	}
	
	private void soultion(int input,FruitBox box){
		int x = 0;
		if(input<3){
			x = ++input;
		}else{
			x = 1;
		}
		
		if(box.getFruits().equalsIgnoreCase(FruitNameEnum.APPLE)){
			System.out.println("What is the content of Box "+ (x) +"??: press 1 for "+FruitNameEnum.ORANGE+", 2 "+FruitNameEnum.APPLE_ORANGE);
			int num = scan.nextInt();

			do {
				if(num == 1){
					System.out.println(box.getNextBox().toStringWithContains());
					if(box.getNextBox().getFruits().equals(FruitNameEnum.ORANGE)){
						System.out.println("****WINNER****");
					}else{
						System.out.println("***LOSER****");
					}
					break;
				}else if (num == 2){
					System.out.println(box.getNextBox().toStringWithContains());
					if(box.getNextBox().getFruits().equals(FruitNameEnum.APPLE_ORANGE)){
						System.out.println("****WINNER****");
					}else{
						System.out.println("***LOSER****");
					}
					break;

				}else{
					System.out.println("Invalid input, please try again");
				}
				num = scan.nextInt();
			}
			while (num == 1 || num == 2);

		} else if(box.getFruits().equalsIgnoreCase(FruitNameEnum.ORANGE)){
			System.out.println("What is the content of Basket "+ (x) +"??: press 1 for "+FruitNameEnum.APPLE+", 2 for "+FruitNameEnum.APPLE_ORANGE);
			int num = scan.nextInt();

			do {
				if(num == 1){
					System.out.println(box.getNextBox().toStringWithContains());
					if(box.getNextBox().getFruits().equals(FruitNameEnum.APPLE)){
						System.out.println("****WINNER****");
					}else{
						System.out.println("***LOSER****");
					}
					break;

				}else if (num == 2){
					System.out.println(box.getNextBox().toStringWithContains());
					if(box.getNextBox().getFruits().equals(FruitNameEnum.APPLE_ORANGE)){
						System.out.println("****WINNER****");
					}else{
						System.out.println("***LOSER****");
					}
					break;

				}else{
					System.out.println("Invalid input, please try again");
				}
				num = scan.nextInt();
			}
			while (num == 1 || num == 2);

		}else if(box.getFruits().equalsIgnoreCase(FruitNameEnum.APPLE_ORANGE)){
			System.out.println("What is the content of Basket "+ (x) +"??: press 1 for "+FruitNameEnum.APPLE+", 2 for "+FruitNameEnum.ORANGE);
			int num = scan.nextInt();

			do {
				if(num == 1){
					System.out.println(box.getNextBox().toStringWithContains());
					if(box.getNextBox().getFruits().equals(FruitNameEnum.APPLE)){
						System.out.println("****WINNER****");
					}else{
						System.out.println("***LOSER****");
					}
					break;

				}else if (num == 2){
					System.out.println(box.getNextBox().toStringWithContains());
					if(box.getNextBox().getFruits().equals(FruitNameEnum.ORANGE)){
						System.out.println("****WINNER****");
					}else{
						System.out.println("***LOSER****");
					}
					break;

				}else{
					System.out.println("Invalid input, please try again");
				}
				num = scan.nextInt();
			}
			while (num == 1 || num == 2);

		}
	}
	

}
