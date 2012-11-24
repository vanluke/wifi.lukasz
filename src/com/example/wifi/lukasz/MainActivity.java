package com.example.wifi.lukasz;

import java.util.List;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.view.View.OnClickListener;
public class MainActivity extends Activity implements OnClickListener{
	
	private static final String TAG = "TestLukasz";
	WifiManager wifi;
	Button Glutton; Button exit;
	BroadcastReceiver receiver;
	public TextView textWifi;
	public TextView polecenie;
	public TextView getText()
	{
		return textWifi;
	}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        textWifi = (TextView) findViewById(R.id.textWifi);
        polecenie = (TextView)findViewById(R.id.Polecenie);
        //Glutton = (Button) findViewById(R.id.Glutton);
		//Glutton.setOnClickListener(this);
        Button btn1 = (Button) findViewById(R.id.exit);
	    btn1.setOnClickListener(new OnClickListener() {

	        public void onClick(View v) {
	            finish();
	            System.exit(0);
	        }
	    });
        // Ustwienie wifi tzn pobranie danych z czujnika wifi
        wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        //pobranie statusu wifi
        WifiInfo info = wifi.getConnectionInfo();
        //polecenie.append("\nTu powienie byæ tekst " + WifiReceiver.textView1.getText().toString());
        textWifi.append("To jest program £ukasza testowy");
        if(receiver == null)
        {
        	receiver = new WifiReceiver(this);
        }
        registerReceiver(receiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
    }
    @Override
    public void onStop()
    {
    	unregisterReceiver(receiver);
    }
    public void onClick(View view)
    {
    	Toast.makeText(this, "Kliknij", Toast.LENGTH_LONG).show();
    	//przyda³ by sie jakis if(), ale narazie bêdzie tak
    	//if (view.getId() == R.id.Glutton) 
    	//{
    		Log.d(TAG, "onClick() wifi.startScan()");
    		wifi.startScan();
    	//}
    		
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
