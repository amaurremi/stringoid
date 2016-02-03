/*    */
package android.bluetooth;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*    */ public final class BluetoothClass implements android.os.Parcelable {
    public static final class Service {
        public static final int LIMITED_DISCOVERABILITY = 8192;
        /*    */     public static final int POSITIONING = 65536;
        public static final int NETWORKING = 131072;
        public static final int RENDER = 262144;
        public static final int CAPTURE = 524288;

        /*  7 */
        public Service() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public static final int OBJECT_TRANSFER = 1048576;
        /*    */     public static final int AUDIO = 2097152;
        /*    */     public static final int TELEPHONY = 4194304;
        /*    */     public static final int INFORMATION = 8388608;
    }

    /*    */
/*    */   public static class Device {
        public static final int COMPUTER_UNCATEGORIZED = 256;
        /*    */     public static final int COMPUTER_DESKTOP = 260;
        /*    */     public static final int COMPUTER_SERVER = 264;

        /*    */
/*    */     public static class Major {
            public static final int MISC = 0;
            /*    */       public static final int COMPUTER = 256;
            /*    */       public static final int PHONE = 512;
            /*    */       public static final int NETWORKING = 768;
            public static final int AUDIO_VIDEO = 1024;
            public static final int PERIPHERAL = 1280;

            /* 22 */
            public Major() {
                throw new RuntimeException("Stub!");
            }

            /*    */
/*    */ 
/*    */       public static final int IMAGING = 1536;
            /*    */
/*    */       public static final int WEARABLE = 1792;
            /*    */       public static final int TOY = 2048;
            /*    */       public static final int HEALTH = 2304;
            /*    */       public static final int UNCATEGORIZED = 7936;
/*    */
        }

        /*    */
/*    */
        public Device()
/*    */ {
/* 35 */
            throw new RuntimeException("Stub!");
/*    */
        }

        /*    */
/*    */     public static final int COMPUTER_LAPTOP = 268;
        /*    */     public static final int COMPUTER_HANDHELD_PC_PDA = 272;
        /*    */     public static final int COMPUTER_PALM_SIZE_PC_PDA = 276;
        /*    */     public static final int COMPUTER_WEARABLE = 280;
        /*    */     public static final int PHONE_UNCATEGORIZED = 512;
        /*    */     public static final int PHONE_CELLULAR = 516;
        /*    */     public static final int PHONE_CORDLESS = 520;
        /*    */     public static final int PHONE_SMART = 524;
        /*    */     public static final int PHONE_MODEM_OR_GATEWAY = 528;
        /*    */     public static final int PHONE_ISDN = 532;
        /*    */     public static final int AUDIO_VIDEO_UNCATEGORIZED = 1024;
        /*    */     public static final int AUDIO_VIDEO_WEARABLE_HEADSET = 1028;
        /*    */     public static final int AUDIO_VIDEO_HANDSFREE = 1032;
        /*    */     public static final int AUDIO_VIDEO_MICROPHONE = 1040;
        /*    */     public static final int AUDIO_VIDEO_LOUDSPEAKER = 1044;
        /*    */     public static final int AUDIO_VIDEO_HEADPHONES = 1048;
        /*    */     public static final int AUDIO_VIDEO_PORTABLE_AUDIO = 1052;
        /*    */     public static final int AUDIO_VIDEO_CAR_AUDIO = 1056;
        /*    */     public static final int AUDIO_VIDEO_SET_TOP_BOX = 1060;
        /*    */     public static final int AUDIO_VIDEO_HIFI_AUDIO = 1064;
        /*    */     public static final int AUDIO_VIDEO_VCR = 1068;
        /*    */     public static final int AUDIO_VIDEO_VIDEO_CAMERA = 1072;
        /*    */     public static final int AUDIO_VIDEO_CAMCORDER = 1076;
        /*    */     public static final int AUDIO_VIDEO_VIDEO_MONITOR = 1080;
        /*    */     public static final int AUDIO_VIDEO_VIDEO_DISPLAY_AND_LOUDSPEAKER = 1084;
        /*    */     public static final int AUDIO_VIDEO_VIDEO_CONFERENCING = 1088;
        /*    */     public static final int AUDIO_VIDEO_VIDEO_GAMING_TOY = 1096;
        /*    */     public static final int WEARABLE_UNCATEGORIZED = 1792;
        /*    */     public static final int WEARABLE_WRIST_WATCH = 1796;
        /*    */     public static final int WEARABLE_PAGER = 1800;
        /*    */     public static final int WEARABLE_JACKET = 1804;
        /*    */     public static final int WEARABLE_HELMET = 1808;
        /*    */     public static final int WEARABLE_GLASSES = 1812;
        /*    */     public static final int TOY_UNCATEGORIZED = 2048;
        /*    */     public static final int TOY_ROBOT = 2052;
        /*    */     public static final int TOY_VEHICLE = 2056;
        /*    */     public static final int TOY_DOLL_ACTION_FIGURE = 2060;
        /*    */     public static final int TOY_CONTROLLER = 2064;
        /*    */     public static final int TOY_GAME = 2068;
        /*    */     public static final int HEALTH_UNCATEGORIZED = 2304;
        /*    */     public static final int HEALTH_BLOOD_PRESSURE = 2308;
        /*    */     public static final int HEALTH_THERMOMETER = 2312;
        /*    */     public static final int HEALTH_WEIGHING = 2316;
        /*    */     public static final int HEALTH_GLUCOSE = 2320;
        /*    */     public static final int HEALTH_PULSE_OXIMETER = 2324;
        /*    */     public static final int HEALTH_PULSE_RATE = 2328;
        /*    */     public static final int HEALTH_DATA_DISPLAY = 2332;
/*    */
    }

    /*    */
/* 87 */   BluetoothClass() {
        throw new RuntimeException("Stub!");
    }

    /* 88 */
    public boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    /* 89 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 90 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 91 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 92 */
    public void writeToParcel(Parcel out, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 93 */
    public boolean hasService(int service) {
        throw new RuntimeException("Stub!");
    }

    /* 94 */
    public int getMajorDeviceClass() {
        throw new RuntimeException("Stub!");
    }

    /* 95 */
    public int getDeviceClass() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 97 */   public static final android.os.Parcelable.Creator<BluetoothClass> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/bluetooth/BluetoothClass.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */