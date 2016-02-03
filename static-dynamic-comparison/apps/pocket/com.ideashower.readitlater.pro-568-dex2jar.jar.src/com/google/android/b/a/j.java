package com.google.android.b.a;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.b.a.a.d;

public class j
  extends Fragment
  implements i
{
  private final k a = new k(this, (byte)0);
  private Bundle b;
  private l c;
  private String d;
  private f e;
  
  public static j a()
  {
    return new j();
  }
  
  private void b()
  {
    if ((this.c != null) && (this.e != null))
    {
      this.c.a(m(), this, this.d, this.e, this.b);
      this.b = null;
      this.e = null;
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = new l(m(), null, 0, this.a);
    b();
    return this.c;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE");; paramBundle = null)
    {
      this.b = paramBundle;
      return;
    }
  }
  
  public void a(String paramString, f paramf)
  {
    this.d = d.a(paramString, "Developer key cannot be null or empty");
    this.e = paramf;
    b();
  }
  
  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    if (this.c != null) {}
    for (Bundle localBundle = this.c.e();; localBundle = this.b)
    {
      paramBundle.putBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE", localBundle);
      return;
    }
  }
  
  public void g()
  {
    super.g();
    this.c.a();
  }
  
  public void h()
  {
    this.c.d();
    super.h();
  }
  
  public void i()
  {
    this.c.b(m().isFinishing());
    this.c = null;
    super.i();
  }
  
  public void w()
  {
    super.w();
    this.c.b();
  }
  
  public void x()
  {
    this.c.c();
    super.x();
  }
  
  public void y()
  {
    l locall;
    if (this.c != null)
    {
      android.support.v4.app.f localf = m();
      locall = this.c;
      if ((localf != null) && (!localf.isFinishing())) {
        break label40;
      }
    }
    label40:
    for (boolean bool = true;; bool = false)
    {
      locall.a(bool);
      super.y();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */