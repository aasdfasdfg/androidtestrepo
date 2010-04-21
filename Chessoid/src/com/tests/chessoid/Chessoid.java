package com.tests.chessoid;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Chessoid extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //Guided by http://en.androidwiki.com/wiki/Dynamically_adding_rows_to_TableLayout
        TableLayout tl = (TableLayout)findViewById(R.id.chessBoard);
        System.out.println(tl.getChildCount());
        tl.getChildAt(3).setBackgroundColor(Color.BLUE);
        int[] specialSquare = { 4, 5};
        TableRow tr;
        TextView tv;
        for(int i=0;i<8;i++) {
        	tr = (TableRow)tl.getChildAt(i);
        	for(int j=0;j<8;j++) {
        		tv = (TextView)tr.getChildAt(j);
        		if(i == specialSquare[0] && j == specialSquare[1]) {
        			tv.setBackgroundColor(Color.RED);
        		}
        	}
        }
    }
    
    private OnClickListener chessBoardSquareListener = new OnClickListener() {
    	public void onClick(View v) {
    		v.setBackgroundColor(Color.BLUE);
    	}
    };
}

