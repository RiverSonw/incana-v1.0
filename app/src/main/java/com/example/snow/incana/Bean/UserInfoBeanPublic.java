package com.example.snow.incana.Bean;
import java.util.List;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $RiverSonw$
 * @updateDes ${TODO}
 */
public class UserInfoBeanPublic  {
    public static String FLAG;


    public static String getFlag() {
        return FLAG;
    }

    public static void setFlag(String flag) {
        FLAG = flag;
    }

    public static ResultBean RESULT;

    public static ResultBean getResult() {
        return RESULT;
    }

    public static void setResult(ResultBean result) {
          RESULT = result;
    }

    public static  class ResultBean {
        /**
         * auctioninfosuper : [{"statime":"1521110000000","address":"2栋","maxprice":1450,"endtime":"","oneprice":2099,"label":"饰品","commname":"生肖挂坠礼物挂坠黄金","auctionid":1,"bidtimes":0,"picaddress":"20180315172331 jpg","phone":"22222222222","staprice":1299,"deadtime":"1529060000000","state":1,"describe":"送女友，送家人的礼物，不二之选。纯手工打造。","username":"snow"}]
         * auctioninfo : [{"statime":"1521110000000","maxprice":1450,"endtime":"","oneprice":2099,"label":"饰品","commname":"生肖挂坠礼物挂坠黄金","auctionid":1,"bidtimes":0,"picaddress":"20180315172331 jpg","staprice":1299,"deadtime":"1529060000000","state":1,"describe":"送女友，送家人的礼物，不二之选。纯手工打造。"},{"statime":"1521110000000","maxprice":0,"oneprice":79,"label":"图书","commname":"三体全集刘慈欣大作三体","auctionid":2,"bidtimes":0,"picaddress":"20180315182642 jpg","staprice":50,"deadtime":"1529060000000","state":0,"describe":"刘慈欣的科幻巨作，内涵深刻。消灭人类暴政，世界属于三体"},{"statime":"1521110000000","maxprice":0,"oneprice":86,"label":"图书","commname":"PS教学书籍，含有光盘","auctionid":3,"bidtimes":0,"picaddress":"20180315182838 jpg","staprice":62,"deadtime":"1529060000000","state":0,"describe":"自学PS的法宝"}]
         * orderinfo : [{"statime":"1521110000000","address":"2栋","maxprice":3700,"orderid":1,"endtime":"","oneprice":4399,"label":"数码","orderstate":0,"commname":"华为P10手机黑色","auctionid":4,"bidtimes":0,"picaddress":"p10TB2jYeay98mpuFjSZFMXXaxp jpg","orderuserid":1,"userprice":3700,"phone":"22222222222","staprice":3599,"deadtime":"1529060000000","state":1,"describe":"手机，国产当自强","username":"snow"}]
         * userinfo : {"address":"8栋","phone":"11111111111","sex":"男","username":"tom"}
         */

        public static  UserinfoBean USERINFO;
        public static  List<AuctioninfosuperBean> AUCTIONINFOSUPER;
        public static  List<AuctioninfoBean> AUCTIONINFO;
        public static  List<OrderinfoBean> ORDERINFO;

        public static UserinfoBean getUserinfo() {
            return USERINFO;
        }

        public static void setUserinfo(UserinfoBean userinfo) {
              USERINFO = userinfo;
        }

        public static List<AuctioninfosuperBean> getAuctioninfosuper() {
            return AUCTIONINFOSUPER;
        }

        public static void setAuctioninfosuper(List<AuctioninfosuperBean> auctioninfosuper) {
              AUCTIONINFOSUPER = auctioninfosuper;
        }

        public static List<AuctioninfoBean> getAuctioninfo() {
            return AUCTIONINFO;
        }

        public static void setAuctioninfo(List<AuctioninfoBean> auctioninfo) {
              AUCTIONINFO = auctioninfo;
        }

        public static List<OrderinfoBean> getOrderinfo() {
            return ORDERINFO;
        }

        public static void setOrderinfo(List<OrderinfoBean> orderinfo) {
              ORDERINFO = orderinfo;
        }



        public static  class UserinfoBean {
            /**
             * address : 8栋
             * phone : 11111111111
             * sex : 男
             * username : tom
             */

            public static  String ADDRESS;
            public static  String PHONE;
            public static  String SEX;
            public static  String USERNAME;
            public static String PASSWORD;
            public static int USERID;

            public static int getUserid() {
                return USERID;
            }

            public static void setUserid(int userid) {
                USERID = userid;
            }

            public static String getPassword() {
                return PASSWORD;
            }

            public static void setPassword(String password) {
                PASSWORD = password;
            }

            public static String getAddress() {
                return ADDRESS;
            }

            public static void setAddress(String address) {
                  ADDRESS = address;
            }

            public static String getPhone() {
                return PHONE;
            }

            public static void setPhone(String phone) {
                  PHONE = phone;
            }

            public static String getSex() {
                return SEX;
            }

            public static void setSex(String sex) {
                  SEX = sex;
            }

            public static String getUsername() {
                return USERNAME;
            }

            public static void setUsername(String username) {
                  USERNAME = username;
            }
        }

        public static  class AuctioninfosuperBean {
            /**
             * 已获得拍卖竞价的商品信息
             *
             * statime : 1521110000000
             * address : 2栋
             * maxprice : 1450 0
             * endtime :
             * oneprice : 2099 0
             * label : 饰品
             * commname : 生肖挂坠礼物挂坠黄金
             * auctionid : 1
             * bidtimes : 0
             * picaddress : 20180315172331 jpg
             * phone : 22222222222
             * staprice : 1299 0
             * deadtime : 1529060000000
             * state : 1
             * describe : 送女友，送家人的礼物，不二之选。纯手工打造。
             * username : snow
             */

            public static  String STATIME;
            public static  String ADDRESS;
            public static  double MAXPRICE;
            public static  String ENDTIME;
            public static  double ONEPRICE;
            public static  String LABEL;
            public static  String COMMNAME;
            public static  int AUCTIONID;
            public static  int BIDTIMES;
            public static  String PICADDRESS;
            public static  String PHONE;
            public static  double STAPRICE;
            public static  String DEADTIME;
            public static  int STATE;
            public static  String DESCRIBE;
            public static  String USERNAME;

            public static String getStatime() {
                return STATIME;
            }

            public static void setStatime(String statime) {
                  STATIME = statime;
            }

            public static String getAddress() {
                return ADDRESS;
            }

            public static void setAddress(String address) {
                  ADDRESS = address;
            }

            public static double getMaxprice() {
                return MAXPRICE;
            }

            public static void setMaxprice(double maxprice) {
                  MAXPRICE = maxprice;
            }

            public static String getEndtime() {
                return ENDTIME;
            }

            public static void setEndtime(String endtime) {
                  ENDTIME = endtime;
            }

            public static double getOneprice() {
                return ONEPRICE;
            }

            public static void setOneprice(double oneprice) {
                  ONEPRICE = oneprice;
            }

            public static String getLabel() {
                return LABEL;
            }

            public static void setLabel(String label) {
                  LABEL = label;
            }

            public static String getCommname() {
                return COMMNAME;
            }

            public static void setCommname(String commname) {
                  COMMNAME = commname;
            }

            public static int getAuctionid() {
                return AUCTIONID;
            }

            public static void setAuctionid(int auctionid) {
                  AUCTIONID = auctionid;
            }

            public static int getBidtimes() {
                return BIDTIMES;
            }

            public static void setBidtimes(int bidtimes) {
                  BIDTIMES = bidtimes;
            }

            public static String getPicaddress() {
                return PICADDRESS;
            }

            public static void setPicaddress(String picaddress) {
                  PICADDRESS = picaddress;
            }

            public static String getPhone() {
                return PHONE;
            }

            public static void setPhone(String phone) {
                  PHONE = phone;
            }

            public static double getStaprice() {
                return STAPRICE;
            }

            public static void setStaprice(double staprice) {
                  STAPRICE = staprice;
            }

            public static String getDeadtime() {
                return DEADTIME;
            }

            public static void setDeadtime(String deadtime) {
                  DEADTIME = deadtime;
            }

            public static int getState() {
                return STATE;
            }

            public static void setState(int state) {
                  STATE = state;
            }

            public static String getDescribe() {
                return DESCRIBE;
            }

            public static void setDescribe(String describe) {
                  DESCRIBE = describe;
            }

            public static String getUsername() {
                return USERNAME;
            }

            public static void setUsername(String username) {
                  USERNAME = username;
            }
        }

        public static  class AuctioninfoBean {
            /**
             * 用户的全部拍卖商品
             *
             * statime : 1521110000000
             * maxprice : 1450 0
             * endtime :
             * oneprice : 2099 0
             * label : 饰品
             * commname : 生肖挂坠礼物挂坠黄金
             * auctionid : 1
             * bidtimes : 0
             * picaddress : 20180315172331 jpg
             * staprice : 1299 0
             * deadtime : 1529060000000
             * state : 1
             * describe : 送女友，送家人的礼物，不二之选。纯手工打造。
             */

            public static  String STATIME;
            public static  double MAXPRICE;
            public static  String ENDTIME;
            public static  double ONEPRICE;
            public static  String LABEL;
            public static  String COMMNAME;
            public static  int AUCTIONID;
            public static  int BIDTIMES;
            public static  String PICADDRESS;
            public static  double STAPRICE;
            public static  String DEADTIME;
            public static  int STATE;
            public static  String DESCRIBE;

            public static String getStatime() {
                return STATIME;
            }

            public static void setStatime(String statime) {
                  STATIME = statime;
            }

            public static double getMaxprice() {
                return MAXPRICE;
            }

            public static void setMaxprice(double maxprice) {
                  MAXPRICE = maxprice;
            }

            public static String getEndtime() {
                return ENDTIME;
            }

            public static void setEndtime(String endtime) {
                  ENDTIME = endtime;
            }

            public static double getOneprice() {
                return ONEPRICE;
            }

            public static void setOneprice(double oneprice) {
                  ONEPRICE = oneprice;
            }

            public static String getLabel() {
                return LABEL;
            }

            public static void setLabel(String label) {
                  LABEL = label;
            }

            public static String getCommname() {
                return COMMNAME;
            }

            public static void setCommname(String commname) {
                  COMMNAME = commname;
            }

            public static int getAuctionid() {
                return AUCTIONID;
            }

            public static void setAuctionid(int auctionid) {
                  AUCTIONID = auctionid;
            }

            public static int getBidtimes() {
                return BIDTIMES;
            }

            public static void setBidtimes(int bidtimes) {
                  BIDTIMES = bidtimes;
            }

            public static String getPicaddress() {
                return PICADDRESS;
            }

            public static void setPicaddress(String picaddress) {
                  PICADDRESS = picaddress;
            }

            public static double getStaprice() {
                return STAPRICE;
            }

            public static void setStaprice(double staprice) {
                  STAPRICE = staprice;
            }

            public static String getDeadtime() {
                return DEADTIME;
            }

            public static void setDeadtime(String deadtime) {
                  DEADTIME = deadtime;
            }

            public static int getState() {
                return STATE;
            }

            public static void setState(int state) {
                  STATE = state;
            }

            public static String getDescribe() {
                return DESCRIBE;
            }

            public static void setDescribe(String describe) {
                  DESCRIBE = describe;
            }
        }

        public static  class OrderinfoBean {
            /**
             * 用户参与竞价的商品信息
             *
             * statime : 1521110000000
             * address : 2栋
             * maxprice : 3700 0
             * orderid : 1
             * endtime :
             * oneprice : 4399 0
             * label : 数码
             * orderstate : 0
             * commname : 华为P10手机黑色
             * auctionid : 4
             * bidtimes : 0
             * picaddress : p10TB2jYeay98mpuFjSZFMXXaxp jpg
             * orderuserid : 1
             * userprice : 3700 0
             * phone : 22222222222
             * staprice : 3599 0
             * deadtime : 1529060000000
             * state : 1
             * describe : 手机，国产当自强
             * username : snow
             */

            public static  String STATIME;
            public static  String ADDRESS;
            public static  double MAXPRICE;
            public static  int ORDERID;
            public static  String ENDTIME;
            public static  double ONEPRICE;
            public static  String LABEL;
            public static  int ORDERSTATE;
            public static  String COMMNAME;
            public static  int AUCTIONID;
            public static  int BIDTIMES;
            public static  String PICADDRESS;
            public static  int ORDERUSERID;
            public static  double USERPRICE;
            public static  String PHONE;
            public static  double STAPRICE;
            public static  String DEADTIME;
            public static  int STATE;
            public static  String DESCRIBE;
            public static  String USERNAME;

            public static String getStatime() {
                return STATIME;
            }

            public static void setStatime(String statime) {
                  STATIME = statime;
            }

            public static String getAddress() {
                return ADDRESS;
            }

            public static void setAddress(String address) {
                  ADDRESS = address;
            }

            public static double getMaxprice() {
                return MAXPRICE;
            }

            public static void setMaxprice(double maxprice) {
                  MAXPRICE = maxprice;
            }

            public static int getOrderid() {
                return ORDERID;
            }

            public static void setOrderid(int orderid) {
                  ORDERID = orderid;
            }

            public static String getEndtime() {
                return ENDTIME;
            }

            public static void setEndtime(String endtime) {
                  ENDTIME = endtime;
            }

            public static double getOneprice() {
                return ONEPRICE;
            }

            public static void setOneprice(double oneprice) {
                  ONEPRICE = oneprice;
            }

            public static String getLabel() {
                return LABEL;
            }

            public static void setLabel(String label) {
                  LABEL = label;
            }

            public static int getOrderstate() {
                return ORDERSTATE;
            }

            public static void setOrderstate(int orderstate) {
                  ORDERSTATE = orderstate;
            }

            public static String getCommname() {
                return COMMNAME;
            }

            public static void setCommname(String commname) {
                  COMMNAME = commname;
            }

            public static int getAuctionid() {
                return AUCTIONID;
            }

            public static void setAuctionid(int auctionid) {
                  AUCTIONID = auctionid;
            }

            public static int getBidtimes() {
                return BIDTIMES;
            }

            public static void setBidtimes(int bidtimes) {
                  BIDTIMES = bidtimes;
            }

            public static String getPicaddress() {
                return PICADDRESS;
            }

            public static void setPicaddress(String picaddress) {
                  PICADDRESS = picaddress;
            }

            public static int getOrderuserid() {
                return ORDERUSERID;
            }

            public static void setOrderuserid(int orderuserid) {
                  ORDERUSERID = orderuserid;
            }

            public static double getUserprice() {
                return USERPRICE;
            }

            public static void setUserprice(double userprice) {
                  USERPRICE = userprice;
            }

            public static String getPhone() {
                return PHONE;
            }

            public static void setPhone(String phone) {
                  PHONE = phone;
            }

            public static double getStaprice() {
                return STAPRICE;
            }

            public static void setStaprice(double staprice) {
                  STAPRICE = staprice;
            }

            public static String getDeadtime() {
                return DEADTIME;
            }

            public static void setDeadtime(String deadtime) {
                  DEADTIME = deadtime;
            }

            public static int getState() {
                return STATE;
            }

            public static void setState(int state) {
                  STATE = state;
            }

            public static String getDescribe() {
                return DESCRIBE;
            }

            public static void setDescribe(String describe) {
                  DESCRIBE = describe;
            }

            public static String getUsername() {
                return USERNAME;
            }

            public static void setUsername(String username) {
                  USERNAME = username;
            }
        }
    }


}
