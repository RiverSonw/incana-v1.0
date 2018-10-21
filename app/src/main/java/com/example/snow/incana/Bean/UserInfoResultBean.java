package com.example.snow.incana.Bean;

import android.app.Application;

import java.util.List;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $RiverSonw$
 * @updateDes ${TODO}
 */
public class UserInfoResultBean extends Application{


    /**
     * result : {"auctioninfosuper":[{"statime":"1521110000000","address":"2栋","maxprice":1450,"oneprice":2099,"label":"饰品","commname":"生肖挂坠礼物挂坠黄金","auctionid":1,"bidtimes":0,"picaddress":"20180315172331.jpg","phone":"22222222222","staprice":1299,"deadtime":"1529060000000","state":1,"describe":"送女友，送家人的礼物，不二之选。纯手工打造。","username":"snow"}],"orderinof":[{"statime":"1521110000000","address":"2栋","maxprice":3700,"orderid":1,"oneprice":4399,"label":"数码","orderstate":0,"commname":"华为P10手机黑色","auctionid":4,"bidtimes":0,"picaddress":"p10TB2jYeay98mpuFjSZFMXXaxp.jpg","orderuserid":1,"userprice":3700,"phone":"22222222222","staprice":3599,"deadtime":"1529060000000","state":1,"describe":"手机，国产当自强","username":"snow"}],"auctioninfo":[{"statime":"1521110000000","maxprice":1450,"oneprice":2099,"label":"饰品","commname":"生肖挂坠礼物挂坠黄金","auctionid":1,"bidtimes":0,"picaddress":"20180315172331.jpg","staprice":1299,"deadtime":"1529060000000","state":1,"describe":"送女友，送家人的礼物，不二之选。纯手工打造。"},{"statime":"1521110000000","maxprice":0,"oneprice":79,"label":"图书","commname":"三体全集刘慈欣大作三体","auctionid":2,"bidtimes":0,"picaddress":"20180315182642.jpg","staprice":50,"deadtime":"1529060000000","state":0,"describe":"刘慈欣的科幻巨作，内涵深刻。消灭人类暴政，世界属于三体"},{"statime":"1521110000000","maxprice":0,"oneprice":86,"label":"图书","commname":"PS教学书籍，含有光盘","auctionid":3,"bidtimes":0,"picaddress":"20180315182838.jpg","staprice":62,"deadtime":"1529060000000","state":0,"describe":"自学PS的法宝"}],"userinfo":{"address":"8栋","phone":"11111111111","sex":"男","username":"tom"}}
     */

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * auctioninfosuper : [{"statime":"1521110000000","address":"2栋","maxprice":1450,"oneprice":2099,"label":"饰品","commname":"生肖挂坠礼物挂坠黄金","auctionid":1,"bidtimes":0,"picaddress":"20180315172331.jpg","phone":"22222222222","staprice":1299,"deadtime":"1529060000000","state":1,"describe":"送女友，送家人的礼物，不二之选。纯手工打造。","username":"snow"}]
         * orderinof : [{"statime":"1521110000000","address":"2栋","maxprice":3700,"orderid":1,"oneprice":4399,"label":"数码","orderstate":0,"commname":"华为P10手机黑色","auctionid":4,"bidtimes":0,"picaddress":"p10TB2jYeay98mpuFjSZFMXXaxp.jpg","orderuserid":1,"userprice":3700,"phone":"22222222222","staprice":3599,"deadtime":"1529060000000","state":1,"describe":"手机，国产当自强","username":"snow"}]
         * auctioninfo : [{"statime":"1521110000000","maxprice":1450,"oneprice":2099,"label":"饰品","commname":"生肖挂坠礼物挂坠黄金","auctionid":1,"bidtimes":0,"picaddress":"20180315172331.jpg","staprice":1299,"deadtime":"1529060000000","state":1,"describe":"送女友，送家人的礼物，不二之选。纯手工打造。"},{"statime":"1521110000000","maxprice":0,"oneprice":79,"label":"图书","commname":"三体全集刘慈欣大作三体","auctionid":2,"bidtimes":0,"picaddress":"20180315182642.jpg","staprice":50,"deadtime":"1529060000000","state":0,"describe":"刘慈欣的科幻巨作，内涵深刻。消灭人类暴政，世界属于三体"},{"statime":"1521110000000","maxprice":0,"oneprice":86,"label":"图书","commname":"PS教学书籍，含有光盘","auctionid":3,"bidtimes":0,"picaddress":"20180315182838.jpg","staprice":62,"deadtime":"1529060000000","state":0,"describe":"自学PS的法宝"}]
         * userinfo : {"address":"8栋","phone":"11111111111","sex":"男","username":"tom"}
         */

        private UserinfoBean userinfo;
        private List<AuctioninfosuperBean> auctioninfosuper;
        private List<OrderinofBean> orderinof;
        private List<AuctioninfoBean> auctioninfo;

        public UserinfoBean getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(UserinfoBean userinfo) {
            this.userinfo = userinfo;
        }

        public List<AuctioninfosuperBean> getAuctioninfosuper() {
            return auctioninfosuper;
        }

        public void setAuctioninfosuper(List<AuctioninfosuperBean> auctioninfosuper) {
            this.auctioninfosuper = auctioninfosuper;
        }

        public List<OrderinofBean> getOrderinof() {
            return orderinof;
        }

        public void setOrderinof(List<OrderinofBean> orderinof) {
            this.orderinof = orderinof;
        }

        public List<AuctioninfoBean> getAuctioninfo() {
            return auctioninfo;
        }

        public void setAuctioninfo(List<AuctioninfoBean> auctioninfo) {
            this.auctioninfo = auctioninfo;
        }

        public static class UserinfoBean {
            /**
             * address : 8栋
             * phone : 11111111111
             * sex : 男
             * username : tom
             * userid: 1
             */

            private String address;
            private String phone;
            private String sex;
            private String username;
            private String password;
            private int userid;

            public int getUserid() {
                return userid;
            }

            public void setUserid(int userid) {
                this.userid = userid;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }

        public static class AuctioninfosuperBean {
            /**
             * statime : 1521110000000
             * address : 2栋
             * maxprice : 1450.0
             * oneprice : 2099.0
             * label : 饰品
             * commname : 生肖挂坠礼物挂坠黄金
             * auctionid : 1
             * bidtimes : 0
             * picaddress : 20180315172331.jpg
             * phone : 22222222222
             * staprice : 1299.0
             * deadtime : 1529060000000
             * state : 1
             * describe : 送女友，送家人的礼物，不二之选。纯手工打造。
             * username : snow
             */

            private String statime;
            private String address;
            private double maxprice;
            private double oneprice;
            private String label;
            private String commname;
            private int auctionid;
            private int bidtimes;
            private String picaddress;
            private String phone;
            private double staprice;
            private String deadtime;
            private int state;
            private String describe;
            private String username;
            private String endtime;

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }

            public String getStatime() {
                return statime;
            }

            public void setStatime(String statime) {
                this.statime = statime;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public double getMaxprice() {
                return maxprice;
            }

            public void setMaxprice(double maxprice) {
                this.maxprice = maxprice;
            }

            public double getOneprice() {
                return oneprice;
            }

            public void setOneprice(double oneprice) {
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

            public int getAuctionid() {
                return auctionid;
            }

            public void setAuctionid(int auctionid) {
                this.auctionid = auctionid;
            }

            public int getBidtimes() {
                return bidtimes;
            }

            public void setBidtimes(int bidtimes) {
                this.bidtimes = bidtimes;
            }

            public String getPicaddress() {
                return picaddress;
            }

            public void setPicaddress(String picaddress) {
                this.picaddress = picaddress;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public double getStaprice() {
                return staprice;
            }

            public void setStaprice(double staprice) {
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

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }

        public static class OrderinofBean {
            /**
             * statime : 1521110000000
             * address : 2栋
             * maxprice : 3700.0
             * orderid : 1
             * oneprice : 4399.0
             * label : 数码
             * orderstate : 0
             * commname : 华为P10手机黑色
             * auctionid : 4
             * bidtimes : 0
             * picaddress : p10TB2jYeay98mpuFjSZFMXXaxp.jpg
             * orderuserid : 1
             * userprice : 3700.0
             * phone : 22222222222
             * staprice : 3599.0
             * deadtime : 1529060000000
             * state : 1
             * describe : 手机，国产当自强
             * username : snow
             */

            private String statime;
            private String address;
            private double maxprice;
            private int orderid;
            private double oneprice;
            private String label;
            private int orderstate;
            private String commname;
            private int auctionid;
            private int bidtimes;
            private String picaddress;
            private int orderuserid;
            private double userprice;
            private String phone;
            private double staprice;
            private String deadtime;
            private int state;
            private String describe;
            private String username;
            private String endtime;

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }

            public String getStatime() {
                return statime;
            }

            public void setStatime(String statime) {
                this.statime = statime;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public double getMaxprice() {
                return maxprice;
            }

            public void setMaxprice(double maxprice) {
                this.maxprice = maxprice;
            }

            public int getOrderid() {
                return orderid;
            }

            public void setOrderid(int orderid) {
                this.orderid = orderid;
            }

            public double getOneprice() {
                return oneprice;
            }

            public void setOneprice(double oneprice) {
                this.oneprice = oneprice;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public int getOrderstate() {
                return orderstate;
            }

            public void setOrderstate(int orderstate) {
                this.orderstate = orderstate;
            }

            public String getCommname() {
                return commname;
            }

            public void setCommname(String commname) {
                this.commname = commname;
            }

            public int getAuctionid() {
                return auctionid;
            }

            public void setAuctionid(int auctionid) {
                this.auctionid = auctionid;
            }

            public int getBidtimes() {
                return bidtimes;
            }

            public void setBidtimes(int bidtimes) {
                this.bidtimes = bidtimes;
            }

            public String getPicaddress() {
                return picaddress;
            }

            public void setPicaddress(String picaddress) {
                this.picaddress = picaddress;
            }

            public int getOrderuserid() {
                return orderuserid;
            }

            public void setOrderuserid(int orderuserid) {
                this.orderuserid = orderuserid;
            }

            public double getUserprice() {
                return userprice;
            }

            public void setUserprice(double userprice) {
                this.userprice = userprice;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public double getStaprice() {
                return staprice;
            }

            public void setStaprice(double staprice) {
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

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }

        public static class AuctioninfoBean {
            /**
             * statime : 1521110000000
             * maxprice : 1450.0
             * oneprice : 2099.0
             * label : 饰品
             * commname : 生肖挂坠礼物挂坠黄金
             * auctionid : 1
             * bidtimes : 0
             * picaddress : 20180315172331.jpg
             * staprice : 1299.0
             * deadtime : 1529060000000
             * state : 1
             * describe : 送女友，送家人的礼物，不二之选。纯手工打造。
             * endtime:
             */

            private String statime;
            private double maxprice;
            private double oneprice;
            private String label;
            private String commname;
            private int auctionid;
            private int bidtimes;
            private String picaddress;
            private double staprice;
            private String deadtime;
            private int state;
            private String describe;
            private String endtime;

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }

            public String getStatime() {
                return statime;
            }

            public void setStatime(String statime) {
                this.statime = statime;
            }

            public double getMaxprice() {
                return maxprice;
            }

            public void setMaxprice(double maxprice) {
                this.maxprice = maxprice;
            }

            public double getOneprice() {
                return oneprice;
            }

            public void setOneprice(double oneprice) {
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

            public int getAuctionid() {
                return auctionid;
            }

            public void setAuctionid(int auctionid) {
                this.auctionid = auctionid;
            }

            public int getBidtimes() {
                return bidtimes;
            }

            public void setBidtimes(int bidtimes) {
                this.bidtimes = bidtimes;
            }

            public String getPicaddress() {
                return picaddress;
            }

            public void setPicaddress(String picaddress) {
                this.picaddress = picaddress;
            }

            public double getStaprice() {
                return staprice;
            }

            public void setStaprice(double staprice) {
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
