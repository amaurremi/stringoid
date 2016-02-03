package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.BitSet;

public class fh
  implements SafeParcelable
{
  public static final fi CREATOR = new fi();
  final int xJ;
  final fl[] xK;
  public final String xL;
  public final boolean xM;
  
  fh(int paramInt, fl[] paramArrayOffl, String paramString, boolean paramBoolean)
  {
    this.xJ = paramInt;
    this.xK = paramArrayOffl;
    this.xL = paramString;
    this.xM = paramBoolean;
  }
  
  public fh(String paramString, boolean paramBoolean, fl... paramVarArgs)
  {
    this(1, paramVarArgs, paramString, paramBoolean);
    paramString = new BitSet(fp.dK());
    int i = 0;
    while (i < paramVarArgs.length)
    {
      int j = paramVarArgs[i].xT;
      if (j != -1)
      {
        if (paramString.get(j)) {
          throw new IllegalArgumentException("Duplicate global search section type " + fp.H(j));
        }
        paramString.set(j);
      }
      i += 1;
    }
  }
  
  public int describeContents()
  {
    fi localfi = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fi localfi = CREATOR;
    fi.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/fh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */