package com.nearby.model;

public class Items {

	private String distance;
	private String title;
	private String type;
	
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Items [distance=" + distance + ", title=" + title + ", type=" + type + "]";
	}
	
}
