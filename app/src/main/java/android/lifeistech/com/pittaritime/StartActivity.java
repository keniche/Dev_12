package android.lifeistech.com.pittaritime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }
    public void button(View v){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("seconds", 10);
        startActivity(intent);
    }
    public void button1(View v){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("seconds", 5);
        startActivity(intent);
    }
}
