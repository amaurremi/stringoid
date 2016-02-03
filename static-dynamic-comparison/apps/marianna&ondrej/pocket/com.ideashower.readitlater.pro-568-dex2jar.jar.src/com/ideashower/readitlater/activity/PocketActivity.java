package com.ideashower.readitlater.activity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.util.j;
import com.pocket.tts.f;
import java.util.Locale;
import org.apache.a.c.k;

public class PocketActivity
  extends a
{
  private boolean A;
  private int z;
  
  public int C()
  {
    return this.z;
  }
  
  protected void c(boolean paramBoolean)
  {
    if (this.A)
    {
      this.A = false;
      paramBoolean = true;
    }
    super.c(paramBoolean);
  }
  
  public void d(int paramInt)
  {
    this.z = paramInt;
    if (this.z == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.x = bool;
      return;
    }
  }
  
  public String f()
  {
    return "list";
  }
  
  protected b l()
  {
    return b.a;
  }
  
  protected Drawable m()
  {
    if ((this.z != 0) && (j.g())) {
      return getResources().getDrawable(2130837749);
    }
    return super.m();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i;
    if (!isFinishing())
    {
      if (paramBundle == null) {
        break label77;
      }
      i = paramBundle.getInt("stateActiveWalkthrough");
      this.z = i;
      if (this.z == 0)
      {
        if (i.a(com.ideashower.readitlater.h.a.y)) {
          break label82;
        }
        this.z = 1;
      }
    }
    for (;;)
    {
      if (this.z != 0) {
        this.A = true;
      }
      super.onCreate(paramBundle);
      if (paramBundle == null) {
        b(ai.Y());
      }
      g.a(this);
      return;
      label77:
      i = 0;
      break;
      label82:
      if (i.a(com.ideashower.readitlater.h.a.aX)) {
        if ((k.b("en", getResources().getConfiguration().locale.getLanguage())) || (!f.a(this))) {
          this.z = 3;
        } else {
          i.a(com.ideashower.readitlater.h.a.aX, false);
        }
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    g.b(this);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("stateActiveWalkthrough", this.z);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/PocketActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */