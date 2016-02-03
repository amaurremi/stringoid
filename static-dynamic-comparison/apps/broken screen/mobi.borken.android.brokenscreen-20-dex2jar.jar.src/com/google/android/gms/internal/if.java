package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class if
  extends hz
  implements SafeParcelable
{
  public static final ig CREATOR = new ig();
  private final ic Hg;
  private final Parcel Hn;
  private final int Ho;
  private int Hp;
  private int Hq;
  private final String mClassName;
  private final int xJ;
  
  if(int paramInt, Parcel paramParcel, ic paramic)
  {
    this.xJ = paramInt;
    this.Hn = ((Parcel)hn.f(paramParcel));
    this.Ho = 2;
    this.Hg = paramic;
    if (this.Hg == null) {}
    for (this.mClassName = null;; this.mClassName = this.Hg.fR())
    {
      this.Hp = 2;
      return;
    }
  }
  
  private if(SafeParcelable paramSafeParcelable, ic paramic, String paramString)
  {
    this.xJ = 1;
    this.Hn = Parcel.obtain();
    paramSafeParcelable.writeToParcel(this.Hn, 0);
    this.Ho = 1;
    this.Hg = ((ic)hn.f(paramic));
    this.mClassName = ((String)hn.f(paramString));
    this.Hp = 2;
  }
  
  public static <T extends hz,  extends SafeParcelable> if a(T paramT)
  {
    String str = paramT.getClass().getCanonicalName();
    ic localic = b(paramT);
    return new if((SafeParcelable)paramT, localic, str);
  }
  
  private static void a(ic paramic, hz paramhz)
  {
    Object localObject = paramhz.getClass();
    if (!paramic.b((Class)localObject))
    {
      HashMap localHashMap = paramhz.fB();
      paramic.a((Class)localObject, paramhz.fB());
      localObject = localHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramhz = (hz.a)localHashMap.get((String)((Iterator)localObject).next());
        Class localClass = paramhz.fJ();
        if (localClass != null) {
          try
          {
            a(paramic, (hz)localClass.newInstance());
          }
          catch (InstantiationException paramic)
          {
            throw new IllegalStateException("Could not instantiate an object of type " + paramhz.fJ().getCanonicalName(), paramic);
          }
          catch (IllegalAccessException paramic)
          {
            throw new IllegalStateException("Could not access object of type " + paramhz.fJ().getCanonicalName(), paramic);
          }
        }
      }
    }
  }
  
  private void a(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown type = " + paramInt);
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      paramStringBuilder.append(paramObject);
      return;
    case 7: 
      paramStringBuilder.append("\"").append(io.aK(paramObject.toString())).append("\"");
      return;
    case 8: 
      paramStringBuilder.append("\"").append(ii.d((byte[])paramObject)).append("\"");
      return;
    case 9: 
      paramStringBuilder.append("\"").append(ii.e((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      ip.a(paramStringBuilder, (HashMap)paramObject);
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void a(StringBuilder paramStringBuilder, hz.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    switch (parama.fA())
    {
    default: 
      throw new IllegalArgumentException("Unknown field out type = " + parama.fA());
    case 0: 
      b(paramStringBuilder, parama, a(parama, Integer.valueOf(a.g(paramParcel, paramInt))));
      return;
    case 1: 
      b(paramStringBuilder, parama, a(parama, a.k(paramParcel, paramInt)));
      return;
    case 2: 
      b(paramStringBuilder, parama, a(parama, Long.valueOf(a.i(paramParcel, paramInt))));
      return;
    case 3: 
      b(paramStringBuilder, parama, a(parama, Float.valueOf(a.l(paramParcel, paramInt))));
      return;
    case 4: 
      b(paramStringBuilder, parama, a(parama, Double.valueOf(a.m(paramParcel, paramInt))));
      return;
    case 5: 
      b(paramStringBuilder, parama, a(parama, a.n(paramParcel, paramInt)));
      return;
    case 6: 
      b(paramStringBuilder, parama, a(parama, Boolean.valueOf(a.c(paramParcel, paramInt))));
      return;
    case 7: 
      b(paramStringBuilder, parama, a(parama, a.o(paramParcel, paramInt)));
      return;
    case 8: 
    case 9: 
      b(paramStringBuilder, parama, a(parama, a.r(paramParcel, paramInt)));
      return;
    case 10: 
      b(paramStringBuilder, parama, a(parama, d(a.q(paramParcel, paramInt))));
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString, hz.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    paramStringBuilder.append("\"").append(paramString).append("\":");
    if (parama.fL())
    {
      a(paramStringBuilder, parama, paramParcel, paramInt);
      return;
    }
    b(paramStringBuilder, parama, paramParcel, paramInt);
  }
  
  private void a(StringBuilder paramStringBuilder, HashMap<String, hz.a<?, ?>> paramHashMap, Parcel paramParcel)
  {
    paramHashMap = b(paramHashMap);
    paramStringBuilder.append('{');
    int j = a.B(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      Map.Entry localEntry = (Map.Entry)paramHashMap.get(Integer.valueOf(a.ar(k)));
      if (localEntry != null)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        a(paramStringBuilder, (String)localEntry.getKey(), (hz.a)localEntry.getValue(), paramParcel, k);
        i = 1;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    paramStringBuilder.append('}');
  }
  
  private static ic b(hz paramhz)
  {
    ic localic = new ic(paramhz.getClass());
    a(localic, paramhz);
    localic.fP();
    localic.fO();
    return localic;
  }
  
  private static HashMap<Integer, Map.Entry<String, hz.a<?, ?>>> b(HashMap<String, hz.a<?, ?>> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      localHashMap.put(Integer.valueOf(((hz.a)localEntry.getValue()).fI()), localEntry);
    }
    return localHashMap;
  }
  
  private void b(StringBuilder paramStringBuilder, hz.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    if (parama.fG())
    {
      paramStringBuilder.append("[");
      switch (parama.fA())
      {
      default: 
        throw new IllegalStateException("Unknown field type out.");
      case 0: 
        ih.a(paramStringBuilder, a.u(paramParcel, paramInt));
      }
      for (;;)
      {
        paramStringBuilder.append("]");
        return;
        ih.a(paramStringBuilder, a.w(paramParcel, paramInt));
        continue;
        ih.a(paramStringBuilder, a.v(paramParcel, paramInt));
        continue;
        ih.a(paramStringBuilder, a.x(paramParcel, paramInt));
        continue;
        ih.a(paramStringBuilder, a.y(paramParcel, paramInt));
        continue;
        ih.a(paramStringBuilder, a.z(paramParcel, paramInt));
        continue;
        ih.a(paramStringBuilder, a.t(paramParcel, paramInt));
        continue;
        ih.a(paramStringBuilder, a.A(paramParcel, paramInt));
        continue;
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
        paramParcel = a.D(paramParcel, paramInt);
        int i = paramParcel.length;
        paramInt = 0;
        while (paramInt < i)
        {
          if (paramInt > 0) {
            paramStringBuilder.append(",");
          }
          paramParcel[paramInt].setDataPosition(0);
          a(paramStringBuilder, parama.fN(), paramParcel[paramInt]);
          paramInt += 1;
        }
      }
    }
    switch (parama.fA())
    {
    default: 
      throw new IllegalStateException("Unknown field type out");
    case 0: 
      paramStringBuilder.append(a.g(paramParcel, paramInt));
      return;
    case 1: 
      paramStringBuilder.append(a.k(paramParcel, paramInt));
      return;
    case 2: 
      paramStringBuilder.append(a.i(paramParcel, paramInt));
      return;
    case 3: 
      paramStringBuilder.append(a.l(paramParcel, paramInt));
      return;
    case 4: 
      paramStringBuilder.append(a.m(paramParcel, paramInt));
      return;
    case 5: 
      paramStringBuilder.append(a.n(paramParcel, paramInt));
      return;
    case 6: 
      paramStringBuilder.append(a.c(paramParcel, paramInt));
      return;
    case 7: 
      parama = a.o(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(io.aK(parama)).append("\"");
      return;
    case 8: 
      parama = a.r(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(ii.d(parama)).append("\"");
      return;
    case 9: 
      parama = a.r(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(ii.e(parama));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      parama = a.q(paramParcel, paramInt);
      paramParcel = parama.keySet();
      paramParcel.size();
      paramStringBuilder.append("{");
      paramParcel = paramParcel.iterator();
      for (paramInt = 1; paramParcel.hasNext(); paramInt = 0)
      {
        String str = (String)paramParcel.next();
        if (paramInt == 0) {
          paramStringBuilder.append(",");
        }
        paramStringBuilder.append("\"").append(str).append("\"");
        paramStringBuilder.append(":");
        paramStringBuilder.append("\"").append(io.aK(parama.getString(str))).append("\"");
      }
      paramStringBuilder.append("}");
      return;
    }
    paramParcel = a.C(paramParcel, paramInt);
    paramParcel.setDataPosition(0);
    a(paramStringBuilder, parama.fN(), paramParcel);
  }
  
  private void b(StringBuilder paramStringBuilder, hz.a<?, ?> parama, Object paramObject)
  {
    if (parama.fF())
    {
      b(paramStringBuilder, parama, (ArrayList)paramObject);
      return;
    }
    a(paramStringBuilder, parama.fz(), paramObject);
  }
  
  private void b(StringBuilder paramStringBuilder, hz.a<?, ?> parama, ArrayList<?> paramArrayList)
  {
    paramStringBuilder.append("[");
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      a(paramStringBuilder, parama.fz(), paramArrayList.get(i));
      i += 1;
    }
    paramStringBuilder.append("]");
  }
  
  public static HashMap<String, String> d(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramBundle.getString(str));
    }
    return localHashMap;
  }
  
  protected Object aF(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  protected boolean aG(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public int describeContents()
  {
    ig localig = CREATOR;
    return 0;
  }
  
  public HashMap<String, hz.a<?, ?>> fB()
  {
    if (this.Hg == null) {
      return null;
    }
    return this.Hg.aJ(this.mClassName);
  }
  
  public Parcel fT()
  {
    switch (this.Hp)
    {
    }
    for (;;)
    {
      return this.Hn;
      this.Hq = b.C(this.Hn);
      b.G(this.Hn, this.Hq);
      this.Hp = 2;
      continue;
      b.G(this.Hn, this.Hq);
      this.Hp = 2;
    }
  }
  
  ic fU()
  {
    switch (this.Ho)
    {
    default: 
      throw new IllegalStateException("Invalid creation type: " + this.Ho);
    case 0: 
      return null;
    case 1: 
      return this.Hg;
    }
    return this.Hg;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public String toString()
  {
    hn.b(this.Hg, "Cannot convert to JSON on client side.");
    Parcel localParcel = fT();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    a(localStringBuilder, this.Hg.aJ(this.mClassName), localParcel);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ig localig = CREATOR;
    ig.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/if.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */