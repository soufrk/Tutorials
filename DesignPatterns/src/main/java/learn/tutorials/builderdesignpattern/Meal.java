package learn.tutorials.builderdesignpattern;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	private List<Item> listOfItems;
	
	public Meal(){
		listOfItems = new ArrayList<>();
	}
	
	public List<Item> getListOfItems() {
		return listOfItems;
	}
	
	public void setListOfItems(List<Item> listOfItems) {
		this.listOfItems = listOfItems;
	}
	
	public void addItem(Item item){
		listOfItems.add(item);
	}
	
	public float getCost(){
		float totalCost = 0.0f;
		for(Item item : listOfItems){
			totalCost += item.price();
		}
		return totalCost;
	}
	
	public void showItems(){
		for(Item item : listOfItems){
			System.out.println("Item name : " + item.name());
			System.out.println("Item price : " + item.price());
			System.out.println("Item packing : " + item.packing().pack());
		}
	}
}
