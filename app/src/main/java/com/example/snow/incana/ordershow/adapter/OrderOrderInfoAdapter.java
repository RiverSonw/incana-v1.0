package com.example.snow.incana.ordershow.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.snow.incana.Bean.UserInfoResultBean;
import com.example.snow.incana.R;
import com.example.snow.incana.utils.Constants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $RiverSonw$
 * @updateDes ${TODO}
 */
class OrderOrderInfoAdapter extends BaseAdapter{

    private Context mContext;
    private List<UserInfoResultBean.ResultBean.OrderinofBean> datas;


    public OrderOrderInfoAdapter(Context mContext, List<UserInfoResultBean.ResultBean.OrderinofBean> datas) {
        this.mContext=mContext;
        this.datas=datas;

    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder;
        if(convertView==null){
            convertView= View.inflate(mContext,R.layout.item_order_orderinfo,null);
            viewholder=new ViewHolder();
            viewholder.order_orderinfo_img= (ImageView) convertView.findViewById(R.id.order_orderinfo_img);
            viewholder.order_orderinfo_commname= (TextView) convertView.findViewById(R.id.order_orderinfo_commname);
            viewholder.order_orderinfo_describe= (TextView) convertView.findViewById(R.id.order_orderinfo_describe);
            viewholder.order_orderinfo_losttime= (TextView) convertView.findViewById(R.id.order_orderinfo_losttime);
            viewholder.order_orderinfo_orderstate= (TextView) convertView.findViewById(R.id.order_orderinfo_orderstate);
            viewholder.order_orderinfo_maxprice= (TextView) convertView.findViewById(R.id.order_orderinfo_maxprice);
            viewholder.order_orderinfo_userprice= (TextView) convertView.findViewById(R.id.order_orderinfo_userprice);
            viewholder.order_orderinfo_phone= (TextView) convertView.findViewById(R.id.order_orderinfo_phone);
            convertView.setTag(viewholder);
        }else{
            viewholder= (ViewHolder) convertView.getTag();
        }

        UserInfoResultBean.ResultBean.OrderinofBean orderinfobean=datas.get(position);

        Glide.with(mContext).load(Constants.HOME_AUCTION_IMG+orderinfobean.getPicaddress()).into(viewholder.order_orderinfo_img);
        viewholder.order_orderinfo_commname.setText(orderinfobean.getCommname());
        viewholder.order_orderinfo_describe.setText(orderinfobean.getDescribe());

        Date date=new Date(System.currentTimeMillis());
        long da=date.getTime();
        long dt=Long.valueOf(orderinfobean.getDeadtime())-da;
        if(dt>=0){
            SimpleDateFormat formatter=new SimpleDateFormat("DD"+"天"+"HH"+"小时"+"MM"+"分");
            String times=formatter.format(new Date(dt));
            viewholder.order_orderinfo_losttime.setText("剩余时间："+times);
        }else{
            viewholder.order_orderinfo_losttime.setText("拍卖已经结束");
            if(orderinfobean.getState()==0) {
                viewholder.order_orderinfo_phone.setText("卖家联系电话：" + orderinfobean.getPhone());
                viewholder.order_orderinfo_phone.setVisibility(View.VISIBLE);
            }
        }
        if(orderinfobean.getState()==0){
            viewholder.order_orderinfo_orderstate.setText("您是当前最高竞价者");
        }else{
            viewholder.order_orderinfo_orderstate.setText("有更高的报价者");
        }
        viewholder.order_orderinfo_maxprice.setText("当前的最高价："+orderinfobean.getMaxprice());
        viewholder.order_orderinfo_userprice.setText("您的报价："+orderinfobean.getUserprice());



        return convertView;
    }

    static class ViewHolder{
        private ImageView order_orderinfo_img;
        private TextView order_orderinfo_commname;
        private TextView order_orderinfo_describe;
        private TextView order_orderinfo_losttime;
        private TextView order_orderinfo_orderstate;
        private TextView order_orderinfo_maxprice;
        private TextView order_orderinfo_userprice;
        private TextView order_orderinfo_phone;



    }
}
