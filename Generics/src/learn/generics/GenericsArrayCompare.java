package learn.generics;

public class GenericsArrayCompare<E extends B<E> & A<E> & C<E>> {
	
	
	public static void main(String[] args){
		Integer[] arrayOfInt = {1,2,3,4,5,6,7,8,9};
		Double[] arrayOfDouble = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0};
		
		System.out.println(countGreaterThan(arrayOfInt, 4));
		System.out.println(countGreaterThan(arrayOfDouble, 4.0));
		
		printGivenTimes("Saurabh",5);
		printGivenTimes(9,6);
	}
	
	/**
	 * @param array
	 * @param t
	 * @return number of elements greater than element in the array passed as parameter  
	 */
	public static <T extends Comparable<T>> int countGreaterThan(T[] array,T t){
		int count = 0;
		for(T element : array){
			if(element.compareTo(t) > 0)
				count++;
		}
		return count;
	}
	
	/**
	 * @param t
	 * @param u
	 */
	public static <T, U extends Number> void printGivenTimes(T t, U u){
		for(int i = 0; i < u.intValue() ; i++){
			System.out.println(t);
		}
	}

}
