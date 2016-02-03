package com.wbtech.ums.common;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.wbtech.ums.UmsAgent;
import com.wbtech.ums.objects.MyMessage;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.json.JSONException;
import org.json.JSONObject;

public class MyCrashHandler
        implements Thread.UncaughtExceptionHandler {
    private static MyCrashHandler myCrashHandler;
    private String activities;
    private String appkey;
    private Context context;
    private String os_version;
    private Object stacktrace;
    private String time;

    private String getErrorInfo(Throwable paramThrowable) {
        StringWriter localStringWriter = new StringWriter();
        PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
        paramThrowable.printStackTrace(localPrintWriter);
        localPrintWriter.close();
        return localStringWriter.toString();
    }

    private JSONObject getErrorInfoJSONString(Context paramContext) {
        JSONObject localJSONObject = new JSONObject();
        try {
            new Build();
            localJSONObject.put("stacktrace", this.stacktrace);
            localJSONObject.put("time", this.time);
            localJSONObject.put("version", CommonUtil.getVersion(paramContext));
            localJSONObject.put("activity", this.activities);
            localJSONObject.put("appkey", this.appkey);
            localJSONObject.put("os_version", this.os_version);
            localJSONObject.put("deviceid", Build.MANUFACTURER + Build.PRODUCT);
            return localJSONObject;
        } catch (JSONException paramContext) {
            paramContext.printStackTrace();
        }
        return localJSONObject;
    }

    /* Error */
    public static MyCrashHandler getInstance() {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 113	com/wbtech/ums/common/MyCrashHandler:myCrashHandler	Lcom/wbtech/ums/common/MyCrashHandler;
        //   6: ifnull +12 -> 18
        //   9: getstatic 113	com/wbtech/ums/common/MyCrashHandler:myCrashHandler	Lcom/wbtech/ums/common/MyCrashHandler;
        //   12: astore_0
        //   13: ldc 2
        //   15: monitorexit
        //   16: aload_0
        //   17: areturn
        //   18: new 2	com/wbtech/ums/common/MyCrashHandler
        //   21: dup
        //   22: invokespecial 114	com/wbtech/ums/common/MyCrashHandler:<init>	()V
        //   25: putstatic 113	com/wbtech/ums/common/MyCrashHandler:myCrashHandler	Lcom/wbtech/ums/common/MyCrashHandler;
        //   28: getstatic 113	com/wbtech/ums/common/MyCrashHandler:myCrashHandler	Lcom/wbtech/ums/common/MyCrashHandler;
        //   31: astore_0
        //   32: goto -19 -> 13
        //   35: astore_0
        //   36: ldc 2
        //   38: monitorexit
        //   39: aload_0
        //   40: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   12	20	0	localMyCrashHandler	MyCrashHandler
        //   35	5	0	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   3	13	35	finally
        //   18	32	35	finally
    }

    public void init(Context paramContext) {
        this.context = paramContext;
    }

    public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
        paramThread = getErrorInfo(paramThrowable);
        paramThrowable = paramThread.substring(paramThread.indexOf("Caused by:")).split("\n\t");
        this.stacktrace = (new StringBuilder(String.valueOf(paramThrowable[0])).append("\n\t").append(paramThrowable[1]).append("\n\t").append(paramThrowable[2]).append("\n\t").toString() + paramThread);
        this.activities = CommonUtil.getActivityName(this.context);
        this.time = CommonUtil.getTime();
        this.appkey = CommonUtil.getAppKey(this.context);
        this.os_version = CommonUtil.getOsVersion(this.context);
        paramThread = getErrorInfoJSONString(this.context);
        CommonUtil.printLog("UmsAgent", paramThread.toString());
        if ((1 == CommonUtil.getReportPolicyMode(this.context)) && (CommonUtil.isNetworkAvailable(this.context))) {
            if (!this.stacktrace.equals("")) {
                paramThrowable = NetworkUitlity.post(UmsConstants.preUrl + "/ums/postErrorLog", paramThread.toString());
                CommonUtil.printLog("UmsAgent", paramThrowable.getMsg());
                if (!paramThrowable.isFlag()) {
                    UmsAgent.saveInfoToFile("errorInfo", paramThread, this.context);
                    CommonUtil.printLog("error", paramThrowable.getMsg());
                }
            }
        }
        for (; ; ) {
            Process.killProcess(Process.myPid());
            return;
            UmsAgent.saveInfoToFile("errorInfo", paramThread, this.context);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/wbtech/ums/common/MyCrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */