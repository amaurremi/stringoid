package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.a.a.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class io
  extends fb
  implements SafeParcelable, b
{
  private static final HashMap<String, fb.a<?, ?>> Qx;
  public static final fl Ru = new fl();
  private String Gi;
  private String PI;
  private final Set<Integer> Qy;
  private String Rm;
  private im Rv;
  private im Rw;
  private final int qh;
  
  static
  {
    Qx = new HashMap();
    Qx.put("id", fb.a.h("id", 2));
    Qx.put("result", fb.a.a("result", 4, im.class));
    Qx.put("startDate", fb.a.h("startDate", 5));
    Qx.put("target", fb.a.a("target", 6, im.class));
    Qx.put("type", fb.a.h("type", 7));
  }
  
  public io()
  {
    this.qh = 1;
    this.Qy = new HashSet();
  }
  
  io(Set<Integer> paramSet, int paramInt, String paramString1, im paramim1, String paramString2, im paramim2, String paramString3)
  {
    this.Qy = paramSet;
    this.qh = paramInt;
    this.Gi = paramString1;
    this.Rv = paramim1;
    this.Rm = paramString2;
    this.Rw = paramim2;
    this.PI = paramString3;
  }
  
  protected boolean a(fb.a parama)
  {
    return this.Qy.contains(Integer.valueOf(parama.qK()));
  }
  
  protected Object aP(String paramString)
  {
    return null;
  }
  
  protected boolean aQ(String paramString)
  {
    return false;
  }
  
  protected Object b(fb.a parama)
  {
    switch (parama.qK())
    {
    case 3: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.qK());
    case 2: 
      return this.Gi;
    case 4: 
      return this.Rv;
    case 5: 
      return this.Rm;
    case 6: 
      return this.Rw;
    }
    return this.PI;
  }
  
  public int describeContents()
  {
    fl localfl = Ru;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof io)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (io)paramObject;
    Iterator localIterator = Qx.values().iterator();
    while (localIterator.hasNext())
    {
      fb.a locala = (fb.a)localIterator.next();
      if (a(locala))
      {
        if (((io)paramObject).a(locala))
        {
          if (!b(locala).equals(((io)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((io)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public String getId()
  {
    return this.Gi;
  }
  
  public String getType()
  {
    return this.PI;
  }
  
  public int hashCode()
  {
    Iterator localIterator = Qx.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      fb.a locala = (fb.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.qK();
      i = b(locala).hashCode() + (i + j);
    }
    label68:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public HashMap<String, fb.a<?, ?>> qE()
  {
    return Qx;
  }
  
  Set<Integer> rI()
  {
    return this.Qy;
  }
  
  im sC()
  {
    return this.Rv;
  }
  
  im sD()
  {
    return this.Rw;
  }
  
  public io sE()
  {
    return this;
  }
  
  public String su()
  {
    return this.Rm;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fl localfl = Ru;
    fl.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/io.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */