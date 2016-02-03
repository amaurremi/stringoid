package mobi.ifunny.studio.meme;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.EditText;
import mobi.ifunny.util.a.b;
import mobi.ifunny.view.FitImageView;

public class MemeFitImageView
        extends FitImageView {
    private EditText e;
    private EditText f;

    public MemeFitImageView(Context paramContext) {
        super(paramContext);
    }

    public MemeFitImageView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public MemeFitImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        b.a(getContext(), paramCanvas, getWidth(), getHeight(), this.e.getText().toString(), this.e.getTextSize(), this.f.getText().toString(), this.f.getTextSize(), 1.0F);
    }

    public void setSubtitleView(EditText paramEditText) {
        this.f = paramEditText;
    }

    public void setTitleView(EditText paramEditText) {
        this.e = paramEditText;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/meme/MemeFitImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */