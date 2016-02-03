package com.android.ex.chips;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.ideashower.readitlater.db.operation.f;
import com.ideashower.readitlater.views.AvatarView;
import com.ideashower.readitlater.views.ThemedImageView;
import com.ideashower.readitlater.views.p;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;

class j
{
  private final View b;
  private final TextView c;
  private final TextView d;
  private final AvatarView e;
  private final ThemedImageView f;
  private boolean g = false;
  private Drawable h;
  
  public j(c paramc, View paramView)
  {
    this.b = paramView;
    this.c = ((TextView)paramView.findViewById(paramc.a()));
    this.d = ((TextView)paramView.findViewById(paramc.b()));
    this.e = ((AvatarView)paramView.findViewById(paramc.c()));
    this.f = ((ThemedImageView)paramView.findViewById(2131230917));
    this.f.setStyle(StyledToolbar.d);
  }
  
  public void a(aa paramaa)
  {
    Object localObject4 = paramaa.b();
    Object localObject3 = paramaa.c();
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      localObject1 = localObject3;
      localObject2 = localObject4;
      if (!TextUtils.equals((CharSequence)localObject4, (CharSequence)localObject3)) {}
    }
    else
    {
      if (!paramaa.e()) {
        break label313;
      }
      localObject2 = localObject3;
    }
    for (Object localObject1 = null;; localObject1 = localObject3)
    {
      localObject3 = paramaa.i();
      boolean bool;
      if ((localObject3 != null) && (((f)localObject3).m()))
      {
        bool = true;
        if ((this.h == null) || (this.g != bool))
        {
          localObject4 = this.f;
          Resources localResources = this.f.getResources();
          if (!bool) {
            break label268;
          }
          i = 2130837684;
          label110:
          ((ThemedImageView)localObject4).setImageDrawable(new p(BitmapFactory.decodeResource(localResources, i), this.f.getContext(), c.d()));
        }
        this.g = bool;
        this.c.setText((CharSequence)localObject2);
        localObject2 = localObject1;
        if (this.g)
        {
          localObject3 = ((f)localObject3).j();
          localObject2 = localObject1;
          if (localObject3 != null) {
            localObject2 = localObject3;
          }
        }
        this.d.setText((CharSequence)localObject2);
        localObject1 = this.d;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label274;
        }
      }
      label268:
      label274:
      for (int i = 0;; i = 8)
      {
        ((TextView)localObject1).setVisibility(i);
        if (!paramaa.e()) {
          break label295;
        }
        this.c.setVisibility(0);
        this.e.setVisibility(0);
        paramaa = paramaa.g();
        if (paramaa == null) {
          break label280;
        }
        paramaa = BitmapFactory.decodeByteArray(paramaa, 0, paramaa.length);
        this.e.setImageBitmap(paramaa);
        return;
        bool = false;
        break;
        i = 2130837651;
        break label110;
      }
      label280:
      this.e.a();
      this.e.b();
      return;
      label295:
      this.c.setVisibility(8);
      this.e.setVisibility(4);
      return;
      label313:
      localObject2 = localObject3;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */