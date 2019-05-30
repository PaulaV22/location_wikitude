package com.example.app3;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.wikitude.architect.ArchitectStartupConfiguration;
import com.wikitude.architect.ArchitectView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import java.io.IOException;

public class SimpleArActivity extends AppCompatActivity {

    private ArchitectView architectView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_ar);
        this.architectView = this.findViewById( R.id.architectView );
        final ArchitectStartupConfiguration config = new ArchitectStartupConfiguration();
        config.setLicenseKey( "3c+5QIkl+0umxX8mhCBe1ByItZDTNGbyt78szjmLnwnYoXBTCwefjggmdxkKGgjsdEbRf6afjddxaTjdNJGdNF5BIj+g45nL4p+KDnF/ZDnbOfmWPUbQyB/p10tqRm/OCB9SIrp+9WreYMKndOE4xCl2ditwQ9InTzmOH9D1mTJTYWx0ZWRfX1t+434gqheVR0m/W/tCcy9PfcJaORbAHFuYR1hknGQiMgbfkhdW9qNu63Ay78Z3Qs3cG2ksUdq943ZjCIC5fpTXgKCjivpTlieC0Fbv77qsySK+dcm4w1Kr5JMsrY/5V6lqhD6Jx5MKMA2yovN6d2CQhMB7jpXKkRbmzwYJBc7NAwfqklkfOrRJgBy21RF52/X+PAJtYqudCsPhHdh46mZGrEa22k2BlRS6Pc6zwqETaesKV556o8KhCWXNAP5s1oZWg3BpAq+sa/KK7xeu2G3c9oTOYKIy2ei3tE7gSEbuEeF0xEr3h7Cit5/X4grMat2yk8lShq6TduEvAC62HNg5/TRzzFU4UtsoYO34htVORD53KTVSKQ5VCMaYmN4Z8AMgI/27Wxl0fIwTkRL6zjOxSM30sFmFK31l4dmnBpXnFZ3/gbCMoyA9EVuQl8znLe2gfd8SpYdeNV5TIUgtNH1IQKs0lgq0PYvg8iPeWSpKVDYMUN9JEfNoYbdVZD0v1SQaD7dJzIfrpShDtmlSk6bOqE/LzDRhgsNKG7bUoaygvMzxVZQWwG3WTY0NuybkR1iMg/DGQL0R" );
        this.architectView.onCreate( config );


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void setLocation(double latitude, double longitude, double altitude){
        architectView.setLocation(latitude, longitude, altitude);
    }


    protected void onPostCreate() {
        this.architectView.onPostCreate();
        try {
            this.architectView.load( "arexperience.html" );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
