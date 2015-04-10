package jp.ne.noise.fragmentsample20150410;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by mgt on 2015/04/10.
 */
@SuppressLint("NewApi")
public class TextFragment extends Fragment {
    private static final String ARG_SELECTED_INDEX = "SELECTED_INDEX";

    private TextView textView;
    private int index;
    private String[] text;

    /**
     * @param index
     * @return TextFragment
     */
    public static TextFragment newInstance(int index) {
        TextFragment textFragment = new TextFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SELECTED_INDEX, index);
        textFragment.setArguments(args);
        return textFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SELECTED_INDEX);
        }
        text = new String[] {
                "一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"
        };
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_text, container, false);
        textView = (TextView)rootView.findViewById(R.id.text_view);
        textView.setText(text[index]);
        return rootView;
    }

}
