package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ec
  extends dw
  implements SafeParcelable
{
  public static final ax CREATOR = new ax();
  private final int a;
  private final Parcel b;
  private final int c;
  private final dz d;
  private final String e;
  private int f;
  private int g;
  
  ec(int paramInt, Parcel paramParcel, dz paramdz)
  {
    this.a = paramInt;
    this.b = ((Parcel)an.a(paramParcel));
    this.c = 2;
    this.d = paramdz;
    if (this.d == null) {}
    for (this.e = null;; this.e = this.d.d())
    {
      this.f = 2;
      return;
    }
  }
  
  public static HashMap a(Bundle paramBundle)
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
  
  private static HashMap a(HashMap paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      localHashMap.put(Integer.valueOf(((dw.a)localEntry.getValue()).g()), localEntry);
    }
    return localHashMap;
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
      paramStringBuilder.append("\"").append(bb.a(paramObject.toString())).append("\"");
      return;
    case 8: 
      paramStringBuilder.append("\"").append(az.a((byte[])paramObject)).append("\"");
      return;
    case 9: 
      paramStringBuilder.append("\"").append(az.b((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      bc.a(paramStringBuilder, (HashMap)paramObject);
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void a(StringBuilder paramStringBuilder, dw.a parama, Parcel paramParcel, int paramInt)
  {
    switch (parama.d())
    {
    default: 
      throw new IllegalArgumentException("Unknown field out type = " + parama.d());
    case 0: 
      a(paramStringBuilder, parama, a(parama, Integer.valueOf(a.f(paramParcel, paramInt))));
      return;
    case 1: 
      a(paramStringBuilder, parama, a(parama, a.h(paramParcel, paramInt)));
      return;
    case 2: 
      a(paramStringBuilder, parama, a(parama, Long.valueOf(a.g(paramParcel, paramInt))));
      return;
    case 3: 
      a(paramStringBuilder, parama, a(parama, Float.valueOf(a.i(paramParcel, paramInt))));
      return;
    case 4: 
      a(paramStringBuilder, parama, a(parama, Double.valueOf(a.j(paramParcel, paramInt))));
      return;
    case 5: 
      a(paramStringBuilder, parama, a(parama, a.k(paramParcel, paramInt)));
      return;
    case 6: 
      a(paramStringBuilder, parama, a(parama, Boolean.valueOf(a.c(paramParcel, paramInt))));
      return;
    case 7: 
      a(paramStringBuilder, parama, a(parama, a.l(paramParcel, paramInt)));
      return;
    case 8: 
    case 9: 
      a(paramStringBuilder, parama, a(parama, a.o(paramParcel, paramInt)));
      return;
    case 10: 
      a(paramStringBuilder, parama, a(parama, a(a.n(paramParcel, paramInt))));
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void a(StringBuilder paramStringBuilder, dw.a parama, Object paramObject)
  {
    if (parama.c())
    {
      a(paramStringBuilder, parama, (ArrayList)paramObject);
      return;
    }
    a(paramStringBuilder, parama.b(), paramObject);
  }
  
  private void a(StringBuilder paramStringBuilder, dw.a parama, ArrayList paramArrayList)
  {
    paramStringBuilder.append("[");
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      a(paramStringBuilder, parama.b(), paramArrayList.get(i));
      i += 1;
    }
    paramStringBuilder.append("]");
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString, dw.a parama, Parcel paramParcel, int paramInt)
  {
    paramStringBuilder.append("\"").append(paramString).append("\":");
    if (parama.j())
    {
      a(paramStringBuilder, parama, paramParcel, paramInt);
      return;
    }
    b(paramStringBuilder, parama, paramParcel, paramInt);
  }
  
  private void a(StringBuilder paramStringBuilder, HashMap paramHashMap, Parcel paramParcel)
  {
    paramHashMap = a(paramHashMap);
    paramStringBuilder.append('{');
    int j = a.b(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.a(paramParcel);
      Map.Entry localEntry = (Map.Entry)paramHashMap.get(Integer.valueOf(a.a(k)));
      if (localEntry != null)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        a(paramStringBuilder, (String)localEntry.getKey(), (dw.a)localEntry.getValue(), paramParcel, k);
        i = 1;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    paramStringBuilder.append('}');
  }
  
  private void b(StringBuilder paramStringBuilder, dw.a parama, Parcel paramParcel, int paramInt)
  {
    if (parama.e())
    {
      paramStringBuilder.append("[");
      switch (parama.d())
      {
      default: 
        throw new IllegalStateException("Unknown field type out.");
      case 0: 
        ay.a(paramStringBuilder, a.q(paramParcel, paramInt));
      }
      for (;;)
      {
        paramStringBuilder.append("]");
        return;
        ay.a(paramStringBuilder, a.s(paramParcel, paramInt));
        continue;
        ay.a(paramStringBuilder, a.r(paramParcel, paramInt));
        continue;
        ay.a(paramStringBuilder, a.t(paramParcel, paramInt));
        continue;
        ay.a(paramStringBuilder, a.u(paramParcel, paramInt));
        continue;
        ay.a(paramStringBuilder, a.v(paramParcel, paramInt));
        continue;
        ay.a(paramStringBuilder, a.p(paramParcel, paramInt));
        continue;
        ay.a(paramStringBuilder, a.w(paramParcel, paramInt));
        continue;
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
        paramParcel = a.z(paramParcel, paramInt);
        int i = paramParcel.length;
        paramInt = 0;
        while (paramInt < i)
        {
          if (paramInt > 0) {
            paramStringBuilder.append(",");
          }
          paramParcel[paramInt].setDataPosition(0);
          a(paramStringBuilder, parama.l(), paramParcel[paramInt]);
          paramInt += 1;
        }
      }
    }
    switch (parama.d())
    {
    default: 
      throw new IllegalStateException("Unknown field type out");
    case 0: 
      paramStringBuilder.append(a.f(paramParcel, paramInt));
      return;
    case 1: 
      paramStringBuilder.append(a.h(paramParcel, paramInt));
      return;
    case 2: 
      paramStringBuilder.append(a.g(paramParcel, paramInt));
      return;
    case 3: 
      paramStringBuilder.append(a.i(paramParcel, paramInt));
      return;
    case 4: 
      paramStringBuilder.append(a.j(paramParcel, paramInt));
      return;
    case 5: 
      paramStringBuilder.append(a.k(paramParcel, paramInt));
      return;
    case 6: 
      paramStringBuilder.append(a.c(paramParcel, paramInt));
      return;
    case 7: 
      parama = a.l(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(bb.a(parama)).append("\"");
      return;
    case 8: 
      parama = a.o(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(az.a(parama)).append("\"");
      return;
    case 9: 
      parama = a.o(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(az.b(parama));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      parama = a.n(paramParcel, paramInt);
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
        paramStringBuilder.append("\"").append(bb.a(parama.getString(str))).append("\"");
      }
      paramStringBuilder.append("}");
      return;
    }
    paramParcel = a.y(paramParcel, paramInt);
    paramParcel.setDataPosition(0);
    a(paramStringBuilder, parama.l(), paramParcel);
  }
  
  public int a()
  {
    return this.a;
  }
  
  protected Object a(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public HashMap b()
  {
    if (this.d == null) {
      return null;
    }
    return this.d.a(this.e);
  }
  
  protected boolean b(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public int describeContents()
  {
    ax localax = CREATOR;
    return 0;
  }
  
  public Parcel e()
  {
    switch (this.f)
    {
    }
    for (;;)
    {
      return this.b;
      this.g = c.a(this.b);
      c.a(this.b, this.g);
      this.f = 2;
      continue;
      c.a(this.b, this.g);
      this.f = 2;
    }
  }
  
  dz f()
  {
    switch (this.c)
    {
    default: 
      throw new IllegalStateException("Invalid creation type: " + this.c);
    case 0: 
      return null;
    case 1: 
      return this.d;
    }
    return this.d;
  }
  
  public String toString()
  {
    an.a(this.d, "Cannot convert to JSON on client side.");
    Parcel localParcel = e();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    a(localStringBuilder, this.d.a(this.e), localParcel);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ax localax = CREATOR;
    ax.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */