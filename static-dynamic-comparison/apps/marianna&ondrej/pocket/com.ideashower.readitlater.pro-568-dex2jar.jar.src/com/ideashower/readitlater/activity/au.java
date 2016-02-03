package com.ideashower.readitlater.activity;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.net.http.SslCertificate.DName;
import android.net.http.SslError;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ideashower.readitlater.a.a.d;
import com.ideashower.readitlater.activity.a.q;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.reader.ReaderWebView;
import com.ideashower.readitlater.reader.f;
import com.ideashower.readitlater.util.g;
import com.ideashower.readitlater.views.ErrorView;
import com.pocket.m.a.c;
import com.pocket.m.a.l;

class au
  extends WebViewClient
{
  private au(ReaderFragment paramReaderFragment) {}
  
  private void a(final SslErrorHandler paramSslErrorHandler, final SslError paramSslError, boolean paramBoolean)
  {
    if (this.a.Q())
    {
      paramSslErrorHandler.cancel();
      return;
    }
    String str1 = this.a.a(2131493151);
    Object localObject2;
    StringBuilder localStringBuilder;
    String str3;
    label152:
    label170:
    String str2;
    if (paramBoolean)
    {
      localObject2 = paramSslError.getCertificate();
      switch (paramSslError.getPrimaryError())
      {
      default: 
        localObject1 = this.a.a(2131493274);
        java.text.DateFormat localDateFormat = android.text.format.DateFormat.getDateFormat(this.a.m());
        localStringBuilder = new StringBuilder().append(str1).append((String)localObject1).append("\n\n");
        str3 = this.a.a(2131493272);
        if (((SslCertificate)localObject2).getIssuedTo() != null)
        {
          localObject1 = ((SslCertificate)localObject2).getIssuedTo().getDName();
          if (((SslCertificate)localObject2).getIssuedBy() == null) {
            break label421;
          }
          str1 = ((SslCertificate)localObject2).getIssuedBy().getDName();
          if (((SslCertificate)localObject2).getValidNotBeforeDate() == null) {
            break label435;
          }
          str2 = localDateFormat.format(((SslCertificate)localObject2).getValidNotBeforeDate());
          label190:
          if (((SslCertificate)localObject2).getValidNotAfterDate() == null) {
            break label449;
          }
          localObject2 = localDateFormat.format(((SslCertificate)localObject2).getValidNotAfterDate());
        }
        break;
      }
    }
    label210:
    for (Object localObject1 = String.format(str3, new Object[] { localObject1, str1, str2, localObject2 });; localObject1 = str1)
    {
      localObject1 = new AlertDialog.Builder(this.a.m()).setIcon(17301543).setTitle(2131493152).setMessage((CharSequence)localObject1).setNegativeButton(this.a.a(2131492902), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramSslErrorHandler.cancel();
          ReaderFragment.a(au.this.a, UiTrigger.t);
        }
      }).setPositiveButton(2131492883, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramSslErrorHandler.proceed();
        }
      });
      if (!paramBoolean) {
        ((AlertDialog.Builder)localObject1).setNeutralButton(this.a.a(2131493373), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            au.a(au.this, paramSslErrorHandler, paramSslError, true);
          }
        });
      }
      ((AlertDialog.Builder)localObject1).show();
      return;
      localObject1 = this.a.a(2131493271);
      break;
      localObject1 = this.a.a(2131493273);
      break;
      localObject1 = this.a.a(2131493275);
      break;
      localObject1 = this.a.a(2131493276);
      break;
      localObject1 = this.a.a(2131493365);
      break label152;
      label421:
      str1 = this.a.a(2131493365);
      break label170;
      label435:
      str2 = this.a.a(2131493365);
      break label190;
      label449:
      localObject2 = this.a.a(2131493365);
      break label210;
    }
  }
  
  public void a()
  {
    CookieSyncManager.getInstance().sync();
    if (com.ideashower.readitlater.a.a.a.c().c(g.a(ReaderFragment.c(this.a).a()))) {}
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    ReaderFragment.c(this.a).b(false);
    super.onPageFinished(paramWebView, paramString);
    if (!ReaderFragment.e(this.a)) {
      ReaderFragment.f(this.a);
    }
    while ((!paramString.equals(this.a.Y.getUrl())) || ((!paramString.equals(ReaderFragment.c(this.a).d())) && (!paramString.equals(ReaderFragment.g(this.a))))) {
      return;
    }
    this.a.ad();
    a();
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    ReaderFragment.c(this.a).b(true);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    ReaderFragment.a(this.a, true);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((!paramString2.equals(ReaderFragment.c(this.a).d())) && (!paramString2.equals(ReaderFragment.c(this.a).c()))) {
      return;
    }
    if ((paramWebView.equals(ReaderFragment.d(this.a))) && (paramInt == -14)) {
      throw new com.ideashower.readitlater.b.a(this.a.a(2131493299), paramString2);
    }
    if (((paramInt == -14) || (paramInt == -13)) && (l.c().g())) {}
    String str;
    switch (l.c().i())
    {
    case 1: 
    default: 
      paramString2 = ReaderFragment.d(this.a);
      str = this.a.d(2131493603);
      if (!ReaderFragment.c(this.a).g()) {
        break;
      }
    }
    for (paramWebView = this.a.d(2131493472);; paramWebView = this.a.d(2131493470))
    {
      paramString2.a(str, paramString1, paramWebView, new com.ideashower.readitlater.views.m()
      {
        public void a()
        {
          au.this.a.a(UiTrigger.p);
        }
      }, false, com.ideashower.readitlater.h.m.b(this.a.m()));
      ReaderFragment.a(this.a, 2);
      return;
      q.b(1).a(this.a.m());
      break;
      q.b(2).a(this.a.m());
      break;
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    a(paramSslErrorHandler, paramSslError, false);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString.startsWith("file:///android_asset/video.html#")) {
      return true;
    }
    ReaderFragment.a(this.a, paramString, false);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */