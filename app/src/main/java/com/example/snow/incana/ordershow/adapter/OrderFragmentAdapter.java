package com.example.snow.incana.ordershow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.snow.incana.Bean.UserInfoResultBean;
import com.example.snow.incana.R;

import java.util.List;


/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $RiverSonw$
 * @updateDes ${TODO}
 */
public class OrderFragmentAdapter extends RecyclerView.Adapter{

    private Context mContext;

    public static final int AUCTION=0;

    public static final int AUCTIONSUPER=1;

    public static final int ORDER=2;

    private int  currenType=AUCTION;

    private LayoutInflater mLayoutInflater;

    private UserInfoResultBean.ResultBean resultbean;

    public OrderFragmentAdapter(Context mContext, UserInfoResultBean.ResultBean resultbean){
        this.mContext=mContext;
        mLayoutInflater=LayoutInflater.from(mContext);
        this.resultbean=resultbean;
        System.out.println("OrderFragmentAdapter  调用");

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==AUCTION){
            System.out.println("回调了AUCTION的方法");
            return new OrderAuctionViewHolder(mContext,mLayoutInflater.inflate(R.layout.order_auctioninfo_item,null));
        }else if(viewType==AUCTIONSUPER){
            return new OrderAuctionSuperViewHolder(mContext,mLayoutInflater.inflate(R.layout.order_auctioninfo_super_item,null));
        }else if(viewType==ORDER){
            return new OrderOrderInfoViewHolder(mContext,mLayoutInflater.inflate(R.layout.order_orderinfo_item,null));
        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==AUCTION){
            OrderAuctionViewHolder auctionviewholder= (OrderAuctionViewHolder) holder;
            auctionviewholder.setData(resultbean.getAuctioninfo());
        }else if(getItemViewType(position)==AUCTIONSUPER){
            OrderAuctionSuperViewHolder auctionsuperviewholder= (OrderAuctionSuperViewHolder) holder;
            auctionsuperviewholder.setData(resultbean.getAuctioninfosuper());
        }else if(getItemViewType(position)==ORDER){
            OrderOrderInfoViewHolder orderviewholder= (OrderOrderInfoViewHolder) holder;
            orderviewholder.setData(resultbean.getOrderinof());
        }
    }

    class OrderOrderInfoViewHolder extends RecyclerView.ViewHolder{
        private Context mContext;
        private GridView order_orderinfo_show_gr;
        private TextView order_orderinfo_show_text;

        public OrderOrderInfoViewHolder(Context mContext,View itemView) {
            super(itemView);
            this.mContext=mContext;
            order_orderinfo_show_gr= (GridView) itemView.findViewById(R.id.order_orderinfo_show_gr);
            order_orderinfo_show_text= (TextView) itemView.findViewById(R.id.order_orderinfo_show_text);
        }

        public void setData(final List<UserInfoResultBean.ResultBean.OrderinofBean> orderinfo){
            if(orderinfo!=null){
                OrderOrderInfoAdapter adapter=new OrderOrderInfoAdapter(mContext,orderinfo);
                order_orderinfo_show_gr.setAdapter(adapter);
            }else{
                order_orderinfo_show_gr.setVisibility(View.GONE);
                order_orderinfo_show_text.setVisibility(View.VISIBLE);
            }
        }
    }
    /**
     * 用户已经获得报价的拍卖信息
     */
    class OrderAuctionSuperViewHolder extends  RecyclerView.ViewHolder{
        private Context mContext;
        private GridView order_auction_super_show_gr;
        private TextView order_auction_super_show_text;

        public OrderAuctionSuperViewHolder(Context mContext,View itemView) {
            super(itemView);
            this.mContext=mContext;
            order_auction_super_show_gr= (GridView) itemView.findViewById(R.id.order_auction_super_show_gr);
            order_auction_super_show_text= (TextView) itemView.findViewById(R.id.order_auction_super_show_text);
        }
        public void setData(final List<UserInfoResultBean.ResultBean.AuctioninfosuperBean> auctionsuper_info){
            if(auctionsuper_info!=null){
                OrderAuctionSuperAdapter adapter=new OrderAuctionSuperAdapter(mContext,auctionsuper_info);
                order_auction_super_show_gr.setAdapter(adapter);
            }else{
                order_auction_super_show_gr.setVisibility(View.GONE);
                order_auction_super_show_text.setVisibility(View.VISIBLE);
            }


        }
    }


    /**
     * 用户发布的拍卖信息
     *
     */
    class OrderAuctionViewHolder extends RecyclerView.ViewHolder{
        private Context mContext;
        private GridView order_auctioninfo_show_gr;
        private TextView order_auction_show_text;

        public OrderAuctionViewHolder(Context mContext,View itemView){
            super(itemView);
            this.mContext=mContext;
            order_auctioninfo_show_gr= (GridView) itemView.findViewById(R.id.order_auctioninfo_show_gr);
            order_auction_show_text= (TextView) itemView.findViewById(R.id.order_auction_show_text);
        }

        public void setData(final List<UserInfoResultBean.ResultBean.AuctioninfoBean> auctioninfo_info){
            if(auctioninfo_info!=null){
                OrderAuctionAdapter adapter=new OrderAuctionAdapter(mContext,auctioninfo_info);
                order_auctioninfo_show_gr.setAdapter(adapter);
            }else{
                order_auctioninfo_show_gr.setVisibility(View.GONE);
                order_auction_show_text.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public int getItemViewType(int position){
        switch (position){
            case AUCTION:
                currenType=AUCTION;
                break;
            case AUCTIONSUPER:
                currenType=AUCTIONSUPER;
                break;
            case ORDER:
                currenType=ORDER;
                break;
        }
        return currenType;
    }


    @Override
    public int getItemCount() {
        return 3;
    }
}
