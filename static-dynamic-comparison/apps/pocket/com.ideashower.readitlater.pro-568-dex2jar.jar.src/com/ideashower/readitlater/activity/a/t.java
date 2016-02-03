package com.ideashower.readitlater.activity.a;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.ideashower.readitlater.activity.a;
import com.ideashower.readitlater.activity.f;
import com.ideashower.readitlater.objects.UserMessage;

@SuppressLint({"ValidFragment"})
public class t
  extends f
  implements View.OnClickListener
{
  private UserMessage Y;
  private View Z;
  private View aa;
  private Button ab;
  private TextView ac;
  
  public static t a(UserMessage paramUserMessage)
  {
    t localt = new t();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("user_message", paramUserMessage);
    localt.g(localBundle);
    return localt;
  }
  
  public static void a(a parama, UserMessage paramUserMessage)
  {
    parama.a(a(paramUserMessage), null, true, false);
  }
  
  public String K()
  {
    return "system_message";
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.Y = ((UserMessage)l().getParcelable("user_message"));
    this.Z = paramLayoutInflater.inflate(2130903131, paramViewGroup, false);
    this.Z.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView) {}
    });
    this.aa = this.Z.findViewById(2131230999);
    this.aa.setClickable(true);
    ((TextView)this.Z.findViewById(2131231003)).setText(this.Y.a());
    ((TextView)this.Z.findViewById(2131231005)).setText(this.Y.b());
    this.ab = ((Button)this.Z.findViewById(2131231006));
    this.ab.setText(this.Y.e());
    this.ab.setOnClickListener(this);
    this.ac = ((TextView)this.Z.findViewById(2131231007));
    paramLayoutInflater = this.Y.f();
    paramViewGroup = new SpannableString(paramLayoutInflater);
    paramViewGroup.setSpan(new UnderlineSpan(), 0, paramLayoutInflater.length(), 0);
    this.ac.setText(paramViewGroup);
    this.ac.setOnClickListener(this);
    return this.Z;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.ab) {
      this.Y.a((a)m());
    }
    for (;;)
    {
      P();
      return;
      if (paramView == this.ac) {
        this.Y.b((a)m());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */