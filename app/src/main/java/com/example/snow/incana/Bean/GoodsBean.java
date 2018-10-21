package com.example.snow.incana.Bean;

import java.io.Serializable;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $RiverSonw$
 * @updateDes ${TODO}
 *          商品对象
 */
public class GoodsBean implements Serializable{
    private int auctionid ;
    private String picadderss;
    private String commname;
    private long statime;
    private long endtime;
    private long deadtime;
    private float staprice;
    private float maxprice;
    private float state;
    private String descirbe;
    private int bidtime;
    private String label;
    private float oneprice;
    private int sellid;

    public int getSellid() {
        return sellid;
    }

    public void setSellid(int sellid) {
        this.sellid = sellid;
    }

    public float getOneprice() {
        return oneprice;
    }

    public void setOneprice(float oneprice) {
        this.oneprice = oneprice;
    }

    public int getAuctionid() {
        return auctionid;
    }

    public void setAuctionid(int auctionid) {
        this.auctionid = auctionid;
    }

    public String getPicadderss() {
        return picadderss;
    }

    public void setPicadderss(String picadderss) {
        this.picadderss = picadderss;
    }

    public String getCommname() {
        return commname;
    }

    public void setCommname(String commname) {
        this.commname = commname;
    }

    public long getStatime() {
        return statime;
    }

    public void setStatime(long statime) {
        this.statime = statime;
    }

    public long getEndtime() {
        return endtime;
    }

    public void setEndtime(long endtime) {
        this.endtime = endtime;
    }

    public long getDeadtime() {
        return deadtime;
    }

    public void setDeadtime(long deadtime) {
        this.deadtime = deadtime;
    }

    public float getStaprice() {
        return staprice;
    }

    public void setStaprice(float staprice) {
        this.staprice = staprice;
    }

    public float getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(float maxprice) {
        this.maxprice = maxprice;
    }

    public float getState() {
        return state;
    }

    public void setState(float state) {
        this.state = state;
    }

    public String getDescirbe() {
        return descirbe;
    }

    public void setDescirbe(String descirbe) {
        this.descirbe = descirbe;
    }

    public int getBidtime() {
        return bidtime;
    }

    public void setBidtime(int bidtime) {
        this.bidtime = bidtime;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


}
