package ca.ualberta.cs.lonelytwitter.test;

//import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

//@SuppressLint("NewApi") 
public class IntentReaderActivityTest extends
        ActivityInstrumentationTestCase2<IntentReaderActivity> {

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

//TODO: Add your code here:
    public void testSendText(){
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "testing send");
    	intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.NORMAL);
    	
    	setActivityIntent(intent);
    	IntentReaderActivity ira = getActivity();
    	
    	assertEquals(ira.getText(), "testing send");
    }
       
    public void testDisplayText(){
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "testing display");
    	
    	setActivityIntent(intent);
    	IntentReaderActivity ira = getActivity();
    	
    	TextView textView = (TextView) ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
    	
    	assertEquals(textView.getText(), "testing display");
    }
    
    public void testDoubleText(){
    	Intent intent = new Intent();
    	String textString = "testing double";
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, textString);
    	intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
    	
    	setActivityIntent(intent);
    	IntentReaderActivity ira = getActivity();
    	
    	assertEquals(ira.getText(), textString+textString);
    }
    
    public void testReverseText(){
    	Intent intent = new Intent();
    	String textString = "testing reverse";
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, textString);
    	intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.REVERSE);
    	
    	setActivityIntent(intent);
    	IntentReaderActivity ira = getActivity();
    	
    	String newTextString = "";
		for (int i = textString.length() - 1; i >= 0; i--) {
			newTextString += textString.charAt(i);
		}
		
    	assertEquals(ira.getText(), newTextString);
    }
    
    public void testDefaultMessage(){
    	Intent intent = new Intent();
    	setActivityIntent(intent);
    	IntentReaderActivity ira = getActivity();
    	
    	assertEquals(ira.getText(), "default text");
    }
    
    public void testTextViewVisible(){
    	Intent intent = new Intent();
    	String textString = "testing visible";
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, textString);
    	
    	setActivityIntent(intent);
    	IntentReaderActivity ira = getActivity();
    	
    	TextView textView = (TextView) ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
    	
    	ViewAsserts.assertOnScreen(ira.getWindow().getDecorView(), textView);
    }
}
