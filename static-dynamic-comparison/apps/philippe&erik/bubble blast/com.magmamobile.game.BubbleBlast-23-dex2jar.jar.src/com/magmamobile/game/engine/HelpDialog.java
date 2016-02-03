package com.magmamobile.game.engine;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import java.util.Locale;

public final class HelpDialog
  extends WebViewClient
  implements View.OnClickListener, DialogInterface.OnDismissListener
{
  private int _close;
  private Context _context;
  private String[] _languages;
  private int _title;
  private String _url;
  private Button mButton;
  private Dialog mDialog;
  private LinearLayout mLayout;
  private ProgressBar mProgress;
  private WebView mWebview;
  
  public HelpDialog(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    this._languages = paramArrayOfString;
    this._context = paramContext;
    this._close = paramInt1;
    this._title = paramInt2;
    this._url = paramString;
  }
  
  private String getHtmlURL(Context paramContext)
  {
    int i;
    int j;
    if (this._languages != null)
    {
      paramContext = paramContext.getResources().getConfiguration().locale.getLanguage();
      i = 0;
      j = this._languages.length;
    }
    for (;;)
    {
      if (i >= j) {
        return this._url.replace("{0}", "");
      }
      if (this._languages[i].equals(paramContext)) {
        return this._url.replace("{0}", "-".concat(this._languages[i]));
      }
      i += 1;
    }
  }
  
  public String getUrl()
  {
    return this._url;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.mButton) {
      this.mDialog.dismiss();
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.mLayout.removeAllViews();
    this.mLayout.addView(this.mWebview);
    this.mLayout.addView(this.mButton);
  }
  
  public void setUrl(String paramString)
  {
    this._url = paramString;
  }
  
  public void show()
  {
    this.mDialog = new Dialog(this._context);
    this.mDialog.setOnDismissListener(this);
    this.mDialog.setTitle(this._title);
    this.mLayout = new LinearLayout(this._context);
    this.mLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.mLayout.setOrientation(1);
    this.mLayout.setGravity(1);
    this.mProgress = new ProgressBar(this._context);
    this.mProgress.setIndeterminate(true);
    this.mProgress.setPadding(64, 64, 64, 64);
    this.mLayout.addView(this.mProgress);
    this.mButton = new Button(this._context);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = (-(int)Game.dpi(50.0F));
    this.mButton.setLayoutParams(localLayoutParams);
    this.mButton.setText(this._close);
    this.mButton.setOnClickListener(this);
    this.mWebview = new WebView(this._context);
    this.mWebview.setHorizontalScrollBarEnabled(true);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.bottomMargin = ((int)Game.dpi(50.0F));
    this.mWebview.setLayoutParams(localLayoutParams);
    this.mWebview.loadUrl(getHtmlURL(this._context));
    this.mWebview.setWebViewClient(this);
    this.mDialog.setContentView(this.mLayout);
    this.mDialog.show();
    this.mDialog.getWindow().setLayout(-1, -1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/HelpDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */