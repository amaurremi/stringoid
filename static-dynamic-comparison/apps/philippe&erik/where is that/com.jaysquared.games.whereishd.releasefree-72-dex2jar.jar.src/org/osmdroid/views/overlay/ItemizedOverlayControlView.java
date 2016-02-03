package org.osmdroid.views.overlay;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.ResourceProxy.bitmap;

public class ItemizedOverlayControlView
  extends LinearLayout
{
  protected ImageButton mCenterToButton;
  protected ItemizedOverlayControlViewListener mLis;
  protected ImageButton mNavToButton;
  protected ImageButton mNextButton;
  protected ImageButton mPreviousButton;
  
  public ItemizedOverlayControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, new DefaultResourceProxyImpl(paramContext));
  }
  
  public ItemizedOverlayControlView(Context paramContext, AttributeSet paramAttributeSet, ResourceProxy paramResourceProxy)
  {
    super(paramContext, paramAttributeSet);
    this.mPreviousButton = new ImageButton(paramContext);
    this.mPreviousButton.setImageBitmap(paramResourceProxy.getBitmap(ResourceProxy.bitmap.previous));
    this.mNextButton = new ImageButton(paramContext);
    this.mNextButton.setImageBitmap(paramResourceProxy.getBitmap(ResourceProxy.bitmap.next));
    this.mCenterToButton = new ImageButton(paramContext);
    this.mCenterToButton.setImageBitmap(paramResourceProxy.getBitmap(ResourceProxy.bitmap.center));
    this.mNavToButton = new ImageButton(paramContext);
    this.mNavToButton.setImageBitmap(paramResourceProxy.getBitmap(ResourceProxy.bitmap.navto_small));
    addView(this.mPreviousButton, new LinearLayout.LayoutParams(-2, -2));
    addView(this.mCenterToButton, new LinearLayout.LayoutParams(-2, -2));
    addView(this.mNavToButton, new LinearLayout.LayoutParams(-2, -2));
    addView(this.mNextButton, new LinearLayout.LayoutParams(-2, -2));
    initViewListeners();
  }
  
  private void initViewListeners()
  {
    this.mNextButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ItemizedOverlayControlView.this.mLis != null) {
          ItemizedOverlayControlView.this.mLis.onNext();
        }
      }
    });
    this.mPreviousButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ItemizedOverlayControlView.this.mLis != null) {
          ItemizedOverlayControlView.this.mLis.onPrevious();
        }
      }
    });
    this.mCenterToButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ItemizedOverlayControlView.this.mLis != null) {
          ItemizedOverlayControlView.this.mLis.onCenter();
        }
      }
    });
    this.mNavToButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ItemizedOverlayControlView.this.mLis != null) {
          ItemizedOverlayControlView.this.mLis.onNavTo();
        }
      }
    });
  }
  
  public void setItemizedOverlayControlViewListener(ItemizedOverlayControlViewListener paramItemizedOverlayControlViewListener)
  {
    this.mLis = paramItemizedOverlayControlViewListener;
  }
  
  public void setNavToVisible(int paramInt)
  {
    this.mNavToButton.setVisibility(paramInt);
  }
  
  public void setNextEnabled(boolean paramBoolean)
  {
    this.mNextButton.setEnabled(paramBoolean);
  }
  
  public void setPreviousEnabled(boolean paramBoolean)
  {
    this.mPreviousButton.setEnabled(paramBoolean);
  }
  
  public static abstract interface ItemizedOverlayControlViewListener
  {
    public abstract void onCenter();
    
    public abstract void onNavTo();
    
    public abstract void onNext();
    
    public abstract void onPrevious();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/ItemizedOverlayControlView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */