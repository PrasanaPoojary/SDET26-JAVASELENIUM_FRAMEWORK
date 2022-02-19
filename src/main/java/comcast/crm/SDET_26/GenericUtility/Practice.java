package comcast.crm.SDET_26.GenericUtility;

import java.util.Random;

public class Practice {

public static void main(String[] args) {
	
		Random random  =new Random();
		int randomNumber = random.nextInt(10000);
	
		System.out.println(randomNumber);
	}
}
