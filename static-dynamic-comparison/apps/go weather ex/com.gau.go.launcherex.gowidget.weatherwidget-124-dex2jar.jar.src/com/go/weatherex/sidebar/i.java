package com.go.weatherex.sidebar;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class i
  implements Parcelable.Creator
{
  public SidebarDrawerLayout.SavedState a(Parcel paramParcel)
  {
    return new SidebarDrawerLayout.SavedState(paramParcel);
  }
  
  public SidebarDrawerLayout.SavedState[] a(int paramInt)
  {
    return new SidebarDrawerLayout.SavedState[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/sidebar/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */