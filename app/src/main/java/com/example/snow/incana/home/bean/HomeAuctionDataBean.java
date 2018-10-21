package com.example.snow.incana.home.bean;

import java.util.List;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $RiverSonw$
 * @updateDes ${TODO}
 */
public class HomeAuctionDataBean {


    /**
     * result : {"HomePageAuction":[{"statime":"1521110000000","maxprice":0,"oneprice":645,"label":"数码","commname":"游戏鼠标宏按键","bidtime":0,"auctionid":14,"sellid":6,"picaddress":"TB2wIL_g26H8KJjSspmXXb2WXXa.jpg","staprice":518,"deadtime":"1529060000000","state":0,"describe":"游戏鼠标，宏按键。。。"},{"statime":"1521110000000","maxprice":0,"oneprice":0,"label":"服装","commname":"女外套学院可爱风","bidtime":0,"auctionid":13,"sellid":6,"picaddress":"TB2vOnIngvD8KJjy0FlXXagBFXa.jpg","staprice":200,"deadtime":"1529060000000","state":0,"describe":"女外套"},{"statime":"1521110000000","maxprice":0,"oneprice":0,"label":"化妆品","commname":"唇彩","bidtime":0,"auctionid":12,"sellid":5,"picaddress":"TB2R1f6izihSKJjy0FlXXadEXXa.jpg","staprice":148,"deadtime":"1529060000000","state":0,"describe":"化妆品，唇彩"},{"statime":"1521110000000","maxprice":0,"oneprice":119,"label":"玩具","commname":"塑料人手办动漫角色","bidtime":0,"auctionid":11,"sellid":5,"picaddress":"TB2MhaoctzJ8KJjSspkXXbF7VXa.jpg","staprice":89,"deadtime":"1529060000000","state":0,"describe":"手办，动漫"},{"statime":"1521110000000","maxprice":0,"oneprice":219,"label":"乐器","commname":"尤克里里琴","bidtime":0,"auctionid":10,"sellid":5,"picaddress":"TB2KITqbr1YBuNjSszhXXcUsFXa.jpg","staprice":168,"deadtime":"1529060000000","state":0,"describe":"民族乐器"},{"statime":"1521110000000","maxprice":0,"oneprice":148,"label":"服装","commname":"男士套头衫","bidtime":0,"auctionid":9,"sellid":4,"picaddress":"TB2k9YIngLD8KJjSszeXXaGRpXa.jpg","staprice":99,"deadtime":"1529060000000","state":0,"describe":"套头衫"},{"statime":"1521110000000","maxprice":1050,"oneprice":0,"label":"饰品","commname":"玉石挂坠翡翠","bidtime":0,"auctionid":8,"sellid":4,"picaddress":"TB2hHuYaNSYBuNjSspjXXX73VXa.jpg","staprice":899,"deadtime":"1529060000000","state":1,"describe":"送亲友"},{"statime":"1521110000000","maxprice":0,"oneprice":0,"label":"数码","commname":"笔记本电脑高配游戏电脑","bidtime":0,"auctionid":7,"sellid":3,"picaddress":"TB2_UA3XFuWBuNjSszbXXcS7FXa.jpg","staprice":5899,"deadtime":"1529060000000","state":0,"describe":"高配笔记本i7处理器gtx1080独立显卡"},{"statime":"1521110000000","maxprice":0,"oneprice":0,"label":"化妆品","commname":"眼部卸妆水","bidtime":0,"auctionid":6,"sellid":2,"picaddress":"InkedTB2_n0tq5lnpuFjSZFgXXbi7FX333.jpg","staprice":125,"deadtime":"1529060000000","state":0,"describe":"卸妆水"},{"statime":"1521110000000","maxprice":0,"oneprice":89,"label":"图书","commname":"时间简史果壳中的宇宙大设计三本全霍金著作","bidtime":0,"auctionid":5,"sellid":2,"picaddress":"TB1hWfVotfJ8KJjy0FeXXXKEXX.jpg","staprice":69,"deadtime":"1529060000000","state":0,"describe":"霍金著作三本合集"},{"statime":"1521110000000","maxprice":3700,"oneprice":4399,"label":"数码","commname":"华为P10手机黑色","bidtime":0,"auctionid":4,"sellid":2,"picaddress":"p10TB2jYeay98mpuFjSZFMXXaxp.jpg","staprice":3599,"deadtime":"1529060000000","state":1,"describe":"手机，国产当自强"},{"statime":"1521110000000","maxprice":0,"oneprice":86,"label":"图书","commname":"PS教学书籍，含有光盘","bidtime":0,"auctionid":3,"sellid":1,"picaddress":"20180315182838.jpg","staprice":62,"deadtime":"1529060000000","state":0,"describe":"自学PS的法宝"},{"statime":"1521110000000","maxprice":0,"oneprice":79,"label":"图书","commname":"三体全集刘慈欣大作三体","bidtime":0,"auctionid":2,"sellid":1,"picaddress":"20180315182642.jpg","staprice":50,"deadtime":"1529060000000","state":0,"describe":"刘慈欣的科幻巨作，内涵深刻。消灭人类暴政，世界属于三体"},{"statime":"1521110000000","maxprice":1450,"oneprice":2099,"label":"饰品","commname":"生肖挂坠礼物挂坠黄金","bidtime":0,"auctionid":1,"sellid":1,"picaddress":"20180315172331.jpg","staprice":1299,"deadtime":"1529060000000","state":1,"describe":"送女友，送家人的礼物，不二之选。纯手工打造。"}]}
     * text : auctioninfo
     */

    private ResultBean result;
    private String text;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static class ResultBean {
        private List<HomePageAuctionBean> HomePageAuction;

        public List<HomePageAuctionBean> getHomePageAuction() {
            return HomePageAuction;
        }

        public void setHomePageAuction(List<HomePageAuctionBean> HomePageAuction) {
            this.HomePageAuction = HomePageAuction;
        }

        public static class HomePageAuctionBean {
            /**
             * statime : 1521110000000
             * maxprice : 0.0
             * oneprice : 645.0
             * label : 数码
             * commname : 游戏鼠标宏按键
             * bidtime : 0
             * auctionid : 14
             * sellid : 6
             * picaddress : TB2wIL_g26H8KJjSspmXXb2WXXa.jpg
             * staprice : 518.0
             * deadtime : 1529060000000
             * state : 0
             * describe : 游戏鼠标，宏按键。。。
             */

            private String statime;
            private float maxprice;
            private float oneprice;
            private String label;
            private String commname;
            private int bidtime;
            private int auctionid;
            private int sellid;
            private String picaddress;
            private float staprice;
            private String deadtime;
            private int state;
            private String describe;

            public String getStatime() {
                return statime;
            }

            public void setStatime(String statime) {
                this.statime = statime;
            }

            public float getMaxprice() {
                return maxprice;
            }

            public void setMaxprice(float maxprice) {
                this.maxprice = maxprice;
            }

            public float getOneprice() {
                return oneprice;
            }

            public void setOneprice(float oneprice) {
                this.oneprice = oneprice;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getCommname() {
                return commname;
            }

            public void setCommname(String commname) {
                this.commname = commname;
            }

            public int getBidtime() {
                return bidtime;
            }

            public void setBidtime(int bidtime) {
                this.bidtime = bidtime;
            }

            public int getAuctionid() {
                return auctionid;
            }

            public void setAuctionid(int auctionid) {
                this.auctionid = auctionid;
            }

            public int getSellid() {
                return sellid;
            }

            public void setSellid(int sellid) {
                this.sellid = sellid;
            }

            public String getPicaddress() {
                return picaddress;
            }

            public void setPicaddress(String picaddress) {
                this.picaddress = picaddress;
            }

            public float getStaprice() {
                return staprice;
            }

            public void setStaprice(float staprice) {
                this.staprice = staprice;
            }

            public String getDeadtime() {
                return deadtime;
            }

            public void setDeadtime(String deadtime) {
                this.deadtime = deadtime;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }
        }
    }
}
