import java.awt.print.Printable;
import java.lang.*;
import java.lang.annotation.Target;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * public class Main {
    public static void main(String[] args){
        System.out.println("Hello world");
    }
}
 * */
public class javaStudy {
	public static String result(int m) {
		String result = "YES";
		if (m <2) {
			return "NO";
		} else {
			for (int z = 2; z <= Math.sqrt(m); z++) {
				if (m%z == 0) {
					result = "NO";
					break;
				} 
			}
		}
		return result;
	}

	public static void main1(String[] args) {
		int[] testArr = {46, 47, 6, 44, 6, 30, 14, 37, 89, 88, 15};
		
//		Arrays.sort(testArr, 0, 5);
		quickSort(testArr, 0, testArr.length - 1);
		for (int i = 0, length = testArr.length; i < length; i++) {
			System.out.println(testArr[i]);
		}
	}
	
	public static void quickSort(int a[], int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i] < index)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index;// 将基准数值替换回 a[i]
        quickSort(a, low, i - 1); // 对低子表进行递归排序
        quickSort(a, i + 1, hight); // 对高子表进行递归排序
    }

	
	public static void main(String[] args) {
		int n = 0;
		int k = 0;
		Scanner scanner4 = new Scanner(System.in);
		String nkString = scanner4.nextLine();
		String compilePattern = "[\\d\\s]+";
		Matcher nkInput = Pattern.compile(compilePattern).matcher(nkString);
		if (nkInput.matches()) {
			String b[] = nkString.split(" ");
			n = Integer.parseInt(b[0]);
			k = Integer.parseInt(b[1]);
		}
		//Scanner scanner5 = new Scanner(System.in);
		String listString = scanner4.nextLine();
		Matcher resultMatcher = Pattern.compile(compilePattern).matcher(listString);
		if (resultMatcher.matches()) {
			String a[] = listString.split(" ");
			int listLength = a.length;
			int c[] = new int[listLength];
			for (int i = 0; i < listLength; i++) {
				c[i] = Integer.parseInt(a[i]);
			}
//			Arrays.sort(b, fromIndex, toIndex);
			if (listLength <= n && n >0 && n <= 10000 && k >0 && k <= n) {
				//System.out.print("list length:" + listLength);
				//input n,k,arraylist done,start to compare
				String temp;//transition value
				quickSort(c,0,c.length - 1);
				
				/*
				int p,q;
				for (p = 1; p < a.length; p++) {
					q = p;
					temp = a[p];
					while(q >0 && Integer.parseInt(temp) < Integer.parseInt(a[q -1])) {
						a[q] = a[q -1];
						q--;
					}
					a[q] = temp;
				}
				*/
				/*
				for (int i = 0; i < listLength - 1; i++) {
					//System.out.println("a[i] :" + Integer.parseInt(a[i]) + ";a[i+1]:" + Integer.parseInt(a[i+1]));
					for (int j = i+1; j < listLength; j++) {
						//从小到大排列,所以第k大就是倒数a[listLength - k]，第k小就是a[k-1]
						//System.out.println("a[i] :" + Integer.parseInt(a[i]) + ";a[i+1]:" + Integer.parseInt(a[i+1]));
						if (Integer.parseInt(a[i]) - Integer.parseInt(a[j]) > 0){
							temp = a[i];
							a[i] = a[j];
							a[j] = temp;//
							
						}
						
					}
					//System.out.println(i + ":" + a[i]);
				}
				*/
				int m;
				m = c[c.length - k] - c[k - 1];
				//m = Integer.parseInt(a[listLength-k]) - Integer.parseInt(a[k-1]);
				
				//判断m是质数
				String primeNumber = result(m);
				System.out.println(primeNumber);
				System.out.println(m);
			}else {
				//System.out.print("input array list out of length,please repeat again!");
			}
		}else {
			//System.out.print("input arraylist is incorrect format!input again!");
		}
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
