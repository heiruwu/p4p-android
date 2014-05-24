package p4p.android.fragments;

import info.androidhive.slidingmenu.R;

import java.io.InputStream;
import java.net.Socket;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProfessorsModelFragment extends Fragment {
	Thread client;
	Socket socket;
	String url = "http://prof4prof.info";
	HttpClient httpclient;
	HttpGet getmethod;
	HttpResponse response;
	InputStream is;
	int id;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		String prosjson = getArguments().getString("pros");
		try {
			JSONArray jarray = new JSONArray(prosjson);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_professors,
				container, false);

		return rootView;
	}

}
