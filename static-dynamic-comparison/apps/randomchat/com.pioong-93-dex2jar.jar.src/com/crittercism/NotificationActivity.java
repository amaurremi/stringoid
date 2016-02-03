package com.crittercism;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.crittercism.app.Crittercism;

public class NotificationActivity
  extends Activity
  implements View.OnClickListener, View.OnTouchListener
{
  public void onClick(View paramView)
  {
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if ((paramBundle != null) && (paramBundle.containsKey("com.crittercism.notification")))
    {
      setTheme(16973835);
      requestWindowFeature(1);
      paramBundle = paramBundle.getString("com.crittercism.notification");
      Crittercism localCrittercism = Crittercism.a();
      LinearLayout localLinearLayout = new LinearLayout(this);
      localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      localLinearLayout.setOrientation(0);
      int i = localCrittercism.y();
      localLinearLayout.setPadding(i, i, i, i);
      localLinearLayout.setId(13);
      localLinearLayout.setOnClickListener(this);
      localLinearLayout.setOnTouchListener(this);
      TextView localTextView = new TextView(this);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(0, 0, localCrittercism.y(), 0);
      localTextView.setLayoutParams(localLayoutParams);
      localTextView.setTextSize(16.0F);
      localTextView.setTextColor(-1);
      localTextView.setId(51);
      localTextView.setText(Crittercism.getNotificationTitle() + ": " + paramBundle);
      localLinearLayout.addView(localTextView);
      setContentView(localLinearLayout);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    finish();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/crittercism/NotificationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */