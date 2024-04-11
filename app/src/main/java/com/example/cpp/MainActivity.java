package com.example.cpp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    // Used to load the 'cpp' library on application startup.
    static {
        System.loadLibrary("app2");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.textView);
        tv.setText(stringFromJNI2());


    }

    /**
     * A native method that is implemented by the 'cpp' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI1();
    public native String stringFromJNI2();
}