package logo.quiz.commons.utils.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

public class AsyncDrawable
  extends BitmapDrawable
{
  private final WeakReference<BitmapWorkerTask> bitmapWorkerTaskReference;
  
  public AsyncDrawable(Resources paramResources, Bitmap paramBitmap, BitmapWorkerTask paramBitmapWorkerTask)
  {
    super(paramResources, paramBitmap);
    this.bitmapWorkerTaskReference = new WeakReference(paramBitmapWorkerTask);
  }
  
  public AsyncDrawable(Resources paramResources, BitmapWorkerTask paramBitmapWorkerTask)
  {
    super(paramResources);
    this.bitmapWorkerTaskReference = new WeakReference(paramBitmapWorkerTask);
  }
  
  public BitmapWorkerTask getBitmapWorkerTask()
  {
    return (BitmapWorkerTask)this.bitmapWorkerTaskReference.get();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/image/AsyncDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */