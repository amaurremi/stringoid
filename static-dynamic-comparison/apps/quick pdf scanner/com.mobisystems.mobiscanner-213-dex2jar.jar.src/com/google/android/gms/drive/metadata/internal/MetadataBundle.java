package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.dc;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class MetadataBundle
  implements SafeParcelable
{
  public static final Parcelable.Creator<MetadataBundle> CREATOR = new f();
  final int qh;
  final Bundle ub;
  
  MetadataBundle(int paramInt, Bundle paramBundle)
  {
    this.qh = paramInt;
    this.ub = ((Bundle)dc.N(paramBundle));
    this.ub.setClassLoader(getClass().getClassLoader());
    paramBundle = new ArrayList();
    Object localObject = this.ub.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (c.at(str) == null)
      {
        paramBundle.add(str);
        Log.w("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
      }
    }
    paramBundle = paramBundle.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (String)paramBundle.next();
      this.ub.remove((String)localObject);
    }
  }
  
  private MetadataBundle(Bundle paramBundle)
  {
    this(1, paramBundle);
  }
  
  public static <T> MetadataBundle a(b<T> paramb, T paramT)
  {
    MetadataBundle localMetadataBundle = ns();
    localMetadataBundle.b(paramb, paramT);
    return localMetadataBundle;
  }
  
  public static MetadataBundle a(MetadataBundle paramMetadataBundle)
  {
    return new MetadataBundle(new Bundle(paramMetadataBundle.ub));
  }
  
  public static MetadataBundle ns()
  {
    return new MetadataBundle(new Bundle());
  }
  
  public <T> T a(b<T> paramb)
  {
    return (T)paramb.b(this.ub);
  }
  
  public <T> void b(b<T> paramb, T paramT)
  {
    if (c.at(paramb.getName()) == null) {
      throw new IllegalArgumentException("Unregistered field: " + paramb.getName());
    }
    paramb.a(paramT, this.ub);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof MetadataBundle)) {
      return false;
    }
    paramObject = (MetadataBundle)paramObject;
    Object localObject = this.ub.keySet();
    if (!localObject.equals(((MetadataBundle)paramObject).ub.keySet())) {
      return false;
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!cz.b(this.ub.get(str), ((MetadataBundle)paramObject).ub.get(str))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Iterator localIterator = this.ub.keySet().iterator();
    String str;
    for (int i = 1; localIterator.hasNext(); i = this.ub.get(str).hashCode() + i * 31) {
      str = (String)localIterator.next();
    }
    return i;
  }
  
  public Set<b<?>> nt()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.ub.keySet().iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(c.at((String)localIterator.next()));
    }
    return localHashSet;
  }
  
  public String toString()
  {
    return "MetadataBundle [values=" + this.ub + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/MetadataBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */