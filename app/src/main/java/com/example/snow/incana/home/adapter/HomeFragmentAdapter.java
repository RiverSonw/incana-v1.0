package com.example.snow.incana.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.snow.incana.Bean.GoodsBean;
import com.example.snow.incana.R;
import com.example.snow.incana.app.GoodsInfoActivity;
import com.example.snow.incana.home.bean.HomeAuctionDataBean;

import java.util.List;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $RiverSonw$
 * @updateDes ${TODO}
 */
public class HomeFragmentAdapter extends RecyclerView.Adapter {
    /**
     *  模块1  欢迎模块
     *          暂时为静态图   准备做成轮播图
     *
     *  模块2  信息展示中心
     *          展示数据库中前20的数据
     */

    public static final int WELCOME=0;

    public static final int RECOMMEND=1;

    private static final String GOODS_BEAN = "goodsbean";


    private Context mContext;

    private LayoutInflater mLayoutInflater;


    private HomeAuctionDataBean.ResultBean resultBean;

    private int currentType=WELCOME;



    public HomeFragmentAdapter(Context mContext, HomeAuctionDataBean.ResultBean resultBean) {
        this.mContext=mContext;
        this.resultBean=resultBean;
        mLayoutInflater=LayoutInflater.from(mContext);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==WELCOME){
            return new WelcomeViewHolder(mContext,mLayoutInflater.inflate(R.layout.home_welcome_view,null));
        }else if(viewType==RECOMMEND){
            return new RecommendViewHolder(mContext,mLayoutInflater.inflate(R.layout.recommend_item,null));
        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==WELCOME){

        }else if(getItemViewType(position)==RECOMMEND){
            RecommendViewHolder recommendviewholder= (RecommendViewHolder) holder;
            recommendviewholder.setData(resultBean.getHomePageAuction());
        }
    }

    /**
     * 数据展示中心
     *      展示数据库前20 的数据
     */
    class RecommendViewHolder extends RecyclerView.ViewHolder{
        private Context mContext;
        private GridView gv_recommend;
        private TextView tv_more_recommend;

        public RecommendViewHolder(Context mContext,View itemView) {
            super(itemView);
            this.mContext=mContext;
            tv_more_recommend= (TextView) itemView.findViewById(R.id.tv_more_recommend);
            gv_recommend= (GridView) itemView.findViewById(R.id.gv_recommend);
        }
        public void setData(final List<HomeAuctionDataBean.ResultBean.HomePageAuctionBean> recommend_info){
            RecommendGridViewAdapter adapter=new RecommendGridViewAdapter(mContext,recommend_info);
            gv_recommend.setAdapter(adapter);

            /**
             * 设置监听跳转至商品展示页面
             *          放置的数据主要有
             *                  auctionid
             *                  commname
             *                  describe
             *                  staprice
             *                  oneprice
             *                  deadtime   最终时间
             *                  statime
             *                  state
             */
            gv_recommend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    HomeAuctionDataBean.ResultBean.HomePageAuctionBean recombean=recommend_info.get(position);

                    GoodsBean goodsbean=new GoodsBean();
                    goodsbean.setAuctionid(recombean.getAuctionid());
                    goodsbean.setPicadderss(recombean.getPicaddress());
                    goodsbean.setCommname(recombean.getCommname());
                    goodsbean.setDescirbe(recombean.getDescribe());
                    goodsbean.setStaprice(recombean.getStaprice());
                    goodsbean.setOneprice(recombean.getOneprice());
                    goodsbean.setMaxprice(recombean.getMaxprice());
                    goodsbean.setDeadtime(Long.valueOf(recombean.getDeadtime()));
                    goodsbean.setStatime(Long.valueOf(recombean.getStatime()));
                    goodsbean.setState(recombean.getState());
                    goodsbean.setSellid(recombean.getSellid());

                    Toast.makeText(mContext,goodsbean.getCommname(), Toast.LENGTH_SHORT).show();
                    System.out.println("选中的商品的一口价："+goodsbean.getOneprice()+"商品的最高价："+goodsbean.getMaxprice());

                    stateGoodsInfoActivity(goodsbean);
                }

            });
        }

    }



    /**
     * 欢迎模块
     *      暂时只有一张图。
     *          准备做成轮播图形式
     *
     */
    class WelcomeViewHolder extends RecyclerView.ViewHolder{
        private Context mContext;
        public WelcomeViewHolder(Context mContext,View itemView) {
            super(itemView);
            this.mContext=mContext;
            System.out.println("homewelcomeview页面显示了。");
        }
    }


    private void stateGoodsInfoActivity(GoodsBean goodsbean){
        Intent intent=new Intent(mContext, GoodsInfoActivity.class);

        intent.putExtra(GOODS_BEAN,goodsbean);
        mContext.startActivity(intent);

    }




    @Override
    public int getItemViewType(int position){
        switch(position){
            case WELCOME:
                currentType= WELCOME;
                break;
            case RECOMMEND:
                currentType=RECOMMEND;
                break;

        }
        return currentType;
    }

    /**
     *  每完成一个模块adapter 数字+1
     *          1---》n
     * @return
     */
    @Override
    public int getItemCount() {
        return 2;
    }
}
