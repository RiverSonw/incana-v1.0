package com.example.snow.incana.user.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.example.snow.incana.Bean.UserInfoBeanPublic;
import com.example.snow.incana.R;
import com.example.snow.incana.app.UserLogoutConAcitvity;


/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $RiverSonw$
 * @updateDes ${TODO}
 */
public class UserFragmentAdapter extends RecyclerView.Adapter {

    public static final int USERINFO=0;

    private int currentType=USERINFO;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public UserFragmentAdapter(Context mContext) {
        this.mContext=mContext;
        mLayoutInflater=LayoutInflater.from(mContext);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==USERINFO){
            return new UserInfoViewHolder(mContext,mLayoutInflater.inflate(R.layout.user_info_view,null));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==USERINFO) {
            UserInfoViewHolder userinfoviewholder= (UserInfoViewHolder) holder;
            userinfoviewholder.setDate();
        }
    }

    /**
     * 用户信息的页面
     */
    class UserInfoViewHolder extends RecyclerView.ViewHolder{
        private Context mContext;
        private TextView usermainusername;
        private TextView usermainsex;
        private TextView usermainaddress;
        private TextView usermainphone;
        private Button userlogoutbutton;

        public UserInfoViewHolder(Context mContext,View itemView) {
            super(itemView);
            this.mContext=mContext;
            usermainusername= (TextView) itemView.findViewById(R.id.user_main_username);
            usermainsex= (TextView) itemView.findViewById(R.id.user_main_sex);
            usermainaddress= (TextView) itemView.findViewById(R.id.user_main_address);
            usermainphone= (TextView) itemView.findViewById(R.id.user_main_phone);

            userlogoutbutton= (Button) itemView.findViewById(R.id.user_logout_button);

        }


        public void setDate() {
            usermainaddress.setText(UserInfoBeanPublic.ResultBean.UserinfoBean.getAddress());
            usermainphone.setText(UserInfoBeanPublic.ResultBean.UserinfoBean.getPhone());
            usermainsex.setText(UserInfoBeanPublic.ResultBean.UserinfoBean.getSex());
            usermainusername.setText(UserInfoBeanPublic.ResultBean.UserinfoBean.getUsername());

            userlogoutbutton.setOnClickListener(new AdapterView.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext,UserLogoutConAcitvity.class);
                    mContext.startActivity(intent);

                }
            });

        }
    }


    @Override
    public int getItemViewType(int position){
        switch(position){
            case USERINFO:
                currentType= USERINFO;
                break;
        }
        return currentType;
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
