package com.example.snow.incana.home.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.snow.incana.R;
import com.example.snow.incana.base.BaseFragment;
import com.example.snow.incana.home.adapter.HomeFragmentAdapter;
import com.example.snow.incana.home.bean.HomeAuctionDataBean;
import com.example.snow.incana.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.UnsupportedEncodingException;

import okhttp3.Call;


/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $RiverSonw$
 * @updateDes ${TODO}
 *      当前的数据更新靠MainActivity的重载实现
 *           需要下来后将页面数据刷新的功能
 */
public class HomeFragment extends BaseFragment {
    private static final String TAG=HomeFragment.class.getSimpleName();
    private RecyclerView rvHome;
    private ImageView ib_top;

    //暂时把查询的EditView 设置为textView
    private TextView tv_message_home;

    private TextView tv_search_home;

    private HomeAuctionDataBean.ResultBean resultBean;

    private HomeFragmentAdapter adapter;

    @Override
    public View initView() {
        Log.e(TAG,"主页面的Fragment被初始化了");
        View view=View.inflate(mContext, R.layout.fragment_home,null);
        rvHome=(RecyclerView) view.findViewById(R.id.rv_home);
        ib_top= (ImageView) view.findViewById(R.id.ib_top);

        tv_message_home= (TextView) view.findViewById(R.id.tv_message_home);
        tv_search_home= (TextView) view.findViewById(R.id.tv_search_home);

        initListener();
        return view;
    }

    @Override
    public void initData(){
        super.initData();

        Log.e(TAG,"主页面的Fragment的UI被初始化了");

        getDataFromNet();
    }

    private void getDataFromNet() {
        String url = Constants.HOME_URL;
        OkHttpUtils
                .get()
                .url(url)
                //.addParams("username", "hyman")
                //.addParams("password", "123")
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
                        Log.e(TAG,"首页请求失败=="+e.getMessage());
                        //解析数据
                    }
                    /**
                     * 当联网成功的时候回调
                     * @param response
                     *          请求成功的数据
                     * @param id
                     */
                    @Override
                    public void onResponse(String response, int id) {
                        Log.e(TAG,"首页数据请求成功=="+response);
                        //解析数据
                        try {
                            processData(java.net.URLDecoder.decode(response,"UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    /**
     *
     * @param json
     *          将获取的json文件格式化。
     */
    private void processData(String json) {

        HomeAuctionDataBean resultBeanData= JSON.parseObject(json,HomeAuctionDataBean.class);
        resultBean=resultBeanData.getResult();

        if(resultBean!=null){

            adapter=new HomeFragmentAdapter(mContext,resultBean);
            rvHome.setAdapter(adapter);


            GridLayoutManager manager=new GridLayoutManager(mContext,1);
            //设置跨度大小的监听
            manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
                @Override
                public int getSpanSize(int position){
                    if(position<=3){
                        //隐藏
                        ib_top.setVisibility(View.GONE);
                    }else{
                        //显示
                        ib_top.setVisibility(View.VISIBLE);
                    }
                    //只能回到第一个节点
                    return 1;
                }
            });
            //设置布局管理者 表格的布局
            rvHome.setLayoutManager(manager);
        }else{
            System.out.println("没有接受到数据");
            Toast.makeText(mContext,"链接网络失败没有获取到数据", Toast.LENGTH_SHORT).show();
            //没有数据的方法
        }
    }

//设置点击事件·
    public void initListener(){
        ib_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvHome.scrollToPosition(0);
            }
        });
        tv_search_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"搜索的方法", Toast.LENGTH_SHORT).show();
            }
        });

        tv_message_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"进入消息中心", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
