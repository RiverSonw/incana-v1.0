package com.example.snow.incana.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.snow.incana.R;
import com.example.snow.incana.home.bean.HomeAuctionDataBean;
import com.example.snow.incana.utils.Constants;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $RiverSonw$
 * @updateDes ${TODO}
 */
class RecommendGridViewAdapter extends BaseAdapter{
    private Context mContext;
    private List<HomeAuctionDataBean.ResultBean.HomePageAuctionBean> datas;

    public RecommendGridViewAdapter(Context mContext,List<HomeAuctionDataBean.ResultBean.HomePageAuctionBean> datas){
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
            convertView=View.inflate(mContext, R.layout.item_recommend_grid_view,null);
            viewholder=new ViewHolder();
            viewholder.iv_recommend= (ImageView) convertView.findViewById(R.id.iv_recommend);
            viewholder.tv_name= (TextView) convertView.findViewById(R.id.tv_name);
            viewholder.tv_price= (TextView) convertView.findViewById(R.id.tv_price);
            viewholder.re_losttime_text= (TextView) convertView.findViewById(R.id.re_losttime_text);
            convertView.setTag(viewholder);
        }else {
            viewholder= (ViewHolder) convertView.getTag();

        }

        HomeAuctionDataBean.ResultBean.HomePageAuctionBean recommendInfoBean=datas.get(position);
        //放置数据
        Glide.with(mContext).load(Constants.HOME_AUCTION_IMG+recommendInfoBean.getPicaddress()).into(viewholder.iv_recommend);
        viewholder.tv_price.setText(String.valueOf(recommendInfoBean.getStaprice()));
        viewholder.tv_name.setText(recommendInfoBean.getCommname());

        Date date=new Date(System.currentTimeMillis());
        long da=date.getTime();
        long dt=Long.valueOf(recommendInfoBean.getDeadtime())-da;
        SimpleDateFormat formatter=new SimpleDateFormat("DD"+"天"+"HH"+"小时"+"mm"+"分");
        String times=formatter.format(new Date(dt));
        viewholder.re_losttime_text.setText(times);


        return convertView;
    }

    static class ViewHolder{
        ImageView iv_recommend;
        TextView tv_name;
        TextView tv_price;
        TextView re_losttime_text;

    }


}
