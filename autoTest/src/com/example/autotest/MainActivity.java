package com.example.autotest;

import java.security.PublicKey;

import org.apache.http.protocol.ResponseConnControl;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.widget.TextView;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.*;


public class MainActivity extends Activity {
	private class ResponseListener implements Response.Listener<String> {
		public void onResponse(String response) {
			Log.d("liujia", "-----\n" + response);
		}
	}
	
	private class ResponseErrorListener implements Response.ErrorListener {
		public void onErrorResponse(VolleyError error){
			Log.e("liujia", error.getMessage(),error);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public static RequestQueue requestQueue;
	public void onCreat(){
		final TextView mTextView = (TextView) findViewById(R.id.text);
		requestQueue= Volley.newRequestQueue(this);
		String url = "ftp://172.17.3.102/FTP_Backup/testResource/";
		StringRequest stringRequest = new StringRequest(Request.Method.GET,url,new ResponseListener(),new ResponseErrorListener());
	}//Volley can not complete the ftp request,only can relise
	
	private FTPClient ftpClient = null;
	private static MainActivity ftpUtilsInstance = null;
	private String ftpUrl = "ftp://172.17.3.102/FTP_Backup/testResource/";
	//private int ftpPort;
	private String userName = "backuper";
	private String userPassword = "nihao123!";
	private final int connectTimeout = 5000;
	private MainActivity(){
		ftpClient = new FTPClient();
	}
	
	public static MainActivity getInstance(){
		if (ftpUtilsInstance ==null) {
			ftpUtilsInstance = new MainActivity();
		}
		Log.d("liujia", "ftpUtilsInstance is :"+ ftpUtilsInstance);
		return ftpUtilsInstance;
	}
	public boolean initFTPSetting(String FTPUrl,String UserName,String UserPassword){
		FTPUrl = ftpUrl;
		//FTPPort = ftpPort;
		UserName = userName;
		UserPassword = userPassword;
		
		int reply;
		try {
			ftpClient.setConnectTimeout(connectTimeout);
			ftpClient.connect(FTPUrl);
			ftpClient.login(UserName, UserPassword);
			reply = ftpClient.getReplyCode();
			Log.d("liujia", "reply code:" + reply);
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				return false;
				//request completed will disconnect to ftp
			}
			return true;
		} catch (SocketException e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}catch (IOException e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}
	
	public boolean downloadFile(String FilePath,String FileName) {
		if (!ftpClient.isConnected()) {
			if (!initFTPSetting(ftpUrl, userName, userPassword)) {
				return false;
			}
		}
		try{
			ftpClient.changeWorkingDirectory("/sdcard/");
			FTPFile[] files = ftpClient.listFiles();
			for (FTPFile file : files) {
				if (file.getName().equals(FileName)) {
					File localFile = new File(FilePath);
					OutputStream outputStream = new FileOutputStream(localFile);
					ftpClient.retrieveFile(file.getName(), outputStream);//download
					outputStream.flush();//clean cache
					outputStream.close();
				}
			}
			ftpClient.logout();
			ftpClient.disconnect();
		}catch (IOException e){
			e.printStackTrace();
		}
		return true;
	}
	
}
