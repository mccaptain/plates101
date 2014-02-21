package com.example.weights;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWeight = 0.0;
        updateOutput();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void addWeight(View view)
    {
    	double theWeight = Double.parseDouble( (String)view.getTag() );
    	mWeight += theWeight;
    	updateOutput();
    }
    
    public void removeWeight(View view)
    {
    	double theWeight = Double.parseDouble( (String)view.getTag() );
    	if( mWeight >= theWeight )
    	{
    		mWeight -= theWeight;
    		updateOutput();
    	}

    }
    
    private void updateOutput()
    {
    	TextView theText = (TextView) findViewById( R.id.mTxWeight );
    	theText.setText( String.format(" %s Kg", mWeight.toString() ) );
    	
    	Double thePoundage = mWeight * 2.20462;
    	TextView theLbText = (TextView) findViewById( R.id.mTxLbWeight );
    	DecimalFormat theDf = new DecimalFormat("#.##");
    	
    	theLbText.setText( String.format( "%s Lb", theDf.format( thePoundage ) ) );
    }
    private Double mWeight;
}
