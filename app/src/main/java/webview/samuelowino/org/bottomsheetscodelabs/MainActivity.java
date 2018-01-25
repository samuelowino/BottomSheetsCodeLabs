package webview.samuelowino.org.bottomsheetscodelabs;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button;
    BottomSheetBehavior behavior;
    NestedScrollView nestedScrollView;
    Toolbar toolbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button1);
        toolbar = findViewById(R.id.bottom_sheets_toolbar);
        setSupportActionBar(toolbar);
        textView = findViewById(R.id.textview1);

        nestedScrollView = findViewById(R.id.nested_scroll_view);
        behavior = BottomSheetBehavior.from(nestedScrollView);

        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED){
                    textView.setText("Greate Job");
                }

                if (newState == BottomSheetBehavior.STATE_EXPANDED){
                    textView.setText("You can Swipe down to close me");
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
        }
    }
}
