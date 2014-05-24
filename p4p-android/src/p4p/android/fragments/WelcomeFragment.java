package p4p.android.fragments;

import info.androidhive.slidingmenu.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class WelcomeFragment extends Fragment {

	public WelcomeFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_welcome, container,
				false);

		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		getActivity().getActionBar().setTitle("Profile for Professors");
		TextView welcome = (TextView) getActivity().findViewById(R.id.welcome);
		welcome.startAnimation(AnimationUtils.loadAnimation(getActivity(),
				R.anim.animate_welcome));
	}
}
