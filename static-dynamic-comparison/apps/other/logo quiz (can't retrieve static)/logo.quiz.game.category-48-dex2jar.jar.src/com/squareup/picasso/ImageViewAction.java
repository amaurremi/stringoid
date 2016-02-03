package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class ImageViewAction
  extends Action<ImageView>
{
  Callback callback;
  
  ImageViewAction(Picasso paramPicasso, ImageView paramImageView, Request paramRequest, boolean paramBoolean1, boolean paramBoolean2, int paramInt, Drawable paramDrawable, String paramString, Callback paramCallback)
  {
    super(paramPicasso, paramImageView, paramRequest, paramBoolean1, paramBoolean2, paramInt, paramDrawable, paramString);
    this.callback = paramCallback;
  }
  
  void cancel()
  {
    super.cancel();
    if (this.callback != null) {
      this.callback = null;
    }
  }
  
  public void complete(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom)
  {
    if (paramBitmap == null) {
      throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[] { this }));
    }
    ImageView localImageView = (ImageView)this.target.get();
    if (localImageView == null) {}
    do
    {
      return;
      Context localContext = this.picasso.context;
      boolean bool = this.picasso.indicatorsEnabled;
      PicassoDrawable.setBitmap(localImageView, localContext, paramBitmap, paramLoadedFrom, this.noFade, bool);
    } while (this.callback == null);
    this.callback.onSuccess();
  }
  
  public void error()
  {
    ImageView localImageView = (ImageView)this.target.get();
    if (localImageView == null) {}
    for (;;)
    {
      return;
      if (this.errorResId != 0) {
        localImageView.setImageResource(this.errorResId);
      }
      while (this.callback != null)
      {
        this.callback.onError();
        return;
        if (this.errorDrawable != null) {
          localImageView.setImageDrawable(this.errorDrawable);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/picasso/ImageViewAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */