import java.util.Scanner;


public class isbn {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		String inputString2= inputString.replaceAll("\\-", "");
		//System.out.println(inputString2);
		//System.out.println("inputString2.length:" + inputString2.length());
		int sum = 0;
		String symbol = null;
		for (int i = 0; i < inputString2.length(); i++) {
			if (i < (inputString2.length() - 1)) {
				//System.out.println(i + ": " + inputString2.charAt(i));
				//.charAt() will return the char type,it output the ASCII,so need to turn char to int!
				sum = sum + Integer.parseInt(String.valueOf(inputString2.charAt(i))) * (i + 1);
				//System.out.println("sum: " + sum);
			}else {
				//System.out.println("i: " + i);
				symbol = String.valueOf(inputString2.charAt(i));
				//System.out.println("symbol :" + symbol);
				String remainder = String.valueOf(sum % 11);
				if (remainder.equalsIgnoreCase("10")) {
					remainder = "X";
				}
				if (remainder.equalsIgnoreCase(symbol)) {
					System.out.println("Right");
				} else {
					//System.out.println("remainder: "+ String.valueOf(remainder));
					String s1 = inputString2.substring(0, 1);
					//System.out.println("s1 : " + s1);
					String s2 = inputString2.substring(1, 4);
					//System.out.println("s2 : " + s2);
					String s3 = inputString2.substring(4, 9);
					//System.out.println("s3 : " + s3);
					String lastCharactor = inputString2.substring(i);
					//System.out.println("lastCharactor1 : " + lastCharactor);
					lastCharactor = remainder;
					//System.out.println("lastCharactor2 : " + lastCharactor);
					String newString = s1 + "-" + s2 + "-" + s3 + "-" + lastCharactor;
					System.out.println(newString);
					
			}
			
		}

			

		}

	}

}
