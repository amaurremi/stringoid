package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.BitSet;

public class fg
  implements SafeParcelable
{
  public static final fh CREATOR = new fh();
  final int xM;
  final fk[] xN;
  public final String xO;
  public final boolean xP;
  
  fg(int paramInt, fk[] paramArrayOffk, String paramString, boolean paramBoolean)
  {
    this.xM = paramInt;
    this.xN = paramArrayOffk;
    this.xO = paramString;
    this.xP = paramBoolean;
  }
  
  public fg(String paramString, boolean paramBoolean, fk... paramVarArgs)
  {
    this(1, paramVarArgs, paramString, paramBoolean);
    paramString = new BitSet(fo.dP());
    int i = 0;
    while (i < paramVarArgs.length)
    {
      int j = paramVarArgs[i].xW;
      if (j != -1)
      {
        if (paramString.get(j)) {
          throw new IllegalArgumentException("Duplicate global search section type " + fo.H(j));
        }
        paramString.set(j);
      }
      i += 1;
    }
  }
  
  public int describeContents()
  {
    fh localfh = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fh localfh = CREATOR;
    fh.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/fg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */