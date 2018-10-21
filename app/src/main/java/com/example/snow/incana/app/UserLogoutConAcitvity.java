package com.example.snow.incana.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.snow.incana.Bean.UserInfoBeanPublic;
import com.example.snow.incana.R;

import java.io.FileOutputStream;

/**
 * 用户清空用户信息缓存的页面
 */
public class UserLogoutConAcitvity extends Activity {
    private Context mContext;
    private Button user_logout_sure_button;
    private Button user_logout_no_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_logout_con_acitvity);
        user_logout_sure_button=(Button) findViewById(R.id.user_logout_sure_button);
        user_logout_no_button=(Button) findViewById(R.id.user_logout_no_button);

        /**
         * 确认注销账户后，删除用户缓存数据，
         *                  清空用户文件数据
         */
        user_logout_sure_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // setFileNull();

                UserInfoBeanPublic.setFlag("");
                
                Toast.makeText(UserLogoutConAcitvity.this,"成功注销了用户信息", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(UserLogoutConAcitvity.this,MainActivity.class));
                finish();

            }
        });
        /**
         * 用户取消注销用户，返回MainActivity
         *
         */
        user_logout_no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserLogoutConAcitvity.this,MainActivity.class));
                finish();
            }
        });

    }
    /**
     * 设置文件为空，清空文件缓存信息
     */
    private void setFileNull(){
        try {
            FileOutputStream outstream=this.openFileOutput("userbean.txt", Context.MODE_PRIVATE);
            outstream.write("".getBytes());
            outstream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
