package com.pocket.d;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Filter;
import com.android.ex.chips.aa;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.f.i;
import com.pocket.h.e;
import com.pocket.m.a.c;
import java.io.File;

public class j
  extends a
  implements e
{
  private final com.pocket.h.d g = new com.pocket.h.d(paramContext, this);
  private final String h;
  
  public j(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    this.g.b(false);
    this.h = as.j();
    j().setVisibility(8);
  }
  
  private String r()
  {
    return c.c("tempAvatar-contacts");
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      a(BitmapFactory.decodeFile(paramBundle.getString("path")));
      j().setVisibility(0);
    }
  }
  
  public void a(com.pocket.h.d paramd)
  {
    if (l() != null) {}
    do
    {
      do
      {
        return;
      } while (paramd.getCount() == 0);
      paramd = ((aa)paramd.getItem(0)).g();
    } while (paramd == null);
    paramd = BitmapFactory.decodeByteArray(paramd, 0, paramd.length);
    i.a(r(), paramd, com.pocket.m.a.d.a());
    a(paramd);
    j().setVisibility(0);
  }
  
  public int c()
  {
    return 2131493263;
  }
  
  protected int d()
  {
    return 0;
  }
  
  protected void e() {}
  
  public void f()
  {
    this.g.getFilter().filter(this.h);
  }
  
  public File n()
  {
    if (this.f != null) {
      return new File(r());
    }
    return null;
  }
  
  public String o()
  {
    return "contacts";
  }
  
  public Bundle p()
  {
    if (this.f != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("path", r());
      return localBundle;
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */