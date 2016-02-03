package com.pocket.q.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.ideashower.readitlater.util.z;
import org.apache.a.c.k;

public class c
  extends o
{
  private final TextView a;
  private final TextView b;
  
  public c(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2130903156, this);
    this.a = ((TextView)findViewById(2131230902));
    this.b = ((TextView)findViewById(2131231063));
  }
  
  public void setDescription(String paramString)
  {
    this.b.setText(paramString);
    if (!k.a(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      z.a(bool, new View[] { this.b });
      return;
    }
  }
  
  public void setLabel(String paramString)
  {
    this.a.setText(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/q/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */