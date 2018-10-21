package com.example.snow.incana.utils;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $RiverSonw$
 * @updateDes ${TODO}
 *      常量类，存放各个页面的联网地址
 */

public class Constants {
    public static String BASE_URL="http://www.incana.xin/incana";
    //主页信息的URL
    public static String HOME_URL=BASE_URL+"/json/Home_Page.json";
    //图片的路径
    public static String HOME_AUCTION_IMG=BASE_URL+"/img/";
    //用户登录servlet的路径
    public static String USER_LOGIN_SERVLET=BASE_URL+"/userLoginAndOrder";
    //用户注册的servlet的路径
    public static String USER_REGITS=BASE_URL+"/UserRegist";

    //用户参与竞价的方法路径
    public static String USER_JOIN_AUCTION=BASE_URL+"/UserJoinAuctionf";
    //用户发布新的拍卖的方法路径
    public static String USER_RELASE_AUCTION=BASE_URL+"/UserRelaseAuction";


}
