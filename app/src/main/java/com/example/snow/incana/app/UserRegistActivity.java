package com.example.snow.incana.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.snow.incana.R;
import com.example.snow.incana.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.UnsupportedEncodingException;

import okhttp3.Call;

public class UserRegistActivity extends Activity implements View.OnClickListener{
    private Context mContext;

    private Button user_regist_rebutton;
    private Button user_regist_jplogbutton;
    private EditText user_regist_username;
    private EditText user_regist_password;
    private EditText user_regist_repassword;
    private EditText user_regist_address;
    private EditText user_regist_phone;

    private RadioGroup user_regint_rag;
    private RadioButton user_regist_nan;
    private RadioButton user_regist_nv;


    private String username;
    private String phone;
    private String password;
    private String password2;
    private String address;
    private String sex;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_regist);

        user_regist_rebutton= (Button) findViewById(R.id.user_regist_rebutton);
        user_regist_jplogbutton= (Button) findViewById(R.id.user_regist_jplogbutton);
        user_regist_username= (EditText) findViewById(R.id.user_regist_username);
        user_regist_password= (EditText) findViewById(R.id.user_regist_password);
        user_regist_repassword= (EditText) findViewById(R.id.user_regist_repassword);
        user_regist_address= (EditText) findViewById(R.id.user_regist_address);
        user_regist_phone= (EditText) findViewById(R.id.user_regist_phone);
        user_regint_rag= (RadioGroup) findViewById(R.id.user_regint_rag);
        user_regist_nan= (RadioButton) findViewById(R.id.user_regist_nan);
        user_regist_nv= (RadioButton) findViewById(R.id.user_regist_nv);

        user_regint_rag.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                try {
                if(checkedId==user_regist_nan.getId()){
                    sex=java.net.URLDecoder.decode("男","UTF-8");
                }else if(checkedId==user_regist_nv.getId()){
                    sex=java.net.URLDecoder.decode("女","UTF-8");
                }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }


    @Override
    public void onClick(View v) {
        //用户注册的按钮
            if(v==user_regist_jplogbutton){
                try {
                    username = java.net.URLEncoder.encode(String.valueOf(user_regist_username.getText()),"UTF-8");
                    phone = java.net.URLEncoder.encode(String.valueOf(user_regist_phone.getText()),"UTF-8");
                    password = java.net.URLEncoder.encode(String.valueOf(user_regist_password.getText()),"UTF-8");
                    password2 = java.net.URLEncoder.encode(String.valueOf(user_regist_repassword.getText()),"UTF-8");
                    address = java.net.URLEncoder.encode(String.valueOf(user_regist_address.getText()),"UTF-8");
                }catch(Exception e){
                    e.printStackTrace();
                }
                if(sex==null){
                    try {
                        sex=java.net.URLEncoder.encode("男","UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                if(username==null||username==""||phone==null||phone==""||password==null||password==""||
                        password2==null||password2==""||address==null||address==""){
                    //用户有一项或者一项以上的没有填写
                    System.out.println("获取到的用户注册信息是："+username+phone+password+address+sex);
                    Toast.makeText(UserRegistActivity.this,"带*号的都必须输入", Toast.LENGTH_SHORT).show();
                }else if(!password.equals(password2)){
                    //两次密码不重复
                    Toast.makeText(UserRegistActivity.this,"两次密码必须一样", Toast.LENGTH_SHORT).show();
                }else{
                    String url = Constants.USER_REGITS;
                    OkHttpUtils
                            .get()
                            .url(url)
                            .addParams("phone", phone)
                            .addParams("password", password)
                            .addParams("username", username)
                            .addParams("sex", sex)
                            .addParams("address", address)
                            .build()
                            .execute(new StringCallback()
                            {
                                /**
                                 *
                                 * 当请求失败的时候
                                 * @param call
                                 * @param e
                                 * @param id
                                 */
                                @Override
                                public void onError(Call call, Exception e, int id) {
                                   Toast.makeText(UserRegistActivity.this,"登录失败请重试", Toast.LENGTH_SHORT).show();
                                }
                                /**
                                 * 当联网成功的时候回调
                                 * @param response
                                 *          请求成功获得的数据
                                 *              获取数据成功后，将数据存入userinfo.txt文件
                                 *              并将数据格式化，实例化UserInfoBeanPublic .用于给Fragment传数据
                                 * @param id
                                 */
                                @Override
                                public void onResponse(String response, int id) {
                                    if(response.equals(0)){
                                        Toast.makeText(UserRegistActivity.this,"注册失败请稍后再试", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(UserRegistActivity.this,"注册成功，前去登录", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(UserRegistActivity.this,UserLoginActivity.class));
                                        finish();
                                    }

                                }
                            });

                }


            }else if(v==user_regist_rebutton){
                //用户返回登录的方法
                startActivity(new Intent(UserRegistActivity.this,UserLoginActivity.class));
                finish();
            }
    }



}
