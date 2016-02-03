package com.ideashower.readitlater.activity;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.a.b;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.objects.e;
import com.ideashower.readitlater.reader.ReaderWebView;
import com.ideashower.readitlater.reader.f;
import com.ideashower.readitlater.util.a;

public class at
  extends b
{
  protected String Z;
  
  public at(ReaderFragment paramReaderFragment) {}
  
  public AlertDialog.Builder a(AlertDialog.Builder paramBuilder)
  {
    this.Z = l().getString("clickedUrl");
    if (ReaderFragment.u(this.aa) == null) {
      ReaderFragment.a(this.aa, new String[] { c(2131493469), c(2131493468), c(2131493490), c(2131493454) });
    }
    paramBuilder.setItems(ReaderFragment.u(this.aa), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        boolean bool = true;
        if ((paramAnonymousInt != 3) && (a.a())) {
          at.this.aa.Y.n();
        }
        String str;
        if (paramAnonymousInt != 0)
        {
          paramAnonymousDialogInterface = at.this.aa;
          str = at.this.Z;
          if (paramAnonymousInt != 1) {
            break label93;
          }
        }
        for (;;)
        {
          ReaderFragment.a(paramAnonymousDialogInterface, str, bool, UiTrigger.i);
          switch (paramAnonymousInt)
          {
          default: 
            return;
            label93:
            bool = false;
          }
        }
        paramAnonymousInt = ReaderFragment.c(at.this.aa).e(at.this.Z);
        if (paramAnonymousInt != 0)
        {
          at.this.aa.a(at.this.Z, paramAnonymousInt, UiTrigger.i);
          return;
        }
        ReaderFragment.a(at.this.aa, at.this.Z, null, at.this.aa.b(UiTrigger.i));
        return;
        ReaderFragment.a(at.this.aa, at.this.Z, null, UiTrigger.i);
        return;
        g.a(at.this.m(), at.this.Z);
        return;
        e.a(at.this.m()).a(at.this.Z, at.this.a(2131493515));
      }
    });
    return paramBuilder;
  }
  
  public void a(String paramString)
  {
    this.Z = paramString;
  }
  
  protected Bundle l(Bundle paramBundle)
  {
    paramBundle.putString("clickedUrl", this.Z);
    return super.l(paramBundle);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (a.a()) {
      this.aa.Y.n();
    }
    super.onCancel(paramDialogInterface);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */