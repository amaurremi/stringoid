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

public class fh
  extends fb
  implements SafeParcelable
{
  public static final dq Mc = new dq();
  private final fe LL;
  private final Parcel LY;
  private final int LZ;
  private int Ma;
  private int Mb;
  private final String mClassName;
  private final int qh;
  
  fh(int paramInt, Parcel paramParcel, fe paramfe)
  {
    this.qh = paramInt;
    this.LY = ((Parcel)dc.N(paramParcel));
    this.LZ = 2;
    this.LL = paramfe;
    if (this.LL == null) {}
    for (this.mClassName = null;; this.mClassName = this.LL.qS())
    {
      this.Ma = 2;
      return;
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
      paramStringBuilder.append("\"").append(dw.aU(paramObject.toString())).append("\"");
      return;
    case 8: 
      paramStringBuilder.append("\"").append(ds.b((byte[])paramObject)).append("\"");
      return;
    case 9: 
      paramStringBuilder.append("\"").append(ds.c((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      dx.a(paramStringBuilder, (HashMap)paramObject);
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void a(StringBuilder paramStringBuilder, fb.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    switch (parama.qD())
    {
    default: 
      throw new IllegalArgumentException("Unknown field out type = " + parama.qD());
    case 0: 
      b(paramStringBuilder, parama, a(parama, Integer.valueOf(a.g(paramParcel, paramInt))));
      return;
    case 1: 
      b(paramStringBuilder, parama, a(parama, a.i(paramParcel, paramInt)));
      return;
    case 2: 
      b(paramStringBuilder, parama, a(parama, Long.valueOf(a.h(paramParcel, paramInt))));
      return;
    case 3: 
      b(paramStringBuilder, parama, a(parama, Float.valueOf(a.j(paramParcel, paramInt))));
      return;
    case 4: 
      b(paramStringBuilder, parama, a(parama, Double.valueOf(a.k(paramParcel, paramInt))));
      return;
    case 5: 
      b(paramStringBuilder, parama, a(parama, a.l(paramParcel, paramInt)));
      return;
    case 6: 
      b(paramStringBuilder, parama, a(parama, Boolean.valueOf(a.c(paramParcel, paramInt))));
      return;
    case 7: 
      b(paramStringBuilder, parama, a(parama, a.m(paramParcel, paramInt)));
      return;
    case 8: 
    case 9: 
      b(paramStringBuilder, parama, a(parama, a.p(paramParcel, paramInt)));
      return;
    case 10: 
      b(paramStringBuilder, parama, a(parama, m(a.o(paramParcel, paramInt))));
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString, fb.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    paramStringBuilder.append("\"").append(paramString).append("\":");
    if (parama.qN())
    {
      a(paramStringBuilder, parama, paramParcel, paramInt);
      return;
    }
    b(paramStringBuilder, parama, paramParcel, paramInt);
  }
  
  private void a(StringBuilder paramStringBuilder, HashMap<String, fb.a<?, ?>> paramHashMap, Parcel paramParcel)
  {
    paramHashMap = b(paramHashMap);
    paramStringBuilder.append('{');
    int j = a.j(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      Map.Entry localEntry = (Map.Entry)paramHashMap.get(Integer.valueOf(a.br(k)));
      if (localEntry != null)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        a(paramStringBuilder, (String)localEntry.getKey(), (fb.a)localEntry.getValue(), paramParcel, k);
        i = 1;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    paramStringBuilder.append('}');
  }
  
  private static HashMap<Integer, Map.Entry<String, fb.a<?, ?>>> b(HashMap<String, fb.a<?, ?>> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      localHashMap.put(Integer.valueOf(((fb.a)localEntry.getValue()).qK()), localEntry);
    }
    return localHashMap;
  }
  
  private void b(StringBuilder paramStringBuilder, fb.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    if (parama.qI())
    {
      paramStringBuilder.append("[");
      switch (parama.qD())
      {
      default: 
        throw new IllegalStateException("Unknown field type out.");
      case 0: 
        dr.a(paramStringBuilder, a.r(paramParcel, paramInt));
      }
      for (;;)
      {
        paramStringBuilder.append("]");
        return;
        dr.a(paramStringBuilder, a.t(paramParcel, paramInt));
        continue;
        dr.a(paramStringBuilder, a.s(paramParcel, paramInt));
        continue;
        dr.a(paramStringBuilder, a.u(paramParcel, paramInt));
        continue;
        dr.a(paramStringBuilder, a.v(paramParcel, paramInt));
        continue;
        dr.a(paramStringBuilder, a.w(paramParcel, paramInt));
        continue;
        dr.a(paramStringBuilder, a.q(paramParcel, paramInt));
        continue;
        dr.a(paramStringBuilder, a.x(paramParcel, paramInt));
        continue;
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
        paramParcel = a.A(paramParcel, paramInt);
        int i = paramParcel.length;
        paramInt = 0;
        while (paramInt < i)
        {
          if (paramInt > 0) {
            paramStringBuilder.append(",");
          }
          paramParcel[paramInt].setDataPosition(0);
          a(paramStringBuilder, parama.qP(), paramParcel[paramInt]);
          paramInt += 1;
        }
      }
    }
    switch (parama.qD())
    {
    default: 
      throw new IllegalStateException("Unknown field type out");
    case 0: 
      paramStringBuilder.append(a.g(paramParcel, paramInt));
      return;
    case 1: 
      paramStringBuilder.append(a.i(paramParcel, paramInt));
      return;
    case 2: 
      paramStringBuilder.append(a.h(paramParcel, paramInt));
      return;
    case 3: 
      paramStringBuilder.append(a.j(paramParcel, paramInt));
      return;
    case 4: 
      paramStringBuilder.append(a.k(paramParcel, paramInt));
      return;
    case 5: 
      paramStringBuilder.append(a.l(paramParcel, paramInt));
      return;
    case 6: 
      paramStringBuilder.append(a.c(paramParcel, paramInt));
      return;
    case 7: 
      parama = a.m(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(dw.aU(parama)).append("\"");
      return;
    case 8: 
      parama = a.p(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(ds.b(parama)).append("\"");
      return;
    case 9: 
      parama = a.p(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(ds.c(parama));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      parama = a.o(paramParcel, paramInt);
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
        paramStringBuilder.append("\"").append(dw.aU(parama.getString(str))).append("\"");
      }
      paramStringBuilder.append("}");
      return;
    }
    paramParcel = a.z(paramParcel, paramInt);
    paramParcel.setDataPosition(0);
    a(paramStringBuilder, parama.qP(), paramParcel);
  }
  
  private void b(StringBuilder paramStringBuilder, fb.a<?, ?> parama, Object paramObject)
  {
    if (parama.qH())
    {
      b(paramStringBuilder, parama, (ArrayList)paramObject);
      return;
    }
    a(paramStringBuilder, parama.qC(), paramObject);
  }
  
  private void b(StringBuilder paramStringBuilder, fb.a<?, ?> parama, ArrayList<?> paramArrayList)
  {
    paramStringBuilder.append("[");
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      a(paramStringBuilder, parama.qC(), paramArrayList.get(i));
      i += 1;
    }
    paramStringBuilder.append("]");
  }
  
  public static HashMap<String, String> m(Bundle paramBundle)
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
  
  protected Object aP(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  protected boolean aQ(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public int describeContents()
  {
    dq localdq = Mc;
    return 0;
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public HashMap<String, fb.a<?, ?>> qE()
  {
    if (this.LL == null) {
      return null;
    }
    return this.LL.aT(this.mClassName);
  }
  
  public Parcel qU()
  {
    switch (this.Ma)
    {
    }
    for (;;)
    {
      return this.LY;
      this.Mb = b.k(this.LY);
      b.D(this.LY, this.Mb);
      this.Ma = 2;
      continue;
      b.D(this.LY, this.Mb);
      this.Ma = 2;
    }
  }
  
  fe qV()
  {
    switch (this.LZ)
    {
    default: 
      throw new IllegalStateException("Invalid creation type: " + this.LZ);
    case 0: 
      return null;
    case 1: 
      return this.LL;
    }
    return this.LL;
  }
  
  public String toString()
  {
    dc.e(this.LL, "Cannot convert to JSON on client side.");
    Parcel localParcel = qU();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    a(localStringBuilder, this.LL.aT(this.mClassName), localParcel);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    dq localdq = Mc;
    dq.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/fh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */