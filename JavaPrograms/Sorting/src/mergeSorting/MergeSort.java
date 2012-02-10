package mergeSorting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeSort {
	public static Object[] myArray;
	public static String output = "";
	public static int length;
	public static int numOfSwaps = 0;

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		String inputNum = in.nextLine();
		String testCase = "";

		while (inputNum.equals("0") == false) {
			inputNum.trim();
			testCase = "";
			int e = 0;
			// System.out.println("i is " + e );
			while (inputNum.charAt(e) != ' ') {
				testCase = testCase + inputNum.charAt(e);
				e++;
				// System.out.println("i ins " +e );
			}
			testCase.trim();
			String inputNumbers = "";

			inputNumbers = inputNum.substring(e + 1);
			int y = 0;
			myArray = new Object[Integer.parseInt(testCase)];
			int l = 0;
			String num;
			while (y < inputNumbers.length()) {
				num = "";
				while (inputNumbers.charAt(y) != ' ') {
					// System.out.println("chartAt(" + y +") is " +
					// alien.charAt(y) );
					num = num + inputNumbers.charAt(y);
					y++;
					if (y == inputNumbers.length())
						break;
				}
				num.trim();
				// System.out.println("num is " + num );
				myArray[l] = Integer.parseInt(num);
				l++;
				y++;
			}
			numOfSwaps = 0;
			int length = myArray.length - 1;
			Object[] result = sortArray(myArray);
			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]+" ");
				
			}
			// for (int x = 0; x< Integer.parseInt(testCase); x ++){
			// System.out.print(myArray[x] + " ");
			// }
			String person = "";
//			numOfSwaps+=numOfSwaps>0?1:0;
			if (numOfSwaps % 2 == 0) // if even
			{
				person = "Onlooker";
			} else {
				person = "Magician"; // if odd
			}
			System.out.println(person + " " + numOfSwaps);
			inputNum = in.nextLine();
			

		}
	}

	// function sortArray uses merge sort
	public static Object[] sortArray(Object ArrayOfCards[]) {
		if(ArrayOfCards.length<=1){
			return ArrayOfCards;
		}
		int mid = ArrayOfCards.length / 2;
		
		Object[] left=new Object[mid];
		Object[] right=new Object[mid];
		if(ArrayOfCards.length%2==1){
			right=new Object[mid+1]; 
			}
		

		for (int i = 0; i < mid; i++) {
			left[i] = ArrayOfCards[i];
		}
		int j=0;
		for (int i = mid; i < ArrayOfCards.length; i++) {
			right[j++] = ArrayOfCards[i];
		}

		left = sortArray(left);
		right = sortArray(right);

		return merge(left, right);
	}

	static Object[] merge(Object[] statleft, Object[] statright) {
		
		ArrayList<Integer> result=new ArrayList<Integer>();
		int i = 0;
		ArrayList<Integer> left = new ArrayList(Arrays.asList(statleft));
		
		List<Integer> right = new ArrayList(Arrays.asList(statright));
		while (left.size() > 0 || right.size() > 0) {			
			if (left.size() > 0 && right.size() > 0) {
				if (right.get(0) > left.get(0)) {
						
					result.add(left.get(0));
					i++;
					left.remove(0);
				} else {
					numOfSwaps+=left.size();	
					result.add(right.get(0));
					i++;
					right.remove(0);
				}

			} 
			else if (left.size() > 0) {
				
				result.addAll(left);
				break;
			} 
			else if (right.size() > 0) {
			//	numOfSwaps+=right.size();
//				numOfSwaps++;
					result.addAll(right);
				break;
			}
		
		}
		return result.toArray();
	}

}