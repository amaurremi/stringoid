package butterknife;

import android.view.View;

import java.util.AbstractList;
import java.util.RandomAccess;

final class ImmutableViewList<T extends View>
        extends AbstractList<T>
        implements RandomAccess {
    private final T[] views;

    ImmutableViewList(T[] paramArrayOfT) {
        this.views = paramArrayOfT;
    }

    public boolean contains(Object paramObject) {
        boolean bool2 = false;
        View[] arrayOfView = this.views;
        int j = arrayOfView.length;
        int i = 0;
        for (; ; ) {
            boolean bool1 = bool2;
            if (i < j) {
                if (arrayOfView[i] == paramObject) {
                    bool1 = true;
                }
            } else {
                return bool1;
            }
            i += 1;
        }
    }

    public T get(int paramInt) {
        return this.views[paramInt];
    }

    public int size() {
        return this.views.length;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/butterknife/ImmutableViewList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */