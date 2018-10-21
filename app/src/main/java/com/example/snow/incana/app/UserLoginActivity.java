package com.example.snow.incana.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.snow.incana.Bean.UserInfoBeanPublic;
import com.example.snow.incana.Bean.UserInfoResultBean;
import com.example.snow.incana.R;
import com.example.snow.incana.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $RiverSonw$
 * @updateDes ${TODO}
 *          用户登录的页面
 *                  在用户首次使用该客户端时，首先启动，提示登录或注册
 *                      用户在注销后也提示
 *                      用户想要发布拍卖时提示
 *                      用户想要参与竞拍时提示
 *                      用户想要查看个人订单中心时提示登录
 *
 */
public class UserLoginActivity extends Activity implements View.OnClickListener{

    private ImageView userloginback;
    private ImageButton ib_goods_info_more;
    private Button userloginloginbutton;
    private TextView userloginmsg;
    private EditText userloginuserphone;
    private  EditText userloginpassword;
    private TextView userloginsuccess;
    private TextView userloginfaild;
    private Button userloginregistbutton;


    private UserInfoResultBean.ResultBean resultBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);
        userloginback=(ImageView) findViewById(R.id.user_login_back);
        userloginloginbutton= (Button) findViewById(R.id.user_login_login_button);
        userloginmsg=(TextView) findViewById(R.id.user_login_msg);
        userloginuserphone= (EditText) findViewById(R.id.user_login_userphone);
        userloginpassword=( EditText) findViewById(R.id.user_login_password);
        userloginsuccess=(TextView) findViewById(R.id.user_login_success);
        userloginfaild=(TextView)findViewById(R.id.user_login_faild);
        userloginregistbutton=(Button) findViewById(R.id.user_login_regist_button);

    }



    @Override
    public void onClick(View v) {
        if(v==userloginback){
            startActivity(new Intent(UserLoginActivity.this,MainActivity.class));
            finish();
        }else if(v==userloginloginbutton){


            String phone=userloginuserphone.getText().toString();
            String password=userloginpassword.getText().toString();

            if(phone==null||phone==""||password==""||password==null){
                Toast.makeText(UserLoginActivity.this,"用户名或密码不存在请重新输入", Toast.LENGTH_SHORT).show();
            }else {
                getDataFromNet(phone, password);
            }
        }else if(v==userloginregistbutton){
            startActivity(new Intent(UserLoginActivity.this,UserRegistActivity.class));
            finish();
        }

    }

    private void getDataFromNet(String phone ,String password) {
        String url = Constants.USER_LOGIN_SERVLET;
        OkHttpUtils
                .get()
                .url(url)
                .addParams("phone", phone)
                .addParams("password", password)
                .build()
                .execute(new StringCallback()
                {
                    /**
                     * 当请求失败的时候
                     * @param call
                     * @param e
                     * @param id
                     */
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        userloginfaild.setVisibility(View.GONE);
                        Toast.makeText(UserLoginActivity.this,"登录失败请重试", Toast.LENGTH_SHORT).show();
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
                        System.out.println(response);

                        if(response=="1"){
                            Toast.makeText(UserLoginActivity.this,"登录失败请重试", Toast.LENGTH_SHORT).show();
                        }else if(response=="0"){
                            Toast.makeText(UserLoginActivity.this,"用户名不存在", Toast.LENGTH_SHORT).show();
                        }else{
                            getUserinfo(response);

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(UserLoginActivity.this,"登录成功", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(UserLoginActivity.this,MainActivity.class));
                                    finish();
                                }
                            },1000);
                        }


                    }
                });
    }

    /**
     *
     * @param response
     *      将数据写入文件中
     */
    private void getUserinfo(String response) {


        System.out.println("获取到了用户的信息=="+response);

        UserInfoResultBean userinfoBean= JSON.parseObject(response,UserInfoResultBean.class);
        resultBean=userinfoBean.getResult();

        UserInfoBeanPublic.ResultBean.UserinfoBean.setUsername(resultBean.getUserinfo().getUsername());
        UserInfoBeanPublic.ResultBean.UserinfoBean.setPhone(resultBean.getUserinfo().getPhone());
        UserInfoBeanPublic.ResultBean.UserinfoBean.setSex(resultBean.getUserinfo().getSex());
        UserInfoBeanPublic.ResultBean.UserinfoBean.setAddress(resultBean.getUserinfo().getAddress());
        UserInfoBeanPublic.ResultBean.UserinfoBean.setPassword(resultBean.getUserinfo().getPassword());
        UserInfoBeanPublic.ResultBean.UserinfoBean.setUserid(resultBean.getUserinfo().getUserid());


        UserInfoBeanPublic.setFlag("2");

    }





}
