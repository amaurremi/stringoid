package com.scoreloop.client.android.core.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MyspaceCaptchaDialog
  extends ScoreloopCustomDialog
{
  private String a;
  private CaptchaCompletionListener b;
  
  public MyspaceCaptchaDialog(Context paramContext, CaptchaCompletionListener paramCaptchaCompletionListener, String paramString)
  {
    super(paramContext);
    this.b = paramCaptchaCompletionListener;
    this.a = paramString;
  }
  
  protected void onStart()
  {
    super.onStart();
    final Object localObject = new WebView(getContext());
    ((WebView)localObject).loadUrl(this.a);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.addView((View)localObject);
    localObject = new EditText(getContext());
    ((EditText)localObject).setWidth(100);
    localLinearLayout.addView((View)localObject);
    Button localButton = new Button(getContext());
    localButton.setWidth(100);
    localButton.setText("submit");
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = localObject.getText().toString();
        MyspaceCaptchaDialog.a(MyspaceCaptchaDialog.this).a(paramAnonymousView);
      }
    });
    localLinearLayout.addView(localButton);
    setContentView(localLinearLayout);
  }
  
  public static abstract interface CaptchaCompletionListener
  {
    public abstract void a(String paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/ui/MyspaceCaptchaDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */