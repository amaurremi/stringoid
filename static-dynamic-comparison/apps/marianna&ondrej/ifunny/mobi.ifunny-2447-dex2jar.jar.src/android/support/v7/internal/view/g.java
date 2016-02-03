package android.support.v7.internal.view;

import android.view.InflateException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

import java.lang.reflect.Method;

class g
        implements MenuItem.OnMenuItemClickListener {
    private static final Class<?>[] a = {MenuItem.class};
    private Object b;
    private Method c;

    public g(Object paramObject, String paramString) {
        this.b = paramObject;
        Class localClass = paramObject.getClass();
        try {
            this.c = localClass.getMethod(paramString, a);
            return;
        } catch (Exception paramObject) {
            paramString = new InflateException("Couldn't resolve menu item onClick handler " + paramString + " in class " + localClass.getName());
            paramString.initCause((Throwable) paramObject);
            throw paramString;
        }
    }

    public boolean onMenuItemClick(MenuItem paramMenuItem) {
        try {
            if (this.c.getReturnType() == Boolean.TYPE) {
                return ((Boolean) this.c.invoke(this.b, new Object[]{paramMenuItem})).booleanValue();
            }
            this.c.invoke(this.b, new Object[]{paramMenuItem});
            return true;
        } catch (Exception paramMenuItem) {
            throw new RuntimeException(paramMenuItem);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */