package com.pocket.q.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.CheckableImageButton;
import org.apache.a.c.k;

public class i
  extends o
{
  private final TextView a;
  private final TextView b;
  private final CheckableImageButton c;
  
  public i(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2130903158, this);
    this.a = ((TextView)findViewById(2131230902));
    this.b = ((TextView)findViewById(2131231063));
    this.c = ((CheckableImageButton)findViewById(2131231082));
    this.c.setCheckable(true);
  }
  
  protected void a(View paramView, boolean paramBoolean)
  {
    if (paramView == this.c)
    {
      paramView = this.c;
      if (paramBoolean) {}
      for (int i = 255;; i = 102)
      {
        paramView.setAlpha(i);
        if (!paramBoolean) {
          this.c.setChecked(false);
        }
        return;
      }
    }
    super.a(paramView, paramBoolean);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.c.setChecked(paramBoolean);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/q/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */