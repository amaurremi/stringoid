package com.quoord.tools;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TapatalkLog {
    private static String MYLOGFILEName;
    private static String MYLOG_PATH_SDCARD_DIR;
    private static Boolean MYLOG_SWITCH = Boolean.valueOf(false);
    private static char MYLOG_TYPE;
    private static Boolean MYLOG_WRITE_TO_FILE = Boolean.valueOf(false);
    private static int SDCARD_LOG_FILE_SAVE_DAYS;
    private static SimpleDateFormat logfile = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat myLogSdf;

    static {
        MYLOG_TYPE = 'v';
        MYLOG_PATH_SDCARD_DIR = "/sdcard/tapatalkLog";
        SDCARD_LOG_FILE_SAVE_DAYS = 0;
        MYLOGFILEName = "Log.txt";
        myLogSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static void d(String paramString, Object paramObject) {
        log(paramString, paramObject.toString(), 'd');
    }

    public static void d(String paramString1, String paramString2) {
        log(paramString1, paramString2, 'd');
    }

    public static void delFile() {
        Object localObject = logfile.format(getDateBefore());
        localObject = new File(MYLOG_PATH_SDCARD_DIR, localObject + MYLOGFILEName);
        if (((File) localObject).exists()) {
            ((File) localObject).delete();
        }
    }

    public static void e(String paramString, Object paramObject) {
        log(paramString, paramObject.toString(), 'e');
    }

    public static void e(String paramString1, String paramString2) {
        log(paramString1, paramString2, 'e');
    }

    private static Date getDateBefore() {
        Date localDate = new Date();
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(localDate);
        localCalendar.set(5, localCalendar.get(5) - SDCARD_LOG_FILE_SAVE_DAYS);
        return localCalendar.getTime();
    }

    public static void i(String paramString, Object paramObject) {
        log(paramString, paramObject.toString(), 'i');
    }

    public static void i(String paramString1, String paramString2) {
        log(paramString1, paramString2, 'i');
    }

    private static void log(String paramString1, String paramString2, char paramChar) {
        if (MYLOG_SWITCH.booleanValue()) {
            if (('e' != paramChar) || (('e' != MYLOG_TYPE) && ('v' != MYLOG_TYPE))) {
                break label56;
            }
            Log.e(paramString1, paramString2);
        }
        for (; ; ) {
            if (MYLOG_WRITE_TO_FILE.booleanValue()) {
                writeLogtoFile(String.valueOf(paramChar), paramString1, paramString2);
            }
            return;
            label56:
            if (('w' == paramChar) && (('w' == MYLOG_TYPE) || ('v' == MYLOG_TYPE))) {
                Log.w(paramString1, paramString2);
            } else if (('d' == paramChar) && (('d' == MYLOG_TYPE) || ('v' == MYLOG_TYPE))) {
                Log.d(paramString1, paramString2);
            } else if (('i' == paramChar) && (('d' == MYLOG_TYPE) || ('v' == MYLOG_TYPE))) {
                Log.i(paramString1, paramString2);
            } else {
                Log.v(paramString1, paramString2);
            }
        }
    }

    public static void v(String paramString, Object paramObject) {
        log(paramString, paramObject.toString(), 'v');
    }

    public static void v(String paramString1, String paramString2) {
        log(paramString1, paramString2, 'v');
    }

    public static void w(String paramString, Object paramObject) {
        log(paramString, paramObject.toString(), 'w');
    }

    public static void w(String paramString1, String paramString2) {
        log(paramString1, paramString2, 'w');
    }

    private static void writeLogtoFile(String paramString1, String paramString2, String paramString3) {
        Date localDate = new Date();
        String str = logfile.format(localDate);
        paramString1 = myLogSdf.format(localDate) + "    " + paramString1 + "    " + paramString2 + "    " + paramString3;
        paramString2 = new File(MYLOG_PATH_SDCARD_DIR);
        if (!paramString2.exists()) {
            paramString2.mkdir();
        }
        paramString2 = new File(MYLOG_PATH_SDCARD_DIR, str + MYLOGFILEName);
        try {
            paramString2 = new FileWriter(paramString2, true);
            paramString3 = new BufferedWriter(paramString2);
            paramString3.write(paramString1);
            paramString3.newLine();
            paramString3.close();
            paramString2.close();
            return;
        } catch (IOException paramString1) {
            paramString1.printStackTrace();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/TapatalkLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */