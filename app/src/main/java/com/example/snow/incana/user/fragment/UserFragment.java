package com.example.snow.incana.user.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.snow.incana.Bean.UserInfoBeanPublic;
import com.example.snow.incana.R;
import com.example.snow.incana.app.MainActivity;
import com.example.snow.incana.app.UserLogoutConAcitvity;
import com.example.snow.incana.base.BaseFragment;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $RiverSonw$
 * @updateDes ${TODO}
 */
public class UserFragment extends BaseFragment{

    private ImageView usermaininfoback;
    private ImageButton usermaininfomore;
    private TextView usermainusername;
    private TextView usermainsex;
    private TextView usermainaddress;
    private TextView usermainphone;
    private Button userlogoutbutton;

    @Override
    public View initView() {
        View view=View.inflate(mContext, R.layout.user_main,null);
        usermaininfoback= (ImageView) view.findViewById(R.id.user_main_info_back);
        usermaininfomore= (ImageButton) view.findViewById(R.id.user_main_info_more);
        usermainusername= (TextView) view.findViewById(R.id.user_main_username);
        usermainsex= (TextView) view.findViewById(R.id.user_main_sex);
        usermainaddress= (TextView) view.findViewById(R.id.user_main_address);
        usermainphone= (TextView) view.findViewById(R.id.user_main_phone);
        userlogoutbutton= (Button) view.findViewById(R.id.user_logout_button);


        //若用户未登录就访问用户中心。则直接跳转登陆界面
        if(UserInfoBeanPublic.getFlag()==""||UserInfoBeanPublic.getFlag()==null){
            Intent intent=new Intent(mContext, MainActivity.class);
            mContext.startActivity(intent);
        }

        //initListener();
        return view;

    }

    @Override
    public void initData(){
        super.initData();
        usermainaddress.setText("联系住址："+UserInfoBeanPublic.ResultBean.UserinfoBean.getAddress());
        usermainphone.setText("联系电话："+UserInfoBeanPublic.ResultBean.UserinfoBean.getPhone());
        usermainsex.setText("性别："+UserInfoBeanPublic.ResultBean.UserinfoBean.getSex());
        usermainusername.setText("用户姓名："+UserInfoBeanPublic.ResultBean.UserinfoBean.getUsername());

        userlogoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(mContext,UserLogoutConAcitvity.class);
                mContext.startActivity(intent);

            }
        });

    }

}
