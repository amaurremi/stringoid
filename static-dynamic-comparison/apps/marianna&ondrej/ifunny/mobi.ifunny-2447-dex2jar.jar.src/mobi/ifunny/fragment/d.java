package mobi.ifunny.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.q;
import android.view.ViewGroup;

import java.lang.reflect.Field;
import java.util.ArrayList;

public abstract class d
        extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> a;
    private ArrayList<Fragment.SavedState> b;

    protected d(q paramq) {
        super(paramq);
        try {
            paramq = FragmentStatePagerAdapter.class.getDeclaredField("mFragments");
            paramq.setAccessible(true);
            this.a = ((ArrayList) paramq.get(this));
            paramq = FragmentStatePagerAdapter.class.getDeclaredField("mSavedState");
            paramq.setAccessible(true);
            this.b = ((ArrayList) paramq.get(this));
            return;
        } catch (NoSuchFieldException paramq) {
        } catch (IllegalAccessException paramq) {
        }
    }

    protected ArrayList<Fragment> a() {
        return this.a;
    }

    protected ArrayList<Fragment.SavedState> b() {
        return this.b;
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
        paramViewGroup = (Fragment) super.instantiateItem(paramViewGroup, paramInt);
        try {
            Object localObject = Fragment.class.getDeclaredField("mSavedFragmentState");
            ((Field) localObject).setAccessible(true);
            localObject = (Bundle) ((Field) localObject).get(paramViewGroup);
            if (localObject != null) {
                ((Bundle) localObject).setClassLoader(paramViewGroup.getClass().getClassLoader());
            }
            return paramViewGroup;
        } catch (NoSuchFieldException localNoSuchFieldException) {
            return paramViewGroup;
        } catch (IllegalAccessException localIllegalAccessException) {
        }
        return paramViewGroup;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/fragment/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */