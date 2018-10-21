package com.example.snow.incana.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.alibaba.fastjson.JSON;
import com.example.snow.incana.Bean.UserInfoBeanPublic;
import com.example.snow.incana.Bean.UserInfoResultBean;
import com.example.snow.incana.R;
import com.example.snow.incana.base.BaseFragment;
import com.example.snow.incana.home.fragment.HomeFragment;
import com.example.snow.incana.ordershow.fragment.OrderShowFragment;
import com.example.snow.incana.relase.fragment.RelaseFragment;
import com.example.snow.incana.user.fragment.UserFragment;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {
    @Bind(R.id.frameLayout)
    FrameLayout frameLayout;

    @Bind(R.id.rg_main)
    RadioGroup rgMain;

    private ArrayList<BaseFragment> fragments;

    private int position=0;

    private Fragment tempFragment;

    String text=null;
    private String flag;
    private UserInfoResultBean.ResultBean userinfobean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initFragment();

        initListener();

        /**
         * 开启首页的时候，
         *      判断UserInfoBeanPublic .getFlag();
         *            是否为空，若为空，
         *                  先去用户文件重载用户信息，
         *                  若用户文件为空，则提示用户登录，
         *
         *            用户登录成功后，Flag置为非空
         *            当Flag为非空时则
         */
       // createuserfile();


        flag= UserInfoBeanPublic.getFlag();
        System.out.println("用户的Flag属性为：=="+flag);
        //若用户未登录，flag属性为空。则跳转登陆界面。若不登录也可以继续访问
        if(flag==null||flag==""){

                    startActivity(new Intent(MainActivity.this, UserLoginActivity.class));
        }else{

        }

    }

    
    private void initListener(){
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch(checkedId){
                    case R.id.rb_main:
                        position=0;
                        break;
                    case R.id.rb_relase:
                        position=1;
                        break;
                    case R.id.rb_ordershow:
                        position=2;
                        break;
                    case R.id.rb_user:
                        position=3;
                        break;
                    default:
                        position=0;
                        break;
                }
                BaseFragment baseFragment=getFragment(position);
                switchFragment(tempFragment,baseFragment);
                
            }

            
        });
        //默认选择首页
        rgMain.check(R.id.rb_main);
    }

    private void initFragment(){
        fragments= new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new RelaseFragment());
        fragments.add(new OrderShowFragment());
        fragments.add(new UserFragment());
    }

    private BaseFragment getFragment(int position) {
        if(fragments!=null&&fragments.size()>0){
            BaseFragment baseFragment=fragments.get(position);
            return baseFragment;
        }
        return null;
    }


    /**
     *
     * @param fromFragment
     * @param nextFragment
     *        form 前一个fragment
     *        next 下一个fragment
     *
     */
    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
        if(tempFragment!=nextFragment){
            tempFragment=nextFragment;
            if(nextFragment!=null){
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                //判断nextFragment 是否添加
                if(!nextFragment.isAdded()){
                    //隐藏当前的fragment
                    if(fromFragment!=null){
                        transaction.hide(fromFragment);
                    }
                    //添加Fragment
                    transaction.add(R.id.frameLayout,nextFragment).commit();
                }else{
                    //隐藏当前的fragment
                    if(fromFragment!=null){
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }

    }

    private void createuserfile(){
        try {
            FileOutputStream outstream=this.openFileOutput("userbean.txt", Context.MODE_PRIVATE);
            outstream.close();
            System.out.println("成功创建 userbean.txt文件");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String readeuserfile(){

        try {
            FileInputStream inStream=this.openFileInput("userbean.txt");
            ByteArrayOutputStream stream=new ByteArrayOutputStream();
            byte[] buffer=new byte[1024];
            int length=-1;
            while ((length=inStream.read(buffer))!=-1){
                stream.write(buffer,0,length);

            }
            stream.close();
            inStream.close();
            text=stream.toString();

            UserInfoResultBean resultbeanDate= JSON.parseObject(text,UserInfoResultBean.class);
            userinfobean= resultbeanDate.getResult();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

}
