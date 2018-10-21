package com.example.snow.incana.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.snow.incana.R;

/**
 * 此Activity
 *          只用于提示信息。并返回到MainActivity
 *
 */
public class MSGActivity extends Activity {
    private Button msg_back_activity_button;
    private TextView msg_text;
    private TextView msg_time;
    private int time=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);

        msg_back_activity_button= (Button) findViewById(R.id.msg_back_activity_button);
        msg_text=(TextView) findViewById(R.id.msg_text);
        msg_time=(TextView) findViewById(R.id.msg_time);

        handler.sendEmptyMessageDelayed(0,1000);
        initListener();
    }

    private void initListener(){
        msg_back_activity_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MSGActivity.this,MainActivity.class));
                finish();
            }
        });
    }

    /**
     * 倒计时后，返回主页面
     */
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);

            time=time-1;

            msg_time.setText(time+"秒后返回主页面");
            handler.removeMessages(0);
            handler.sendEmptyMessageDelayed(0,1000);
            if(time<=0){
                handler.removeCallbacksAndMessages(null);
                startActivity(new Intent(MSGActivity.this,MainActivity.class));
                finish();
            }
        }
    };
}
