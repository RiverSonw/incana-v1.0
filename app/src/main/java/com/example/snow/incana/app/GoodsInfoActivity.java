package com.example.snow.incana.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.snow.incana.Bean.GoodsBean;
import com.example.snow.incana.Bean.UserInfoBeanPublic;
import com.example.snow.incana.Bean.UserInfoResultBean;
import com.example.snow.incana.R;
import com.example.snow.incana.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.sql.Date;
import java.text.SimpleDateFormat;

import okhttp3.Call;

public class GoodsInfoActivity extends Activity implements View.OnClickListener {
    private Context mContext;


    private ImageView ibGoodsInfoBack;
    private ImageButton ibGoodsInfoMore;
    private ImageView ibGoodsInfoImage;
    private TextView ibGoodsInfoName;
    private TextView ibGoodsInfoDescribe;
    private TextView ibGoodsInfoLosttime;
    private TextView ibGoodsInfoStaprice;
    private TextView ibGoodsInfoMaxprice;
    private EditText ibGoodsUserprice;
    private LinearLayout llGoodsRoot;
    private TextView ibGoodsInfoCallcenter;
    private TextView ibGoodsInfoJoinauction;
    private TextView ibGoodsInfoOneprice;

    private GoodsBean goodsBean;

    private long losttime;

    private UserInfoResultBean.ResultBean resultBean;
    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2018-04-13 14:35:33 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */

    private void findViews() {

        ibGoodsInfoBack = (ImageView)findViewById( R.id.ib_goods_info_back );
        ibGoodsInfoMore = (ImageButton)findViewById( R.id.ib_goods_info_more );
        ibGoodsInfoImage = (ImageView)findViewById( R.id.ib_goods_info_image );
        ibGoodsInfoName = (TextView)findViewById( R.id.ib_goods_info_name );
        ibGoodsInfoDescribe = (TextView)findViewById( R.id.ib_goods_info_describe );
        ibGoodsInfoLosttime = (TextView)findViewById( R.id.ib_goods_info_losttime );
        ibGoodsInfoStaprice = (TextView)findViewById( R.id.ib_goods_info_staprice );
        ibGoodsInfoMaxprice = (TextView)findViewById( R.id.ib_goods_info_maxprice );
        ibGoodsUserprice = (EditText)findViewById( R.id.ib_goods_userprice );
        llGoodsRoot = (LinearLayout)findViewById( R.id.ll_goods_root );
        ibGoodsInfoCallcenter = (TextView)findViewById( R.id.ib_goods_info_callcenter );
        ibGoodsInfoJoinauction = (TextView)findViewById( R.id.ib_goods_info_joinauction );
        ibGoodsInfoOneprice=(TextView) findViewById(R.id.ib_goods_info_oneprice);

        ibGoodsInfoMore.setOnClickListener( this );
        ibGoodsInfoJoinauction.setOnClickListener(this);
        ibGoodsInfoCallcenter.setOnClickListener(this);
        ibGoodsInfoBack.setOnClickListener(this);



    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2018-04-13 14:35:33 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if(v==ibGoodsInfoBack){
            //重新开启Activity页面 ，刷新数据
            startActivity(new Intent(GoodsInfoActivity.this,MainActivity.class));
            finish();

        }else if ( v == ibGoodsInfoMore ) {
            // Handle clicks for ibGoodsInfoMore
            Toast.makeText(GoodsInfoActivity.this,"展示更多数据", Toast.LENGTH_SHORT).show();
        }else if(v==ibGoodsInfoJoinauction){
            /**
             * 用户点击参与竞拍的点击事件
             *           1.获取用户的报价金额,用户id,此拍卖的auctionid，以及是否达到一口价的flag
             *                  1.0若用户id和发布者的id相同，则提示不能竞拍自己的拍卖
             *                  1.1若金额为空则toast“金额不能为空”
             *                  1.2金额低于当前最高价toast"竞拍金额必须高于最高价"
             *                  1.3金额超过一口价toast"已超过一口价"
             *                  1.4金额输入正确，进行下一步
             *           2.客户端验证正确后，将数据发送给客户端。
             *                  收到客户端返回的信息后，弹出发布竞拍成功。
             *                  接收新的HomePageJSON  和新的UserJson
             *
             */
            int flag=0;
            float userprice;
            userprice=Float.valueOf(ibGoodsUserprice.getText().toString());
            if(UserInfoBeanPublic.ResultBean.UserinfoBean.getUserid()==goodsBean.getSellid()){
                Toast.makeText(GoodsInfoActivity.this,"自己发布的拍卖，不能自己竞价", Toast.LENGTH_SHORT).show();
            }
            else if(userprice<=0){
                Toast.makeText(GoodsInfoActivity.this,"必须要填写您的竞价", Toast.LENGTH_SHORT).show();
            }else if(userprice<=goodsBean.getMaxprice()||userprice<=goodsBean.getStaprice()){
                System.out.println("用户的报价是："+userprice);
                Toast.makeText(GoodsInfoActivity.this,"竞价必须高于当前的最高价", Toast.LENGTH_SHORT).show();
            }else if(goodsBean.getOneprice()!=0.0&&userprice>goodsBean.getOneprice()){
                System.out.println("用户的报价是："+userprice);
                Toast.makeText(GoodsInfoActivity.this,"竞价不需要高于一口价", Toast.LENGTH_SHORT).show();
            }else{
                if(userprice==goodsBean.getOneprice()){
                    flag=1;
                    //用户报价等于当前一口价
                    //flag=1
                    String url = Constants.USER_JOIN_AUCTION;
                    OkHttpUtils
                            .get()
                            .url(url)
                            .addParams("userid",String.valueOf( UserInfoBeanPublic.ResultBean.UserinfoBean.getUserid()))
                            .addParams("userprice", String.valueOf(userprice))
                            .addParams("auctionid", String.valueOf(goodsBean.getAuctionid()))
                            .addParams("flag", String.valueOf(flag))
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
                                    Toast.makeText(GoodsInfoActivity.this,"竞价失败，请重试", Toast.LENGTH_SHORT).show();

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
                                        Toast.makeText(GoodsInfoActivity.this,"竞价失败", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(GoodsInfoActivity.this,"竞价成功，返回主页", Toast.LENGTH_SHORT).show();
                                        System.out.println(response);
                                        getUserinfo(response);

                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                startActivity(new Intent(GoodsInfoActivity.this,MainActivity.class));
                                                finish();
                                            }
                                        },2000);
                                    }


                                }
                            });
                }else {
                    //用户报价没有达到一口价，或者该商品没有一口价
                    flag=0;
                    String url = Constants.USER_JOIN_AUCTION;
                    OkHttpUtils
                            .get()
                            .url(url)
                            .addParams("userid", String.valueOf(UserInfoBeanPublic.ResultBean.UserinfoBean.getUserid()))
                            .addParams("userprice", String.valueOf(userprice))
                            .addParams("auctionid", String.valueOf(goodsBean.getAuctionid()))
                            .addParams("flag", String.valueOf(flag))
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
                                    Toast.makeText(GoodsInfoActivity.this,"竞价失败，请重试", Toast.LENGTH_SHORT).show();

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
                                    if(!response.equals(0)){
                                        Toast.makeText(GoodsInfoActivity.this,"竞价成功，返回主页", Toast.LENGTH_SHORT).show();
                                        getUserinfo(response);
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                startActivity(new Intent(GoodsInfoActivity.this,MainActivity.class));
                                                finish();
                                            }
                                        },2000);
                                    }else{
                                        Toast.makeText(GoodsInfoActivity.this,"竞拍失败请重试", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }


        }else if(v==ibGoodsInfoCallcenter){
            Toast.makeText(GoodsInfoActivity.this,"联系客服", Toast.LENGTH_SHORT).show();

        }
    }


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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_info);

        findViews();
        //接收数据
        goodsBean=(GoodsBean)getIntent().getSerializableExtra("goodsbean");
        if(goodsBean!=null){
           // Toast.makeText(this,goodsBean.getDescirbe(), Toast.LENGTH_SHORT).show();
            setDateForView(goodsBean);
        }

    }

    /**
     *     设置数据
     * @param goodsbean
     */
    private void setDateForView(GoodsBean goodsbean) {
        System.out.println("图片地址为"+goodsbean.getPicadderss());
        Glide.with(this).load(Constants.HOME_AUCTION_IMG+goodsbean.getPicadderss()).into(ibGoodsInfoImage);

        ibGoodsInfoName.setText(goodsbean.getCommname());

        ibGoodsInfoDescribe.setText(goodsbean.getDescirbe());

        ibGoodsInfoStaprice.setText("起拍价格：￥"+String.valueOf(goodsbean.getStaprice()));
        System.out.println("一口价的价格是："+goodsbean.getOneprice());
        if(goodsbean.getMaxprice()>0) {
            ibGoodsInfoMaxprice.setText("当前最高竞价：￥"+String.valueOf(goodsbean.getMaxprice()));
        }
        if(goodsbean.getOneprice()>0){
            ibGoodsInfoOneprice.setText("一口价：￥"+ String.valueOf(goodsbean.getOneprice()));
        }

        Date da=new Date(System.currentTimeMillis());
        long datenow=da.getTime();
        long datedead=goodsbean.getDeadtime();
        System.out.println("datenow=="+datenow+"    datedead=="+datedead);
        losttime=datedead-datenow;

        handler.sendEmptyMessageDelayed(0,1000);
    }

    private Handler handler=new Handler(){
      @Override
        public void handleMessage(Message msg){
          super.handleMessage(msg);

          losttime=losttime-1000;
          SimpleDateFormat formatter=new SimpleDateFormat("剩余时间"+"DD"+"天"+" HH"+"小时"+"mm"+"分钟"+"ss"+"秒");

          String time=formatter.format(losttime);
          ibGoodsInfoLosttime.setText(time);
          handler.removeMessages(0);
            handler.sendEmptyMessageDelayed(0,1000);
          if(losttime<=0){
              handler.removeCallbacksAndMessages(null);

          }
      }
    };


}
