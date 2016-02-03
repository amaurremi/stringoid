package com.google.android.gms.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ee
{
  private final a GG;
  private final View qV;
  
  public ee(String paramString1, Collection<String> paramCollection, int paramInt, View paramView, String paramString2)
  {
    this.GG = new a(paramString1, paramCollection, paramInt, paramString2);
    this.qV = paramView;
  }
  
  public String qi()
  {
    return this.GG.qi();
  }
  
  public List<String> qj()
  {
    return this.GG.qj();
  }
  
  public static final class a
    implements SafeParcelable
  {
    public static final da GH = new da();
    private final List<String> GI = new ArrayList();
    private final String qS;
    private final int qU;
    private final String qW;
    private final int qh;
    
    a(int paramInt1, String paramString1, List<String> paramList, int paramInt2, String paramString2)
    {
      this.qh = paramInt1;
      this.qS = paramString1;
      this.GI.addAll(paramList);
      this.qU = paramInt2;
      this.qW = paramString2;
    }
    
    public a(String paramString1, Collection<String> paramCollection, int paramInt, String paramString2)
    {
      this(3, paramString1, new ArrayList(paramCollection), paramInt, paramString2);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public int lX()
    {
      return this.qh;
    }
    
    public String qi()
    {
      if (this.qS != null) {
        return this.qS;
      }
      return "<<default account>>";
    }
    
    public List<String> qj()
    {
      return new ArrayList(this.GI);
    }
    
    public String qk()
    {
      return this.qS;
    }
    
    public int ql()
    {
      return this.qU;
    }
    
    public String qm()
    {
      return this.qW;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      da.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */