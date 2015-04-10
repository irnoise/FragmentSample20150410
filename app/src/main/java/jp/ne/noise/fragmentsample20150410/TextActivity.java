package jp.ne.noise.fragmentsample20150410;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by mgt on 2015/04/10.
 */
public class TextActivity extends ActionBarActivity {

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            getFragmentManager().beginTransaction()
                    .add(R.id.container, TextFragment.newInstance(extras.getInt("SELECTED_INDEX")))
                    .commit();
        }
    }
}
