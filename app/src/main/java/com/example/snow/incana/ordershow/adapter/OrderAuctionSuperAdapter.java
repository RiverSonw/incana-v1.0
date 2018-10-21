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
 class OrderAuctionSuperAdapter extends BaseAdapter {

    private Context mContext;
    private List<UserInfoResultBean.ResultBean.AuctioninfosuperBean> datas;

    public OrderAuctionSuperAdapter(Context mContext, List<UserInfoResultBean.ResultBean.AuctioninfosuperBean> datas){
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
        ViewHolder viewholder ;
        if(convertView==null){
            convertView= View.inflate(mContext, R.layout.item_order_auctioninfo_super,null);
            viewholder=new ViewHolder();
            viewholder.order_auction_super_img= (ImageView) convertView.findViewById(R.id.order_auction_super_img);
            viewholder.order_auction_super_commname= (TextView) convertView.findViewById(R.id.order_auction_super_commname);
            viewholder.order_auction_super_describe= (TextView) convertView.findViewById(R.id.order_auction_super_describe);
            viewholder.order_auction_super_losttime= (TextView) convertView.findViewById(R.id.order_auction_super_losttime);
            viewholder.order_auction_super_state= (TextView) convertView.findViewById(R.id.order_auction_super_state);
            viewholder.order_auction_super_username= (TextView) convertView.findViewById(R.id.order_auction_super_username);
            viewholder.order_auction_super_maxprice= (TextView) convertView.findViewById(R.id.order_auction_super_maxprice);
            viewholder.order_auction_super_address= (TextView) convertView.findViewById(R.id.order_auction_super_address);

            convertView.setTag(viewholder);
        }else{
            viewholder= (ViewHolder) convertView.getTag();
        }
        UserInfoResultBean.ResultBean.AuctioninfosuperBean auctionsuperbean=datas.get(position);

        Glide.with(mContext).load(Constants.HOME_AUCTION_IMG+auctionsuperbean.getPicaddress()).into(viewholder.order_auction_super_img);
        viewholder.order_auction_super_commname.setText(auctionsuperbean.getCommname());
        viewholder.order_auction_super_describe.setText(auctionsuperbean.getDescribe());

        Date date=new Date(System.currentTimeMillis());
        long da=date.getTime();
        long dt=Long.valueOf(auctionsuperbean.getDeadtime())-da;
        if(dt>=0){
            SimpleDateFormat formatter=new SimpleDateFormat("DD"+"天"+"HH"+"小时"+"MM"+"分");
            String times=formatter.format(new Date(dt));
            viewholder.order_auction_super_losttime.setText("剩余时间："+times);
        }else{
            viewholder.order_auction_super_losttime.setText("拍卖已经结束，获得报价");
        }

        if(auctionsuperbean.getState()==1){
            viewholder.order_auction_super_state.setText("已经获得报价");
        }else{
            viewholder.order_auction_super_state.setText("拍卖结束");
        }
        viewholder.order_auction_super_username.setText("竞价人"+auctionsuperbean.getUsername());

        viewholder.order_auction_super_maxprice.setText("最高竞价"+auctionsuperbean.getMaxprice());

        viewholder.order_auction_super_address.setText("电话："+auctionsuperbean.getPhone()+",地址："+auctionsuperbean.getAddress());

        return convertView;
    }
    static class ViewHolder{
        private ImageView order_auction_super_img;
        private TextView order_auction_super_commname;
        private  TextView order_auction_super_describe;
        private  TextView order_auction_super_losttime;
        private TextView order_auction_super_state;
        private  TextView order_auction_super_username;
        private TextView order_auction_super_maxprice;
        private TextView order_auction_super_address;



    }
}
