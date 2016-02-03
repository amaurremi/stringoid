package com.ideashower.readitlater.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.ideashower.readitlater.a.c;
import com.ideashower.readitlater.a.v;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.views.RilButton;

public class GsfDemoCompleteActivity
  extends a
{
  private boolean z;
  
  protected void c(boolean paramBoolean) {}
  
  public String f()
  {
    return "get_started_flow_success";
  }
  
  protected b l()
  {
    return b.a;
  }
  
  protected Drawable m()
  {
    return new ColorDrawable(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903048);
    i.b(com.ideashower.readitlater.h.a.bE);
    this.z = c.f();
    paramBundle = (RilButton)findViewById(2131230774);
    paramBundle.setClickable(false);
    paramBundle.setFocusable(false);
    if (this.z)
    {
      paramBundle.setText(2131492924);
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          v.o();
          GsfDemoCompleteActivity.this.finish();
        }
      });
      ((TextView)findViewById(2131230793)).setText(2131493194);
      return;
    }
    findViewById(2131230790).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        v.d();
        GsfDemoCompleteActivity.this.finish();
        paramAnonymousView = new Intent(GsfDemoCompleteActivity.this, GsfActivity.class);
        paramAnonymousView.addFlags(335544320);
        paramAnonymousView.putExtra("extraSuccess", true);
        GsfDemoCompleteActivity.this.startActivity(paramAnonymousView);
      }
    });
  }
  
  public void onPause()
  {
    super.onPause();
    if (!isFinishing())
    {
      if (this.z) {
        v.o();
      }
      finish();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/GsfDemoCompleteActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */