package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class fq
  implements SafeParcelable
{
  public static final fr CREATOR = new fr();
  public final String name;
  public final int weight;
  final int xJ;
  public final String xY;
  public final boolean xZ;
  public final boolean ya;
  public final String yb;
  public final fn[] yc;
  final int[] yd;
  public final String ye;
  
  fq(int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString3, fn[] paramArrayOffn, int[] paramArrayOfInt, String paramString4)
  {
    this.xJ = paramInt1;
    this.name = paramString1;
    this.xY = paramString2;
    this.xZ = paramBoolean1;
    this.weight = paramInt2;
    this.ya = paramBoolean2;
    this.yb = paramString3;
    this.yc = paramArrayOffn;
    this.yd = paramArrayOfInt;
    this.ye = paramString4;
  }
  
  fq(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString3, fn[] paramArrayOffn, int[] paramArrayOfInt, String paramString4)
  {
    this(2, paramString1, paramString2, paramBoolean1, paramInt, paramBoolean2, paramString3, paramArrayOffn, paramArrayOfInt, paramString4);
  }
  
  public int describeContents()
  {
    fr localfr = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof fq))
    {
      paramObject = (fq)paramObject;
      bool1 = bool2;
      if (this.name.equals(((fq)paramObject).name))
      {
        bool1 = bool2;
        if (this.xY.equals(((fq)paramObject).xY))
        {
          bool1 = bool2;
          if (this.xZ == ((fq)paramObject).xZ) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fr localfr = CREATOR;
    fr.a(this, paramParcel, paramInt);
  }
  
  public static final class a
  {
    private final String mName;
    private String yf;
    private boolean yg;
    private int yh;
    private boolean yi;
    private String yj;
    private final List<fn> yk;
    private BitSet yl;
    private String ym;
    
    public a(String paramString)
    {
      this.mName = paramString;
      this.yh = 1;
      this.yk = new ArrayList();
    }
    
    public a I(int paramInt)
    {
      if (this.yl == null) {
        this.yl = new BitSet();
      }
      this.yl.set(paramInt);
      return this;
    }
    
    public a Z(String paramString)
    {
      this.yf = paramString;
      return this;
    }
    
    public a aa(String paramString)
    {
      this.ym = paramString;
      return this;
    }
    
    public fq dL()
    {
      int i = 0;
      Object localObject = null;
      if (this.yl != null)
      {
        int[] arrayOfInt = new int[this.yl.cardinality()];
        int j = this.yl.nextSetBit(0);
        for (;;)
        {
          localObject = arrayOfInt;
          if (j < 0) {
            break;
          }
          arrayOfInt[i] = j;
          j = this.yl.nextSetBit(j + 1);
          i += 1;
        }
      }
      return new fq(this.mName, this.yf, this.yg, this.yh, this.yi, this.yj, (fn[])this.yk.toArray(new fn[this.yk.size()]), (int[])localObject, this.ym);
    }
    
    public a w(boolean paramBoolean)
    {
      this.yg = paramBoolean;
      return this;
    }
    
    public a x(boolean paramBoolean)
    {
      this.yi = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/fq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */