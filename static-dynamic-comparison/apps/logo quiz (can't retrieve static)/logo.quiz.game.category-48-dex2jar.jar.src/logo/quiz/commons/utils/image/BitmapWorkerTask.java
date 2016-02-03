package logo.quiz.commons.utils.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public class BitmapWorkerTask
  extends AsyncTask<String, Void, Bitmap>
{
  private Context context;
  private String drawableName = "0";
  private final WeakReference<ImageView> imageViewReference;
  int placeHolderSize = 70;
  private int resId = 0;
  private final Resources resources;
  
  public BitmapWorkerTask(ImageView paramImageView, int paramInt, Resources paramResources, Context paramContext)
  {
    this.imageViewReference = new WeakReference(paramImageView);
    this.placeHolderSize = paramInt;
    this.resources = paramResources;
    this.context = paramContext;
  }
  
  public static boolean cancelPotentialWork(String paramString, ImageView paramImageView)
  {
    paramImageView = getBitmapWorkerTask(paramImageView);
    if (paramImageView != null)
    {
      if (!paramImageView.getDrawableName().equals(paramString)) {
        paramImageView.cancel(true);
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public static BitmapWorkerTask getBitmapWorkerTask(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getDrawable();
      if ((paramImageView instanceof AsyncDrawable)) {
        return ((AsyncDrawable)paramImageView).getBitmapWorkerTask();
      }
    }
    return null;
  }
  
  protected Bitmap doInBackground(String[] paramArrayOfString)
  {
    this.resId = Integer.valueOf(paramArrayOfString[0]).intValue();
    this.drawableName = paramArrayOfString[1];
    try
    {
      if (this.resId == -1) {
        return DecodeUtils.decode(this.context, Uri.parse(this.drawableName), this.placeHolderSize, this.placeHolderSize);
      }
      paramArrayOfString = ImageUtils.decodeSampledBitmapFromResource(this.resources, Integer.valueOf(this.resId).intValue(), this.placeHolderSize, this.placeHolderSize);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
    return null;
  }
  
  public String getDrawableName()
  {
    return this.drawableName;
  }
  
  protected void onPostExecute(Bitmap paramBitmap)
  {
    if (isCancelled()) {
      paramBitmap = null;
    }
    if ((this.imageViewReference != null) && (paramBitmap != null))
    {
      ImageView localImageView = (ImageView)this.imageViewReference.get();
      if ((this == getBitmapWorkerTask(localImageView)) && (localImageView != null))
      {
        localImageView.setImageBitmap(paramBitmap);
        ImageUtils.putImageToCache(this.drawableName, paramBitmap);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/image/BitmapWorkerTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */