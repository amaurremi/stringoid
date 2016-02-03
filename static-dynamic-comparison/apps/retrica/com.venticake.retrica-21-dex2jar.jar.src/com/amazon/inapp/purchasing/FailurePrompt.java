package com.amazon.inapp.purchasing;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.amazon.android.framework.context.ContextManager;
import com.amazon.android.framework.prompt.PromptContent;
import com.amazon.android.framework.prompt.SimplePrompt;
import com.amazon.android.framework.resource.Resource;

class FailurePrompt
  extends SimplePrompt
{
  private static final String LINK = "http://www.amazon.com/gp/mas/get-appstore/android/ref=mas_mx_mba_iap_dl";
  private static final String PROMPT_TITLE1 = "Amazon Appstore required";
  private static final String PROMPT_TITLE2 = "Amazon Appstore Update Required";
  private static final long SHUTDOWN_EXP_TIME = 31536000L;
  private static final String TAG = "FailurePrompt";
  @Resource
  private ContextManager contextMgr;
  private PromptContent pContent;
  
  FailurePrompt(PromptContent paramPromptContent)
  {
    super(paramPromptContent);
    this.pContent = paramPromptContent;
  }
  
  protected void doAction()
  {
    if (Logger.isTraceOn()) {
      Logger.trace("FailurePrompt", "doAction");
    }
    if (("Amazon Appstore required".equalsIgnoreCase(this.pContent.getTitle())) || ("Amazon Appstore Update Required".equalsIgnoreCase(this.pContent.getTitle()))) {}
    try
    {
      Activity localActivity2 = this.contextMgr.getVisible();
      Activity localActivity1 = localActivity2;
      if (localActivity2 == null) {
        localActivity1 = this.contextMgr.getRoot();
      }
      localActivity1.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.amazon.com/gp/mas/get-appstore/android/ref=mas_mx_mba_iap_dl")));
      return;
    }
    catch (Exception localException)
    {
      while (!Logger.isTraceOn()) {}
      Logger.trace("FailurePrompt", "Exception in PurchaseItemCommandTask.OnSuccess: " + localException);
    }
  }
  
  protected long getExpirationDurationInSeconds()
  {
    return 31536000L;
  }
  
  public String toString()
  {
    return "FailurePrompt";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/FailurePrompt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */