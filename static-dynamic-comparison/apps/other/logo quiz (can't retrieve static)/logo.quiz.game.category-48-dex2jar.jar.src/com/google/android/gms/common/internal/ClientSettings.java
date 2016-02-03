package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ClientSettings
{
  private final View IG;
  private final ParcelableClientSettings Lk;
  
  public ClientSettings(String paramString1, Collection<String> paramCollection, int paramInt, View paramView, String paramString2)
  {
    this.Lk = new ParcelableClientSettings(paramString1, paramCollection, paramInt, paramString2);
    this.IG = paramView;
  }
  
  public String getAccountName()
  {
    return this.Lk.getAccountName();
  }
  
  public String getAccountNameOrDefault()
  {
    return this.Lk.getAccountNameOrDefault();
  }
  
  public int getGravityForPopups()
  {
    return this.Lk.getGravityForPopups();
  }
  
  public ParcelableClientSettings getParcelableClientSettings()
  {
    return this.Lk;
  }
  
  public String getRealClientPackageName()
  {
    return this.Lk.getRealClientPackageName();
  }
  
  public List<String> getScopes()
  {
    return this.Lk.getScopes();
  }
  
  public String[] getScopesArray()
  {
    return (String[])this.Lk.getScopes().toArray(new String[0]);
  }
  
  public View getViewForPopups()
  {
    return this.IG;
  }
  
  public static final class ParcelableClientSettings
    implements SafeParcelable
  {
    public static final ParcelableClientSettingsCreator CREATOR = new ParcelableClientSettingsCreator();
    private final int BR;
    private final String Dd;
    private final int IF;
    private final String IH;
    private final List<String> Jd = new ArrayList();
    
    ParcelableClientSettings(int paramInt1, String paramString1, List<String> paramList, int paramInt2, String paramString2)
    {
      this.BR = paramInt1;
      this.Dd = paramString1;
      this.Jd.addAll(paramList);
      this.IF = paramInt2;
      this.IH = paramString2;
    }
    
    public ParcelableClientSettings(String paramString1, Collection<String> paramCollection, int paramInt, String paramString2)
    {
      this(3, paramString1, new ArrayList(paramCollection), paramInt, paramString2);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getAccountName()
    {
      return this.Dd;
    }
    
    public String getAccountNameOrDefault()
    {
      if (this.Dd != null) {
        return this.Dd;
      }
      return "<<default account>>";
    }
    
    public int getGravityForPopups()
    {
      return this.IF;
    }
    
    public String getRealClientPackageName()
    {
      return this.IH;
    }
    
    public List<String> getScopes()
    {
      return new ArrayList(this.Jd);
    }
    
    public int getVersionCode()
    {
      return this.BR;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ParcelableClientSettingsCreator.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/internal/ClientSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */