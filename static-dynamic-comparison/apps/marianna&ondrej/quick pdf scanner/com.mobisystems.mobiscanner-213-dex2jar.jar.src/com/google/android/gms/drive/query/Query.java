package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;

public class Query
  implements SafeParcelable
{
  public static final Parcelable.Creator<Query> CREATOR = new d();
  final int qh;
  LogicalFilter ud;
  String ue;
  
  Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString)
  {
    this.qh = paramInt;
    this.ud = paramLogicalFilter;
    this.ue = paramString;
  }
  
  Query(LogicalFilter paramLogicalFilter, String paramString)
  {
    this(1, paramLogicalFilter, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public a nv()
  {
    return this.ud;
  }
  
  public String nw()
  {
    return this.ue;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
  
  public static class a
  {
    private String ue;
    private final List<a> uf = new ArrayList();
    
    public a a(a parama)
    {
      this.uf.add(parama);
      return this;
    }
    
    public a av(String paramString)
    {
      this.ue = paramString;
      return this;
    }
    
    public Query nx()
    {
      return new Query(new LogicalFilter(Operator.uI, this.uf), this.ue);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/query/Query.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */