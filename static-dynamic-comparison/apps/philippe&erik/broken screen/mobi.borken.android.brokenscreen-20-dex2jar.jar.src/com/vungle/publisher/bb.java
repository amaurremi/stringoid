package com.vungle.publisher;

import android.os.Bundle;

public class bb
  implements ay
{
  protected Bundle a = new Bundle();
  
  public final String a()
  {
    return this.a.getString("incentivizedUserId");
  }
  
  public final void a(Orientation paramOrientation)
  {
    this.a.putParcelable("orientation", paramOrientation);
  }
  
  public final void a(String paramString)
  {
    this.a.putString("incentivizedCancelDialogBodyText", paramString);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a.putBoolean("isBackButtonEnabled", paramBoolean);
  }
  
  public final void b(String paramString)
  {
    this.a.putString("incentivizedCancelDialogNegativeButtonText", paramString);
  }
  
  public final void b(boolean paramBoolean)
  {
    this.a.putBoolean("isIncentivized", paramBoolean);
  }
  
  public final void c(String paramString)
  {
    this.a.putString("incentivizedCancelDialogPositiveButtonText", paramString);
  }
  
  public final void c(boolean paramBoolean)
  {
    this.a.putBoolean("isSoundEnabled", paramBoolean);
  }
  
  public final void d(String paramString)
  {
    this.a.putString("incentivizedCancelDialogTitle", paramString);
  }
  
  public final void e(String paramString)
  {
    this.a.putString("incentivizedUserId", paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    return this.a.equals(paramObject);
  }
  
  public String getIncentivizedCancelDialogBodyText()
  {
    return this.a.getString("incentivizedCancelDialogBodyText");
  }
  
  public String getIncentivizedCancelDialogCloseButtonText()
  {
    return this.a.getString("incentivizedCancelDialogNegativeButtonText");
  }
  
  public String getIncentivizedCancelDialogKeepWatchingButtonText()
  {
    return this.a.getString("incentivizedCancelDialogPositiveButtonText");
  }
  
  public String getIncentivizedCancelDialogTitle()
  {
    return this.a.getString("incentivizedCancelDialogTitle");
  }
  
  public Orientation getOrientation()
  {
    return (Orientation)this.a.getParcelable("orientation");
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public boolean isBackButtonImmediatelyEnabled()
  {
    return this.a.getBoolean("isBackButtonEnabled");
  }
  
  public boolean isIncentivized()
  {
    return this.a.getBoolean("isIncentivized");
  }
  
  public boolean isSoundEnabled()
  {
    return this.a.getBoolean("isSoundEnabled");
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */