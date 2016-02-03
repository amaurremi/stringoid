/*   */
package android.os;

/*   */
/*   */ public class BatteryManager {
    /* 4 */
    public BatteryManager() {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final String EXTRA_STATUS = "status";
    /*   */   public static final String EXTRA_HEALTH = "health";
    /*   */   public static final String EXTRA_PRESENT = "present";
    /*   */   public static final String EXTRA_LEVEL = "level";
    /*   */   public static final String EXTRA_SCALE = "scale";
    /*   */   public static final String EXTRA_ICON_SMALL = "icon-small";
    /*   */   public static final String EXTRA_PLUGGED = "plugged";
    /*   */   public static final String EXTRA_VOLTAGE = "voltage";
    /*   */   public static final String EXTRA_TEMPERATURE = "temperature";
    /*   */   public static final String EXTRA_TECHNOLOGY = "technology";
    /*   */   public static final int BATTERY_STATUS_UNKNOWN = 1;
    /*   */   public static final int BATTERY_STATUS_CHARGING = 2;
    /*   */   public static final int BATTERY_STATUS_DISCHARGING = 3;
    /*   */   public static final int BATTERY_STATUS_NOT_CHARGING = 4;
    /*   */   public static final int BATTERY_STATUS_FULL = 5;
    /*   */   public static final int BATTERY_HEALTH_UNKNOWN = 1;
    /*   */   public static final int BATTERY_HEALTH_GOOD = 2;
    /*   */   public static final int BATTERY_HEALTH_OVERHEAT = 3;
    /*   */   public static final int BATTERY_HEALTH_DEAD = 4;
    /*   */   public static final int BATTERY_HEALTH_OVER_VOLTAGE = 5;
    /*   */   public static final int BATTERY_HEALTH_UNSPECIFIED_FAILURE = 6;
    /*   */   public static final int BATTERY_HEALTH_COLD = 7;
    /*   */   public static final int BATTERY_PLUGGED_AC = 1;
    /*   */   public static final int BATTERY_PLUGGED_USB = 2;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/BatteryManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */