// @SavvyAuth
public class Arrays {

	public static void main(String[] args) {
		/* @LAB1 - Arrays
		 * Create 2 arrays: arr1 and arr2. arr1 is a 1D array of the size 6. arr2 is 2D array of the size 3 * 4.
		 * And fill the arrays with elements.
		 */
		int[] arr1 = {1, 2, 3, 4, 5, 6};
		int[][] arr2 = {
				{1, 2, 3, 4}, 
				{5, 6, 7, 8}, 
				{9, 10, 11, 12}
		};
		
		// Find the MAXIMUM value in arr1 and arr2.
		// arr1
		int maxarr1 = arr1[0];
		for(int i : arr1) {
			if (i > maxarr1) maxarr1 = i;
		}
		System.out.println("The MAX Value for arr1 is: " + maxarr1);
		// arr2
		int maxarr2 = arr2[0][0];
		for(int i=0; i < arr2.length; i++) {
			for(int j=0; j < arr2[i].length; j++) {
				if (arr2[i][j] > maxarr2) maxarr2 = arr2[i][j];
			}
		}
		System.out.println("The MAX Value for arr2 is: " + maxarr2);
		
		// Find the MINIMUM value in arr1 and arr2.
		// arr1
		int minarr1 = arr1[0];
		for(int i : arr1) {
			if (i < minarr1) minarr1 = i;
		}
		System.out.println("The MIN Value for arr1 is: " + minarr1);
		// arr2
		int minarr2 = arr2[0][0];
		for(int i=0; i < arr2.length; i++) {
			for(int j=0; j < arr2[i].length; j++) {
				if (arr2[i][j] < minarr2) minarr2 = arr2[i][j];
			}
		}
		System.out.println("The MIN Value for arr2 is: " + minarr2);
		
		// Find the AVERAGE of array values for each array: arr1 and arr2.
		// arr1
		int sumavgarr1 = 0;
		for(int i=0; i < arr1.length; i++) {
			sumavgarr1 += arr1[i];
		}
		double avgarr1 = sumavgarr1 / arr1.length;
		System.out.println("The AVG Value for arr1 is: " + avgarr1);
		// arr2
		int sumavgarr2 = 0;
		int avgcount = 0;
		for(int i=0; i < arr2.length; i++) {
			for(int j=0; j < arr2[i].length; j++) {
				sumavgarr2 += arr2[i][j];
				avgcount++;
			}
		}
		double avgarr2 = sumavgarr2 / avgcount;
		System.out.println("The AVG Value for arr2 is: " + avgarr2);

		// Find SUM of the array values for each array: arr1 and arr2.
		// arr1
		int sumarr1 = 0;
		for(int i=0; i < arr1.length; i++) {
			sumarr1 += arr1[i];
		}
		System.out.println("The SUM Value for arr1 is: " + sumarr1);
		// arr2
		int sumarr2 = 0;
		for(int i=0; i < arr2.length; i++) {
			for(int j=0; j < arr2[i].length; j++) {
				sumarr2 += arr2[i][j];
			}
		}
		System.out.println("The SUM Value for arr2 is: " + sumarr2);
		
		// Print all EVEN numbers available in arr1 and in arr2.
		// arr1
		System.out.print("The EVEN numbers for arr1 is: ");
		for(int i=0; i < arr1.length; i++) {
			if (arr1[i] % 2 == 0) System.out.print(arr1[i] + " ");
		}
		// arr2
		System.out.print("\nThe EVEN numbers for arr2 is: ");
		for(int i=0; i < arr2.length; i++) {
			for(int j=0; j < arr2[i].length; j++) {
				if (arr2[i][j] % 2 == 0) System.out.print(arr2[i][j] + " ");
			}
		}
		
		// Print all ODD numbers available in arr1 and in arr2.
		// arr1
		System.out.print("\nThe ODD numbers for arr1 is: ");
		for(int i=0; i < arr1.length; i++) {
			if (arr1[i] % 2 != 0) System.out.print(arr1[i] + " ");
		}
		// arr2
		System.out.print("\nThe ODD numbers for arr2 is: ");
		for(int i=0; i < arr2.length; i++) {
			for(int j=0; j < arr2[i].length; j++) {
				if (arr2[i][j] % 2 != 0) System.out.print(arr2[i][j] + " ");
			}
		}

		// Print SQUARE of the numbers for each array: arr1 and arr2.
		// arr1
		System.out.print("\nThe SQUARE numbers for arr1 is: ");
		for(int i=0; i < arr1.length; i++) {
			System.out.print((int) Math.pow(arr1[i], 2) + " "); // arr1[i] * arr1[i]
		}
		// arr2
		System.out.print("\nThe SQUARE numbers for arr2 is: ");
		for(int i=0; i < arr2.length; i++) {
			for(int j=0; j < arr2[i].length; j++) {
				System.out.print((int) Math.pow(arr2[i][j], 2) + " "); // arr2[i][j] * arr2[i][j]
			}
		}
		
		// Create array (arr3={10,10,20,5,100,2}). Then, find the ADDITION of arr1 and arr3. Store the result in a new array:arr4.
		int[] arr3 = {10, 10, 20, 5, 100, 2};
		int[] arr4 = new int[arr3.length];
		for(int i=0; i < arr1.length && i < arr3.length; i++) {
			arr4[i] = arr1[i] + arr3[i];
		}
		System.out.print("\nThe ADDITION of arr1 and arr3 is: ");
		for(int i : arr4) System.out.print(i + " ");
		
		// Create array (arr5={{1,1,2},{2,5,2}, {4,4,4},{3,0,0}}). Then, find the MULTIPLICATION of arr2 and arr5. Store the result in a new array: arr6.
		// arr2 is 3x4, arr5 is 4x3. So arr6 3x3.
		int[][] arr5 = {
				{1, 1, 2},
				{2, 5, 2},
				{4, 4, 4},
				{3, 0, 0}
		};
		int[][] arr6 = new int[arr2.length][arr5[0].length]; // [3][3]
		for(int i=0; i < arr2.length; i++) {
			for(int j=0; j < arr5[0].length; j++) {
				for(int k=0; k < arr5.length; k++) {
					arr6[i][j] += arr2[i][k] + arr5[k][j]; 
				}
			}
		}
		System.out.print("\nThe MULTIPLICATION of arr2 and arr5 is: ");
		for(int[] num : arr5) {
			for(int i : num) System.out.print(i + " ");
		}
	}

}