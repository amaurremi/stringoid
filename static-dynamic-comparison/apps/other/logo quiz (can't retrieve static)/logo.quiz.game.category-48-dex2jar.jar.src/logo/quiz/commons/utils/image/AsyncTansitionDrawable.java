package logo.quiz.commons.utils.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import java.lang.ref.WeakReference;

public class AsyncTansitionDrawable
  extends TransitionDrawable
{
  private final WeakReference<BitmapWorkerTask> bitmapWorkerTaskReference;
  
  public AsyncTansitionDrawable(Resources paramResources, Bitmap paramBitmap, BitmapWorkerTask paramBitmapWorkerTask)
  {
    super(new Drawable[] { new ColorDrawable(0), new BitmapDrawable(paramResources, paramBitmap) });
    this.bitmapWorkerTaskReference = new WeakReference(paramBitmapWorkerTask);
  }
  
  public BitmapWorkerTask getBitmapWorkerTask()
  {
    return (BitmapWorkerTask)this.bitmapWorkerTaskReference.get();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/image/AsyncTansitionDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */