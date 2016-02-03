package com.wbtech.ums;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.format.Time;
import android.widget.ProgressBar;
import com.wbtech.ums.common.CommonUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UpdateManager {
    private static final int DOWN_OVER = 2;
    private static final int DOWN_UPDATE = 1;
    private static String Msg = "Found  new version ， update?";
    public static String apkUrl;
    private static Thread downLoadThread;
    public static String force;
    private static boolean interceptFlag = false;
    public static Context mContext;
    private static Handler mHandler;
    private static ProgressBar mProgress;
    private static Runnable mdownApkRunnable = new Runnable() {
        public void run() {
            try {
                Object localObject = (HttpURLConnection) new URL(UpdateManager.apkUrl).openConnection();
                ((HttpURLConnection) localObject).connect();
                int j = ((HttpURLConnection) localObject).getContentLength();
                localObject = ((HttpURLConnection) localObject).getInputStream();
                new File("/sdcard/");
                if (!Environment.getExternalStorageState().equals("mounted")) {
                    UpdateManager.showSdDialog(UpdateManager.mContext);
                }
                FileOutputStream localFileOutputStream = new FileOutputStream(new File(UpdateManager.saveFile));
                int i = 0;
                byte[] arrayOfByte = new byte['Ѐ'];
                int k = ((InputStream) localObject).read(arrayOfByte);
                i += k;
                UpdateManager.progress = (int) (i / j * 100.0F);
                UpdateManager.mHandler.sendEmptyMessage(1);
                if (k <= 0) {
                    UpdateManager.progressDialog.dismiss();
                    UpdateManager.mHandler.sendEmptyMessage(2);
                }
                for (; ; ) {
                    localFileOutputStream.close();
                    ((InputStream) localObject).close();
                    return;
                    localFileOutputStream.write(arrayOfByte, 0, k);
                    boolean bool = UpdateManager.interceptFlag;
                    if (!bool) {
                        break;
                    }
                }
                return;
            } catch (MalformedURLException localMalformedURLException) {
                localMalformedURLException.printStackTrace();
                return;
            } catch (IOException localIOException) {
                localIOException.printStackTrace();
            }
        }
    };
    public static String nametimeString;
    private static Dialog noticeDialog;
    private static int progress = 0;
    public static ProgressDialog progressDialog;
    private static String saveFile;
    private static final String savePath = "/sdcard/";
    private static String updateMsg = null;
    String appkey;
    public String newVersion;
    public String newtime;

    static {
        apkUrl = null;
        saveFile = null;
        interceptFlag = false;
        mHandler = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                switch (paramAnonymousMessage.what) {
                    default:
                        return;
                    case 1:
                        UpdateManager.progressDialog.setProgress(UpdateManager.progress);
                        return;
                }
                UpdateManager.access$1();
            }
        };
        nametimeString = now();
    }

    public UpdateManager(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
        this.appkey = CommonUtil.getAppKey(paramContext);
        this.newVersion = paramString1;
        force = paramString2;
        apkUrl = paramString3;
        mContext = paramContext;
        updateMsg = Msg + "\n" + paramString1 + ":" + paramString4;
        saveFile = "/sdcard/" + nametimeString;
    }

    private static void downloadApk() {
        downLoadThread = new Thread(mdownApkRunnable);
        downLoadThread.start();
    }

    private static void installApk() {
        File localFile = new File(saveFile);
        if (!localFile.exists()) {
            return;
        }
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setDataAndType(Uri.parse("file://" + localFile.toString()), "application/vnd.android.package-archive");
        mContext.startActivity(localIntent);
    }

    public static String now() {
        Time localTime = new Time("Asia/Beijing");
        localTime.setToNow();
        return localTime.format("%Y-%m-%d");
    }

    private static void showDownloadDialog(Context paramContext) {
        progressDialog = new ProgressDialog(paramContext);
        progressDialog.setTitle("Update software");
        progressDialog.setProgressStyle(1);
        progressDialog.setButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface.dismiss();
                UpdateManager.interceptFlag = true;
            }
        });
        progressDialog.show();
        downloadApk();
    }

    public static void showNoticeDialog(Context paramContext) {
        System.out.println(apkUrl);
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
        localBuilder.setTitle("Update software");
        localBuilder.setMessage(updateMsg);
        localBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface.dismiss();
                UpdateManager.showDownloadDialog(UpdateManager.this);
            }
        });
        localBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (UpdateManager.force.equals("true")) {
                    System.exit(0);
                    return;
                }
                paramAnonymousDialogInterface.dismiss();
            }
        });
        noticeDialog = localBuilder.create();
        noticeDialog.show();
    }

    public static void showSdDialog(Context paramContext) {
        paramContext = new AlertDialog.Builder(paramContext);
        paramContext.setTitle("point");
        paramContext.setMessage("SD card does not exist");
        paramContext.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                System.exit(0);
            }
        });
        noticeDialog = paramContext.create();
        noticeDialog.show();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/wbtech/ums/UpdateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */