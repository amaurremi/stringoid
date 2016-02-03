package com.bluebird.mobile.tools.todays.offer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.bluebird.mobile.tools.R.anim;
import com.bluebird.mobile.tools.R.id;
import com.bluebird.mobile.tools.R.string;
import com.bluebird.mobile.tools.commons.PopupListener;

public class TodayOffer
{
  private Activity activity;
  private PopupListener popupListener;
  private TodayOfferAd todayOfferAd;
  
  public TodayOffer(TodayOfferAd paramTodayOfferAd, Activity paramActivity)
  {
    this.todayOfferAd = paramTodayOfferAd;
    if (paramTodayOfferAd != null) {}
    try
    {
      ((ImageView)paramActivity.findViewById(R.id.todayOfferImage)).setImageResource(paramTodayOfferAd.getImageResource());
      String str1 = paramActivity.getString(R.string.today_offer_label1, paramTodayOfferAd.getLabel1Args());
      String str2 = paramActivity.getString(R.string.today_offer_label2, paramTodayOfferAd.getLabel2Args());
      ((TextView)paramActivity.findViewById(R.id.todayOfferLabel1)).setText(Html.fromHtml(str1));
      ((TextView)paramActivity.findViewById(R.id.todayOfferLabel2)).setText(str2);
      if (paramTodayOfferAd.getH1Args() != null)
      {
        str1 = paramActivity.getString(R.string.today_offer_h1, paramTodayOfferAd.getH1Args());
        ((TextView)paramActivity.findViewById(R.id.todayOfferH1)).setText(Html.fromHtml(str1), TextView.BufferType.SPANNABLE);
      }
      this.popupListener = paramTodayOfferAd.getPopupListener();
      paramTodayOfferAd = (ViewGroup)paramActivity.findViewById(R.id.todayOfferContainer);
      int j = paramTodayOfferAd.getChildCount();
      int i = 0;
      while (i < j)
      {
        paramTodayOfferAd.getChildAt(i).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            TodayOffer.this.openOfferUrl();
          }
        });
        i += 1;
      }
      paramActivity.findViewById(R.id.todaysOfferClose).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          TodayOffer.this.closeOffer();
        }
      });
    }
    catch (Exception paramTodayOfferAd)
    {
      for (;;)
      {
        Log.e("TodayOffer", "Forget to add a todays offer view! Default it is todays_offer.xml from android-tools.", paramTodayOfferAd);
      }
    }
    this.activity = paramActivity;
  }
  
  public void closeOffer()
  {
    closeOffer(true);
  }
  
  public void closeOffer(boolean paramBoolean)
  {
    try
    {
      View localView = this.activity.findViewById(R.id.todayOfferContainer);
      if (localView.getVisibility() != 8)
      {
        localView.setVisibility(8);
        if (paramBoolean) {
          localView.startAnimation(AnimationUtils.loadAnimation(this.activity.getApplicationContext(), R.anim.slide_down));
        }
        if (this.popupListener != null) {
          this.popupListener.onDismiss();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("TodayOffer", "Forget to add a todays offer view! Default it is todays_offer.xml from android-tools.", localException);
    }
  }
  
  public void openOfferUrl()
  {
    try
    {
      if (this.popupListener != null) {
        this.popupListener.onClick();
      }
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(this.todayOfferAd.getOfferUrl()));
      localIntent.addFlags(1073741824);
      this.activity.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      Log.e("TodayOffer", "Forget to add a todays offer view! Default it is todays_offer.xml from android-tools.", localException);
    }
  }
  
  public void showOffer()
  {
    showOffer(true);
  }
  
  public void showOffer(boolean paramBoolean)
  {
    try
    {
      View localView = this.activity.findViewById(R.id.todayOfferContainer);
      localView.setVisibility(0);
      if (paramBoolean)
      {
        Animation localAnimation = AnimationUtils.loadAnimation(this.activity.getApplicationContext(), R.anim.slide_up);
        localAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            if (TodayOffer.this.popupListener != null) {
              TodayOffer.this.popupListener.onShowEnd();
            }
          }
          
          public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public void onAnimationStart(Animation paramAnonymousAnimation)
          {
            if (TodayOffer.this.popupListener != null) {
              TodayOffer.this.popupListener.onShowStart();
            }
          }
        });
        localView.startAnimation(localAnimation);
        return;
      }
      if (this.popupListener != null)
      {
        this.popupListener.onShowStart();
        this.popupListener.onShowEnd();
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("TodayOffer", "Forget to add a todays offer view! Default it is todays_offer.xml from android-tools.", localException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/todays/offer/TodayOffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */