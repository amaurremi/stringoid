package mobi.ifunny.studio.gif;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import mobi.ifunny.e;
import mobi.ifunny.l.b;

class h
        extends b<GifCaptionActivity, Void, Void, Bitmap> {
    private String a;
    private int b;
    private g c;

    private h(GifCaptionActivity paramGifCaptionActivity, String paramString1, String paramString2, int paramInt, g paramg) {
        super(paramGifCaptionActivity, paramString1);
        this.a = paramString2;
        this.b = paramInt;
        this.c = paramg;
    }

    protected Bitmap a(Void... paramVarArgs) {
        paramVarArgs = new TextPaint(1);
        paramVarArgs.setColor(this.c.c());
        paramVarArgs.setTextSize(this.c.g());
        paramVarArgs.setTypeface(this.c.a());
        Object localObject1 = this.c.f();
        Object localObject2 = new StaticLayout(this.a, paramVarArgs, this.b - ((Rect) localObject1).left - ((Rect) localObject1).right, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
        int i = ((StaticLayout) localObject2).getHeight() + ((Rect) localObject1).top + ((Rect) localObject1).bottom;
        paramVarArgs = Bitmap.createBitmap(this.b, i, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(paramVarArgs);
        localCanvas.drawColor(this.c.d());
        localCanvas.save();
        localCanvas.translate(((Rect) localObject1).left, ((Rect) localObject1).top);
        ((StaticLayout) localObject2).draw(localCanvas);
        localCanvas.restore();
        localObject1 = e.a.getResources().getDrawable(2130837959);
        int j = (int) (((Drawable) localObject1).getIntrinsicWidth() * 1.0F);
        int k = (int) (1.0F * ((Drawable) localObject1).getIntrinsicHeight());
        localObject2 = this.c.b();
        Rect localRect = new Rect();
        localRect.left = (this.b - ((Point) localObject2).x - j);
        localRect.top = (i - ((Point) localObject2).y - k);
        localRect.right = (localRect.left + j);
        localRect.bottom = (localRect.top + k);
        ((Drawable) localObject1).setBounds(localRect);
        ((Drawable) localObject1).setDither(false);
        ((Drawable) localObject1).setFilterBitmap(true);
        ((Drawable) localObject1).draw(localCanvas);
        return paramVarArgs;
    }

    protected void a(GifCaptionActivity paramGifCaptionActivity) {
        super.onStarted(paramGifCaptionActivity);
        GifCaptionActivity.f(paramGifCaptionActivity);
    }

    protected void a(GifCaptionActivity paramGifCaptionActivity, Bitmap paramBitmap) {
        super.onPostExecute(paramGifCaptionActivity, paramBitmap);
        if (paramBitmap != null) {
            GifCaptionActivity.a(paramGifCaptionActivity, paramBitmap, this.a);
            return;
        }
        GifCaptionActivity.g(paramGifCaptionActivity);
    }

    protected void b(GifCaptionActivity paramGifCaptionActivity) {
        GifCaptionActivity.h(paramGifCaptionActivity);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/gif/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */