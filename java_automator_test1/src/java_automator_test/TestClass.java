package java_automator_test;

import java.io.IOException;
import java.io.FileNotFoundException;

import android.R.integer;
import android.os.RemoteException;
import android.provider.Settings.Global;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

//import org.hamcrest.core.Is;

import android.view.KeyEvent;
import android.widget.Switch;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.text.format.Time;
import android.text.style.BackgroundColorSpan;
import android.util.Log;//can print log in ddms


public class TestClass extends UiAutomatorTestCase {
	public void cancel_forbidinstall_window(String forbid_title) throws UiObjectNotFoundException,IOException{
		try{
			UiObject forbidinstall = new UiObject(new UiSelector().resourceId("android:id/fun_dialog_title"));
			String forbid_window_title = forbidinstall.getText();
			while(forbid_window_title.equalsIgnoreCase(forbid_title)){
				getUiDevice().pressDPadDown();
				UiObject forbid_cancel = new UiObject(new UiSelector().resourceId("android:id/fun_dialog_btn_cancel").focused(true));
				if(forbid_cancel.exists()){
					getUiDevice().pressEnter();
					break;
				}
				else{
					continue;
				}
				
			}
		}catch(Exception e){
			System.out.println("there is no forbid window,but why error occur?");
			Log.d("liujia", "there is no forbid window,but why error occur?");
		}
		
	}
	public void testDemo() throws UiObjectNotFoundException, IOException {
		int loop_num = 10;//every time to execute autotest,need to change this loop_num!!
		int loop = 0;
		for(int loop1 = 0;loop1<loop_num;loop1++){
			Process pro2 = Runtime.getRuntime().exec("am force-stop tv.fun.filemanager");
			//pro2.waitFor();
			//getUiDevice().pressHome();
			sleep(2000);
//			Log.e(tag, msg)
			//UiObject find_filemanagerObject = new UiObject(new UiSelector().)
			try{
				Process pro = Runtime.getRuntime().exec("am start -n tv.fun.filemanager/.MainActivity");
				//sleep(3000);
				int exitValue = pro.waitFor();
				Log.d("liujia","exitValue=" + exitValue);
				System.out.println("test case 1-245:open the filemanager,pass!");
				Log.d("liujia", "case 1-245 passed!");
			}catch(Exception e){
				System.out.println(e.toString());
			}
			//test
			/*
			try{
				FileWriter output = new FileWriter("D:\\personal\\test.txt");
				BufferedWriter bf = new BufferedWriter(output);
				bf.write("测试");
				bf.flush();
				bf.close();
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}
			*/
			
			while (true){
				UiObject get_item_name = new UiObject(new UiSelector().resourceId("tv.fun.filemanager:id/title_item_name").selected(true));
				//byte[] current_item_name = get_item_name.getText().getBytes("utf-8");
				//String aString = current_item_name.toString();
				String current_item_name = get_item_name.getText();
				//Log.d("liujia", "中文测试");
				Log.d("liujia", current_item_name);
				
				String expect1 = "应用";
				byte[] utf8test = expect1.getBytes("utf-8");
//				System.out.print(new String(utf8test,"utf-8"));
				//Log.d("liujia", expect1);
				
				//String class_name = get_item_name.getClassName();
				//debug print
				//System.out.println("get name is:" + aString);
				//System.out.println("class name:" + class_name);
				if (current_item_name.equalsIgnoreCase(expect1)){
					Log.d("liujia", "循环:" + current_item_name);
					System.out.println("change to the last tab!");
					System.out.println("case 1-246 passed !");
					Log.d("liujia", "case 1-246 passed!");
					break;
				}
				else{
					getUiDevice().pressDPadRight();
				}
					
				}
			
			//case 1-714:
			
			getUiDevice().pressBack();
			sleep(5000);
			while(true){
				Log.d("liujia","start to check usb insert,now auto insert has not been implemented,so will execte else content!");
				try{	
					UiObject check_dialog = new UiObject(new UiSelector().resourceId("tv.fun.filemanager:id/dialog_content"));
					//String dialog_name = check_dialog.getText();
					if(check_dialog.exists()){
						UiObject find_open_button = new UiObject(new UiSelector().resourceId("tv.fun.filemanager:id/dialog_btn_confirm"));
						find_open_button.click();
						sleep(4000);
						getUiDevice().pressDPadDown();
						sleep(2000);
						getUiDevice().pressDPadDown();
						UiObject get_usb_name = new UiObject(new UiSelector().resourceId("tv.fun.filemanager:id/list_item_text").selected(true));
						String usb_name = get_usb_name.getText();
						Log.d("liujia", "current usb name is:" + usb_name);
						if(usb_name.equalsIgnoreCase("U盘1")){
							//debug print
							Log.d("liujia", "check USB insert,get in this loop!");
							getUiDevice().pressEnter();
							//getUiDevice().pressKeyCode(20);
							sleep(2000);
							UiObject check_getinto_usb = new UiObject(new UiSelector().resourceId("tv.fun.filemanager:id/indicater_name"));
							String check_case = check_getinto_usb.getText();
							Log.d("liujia", "check_case result :" + check_case);
							if(check_case.equalsIgnoreCase("设备->sda1")){
								Log.d("liujia", "case 1-714 passed!");
								System.out.println("case 1-714 passed!");
								break;
							}
							else{
								Log.d("liujia", "case 1-714 failed,check again!");
								System.out.println("case 1-714 failed,check again!");
							}
						}
						else{
							Log.d("liujia","check usb name:" + usb_name );
							System.out.println("case 1-714 failed,check again!");
							
						}
					}
					else if (!check_dialog.exists()) {
						Process pro1 = Runtime.getRuntime().exec("am start -n tv.fun.filemanager/.MainActivity");
						pro1.waitFor();
						Log.d("liujia", "case1-714 pro1 is:" + pro1);
						getUiDevice().pressDPadDown();
						sleep(2000);
						getUiDevice().pressDPadDown();
						UiObject get_usb_name = new UiObject(new UiSelector().resourceId("tv.fun.filemanager:id/list_item_text").selected(true));
						String usb_name = get_usb_name.getText();
						Log.d("liujia", "current usb name is:" + usb_name);
						if(usb_name.equalsIgnoreCase("U盘1")){
							//debug print
							Log.d("liujia", "check USB insert,get in this loop!");
							getUiDevice().pressEnter();
							//getUiDevice().pressKeyCode(20);
							sleep(2000);
							UiObject check_getinto_usb = new UiObject(new UiSelector().resourceId("tv.fun.filemanager:id/indicater_name"));
							String check_case = check_getinto_usb.getText();
							Log.d("liujia", "check_case result :" + check_case);
							if(check_case.equalsIgnoreCase("设备->sda1")){
								Log.d("liujia", "case 1-714 passed!");
								System.out.println("case 1-714 passed!");
								break;
							}
							else{
								Log.d("liujia", "case 1-714 failed,check again!");
								System.out.println("case 1-714 failed,check again!");
							}
						}
						else{
							Log.d("liujia","check usb name:" + usb_name );
							System.out.println("case 1-714 failed,check again!");						
						}
						Log.d("liujia","there is no usb insert,check again!");
						System.out.println("case 1-714 failed,check again!");
					}
				}catch(Exception e){
					System.out.println(e.toString());
				}
			}
			
			//case-272:
			getUiDevice().pressBack();
			sleep(2000);
			getUiDevice().pressBack();//back to launcher
			try{
				Process open1 = Runtime.getRuntime().exec("am start -n tv.fun.filemanager/.MainActivity");
				open1.waitFor();
				for(int i = 0;i<=5;i = i+1){
					UiObject change_tab1 = new UiObject(new UiSelector().resourceId("tv.fun.filemanager:id/title_item_name").selected(true));
					String current_tab_1 = change_tab1.getText();
					if(current_tab_1.equalsIgnoreCase("应用")){
						//Log.d("liujia", "debug:get into loop to check video apk!");
						getUiDevice().pressDPadDown();
						sleep(2000);
						getUiDevice().pressDPadDown();
						sleep(2000);
						UiObject get_apk_num = new UiObject(new UiSelector().resourceId("tv.fun.filemanager:id/indicater_total"));
						int a = Integer.parseInt(get_apk_num.getText());//string to int
						for(int d = 0;d<= a;d = d+1){
							Log.d("liujia", "d is:" + d);
							UiObject get_apk_name = new UiObject(new UiSelector().resourceId("tv.fun.filemanager:id/list_item_text").selected(true));
							String apk_name = get_apk_name.getText();
							sleep(1000);
							Pattern p = Pattern.compile(".+视频.*");
							Matcher m = p.matcher(apk_name);
							boolean b = m.matches();
							Log.d("liujia", "regex result :" + b);
							if(b){//!!try to use regular expression,apk_name.equalsIgnoreCase("搜狐视频MAX")
								//Log.d("liujia", "debug:has found the video apk,try to open.");
								getUiDevice().pressEnter();
								sleep(3000);
								//getUiDevice().pressEnter();
								//sleep(2000);
								//check if is the risk window
								UiObject forbid_box_check = new UiObject(new UiSelector().resourceId("com.android.packageinstaller:id/message"));
								String forbid_text = forbid_box_check.getText();
								sleep(1000);
								Pattern p1 = Pattern.compile(".*\".+视频.*\"存在使用风险.*");
								Matcher m1 = p1.matcher(forbid_text);
								boolean b1 = m1.matches();
								//check if is the forbid window
								//UiObject forbidinstall = new UiObject(new UiSelector().resourceId("android:id/fun_dialog_title"));
								//String forbid_window_title = forbidinstall.getText();
								
								if(b1){//!!try to use regular expression,forbid_text.equalsIgnoreCase("\"搜狐视频MAX\"存在使用风险， 禁止安装")
									getUiDevice().pressEnter();
									sleep(1000);
									Log.d("liujia", "case -272 passed!");
									System.out.println("case -272 passed!");
								}
								/*
								else if (forbidinstall.exists()) {
									Log.d("liujia", "open another window,enter in!");
									cancel_forbidinstall_window("禁止安装");
								}
								*/
								else{
									Log.d("liujia", "case-272 forbid window regex failed!");
									System.out.println("case-272failed!check apk install permission!");
								}
								break;
							}
							else{
								Log.d("liujia", "regex failed");
								getUiDevice().pressDPadRight();
							}
						}
						
					}
					getUiDevice().pressDPadRight();
					sleep(1000);
				}
			}catch(Exception e){
				System.out.println(e.toString());
			}
			
			//case1-271
			getUiDevice().pressDPadUp();
			Log.d("liujia", "start to excute case 1-271!");
			sleep(2000);
			getUiDevice().pressDPadUp();
			for(int j=0;j<=2;j=j+1){
				//debug
				Log.d("liujia", "try to find video tab!");
				UiObject change_tab2 = new UiObject(new UiSelector().resourceId("tv.fun.filemanager:id/title_item_name").selected(true));
				String change_tab2_name = change_tab2.getText();
				//debug
				Log.d("liujia","change_tab2_name is: "+change_tab2_name);
				if(change_tab2_name.equalsIgnoreCase("视频")){
					Log.d("liujia", "271-get into video tab!");
					getUiDevice().pressDPadDown();
					sleep(1000);
					getUiDevice().pressDPadDown();
					UiObject get_video_fold = new UiObject(new UiSelector().resourceId("tv.fun.filemanager:id/list_item_text").selected(true));
					String get_video_fold_name = get_video_fold.getText();
					if(get_video_fold_name.equalsIgnoreCase("video")){
						Log.d("liujia", "271-have found video floder!");
						sleep(2000);
						
						getUiDevice().pressEnter();
						Log.d("liujia", "1.open video folder");
						sleep(2000);
						getUiDevice().pressEnter();
						Log.d("liujia", "2.play");
						sleep(2000);
						//case1-270
						getUiDevice().pressDPadCenter();//video now Is suspend，play/suspend only cna use this key:pressDPadCenter()
						Log.d("liujia", "3.suspend");
						sleep(2000);
						UiObject get_video_title = new UiObject(new UiSelector().resourceId("com.funshion.mediaplayer:id/title_txt"));
						Log.d("liujia", "video name:" + get_video_title.getText());
						System.out.println(get_video_title.exists());
						UiObject get_suspend_icon = new UiObject(new UiSelector().resourceId("com.funshion.mediaplayer:id/status_icon"));
						if(get_video_title.exists() && get_suspend_icon.exists()){
							Log.d("liujia", "case1-270 passed!");
							System.out.println("case1-270 passed!");
							getUiDevice().pressDPadCenter();//replay
							sleep(3000);//play the video for 5S
							getUiDevice().pressBack();
							getUiDevice().pressBack();
							sleep(2000);
							UiObject get_main_title = new UiObject(new UiSelector().resourceId("tv.fun.filemanager:id/activity_main_title"));
							Log.d("liujia", "get_main_title:" + get_main_title.getText());
							if(get_main_title.getText().equals("文件管理")){
								Log.d("liujia", "case1-271 passed!");
								System.out.println("case1-271 passed!");
							}
							else{
								Log.d("liujia", "case1-271failed,Can not exit video play!");
								System.out.println("case1-271failed!");
							}
						}
						else{
							Log.d("liujia", "case 1-271 &1-270 failed!");
						}
					}
				}
				getUiDevice().pressDPadLeft();
				
			}
			
			//case1-269 & 1-266
			getUiDevice().pressBack();//back to video folder
			UiObject video_number = new UiObject(new UiSelector().resourceId("tv.fun.filemanager:id/video_cover_count").selected(true));
			UiObject video_folder_name = new UiObject(new UiSelector().resourceId("tv.fun.filemanager:id/list_item_text"));
			String video_folder_str = video_folder_name.getText();
			Boolean folder_name = video_folder_str.equalsIgnoreCase("video");
			if(video_number.exists() && folder_name){
				Log.d("liujia", "case1-266 passed!");
				System.out.println("case1-266 passed!");
			}
			else{
				Log.d("liujia", "video_folder_str is :" +video_folder_str);
				Log.d("liujia", "video_number is :" + video_number.getText());
				Log.d("liujia", "case1-266 failed,check again!");
				System.out.println("case1-266 failed,check again!");
			}
			int video_account = Integer.parseInt(video_number.getText());
			getUiDevice().pressEnter();
			sleep(2000);
			int f = 0;
			for(int d=0;d<video_account;d=d+1){
				getUiDevice().pressEnter();
				sleep(2000);
				UiObject video_name = new UiObject(new UiSelector().resourceId("com.funshion.mediaplayer:id/title_txt"));
				if(video_name.exists()){
					//System.out.println("the video name which is playing is:" + video_name.getText());
					Log.d("liujia","the video name which is playing is:" + video_name.getText());
					sleep(6000);//play each video for 1 min,need to change to 60000
					getUiDevice().pressBack();
					getUiDevice().pressBack();
					sleep(1000);
					getUiDevice().pressDPadRight();
					f = f+1;
					if(f == video_account){
						Log.d("liujia", "case1-269 passed!");
						System.out.println("case1-269 passed!");
					}
				}
				else{
					getUiDevice().pressBack();
					getUiDevice().pressBack();//bad file will auto play the next file,so back.
					Log.d("liujia", "some video file can not be play or maybe error occur,check again!");
				}
				
			}
			loop = loop1;
			}
		if(loop == loop_num){
			System.out.println("test finished! total executed~");
			Log.d("liujia", "test finished! total executed~");
		}
		else{
			Log.d("liujia", "execute Time Is :"  + loop);
			System.out.println("execute Time Is :"  + loop);
			float success_rate = loop/loop_num;
			Log.d("liujia", "success_rate :" + success_rate);
		}
		
		}
		
/*	
	public void testCase2() throws IOException,UiObjectNotFoundException {
		
		
	}*/
			
		
	}

	
