package libs;
import com.android.uiautomator.core.UiObject;  
import com.android.uiautomator.core.UiObjectNotFoundException;  
import com.android.uiautomator.core.UiSelector;

import java.io.IOException;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
public  class AppStore extends Common{
	
	public void pressHome1(long time){
		getUiDevice().pressHome();
		sleep(time);
	}
	public void pressHome1(){
		getUiDevice().pressHome();
		sleep(1000);
	}

}
