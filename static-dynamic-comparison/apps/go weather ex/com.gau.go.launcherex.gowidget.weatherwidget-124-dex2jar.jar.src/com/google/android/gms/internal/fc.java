package com.google.android.gms.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class fc
{
  private final View AV;
  private final a CT;
  
  public fc(String paramString1, Collection<String> paramCollection, int paramInt, View paramView, String paramString2)
  {
    this.CT = new a(paramString1, paramCollection, paramInt, paramString2);
    this.AV = paramView;
  }
  
  public String eC()
  {
    return this.CT.eC();
  }
  
  public int eD()
  {
    return this.CT.eD();
  }
  
  public List<String> eE()
  {
    return this.CT.eE();
  }
  
  public String[] eF()
  {
    return (String[])this.CT.eE().toArray(new String[0]);
  }
  
  public String eG()
  {
    return this.CT.eG();
  }
  
  public View eH()
  {
    return this.AV;
  }
  
  public String getAccountName()
  {
    return this.CT.getAccountName();
  }
  
  public static final class a
    implements SafeParcelable
  {
    public static final fp CREATOR = new fp();
    private final int AU;
    private final String AW;
    private final List<String> CU = new ArrayList();
    private final String wG;
    private final int xH;
    
    a(int paramInt1, String paramString1, List<String> paramList, int paramInt2, String paramString2)
    {
      this.xH = paramInt1;
      this.wG = paramString1;
      this.CU.addAll(paramList);
      this.AU = paramInt2;
      this.AW = paramString2;
    }
    
    public a(String paramString1, Collection<String> paramCollection, int paramInt, String paramString2)
    {
      this(3, paramString1, new ArrayList(paramCollection), paramInt, paramString2);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String eC()
    {
      if (this.wG != null) {
        return this.wG;
      }
      return "<<default account>>";
    }
    
    public int eD()
    {
      return this.AU;
    }
    
    public List<String> eE()
    {
      return new ArrayList(this.CU);
    }
    
    public String eG()
    {
      return this.AW;
    }
    
    public String getAccountName()
    {
      return this.wG;
    }
    
    public int getVersionCode()
    {
      return this.xH;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      fp.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/fc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */