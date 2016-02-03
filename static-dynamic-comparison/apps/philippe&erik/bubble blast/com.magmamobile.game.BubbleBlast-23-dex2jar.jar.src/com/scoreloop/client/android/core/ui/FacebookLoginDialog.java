package com.scoreloop.client.android.core.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import com.a.a.b;
import com.a.a.c;
import com.a.a.j;

public class FacebookLoginDialog
  extends Dialog
{
  private j a;
  private b b;
  
  public FacebookLoginDialog(Context paramContext, j paramj)
  {
    super(paramContext, 16973841);
    this.a = paramj;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.a.b(this.b);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.b = new b(getContext(), c.a());
    this.b.a("Scoreloop");
    this.b.a(this.a);
    this.b.c();
    setContentView(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/ui/FacebookLoginDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */