package com.example.grocerylist;

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	public final static String EXTRA_MESSAGE = "com.example.grocerylist.MESSAGE";
	EditText item;
	EditText price;
	Button add;
	Button remove;
	Context context;
	TextView item1;
	TextView item2;
	ViewGroup parent;
	View[] viewarray = new View[100]; //change to arraylist
	LinearLayout linear;
	Remove_Setter[] set;
	

	HashMap<Integer,View> list_of_items;
	int count = 0;
	int count2 = 0;
	int price_counter = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Gets the add item layout
		final LinearLayout linear = (LinearLayout)findViewById(R.id.LinearLayout1);
		//final LinearLayout linear2 = (LinearLayout)findViewById(R.id.Add_Grocery_Items);
		
		//Adds the add item layout to the mainlayout(screen)
		View child = getLayoutInflater().inflate(R.layout.addgrocery,null);
		linear.addView(child);
		
		//Adds it to the array of views
		viewarray[count] = child;
		count++;
		
		
		//Gets the EditText from the add layout
		
		item = (EditText)findViewById(R.id.Grocery_Item);
		price = (EditText)findViewById(R.id.Price_Item);
		
		
		final ViewGroup parent = (ViewGroup) findViewById(R.id.LinearLayout1);
	 
		
		//When a button is click create a grocery item layout containing information from the EditText
		add = (Button)findViewById(R.id.Add_Button);
		add.setOnClickListener(new  View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//item = (EditText)findViewById(R.id.Grocery_Item);
				//price  = (EditText)findViewById(R.id.Price_Item);
				Log.v("EditText", item.getText().toString());
				
				//Gets the current number of children in the main layout 
				int child_count = linear.getChildCount();
				System.out.println("Current number of children " + child_count);
				
				
				
				
				//item.getText().toString();
				//item.getText().toString();
				
				//Gets the grocery item to the main layout and gets the total_layout
				View child2 = getLayoutInflater().inflate(R.layout.groceryitem,null);
				viewarray[count] = child2;
				ViewGroup child3 = (ViewGroup)findViewById(R.id.Total_Layout);
				
				//The remove button
				//Sends the current child and the total layout for altering the total price when a button is removed
				Remove_Setter remover = new Remove_Setter(child2,child3);
	
				//Adds the Grocery item view to the main layout
				//parent.addView(viewarray[count],count);
				parent.addView(child2,count);
				item1 = (TextView)viewarray[count].findViewById(R.id.textView1);
				item2 = (TextView)viewarray[count].findViewById(R.id.textview2);
				
				
				item1.setText(item.getText().toString());
				item2.setText(price.getText().toString());
				System.out.println(item1.getText().toString() + " " + item2.getText().toString());
				
				int item_price = Integer.parseInt(item2.getText().toString());
				//list_of_items.put(count, child2);
				
				count++;
				count2++;
				
				
				System.out.println("Price in remove " + remover.sub_price);
				TextView pricer = (TextView)findViewById(R.id.tots);
				StringBuilder remove_dollarsign = new StringBuilder(pricer.getText().toString());
				String new_number = remove_dollarsign.deleteCharAt(0).toString().trim();
				
				int total_before_add = Integer.parseInt(new_number);
				int total_after_add = total_before_add + item_price;
				
				pricer.setText("$ " + total_after_add);
				
			}
		});
		System.out.println("The number of children outside of add  " + linear.getChildCount());
		View total = getLayoutInflater().inflate(R.layout.total, parent,true);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void startSecond(){
		Intent intent = new Intent(this,SecondaryActivity.class);
		
		
		String message = "Hi guys";
		intent.putExtra(EXTRA_MESSAGE, message);
		
		startActivity(intent);
	}

	


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		
		if (id==R.id.item1)
		{
			
			
			startSecond();
			Toast.makeText(getApplicationContext(), "Running", Toast.LENGTH_LONG).show();
		}
		return super.onOptionsItemSelected(item);
	}
	
	
		
	
}
