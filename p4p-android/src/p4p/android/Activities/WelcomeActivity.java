package p4p.android.Activities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

import info.androidhive.slidingmenu.MainActivity;
import info.androidhive.slidingmenu.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class WelcomeActivity extends Activity {
	HttpClient httpclient;
	HttpGet getmethod;
	String Depturl = "http://api.prof4prof.info/depts";
	HttpResponse response;
	String [] prodept;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		Timer timer = new Timer(true);
		timer.schedule(new timerTask(), 3000, 2000);
	}

	public class timerTask extends TimerTask {

		public void run() {

			httpclient = new DefaultHttpClient();
			getmethod = new HttpGet(Depturl);
			try {
				response = httpclient.execute(getmethod);
				Log.w("client", "Get Request");
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(
								response.getEntity().getContent(), "UTF-8"));
				String json = reader.readLine();
				JSONArray jarray = new JSONArray(json);
				for (int i = 0; i < jarray.length(); i++) {
					prodept[i] = jarray.getJSONObject(i).getString("name");
					Log.w("string", prodept[i]);
				}
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Toast.makeText(getApplication(),
								"ClientProtocol error", Toast.LENGTH_SHORT)
								.show();
					}
				});
				e.printStackTrace();
			} catch (IOException e) {
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Toast.makeText(getApplication(), "IO error",
								Toast.LENGTH_SHORT).show();
					}
				});
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Toast.makeText(getApplication(), "JSON error",
								Toast.LENGTH_SHORT).show();
					}
				});
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Intent it = new Intent();
			it.putExtra("depts", prodept);
			it.setClass(WelcomeActivity.this, MainActivity.class);
			startActivity(it);
			this.cancel();
			WelcomeActivity.this.finish();
		}
	}

}
