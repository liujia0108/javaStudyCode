import java.util.Scanner;


public class scholarship {
	public static void quickSort(String a[][],int low,int height) {
		int i,j,index2;
		String index1,index0;
		if (low > height) {
			return;
		}
		i = low;
		j = height;
		index0 = a[i][0];
		index1 = a[i][1];
		index2 = Integer.parseInt(a[i][2]);
		while (i < j) {
			//test
			//System.out.println("i:" + i +";index2 :" +index2);
			//System.out.println("j:" + j +";a[j][2]:" +a[j][2]);
			while (i < j && Integer.parseInt(a[j][2]) >= index2) {
				j--;
				
			}
			if (i < j) {
				a[i][2] = a[j][2];
				a[i][0] = a[j][0];
				a[i][1] = a[j][1];
				i = i +1;
				
			}
			while(i < j && Integer.parseInt(a[i][2]) < index2){
				i++;
			}
			if (i < j) {
				a[j][2] = a[i][2];
				a[j][0] = a[i][0];
				a[j][1] = a[i][1];
				j = j -1;
			}
			
		}
		
		a[i][2] = String.valueOf(index2);
		a[i][0] = index0;
		a[i][1] = index1;
		quickSort(a, low, i -1);
		quickSort(a, i + 1, height);
		
	}

	//the key is here,to creat a class to add it's value
	static class Person
	{
		int ID = -1;
		String name = null;
		int max = -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		String[][] array = new String[N][6];
		String[][] finalScholarship = new String[N][3];
		int scholarship = 0;

		Person per1 = null;
		per1 = new Person();
		
		if (N >= 1 && N <= 100) {
			for (int i  = 0;i < N;i++) {
				String input = scanner.nextLine();
				String[] inputList = input.split(" ");
				String studentName = inputList[0];
				int studentFinalGrade = Integer.parseInt(inputList[1]);
				int studentClassGrade = Integer.parseInt(inputList[2]);
				String studentLeader = inputList[3];
				String studentWest = inputList[4];
				int studentThesis = Integer.parseInt(inputList[5]);
				int studentSum = 0;
				if (studentFinalGrade > 80 && studentThesis >= 1) {
					studentSum = studentSum + 8000;
				}
				if (studentFinalGrade > 85 && studentClassGrade > 80) {
					studentSum = studentSum + 4000;
				}
				if (studentFinalGrade > 90) {
					studentSum = studentSum + 2000;
				}
				if (studentFinalGrade > 85 && studentWest.equalsIgnoreCase("Y")) {
					studentSum = studentSum + 1000;
				}
				if (studentClassGrade > 80 && studentLeader.equalsIgnoreCase("Y")) {
					studentSum = studentSum +850;
				}
				System.out.println(i + ":" + studentSum);
				scholarship = scholarship + studentSum;
				//each line is a string[],and caculate it's money then compare,modify the class value if larger!
				if (studentSum > per1.max) {
					per1.max = studentSum;
					per1.ID = i;
					per1.name = studentName;
				}
				
			}
			
		}
		System.out.println(per1.name);
		System.out.println(per1.max);
		System.out.println(scholarship);

		/*
			String detailLine = scanner.nextLine();
			String[] b = detailLine.split(" ");
			int sumPersonal = 0;
			String name = b[0];
			//System.out.println("name :" + name);
			int finalGrade = Integer.parseInt(b[1]);
			//System.out.println("finalGrade :" + finalGrade);
			int classGrade = Integer.parseInt(b[2]);
			//System.out.println("classGrade :" + classGrade);
			String leader = b[3];
			//System.out.println("leader :" + leader);
			String west = b[4];
			//System.out.println("west :" + west);
			int thesis = Integer.parseInt(b[5]);
			//System.out.println("thesis :" + thesis);
			if (finalGrade > 80 && thesis >= 1) {
				sumPersonal = sumPersonal + 8000;
			}
			if (finalGrade > 85 && classGrade > 80) {
				sumPersonal = sumPersonal + 4000;
			}
			if (finalGrade > 90) {
				sumPersonal = sumPersonal + 2000;
			}
			if (finalGrade > 85 && west.equalsIgnoreCase("Y")) {
				sumPersonal = sumPersonal + 1000;
			}
			if (classGrade > 80 && leader.equalsIgnoreCase("Y")) {
				sumPersonal = sumPersonal +850;
			}
			
		}
		
		
		
			for (int i = 0; i < N; i++) {
				String detailLine = scanner.nextLine();
				String[] b = detailLine.split(" ");
				for (int j = 0; j < 6; j++) {
					array[i][j] = b[j];
					//System.out.println("i+j:" +i +"+" + j + ":" + array[i][j]);
					
				}
				int sumPersonal = 0;
				String name = array[i][0];
				//System.out.println("name :" + name);
				int finalGrade = Integer.parseInt(array[i][1]);
				//System.out.println("finalGrade :" + finalGrade);
				int classGrade = Integer.parseInt(array[i][2]);
				//System.out.println("classGrade :" + classGrade);
				String leader = array[i][3];
				//System.out.println("leader :" + leader);
				String west = array[i][4];
				//System.out.println("west :" + west);
				int thesis = Integer.parseInt(array[i][5]);
				//System.out.println("thesis :" + thesis);
				if (finalGrade > 80 && thesis >= 1) {
					sumPersonal = sumPersonal + 8000;
				}
				if (finalGrade > 85 && classGrade > 80) {
					sumPersonal = sumPersonal + 4000;
				}
				if (finalGrade > 90) {
					sumPersonal = sumPersonal + 2000;
				}
				if (finalGrade > 85 && west.equalsIgnoreCase("Y")) {
					sumPersonal = sumPersonal + 1000;
				}
				if (classGrade > 80 && leader.equalsIgnoreCase("Y")) {
					sumPersonal = sumPersonal +850;
				}
				//System.out.println("sumPersonal :" + sumPersonal);
				String[] personalResult = new String[3];
				personalResult[0] = String.valueOf(i);
				personalResult[1] = name;
				personalResult[2] = String.valueOf(sumPersonal);
				for (int p = 0; p < personalResult.length; p++) {
					finalScholarship[i][p] = personalResult[p];
					//System.out.println(p +":" + finalScholarship[i][p]);
				}
				

				
			}
		}
		
		
		//System.out.println("before finalScholarship :" + finalScholarship.length);
		quickSort(finalScholarship,0,finalScholarship.length-1);
		//for test print
		for (int w = 0; w < N; w++) {
			//System.out.println(finalScholarship[w][0] +":" + finalScholarship[w][1] + ":" + finalScholarship[w][2]);
		}
		//System.out.println("++++++++++++++++++");
		
		for (int w = 0; w < N; w++) {
			int compareTurnBefore = Integer.parseInt(finalScholarship[w][2]);
			scholarship = scholarship + Integer.parseInt(finalScholarship[w][2]);

			//in order to output the first name when get the same scholarship!,change the name to latest one!
			String tempName = "";
			if (w >= 1 && finalScholarship[w][2].equalsIgnoreCase(finalScholarship[w - 1][2])
					&& (Integer.parseInt(finalScholarship[w][0]) > Integer.parseInt(finalScholarship[w - 1][0]))) {
				//System.out.println("start to change name!");
				tempName = finalScholarship[w - 1][1];
				finalScholarship[w - 1][1] = finalScholarship[w][1];
				finalScholarship[w][1] = tempName;
				
			}
		}
		System.out.println(finalScholarship[N-1][1]);
		System.out.println(finalScholarship[N-1][2]);
		System.out.println(scholarship);
		*/
	}

}
