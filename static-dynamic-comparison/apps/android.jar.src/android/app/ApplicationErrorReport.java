/*    */
package android.app;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*    */ public class ApplicationErrorReport implements android.os.Parcelable {
    public static final int TYPE_NONE = 0;

    /*    */   public static class CrashInfo {
        public String exceptionClassName;
        public String exceptionMessage;
        public String throwFileName;
        public String throwClassName;

        /*  7 */
        public CrashInfo() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public CrashInfo(Throwable tr) {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public CrashInfo(Parcel in) {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public void writeToParcel(Parcel dest, int flags) {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public void dump(android.util.Printer pw, String prefix) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public String throwMethodName;
        /*    */     public int throwLineNumber;
        /*    */     public String stackTrace;
/*    */
    }

    /*    */
/*    */   public static class AnrInfo {
        /*    */     public String activity;
        /*    */     public String cause;

        /*    */
/* 22 */
        public AnrInfo() {
            throw new RuntimeException("Stub!");
        }

        /* 23 */
        public AnrInfo(Parcel in) {
            throw new RuntimeException("Stub!");
        }

        /* 24 */
        public void writeToParcel(Parcel dest, int flags) {
            throw new RuntimeException("Stub!");
        }

        /* 25 */
        public void dump(android.util.Printer pw, String prefix) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public String info;
    }

    /*    */
/*    */   public static class BatteryInfo {
        public int usagePercent;
        /*    */     public long durationMicros;

        /*    */
/* 32 */
        public BatteryInfo() {
            throw new RuntimeException("Stub!");
        }

        /* 33 */
        public BatteryInfo(Parcel in) {
            throw new RuntimeException("Stub!");
        }

        /* 34 */
        public void writeToParcel(Parcel dest, int flags) {
            throw new RuntimeException("Stub!");
        }

        /* 35 */
        public void dump(android.util.Printer pw, String prefix) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public String usageDetails;
        /*    */     public String checkinDetails;
/*    */
    }

    /*    */
/*    */   public static class RunningServiceInfo {
        public long durationMillis;

        /*    */
/* 43 */
        public RunningServiceInfo() {
            throw new RuntimeException("Stub!");
        }

        /* 44 */
        public RunningServiceInfo(Parcel in) {
            throw new RuntimeException("Stub!");
        }

        /* 45 */
        public void writeToParcel(Parcel dest, int flags) {
            throw new RuntimeException("Stub!");
        }

        /* 46 */
        public void dump(android.util.Printer pw, String prefix) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public String serviceDetails;
    }

    /*    */
/* 50 */
    public ApplicationErrorReport() {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public static android.content.ComponentName getErrorReportReceiver(android.content.Context context, String packageName, int appFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void readFromParcel(Parcel in) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public void dump(android.util.Printer pw, String prefix) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/*    */   public static final int TYPE_CRASH = 1;
    /*    */   public static final int TYPE_ANR = 2;
    /*    */   public static final int TYPE_BATTERY = 3;
    /*    */   public static final int TYPE_RUNNING_SERVICE = 5;
    /*    */   public int type;
    /*    */   public String packageName;
    /*    */   public String installerPackageName;
    /*    */   public String processName;
    /*    */   public long time;
    /*    */   public boolean systemApp;
    /*    */   public CrashInfo crashInfo;
    /*    */   public AnrInfo anrInfo;
    /*    */   public BatteryInfo batteryInfo;
    /*    */   public RunningServiceInfo runningServiceInfo;
    /* 72 */   public static final android.os.Parcelable.Creator<ApplicationErrorReport> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/ApplicationErrorReport.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */