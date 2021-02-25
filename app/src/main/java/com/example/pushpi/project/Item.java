package com.example.prachi.project;

import android.graphics.Bitmap;

public class Item
{
	public Bitmap image;
	public String title;
	public boolean isSelected;
	

	public boolean isSelected()
	{
		return isSelected;
	}


	public void setSelected(boolean isSelected)
	{
		this.isSelected = isSelected;
	}


	public Item(Bitmap image, String title)
	{
		super();
		this.image = image;
		this.title = title;
	}


	public Bitmap getImage()
	{
		return image;
	}

	public void setImage(Bitmap image)
	{
		this.image = image;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

}
