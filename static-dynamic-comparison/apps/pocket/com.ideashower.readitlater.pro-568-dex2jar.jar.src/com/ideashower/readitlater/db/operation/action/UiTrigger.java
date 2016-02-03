package com.ideashower.readitlater.db.operation.action;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ideashower.readitlater.a.g;

public class UiTrigger
  implements Parcelable
{
  public static final UiTrigger A;
  public static final UiTrigger B;
  public static final UiTrigger C;
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public UiTrigger a(Parcel paramAnonymousParcel)
    {
      return new UiTrigger(paramAnonymousParcel);
    }
    
    public UiTrigger[] a(int paramAnonymousInt)
    {
      return new UiTrigger[paramAnonymousInt];
    }
  };
  public static final UiTrigger D;
  public static final UiTrigger E;
  public static final UiTrigger F;
  public static final UiTrigger a = new UiTrigger("clipboard");
  public static final UiTrigger b = new UiTrigger("intent");
  public static final UiTrigger c = new UiTrigger("intent_w_overlay");
  public static final UiTrigger d = new UiTrigger("back");
  public static final UiTrigger e = new UiTrigger("left_navigation_menu");
  public static final UiTrigger f = new UiTrigger("item_menu");
  public static final UiTrigger g = new UiTrigger("bulk_edit");
  public static final UiTrigger h = new UiTrigger("undo_bar");
  public static final UiTrigger i = new UiTrigger("long_press");
  public static final UiTrigger j = new UiTrigger("toolbar");
  public static final UiTrigger k = new UiTrigger("toolbar_quote");
  public static final UiTrigger l = new UiTrigger("attribution");
  public static final UiTrigger m = new UiTrigger("link_menu_offline");
  public static final UiTrigger n = new UiTrigger("link");
  public static final UiTrigger o = new UiTrigger("link_switch_view");
  public static final UiTrigger p = new UiTrigger("error_try_again");
  public static final UiTrigger q = new UiTrigger("view_toggle");
  public static final UiTrigger r = new UiTrigger("form");
  public static final UiTrigger s = new UiTrigger("subscription_login");
  public static final UiTrigger t = new UiTrigger("reader_back_ssl");
  public static final UiTrigger u = new UiTrigger("p_lib_update_button");
  public static final UiTrigger v = new UiTrigger("listen_remote");
  public static final UiTrigger w = new UiTrigger("dialog_sd_card_error");
  public static final UiTrigger x = new UiTrigger("dialog_storage_locat");
  public static final UiTrigger y = new UiTrigger("inbox_attribution");
  public static final UiTrigger z = new UiTrigger("settings");
  private final String G;
  
  static
  {
    A = new UiTrigger("logout");
    B = new UiTrigger("login");
    C = new UiTrigger("notification");
    D = new UiTrigger("galaxy_gear");
    E = new UiTrigger("media_button");
    F = new UiTrigger("listen_notification");
  }
  
  public UiTrigger(Parcel paramParcel)
  {
    this.G = paramParcel.readString();
  }
  
  private UiTrigger(String paramString)
  {
    this.G = paramString;
    if ((g.y()) && (paramString.length() > 20)) {
      throw new RuntimeException("UiTrigger " + paramString + " is " + paramString.length() + " chars long. Maximum length is " + 20);
    }
  }
  
  public static UiTrigger a(String paramString)
  {
    return new UiTrigger(paramString);
  }
  
  public String a()
  {
    return this.G;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.G);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/UiTrigger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */