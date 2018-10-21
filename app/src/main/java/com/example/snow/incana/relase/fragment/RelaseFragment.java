package com.example.snow.incana.relase.fragment;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.snow.incana.Bean.UserInfoBeanPublic;
import com.example.snow.incana.R;
import com.example.snow.incana.app.MSGActivity;
import com.example.snow.incana.base.BaseFragment;
import com.example.snow.incana.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.sql.Date;
import java.util.Calendar;

import okhttp3.Call;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $RiverSonw$
 * @updateDes ${TODO}
 */
public class RelaseFragment extends BaseFragment implements View.OnClickListener{
    private EditText re_auction_name;
    private EditText re_auction_staprice;
    private EditText re_auction_deadtime;
    private EditText re_auction_label;
    private EditText re_auction_describe;
    private EditText re_auction_oneprice;
    private Button re_auciton_button;

    private TextView textView_tixing2;

    private Calendar calendar; // 通过Calendar获取系统时间
    private int mYear;
    private int mMonth;
    private int mDay;

    private String commname;
    private String staprice;

    private String label;
    private String describe;
    private String oneprice;
    private String userid;
    private String picaddress;
    private String deadtime;

    private Date da;
    private String deadtime_second;
    private long datenow;
    private long deadtime2;
    private String datetimenow;

    @Override
    public View initView() {
        View view=View.inflate(mContext, R.layout.relase_auction,null);
        re_auction_name= (EditText) view.findViewById(R.id.re_auction_name);
        re_auction_staprice= (EditText) view.findViewById(R.id.re_auction_staprice);
        re_auction_deadtime= (EditText) view.findViewById(R.id.re_auction_deadtime);
        re_auction_label= (EditText) view.findViewById(R.id.re_auction_label);
        re_auction_describe= (EditText) view.findViewById(R.id.re_auction_describe);
        re_auction_oneprice= (EditText) view.findViewById(R.id.re_auction_oneprice);
        re_auciton_button= (Button) view.findViewById(R.id.re_auciton_button);

        textView_tixing2= (TextView) view.findViewById(R.id.textView_tixing2);

        calendar = Calendar.getInstance();

        re_auciton_button.setOnClickListener(this);
        re_auction_deadtime.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View v) {
        if(v==re_auciton_button) {
            try {
                commname =java.net.URLEncoder.encode( re_auction_name.getText().toString(),"UTF-8");
                staprice = re_auction_staprice.getText().toString();
                deadtime = re_auction_deadtime.getText().toString();
                label = java.net.URLEncoder.encode(re_auction_label.getText().toString(),"UTF-8");
                describe = java.net.URLEncoder.encode(String.valueOf(re_auction_describe.getText().toString()),"UTF-8");
                oneprice = re_auction_oneprice.getText().toString();
                userid = String.valueOf(UserInfoBeanPublic.ResultBean.UserinfoBean.getUserid());
                //暂时没有图片地址，放一张默认图
                picaddress =java.net.URLEncoder.encode("new_img_loading_2.png","UTF-8");

            }catch(Exception e){
                e.printStackTrace();
            }


            da=new Date(System.currentTimeMillis());
            datenow=da.getTime();
            datetimenow=String.valueOf(datenow);
            deadtime2=(Integer.valueOf(deadtime)-1)*24*60*60*1000;

            deadtime_second=String.valueOf(datenow+deadtime2);
            /**
             * 判断输入时间是否正确
             *          若时间为空   直接提交给服务器。让服务器设置拍卖时间
             *          若输入时间小于当前时间
             *          输入正确
             */
            if(!oneprice.equals("")&&Integer.valueOf(oneprice)<=Integer.valueOf(staprice)){
                Toast.makeText(mContext,"一口价必须大于起拍价", Toast.LENGTH_SHORT).show();
            }else if(deadtime=="0"){
                Toast.makeText(mContext,"拍卖时间必须大于一天", Toast.LENGTH_SHORT).show();
            }
            else if(deadtime==""||deadtime==null){
                Toast.makeText(mContext,"没有获取到时间", Toast.LENGTH_SHORT).show();
                deadtime_second=String.valueOf(deadtime2+20*24*60*60);
            }
            else if(commname==null||commname==""||staprice==null||staprice==""||label==null||label==""||describe==null||describe==""){
                //当带*的数据未填写时：
                textView_tixing2.setVisibility(View.VISIBLE);
                Toast.makeText(mContext,"带*号的数据必须填写", Toast.LENGTH_SHORT).show();
            }else{

                String url = Constants.USER_RELASE_AUCTION;
                OkHttpUtils
                        .get()
                        .url(url)
                        .addParams("commname", commname)
                        .addParams("describes", describe)
                        .addParams("deadtime", deadtime_second)
                        .addParams("staprice", staprice)
                        .addParams("sellid", userid)
                        .addParams("oneprice", oneprice)
                        .addParams("picaddress", picaddress)
                        .addParams("label", label)
                        .addParams("statime",datetimenow)

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
                                Toast.makeText(mContext,"拍卖发布失败，请重试", Toast.LENGTH_SHORT).show();
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

                                if(response=="0"){
                                    Toast.makeText(mContext,"项目发布失败，请重试", Toast.LENGTH_SHORT).show();

                                }else {
                                    System.out.println(response);
                                    Toast.makeText(mContext,"拍卖发布成功，返回主页面", Toast.LENGTH_SHORT).show();


                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            startActivity(new Intent(mContext, MSGActivity.class));
                                        }
                                    }, 2000);
                                }
                            }
                        });

            }

        }

    }
}
