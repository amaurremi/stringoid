package com.ideashower.readitlater.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.android.ex.chips.n;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.av;
import com.ideashower.readitlater.a.aw;
import com.ideashower.readitlater.a.o;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.ag;
import com.ideashower.readitlater.db.operation.action.ah;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.ImageRequestView;
import com.ideashower.readitlater.views.ak;
import com.ideashower.readitlater.views.toolbars.StyledIconButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.toolbars.ToolbarLayout;
import com.pocket.user.UserMeta;

public class ba
  extends f
{
  public static final int Y = j.a(200.0F);
  private com.android.ex.chips.a Z;
  private EditText aa;
  private StyledIconButton ab;
  private TextView ac;
  private com.android.ex.chips.c ad;
  private ToolbarLayout ae;
  private StyledToolbar af;
  private UiContext ag;
  private ak ah;
  
  public static com.pocket.p.l Y()
  {
    if (j.g()) {
      return com.pocket.p.l.a;
    }
    return com.pocket.p.l.b;
  }
  
  public static com.android.ex.chips.c a(n paramn)
  {
    paramn.setFilters(new InputFilter[] { com.d.a.a.a });
    com.android.a.a locala = new com.android.a.a();
    com.pocket.h.c localc = new com.pocket.h.c(paramn.getContext(), paramn);
    paramn.setAdapter(localc);
    paramn.setThreshold(0);
    paramn.setValidator(locala);
    paramn.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() == 0) {
          ba.this.a(true);
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    localc.a(new com.android.ex.chips.k()
    {
      public void a(CharSequence paramAnonymousCharSequence)
      {
        if (!TextUtils.isEmpty(paramAnonymousCharSequence)) {
          ba.this.a(false);
        }
      }
    });
    return localc;
  }
  
  public static ba a(ak paramak, int paramInt, UiContext paramUiContext)
  {
    ba localba = new ba();
    Bundle localBundle = new Bundle();
    localBundle.putBundle("item", paramak.f());
    localBundle.putInt("friendId", paramInt);
    localBundle.putParcelable("uiContext", paramUiContext);
    localba.g(localBundle);
    return localba;
  }
  
  public static void a(android.support.v4.app.f paramf, ak paramak, UiContext paramUiContext)
  {
    a(paramf, paramak, paramUiContext, 0);
  }
  
  public static void a(android.support.v4.app.f paramf, ak paramak, UiContext paramUiContext, int paramInt)
  {
    if (Y() == com.pocket.p.l.a)
    {
      com.pocket.p.k.a(a(paramak, paramInt, paramUiContext), paramf, null);
      return;
    }
    SendToFriendActivity.c(paramf, paramak, paramInt, paramUiContext);
  }
  
  private void aa()
  {
    TextView localTextView = (TextView)c(2131230888);
    CharSequence localCharSequence = localTextView.getText();
    float f1 = localTextView.getPaint().measureText(localCharSequence, 0, localCharSequence.length());
    float f2 = j.a(16.0F);
    z.c(this.Z, (int)(f1 + f2));
  }
  
  private void ab()
  {
    Object localObject1 = com.d.a.a.a(this.Z);
    if ((localObject1 == null) || (localObject1.length == 0)) {}
    while (Z()) {
      return;
    }
    boolean bool = i.a(com.ideashower.readitlater.h.a.bz);
    Object localObject2 = new ah(this.ah.b(), this.ag);
    if (!org.apache.a.c.k.c(this.aa.getText().toString())) {
      ((ah)localObject2).a(this.aa.getText().toString());
    }
    if (!org.apache.a.c.k.c(this.ah.e())) {
      ((ah)localObject2).c(this.ah.e());
    }
    int j = localObject1.length;
    int i = 0;
    if (i < j)
    {
      Object localObject3 = localObject1[i];
      if (((com.android.b.a.a)localObject3).c()) {
        ((ah)localObject2).a(((com.android.b.a.a)localObject3).d());
      }
      for (;;)
      {
        i += 1;
        break;
        ((ah)localObject2).b(((com.android.b.a.a)localObject3).a());
      }
    }
    ((ah)localObject2).a().j();
    if (com.ideashower.readitlater.a.g.k())
    {
      i = 2131493769;
      Toast.makeText(m(), i, 1).show();
      if ((!as.k().h().b()) && (!bool))
      {
        localObject1 = com.ideashower.readitlater.a.g.o();
        localObject2 = new Runnable()
        {
          public void run()
          {
            final a locala = com.ideashower.readitlater.a.g.n();
            if ((!(locala instanceof a)) || (locala.isFinishing())) {
              return;
            }
            locala = (a)locala;
            i.b().a(com.ideashower.readitlater.h.a.bz, true).a();
            com.pocket.stats.f.a("avatar", "addavatar", "open", "2");
            ImageView localImageView = new ImageView(locala);
            if (j.c()) {}
            for (int i = 2130837835;; i = 2130837731)
            {
              localImageView.setImageResource(i);
              new AlertDialog.Builder(locala).setTitle(2131493154).setMessage(2131493153).setView(localImageView).setPositiveButton(2131492866, new DialogInterface.OnClickListener()
              {
                public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  com.pocket.stats.f.a("avatar", "addavatar", "tapped_btn", "2");
                  p.a(locala);
                }
              }).setNegativeButton(2131492921, null).show();
              return;
            }
          }
        };
        if (!j.g()) {
          break label264;
        }
      }
    }
    label264:
    for (long l = 800L;; l = 1000L)
    {
      ((Handler)localObject1).postDelayed((Runnable)localObject2, l);
      P();
      return;
      i = 2131493770;
      break;
    }
  }
  
  private boolean ac()
  {
    int i = 0;
    if ((as.r()) && (as.s())) {
      return false;
    }
    i.b().a(com.ideashower.readitlater.h.a.bm, true).a();
    Object localObject2 = as.k();
    final Object localObject1 = LayoutInflater.from(m()).inflate(2130903083, null);
    z.a((View)localObject1, 14.0F, 14.0F, 14.0F, 14.0F);
    final EditText localEditText1 = (EditText)((View)localObject1).findViewById(2131230734);
    final EditText localEditText2 = (EditText)((View)localObject1).findViewById(2131230735);
    final EditText localEditText3 = (EditText)((View)localObject1).findViewById(2131230737);
    final boolean bool = org.apache.a.c.k.c(((com.pocket.user.a)localObject2).f());
    if (bool)
    {
      localEditText3.setVisibility(i);
      localEditText3.setText(((com.pocket.user.a)localObject2).f());
      localEditText1.setText(((com.pocket.user.a)localObject2).c());
      localEditText2.setText(((com.pocket.user.a)localObject2).d());
      localObject2 = new AlertDialog.Builder(m()).setTitle(2131493158);
      if (!bool) {
        break label262;
      }
    }
    label262:
    for (i = 2131493156;; i = 2131493157)
    {
      localObject1 = ((AlertDialog.Builder)localObject2).setMessage(i).setView((View)localObject1).setNegativeButton(2131492871, null).setPositiveButton(2131492933, null).show();
      ((AlertDialog)localObject1).setOnShowListener(new DialogInterface.OnShowListener()
      {
        public void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          if (bool) {
            paramAnonymousDialogInterface = localEditText3;
          }
          for (;;)
          {
            z.a(true, paramAnonymousDialogInterface);
            return;
            if (localEditText1.getText().length() > 0) {
              paramAnonymousDialogInterface = localEditText1;
            } else {
              paramAnonymousDialogInterface = localEditText2;
            }
          }
        }
      });
      ((AlertDialog)localObject1).getButton(-1).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = org.apache.a.c.k.c(localEditText1.getText().toString()).trim();
          String str1 = org.apache.a.c.k.c(localEditText2.getText().toString()).trim();
          String str2 = org.apache.a.c.k.c(localEditText3.getText().toString()).trim();
          if (org.apache.a.c.k.c(str2))
          {
            new AlertDialog.Builder(ba.this.m()).setMessage(2131493088).setPositiveButton(2131492924, null).show();
            return;
          }
          as.x().c(paramAnonymousView).d(str1).e(str2).a(null, new aw()
          {
            public void a()
            {
              ba.4.this.d.dismiss();
              ba.a(ba.this);
            }
            
            public void a(ErrorReport paramAnonymous2ErrorReport)
            {
              com.ideashower.readitlater.activity.a.d.a(4, paramAnonymous2ErrorReport).a(ba.this.m());
            }
          });
        }
      });
      return true;
      i = 8;
      break;
    }
  }
  
  public String K()
  {
    return "send_to_friend";
  }
  
  public void P()
  {
    super.P();
    if ((m() instanceof StandAloneSendToFriendActivity)) {
      m().finish();
    }
  }
  
  protected boolean Z()
  {
    int i = 1;
    boolean bool = false;
    if (!as.r()) {}
    for (;;)
    {
      if (i != 0) {
        bool = ac();
      }
      return bool;
      if (!as.s())
      {
        if ((i.a(com.ideashower.readitlater.h.a.bm)) || (!com.ideashower.readitlater.a.g.k())) {
          i = 0;
        }
      }
      else {
        i = 0;
      }
    }
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903062, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    paramBundle = l();
    this.ah = new ak(paramBundle.getBundle("item"));
    this.ag = ((UiContext)paramBundle.getParcelable("uiContext"));
    int i = paramBundle.getInt("friendId");
    this.ae = ((ToolbarLayout)c(2131230729));
    this.af = ((StyledToolbar)this.ae.getTopToolbar());
    this.af.a(true, this);
    this.af.setIsRainbowified(true);
    this.ab = ((StyledIconButton)c(2131230895));
    this.Z = ((com.android.ex.chips.a)c(2131230887));
    aa();
    this.aa = ((EditText)c(2131230889));
    this.ac = ((TextView)c(2131230894));
    this.ad = a(this.Z);
    this.ab.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ba.a(ba.this);
      }
    });
    Object localObject1 = (TextView)c(2131230891);
    paramBundle = (TextView)c(2131230892);
    Object localObject2 = (ImageRequestView)c(2131230893);
    if (!org.apache.a.c.k.c(this.ah.a()))
    {
      ((TextView)localObject1).setText(this.ah.a());
      paramBundle.setText(com.ideashower.readitlater.util.g.a(this.ah.b()).replaceFirst("www\\.", ""));
      if (!org.apache.a.c.k.c(this.ah.d())) {
        break label381;
      }
      ((ImageRequestView)localObject2).setVisibility(8);
      localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      label318:
      if (!org.apache.a.c.k.c(this.ah.e())) {
        break label399;
      }
      this.ac.setVisibility(8);
    }
    for (;;)
    {
      if (i != 0) {
        this.Z.a(o.c().b(i));
      }
      this.ad.a(true);
      return;
      ((TextView)localObject1).setText(this.ah.b());
      break;
      label381:
      ((ImageRequestView)localObject2).a(this.ah.d(), com.pocket.m.a.d.a());
      break label318;
      label399:
      this.ac.setText(this.ah.e());
      this.ac.setVisibility(0);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */