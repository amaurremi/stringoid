package mobi.ifunny.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.util.SparseArray;

import java.util.Iterator;
import java.util.List;

import mobi.ifunny.l.e;

public class FragmentPage
        extends e {
    private Bundle a;
    private boolean b = false;
    private SparseArray<FragmentPage.ActivityResultMeta> c;

    private void b(boolean paramBoolean) {
        if (this.b != paramBoolean) {
            this.b = paramBoolean;
            a(paramBoolean);
        }
    }

    protected boolean A() {
        return this.b;
    }

    protected void a(int paramInt1, int paramInt2, Intent paramIntent) {
    }

    protected final void a(int paramInt1, int paramInt2, Intent paramIntent, FragmentPage.ActivityResultMeta paramActivityResultMeta) {
        FragmentPage.ActivityResultMeta localActivityResultMeta = paramActivityResultMeta;
        if (paramActivityResultMeta == null) {
            if (this.c != null) {
            }
        }
        do {
            do {
                return;
                localActivityResultMeta = (FragmentPage.ActivityResultMeta) this.c.get(paramInt1);
            } while (localActivityResultMeta == null);
            this.c.remove(paramInt1);
            if (this.c.size() == 0) {
                this.c = null;
            }
            paramActivityResultMeta = getChildFragmentManager();
            if (!FragmentPage.ActivityResultMeta.b(localActivityResultMeta)) {
                break;
            }
            Object localObject = FragmentPage.ActivityResultMeta.c(localActivityResultMeta);
            if (TextUtils.isEmpty((CharSequence) localObject)) {
                paramActivityResultMeta = paramActivityResultMeta.c().iterator();
                while (paramActivityResultMeta.hasNext()) {
                    localObject = (Fragment) paramActivityResultMeta.next();
                    if ((localObject instanceof FragmentPage)) {
                        ((FragmentPage) localObject).a(paramInt1, paramInt2, paramIntent, localActivityResultMeta);
                    }
                }
                a(FragmentPage.ActivityResultMeta.d(localActivityResultMeta), paramInt2, paramIntent);
                return;
            }
            paramActivityResultMeta = (FragmentPage) paramActivityResultMeta.a((String) localObject);
        } while (paramActivityResultMeta == null);
        paramActivityResultMeta.a(paramInt1, paramInt2, paramIntent, localActivityResultMeta);
        return;
        a(FragmentPage.ActivityResultMeta.d(localActivityResultMeta), paramInt2, paramIntent);
    }

    protected final void a(Intent paramIntent, int paramInt) {
        a(paramIntent, paramInt, null);
    }

    protected final void a(Intent paramIntent, int paramInt, FragmentPage.ActivityResultMeta paramActivityResultMeta) {
        FragmentPage.ActivityResultMeta localActivityResultMeta = paramActivityResultMeta;
        if (paramActivityResultMeta == null) {
            localActivityResultMeta = new FragmentPage.ActivityResultMeta(paramInt, this);
        }
        if (getParentFragment() == null) {
            if (this.c == null) {
                this.c = new SparseArray();
            }
            this.c.put(FragmentPage.ActivityResultMeta.a(localActivityResultMeta), localActivityResultMeta);
            startActivityForResult(paramIntent, FragmentPage.ActivityResultMeta.a(localActivityResultMeta));
            return;
        }
        paramActivityResultMeta = getParentFragment();
        if (!(paramActivityResultMeta instanceof FragmentPage)) {
            throw new IllegalStateException("every parent must be a FragmentPage");
        }
        paramActivityResultMeta = (FragmentPage) paramActivityResultMeta;
        FragmentPage.ActivityResultMeta.a(localActivityResultMeta, this);
        paramActivityResultMeta.a(paramIntent, paramInt, localActivityResultMeta);
    }

    protected void a(boolean paramBoolean) {
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        a(paramInt1, paramInt2, paramIntent, null);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (paramBundle != null) {
            this.a = paramBundle.getBundle("STATE_PAGE_ARGS");
            this.c = paramBundle.getSparseParcelableArray("STATE_RESULT_METAS");
        }
    }

    public void onPause() {
        b(false);
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        b(getUserVisibleHint());
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putBundle("STATE_PAGE_ARGS", this.a);
        paramBundle.putSparseParcelableArray("STATE_RESULT_METAS", this.c);
    }

    public void setUserVisibleHint(boolean paramBoolean) {
        super.setUserVisibleHint(paramBoolean);
        if ((isResumed()) && (paramBoolean)) {
        }
        for (paramBoolean = true; ; paramBoolean = false) {
            b(paramBoolean);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/fragment/FragmentPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */