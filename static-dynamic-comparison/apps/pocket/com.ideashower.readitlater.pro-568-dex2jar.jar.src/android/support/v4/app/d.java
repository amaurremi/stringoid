package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

public class d
  extends Fragment
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener
{
  int a = 0;
  int b = 0;
  boolean c = true;
  boolean d = true;
  int e = -1;
  Dialog f;
  boolean g;
  boolean h;
  boolean i;
  
  public int a(n paramn, String paramString)
  {
    this.h = false;
    this.i = true;
    paramn.a(this, paramString);
    this.g = false;
    this.e = paramn.a();
    return this.e;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    if ((this.a == 2) || (this.a == 3)) {
      this.b = 16973913;
    }
    if (paramInt2 != 0) {
      this.b = paramInt2;
    }
  }
  
  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
    if (!this.i) {
      this.h = false;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.G == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.d = bool;
      if (paramBundle != null)
      {
        this.a = paramBundle.getInt("android:style", 0);
        this.b = paramBundle.getInt("android:theme", 0);
        this.c = paramBundle.getBoolean("android:cancelable", true);
        this.d = paramBundle.getBoolean("android:showsDialog", this.d);
        this.e = paramBundle.getInt("android:backStackId", -1);
      }
      return;
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (this.h) {
      return;
    }
    this.h = true;
    this.i = false;
    if (this.f != null)
    {
      this.f.dismiss();
      this.f = null;
    }
    this.g = true;
    if (this.e >= 0)
    {
      o().a(this.e, 1);
      this.e = -1;
      return;
    }
    n localn = o().a();
    localn.a(this);
    if (paramBoolean)
    {
      localn.b();
      return;
    }
    localn.a();
  }
  
  public LayoutInflater b(Bundle paramBundle)
  {
    if (!this.d) {
      return super.b(paramBundle);
    }
    this.f = c(paramBundle);
    switch (this.a)
    {
    }
    while (this.f != null)
    {
      return (LayoutInflater)this.f.getContext().getSystemService("layout_inflater");
      this.f.getWindow().addFlags(24);
      this.f.requestWindowFeature(1);
    }
    return (LayoutInflater)this.C.getSystemService("layout_inflater");
  }
  
  public void b()
  {
    a(true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (this.f != null) {
      this.f.setCancelable(paramBoolean);
    }
  }
  
  public Dialog c()
  {
    return this.f;
  }
  
  public Dialog c(Bundle paramBundle)
  {
    return new Dialog(m(), d());
  }
  
  public void c(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    if (!this.d) {}
    do
    {
      do
      {
        return;
        View localView = v();
        if (localView != null)
        {
          if (localView.getParent() != null) {
            throw new IllegalStateException("DialogFragment can not be attached to a container view");
          }
          this.f.setContentView(localView);
        }
        this.f.setOwnerActivity(m());
        this.f.setCancelable(this.c);
        this.f.setOnCancelListener(this);
        this.f.setOnDismissListener(this);
      } while (paramBundle == null);
      paramBundle = paramBundle.getBundle("android:savedDialogState");
    } while (paramBundle == null);
    this.f.onRestoreInstanceState(paramBundle);
  }
  
  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    if (this.f != null)
    {
      Bundle localBundle = this.f.onSaveInstanceState();
      if (localBundle != null) {
        paramBundle.putBundle("android:savedDialogState", localBundle);
      }
    }
    if (this.a != 0) {
      paramBundle.putInt("android:style", this.a);
    }
    if (this.b != 0) {
      paramBundle.putInt("android:theme", this.b);
    }
    if (!this.c) {
      paramBundle.putBoolean("android:cancelable", this.c);
    }
    if (!this.d) {
      paramBundle.putBoolean("android:showsDialog", this.d);
    }
    if (this.e != -1) {
      paramBundle.putInt("android:backStackId", this.e);
    }
  }
  
  public boolean e()
  {
    return this.d;
  }
  
  public void f()
  {
    super.f();
    if ((!this.i) && (!this.h)) {
      this.h = true;
    }
  }
  
  public void g()
  {
    super.g();
    if (this.f != null)
    {
      this.g = false;
      this.f.show();
    }
  }
  
  public void h()
  {
    super.h();
    if (this.f != null) {
      this.f.hide();
    }
  }
  
  public void i()
  {
    super.i();
    if (this.f != null)
    {
      this.g = true;
      this.f.dismiss();
      this.f = null;
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.g) {
      a(true);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/app/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */