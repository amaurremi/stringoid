package com.pocket.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.al;
import com.ideashower.readitlater.activity.h;
import com.ideashower.readitlater.objects.UserMessage;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.toolbars.ToolbarLayout;
import com.pocket.p.l;
import com.pocket.q.a.b;
import com.pocket.q.a.m;
import com.pocket.q.a.p;
import com.pocket.q.a.q;
import com.pocket.q.a.r;
import com.pocket.user.UserMeta;
import java.util.ArrayList;

public class a
  extends h
{
  public static l ab()
  {
    return l.c;
  }
  
  public static a ac()
  {
    return new a();
  }
  
  public String K()
  {
    return "settings";
  }
  
  protected int Y()
  {
    return 2131493476;
  }
  
  protected View Z()
  {
    return null;
  }
  
  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
    if (!(paramActivity instanceof e)) {
      throw new RuntimeException("unsupported activity " + paramActivity);
    }
    if (!g.y()) {
      throw new RuntimeException("unsupported activity mode");
    }
  }
  
  protected void a(ArrayList paramArrayList)
  {
    if (!g.y()) {
      return;
    }
    paramArrayList.add(new com.pocket.q.a.j(this, "Premium Tools"));
    if (as.k().h().d() == 1) {}
    for (String str = "(Premium)";; str = "(Free)")
    {
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.cr, "Premium Status").d("Actual " + str).d("Fake - Premium").d("Fake - Free").a(new m()
      {
        public void a(int paramAnonymousInt)
        {
          paramAnonymousInt = 0;
          while (paramAnonymousInt < 2)
          {
            Toast.makeText(a.this.m(), "Warning: This test toggle only changes the status locally. This does not effect your actual status. So only use this for testing UI.", 1).show();
            paramAnonymousInt += 1;
          }
          as.y();
        }
        
        public boolean a(int paramAnonymousInt, DialogInterface paramAnonymousDialogInterface)
        {
          return true;
        }
      }).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.cs, "Shake Action").d("Report Issue").d("Toggle Premium/Free").d("None").d("Toggle Dark/Light Theme").b());
      paramArrayList.add(p.b(this, "Clear Recent Searches").a(new b()
      {
        public void a()
        {
          new com.ideashower.readitlater.db.operation.j()
          {
            protected void c_()
            {
              u();
            }
          }.f();
          Toast.makeText(a.this.m(), "Cleared! Note: this only clears them locally, doesn't remove them from your account.", 1).show();
        }
      }).a());
      paramArrayList.add(p.b(this, "View Update Tour").a(new b()
      {
        public void a()
        {
          al.a(a.this.m(), 1, null);
        }
      }).a());
      paramArrayList.add(p.b(this, "View Purchase View").a(new b()
      {
        public void a()
        {
          al.a(a.this.m(), 2, null);
        }
      }).a());
      paramArrayList.add(p.b(this, "View Purchase Complete View").a(new b()
      {
        public void a()
        {
          al.a(a.this.m(), 3, null);
        }
      }).a());
      paramArrayList.add(p.b(this, "Show popup User Message").a(new b()
      {
        public void a()
        {
          UserMessage localUserMessage = UserMessage.a("{\r\n    \"message_id\": \"28\",\r\n    \"message_ui_id\": \"1\",\r\n    \"title\": \"Your Premium Subscription Has Expired\",\r\n    \"message\": \"Your Comped subscription to Pocket Premium has expired. Renew to keep using Premium features.\",\r\n    \"buttons\": [\r\n        {\r\n            \"label\": \"No Thanks\",\r\n            \"action\": \"close\"\r\n        },\r\n        {\r\n            \"label\": \"Renew\",\r\n            \"action\": \"pocket://internal/renew\"\r\n        }\r\n    ]\r\n}");
          com.ideashower.readitlater.activity.a.t.a((com.ideashower.readitlater.activity.a)a.this.m(), localUserMessage);
        }
      }).a());
      paramArrayList.add(p.a(this, "AB Tests"));
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.cm, "Enable Overrides").c("Will use server assigned values").d("Will use values below").b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.cn, "AB Test - Google SSO Enabled").c(com.ideashower.readitlater.h.a.cm, true).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.co, "AB Test - Learn More Enabled").c(com.ideashower.readitlater.h.a.cm, true).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.cp, "AB Test - Show Premium Tag upsell").c(com.ideashower.readitlater.h.a.cm, true).b());
      paramArrayList.add(p.a(this, com.ideashower.readitlater.h.a.cq, "AB Test - Show Premium Search upsell").c(com.ideashower.readitlater.h.a.cm, true).b());
      return;
    }
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    ((StyledToolbar)((ToolbarLayout)c(2131230729)).getTopToolbar()).setTitle("Dev/Beta Settings");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/app/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */