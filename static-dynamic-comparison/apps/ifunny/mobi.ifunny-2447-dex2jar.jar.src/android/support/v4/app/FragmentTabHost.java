package android.support.v4.app;

import android.content.Context;
import android.os.Parcelable;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

import java.util.ArrayList;

public class FragmentTabHost
        extends TabHost
        implements TabHost.OnTabChangeListener {
    private final ArrayList<aa> a;
    private Context b;
    private q c;
    private int d;
    private TabHost.OnTabChangeListener e;
    private aa f;
    private boolean g;

    private ab a(String paramString, ab paramab) {
        Object localObject = null;
        int i = 0;
        if (i < this.a.size()) {
            aa localaa = (aa) this.a.get(i);
            if (!aa.b(localaa).equals(paramString)) {
                break label217;
            }
            localObject = localaa;
        }
        label204:
        label217:
        for (; ; ) {
            i += 1;
            break;
            if (localObject == null) {
                throw new IllegalStateException("No tab known for tag " + paramString);
            }
            paramString = paramab;
            if (this.f != localObject) {
                paramString = paramab;
                if (paramab == null) {
                    paramString = this.c.a();
                }
                if ((this.f != null) && (aa.a(this.f) != null)) {
                    paramString.b(aa.a(this.f));
                }
                if (localObject != null) {
                    if (aa.a((aa) localObject) != null) {
                        break label204;
                    }
                    aa.a((aa) localObject, Fragment.instantiate(this.b, aa.c((aa) localObject).getName(), aa.d((aa) localObject)));
                    paramString.a(this.d, aa.a((aa) localObject), aa.b((aa) localObject));
                }
            }
            for (; ; ) {
                this.f = ((aa) localObject);
                return paramString;
                paramString.c(aa.a((aa) localObject));
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = getCurrentTabTag();
        Object localObject1 = null;
        int i = 0;
        if (i < this.a.size()) {
            aa localaa = (aa) this.a.get(i);
            aa.a(localaa, this.c.a(aa.b(localaa)));
            Object localObject2 = localObject1;
            if (aa.a(localaa) != null) {
                localObject2 = localObject1;
                if (!aa.a(localaa).isDetached()) {
                    if (!aa.b(localaa).equals(str)) {
                        break label109;
                    }
                    this.f = localaa;
                    localObject2 = localObject1;
                }
            }
            for (; ; ) {
                i += 1;
                localObject1 = localObject2;
                break;
                label109:
                localObject2 = localObject1;
                if (localObject1 == null) {
                    localObject2 = this.c.a();
                }
                ((ab) localObject2).b(aa.a(localaa));
            }
        }
        this.g = true;
        localObject1 = a(str, (ab) localObject1);
        if (localObject1 != null) {
            ((ab) localObject1).b();
            this.c.b();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = false;
    }

    protected void onRestoreInstanceState(Parcelable paramParcelable) {
        paramParcelable = (FragmentTabHost.SavedState) paramParcelable;
        super.onRestoreInstanceState(paramParcelable.getSuperState());
        setCurrentTabByTag(paramParcelable.a);
    }

    protected Parcelable onSaveInstanceState() {
        FragmentTabHost.SavedState localSavedState = new FragmentTabHost.SavedState(super.onSaveInstanceState());
        localSavedState.a = getCurrentTabTag();
        return localSavedState;
    }

    public void onTabChanged(String paramString) {
        if (this.g) {
            ab localab = a(paramString, null);
            if (localab != null) {
                localab.b();
            }
        }
        if (this.e != null) {
            this.e.onTabChanged(paramString);
        }
    }

    public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener) {
        this.e = paramOnTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/FragmentTabHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */