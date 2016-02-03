package mobi.ifunny.studio.comics;

import java.util.TimerTask;

class c
        extends TimerTask {
    c(FrameEditorActivity paramFrameEditorActivity) {
    }

    public void run() {
        this.a.runOnUiThread(new d(this));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */