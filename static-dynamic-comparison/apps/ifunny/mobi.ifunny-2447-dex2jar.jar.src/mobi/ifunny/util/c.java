package mobi.ifunny.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;
import android.widget.ImageView;

public class c {
    public final Drawable a;
    public final Drawable b;

    public c(Context paramContext) {
        paramContext = paramContext.getResources();
        this.a = paramContext.getDrawable(2130837610);
        this.b = paramContext.getDrawable(2130837611);
    }

    public com.makeramen.c a() {
        return (com.makeramen.c) com.makeramen.c.a(this.a);
    }

    public void a(int paramInt, View paramView, boolean paramBoolean) {
        if (paramBoolean) {
            paramView.setVisibility(0);
            Drawable localDrawable = paramView.getBackground();
            Object localObject;
            if (paramInt == 0) {
                if ((localDrawable != null) && ((localDrawable instanceof LevelListDrawable))) {
                    localObject = localDrawable;
                    if (localDrawable.getLevel() != 0) {
                        localDrawable.setVisible(true, true);
                    }
                } else {
                    localObject = paramView.getResources().getDrawable(2130837608);
                }
                ((Drawable) localObject).setLevel(r.b(1, 6));
                paramView.setBackgroundDrawable((Drawable) localObject);
                return;
            }
            if ((localDrawable != null) && ((localDrawable instanceof ShapeDrawable))) {
                ShapeDrawable localShapeDrawable = (ShapeDrawable) localDrawable;
                localObject = localShapeDrawable;
                if (localShapeDrawable.getPaint().getColor() == paramInt) {
                    localDrawable.setVisible(true, true);
                }
            } else {
                localObject = new ShapeDrawable(new OvalShape());
            }
            ((ShapeDrawable) localObject).getPaint().setColor(paramInt);
            paramView.setBackgroundDrawable((Drawable) localObject);
            return;
        }
        paramView.setVisibility(4);
    }

    public void a(ImageView paramImageView, boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (com.makeramen.c localc = b(); ; localc = a()) {
            localc.a(true);
            paramImageView.setImageDrawable(localc);
            return;
        }
    }

    public com.makeramen.c b() {
        return (com.makeramen.c) com.makeramen.c.a(this.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */