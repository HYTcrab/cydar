package com.forum.util;

public class MyConstant {
    //七牛云相关
    public static final String QINIU_IMAGE_URL = "http://pcqco941f.bkt.clouddn.com/";
    public static final String QINIU_ACCESS_KEY = "AE9-H7hDTfHeEJh9pyajRbktIi3BMDneMesKcsSZ";
    public static final String QINIU_SECRET_KEY = "d2hnSQIFnTNkPQ2qay0oVO5oy46YpdIHMIDeJhpV";
    public static final String QINIU_BUCKET_NAME = "cydar";

    //发送邮件的邮箱，要与df.properties中的一致
    public static final String MAIL_FROM = "779302556@qq.com";

    //域名

    //public static final String DOMAIN_NAME = "http://naivee.me/";
    public static final String DOMAIN_NAME = "http://localhost:8080/";

    //三种操作
    public static final int OPERATION_CLICK_LIKE = 1;
    public static final int OPERATION_REPLY = 2;
    public static final int OPERATION_COMMENT = 3;
}
