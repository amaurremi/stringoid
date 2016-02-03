package com.squareup.picasso;

import android.graphics.Bitmap;

public abstract interface Transformation
{
  public abstract String key();
  
  public abstract Bitmap transform(Bitmap paramBitmap);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/picasso/Transformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */