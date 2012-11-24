package com.example.wifi.lukasz;

import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class WifiReceiver extends BroadcastReceiver 
{
	private static final String TAG = "WiFiDawaj";
	MainActivity ob1;
	static TextView textView1;
	String text;
	public String getText1()
	{
		return text;
	}
	public WifiReceiver(MainActivity ob1)
	{
		super();
		this.ob1 = ob1;
	}
	
	@Override
	public void onReceive(Context arg0, Intent arg1) 
	{
		List<ScanResult> res = ob1.wifi.getScanResults();
		ScanResult bstResult = null;
		for(ScanResult r : res)
		{
			if( (bstResult == null) || (WifiManager.compareSignalLevel(bstResult.level, r.level) < 0))
			{
				bstResult = r;
			//textView1.append( r.toString());
			}
		}
		String msg = String.format("polaczen znaleziono: %s \n%s jest najsilniejsze \n%sdBm: zasieg", res.size(), bstResult.SSID, bstResult.level);
		
		
		Toast.makeText(ob1, msg, Toast.LENGTH_LONG).show();
		
	}
	
	
	
}
