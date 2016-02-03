package com.skplanet.tad.view;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.skplanet.tad.AdActivity;
import com.skplanet.tad.AdActivity.a;
import com.skplanet.tad.common.a;
import com.skplanet.tad.common.b;
import com.skplanet.tad.controller.g;
import java.util.ArrayList;
import java.util.Iterator;

public class e
  extends AlertDialog.Builder
{
  Context a;
  String b;
  boolean c = false;
  private ArrayList d;
  private AlertDialog e;
  
  public e(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    this.c = false;
    a();
  }
  
  public e(Context paramContext, String paramString)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = paramString;
    this.c = true;
    a();
  }
  
  public e(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.a = paramContext;
    this.c = paramBoolean;
    a();
  }
  
  public RelativeLayout a(final Context paramContext, CheckBox paramCheckBox, String paramString, int paramInt)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    TextView localTextView = new TextView(paramContext);
    Button localButton = new Button(paramContext);
    int i = (int)TypedValue.applyDimension(1, 42.0F, paramContext.getResources().getDisplayMetrics());
    int j = (int)TypedValue.applyDimension(1, 5.0F, paramContext.getResources().getDisplayMetrics());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, i);
    localLayoutParams.addRule(11);
    localLayoutParams.setMargins(0, j, 0, 0);
    localButton.setId(17);
    localButton.setText("상세");
    localButton.setLayoutParams(localLayoutParams);
    localRelativeLayout.addView(localButton);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(0, localButton.getId());
    localLayoutParams.addRule(13);
    paramCheckBox.setChecked(b.a(this.a).b((int)Math.pow(2.0D, paramInt)));
    paramCheckBox.setId(18);
    paramCheckBox.setLayoutParams(localLayoutParams);
    localRelativeLayout.addView(paramCheckBox);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(0, paramCheckBox.getId());
    localLayoutParams.addRule(13);
    localTextView.setText(paramString);
    localTextView.setGravity(1);
    localTextView.setLayoutParams(localLayoutParams);
    localRelativeLayout.addView(localTextView);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("action", AdActivity.a.c.toString());
        if (e.this.c) {
          paramAnonymousView.putString("popup_ad.url", "http://220.103.245.39:80/getLatestPolicyInfo.do");
        }
        for (;;)
        {
          try
          {
            Intent localIntent = new Intent(paramContext, AdActivity.class);
            localIntent.putExtras(paramAnonymousView);
            paramContext.startActivity(localIntent);
            return;
          }
          catch (ActivityNotFoundException paramAnonymousView) {}
          paramAnonymousView.putString("popup_ad.url", "http://www.adotsolution.com/pinfo/policy/getLatestPolicyInfo");
        }
      }
    });
    return localRelativeLayout;
  }
  
  public void a()
  {
    final CheckBox localCheckBox1 = new CheckBox(this.a);
    final CheckBox localCheckBox2 = new CheckBox(this.a);
    final CheckBox localCheckBox3 = new CheckBox(this.a);
    final CheckBox localCheckBox4 = new CheckBox(this.a);
    this.d = new ArrayList();
    this.d.add(localCheckBox1);
    this.d.add(localCheckBox2);
    this.d.add(localCheckBox3);
    this.d.add(localCheckBox4);
    setTitle("T ad 개인맞춤 광고 이용동의");
    Object localObject = new ScrollView(this.a);
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    localLinearLayout.setOrientation(1);
    TextView localTextView = new TextView(this.a);
    int i = (int)TypedValue.applyDimension(1, 5.0F, this.a.getResources().getDisplayMetrics());
    localTextView.setPadding(i, i, 0, 0);
    localTextView.setText("T ad는 고객 맞춤형 광고 서비스를 제공하고 있습니다. 미동의한 경우 일반광고가 노출됩니다.");
    localLinearLayout.addView(localTextView);
    i = 0;
    if (i >= this.d.size())
    {
      ((ScrollView)localObject).addView(localLinearLayout);
      setView((View)localObject);
      setPositiveButton("동의", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (e.this.c)
          {
            if ((localCheckBox1.isChecked()) && (localCheckBox2.isChecked()) && (localCheckBox3.isChecked()) && (localCheckBox4.isChecked()))
            {
              new com.skplanet.tad.v2.controller.e(e.this.a, e.this.b, true).start();
              return;
            }
            a.c("TermsDialogBuilder.setpositiveBtn, someCheckBox not Selected, nothing to do");
            return;
          }
          paramAnonymousInt = 0;
          int j;
          for (int i = 0;; i = j)
          {
            if (paramAnonymousInt >= e.a(e.this).size())
            {
              new g(e.this.a).execute(new Integer[] { Integer.valueOf(i) });
              return;
            }
            j = i;
            if (((CheckBox)e.a(e.this).get(paramAnonymousInt)).isChecked()) {
              j = (int)(i + Math.pow(2.0D, paramAnonymousInt));
            }
            paramAnonymousInt += 1;
          }
        }
      });
      setNegativeButton("미동의", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (e.this.c)
          {
            new com.skplanet.tad.v2.controller.e(e.this.a, e.this.b, false).start();
            return;
          }
          new g(e.this.a).execute(new Integer[] { Integer.valueOf(0) });
        }
      });
      localObject = this.d.iterator();
      i = 0;
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        return;
        localLinearLayout.addView(a(this.a, (CheckBox)this.d.get(i), new String[] { "개인정보 제공 동의", "개인정보 수집/이용 동의", "개인위치정보 수집/이용 동의", "정보광고 수집 동의" }[i], i));
        i += 1;
        break;
      }
      ((CheckBox)((Iterator)localObject).next()).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          if ((!localCheckBox1.isChecked()) && (!localCheckBox2.isChecked()) && (!localCheckBox3.isChecked()) && (!localCheckBox4.isChecked()))
          {
            e.b(e.this).getButton(-1).setEnabled(false);
            return;
          }
          e.b(e.this).getButton(-1).setEnabled(true);
        }
      });
      i += 1;
    }
  }
  
  public AlertDialog create()
  {
    this.e = super.create();
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/view/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */