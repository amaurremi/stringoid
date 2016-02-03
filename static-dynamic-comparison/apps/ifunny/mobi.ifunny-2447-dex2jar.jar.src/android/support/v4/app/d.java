package android.support.v4.app;

import android.util.Log;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class d
        extends ab
        implements Runnable {
    final s a;
    e b;
    e c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    boolean k;
    boolean l = true;
    String m;
    boolean n;
    int o = -1;
    int p;
    CharSequence q;
    int r;
    CharSequence s;

    public d(s params) {
        this.a = params;
    }

    private void a(int paramInt1, Fragment paramFragment, String paramString, int paramInt2) {
        paramFragment.mFragmentManager = this.a;
        if (paramString != null) {
            if ((paramFragment.mTag != null) && (!paramString.equals(paramFragment.mTag))) {
                throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.mTag + " now " + paramString);
            }
            paramFragment.mTag = paramString;
        }
        if (paramInt1 != 0) {
            if ((paramFragment.mFragmentId != 0) && (paramFragment.mFragmentId != paramInt1)) {
                throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + paramFragment.mFragmentId + " now " + paramInt1);
            }
            paramFragment.mFragmentId = paramInt1;
            paramFragment.mContainerId = paramInt1;
        }
        paramString = new e();
        paramString.c = paramInt2;
        paramString.d = paramFragment;
        a(paramString);
    }

    int a(boolean paramBoolean) {
        if (this.n) {
            throw new IllegalStateException("commit already called");
        }
        if (s.a) {
            Log.v("FragmentManager", "Commit: " + this);
            a("  ", null, new PrintWriter(new android.support.v4.d.e("FragmentManager")), null);
        }
        this.n = true;
        if (this.k) {
        }
        for (this.o = this.a.a(this); ; this.o = -1) {
            this.a.a(this, paramBoolean);
            return this.o;
        }
    }

    public ab a() {
        if (this.k) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.l = false;
        return this;
    }

    public ab a(int paramInt, Fragment paramFragment) {
        a(paramInt, paramFragment, null, 1);
        return this;
    }

    public ab a(int paramInt, Fragment paramFragment, String paramString) {
        a(paramInt, paramFragment, paramString, 1);
        return this;
    }

    public ab a(Fragment paramFragment) {
        e locale = new e();
        locale.c = 3;
        locale.d = paramFragment;
        a(locale);
        return this;
    }

    public ab a(Fragment paramFragment, String paramString) {
        a(0, paramFragment, paramString, 1);
        return this;
    }

    void a(int paramInt) {
        if (!this.k) {
        }
        for (; ; ) {
            return;
            if (s.a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + paramInt);
            }
            for (e locale = this.b; locale != null; locale = locale.a) {
                Fragment localFragment;
                if (locale.d != null) {
                    localFragment = locale.d;
                    localFragment.mBackStackNesting += paramInt;
                    if (s.a) {
                        Log.v("FragmentManager", "Bump nesting of " + locale.d + " to " + locale.d.mBackStackNesting);
                    }
                }
                if (locale.i != null) {
                    int i1 = locale.i.size() - 1;
                    while (i1 >= 0) {
                        localFragment = (Fragment) locale.i.get(i1);
                        localFragment.mBackStackNesting += paramInt;
                        if (s.a) {
                            Log.v("FragmentManager", "Bump nesting of " + localFragment + " to " + localFragment.mBackStackNesting);
                        }
                        i1 -= 1;
                    }
                }
            }
        }
    }

    void a(e parame) {
        if (this.b == null) {
            this.c = parame;
            this.b = parame;
        }
        for (; ; ) {
            parame.e = this.e;
            parame.f = this.f;
            parame.g = this.g;
            parame.h = this.h;
            this.d += 1;
            return;
            parame.b = this.c;
            this.c.a = parame;
            this.c = parame;
        }
    }

    public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
        a(paramString, paramPrintWriter, true);
    }

    public void a(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean) {
        if (paramBoolean) {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("mName=");
            paramPrintWriter.print(this.m);
            paramPrintWriter.print(" mIndex=");
            paramPrintWriter.print(this.o);
            paramPrintWriter.print(" mCommitted=");
            paramPrintWriter.println(this.n);
            if (this.i != 0) {
                paramPrintWriter.print(paramString);
                paramPrintWriter.print("mTransition=#");
                paramPrintWriter.print(Integer.toHexString(this.i));
                paramPrintWriter.print(" mTransitionStyle=#");
                paramPrintWriter.println(Integer.toHexString(this.j));
            }
            if ((this.e != 0) || (this.f != 0)) {
                paramPrintWriter.print(paramString);
                paramPrintWriter.print("mEnterAnim=#");
                paramPrintWriter.print(Integer.toHexString(this.e));
                paramPrintWriter.print(" mExitAnim=#");
                paramPrintWriter.println(Integer.toHexString(this.f));
            }
            if ((this.g != 0) || (this.h != 0)) {
                paramPrintWriter.print(paramString);
                paramPrintWriter.print("mPopEnterAnim=#");
                paramPrintWriter.print(Integer.toHexString(this.g));
                paramPrintWriter.print(" mPopExitAnim=#");
                paramPrintWriter.println(Integer.toHexString(this.h));
            }
            if ((this.p != 0) || (this.q != null)) {
                paramPrintWriter.print(paramString);
                paramPrintWriter.print("mBreadCrumbTitleRes=#");
                paramPrintWriter.print(Integer.toHexString(this.p));
                paramPrintWriter.print(" mBreadCrumbTitleText=");
                paramPrintWriter.println(this.q);
            }
            if ((this.r != 0) || (this.s != null)) {
                paramPrintWriter.print(paramString);
                paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
                paramPrintWriter.print(Integer.toHexString(this.r));
                paramPrintWriter.print(" mBreadCrumbShortTitleText=");
                paramPrintWriter.println(this.s);
            }
        }
        if (this.b != null) {
            paramPrintWriter.print(paramString);
            paramPrintWriter.println("Operations:");
            String str2 = paramString + "    ";
            e locale = this.b;
            int i1 = 0;
            while (locale != null) {
                String str1;
                int i2;
                switch (locale.c) {
                    default:
                        str1 = "cmd=" + locale.c;
                        paramPrintWriter.print(paramString);
                        paramPrintWriter.print("  Op #");
                        paramPrintWriter.print(i1);
                        paramPrintWriter.print(": ");
                        paramPrintWriter.print(str1);
                        paramPrintWriter.print(" ");
                        paramPrintWriter.println(locale.d);
                        if (paramBoolean) {
                            if ((locale.e != 0) || (locale.f != 0)) {
                                paramPrintWriter.print(paramString);
                                paramPrintWriter.print("enterAnim=#");
                                paramPrintWriter.print(Integer.toHexString(locale.e));
                                paramPrintWriter.print(" exitAnim=#");
                                paramPrintWriter.println(Integer.toHexString(locale.f));
                            }
                            if ((locale.g != 0) || (locale.h != 0)) {
                                paramPrintWriter.print(paramString);
                                paramPrintWriter.print("popEnterAnim=#");
                                paramPrintWriter.print(Integer.toHexString(locale.g));
                                paramPrintWriter.print(" popExitAnim=#");
                                paramPrintWriter.println(Integer.toHexString(locale.h));
                            }
                        }
                        if ((locale.i == null) || (locale.i.size() <= 0)) {
                            break label795;
                        }
                        i2 = 0;
                        label629:
                        if (i2 >= locale.i.size()) {
                            break label795;
                        }
                        paramPrintWriter.print(str2);
                        if (locale.i.size() == 1) {
                            paramPrintWriter.print("Removed: ");
                        }
                        break;
                }
                for (; ; ) {
                    paramPrintWriter.println(locale.i.get(i2));
                    i2 += 1;
                    break label629;
                    str1 = "NULL";
                    break;
                    str1 = "ADD";
                    break;
                    str1 = "REPLACE";
                    break;
                    str1 = "REMOVE";
                    break;
                    str1 = "HIDE";
                    break;
                    str1 = "SHOW";
                    break;
                    str1 = "DETACH";
                    break;
                    str1 = "ATTACH";
                    break;
                    if (i2 == 0) {
                        paramPrintWriter.println("Removed:");
                    }
                    paramPrintWriter.print(str2);
                    paramPrintWriter.print("  #");
                    paramPrintWriter.print(i2);
                    paramPrintWriter.print(": ");
                }
                label795:
                locale = locale.a;
                i1 += 1;
            }
        }
    }

    public int b() {
        return a(false);
    }

    public ab b(int paramInt, Fragment paramFragment, String paramString) {
        if (paramInt == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        a(paramInt, paramFragment, paramString, 2);
        return this;
    }

    public ab b(Fragment paramFragment) {
        e locale = new e();
        locale.c = 6;
        locale.d = paramFragment;
        a(locale);
        return this;
    }

    public void b(boolean paramBoolean) {
        if (s.a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            a("  ", null, new PrintWriter(new android.support.v4.d.e("FragmentManager")), null);
        }
        a(-1);
        e locale = this.c;
        if (locale != null) {
            Fragment localFragment;
            switch (locale.c) {
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + locale.c);
                case 1:
                    localFragment = locale.d;
                    localFragment.mNextAnim = locale.h;
                    this.a.a(localFragment, s.c(this.i), this.j);
            }
            for (; ; ) {
                locale = locale.b;
                break;
                localFragment = locale.d;
                if (localFragment != null) {
                    localFragment.mNextAnim = locale.h;
                    this.a.a(localFragment, s.c(this.i), this.j);
                }
                if (locale.i != null) {
                    int i1 = 0;
                    while (i1 < locale.i.size()) {
                        localFragment = (Fragment) locale.i.get(i1);
                        localFragment.mNextAnim = locale.g;
                        this.a.a(localFragment, false);
                        i1 += 1;
                    }
                    localFragment = locale.d;
                    localFragment.mNextAnim = locale.g;
                    this.a.a(localFragment, false);
                    continue;
                    localFragment = locale.d;
                    localFragment.mNextAnim = locale.g;
                    this.a.c(localFragment, s.c(this.i), this.j);
                    continue;
                    localFragment = locale.d;
                    localFragment.mNextAnim = locale.h;
                    this.a.b(localFragment, s.c(this.i), this.j);
                    continue;
                    localFragment = locale.d;
                    localFragment.mNextAnim = locale.g;
                    this.a.e(localFragment, s.c(this.i), this.j);
                    continue;
                    localFragment = locale.d;
                    localFragment.mNextAnim = locale.g;
                    this.a.d(localFragment, s.c(this.i), this.j);
                }
            }
        }
        if (paramBoolean) {
            this.a.a(this.a.n, s.c(this.i), this.j, true);
        }
        if (this.o >= 0) {
            this.a.b(this.o);
            this.o = -1;
        }
    }

    public int c() {
        return a(true);
    }

    public ab c(Fragment paramFragment) {
        e locale = new e();
        locale.c = 7;
        locale.d = paramFragment;
        a(locale);
        return this;
    }

    public String d() {
        return this.m;
    }

    public boolean e() {
        return this.d == 0;
    }

    public void run() {
        if (s.a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if ((this.k) && (this.o < 0)) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        a(1);
        e locale = this.b;
        if (locale != null) {
            Object localObject1;
            switch (locale.c) {
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + locale.c);
                case 1:
                    localObject1 = locale.d;
                    ((Fragment) localObject1).mNextAnim = locale.e;
                    this.a.a((Fragment) localObject1, false);
            }
            for (; ; ) {
                locale = locale.a;
                break;
                localObject1 = locale.d;
                Object localObject2;
                if (this.a.g != null) {
                    int i1 = 0;
                    localObject2 = localObject1;
                    if (i1 < this.a.g.size()) {
                        Fragment localFragment = (Fragment) this.a.g.get(i1);
                        if (s.a) {
                            Log.v("FragmentManager", "OP_REPLACE: adding=" + localObject1 + " old=" + localFragment);
                        }
                        if (localObject1 != null) {
                            localObject2 = localObject1;
                            if (localFragment.mContainerId != ((Fragment) localObject1).mContainerId) {
                            }
                        } else {
                            if (localFragment != localObject1) {
                                break label313;
                            }
                            localObject2 = null;
                            locale.d = null;
                        }
                        for (; ; ) {
                            i1 += 1;
                            localObject1 = localObject2;
                            break;
                            label313:
                            if (locale.i == null) {
                                locale.i = new ArrayList();
                            }
                            locale.i.add(localFragment);
                            localFragment.mNextAnim = locale.f;
                            if (this.k) {
                                localFragment.mBackStackNesting += 1;
                                if (s.a) {
                                    Log.v("FragmentManager", "Bump nesting of " + localFragment + " to " + localFragment.mBackStackNesting);
                                }
                            }
                            this.a.a(localFragment, this.i, this.j);
                            localObject2 = localObject1;
                        }
                    }
                } else {
                    localObject2 = localObject1;
                }
                if (localObject2 != null) {
                    ((Fragment) localObject2).mNextAnim = locale.e;
                    this.a.a((Fragment) localObject2, false);
                    continue;
                    localObject1 = locale.d;
                    ((Fragment) localObject1).mNextAnim = locale.f;
                    this.a.a((Fragment) localObject1, this.i, this.j);
                    continue;
                    localObject1 = locale.d;
                    ((Fragment) localObject1).mNextAnim = locale.f;
                    this.a.b((Fragment) localObject1, this.i, this.j);
                    continue;
                    localObject1 = locale.d;
                    ((Fragment) localObject1).mNextAnim = locale.e;
                    this.a.c((Fragment) localObject1, this.i, this.j);
                    continue;
                    localObject1 = locale.d;
                    ((Fragment) localObject1).mNextAnim = locale.f;
                    this.a.d((Fragment) localObject1, this.i, this.j);
                    continue;
                    localObject1 = locale.d;
                    ((Fragment) localObject1).mNextAnim = locale.e;
                    this.a.e((Fragment) localObject1, this.i, this.j);
                }
            }
        }
        this.a.a(this.a.n, this.i, this.j, true);
        if (this.k) {
            this.a.b(this);
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("BackStackEntry{");
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.o >= 0) {
            localStringBuilder.append(" #");
            localStringBuilder.append(this.o);
        }
        if (this.m != null) {
            localStringBuilder.append(" ");
            localStringBuilder.append(this.m);
        }
        localStringBuilder.append("}");
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */