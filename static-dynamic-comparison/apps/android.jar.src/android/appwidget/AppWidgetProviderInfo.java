/*    */
package android.appwidget;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class AppWidgetProviderInfo implements android.os.Parcelable {
    public AppWidgetProviderInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public AppWidgetProviderInfo(Parcel in) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void writeToParcel(Parcel out, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int RESIZE_NONE = 0;
    /*    */   public static final int RESIZE_HORIZONTAL = 1;
    /*    */   public static final int RESIZE_VERTICAL = 2;
    /*    */   public static final int RESIZE_BOTH = 3;
    /*    */   public android.content.ComponentName provider;
    /*    */   public int minWidth;
    /*    */   public int minHeight;
    /*    */   public int minResizeWidth;
    /*    */   public int minResizeHeight;
    /*    */   public int updatePeriodMillis;
    /*    */   public int initialLayout;
    /*    */   public android.content.ComponentName configure;
    /*    */   public String label;
    /*    */   public int icon;
    /*    */   public int autoAdvanceViewId;
    /*    */   public int previewImage;
    /*    */   public int resizeMode;
    /* 28 */   public static final android.os.Parcelable.Creator<AppWidgetProviderInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/appwidget/AppWidgetProviderInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */