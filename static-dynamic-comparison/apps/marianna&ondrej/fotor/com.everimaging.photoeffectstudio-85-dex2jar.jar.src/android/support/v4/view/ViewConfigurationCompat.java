package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class ViewConfigurationCompat {
    static final ViewConfigurationVersionImpl IMPL = new BaseViewConfigurationVersionImpl();

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new FroyoViewConfigurationVersionImpl();
            return;
        }
    }

    public static int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration) {
        return IMPL.getScaledPagingTouchSlop(paramViewConfiguration);
    }

    static class BaseViewConfigurationVersionImpl
            implements ViewConfigurationCompat.ViewConfigurationVersionImpl {
        public int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration) {
            return paramViewConfiguration.getScaledTouchSlop();
        }
    }

    static class FroyoViewConfigurationVersionImpl
            implements ViewConfigurationCompat.ViewConfigurationVersionImpl {
        public int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration) {
            return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(paramViewConfiguration);
        }
    }

    static abstract interface ViewConfigurationVersionImpl {
        public abstract int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v4/view/ViewConfigurationCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */