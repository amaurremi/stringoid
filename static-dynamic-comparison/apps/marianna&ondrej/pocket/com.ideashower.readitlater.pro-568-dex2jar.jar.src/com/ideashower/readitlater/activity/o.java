package com.ideashower.readitlater.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.av;
import com.ideashower.readitlater.a.aw;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.a.b;
import com.ideashower.readitlater.activity.a.d;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.AvatarView;
import com.ideashower.readitlater.views.LabelEditText;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.toolbars.StyledIconButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.toolbars.ToolbarLayout;
import com.pocket.user.UserMeta;
import com.pocket.widget.BorderedRelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class o
  extends f
{
  protected ToolbarLayout Y;
  protected StyledToolbar Z;
  protected RilButton aa;
  protected EditText ab;
  protected EditText ac;
  protected LabelEditText ad;
  protected LabelEditText ae;
  protected EditText af;
  protected AvatarView ag;
  protected Button ah;
  protected com.ideashower.readitlater.activity.a.l ai;
  protected UserMeta aj;
  private View ak;
  private ViewGroup al;
  private EditText am;
  private View.OnClickListener an;
  private View.OnClickListener ao;
  private View.OnClickListener ap;
  private View.OnClickListener aq;
  
  public static com.pocket.p.l Y()
  {
    if (j.g()) {
      return com.pocket.p.l.a;
    }
    return com.pocket.p.l.b;
  }
  
  public static o a(UserMeta paramUserMeta)
  {
    o localo = new o();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("meta", paramUserMeta);
    localo.g(localBundle);
    return localo;
  }
  
  private static String a(TextView paramTextView, String paramString)
  {
    String str = org.apache.a.c.k.c(paramTextView.getText().toString()).trim();
    paramTextView = str;
    if (str.equals(paramString)) {
      paramTextView = null;
    }
    return paramTextView;
  }
  
  public static void a(final a parama)
  {
    if (!g.k())
    {
      b.b(2131493071, 2131493037).a(parama);
      return;
    }
    com.ideashower.readitlater.activity.a.l locall = com.ideashower.readitlater.activity.a.l.a(2131493102, true);
    locall.a(parama);
    com.pocket.c.e.a(new com.ideashower.readitlater.d.f()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        if (o.this.r()) {}
        do
        {
          return;
          o.this.a();
        } while (!paramAnonymousBoolean);
        com.pocket.user.a locala = as.k();
        o.a(parama, locala.h());
      }
    }, true);
  }
  
  private void a(com.pocket.user.e parame)
  {
    a(parame, this.al.indexOfChild(this.am));
  }
  
  private void a(com.pocket.user.e parame, int paramInt)
  {
    BorderedRelativeLayout localBorderedRelativeLayout = (BorderedRelativeLayout)LayoutInflater.from(m()).inflate(2130903135, null);
    TextView localTextView2 = (TextView)localBorderedRelativeLayout.findViewById(2131230902);
    TextView localTextView1 = (TextView)localBorderedRelativeLayout.findViewById(2131231028);
    ImageView localImageView = (ImageView)localBorderedRelativeLayout.findViewById(2131230769);
    StyledIconButton localStyledIconButton = (StyledIconButton)localBorderedRelativeLayout.findViewById(2131230907);
    localTextView2.setText(parame.a());
    localBorderedRelativeLayout.setTag(parame);
    if (parame.b())
    {
      localBorderedRelativeLayout.setOnClickListener(this.ao);
      localTextView1.setText(a(2131493285).toUpperCase());
      localStyledIconButton.setVisibility(0);
      localStyledIconButton.setTag(parame);
      localStyledIconButton.setOnClickListener(this.an);
      parame = new LinearLayout.LayoutParams(-1, j.a(60.0F));
      parame.leftMargin = j.a(4.0F);
      parame.rightMargin = j.a(4.0F);
      localBorderedRelativeLayout.setLayoutParams(parame);
      localBorderedRelativeLayout.setBorder(2131165765);
      localBorderedRelativeLayout.setBottomBorderLength(j.a(1.0F));
      this.al.addView(localBorderedRelativeLayout, paramInt);
      return;
    }
    if (parame.a().equals(this.aj.a())) {}
    for (parame = this.aq;; parame = this.ap)
    {
      localBorderedRelativeLayout.setOnClickListener(parame);
      localTextView1.setText(a(2131493363).toUpperCase());
      localStyledIconButton.setVisibility(8);
      localImageView.setVisibility(8);
      break;
    }
  }
  
  private void a(final com.pocket.user.e parame, final View paramView)
  {
    new AlertDialog.Builder(m()).setTitle(2131493069).setMessage(a(2131493067, new Object[] { parame.a() })).setPositiveButton(2131492888, new DialogInterface.OnClickListener()
    {
      public void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new ProgressDialog(o.this.m());
        paramAnonymousDialogInterface.setMessage(o.this.a(2131493137));
        paramAnonymousDialogInterface.setCancelable(false);
        paramAnonymousDialogInterface.show();
        com.pocket.c.e.b(parame.a(), new com.ideashower.readitlater.d.f()
        {
          public void a(boolean paramAnonymous2Boolean)
          {
            paramAnonymousDialogInterface.dismiss();
            if (paramAnonymous2Boolean)
            {
              o.this.aj.a(o.4.this.a);
              o.c(o.this).removeView(o.4.this.b);
            }
          }
        });
      }
    }).setNeutralButton(2131492871, null).show();
  }
  
  private void ac()
  {
    this.ag.setFriend(com.ideashower.readitlater.a.o.c().e());
  }
  
  private void ad()
  {
    this.an = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        com.pocket.user.e locale = (com.pocket.user.e)paramAnonymousView.getTag();
        o.a(o.this, locale, (View)paramAnonymousView.getParent());
      }
    };
    this.ao = new View.OnClickListener()
    {
      public void onClick(final View paramAnonymousView)
      {
        final com.pocket.user.e locale = (com.pocket.user.e)paramAnonymousView.getTag();
        new AlertDialog.Builder(o.this.m()).setTitle(2131493070).setMessage(locale.a()).setPositiveButton(2131492888, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            o.a(o.this, locale, paramAnonymousView);
          }
        }).setNeutralButton(2131492871, null).show();
      }
    };
    this.ap = new View.OnClickListener()
    {
      public void onClick(final View paramAnonymousView)
      {
        final com.pocket.user.e locale = (com.pocket.user.e)paramAnonymousView.getTag();
        new AlertDialog.Builder(o.this.m()).setTitle(2131493177).setMessage(o.this.a(2131493176, new Object[] { locale.a() })).setNegativeButton(2131492929, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            com.pocket.c.e.a(locale.a(), null);
          }
        }).setPositiveButton(2131492888, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            o.a(o.this, locale, paramAnonymousView);
          }
        }).setNeutralButton(2131492871, null).show();
      }
    };
    this.aq = new View.OnClickListener()
    {
      public void onClick(final View paramAnonymousView)
      {
        paramAnonymousView = (com.pocket.user.e)paramAnonymousView.getTag();
        new AlertDialog.Builder(o.this.m()).setTitle(2131493177).setMessage(o.this.a(2131493176, new Object[] { paramAnonymousView.a() })).setNegativeButton(2131492929, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            com.pocket.c.e.a(paramAnonymousView.a(), null);
          }
        }).setNeutralButton(2131492871, null).show();
      }
    };
    Object localObject = this.aj.f();
    if (localObject != null)
    {
      int i = this.al.indexOfChild(this.am);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.pocket.user.e locale = (com.pocket.user.e)((Iterator)localObject).next();
        if (locale.a().equals(this.aj.a()))
        {
          if (!locale.b()) {
            a(locale, i);
          }
        }
        else {
          a(locale);
        }
      }
    }
    this.am.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 6) && (paramAnonymousTextView.getText().length() > 0))
        {
          o.a(o.this);
          return true;
        }
        return false;
      }
    });
  }
  
  private void ae()
  {
    final String str = this.am.getText().toString().trim();
    final ProgressDialog localProgressDialog = new ProgressDialog(m());
    localProgressDialog.setMessage(a(2131493040));
    localProgressDialog.setCancelable(false);
    localProgressDialog.show();
    com.pocket.c.e.c(str, new com.ideashower.readitlater.d.f()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        localProgressDialog.dismiss();
        if (paramAnonymousBoolean)
        {
          o.this.aj.a(str, false);
          o.a(o.this, (com.pocket.user.e)o.this.aj.f().get(o.this.aj.f().size() - 1));
          o.b(o.this).setText(null);
        }
      }
    });
  }
  
  private static void b(a parama, UserMeta paramUserMeta)
  {
    if (Y() == com.pocket.p.l.a)
    {
      com.pocket.p.k.a(a(paramUserMeta), parama, null);
      return;
    }
    EditAccountActivity.a(parama, paramUserMeta);
  }
  
  public String K()
  {
    return "edit_account";
  }
  
  public void L()
  {
    super.L();
    ac();
  }
  
  public void M()
  {
    super.M();
    ac();
  }
  
  protected void Z()
  {
    if (this.ai != null) {
      return;
    }
    final String str2 = a(this.ab, as.k().c());
    final String str3 = a(this.ac, as.k().d());
    if (this.ad.getVisibility() == 0) {}
    final String str4;
    for (final String str1 = a(this.ad, as.e());; str1 = null)
    {
      str4 = a(this.ae, as.j());
      localObject1 = a(this.af, null);
      if ((str2 != null) || (str3 != null) || (str4 != null) || (str1 != null) || (!this.am.getText().toString().trim().equals(""))) {
        break;
      }
      P();
      return;
    }
    if ((str1 != null) && (str1.length() == 0))
    {
      b.b(2131493090, 2131493181).a((a)m());
      return;
    }
    if ((str4 != null) && (!str4.equals(localObject1)))
    {
      b.b(2131493090, 2131493089).a((a)m());
      return;
    }
    final Object localObject2 = LayoutInflater.from(m()).inflate(2130903097, null);
    final Object localObject1 = (EditText)((View)localObject2).findViewById(2131230945);
    localObject2 = new AlertDialog.Builder(m()).setTitle(2131493131).setMessage(2131493130).setView((View)localObject2).setNegativeButton(2131492871, null).setPositiveButton(2131492934, null).setNeutralButton(2131492898, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        g.a(o.this.m(), "http://getpocket.com/forgot");
      }
    }).create();
    ((AlertDialog)localObject2).setOnShowListener(new DialogInterface.OnShowListener()
    {
      public void onShow(DialogInterface paramAnonymousDialogInterface)
      {
        z.a(true, localObject1);
      }
    });
    ((AlertDialog)localObject2).show();
    ((AlertDialog)localObject2).getButton(-1).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = localObject1.getText().toString();
        if (org.apache.a.c.k.c(paramAnonymousView))
        {
          new AlertDialog.Builder(o.this.m()).setMessage(2131493129).setPositiveButton(2131492924, null).show();
          return;
        }
        o.this.aa();
        av localav = as.x();
        if (str2 != null) {
          localav.c(str2);
        }
        if (str3 != null) {
          localav.d(str3);
        }
        if (str1 != null) {
          localav.a(str1);
        }
        if (str4 != null) {
          localav.e(str4);
        }
        localav.a(paramAnonymousView, new aw()
        {
          public void a()
          {
            o.this.ab();
            Toast.makeText(this.a, o.this.d(2131493743), 1).show();
            o.this.P();
          }
          
          public void a(ErrorReport paramAnonymous2ErrorReport)
          {
            o.this.ab();
            d.a(4, paramAnonymous2ErrorReport).a(this.a);
          }
        });
        localObject2.dismiss();
      }
    });
  }
  
  protected void aa()
  {
    this.ai = com.ideashower.readitlater.activity.a.l.a(2131493143, null, true);
    this.ai.a((a)m());
    this.ai.a(new com.ideashower.readitlater.activity.a.p()
    {
      public void a(com.ideashower.readitlater.activity.a.o paramAnonymouso)
      {
        o.this.ai = null;
      }
      
      public void b(com.ideashower.readitlater.activity.a.o paramAnonymouso)
      {
        o.this.ab();
      }
    });
  }
  
  protected void ab()
  {
    if (this.ai != null)
    {
      this.ai.a();
      this.ai = null;
    }
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903040, paramViewGroup, false);
  }
  
  public void d(final Bundle paramBundle)
  {
    super.d(paramBundle);
    this.Y = ((ToolbarLayout)c(2131230729));
    this.aa = ((RilButton)c(2131230743));
    this.ab = ((EditText)c(2131230734));
    this.ac = ((EditText)c(2131230735));
    this.ad = ((LabelEditText)c(2131230736));
    this.ae = ((LabelEditText)c(2131230737));
    this.af = ((EditText)c(2131230738));
    this.ag = ((AvatarView)c(2131230733));
    this.ah = ((Button)c(2131230732));
    this.ak = c(2131230739);
    this.al = ((ViewGroup)c(2131230731));
    this.am = ((EditText)c(2131230741));
    this.Z = ((StyledToolbar)this.Y.getTopToolbar());
    this.Z.a(true, this);
    paramBundle = this.Z;
    boolean bool;
    if (!e())
    {
      bool = true;
      paramBundle.setIsRainbowified(bool);
      this.Z.a(StyledToolbar.a, false);
      this.Z.setTitle(2131493502);
      if (e())
      {
        int i = (int)n().getDimension(2131296296);
        int j = j.a(50.0F);
        this.al.setPadding(j, i, j, i);
      }
      this.aj = ((UserMeta)l().getParcelable("meta"));
      if (!as.f()) {
        break label442;
      }
      this.ad.setText(as.e());
    }
    for (;;)
    {
      this.ab.setText(this.aj.g());
      this.ac.setText(this.aj.h());
      this.ae.setText(this.aj.a());
      paramBundle = this.ae.getText().toString();
      this.ae.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          if (!o.this.ae.getText().toString().trim().equals(paramBundle))
          {
            o.this.af.setVisibility(0);
            return;
          }
          o.this.af.setVisibility(8);
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.aa.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          o.this.Z();
        }
      });
      this.ag.setFriend(com.ideashower.readitlater.a.o.c().e());
      this.ah.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          p.a(o.this.m());
        }
      });
      this.ak.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (q.Y() == com.pocket.p.l.a)
          {
            com.pocket.p.k.a(q.a(o.this.aj), o.this.m());
            return;
          }
          EditPasswordActivity.a(o.this.m(), o.this.aj);
        }
      });
      ad();
      return;
      bool = false;
      break;
      label442:
      this.ad.setVisibility(8);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */