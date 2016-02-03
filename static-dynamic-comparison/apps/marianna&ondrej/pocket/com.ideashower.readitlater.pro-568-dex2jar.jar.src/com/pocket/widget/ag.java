package com.pocket.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.ideashower.readitlater.db.operation.action.ak;
import com.ideashower.readitlater.db.operation.f;
import com.ideashower.readitlater.e.c;
import com.ideashower.readitlater.e.w;
import com.ideashower.readitlater.e.x;
import com.ideashower.readitlater.e.y;
import com.ideashower.readitlater.reader.twitter.TwitterAvatarImageView;
import com.ideashower.readitlater.reader.twitter.URLSpanNoUnderline;
import com.ideashower.readitlater.reader.twitter.a;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.AvatarView;
import com.ideashower.readitlater.views.toolbars.StyledIconButton;
import com.pocket.m.a.d;
import org.apache.a.c.k;

public class ag
  extends h
{
  protected final AvatarView g;
  protected final TextView h;
  protected final TextView i;
  protected final TextView j;
  protected final TextView k;
  protected final TextView l;
  protected final TextView m;
  protected final Button n;
  protected final Button o;
  protected final ImageView p;
  protected final TwitterAvatarImageView q;
  protected final StyledIconButton r;
  protected final StyledIconButton s;
  protected final StyledIconButton t;
  protected final TextView u;
  protected c v;
  protected com.ideashower.readitlater.e.o w;
  protected f x;
  protected int y;
  
  public ag(af paramaf, View paramView)
  {
    super(paramaf, paramView);
    this.g = ((AvatarView)paramView.findViewById(2131230733));
    this.h = ((TextView)paramView.findViewById(2131230833));
    this.i = ((TextView)paramView.findViewById(2131231151));
    this.j = ((TextView)paramView.findViewById(2131231136));
    this.k = ((TextView)paramView.findViewById(2131230889));
    this.l = ((TextView)paramView.findViewById(2131230894));
    this.m = ((TextView)paramView.findViewById(2131230793));
    this.n = ((Button)paramView.findViewById(2131230905));
    this.o = ((Button)paramView.findViewById(2131231137));
    if ((this.n != null) && (this.o != null))
    {
      a(af.a(paramaf), this.n);
      a(af.b(paramaf), this.o);
    }
    this.p = ((ImageView)paramView.findViewById(2131231150));
    this.q = ((TwitterAvatarImageView)paramView.findViewById(2131231149));
    this.r = ((StyledIconButton)paramView.findViewById(2131231153));
    this.s = ((StyledIconButton)paramView.findViewById(2131231154));
    this.t = ((StyledIconButton)paramView.findViewById(2131231155));
    this.u = ((TextView)paramView.findViewById(2131231152));
  }
  
  public com.ideashower.readitlater.e.o a()
  {
    return this.w;
  }
  
  protected com.ideashower.readitlater.e.o a(x paramx)
  {
    return this.z.g.a(((w)this.v).a());
  }
  
  protected void a(int paramInt)
  {
    this.y = paramInt;
    this.v = this.z.c(paramInt);
    if ((this.v instanceof x))
    {
      this.x = com.ideashower.readitlater.a.o.c().a((x)this.v);
      this.w = a((x)this.v);
      if (this.x != null)
      {
        this.g.setFriend(this.x);
        this.h.setText(this.x.h());
      }
      this.j.setText(((x)this.v).h());
      z.a(this.k, ((x)this.v).d());
      z.a(this.l, ((x)this.v).e());
      if (((x)this.v).g() == 0)
      {
        paramInt = 0;
        this.n.setVisibility(paramInt);
        this.o.setVisibility(paramInt);
        localObject = this.n;
        if ((this.w.al() != 0) && (this.w.al() != 1)) {
          break label240;
        }
        paramInt = 2131492864;
        ((Button)localObject).setText(paramInt);
        localObject = this.b.getLayoutParams();
        if (localObject != null)
        {
          ((ViewGroup.LayoutParams)localObject).height = -2;
          this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    label240:
    while (!(this.v instanceof y)) {
      for (;;)
      {
        return;
        paramInt = 8;
        continue;
        paramInt = 2131492868;
      }
    }
    final y localy = (y)this.v;
    if (localy.a() > 0) {}
    for (Object localObject = d.a(localy.a());; localObject = d.a())
    {
      this.q.a(localy.h(), (d)localObject);
      this.h.setText(localy.g());
      this.i.setText("@" + localy.f());
      localObject = a.d(a.c(a.b(a.a(localy.c(), localy.l()), localy.j()), localy.i()), localy.p());
      if (k.b((CharSequence)localObject))
      {
        this.m.setText(Html.fromHtml((String)localObject));
        this.m.setMovementMethod(LinkMovementMethod.getInstance());
        URLSpanNoUnderline.a(this.m);
      }
      this.u.setText(localy.o());
      this.p.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.a(ag.this.z.b(), localy);
        }
      });
      this.q.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = localy.f();
          paramAnonymousView = "https://twitter.com/" + paramAnonymousView;
          Intent localIntent = new Intent("android.intent.action.VIEW");
          localIntent.setData(Uri.parse(paramAnonymousView));
          ag.this.z.b().startActivity(localIntent);
        }
      });
      this.r.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.a(ag.this.z.b(), localy.b(), localy.f());
          ak.a(ag.this.z.d(ag.this.y));
        }
      });
      this.s.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.a(ag.this.z.b(), localy, localy.c());
          ak.b(ag.this.z.d(ag.this.y));
        }
      });
      this.t.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.a(localy, ag.this.z.b());
          ak.c(ag.this.z.d(ag.this.y));
        }
      });
      this.u.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.a(ag.this.z.b(), localy);
        }
      });
      return;
    }
  }
  
  public c b()
  {
    return this.v;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */