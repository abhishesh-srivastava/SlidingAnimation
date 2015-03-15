package com.abhishesh.slidinganimation;

import android.graphics.drawable.Drawable;

public class GridViewItem {

	String name;
	String packageName;
	Drawable icon;
	
	public GridViewItem(String itemName, Drawable image, String pName) {
		// TODO Auto-generated constructor stub
		name = itemName;
		packageName = pName;
		icon = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public Drawable getIcon() {
		return icon;
	}
	public void setIcon(Drawable icon) {
		this.icon = icon;
	}

}
