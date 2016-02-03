package com.mopub.nativeads;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.nativeads.util.Utils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class NativeViewHolder
{
  TextView callToActionView;
  ImageView iconImageView;
  ImageView mainImageView;
  TextView textView;
  TextView titleView;
  
  private void addTextView(TextView paramTextView, String paramString)
  {
    if (paramTextView == null)
    {
      Utils.MoPubLog("Attempted to add text (" + paramString + ") to null TextView.");
      return;
    }
    paramTextView.setText(null);
    if (paramString == null)
    {
      Utils.MoPubLog("Attempted to set TextView contents to null.");
      return;
    }
    paramTextView.setText(paramString);
  }
  
  static NativeViewHolder fromViewBinder(View paramView, ViewBinder paramViewBinder)
  {
    NativeViewHolder localNativeViewHolder = new NativeViewHolder();
    try
    {
      localNativeViewHolder.titleView = ((TextView)paramView.findViewById(paramViewBinder.titleId));
      localNativeViewHolder.textView = ((TextView)paramView.findViewById(paramViewBinder.textId));
      localNativeViewHolder.callToActionView = ((TextView)paramView.findViewById(paramViewBinder.callToActionId));
      localNativeViewHolder.mainImageView = ((ImageView)paramView.findViewById(paramViewBinder.mainImageId));
      localNativeViewHolder.iconImageView = ((ImageView)paramView.findViewById(paramViewBinder.iconImageId));
      return localNativeViewHolder;
    }
    catch (ClassCastException paramView)
    {
      Utils.MoPubLog("Could not cast View from id in ViewBinder to expected View type", paramView);
    }
    return null;
  }
  
  void update(NativeResponse paramNativeResponse)
  {
    addTextView(this.titleView, paramNativeResponse.getTitle());
    addTextView(this.textView, paramNativeResponse.getSubtitle());
    addTextView(this.callToActionView, paramNativeResponse.getCallToAction());
    paramNativeResponse.loadMainImage(this.mainImageView);
    paramNativeResponse.loadIconImage(this.iconImageView);
  }
  
  void updateExtras(View paramView, NativeResponse paramNativeResponse, ViewBinder paramViewBinder)
  {
    Iterator localIterator = paramViewBinder.extras.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      View localView = paramView.findViewById(((Integer)paramViewBinder.extras.get(str)).intValue());
      Object localObject = paramNativeResponse.getExtra(str);
      if (NativeResponse.Parameter.isImageKey(str))
      {
        if ((localView instanceof ImageView))
        {
          ((ImageView)localView).setImageDrawable(null);
          paramNativeResponse.loadExtrasImage(str, (ImageView)localView);
        }
        else
        {
          Utils.MoPubLog("View bound to " + str + " should be an instance of ImageView.");
        }
      }
      else if ((localView instanceof TextView))
      {
        ((TextView)localView).setText(null);
        if ((localObject instanceof String)) {
          addTextView((TextView)localView, (String)localObject);
        }
      }
      else
      {
        Utils.MoPubLog("View bound to " + str + " should be an instance of TextView.");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/NativeViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */