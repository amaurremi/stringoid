package com.pocket.gsf;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.p;
import org.apache.a.c.k;

public class GSFDemoStep
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public GSFDemoStep a(Parcel paramAnonymousParcel)
    {
      return new GSFDemoStep(paramAnonymousParcel);
    }
    
    public GSFDemoStep[] a(int paramAnonymousInt)
    {
      return new GSFDemoStep[paramAnonymousInt];
    }
  };
  private final String a;
  private final String b;
  
  public GSFDemoStep(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public GSFDemoStep(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public Drawable a(Context paramContext)
  {
    if (this.b == null) {
      return null;
    }
    String str;
    if (this.b.equals("gsf_step_menu")) {
      if (j.i()) {
        str = "gsf_step_hard_menu";
      }
    }
    Resources localResources;
    int i;
    for (;;)
    {
      localResources = paramContext.getResources();
      i = localResources.getIdentifier(str, "drawable", paramContext.getPackageName());
      if (i != 0) {
        break label102;
      }
      if (!g.y()) {
        break;
      }
      throw new RuntimeException("drawable not found " + str);
      str = "gsf_step_menu_overflow";
      continue;
      str = this.b;
    }
    return null;
    label102:
    return new p(i, paramContext, localResources.getColorStateList(2131165407));
  }
  
  public String a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return k.a(this.b, "gsf_step_share_or_menu");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/gsf/GSFDemoStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */