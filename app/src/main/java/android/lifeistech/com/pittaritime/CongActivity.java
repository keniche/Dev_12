package android.lifeistech.com.pittaritime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cong);
    }
    public void restart(View v){
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }
}
