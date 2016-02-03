package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public BackStackState a(Parcel paramAnonymousParcel)
    {
      return new BackStackState(paramAnonymousParcel);
    }
    
    public BackStackState[] a(int paramAnonymousInt)
    {
      return new BackStackState[paramAnonymousInt];
    }
  };
  final int[] a;
  final int b;
  final int c;
  final String d;
  final int e;
  final int f;
  final CharSequence g;
  final int h;
  final CharSequence i;
  
  public BackStackState(Parcel paramParcel)
  {
    this.a = paramParcel.createIntArray();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.h = paramParcel.readInt();
    this.i = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
  }
  
  public BackStackState(l paraml, b paramb)
  {
    paraml = paramb.b;
    int k;
    for (int j = 0; paraml != null; j = k)
    {
      k = j;
      if (paraml.i != null) {
        k = j + paraml.i.size();
      }
      paraml = paraml.a;
    }
    this.a = new int[j + paramb.d * 7];
    if (!paramb.k) {
      throw new IllegalStateException("Not on back stack");
    }
    paraml = paramb.b;
    j = 0;
    if (paraml != null)
    {
      int[] arrayOfInt = this.a;
      k = j + 1;
      arrayOfInt[j] = paraml.c;
      arrayOfInt = this.a;
      int m = k + 1;
      if (paraml.d != null) {}
      for (j = paraml.d.o;; j = -1)
      {
        arrayOfInt[k] = j;
        arrayOfInt = this.a;
        j = m + 1;
        arrayOfInt[m] = paraml.e;
        arrayOfInt = this.a;
        k = j + 1;
        arrayOfInt[j] = paraml.f;
        arrayOfInt = this.a;
        j = k + 1;
        arrayOfInt[k] = paraml.g;
        arrayOfInt = this.a;
        k = j + 1;
        arrayOfInt[j] = paraml.h;
        if (paraml.i == null) {
          break label311;
        }
        m = paraml.i.size();
        arrayOfInt = this.a;
        j = k + 1;
        arrayOfInt[k] = m;
        k = 0;
        while (k < m)
        {
          this.a[j] = ((Fragment)paraml.i.get(k)).o;
          k += 1;
          j += 1;
        }
      }
      for (;;)
      {
        paraml = paraml.a;
        break;
        label311:
        arrayOfInt = this.a;
        j = k + 1;
        arrayOfInt[k] = 0;
      }
    }
    this.b = paramb.i;
    this.c = paramb.j;
    this.d = paramb.m;
    this.e = paramb.o;
    this.f = paramb.p;
    this.g = paramb.q;
    this.h = paramb.r;
    this.i = paramb.s;
  }
  
  public b a(l paraml)
  {
    b localb = new b(paraml);
    int m = 0;
    int j = 0;
    while (j < this.a.length)
    {
      c localc = new c();
      Object localObject = this.a;
      int k = j + 1;
      localc.c = localObject[j];
      if (l.a) {
        Log.v("FragmentManager", "Instantiate " + localb + " op #" + m + " base fragment #" + this.a[k]);
      }
      localObject = this.a;
      j = k + 1;
      k = localObject[k];
      if (k >= 0) {}
      for (localc.d = ((Fragment)paraml.f.get(k));; localc.d = null)
      {
        localObject = this.a;
        k = j + 1;
        localc.e = localObject[j];
        localObject = this.a;
        j = k + 1;
        localc.f = localObject[k];
        localObject = this.a;
        k = j + 1;
        localc.g = localObject[j];
        localObject = this.a;
        j = k + 1;
        localc.h = localObject[k];
        localObject = this.a;
        k = j + 1;
        int i1 = localObject[j];
        j = k;
        if (i1 <= 0) {
          break;
        }
        localc.i = new ArrayList(i1);
        int n = 0;
        for (;;)
        {
          j = k;
          if (n >= i1) {
            break;
          }
          if (l.a) {
            Log.v("FragmentManager", "Instantiate " + localb + " set remove fragment #" + this.a[k]);
          }
          localObject = (Fragment)paraml.f.get(this.a[k]);
          localc.i.add(localObject);
          n += 1;
          k += 1;
        }
      }
      localb.a(localc);
      m += 1;
    }
    localb.i = this.b;
    localb.j = this.c;
    localb.m = this.d;
    localb.o = this.e;
    localb.k = true;
    localb.p = this.f;
    localb.q = this.g;
    localb.r = this.h;
    localb.s = this.i;
    localb.b(1);
    return localb;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/app/BackStackState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */