package com.parse.oauth;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class OAuth1FlowDialog
  extends Dialog
{
  private static final FrameLayout.LayoutParams FILL = new FrameLayout.LayoutParams(-1, -1);
  private final String callbackUrl;
  private ImageView closeImage;
  private FrameLayout content;
  private final FlowResultHandler handler;
  private ProgressDialog progressDialog;
  private final String requestUrl;
  private final String serviceUrlIdentifier;
  private WebView webView;
  
  public OAuth1FlowDialog(Context paramContext, String paramString1, String paramString2, String paramString3, FlowResultHandler paramFlowResultHandler)
  {
    super(paramContext, 16973840);
    this.requestUrl = paramString1;
    this.callbackUrl = paramString2;
    this.serviceUrlIdentifier = paramString3;
    this.handler = paramFlowResultHandler;
    setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        OAuth1FlowDialog.this.handler.onCancel();
      }
    });
  }
  
  private void createCloseImage()
  {
    this.closeImage = new ImageView(getContext());
    this.closeImage.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        OAuth1FlowDialog.this.cancel();
      }
    });
    Drawable localDrawable = getContext().getResources().getDrawable(17301527);
    this.closeImage.setImageDrawable(localDrawable);
    this.closeImage.setVisibility(4);
  }
  
  private void setUpWebView(int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    this.webView = new WebView(getContext());
    this.webView.setVerticalScrollBarEnabled(false);
    this.webView.setHorizontalScrollBarEnabled(false);
    this.webView.setWebViewClient(new OAuth1WebViewClient(null));
    this.webView.getSettings().setJavaScriptEnabled(true);
    this.webView.loadUrl(this.requestUrl);
    this.webView.setLayoutParams(FILL);
    this.webView.setVisibility(4);
    localLinearLayout.setPadding(paramInt, paramInt, paramInt, paramInt);
    localLinearLayout.addView(this.webView);
    this.content.addView(localLinearLayout);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.progressDialog = new ProgressDialog(getContext());
    this.progressDialog.requestWindowFeature(1);
    this.progressDialog.setMessage("Loading...");
    requestWindowFeature(1);
    this.content = new FrameLayout(getContext());
    createCloseImage();
    setUpWebView(this.closeImage.getDrawable().getIntrinsicWidth() / 2);
    this.content.addView(this.closeImage, new ViewGroup.LayoutParams(-2, -2));
    addContentView(this.content, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public static abstract interface FlowResultHandler
  {
    public abstract void onCancel();
    
    public abstract void onComplete(String paramString);
    
    public abstract void onError(int paramInt, String paramString1, String paramString2);
  }
  
  private class OAuth1WebViewClient
    extends WebViewClient
  {
    private OAuth1WebViewClient() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      try
      {
        OAuth1FlowDialog.this.progressDialog.dismiss();
        OAuth1FlowDialog.this.content.setBackgroundColor(0);
        OAuth1FlowDialog.this.webView.setVisibility(0);
        OAuth1FlowDialog.this.closeImage.setVisibility(0);
        return;
      }
      catch (IllegalArgumentException paramWebView)
      {
        for (;;) {}
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      OAuth1FlowDialog.this.progressDialog.show();
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      OAuth1FlowDialog.this.dismiss();
      OAuth1FlowDialog.this.handler.onError(paramInt, paramString1, paramString2);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if (paramString.startsWith(OAuth1FlowDialog.this.callbackUrl))
      {
        OAuth1FlowDialog.this.dismiss();
        OAuth1FlowDialog.this.handler.onComplete(paramString);
        return true;
      }
      if (paramString.contains(OAuth1FlowDialog.this.serviceUrlIdentifier)) {
        return false;
      }
      OAuth1FlowDialog.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/oauth/OAuth1FlowDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */