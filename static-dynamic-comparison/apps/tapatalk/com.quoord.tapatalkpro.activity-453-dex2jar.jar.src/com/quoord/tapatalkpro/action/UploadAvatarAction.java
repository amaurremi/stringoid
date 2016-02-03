package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.util.Util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class UploadAvatarAction {
    private static final String BOUNDARY = UUID.randomUUID().toString();
    private static final String CHARSET = "utf-8";
    private static final String CONTENT_TYPE = "multipart/form-data";
    private static final String LINE_END = "\r\n";
    private static final String PREFIX = "--";
    public static final int UPLOAD_FILE_NOT_EXISTS_CODE = 2;
    public static final int UPLOAD_SERVER_ERROR_CODE = 4;
    public static final int UPLOAD_SUCCESS_CODE = 1;
    private static long requestTime = 0L;
    private static UploadAvatarAction uploadAvatarAction = null;
    private int connectTimeOut = 10000;
    private Activity mActivity = null;
    private String mFileName = null;
    private int mFileSize = 0;
    private OnUploadProcessListener onUploadProcessListener;
    private int readTimeOut = 10000;

    private UploadAvatarAction(Activity paramActivity) {
        this.mActivity = paramActivity;
    }

    private ByteArrayOutputStream getImageBuffer(Uri paramUri)
            throws FileNotFoundException {
        long l = 0L;
        Object localObject;
        if (paramUri.toString().startsWith("content")) {
            localObject = this.mActivity.managedQuery(paramUri, new String[]{"mime_type", "_display_name", "_size"}, null, null, null);
            if (localObject == null) {
                sendMessage(2, "File Not Exists");
                return null;
            }
            if (!((Cursor) localObject).moveToFirst()) {
                sendMessage(2, "File Not Exists");
                return null;
            }
            this.mFileName = ((Cursor) localObject).getString(1);
            l = ((Cursor) localObject).getInt(2);
        }
        for (; ; ) {
            paramUri = this.mActivity.getContentResolver().openInputStream(paramUri);
            localObject = new BitmapFactory.Options();
            ((BitmapFactory.Options) localObject).inSampleSize = ((int) Math.sqrt(l / 70000L) + 1);
            paramUri = BitmapFactory.decodeStream(paramUri, null, (BitmapFactory.Options) localObject);
            localObject = new ByteArrayOutputStream();
            paramUri.compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream) localObject);
            this.mFileSize = ((ByteArrayOutputStream) localObject).size();
            paramUri.recycle();
            return (ByteArrayOutputStream) localObject;
            if (paramUri.toString().startsWith("file")) {
                localObject = new File(paramUri.getPath());
                this.mFileName = ((File) localObject).getName();
                l = ((File) localObject).length();
            }
        }
    }

    public static UploadAvatarAction getInstance(Activity paramActivity) {
        if (uploadAvatarAction == null) {
            uploadAvatarAction = new UploadAvatarAction(paramActivity);
        }
        for (; ; ) {
            return uploadAvatarAction;
            uploadAvatarAction.mActivity = paramActivity;
        }
    }

    // todo keys are put in hash map
    private String getParamString() {
        HashMap localHashMap = new HashMap();
        localHashMap.put("au_id", String.valueOf(TapatalkIdFactory.getTapatalkId(this.mActivity).getAuid()));
        localHashMap.put("token", TapatalkIdFactory.getTapatalkId(this.mActivity).getToken());
        localHashMap.put("app_key", "hdp3jtrujmsUis3r");
        localHashMap.put("app_id", "4");
        localHashMap.put("device_id", Util.getMD5(Util.getMacAddress(this.mActivity)));
        StringBuffer localStringBuffer = new StringBuffer();
        Iterator localIterator = localHashMap.keySet().iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                localStringBuffer.append("--").append(BOUNDARY).append("\r\n");
                localStringBuffer.append("Content-Disposition:form-data; name=\"file\"; filename=\"" + this.mFileName + "\"" + "\r\n");
                localStringBuffer.append("Content-Type:image/jpeg\r\n");
                localStringBuffer.append("\r\n");
                return localStringBuffer.toString();
            }
            String str1 = (String) localIterator.next();
            String str2 = (String) localHashMap.get(str1);
            localStringBuffer.append("--").append(BOUNDARY).append("\r\n");
            localStringBuffer.append("Content-Disposition: forum-data; name=\"").append(str1).append("\"").append("\r\n").append("\r\n");
            localStringBuffer.append(str2).append("\r\n");
        }
    }

    public static long getRequestTime() {
        return requestTime;
    }

    /* Error */
    private HttpURLConnection getUploadAvatarConnection() {
        // Byte code:
        //   0: aconst_null
        //   1: astore_1
        //   2: aload_0
        //   3: getfield 67	com/quoord/tapatalkpro/action/UploadAvatarAction:mActivity	Landroid/app/Activity;
        //   6: invokestatic 313	com/quoord/tools/directoryurl/DirectoryUrlUtil:getUploadAvatarUrl	(Landroid/content/Context;)Ljava/lang/String;
        //   9: astore_2
        //   10: new 315	java/net/URL
        //   13: dup
        //   14: aload_2
        //   15: invokespecial 316	java/net/URL:<init>	(Ljava/lang/String;)V
        //   18: astore_3
        //   19: aload_2
        //   20: ldc_w 318
        //   23: invokevirtual 96	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   26: ifeq +138 -> 164
        //   29: invokestatic 321	com/quoord/tapatalkpro/util/Util:trustAllHosts	()V
        //   32: aload_3
        //   33: invokevirtual 325	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   36: checkcast 327	javax/net/ssl/HttpsURLConnection
        //   39: astore_2
        //   40: aload_2
        //   41: getstatic 331	com/quoord/tapatalkpro/util/Util:DO_NOT_VERIFY	Ljavax/net/ssl/HostnameVerifier;
        //   44: invokevirtual 335	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
        //   47: aload_2
        //   48: astore_1
        //   49: aload_1
        //   50: ldc_w 337
        //   53: invokevirtual 342	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   56: aload_1
        //   57: aload_0
        //   58: getfield 73	com/quoord/tapatalkpro/action/UploadAvatarAction:readTimeOut	I
        //   61: invokevirtual 346	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   64: aload_1
        //   65: aload_0
        //   66: getfield 75	com/quoord/tapatalkpro/action/UploadAvatarAction:connectTimeOut	I
        //   69: invokevirtual 349	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   72: aload_1
        //   73: iconst_1
        //   74: invokevirtual 353	java/net/HttpURLConnection:setDoInput	(Z)V
        //   77: aload_1
        //   78: iconst_1
        //   79: invokevirtual 356	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   82: aload_1
        //   83: iconst_0
        //   84: invokevirtual 359	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   87: aload_1
        //   88: ldc_w 361
        //   91: ldc 14
        //   93: invokevirtual 365	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   96: aload_1
        //   97: ldc_w 367
        //   100: ldc_w 369
        //   103: invokevirtual 365	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   106: aload_1
        //   107: ldc_w 371
        //   110: new 277	java/lang/StringBuilder
        //   113: dup
        //   114: ldc_w 373
        //   117: invokespecial 280	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   120: getstatic 58	com/quoord/tapatalkpro/action/UploadAvatarAction:BOUNDARY	Ljava/lang/String;
        //   123: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   126: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   129: invokevirtual 365	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   132: aload_1
        //   133: ldc_w 375
        //   136: ldc_w 377
        //   139: invokevirtual 365	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   142: aload_1
        //   143: ldc_w 379
        //   146: ldc_w 381
        //   149: invokevirtual 365	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   152: aload_1
        //   153: ldc_w 383
        //   156: ldc_w 381
        //   159: invokevirtual 365	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   162: aload_1
        //   163: areturn
        //   164: aload_3
        //   165: invokevirtual 325	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   168: checkcast 339	java/net/HttpURLConnection
        //   171: astore_2
        //   172: aload_2
        //   173: astore_1
        //   174: goto -125 -> 49
        //   177: astore_2
        //   178: aload_2
        //   179: invokevirtual 386	java/net/MalformedURLException:printStackTrace	()V
        //   182: goto -133 -> 49
        //   185: astore_2
        //   186: aload_2
        //   187: invokevirtual 387	java/io/IOException:printStackTrace	()V
        //   190: goto -141 -> 49
        //   193: astore_2
        //   194: aload_2
        //   195: invokevirtual 388	java/net/ProtocolException:printStackTrace	()V
        //   198: goto -142 -> 56
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	201	0	this	UploadAvatarAction
        //   1	173	1	localObject1	Object
        //   9	164	2	localObject2	Object
        //   177	2	2	localMalformedURLException	java.net.MalformedURLException
        //   185	2	2	localIOException	java.io.IOException
        //   193	2	2	localProtocolException	java.net.ProtocolException
        //   18	147	3	localURL	java.net.URL
        // Exception table:
        //   from	to	target	type
        //   10	47	177	java/net/MalformedURLException
        //   164	172	177	java/net/MalformedURLException
        //   10	47	185	java/io/IOException
        //   164	172	185	java/io/IOException
        //   49	56	193	java/net/ProtocolException
    }

    private void sendMessage(int paramInt, String paramString) {
        this.onUploadProcessListener.onUploadDone(paramInt, paramString);
    }

    private void toUploadAvatar(Uri paramUri) {
        long l = System.currentTimeMillis();
        try {
            paramUri = getImageBuffer(paramUri);
            if (paramUri == null) {
                return;
            }
        } catch (FileNotFoundException paramUri) {
            sendMessage(2, "File Not Exists");
            return;
        }
        int i;
        for (; ; ) {
            Object localObject;
            DataOutputStream localDataOutputStream;
            try {
                localObject = getUploadAvatarConnection();
                localDataOutputStream = new DataOutputStream(((HttpURLConnection) localObject).getOutputStream());
                localDataOutputStream.write(getParamString().getBytes());
                this.onUploadProcessListener.initUpload(paramUri.size());
                i = 0;
                if (i >= paramUri.size() - 1024) {
                    localDataOutputStream.write(paramUri.toByteArray(), i, paramUri.size() - i);
                    this.onUploadProcessListener.onUploadProcess(paramUri.size());
                    localDataOutputStream.write("\r\n".getBytes());
                    localDataOutputStream.write(("--" + BOUNDARY + "--" + "\r\n").getBytes());
                    localDataOutputStream.flush();
                    i = ((HttpURLConnection) localObject).getResponseCode();
                    requestTime = (int) (System.currentTimeMillis() - l);
                    if (i != 200) {
                        break;
                    }
                    paramUri = ((HttpURLConnection) localObject).getInputStream();
                    localObject = new StringBuffer();
                    i = paramUri.read();
                    if (i != -1) {
                        break label299;
                    }
                    paramUri = ((StringBuffer) localObject).toString();
                    sendMessage(1, "Upload Result : " + paramUri);
                    return;
                }
            } catch (Exception paramUri) {
                sendMessage(4, "Upload Failed. Error : " + paramUri.getMessage());
                return;
            }
            localDataOutputStream.write(paramUri.toByteArray(), i, 1024);
            i += 1024;
            this.onUploadProcessListener.onUploadProcess(i);
            continue;
            label299:
            ((StringBuffer) localObject).append((char) i);
        }
        sendMessage(4, "Upload Failed. Code : " + i);
    }

    public int getConnectTimeout() {
        return this.connectTimeOut;
    }

    public int getReadTimeOut() {
        return this.readTimeOut;
    }

    public void setConnectTimeout(int paramInt) {
        this.connectTimeOut = paramInt;
    }

    public void setOnUploadProcessListener(OnUploadProcessListener paramOnUploadProcessListener) {
        this.onUploadProcessListener = paramOnUploadProcessListener;
    }

    public void setReadTimeOut(int paramInt) {
        this.readTimeOut = paramInt;
    }

    public void uploadAvatarToTapatalk(final Uri paramUri) {
        if (Util.isEmpty(paramUri)) {
            sendMessage(2, "File Not Exists");
            return;
        }
        try {
            new Thread(new Runnable() {
                public void run() {
                    UploadAvatarAction.this.toUploadAvatar(paramUri);
                }
            }).start();
            return;
        } catch (Exception paramUri) {
        }
    }

    public static abstract interface OnUploadProcessListener {
        public abstract void initUpload(int paramInt);

        public abstract void onUploadDone(int paramInt, String paramString);

        public abstract void onUploadProcess(int paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/UploadAvatarAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */