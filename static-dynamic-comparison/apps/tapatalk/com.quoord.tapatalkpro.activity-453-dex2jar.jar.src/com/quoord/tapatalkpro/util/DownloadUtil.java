package com.quoord.tapatalkpro.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.cache.AppCacheManager;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class DownloadUtil {
    public static final String BROKEN = "BROKEN";

    public static boolean checkLocal(String paramString) {
        return new File(paramString).exists();
    }

    public static String getRomoteBitmapLocalUrl(Context paramContext, String paramString) {
        if ((paramString == null) || (paramString.length() == 0)) {
            paramContext = "BROKEN";
            return paramContext;
        }
        AppCacheManager.getRemoteImageCacheDir(paramContext);
        String str = AppCacheManager.getRemoteImageCacheDir(paramContext) + paramString.hashCode();
        File localFile = new File(str);
        paramString = paramString.replaceAll("&amp;", "&").replaceAll(" ", "%20");
        paramContext = paramString;
        if (!paramString.startsWith("http://")) {
            paramContext = paramString;
            if (!paramString.startsWith("https://")) {
                paramContext = "http://" + paramString;
            }
        }
        for (; ; ) {
            try {
                localObject = new URL(paramContext);
                if (!paramContext.startsWith("https")) {
                    continue;
                }
                Util.trustAllHosts();
                paramString = (HttpsURLConnection) ((URL) localObject).openConnection();
                paramString.setHostnameVerifier(Util.DO_NOT_VERIFY);
                paramString.setConnectTimeout(6000);
                paramString.setReadTimeout(60000);
                paramContext = paramString;
                if (!((URL) localObject).toString().startsWith("https")) {
                    if (paramString.getResponseCode() != 302) {
                        continue;
                    }
                    localObject = paramString.getURL();
                    paramContext = paramString;
                    if (((URL) localObject).toString().startsWith("https")) {
                        paramContext = (HttpURLConnection) ((URL) localObject).openConnection();
                    }
                }
                paramContext.setConnectTimeout(6000);
                paramContext.setReadTimeout(60000);
                paramContext.setDoInput(true);
                paramContext.setRequestProperty("Accept-Encoding", "none");
                paramContext.connect();
                paramString = new DataInputStream(paramContext.getInputStream());
                localObject = new FileOutputStream(localFile);
                arrayOfByte = new byte['Ѐ'];
                i = paramString.read(arrayOfByte);
                if (i != -1) {
                    continue;
                }
                paramContext.disconnect();
                paramString.close();
                ((FileOutputStream) localObject).flush();
                ((FileOutputStream) localObject).close();
            } catch (Exception paramContext) {
                Object localObject;
                byte[] arrayOfByte;
                int i;
                paramContext.printStackTrace();
                continue;
            }
            paramContext = str;
            if (localFile.exists()) {
                break;
            }
            return "BROKEN";
            paramString = (HttpURLConnection) ((URL) localObject).openConnection();
            continue;
            paramContext = (HttpURLConnection) ((URL) localObject).openConnection();
            continue;
            ((FileOutputStream) localObject).write(arrayOfByte, 0, i);
        }
    }

    public static String getRomoteBitmapLocalUrl(Context paramContext, String paramString, boolean paramBoolean) {
        if ((paramString == null) || (paramString.length() == 0)) {
            paramContext = "BROKEN";
            return paramContext;
        }
        if (!AppCacheManager.checkFile(AppCacheManager.getRemoteImageCacheDir(paramContext))) {
            AppCacheManager.createCacheDir(paramContext);
        }
        String str = AppCacheManager.getRemoteImageCacheDir(paramContext) + paramString.hashCode();
        File localFile = new File(str);
        paramString = paramString.replaceAll("&amp;", "&").replaceAll(" ", "%20");
        paramContext = paramString;
        if (!paramString.startsWith("http://")) {
            paramContext = paramString;
            if (!paramString.startsWith("https://")) {
                paramContext = "http://" + paramString;
            }
        }
        for (; ; ) {
            try {
                localObject = new URL(paramContext);
                if (!paramContext.startsWith("https")) {
                    continue;
                }
                Util.trustAllHosts();
                paramString = (HttpsURLConnection) ((URL) localObject).openConnection();
                paramString.setHostnameVerifier(Util.DO_NOT_VERIFY);
                paramString.setConnectTimeout(6000);
                paramString.setReadTimeout(60000);
                paramContext = paramString;
                if (!((URL) localObject).toString().startsWith("https")) {
                    if (paramString.getResponseCode() != 302) {
                        continue;
                    }
                    localObject = paramString.getURL();
                    paramContext = paramString;
                    if (((URL) localObject).toString().startsWith("https")) {
                        paramContext = (HttpURLConnection) ((URL) localObject).openConnection();
                    }
                }
                paramContext.setConnectTimeout(6000);
                paramContext.setReadTimeout(60000);
                paramContext.setDoInput(true);
                paramContext.setRequestProperty("Accept-Encoding", "none");
                paramContext.connect();
                paramString = new DataInputStream(paramContext.getInputStream());
                localObject = new FileOutputStream(localFile);
                arrayOfByte = new byte['Ѐ'];
                i = paramString.read(arrayOfByte);
                if (i != -1) {
                    continue;
                }
                paramContext.disconnect();
                paramString.close();
                ((FileOutputStream) localObject).flush();
                ((FileOutputStream) localObject).close();
            } catch (Exception paramContext) {
                Object localObject;
                byte[] arrayOfByte;
                int i;
                paramContext.printStackTrace();
                continue;
            }
            paramContext = str;
            if (localFile.exists()) {
                break;
            }
            return "BROKEN";
            paramString = (HttpURLConnection) ((URL) localObject).openConnection();
            continue;
            paramContext = (HttpURLConnection) ((URL) localObject).openConnection();
            continue;
            ((FileOutputStream) localObject).write(arrayOfByte, 0, i);
        }
    }

    public static String getRomoteBitmapLocalUrl(ForumStatus paramForumStatus, String paramString, Context paramContext) {
        if ((paramString == null) || (paramString.length() == 0)) {
            paramForumStatus = "BROKEN";
            return paramForumStatus;
        }
        if (!AppCacheManager.checkFile(AppCacheManager.getRemoteImageCacheDir(paramContext))) {
            AppCacheManager.createCacheDir(paramContext);
        }
        String str1 = AppCacheManager.getRootCacheDir(paramContext) + paramString.hashCode();
        File localFile = new File(str1);
        String str2 = paramForumStatus.getCookie();
        Object localObject = paramString.replaceAll("&amp;", "&").replaceAll(" ", "%20");
        paramString = (String) localObject;
        if (!((String) localObject).startsWith("http://")) {
            paramString = (String) localObject;
            if (!((String) localObject).startsWith("https://")) {
                paramString = "http://" + (String) localObject;
            }
        }
        for (; ; ) {
            try {
                localURL = new URL(paramString);
                if (!paramString.startsWith("https")) {
                    continue;
                }
                Util.trustAllHosts();
                localObject = (HttpsURLConnection) localURL.openConnection();
                ((HttpsURLConnection) localObject).setHostnameVerifier(Util.DO_NOT_VERIFY);
                ((HttpURLConnection) localObject).setConnectTimeout(6000);
                ((HttpURLConnection) localObject).setReadTimeout(60000);
                paramString = (String) localObject;
                if (!localURL.toString().startsWith("https")) {
                    if (((HttpURLConnection) localObject).getResponseCode() != 302) {
                        continue;
                    }
                    localURL = ((HttpURLConnection) localObject).getURL();
                    paramString = (String) localObject;
                    if (localURL.toString().startsWith("https")) {
                        paramString = (HttpURLConnection) localURL.openConnection();
                    }
                }
                paramString.setConnectTimeout(6000);
                paramString.setReadTimeout(60000);
                paramString.setDoInput(true);
                if ((str2 != null) && (str2.length() > 0)) {
                    paramString.setRequestProperty("Cookie", paramForumStatus.getCookie());
                }
                if (paramForumStatus != null) {
                    paramString.setRequestProperty("Referer", paramForumStatus.getUrl());
                }
                UserAgent.setHTTPURLConn(paramContext, paramString, paramForumStatus);
                if ((paramForumStatus != null) && (paramForumStatus.isContentType())) {
                    paramString.setRequestProperty("Content-Type", "text/xml");
                }
                if ((paramForumStatus != null) && (paramForumStatus.isRequestZip())) {
                    paramString.setRequestProperty("Content-Encoding", "gzip");
                }
                paramString.setRequestProperty("Accept-Encoding", "none");
                paramString.connect();
                paramForumStatus = new DataInputStream(paramString.getInputStream());
                paramContext = new FileOutputStream(localFile);
                localObject = new byte['Ѐ'];
                i = paramForumStatus.read((byte[]) localObject);
                if (i != -1) {
                    continue;
                }
                paramString.disconnect();
                paramForumStatus.close();
                paramContext.flush();
                paramContext.close();
            } catch (Exception paramForumStatus) {
                URL localURL;
                int i;
                paramForumStatus.printStackTrace();
                continue;
            }
            paramForumStatus = str1;
            if (localFile.exists()) {
                break;
            }
            return "BROKEN";
            localObject = (HttpURLConnection) localURL.openConnection();
            continue;
            paramString = (HttpURLConnection) localURL.openConnection();
            continue;
            paramContext.write((byte[]) localObject, 0, i);
        }
    }

    public static String getRomoteBitmapLocalUrl(ForumStatus paramForumStatus, String paramString1, String paramString2, Context paramContext) {
        return getRomoteBitmapLocalUrl(paramForumStatus, paramString1, paramContext);
    }

    public static String getRomoteBitmapLocalUrl(ForumStatus paramForumStatus, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, Context paramContext) {
        return getRomoteBitmapLocalUrl(paramForumStatus, paramString1, paramContext);
    }

    public static String getRomoteBitmapLocalUrlWithNoStatus(Context paramContext, String paramString) {
        return getRomoteBitmapLocalUrl(paramContext, paramString);
    }

    private static Drawable matrixImage(Bitmap paramBitmap) {
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        float f1 = 'î' / i;
        float f2 = 'î' / j;
        Matrix localMatrix = new Matrix();
        localMatrix.postScale(f1, f2);
        return new BitmapDrawable(Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/DownloadUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */