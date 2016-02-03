package mobi.ifunny.view.drawable;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public class a
        extends Drawable {
    private final Paint a = new Paint();

    public a() {
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(0.0F);
        this.a.setColor(-16777216);
        this.a.setPathEffect(new DashPathEffect(new float[]{15.0F, 15.0F}, 0.0F));
        Bitmap localBitmap = Bitmap.createBitmap(30, 1, Bitmap.Config.RGB_565);
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.drawColor(-1);
        localCanvas.drawLine(0.0F, 0.0F, 30.0F, 0.0F, this.a);
        this.a.setColor(-1);
        this.a.setPathEffect(null);
        this.a.setShader(new BitmapShader(localBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
    }

    public void draw(Canvas paramCanvas) {
        Rect localRect = getBounds();
        paramCanvas.drawLine(localRect.left, localRect.top, localRect.right, localRect.top, this.a);
    }

    public int getOpacity() {
        return -1;
    }

    public void setAlpha(int paramInt) {
    }

    public void setColorFilter(ColorFilter paramColorFilter) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/drawable/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */