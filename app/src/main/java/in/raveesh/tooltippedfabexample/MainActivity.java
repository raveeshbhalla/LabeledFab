package in.raveesh.tooltippedfabexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import in.raveesh.labeledfab.LabeledFab;

public class MainActivity extends AppCompatActivity {
    boolean shown = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LabeledFab fab = (LabeledFab) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shown = !shown;
                if (shown) {
                    fab.showLabel();
                }
                else{
                    fab.hideLabel();
                }
            }
        });
    }

}
