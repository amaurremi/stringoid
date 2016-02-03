package com.wbtech.ums.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utility {
    public static String md5Appkey(String paramString) {
        try {
            Object localObject = MessageDigest.getInstance("MD5");
            ((MessageDigest) localObject).update(paramString.getBytes());
            paramString = ((MessageDigest) localObject).digest();
            localObject = new StringBuffer();
            int i = 0;
            for (; ; ) {
                if (i >= paramString.length) {
                    return ((StringBuffer) localObject).toString();
                }
                int j = paramString[i] & 0xFF;
                if (j < 16) {
                    ((StringBuffer) localObject).append("0");
                }
                ((StringBuffer) localObject).append(Integer.toHexString(j));
                i += 1;
            }
            return "";
        } catch (NoSuchAlgorithmException paramString) {
            CommonUtil.printLog("MD5Utility", "getMD5 error");
            paramString.printStackTrace();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/wbtech/ums/common/MD5Utility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */