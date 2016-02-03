package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

public class k
        extends Activity {
    final Handler a = new l(this);
    final s b = new s();
    final p c = new m(this);
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    android.support.v4.d.m<String, ah> l;
    ah m;

    private static String a(View paramView) {
        char c3 = 'F';
        char c2 = '.';
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append(paramView.getClass().getName());
        localStringBuilder.append('{');
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(paramView)));
        localStringBuilder.append(' ');
        char c1;
        label118:
        label135:
        label152:
        label169:
        label186:
        label203:
        label220:
        label244:
        label261:
        int n;
        Object localObject;
        switch (paramView.getVisibility()) {
            default:
                localStringBuilder.append('.');
                if (paramView.isFocusable()) {
                    c1 = 'F';
                    localStringBuilder.append(c1);
                    if (!paramView.isEnabled()) {
                        break label562;
                    }
                    c1 = 'E';
                    localStringBuilder.append(c1);
                    if (!paramView.willNotDraw()) {
                        break label568;
                    }
                    c1 = '.';
                    localStringBuilder.append(c1);
                    if (!paramView.isHorizontalScrollBarEnabled()) {
                        break label574;
                    }
                    c1 = 'H';
                    localStringBuilder.append(c1);
                    if (!paramView.isVerticalScrollBarEnabled()) {
                        break label580;
                    }
                    c1 = 'V';
                    localStringBuilder.append(c1);
                    if (!paramView.isClickable()) {
                        break label586;
                    }
                    c1 = 'C';
                    localStringBuilder.append(c1);
                    if (!paramView.isLongClickable()) {
                        break label592;
                    }
                    c1 = 'L';
                    localStringBuilder.append(c1);
                    localStringBuilder.append(' ');
                    if (!paramView.isFocused()) {
                        break label598;
                    }
                    c1 = c3;
                    localStringBuilder.append(c1);
                    if (!paramView.isSelected()) {
                        break label604;
                    }
                    c1 = 'S';
                    localStringBuilder.append(c1);
                    c1 = c2;
                    if (paramView.isPressed()) {
                        c1 = 'P';
                    }
                    localStringBuilder.append(c1);
                    localStringBuilder.append(' ');
                    localStringBuilder.append(paramView.getLeft());
                    localStringBuilder.append(',');
                    localStringBuilder.append(paramView.getTop());
                    localStringBuilder.append('-');
                    localStringBuilder.append(paramView.getRight());
                    localStringBuilder.append(',');
                    localStringBuilder.append(paramView.getBottom());
                    n = paramView.getId();
                    if (n != -1) {
                        localStringBuilder.append(" #");
                        localStringBuilder.append(Integer.toHexString(n));
                        localObject = paramView.getResources();
                        if ((n != 0) && (localObject != null)) {
                            switch (0xFF000000 & n) {
                            }
                        }
                    }
                }
                break;
        }
        for (; ; ) {
            try {
                paramView = ((Resources) localObject).getResourcePackageName(n);
                String str = ((Resources) localObject).getResourceTypeName(n);
                localObject = ((Resources) localObject).getResourceEntryName(n);
                localStringBuilder.append(" ");
                localStringBuilder.append(paramView);
                localStringBuilder.append(":");
                localStringBuilder.append(str);
                localStringBuilder.append("/");
                localStringBuilder.append((String) localObject);
            } catch (Resources.NotFoundException paramView) {
                label562:
                label568:
                label574:
                label580:
                label586:
                label592:
                label598:
                label604:
                continue;
            }
            localStringBuilder.append("}");
            return localStringBuilder.toString();
            localStringBuilder.append('V');
            break;
            localStringBuilder.append('I');
            break;
            localStringBuilder.append('G');
            break;
            c1 = '.';
            break label118;
            c1 = '.';
            break label135;
            c1 = 'D';
            break label152;
            c1 = '.';
            break label169;
            c1 = '.';
            break label186;
            c1 = '.';
            break label203;
            c1 = '.';
            break label220;
            c1 = '.';
            break label244;
            c1 = '.';
            break label261;
            paramView = "app";
            continue;
            paramView = "android";
        }
    }

    private void a(String paramString, PrintWriter paramPrintWriter, View paramView) {
        paramPrintWriter.print(paramString);
        if (paramView == null) {
            paramPrintWriter.println("null");
        }
        for (; ; ) {
            return;
            paramPrintWriter.println(a(paramView));
            if ((paramView instanceof ViewGroup)) {
                paramView = (ViewGroup) paramView;
                int i1 = paramView.getChildCount();
                if (i1 > 0) {
                    paramString = paramString + "  ";
                    int n = 0;
                    while (n < i1) {
                        a(paramString, paramPrintWriter, paramView.getChildAt(n));
                        n += 1;
                    }
                }
            }
        }
    }

    public Object Q_() {
        return null;
    }

    ah a(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
        if (this.l == null) {
            this.l = new android.support.v4.d.m();
        }
        ah localah = (ah) this.l.get(paramString);
        if (localah == null) {
            if (paramBoolean2) {
                localah = new ah(paramString, this, paramBoolean1);
                this.l.put(paramString, localah);
            }
            return localah;
        }
        localah.a(this);
        return localah;
    }

    protected void a() {
        this.b.n();
    }

    public void a(Fragment paramFragment) {
    }

    public void a(Fragment paramFragment, Intent paramIntent, int paramInt) {
        if (paramInt == -1) {
            super.startActivityForResult(paramIntent, -1);
            return;
        }
        if ((0xFFFF0000 & paramInt) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(paramIntent, (paramFragment.mIndex + 1 << 16) + (0xFFFF & paramInt));
    }

    void a(String paramString) {
        if (this.l != null) {
            ah localah = (ah) this.l.get(paramString);
            if ((localah != null) && (!localah.g)) {
                localah.h();
                this.l.remove(paramString);
            }
        }
    }

    void a(boolean paramBoolean) {
        if (!this.g) {
            this.g = true;
            this.h = paramBoolean;
            this.a.removeMessages(1);
            e();
        }
    }

    protected boolean a(View paramView, Menu paramMenu) {
        return super.onPreparePanel(0, paramView, paramMenu);
    }

    public Object c() {
        o localo = (o) getLastNonConfigurationInstance();
        if (localo != null) {
            return localo.b;
        }
        return null;
    }

    public void d() {
        if (Build.VERSION.SDK_INT >= 11) {
            b.a(this);
            return;
        }
        this.i = true;
    }

    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
        if (Build.VERSION.SDK_INT >= 11) {
        }
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Local FragmentActivity ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(" State:");
        String str = paramString + "  ";
        paramPrintWriter.print(str);
        paramPrintWriter.print("mCreated=");
        paramPrintWriter.print(this.d);
        paramPrintWriter.print("mResumed=");
        paramPrintWriter.print(this.e);
        paramPrintWriter.print(" mStopped=");
        paramPrintWriter.print(this.f);
        paramPrintWriter.print(" mReallyStopped=");
        paramPrintWriter.println(this.g);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mLoadersStarted=");
        paramPrintWriter.println(this.k);
        if (this.m != null) {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("Loader Manager ");
            paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this.m)));
            paramPrintWriter.println(":");
            this.m.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
        this.b.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("View Hierarchy:");
        a(paramString + "  ", paramPrintWriter, getWindow().getDecorView());
    }

    void e() {
        if (this.k) {
            this.k = false;
            if (this.m != null) {
                if (this.h) {
                    break label41;
                }
                this.m.c();
            }
        }
        for (; ; ) {
            this.b.q();
            return;
            label41:
            this.m.d();
        }
    }

    public q f() {
        return this.b;
    }

    public af g() {
        if (this.m != null) {
            return this.m;
        }
        this.j = true;
        this.m = a("(root)", this.k, true);
        return this.m;
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        this.b.j();
        int n = paramInt1 >> 16;
        if (n != 0) {
            n -= 1;
            if ((this.b.f == null) || (n < 0) || (n >= this.b.f.size())) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(paramInt1));
                return;
            }
            Fragment localFragment = (Fragment) this.b.f.get(n);
            if (localFragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(paramInt1));
                return;
            }
            localFragment.onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
            return;
        }
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public void onBackPressed() {
        if (!this.b.d()) {
            finish();
        }
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        this.b.a(paramConfiguration);
    }

    protected void onCreate(Bundle paramBundle) {
        this.b.a(this, this.c, null);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(paramBundle);
        o localo = (o) getLastNonConfigurationInstance();
        if (localo != null) {
            this.l = localo.e;
        }
        Parcelable localParcelable;
        s locals;
        if (paramBundle != null) {
            localParcelable = paramBundle.getParcelable("android:support:fragments");
            locals = this.b;
            if (localo == null) {
                break label101;
            }
        }
        label101:
        for (paramBundle = localo.d; ; paramBundle = null) {
            locals.a(localParcelable, paramBundle);
            this.b.k();
            return;
        }
    }

    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu) {
        if (paramInt == 0) {
            boolean bool1 = super.onCreatePanelMenu(paramInt, paramMenu);
            boolean bool2 = this.b.a(paramMenu, getMenuInflater());
            if (Build.VERSION.SDK_INT >= 11) {
                return bool1 | bool2;
            }
            return true;
        }
        return super.onCreatePanelMenu(paramInt, paramMenu);
    }

    public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet) {
        Object localObject = null;
        if (!"fragment".equals(paramString)) {
            return super.onCreateView(paramString, paramContext, paramAttributeSet);
        }
        String str2 = paramAttributeSet.getAttributeValue(null, "class");
        TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, n.a);
        String str1 = str2;
        if (str2 == null) {
            str1 = localTypedArray.getString(0);
        }
        int i1 = localTypedArray.getResourceId(1, -1);
        str2 = localTypedArray.getString(2);
        localTypedArray.recycle();
        if (!Fragment.isSupportFragmentClass(this, str1)) {
            return super.onCreateView(paramString, paramContext, paramAttributeSet);
        }
        if (0 != 0) {
            throw new NullPointerException();
        }
        if ((-1 == 0) && (i1 == -1) && (str2 == null)) {
            throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
        }
        paramContext = (Context) localObject;
        if (i1 != -1) {
            paramContext = this.b.a(i1);
        }
        paramString = paramContext;
        if (paramContext == null) {
            paramString = paramContext;
            if (str2 != null) {
                paramString = this.b.a(str2);
            }
        }
        paramContext = paramString;
        if (paramString == null) {
            paramContext = paramString;
            if (-1 != 0) {
                paramContext = this.b.a(0);
            }
        }
        if (s.a) {
            Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(i1) + " fname=" + str1 + " existing=" + paramContext);
        }
        int n;
        if (paramContext == null) {
            paramString = Fragment.instantiate(this, str1);
            paramString.mFromLayout = true;
            if (i1 != 0) {
                n = i1;
                paramString.mFragmentId = n;
                paramString.mContainerId = 0;
                paramString.mTag = str2;
                paramString.mInLayout = true;
                paramString.mFragmentManager = this.b;
                paramString.onInflate(this, paramAttributeSet, paramString.mSavedFragmentState);
                this.b.a(paramString, true);
            }
        }
        for (; ; ) {
            if (paramString.mView != null) {
                break label525;
            }
            throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
            n = 0;
            break;
            if (paramContext.mInLayout) {
                throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(i1) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(0) + " with another fragment for " + str1);
            }
            paramContext.mInLayout = true;
            if (!paramContext.mRetaining) {
                paramContext.onInflate(this, paramAttributeSet, paramContext.mSavedFragmentState);
            }
            this.b.c(paramContext);
            paramString = paramContext;
        }
        label525:
        if (i1 != 0) {
            paramString.mView.setId(i1);
        }
        if (paramString.mView.getTag() == null) {
            paramString.mView.setTag(str2);
        }
        return paramString.mView;
    }

    protected void onDestroy() {
        super.onDestroy();
        a(false);
        this.b.s();
        if (this.m != null) {
            this.m.h();
        }
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if ((Build.VERSION.SDK_INT < 5) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0)) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.b.t();
    }

    public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
        if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
            return true;
        }
        switch (paramInt) {
            default:
                return false;
            case 0:
                return this.b.a(paramMenuItem);
        }
        return this.b.b(paramMenuItem);
    }

    protected void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        this.b.j();
    }

    public void onPanelClosed(int paramInt, Menu paramMenu) {
        switch (paramInt) {
        }
        for (; ; ) {
            super.onPanelClosed(paramInt, paramMenu);
            return;
            this.b.b(paramMenu);
        }
    }

    protected void onPause() {
        super.onPause();
        this.e = false;
        if (this.a.hasMessages(2)) {
            this.a.removeMessages(2);
            a();
        }
        this.b.o();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.a.removeMessages(2);
        a();
        this.b.f();
    }

    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu) {
        if ((paramInt == 0) && (paramMenu != null)) {
            if (this.i) {
                this.i = false;
                paramMenu.clear();
                onCreatePanelMenu(paramInt, paramMenu);
            }
            return a(paramView, paramMenu) | this.b.a(paramMenu);
        }
        return super.onPreparePanel(paramInt, paramView, paramMenu);
    }

    protected void onResume() {
        super.onResume();
        this.a.sendEmptyMessage(2);
        this.e = true;
        this.b.f();
    }

    public final Object onRetainNonConfigurationInstance() {
        int i1 = 0;
        if (this.f) {
            a(true);
        }
        Object localObject1 = Q_();
        ArrayList localArrayList = this.b.h();
        int i2;
        if (this.l != null) {
            int i3 = this.l.size();
            localObject2 = new ah[i3];
            int n = i3 - 1;
            while (n >= 0) {
                localObject2[n] = ((ah) this.l.c(n));
                n -= 1;
            }
            n = 0;
            i2 = n;
            if (i1 < i3) {
                Object localObject3 = localObject2[i1];
                if (((ah) localObject3).g) {
                    n = 1;
                }
                for (; ; ) {
                    i1 += 1;
                    break;
                    ((ah) localObject3).h();
                    this.l.remove(((ah) localObject3).d);
                }
            }
        } else {
            i2 = 0;
        }
        if ((localArrayList == null) && (i2 == 0) && (localObject1 == null)) {
            return null;
        }
        Object localObject2 = new o();
        ((o) localObject2).a = null;
        ((o) localObject2).b = localObject1;
        ((o) localObject2).c = null;
        ((o) localObject2).d = localArrayList;
        ((o) localObject2).e = this.l;
        return localObject2;
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        Parcelable localParcelable = this.b.i();
        if (localParcelable != null) {
            paramBundle.putParcelable("android:support:fragments", localParcelable);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f = false;
        this.g = false;
        this.a.removeMessages(1);
        if (!this.d) {
            this.d = true;
            this.b.l();
        }
        this.b.j();
        this.b.f();
        if (!this.k) {
            this.k = true;
            if (this.m == null) {
                break label143;
            }
            this.m.b();
        }
        int i1;
        ah[] arrayOfah;
        for (; ; ) {
            this.j = true;
            this.b.m();
            if (this.l == null) {
                return;
            }
            i1 = this.l.size();
            arrayOfah = new ah[i1];
            n = i1 - 1;
            while (n >= 0) {
                arrayOfah[n] = ((ah) this.l.c(n));
                n -= 1;
            }
            label143:
            if (!this.j) {
                this.m = a("(root)", this.k, false);
                if ((this.m != null) && (!this.m.f)) {
                    this.m.b();
                }
            }
        }
        int n = 0;
        while (n < i1) {
            ah localah = arrayOfah[n];
            localah.e();
            localah.g();
            n += 1;
        }
    }

    protected void onStop() {
        super.onStop();
        this.f = true;
        this.a.sendEmptyMessage(1);
        this.b.p();
    }

    public void startActivityForResult(Intent paramIntent, int paramInt) {
        if ((paramInt != -1) && ((0xFFFF0000 & paramInt) != 0)) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(paramIntent, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */