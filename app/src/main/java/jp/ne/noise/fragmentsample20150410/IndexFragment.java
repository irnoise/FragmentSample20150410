package jp.ne.noise.fragmentsample20150410;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mgt on 2015/04/10.
 */

@SuppressLint("NewApi")
public class IndexFragment extends Fragment {
    private String[] index;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        index = new String[12];

        int i = 0;
        for (final String s : index) {
            index[i] = "Index" + (i + 1);
            i++;
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_index, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, index);
        ListView listView = (ListView)rootView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    UIActionListener uiActionListener = (UIActionListener)getActivity();
                    uiActionListener.onIndexSelected(position);
                } else {
                    Intent intent = new Intent(getActivity(), TextActivity.class);
                    intent.putExtra("SELECTED_INDEX", position);
                    startActivity(intent);
                }

            }
        });
        return rootView;
    }

}


