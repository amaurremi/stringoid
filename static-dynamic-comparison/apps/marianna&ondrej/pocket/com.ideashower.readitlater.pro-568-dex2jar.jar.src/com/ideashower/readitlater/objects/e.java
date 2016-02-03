package com.ideashower.readitlater.objects;

import android.content.Context;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.ideashower.readitlater.util.a;

public class e
{
  protected final Context a;
  private ClipboardManager b;
  
  public e(Context paramContext)
  {
    this.a = paramContext;
    b(paramContext);
  }
  
  public static e a(Context paramContext)
  {
    if (a.e()) {
      return new f(paramContext);
    }
    return new e(paramContext);
  }
  
  public String a()
  {
    CharSequence localCharSequence = this.b.getText();
    if (localCharSequence == null) {
      return null;
    }
    return localCharSequence.toString();
  }
  
  protected void a(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1);
    if (paramString2 == null) {
      return;
    }
    Toast.makeText(this.a, this.a.getString(2131493744, new Object[] { paramString2 }), 0).show();
  }
  
  protected void b(Context paramContext)
  {
    this.b = ((ClipboardManager)paramContext.getSystemService("clipboard"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/objects/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */