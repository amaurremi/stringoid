package android.support.v4.widget;

import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class aa
        extends z {
    private Method a;
    private Field b;

    aa() {
        try {
            this.a = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
        } catch (NoSuchMethodException localNoSuchMethodException) {
            for (; ; ) {
                try {
                    this.b = View.class.getDeclaredField("mRecreateDisplayList");
                    this.b.setAccessible(true);
                    return;
                } catch (NoSuchFieldException localNoSuchFieldException) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", localNoSuchFieldException);
                }
                localNoSuchMethodException = localNoSuchMethodException;
                Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", localNoSuchMethodException);
            }
        }
    }

    public void a(SlidingPaneLayout paramSlidingPaneLayout, View paramView) {
        if ((this.a != null) && (this.b != null)) {
            try {
                this.b.setBoolean(paramView, true);
                this.a.invoke(paramView, (Object[]) null);
                super.a(paramSlidingPaneLayout, paramView);
                return;
            } catch (Exception localException) {
                for (; ; ) {
                    Log.e("SlidingPaneLayout", "Error refreshing display list state", localException);
                }
            }
        }
        paramView.invalidate();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/widget/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */