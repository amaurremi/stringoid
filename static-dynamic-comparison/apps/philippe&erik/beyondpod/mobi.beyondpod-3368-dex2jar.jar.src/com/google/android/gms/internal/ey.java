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

public class ey
  extends es
  implements SafeParcelable
{
  public static final ez CREATOR = new ez();
  private final int kg;
  private final String mClassName;
  private int qA;
  private int qB;
  private final ev qq;
  private final Parcel qy;
  private final int qz;
  
  ey(int paramInt, Parcel paramParcel, ev paramev)
  {
    this.kg = paramInt;
    this.qy = ((Parcel)eg.f(paramParcel));
    this.qz = 2;
    this.qq = paramev;
    if (this.qq == null) {}
    for (this.mClassName = null;; this.mClassName = this.qq.cz())
    {
      this.qA = 2;
      return;
    }
  }
  
  private ey(SafeParcelable paramSafeParcelable, ev paramev, String paramString)
  {
    this.kg = 1;
    this.qy = Parcel.obtain();
    paramSafeParcelable.writeToParcel(this.qy, 0);
    this.qz = 1;
    this.qq = ((ev)eg.f(paramev));
    this.mClassName = ((String)eg.f(paramString));
    this.qA = 2;
  }
  
  public static <T extends es,  extends SafeParcelable> ey a(T paramT)
  {
    String str = paramT.getClass().getCanonicalName();
    ev localev = b(paramT);
    return new ey((SafeParcelable)paramT, localev, str);
  }
  
  private static void a(ev paramev, es parames)
  {
    Object localObject = parames.getClass();
    if (!paramev.b((Class)localObject))
    {
      HashMap localHashMap = parames.cj();
      paramev.a((Class)localObject, parames.cj());
      localObject = localHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        parames = (es.a)localHashMap.get((String)((Iterator)localObject).next());
        Class localClass = parames.cr();
        if (localClass != null) {
          try
          {
            a(paramev, (es)localClass.newInstance());
          }
          catch (InstantiationException paramev)
          {
            throw new IllegalStateException("Could not instantiate an object of type " + parames.cr().getCanonicalName(), paramev);
          }
          catch (IllegalAccessException paramev)
          {
            throw new IllegalStateException("Could not access object of type " + parames.cr().getCanonicalName(), paramev);
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
      paramStringBuilder.append("\"").append(fe.aa(paramObject.toString())).append("\"");
      return;
    case 8: 
      paramStringBuilder.append("\"").append(fb.b((byte[])paramObject)).append("\"");
      return;
    case 9: 
      paramStringBuilder.append("\"").append(fb.c((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      ff.a(paramStringBuilder, (HashMap)paramObject);
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void a(StringBuilder paramStringBuilder, es.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    switch (parama.ci())
    {
    default: 
      throw new IllegalArgumentException("Unknown field out type = " + parama.ci());
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
      b(paramStringBuilder, parama, a(parama, c(a.o(paramParcel, paramInt))));
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString, es.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    paramStringBuilder.append("\"").append(paramString).append("\":");
    if (parama.ct())
    {
      a(paramStringBuilder, parama, paramParcel, paramInt);
      return;
    }
    b(paramStringBuilder, parama, paramParcel, paramInt);
  }
  
  private void a(StringBuilder paramStringBuilder, HashMap<String, es.a<?, ?>> paramHashMap, Parcel paramParcel)
  {
    paramHashMap = c(paramHashMap);
    paramStringBuilder.append('{');
    int j = a.n(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      Map.Entry localEntry = (Map.Entry)paramHashMap.get(Integer.valueOf(a.M(k)));
      if (localEntry != null)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        a(paramStringBuilder, (String)localEntry.getKey(), (es.a)localEntry.getValue(), paramParcel, k);
        i = 1;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    paramStringBuilder.append('}');
  }
  
  private static ev b(es parames)
  {
    ev localev = new ev(parames.getClass());
    a(localev, parames);
    localev.cx();
    localev.cw();
    return localev;
  }
  
  private void b(StringBuilder paramStringBuilder, es.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    if (parama.co())
    {
      paramStringBuilder.append("[");
      switch (parama.ci())
      {
      default: 
        throw new IllegalStateException("Unknown field type out.");
      case 0: 
        fa.a(paramStringBuilder, a.r(paramParcel, paramInt));
      }
      for (;;)
      {
        paramStringBuilder.append("]");
        return;
        fa.a(paramStringBuilder, a.t(paramParcel, paramInt));
        continue;
        fa.a(paramStringBuilder, a.s(paramParcel, paramInt));
        continue;
        fa.a(paramStringBuilder, a.u(paramParcel, paramInt));
        continue;
        fa.a(paramStringBuilder, a.v(paramParcel, paramInt));
        continue;
        fa.a(paramStringBuilder, a.w(paramParcel, paramInt));
        continue;
        fa.a(paramStringBuilder, a.q(paramParcel, paramInt));
        continue;
        fa.a(paramStringBuilder, a.x(paramParcel, paramInt));
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
          a(paramStringBuilder, parama.cv(), paramParcel[paramInt]);
          paramInt += 1;
        }
      }
    }
    switch (parama.ci())
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
      paramStringBuilder.append("\"").append(fe.aa(parama)).append("\"");
      return;
    case 8: 
      parama = a.p(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(fb.b(parama)).append("\"");
      return;
    case 9: 
      parama = a.p(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(fb.c(parama));
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
        paramStringBuilder.append("\"").append(fe.aa(parama.getString(str))).append("\"");
      }
      paramStringBuilder.append("}");
      return;
    }
    paramParcel = a.z(paramParcel, paramInt);
    paramParcel.setDataPosition(0);
    a(paramStringBuilder, parama.cv(), paramParcel);
  }
  
  private void b(StringBuilder paramStringBuilder, es.a<?, ?> parama, Object paramObject)
  {
    if (parama.cn())
    {
      b(paramStringBuilder, parama, (ArrayList)paramObject);
      return;
    }
    a(paramStringBuilder, parama.ch(), paramObject);
  }
  
  private void b(StringBuilder paramStringBuilder, es.a<?, ?> parama, ArrayList<?> paramArrayList)
  {
    paramStringBuilder.append("[");
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      a(paramStringBuilder, parama.ch(), paramArrayList.get(i));
      i += 1;
    }
    paramStringBuilder.append("]");
  }
  
  public static HashMap<String, String> c(Bundle paramBundle)
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
  
  private static HashMap<Integer, Map.Entry<String, es.a<?, ?>>> c(HashMap<String, es.a<?, ?>> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      localHashMap.put(Integer.valueOf(((es.a)localEntry.getValue()).cq()), localEntry);
    }
    return localHashMap;
  }
  
  protected Object V(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  protected boolean W(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public Parcel cB()
  {
    switch (this.qA)
    {
    }
    for (;;)
    {
      return this.qy;
      this.qB = b.o(this.qy);
      b.D(this.qy, this.qB);
      this.qA = 2;
      continue;
      b.D(this.qy, this.qB);
      this.qA = 2;
    }
  }
  
  ev cC()
  {
    switch (this.qz)
    {
    default: 
      throw new IllegalStateException("Invalid creation type: " + this.qz);
    case 0: 
      return null;
    case 1: 
      return this.qq;
    }
    return this.qq;
  }
  
  public HashMap<String, es.a<?, ?>> cj()
  {
    if (this.qq == null) {
      return null;
    }
    return this.qq.Z(this.mClassName);
  }
  
  public int describeContents()
  {
    ez localez = CREATOR;
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public String toString()
  {
    eg.b(this.qq, "Cannot convert to JSON on client side.");
    Parcel localParcel = cB();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    a(localStringBuilder, this.qq.Z(this.mClassName), localParcel);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ez localez = CREATOR;
    ez.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */