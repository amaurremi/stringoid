package mobi.ifunny.studio.comics.engine;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import mobi.ifunny.studio.comics.engine.a.h;

public final class EditorView
        extends SurfaceView
        implements SurfaceHolder.Callback {
    private f a;

    public EditorView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void a() {
        getHolder().removeCallback(this);
        this.a = null;
    }

    public void a(f paramf) {
        this.a = paramf;
        SurfaceHolder localSurfaceHolder = getHolder();
        paramf.a(localSurfaceHolder);
        localSurfaceHolder.addCallback(this);
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if (this.a == null) {
            return false;
        }
        return this.a.r().a(paramInt, paramKeyEvent);
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (this.a == null) {
            return false;
        }
        return this.a.r().b(paramInt, paramKeyEvent);
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (this.a == null) {
            return false;
        }
        return this.a.r().a(paramMotionEvent);
    }

    public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {
        if (this.a != null) {
            this.a.a(paramInt2, paramInt3);
        }
    }

    public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {
        if (this.a != null) {
            this.a.h();
        }
    }

    public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {
        if (this.a != null) {
            this.a.i();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/EditorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */