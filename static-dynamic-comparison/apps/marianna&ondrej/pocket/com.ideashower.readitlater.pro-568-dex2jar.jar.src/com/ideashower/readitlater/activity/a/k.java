package com.ideashower.readitlater.activity.a;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.m;
import com.pocket.m.a.c;

public class k
  extends b
{
  private static boolean Y = false;
  
  public static k M()
  {
    k localk = new k();
    localk.b(2131493128, String.format(g.a(2131493127), new Object[] { com.pocket.m.a.l.c().j() }));
    return localk;
  }
  
  protected boolean L()
  {
    return Y;
  }
  
  protected boolean O()
  {
    return false;
  }
  
  public AlertDialog.Builder a(AlertDialog.Builder paramBuilder)
  {
    paramBuilder = super.a(paramBuilder);
    paramBuilder.setIcon(17301543).setNeutralButton(c(2131492880), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ((com.ideashower.readitlater.activity.a)k.this.m()).b(false);
      }
    }).setNegativeButton(c(2131492878), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        l.b(1).a((com.ideashower.readitlater.activity.a)k.this.m());
        com.pocket.m.a.l.a(1, false, new Runnable()
        {
          public void run()
          {
            a.K().a((com.ideashower.readitlater.activity.a)k.this.m());
            g.s().a();
          }
        }, true);
      }
    });
    return paramBuilder;
  }
  
  protected boolean b_()
  {
    return true;
  }
  
  protected void e(boolean paramBoolean)
  {
    Y = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */