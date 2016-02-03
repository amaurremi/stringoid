package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;

final class BackStackState
        implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new f();
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;

    public BackStackState(Parcel paramParcel) {
        this.a = paramParcel.createIntArray();
        this.b = paramParcel.readInt();
        this.c = paramParcel.readInt();
        this.d = paramParcel.readString();
        this.e = paramParcel.readInt();
        this.f = paramParcel.readInt();
        this.g = ((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
        this.h = paramParcel.readInt();
        this.i = ((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    }

    public BackStackState(s params, d paramd) {
        params = paramd.b;
        int k;
        for (int j = 0; params != null; j = k) {
            k = j;
            if (params.i != null) {
                k = j + params.i.size();
            }
            params = params.a;
        }
        this.a = new int[j + paramd.d * 7];
        if (!paramd.k) {
            throw new IllegalStateException("Not on back stack");
        }
        params = paramd.b;
        j = 0;
        if (params != null) {
            int[] arrayOfInt = this.a;
            k = j + 1;
            arrayOfInt[j] = params.c;
            arrayOfInt = this.a;
            int m = k + 1;
            if (params.d != null) {
            }
            for (j = params.d.mIndex; ; j = -1) {
                arrayOfInt[k] = j;
                arrayOfInt = this.a;
                j = m + 1;
                arrayOfInt[m] = params.e;
                arrayOfInt = this.a;
                k = j + 1;
                arrayOfInt[j] = params.f;
                arrayOfInt = this.a;
                j = k + 1;
                arrayOfInt[k] = params.g;
                arrayOfInt = this.a;
                k = j + 1;
                arrayOfInt[j] = params.h;
                if (params.i == null) {
                    break label311;
                }
                m = params.i.size();
                arrayOfInt = this.a;
                j = k + 1;
                arrayOfInt[k] = m;
                k = 0;
                while (k < m) {
                    this.a[j] = ((Fragment) params.i.get(k)).mIndex;
                    k += 1;
                    j += 1;
                }
            }
            for (; ; ) {
                params = params.a;
                break;
                label311:
                arrayOfInt = this.a;
                j = k + 1;
                arrayOfInt[k] = 0;
            }
        }
        this.b = paramd.i;
        this.c = paramd.j;
        this.d = paramd.m;
        this.e = paramd.o;
        this.f = paramd.p;
        this.g = paramd.q;
        this.h = paramd.r;
        this.i = paramd.s;
    }

    public d a(s params) {
        d locald = new d(params);
        int m = 0;
        int j = 0;
        while (j < this.a.length) {
            e locale = new e();
            Object localObject = this.a;
            int k = j + 1;
            locale.c = localObject[j];
            if (s.a) {
                Log.v("FragmentManager", "Instantiate " + locald + " op #" + m + " base fragment #" + this.a[k]);
            }
            localObject = this.a;
            j = k + 1;
            k = localObject[k];
            if (k >= 0) {
            }
            for (locale.d = ((Fragment) params.f.get(k)); ; locale.d = null) {
                localObject = this.a;
                k = j + 1;
                locale.e = localObject[j];
                localObject = this.a;
                j = k + 1;
                locale.f = localObject[k];
                localObject = this.a;
                k = j + 1;
                locale.g = localObject[j];
                localObject = this.a;
                j = k + 1;
                locale.h = localObject[k];
                localObject = this.a;
                k = j + 1;
                int i1 = localObject[j];
                j = k;
                if (i1 <= 0) {
                    break;
                }
                locale.i = new ArrayList(i1);
                int n = 0;
                for (; ; ) {
                    j = k;
                    if (n >= i1) {
                        break;
                    }
                    if (s.a) {
                        Log.v("FragmentManager", "Instantiate " + locald + " set remove fragment #" + this.a[k]);
                    }
                    localObject = (Fragment) params.f.get(this.a[k]);
                    locale.i.add(localObject);
                    n += 1;
                    k += 1;
                }
            }
            locald.a(locale);
            m += 1;
        }
        locald.i = this.b;
        locald.j = this.c;
        locald.m = this.d;
        locald.o = this.e;
        locald.k = true;
        locald.p = this.f;
        locald.q = this.g;
        locald.r = this.h;
        locald.s = this.i;
        locald.a(1);
        return locald;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeIntArray(this.a);
        paramParcel.writeInt(this.b);
        paramParcel.writeInt(this.c);
        paramParcel.writeString(this.d);
        paramParcel.writeInt(this.e);
        paramParcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, paramParcel, 0);
        paramParcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, paramParcel, 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/BackStackState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */