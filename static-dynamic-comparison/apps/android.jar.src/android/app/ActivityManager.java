/*     */
package android.app;
/*     */ 
/*     */

import android.os.Parcel;

/*     */
/*     */ public class ActivityManager {
    public static final int RECENT_WITH_EXCLUDED = 1;

    /*     */
/*   7 */   public static class RecentTaskInfo implements android.os.Parcelable {
        public RecentTaskInfo() {
            throw new RuntimeException("Stub!");
        }

        /*   8 */
        public int describeContents() {
            throw new RuntimeException("Stub!");
        }

        /*   9 */
        public void writeToParcel(Parcel dest, int flags) {
            throw new RuntimeException("Stub!");
        }

        /*  10 */
        public void readFromParcel(Parcel source) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */     public int id;
        /*     */     public int persistentId;
        /*     */     public android.content.Intent baseIntent;
        /*     */     public android.content.ComponentName origActivity;
        /*     */     public CharSequence description;
        /*  17 */     public static final android.os.Parcelable.Creator<RecentTaskInfo> CREATOR = null;
/*     */
    }

    /*     */
/*     */   public static class RunningTaskInfo implements android.os.Parcelable {
        public int id;

        /*     */
/*  22 */
        public RunningTaskInfo() {
            throw new RuntimeException("Stub!");
        }

        /*  23 */
        public int describeContents() {
            throw new RuntimeException("Stub!");
        }

        /*  24 */
        public void writeToParcel(Parcel dest, int flags) {
            throw new RuntimeException("Stub!");
        }

        /*  25 */
        public void readFromParcel(Parcel source) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */     public android.content.ComponentName baseActivity;
        /*     */     public android.content.ComponentName topActivity;
        /*     */     public android.graphics.Bitmap thumbnail;
        /*     */     public CharSequence description;
        /*     */     public int numActivities;
        /*     */     public int numRunning;
        /*  34 */     public static final android.os.Parcelable.Creator<RunningTaskInfo> CREATOR = null;
    }

    /*     */
/*     */   public static final int RECENT_IGNORE_UNAVAILABLE = 2;

    /*     */   public static class RunningServiceInfo implements android.os.Parcelable {
        public android.content.ComponentName service;

        /*     */
/*  39 */
        public RunningServiceInfo() {
            throw new RuntimeException("Stub!");
        }

        /*  40 */
        public int describeContents() {
            throw new RuntimeException("Stub!");
        }

        /*  41 */
        public void writeToParcel(Parcel dest, int flags) {
            throw new RuntimeException("Stub!");
        }

        /*  42 */
        public void readFromParcel(Parcel source) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */     public int pid;
        /*     */     public int uid;
        /*     */     public String process;
        /*     */     public boolean foreground;
        /*     */     public long activeSince;
        /*     */     public boolean started;
        /*     */     public int clientCount;
        /*     */     public int crashCount;
        /*     */     public long lastActivityTime;
        /*     */     public long restarting;
        /*     */     public static final int FLAG_STARTED = 1;
        /*     */     public static final int FLAG_FOREGROUND = 2;
        /*     */     public static final int FLAG_SYSTEM_PROCESS = 4;
        /*     */     public static final int FLAG_PERSISTENT_PROCESS = 8;
        /*     */     public int flags;
        /*     */     public String clientPackage;
        /*     */     public int clientLabel;
        /*  62 */     public static final android.os.Parcelable.Creator<RunningServiceInfo> CREATOR = null;
    }

    /*     */
/*     */   public static class MemoryInfo implements android.os.Parcelable {
        public long availMem;
        /*     */     public long totalMem;

        /*     */
/*  67 */
        public MemoryInfo() {
            throw new RuntimeException("Stub!");
        }

        /*  68 */
        public int describeContents() {
            throw new RuntimeException("Stub!");
        }

        /*  69 */
        public void writeToParcel(Parcel dest, int flags) {
            throw new RuntimeException("Stub!");
        }

        /*  70 */
        public void readFromParcel(Parcel source) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */     public long threshold;
        /*     */
/*     */     public boolean lowMemory;
        /*  76 */     public static final android.os.Parcelable.Creator<MemoryInfo> CREATOR = null;
    }

    /*     */
/*     */   public static class ProcessErrorStateInfo implements android.os.Parcelable {
        public static final int NO_ERROR = 0;
        /*     */     public static final int CRASHED = 1;

        /*     */
/*  81 */
        public ProcessErrorStateInfo() {
            throw new RuntimeException("Stub!");
        }

        /*  82 */
        public int describeContents() {
            throw new RuntimeException("Stub!");
        }

        /*  83 */
        public void writeToParcel(Parcel dest, int flags) {
            throw new RuntimeException("Stub!");
        }

        /*  84 */
        public void readFromParcel(Parcel source) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */     public static final int NOT_RESPONDING = 2;
        /*     */     public int condition;
        /*     */     public String processName;
        /*     */     public int pid;
        /*     */     public int uid;
        /*     */     public String tag;
        /*     */     public String shortMsg;
        /*     */     public String longMsg;
        /*     */     public String stackTrace;
        /*  96 */     public byte[] crashData = null;
        /*     */
/*  98 */     public static final android.os.Parcelable.Creator<ProcessErrorStateInfo> CREATOR = null;
/*     */
    }

    /*     */
/*     */   public static class RunningAppProcessInfo implements android.os.Parcelable {
        public String processName;

        /*     */
/* 103 */
        public RunningAppProcessInfo() {
            throw new RuntimeException("Stub!");
        }

        /* 104 */
        public RunningAppProcessInfo(String pProcessName, int pPid, String[] pArr) {
            throw new RuntimeException("Stub!");
        }

        /* 105 */
        public int describeContents() {
            throw new RuntimeException("Stub!");
        }

        /* 106 */
        public void writeToParcel(Parcel dest, int flags) {
            throw new RuntimeException("Stub!");
        }

        /* 107 */
        public void readFromParcel(Parcel source) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */     public int pid;
        /*     */     public int uid;
        /* 111 */     public String[] pkgList = null;
        /*     */
/*     */     public int lastTrimLevel;
        /*     */     public static final int IMPORTANCE_FOREGROUND = 100;
        /*     */     public static final int IMPORTANCE_VISIBLE = 200;
        /*     */     public static final int IMPORTANCE_PERCEPTIBLE = 130;
        /*     */     public static final int IMPORTANCE_SERVICE = 300;
        /*     */     public static final int IMPORTANCE_BACKGROUND = 400;
        /*     */     public static final int IMPORTANCE_EMPTY = 500;
        /*     */     public int importance;
        /*     */     public int lru;
        /*     */     public static final int REASON_UNKNOWN = 0;
        /*     */     public static final int REASON_PROVIDER_IN_USE = 1;
        /*     */     public static final int REASON_SERVICE_IN_USE = 2;
        /*     */     public int importanceReasonCode;
        /*     */     public int importanceReasonPid;
        /*     */     public android.content.ComponentName importanceReasonComponent;
        /* 128 */     public static final android.os.Parcelable.Creator<RunningAppProcessInfo> CREATOR = null;
    }

    /*     */
/* 130 */   ActivityManager() {
        throw new RuntimeException("Stub!");
    }

    /* 131 */
    public int getMemoryClass() {
        throw new RuntimeException("Stub!");
    }

    /* 132 */
    public int getLargeMemoryClass() {
        throw new RuntimeException("Stub!");
    }

    /* 133 */
    public java.util.List<RecentTaskInfo> getRecentTasks(int maxNum, int flags) throws SecurityException {
        throw new RuntimeException("Stub!");
    }

    /* 134 */
    public java.util.List<RunningTaskInfo> getRunningTasks(int maxNum) throws SecurityException {
        throw new RuntimeException("Stub!");
    }

    /* 135 */
    public void moveTaskToFront(int taskId, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 136 */
    public void moveTaskToFront(int taskId, int flags, android.os.Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 137 */
    public java.util.List<RunningServiceInfo> getRunningServices(int maxNum) throws SecurityException {
        throw new RuntimeException("Stub!");
    }

    /* 138 */
    public PendingIntent getRunningServiceControlPanel(android.content.ComponentName service) throws SecurityException {
        throw new RuntimeException("Stub!");
    }

    /* 139 */
    public void getMemoryInfo(MemoryInfo outInfo) {
        throw new RuntimeException("Stub!");
    }

    /* 140 */
    public java.util.List<ProcessErrorStateInfo> getProcessesInErrorState() {
        throw new RuntimeException("Stub!");
    }

    /* 141 */
    public java.util.List<RunningAppProcessInfo> getRunningAppProcesses() {
        throw new RuntimeException("Stub!");
    }

    /* 142 */
    public static void getMyMemoryState(RunningAppProcessInfo outState) {
        throw new RuntimeException("Stub!");
    }

    /* 143 */
    public android.os.Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 145 */ public void restartPackage(String packageName) {
        throw new RuntimeException("Stub!");
    }

    /* 146 */
    public void killBackgroundProcesses(String packageName) {
        throw new RuntimeException("Stub!");
    }

    /* 147 */
    public android.content.pm.ConfigurationInfo getDeviceConfigurationInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 148 */
    public int getLauncherLargeIconDensity() {
        throw new RuntimeException("Stub!");
    }

    /* 149 */
    public int getLauncherLargeIconSize() {
        throw new RuntimeException("Stub!");
    }

    /* 150 */
    public static boolean isUserAMonkey() {
        throw new RuntimeException("Stub!");
    }

    /* 151 */
    public static boolean isRunningInTestHarness() {
        throw new RuntimeException("Stub!");
    }

    /*     */
/*     */   public static final int MOVE_TASK_WITH_HOME = 1;
    /*     */   public static final int MOVE_TASK_NO_USER_ACTION = 2;
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/ActivityManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */