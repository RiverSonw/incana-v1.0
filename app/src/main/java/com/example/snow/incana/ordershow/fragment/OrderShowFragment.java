package com.example.snow.incana.ordershow.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.snow.incana.Bean.UserInfoBeanPublic;
import com.example.snow.incana.Bean.UserInfoResultBean;
import com.example.snow.incana.R;
import com.example.snow.incana.app.MainActivity;
import com.example.snow.incana.base.BaseFragment;
import com.example.snow.incana.ordershow.adapter.OrderFragmentAdapter;
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
 *          若用户未登录就访问此Fragment 则提示用户登录
 *              分三个模块显示用户
 *                      1.已经发布的拍卖
 *                      2.已经获得报价的拍卖
 *                      3.自己参与的竞拍
 *
 */
public class OrderShowFragment extends BaseFragment {
    private RecyclerView orderhome;
    private ImageButton ib_goods_info_more;
    private ImageView ibgoodsinfoback;

    private OrderFragmentAdapter adapter;

    private UserInfoResultBean.ResultBean resultbean;
    @Override
    public View initView() {
        View view=View.inflate(mContext, R.layout.order_info,null);
        orderhome=(RecyclerView) view.findViewById(R.id.order_home);
        ibgoodsinfoback= (ImageView) view.findViewById(R.id.ib_goods_info_back);



        initListener();
        return view;
    }

    @Override
    public void initData(){
        super.initData();
        if(UserInfoBeanPublic.getFlag()==""||UserInfoBeanPublic.getFlag()==null){
            Intent intent=new Intent(mContext, MainActivity.class);
            mContext.startActivity(intent);

        }else{
            getDataFromNet();
        }

    }

    private void getDataFromNet() {
        String url = Constants.USER_LOGIN_SERVLET;
        OkHttpUtils
                .get()
                .url(url)
                .addParams("phone", UserInfoBeanPublic.ResultBean.UserinfoBean.getPhone())
                .addParams("password", UserInfoBeanPublic.ResultBean.UserinfoBean.getPassword())
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
                        Toast.makeText(mContext,"获取数据失败，请重试", Toast.LENGTH_SHORT).show();

                    }
                    /**
                     * 当联网成功的时候回调
                     * @param response
                     *          请求成功的数据
                     * @param id
                     */
                    @Override
                    public void onResponse(String response, int id) {


                        processData(response);
                        System.out.println("获取到了用户的全部数据"+response);
                    }
                });
    }

private void processData(String response){
        UserInfoResultBean resultbeanData= JSON.parseObject(response,UserInfoResultBean.class);
        resultbean=resultbeanData.getResult();
        adapter=new OrderFragmentAdapter(mContext,resultbean);

        orderhome.setAdapter(adapter);
        GridLayoutManager manager=new GridLayoutManager(mContext,1);
        orderhome.setLayoutManager(manager);

        System.out.println("调用了OrderFragmentAdapter的回调方法");
}
    public void initListener(){
        ibgoodsinfoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(mContext,"返回主页", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
