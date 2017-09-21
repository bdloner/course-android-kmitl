package kmitl.lab05.bdloner.simplemydot.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kmitl.lab05.bdloner.simplemydot.R;

/**
 * A simple {@link Fragment} subclass.
 */


public class ViewFragment extends Fragment {

    public ViewFragment() {

    }

    public static ViewFragment newInstance(){
        Bundle args = new Bundle();

        ViewFragment fragment = new ViewFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view, container, false);
    }
}
