package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ks$b
  extends hy
  implements SafeParcelable, Person.Cover
{
  public static final kv CREATOR = new kv();
  private static final HashMap<String, hy.a<?, ?>> acr = new HashMap();
  private final Set<Integer> acs;
  private ks.b.a adL;
  private ks.b.b adM;
  private int adN;
  private final int xM;
  
  static
  {
    acr.put("coverInfo", hy.a.a("coverInfo", 2, ks.b.a.class));
    acr.put("coverPhoto", hy.a.a("coverPhoto", 3, ks.b.b.class));
    acr.put("layout", hy.a.a("layout", 4, new hv().f("banner", 0), false));
  }
  
  public ks$b()
  {
    this.xM = 1;
    this.acs = new HashSet();
  }
  
  ks$b(Set<Integer> paramSet, int paramInt1, ks.b.a parama, ks.b.b paramb, int paramInt2)
  {
    this.acs = paramSet;
    this.xM = paramInt1;
    this.adL = parama;
    this.adM = paramb;
    this.adN = paramInt2;
  }
  
  protected boolean a(hy.a parama)
  {
    return this.acs.contains(Integer.valueOf(parama.fN()));
  }
  
  protected Object aF(String paramString)
  {
    return null;
  }
  
  protected boolean aG(String paramString)
  {
    return false;
  }
  
  protected Object b(hy.a parama)
  {
    switch (parama.fN())
    {
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.fN());
    case 2: 
      return this.adL;
    case 3: 
      return this.adM;
    }
    return Integer.valueOf(this.adN);
  }
  
  public int describeContents()
  {
    kv localkv = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (b)paramObject;
    Iterator localIterator = acr.values().iterator();
    while (localIterator.hasNext())
    {
      hy.a locala = (hy.a)localIterator.next();
      if (a(locala))
      {
        if (((b)paramObject).a(locala))
        {
          if (!b(locala).equals(((b)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((b)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public HashMap<String, hy.a<?, ?>> fG()
  {
    return acr;
  }
  
  public Person.Cover.CoverInfo getCoverInfo()
  {
    return this.adL;
  }
  
  public Person.Cover.CoverPhoto getCoverPhoto()
  {
    return this.adM;
  }
  
  public int getLayout()
  {
    return this.adN;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public boolean hasCoverInfo()
  {
    return this.acs.contains(Integer.valueOf(2));
  }
  
  public boolean hasCoverPhoto()
  {
    return this.acs.contains(Integer.valueOf(3));
  }
  
  public boolean hasLayout()
  {
    return this.acs.contains(Integer.valueOf(4));
  }
  
  public int hashCode()
  {
    Iterator localIterator = acr.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      hy.a locala = (hy.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.fN();
      i = b(locala).hashCode() + (i + j);
    }
    label68:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  ks.b.a kO()
  {
    return this.adL;
  }
  
  ks.b.b kP()
  {
    return this.adM;
  }
  
  public b kQ()
  {
    return this;
  }
  
  Set<Integer> kk()
  {
    return this.acs;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kv localkv = CREATOR;
    kv.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ks$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */