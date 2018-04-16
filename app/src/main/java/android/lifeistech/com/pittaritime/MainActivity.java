package android.lifeistech.com.pittaritime;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TextView mTimeTextView;
    TextView mResultTextView;

    Timer mTimer;

    Handler mHandler;

    int mTime;
    int mDefaultTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimeTextView = (TextView) findViewById(R.id.mTimeTextView);
        mResultTextView = (TextView) findViewById(R.id.mResultTextView);

        mHandler = new Handler();

        Intent intent = getIntent();
        mDefaultTime = intent.getIntExtra("seconds", 0);
    }

    public void start(View v) {

        if (mTimer == null) {
            Toast.makeText(this, mDefaultTime + "秒当ててね", Toast.LENGTH_SHORT).show();

            mTime = mDefaultTime;
            mTimeTextView.setText(String.valueOf(mTime));
            mTimer = new Timer(false);
            mTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mTime--;
                            Log.d("Timeの数字=", String.valueOf(mTime));
                        }
                    });
                }
            }, 0, 1000);
            //TODO:Timer Taskもインスタンス？でも、インスタンスを参照する変数がないし変だな〜
        }
    }

    public void stop(View v) {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;

            if (mTime == 0) {
                mTimeTextView.setText(String.valueOf(mTime));
                mResultTextView.setText("おめでとう！");
                Intent intent = new Intent(this, CongActivity.class);
                startActivity(intent);

            } else {
                mTimeTextView.setText(String.valueOf(mTime));
                mResultTextView.setText("残念！");
                Intent intent = new Intent(this, GameOverActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        if(mTimer != null){
            mTimer.cancel();
            mTimer = null;
        }
    }

}
