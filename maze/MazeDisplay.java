import java.util.ArrayList;

public class MazeDisplay {

	public ArrayList<ArrayList<Integer>> parsedArray(int[][] inputArray) {

		ArrayList<ArrayList<Integer>> parsedArray = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j < inputArray[i].length; j++) {
				ArrayList<Integer> parsedArrayElement = new ArrayList<Integer>();

				int input = inputArray[i][j];
//				System.out.println("input=" + input);
				int units = input % 10;
				int tens = ((input / 10) % 10);
				int hundreds = ((input / 100) % 10);
				int thousands = ((input / 1000) % 10);
				int tenthousands = ((input / 10000) % 10);

				parsedArrayElement.add(tenthousands);
				parsedArrayElement.add(thousands);
				parsedArrayElement.add(hundreds);
				parsedArrayElement.add(tens);
				parsedArrayElement.add(units);

				parsedArray.add(parsedArrayElement);

			}
		}

		return parsedArray;
	}
}
