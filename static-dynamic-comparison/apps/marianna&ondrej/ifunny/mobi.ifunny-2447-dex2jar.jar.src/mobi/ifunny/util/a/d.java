package mobi.ifunny.util.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Iterator;

public class d {
    public final int a;
    public final int b;
    public final ArrayList<e> c;

    public d(int paramInt1, int paramInt2, ArrayList<e> paramArrayList) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramArrayList;
    }

    public void a() {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext()) {
            ((e) localIterator.next()).a.recycle();
        }
    }

    public boolean b() {
        return this.c.isEmpty();
    }

    public int c() {
        return this.c.size();
    }

    public Bitmap d() {
        if (this.c == null) {
            return null;
        }
        if (this.c.size() == 1) {
            return ((e) this.c.get(0)).a;
        }
        Bitmap localBitmap = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        localPaint.setFilterBitmap(true);
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext()) {
            e locale = (e) localIterator.next();
            localCanvas.drawBitmap(locale.a, null, locale.b, localPaint);
        }
        return localBitmap;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder(String.format("SlicedBitmap{width=%d, height=%d}", new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b)}));
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext()) {
            e locale = (e) localIterator.next();
            localStringBuilder.append('\n').append(' ').append(locale.toString());
        }
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */