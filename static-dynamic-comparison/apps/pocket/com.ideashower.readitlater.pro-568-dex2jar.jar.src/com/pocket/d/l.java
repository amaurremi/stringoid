package com.pocket.d;

import android.content.Context;
import com.ideashower.readitlater.a.as;
import org.apache.a.a.a.d;
import org.apache.a.a.b.a;

public class l
  extends e
{
  private String i = as.j();
  
  public l(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  public int c()
  {
    return 2131493266;
  }
  
  protected int d()
  {
    return 2130837524;
  }
  
  protected void e() {}
  
  public void f()
  {
    if (this.i == null) {
      return;
    }
    com.ideashower.readitlater.util.e.b("AbsUrlAvatarSource", "GravatarAvatarSource.displayAvatar()");
    super.f();
  }
  
  public String o()
  {
    return "gravatar";
  }
  
  protected String r()
  {
    String str = new String(d.a(a.a(this.i.toLowerCase().trim().getBytes())));
    com.ideashower.readitlater.util.e.b("AbsUrlAvatarSource", "http://www.gravatar.com/avatar/" + str + ".jpg?s=" + 500 + "&d=404&r=pg");
    return "http://www.gravatar.com/avatar/" + str + ".jpg?s=" + 500 + "&d=404&r=pg";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/d/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */