package learn.tutorials.simpleprograms;

public class FibonacciSeries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int input = 100;
		FibonacciSeries series = new FibonacciSeries();
		int[] firstResultSeries = series.fibSeriesWithoutRecursion(input);
		for(int resultNumber : firstResultSeries){
			System.out.print(resultNumber + "\t");
		}
		System.out.println("");
		int[] secondResultSeries = new int[input]; 
		secondResultSeries = series.fibSeriesWithRecusrion(input, secondResultSeries, 0, 1, 0);
		for(int resultNumber : secondResultSeries){
			System.out.print(resultNumber + "\t");
		}
	}
	
	public int[] fibSeriesWithoutRecursion(int input){
		int[] result = new int[input];
		result[0] = 0; result[1] = 1;
		for(int i = 2; i < input; i++){
			result[i] = result[i-2] + result[i-1];
		}
		return result;
	}
	
	public int[] fibSeriesWithRecusrion(int input, int[] fibSeries, int previous, int current, int count){
		if(input == 0)
			return fibSeries;
		fibSeries[count] = previous;
		current = current + previous;
		previous = current - previous;
		fibSeriesWithRecusrion(input-1, fibSeries, previous, current, count + 1);
		return fibSeries;
	}
}
