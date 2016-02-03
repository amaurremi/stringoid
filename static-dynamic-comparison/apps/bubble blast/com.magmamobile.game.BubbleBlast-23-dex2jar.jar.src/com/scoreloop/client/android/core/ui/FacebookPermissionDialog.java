package com.scoreloop.client.android.core.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import com.a.a.c;
import com.a.a.e;
import com.a.a.j;

public class FacebookPermissionDialog
  extends Dialog
{
  private e a;
  private j b;
  
  public FacebookPermissionDialog(Context paramContext, j paramj)
  {
    super(paramContext, 16973841);
    this.b = paramj;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.b.b(this.a);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.a = new e(getContext(), c.a(), new String[] { "publish_stream", "offline_access" });
    this.a.a(this.b);
    this.a.c();
    setContentView(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/ui/FacebookPermissionDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */