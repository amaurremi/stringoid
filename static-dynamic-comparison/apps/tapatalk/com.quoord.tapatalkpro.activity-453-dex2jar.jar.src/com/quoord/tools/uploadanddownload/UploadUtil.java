package com.quoord.tools.uploadanddownload;

import com.quoord.tapatalkpro.util.Util;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;

public class UploadUtil {
    private static final String BOUNDARY = UUID.randomUUID().toString();
    private static final String CHARSET = "utf-8";
    private static final String CONTENT_TYPE = "multipart/form-data";
    private static final String LINE_END = "\r\n";
    private static final String PREFIX = "--";
    public static final int UPLOAD_FILE_NOT_EXISTS_CODE = 2;
    public static final int UPLOAD_SERVER_ERROR_CODE = 4;
    public static final int UPLOAD_SUCCESS_CODE = 1;
    private static long requestTime = 0L;
    private static UploadUtil uploadUtil = null;
    private int connectTimeOut = 10000;
    private OnUploadProcessListener onUploadProcessListener;
    private int readTimeOut = 10000;

    public static UploadUtil getInstance() {
        if (uploadUtil == null) {
            uploadUtil = new UploadUtil();
        }
        return uploadUtil;
    }

    public static long getRequestTime() {
        return requestTime;
    }

    private void sendMessage(int paramInt, String paramString) {
        this.onUploadProcessListener.onUploadDone(paramInt, paramString);
    }

    private void toUploadFile(File paramFile, String paramString1, String paramString2) {
        requestTime = 0L;
        requestTime = System.currentTimeMillis();
        int i;
        for (; ; ) {
            try {
                Object localObject = new URL(paramString2);
                int j;
                if (paramString2.startsWith("https")) {
                    Util.trustAllHosts();
                    paramString2 = (HttpsURLConnection) ((URL) localObject).openConnection();
                    paramString2.setHostnameVerifier(Util.DO_NOT_VERIFY);
                    paramString2.setReadTimeout(this.readTimeOut);
                    paramString2.setConnectTimeout(this.connectTimeOut);
                    paramString2.setDoInput(true);
                    paramString2.setDoOutput(true);
                    paramString2.setUseCaches(false);
                    paramString2.setRequestMethod("POST");
                    paramString2.setRequestProperty("Charset", "utf-8");
                    paramString2.setRequestProperty("connection", "keep-alive");
                    paramString2.setRequestProperty("Content-Type", "multipart/form-data");
                    localObject = new DataOutputStream(paramString2.getOutputStream());
                    StringBuffer localStringBuffer = new StringBuffer();
                    localStringBuffer.append("--").append(BOUNDARY).append("\r\n");
                    localStringBuffer.append("Content-Disposition:form-data; name=\"" + paramString1 + "\"; filename=\"" + paramFile.getName() + "\"" + "\r\n");
                    localStringBuffer.append("Content-Type:image/pjpeg\r\n");
                    localStringBuffer.append("\r\n");
                    ((DataOutputStream) localObject).write(localStringBuffer.toString().getBytes());
                    paramString1 = new FileInputStream(paramFile);
                    this.onUploadProcessListener.initUpload((int) paramFile.length());
                    paramFile = new byte['Ѐ'];
                    i = 0;
                    j = paramString1.read(paramFile);
                    if (j == -1) {
                        paramString1.close();
                        ((DataOutputStream) localObject).write("\r\n".getBytes());
                        ((DataOutputStream) localObject).write(("--" + BOUNDARY + "--" + "\r\n").getBytes());
                        ((DataOutputStream) localObject).flush();
                        i = paramString2.getResponseCode();
                        requestTime = (int) ((System.currentTimeMillis() - requestTime) / 1000L);
                        if (i != 200) {
                            break;
                        }
                        paramFile = paramString2.getInputStream();
                        paramString1 = new StringBuffer();
                        i = paramFile.read();
                        if (i != -1) {
                            break label473;
                        }
                        paramFile = paramString1.toString();
                        sendMessage(1, "Upload Result : " + paramFile);
                    }
                } else {
                    paramString2 = (HttpURLConnection) ((URL) localObject).openConnection();
                    continue;
                }
                i += j;
                ((DataOutputStream) localObject).write(paramFile, 0, j);
                this.onUploadProcessListener.onUploadProcess(i);
                continue;
                c = (char) i;
            } catch (Exception paramFile) {
                sendMessage(4, "Upload Failed. Error : " + paramFile.getMessage());
                return;
            }
            label473:
            char c;
            paramString1.append(c);
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

    public void uploadFile(final File paramFile, final String paramString1, final String paramString2) {
        if ((paramFile == null) || (!paramFile.exists())) {
            sendMessage(2, "File Not Exists");
            return;
        }
        new Thread(new Runnable() {
            public void run() {
                UploadUtil.this.toUploadFile(paramFile, paramString1, paramString2);
            }
        }).start();
    }

    public void uploadFile(String paramString1, String paramString2, String paramString3) {
        if (paramString1 == null) {
            sendMessage(2, "File Not Exists");
            return;
        }
        try {
            uploadFile(new File(paramString1), paramString2, paramString3);
            return;
        } catch (Exception paramString1) {
            sendMessage(2, "File Not Exists");
        }
    }

    public static abstract interface OnUploadProcessListener {
        public abstract void initUpload(int paramInt);

        public abstract void onUploadDone(int paramInt, String paramString);

        public abstract void onUploadProcess(int paramInt);
    }

    public static abstract interface uploadProcessListener {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/uploadanddownload/UploadUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */