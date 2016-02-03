package logo.quiz.commons.utils.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.view.View;
import java.lang.ref.WeakReference;

public class BitmapDrawableWorkerTask
  extends AsyncTask<String, Void, BitmapDrawable>
{
  private Context context;
  private final WeakReference<View> imageViewReference;
  int placeHolderSize = 70;
  private int resId = 0;
  private final Resources resources;
  
  public BitmapDrawableWorkerTask(View paramView, int paramInt, Resources paramResources, Context paramContext)
  {
    this.imageViewReference = new WeakReference(paramView);
    this.placeHolderSize = paramInt;
    this.resources = paramResources;
    this.context = paramContext;
  }
  
  public static boolean cancelPotentialWork(int paramInt, View paramView)
  {
    paramView = getBitmapWorkerTask(paramView);
    if (paramView != null)
    {
      if (paramView.getResId() != paramInt) {
        paramView.cancel(true);
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public static BitmapDrawableWorkerTask getBitmapWorkerTask(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getBackground();
      if ((paramView instanceof AsyncBitmapDrawable)) {
        return ((AsyncBitmapDrawable)paramView).getBitmapWorkerTask();
      }
    }
    return null;
  }
  
  protected BitmapDrawable doInBackground(String[] paramArrayOfString)
  {
    this.resId = Integer.valueOf(paramArrayOfString[0]).intValue();
    try
    {
      paramArrayOfString = new BitmapDrawable(this.resources, ImageUtils.decodeSampledBitmapFromResource(this.resources, Integer.valueOf(this.resId).intValue(), this.placeHolderSize, this.placeHolderSize));
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
    return null;
  }
  
  public int getResId()
  {
    return this.resId;
  }
  
  protected void onPostExecute(BitmapDrawable paramBitmapDrawable)
  {
    if (isCancelled()) {
      paramBitmapDrawable = null;
    }
    if ((this.imageViewReference != null) && (paramBitmapDrawable != null))
    {
      View localView = (View)this.imageViewReference.get();
      if ((this == getBitmapWorkerTask(localView)) && (localView != null))
      {
        localView.setBackgroundDrawable(paramBitmapDrawable);
        ImageUtils.putLevelImageToCache(this.resId, paramBitmapDrawable);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/image/BitmapDrawableWorkerTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */