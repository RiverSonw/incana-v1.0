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
class OrderAuctionAdapter extends BaseAdapter {

    private Context mContext;

    private List<UserInfoResultBean.ResultBean.AuctioninfoBean> datas;


    public OrderAuctionAdapter(Context mContext,List<UserInfoResultBean.ResultBean.AuctioninfoBean> datas){
        this.mContext=mContext;
        this.datas=datas;
        System.out.println("获取到了几条数据："+datas.size());

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
            convertView= View.inflate(mContext, R.layout.item_order_auction,null);
            viewholder=new ViewHolder();
            viewholder.order_auctioninfo_img= (ImageView) convertView.findViewById(R.id.order_auctioninfo_img);
            viewholder.order_auctioninfo_commname= (TextView) convertView.findViewById(R.id.order_auctioninfo_commname);
            viewholder.order_auctioninfo_describe= (TextView) convertView.findViewById(R.id.order_auctioninfo_describe);
            viewholder.order_auctioninfo_losttime= (TextView) convertView.findViewById(R.id.order_auctioninfo_losttime);
            viewholder.order_auctioninfo_auctionstate= (TextView) convertView.findViewById(R.id.order_auctioninfo_auctionstate);
            viewholder.order_auctioninfo_staprice= (TextView) convertView.findViewById(R.id.order_auctioninfo_staprice);
            viewholder.order_auctioninfo_oneprice= (TextView) convertView.findViewById(R.id.order_auctioninfo_oneprice);

            convertView.setTag(viewholder);
        }else{
            viewholder= (ViewHolder) convertView.getTag();
        }
        UserInfoResultBean.ResultBean.AuctioninfoBean auctioninfobean=datas.get(position);

        Glide.with(mContext).load(Constants.HOME_AUCTION_IMG+auctioninfobean.getPicaddress()).into(viewholder.order_auctioninfo_img);
        viewholder.order_auctioninfo_commname.setText(auctioninfobean.getCommname());
        if(auctioninfobean.getState()==0){
            viewholder.order_auctioninfo_auctionstate.setText("正在拍卖");
        }else if(auctioninfobean.getState()==1){
            viewholder.order_auctioninfo_auctionstate.setText("获得竞价");
        }else{
            viewholder.order_auctioninfo_auctionstate.setText("已经流拍");
        }
        viewholder.order_auctioninfo_describe.setText(auctioninfobean.getDescribe());
        if(auctioninfobean.getOneprice()==0){
            viewholder.order_auctioninfo_oneprice.setVisibility(View.GONE);
        }else {
            viewholder.order_auctioninfo_oneprice.setText("一口价￥：" + auctioninfobean.getOneprice());
            viewholder.order_auctioninfo_oneprice.setVisibility(View.VISIBLE);
        }
        viewholder.order_auctioninfo_staprice.setText("起拍价￥："+auctioninfobean.getStaprice());


        Date date=new Date(System.currentTimeMillis());
        long da=date.getTime();
        long dt=Long.valueOf(auctioninfobean.getDeadtime())-da;
        if(dt>=0){
            SimpleDateFormat formatter=new SimpleDateFormat("DD"+"天"+"HH"+"小时"+"MM"+"分");
            String times=formatter.format(new Date(dt));
            viewholder.order_auctioninfo_losttime.setText("剩余时间："+times);
        }else{
            viewholder.order_auctioninfo_losttime.setText("拍卖已经结束，流拍");
        }


        return convertView;
    }

    static class ViewHolder{
        ImageView order_auctioninfo_img;
        TextView order_auctioninfo_commname;
        TextView order_auctioninfo_describe;
        TextView order_auctioninfo_losttime;
        TextView order_auctioninfo_auctionstate;
        TextView order_auctioninfo_staprice;
        TextView order_auctioninfo_oneprice;

    }
}
