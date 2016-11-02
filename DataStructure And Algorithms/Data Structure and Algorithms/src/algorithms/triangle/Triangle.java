package algorithms.triangle;

public class Triangle {

	public static void main(String[] args) {
		int row = 5;
		for (int i = row; i > 0; i--) {
			System.out.printf("%" + (i) * 2 + "s", "");
			for(int j = i; j <= row; j++)
				System.out.printf("%4s", "*");
			System.out.println();
		}
	}

}
