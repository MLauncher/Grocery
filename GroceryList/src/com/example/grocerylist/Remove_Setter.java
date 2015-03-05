package com.example.grocerylist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Remove_Setter {

	Button remove;
	int sub_price;
	TextView price_item_text;
	ViewGroup Total_Remove;
	public Remove_Setter(View v,ViewGroup v2) {
		// TODO Auto-generated constructor stub
		
		//Given layout
		final ViewGroup layout  = (ViewGroup)v;
		View remove_button =layout.getChildAt(2);
		
		Total_Remove = v2;
		
		
		//sub_price = Integer.parseInt(price_text.toString());
		Button remove = (Button)remove_button;
		
		remove.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Get the price of current child
				View price_view = layout.getChildAt(1);
				price_item_text = (TextView)price_view;
				setRemove(Integer.parseInt(price_item_text.getText().toString()));
				
				TextView text = (TextView)Total_Remove.getChildAt(1);
				System.out.println("The price currently: " + text.toString());
				StringBuilder remove_dollarsign = new StringBuilder(text.getText().toString());
				String new_number = remove_dollarsign.deleteCharAt(0).toString().trim();
				
				int total_before_remove = Integer.parseInt(new_number);
				int total_after_remove = total_before_remove- getRemove();
				
				text.setText("$ " + total_after_remove);
				
				System.out.println("Success ");
				layout.removeAllViews();
						
			}
		});
		
	
	}
	
	public void setRemove(int num)
	{
		sub_price = num;
	}
	
	public int getRemove()
	{
		return sub_price;
	}

}
