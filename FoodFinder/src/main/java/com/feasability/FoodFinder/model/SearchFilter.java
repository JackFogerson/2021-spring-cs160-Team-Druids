package com.feasability.FoodFinder.model;

import java.util.ArrayList;

public class SearchFilter {
	
	//private ArrayList<String> selectedBudgets;
	//private ArrayList<String> selectedCuisines;
	
	private String[] selectedBudgets;
	
	private String[] selectedCuisines;
	
	private String location;
		
	
	public String[] getSelectedBudgets() {
		return selectedBudgets;
	}
	
	public void setSelectedBudgets(String[] selectedBudgets) {
		this.selectedBudgets = selectedBudgets;
	}
	
	public String[] getSelectedCuisines() {
		return selectedCuisines;
	}
	
	public void setSelectedCuisines(String[] selectedCuisines) {
		this.selectedCuisines = selectedCuisines;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public int totalSize() {
		int budgetSize = 0;
		int cuisineSize = 0;
		int locationSize = 0;
		if (selectedBudgets != null ) {
			budgetSize = selectedBudgets.length;
		}
		if (selectedCuisines != null) {
			cuisineSize = selectedCuisines.length;
		}
		if (location != "") {
			locationSize += 1;;
		}
		
		return budgetSize + cuisineSize + locationSize;
	}
	
	public int selectedBudgetSize() {
		int budgetSize = 0;
		if (selectedBudgets != null ) {
			budgetSize = selectedBudgets.length;
		}
		return budgetSize;
	}
	
	public int selectedCuisineSize() {
		int cuisineSize = 0;
		if (selectedCuisines != null) {
			cuisineSize = selectedCuisines.length;
		}
		return cuisineSize;
	}
}
