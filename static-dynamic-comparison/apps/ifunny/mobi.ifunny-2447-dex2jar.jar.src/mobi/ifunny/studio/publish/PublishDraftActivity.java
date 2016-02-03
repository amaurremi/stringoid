package mobi.ifunny.studio.publish;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.a.l;
import android.support.v4.app.af;
import android.support.v4.app.ag;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import mobi.ifunny.rest.content.TaskInfo;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Content;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.rest.retrofit.TypedByteArrayWithFilename;
import mobi.ifunny.studio.a.b.g;
import mobi.ifunny.util.aa;
import mobi.ifunny.view.ImageViewEx;
import mobi.ifunny.view.ProgressBar;
import mobi.ifunny.view.drawable.f;
import retrofit.mime.TypedOutput;

public class PublishDraftActivity
        extends a
        implements ag<mobi.ifunny.util.a.d> {
    public static mobi.ifunny.studio.a.a v;
    public static byte[] w;
    private static final String x = PublishDraftActivity.class.getSimpleName();
    private String y;

    private CharSequence a(mobi.ifunny.studio.a.a parama) {
        String str = parama.a.a;
        if (TextUtils.equals(str, "caption")) {
            parama = (mobi.ifunny.studio.a.a.a) parama.b;
            if (!TextUtils.isEmpty(parama.a)) {
                return c(parama.a);
            }
        } else if (TextUtils.equals(str, "mem")) {
            parama = (mobi.ifunny.studio.a.c.a) parama.b;
            if (!TextUtils.isEmpty(parama.a)) {
                return parama.a + "...";
            }
            if (!TextUtils.isEmpty(parama.c)) {
                return parama.c;
            }
        }
        return null;
    }

    private CharSequence c(String paramString) {
        Object localObject = paramString;
        int i;
        if (paramString.length() > 80) {
            localObject = paramString.toCharArray();
            i = localObject.length - 1;
        }
        while (i >= 0) {
            if ((localObject[i] == ' ') && (i < 80)) {
                localObject = paramString.substring(0, i) + "...";
                return (CharSequence) localObject;
            }
            i -= 1;
        }
        return paramString.substring(0, 80) + "...";
    }

    private void t() {
        Toast.makeText(this, 2131690092, 0).show();
    }

    public void a(l<mobi.ifunny.util.a.d> paraml, mobi.ifunny.util.a.d paramd) {
        if (paramd == null) {
            return;
        }
        this.s.setVisibility(4);
        this.o.setVisibility(0);
        this.o.setImageDrawable(new f(paramd));
    }

    protected void a(String paramString1, String paramString2, RestHttpHandler<TaskInfo, a> paramRestHttpHandler) {
        if ((v == null) || (w == null)) {
            t();
            finish();
        }
        Object localObject2 = v;
        Object localObject1;
        TypedByteArrayWithFilename localTypedByteArrayWithFilename;
        String str;
        try {
            localObject1 = aa.a(localObject2);
            localObject1 = new TypedByteArrayWithFilename("application/x-msgpack", (byte[]) localObject1);
            localTypedByteArrayWithFilename = new TypedByteArrayWithFilename("image/jpeg", w);
            str = ((mobi.ifunny.studio.a.a) localObject2).a.a;
            if (TextUtils.equals("caption", str)) {
                IFunnyRestRequest.Content.addCaption(this, paramString1, str, paramString2, localTypedByteArrayWithFilename, (TypedOutput) localObject1, ((mobi.ifunny.studio.a.a.a) ((mobi.ifunny.studio.a.a) localObject2).b).a, paramRestHttpHandler);
                return;
            }
        } catch (IOException paramString1) {
            t();
            return;
        }
        if (TextUtils.equals("mem", str)) {
            localObject2 = (mobi.ifunny.studio.a.c.a) ((mobi.ifunny.studio.a.a) localObject2).b;
            IFunnyRestRequest.Content.addMeme(this, paramString1, str, paramString2, localTypedByteArrayWithFilename, (TypedOutput) localObject1, ((mobi.ifunny.studio.a.c.a) localObject2).a, ((mobi.ifunny.studio.a.c.a) localObject2).c, ((mobi.ifunny.studio.a.c.a) localObject2).e, paramRestHttpHandler);
            return;
        }
        if (TextUtils.equals("comics", str)) {
            Object localObject3 = (mobi.ifunny.studio.a.b.a) ((mobi.ifunny.studio.a.a) localObject2).b;
            localObject2 = new StringBuilder();
            StringBuilder localStringBuilder = new StringBuilder();
            localObject3 = ((mobi.ifunny.studio.a.b.a) localObject3).b.iterator();
            while (((Iterator) localObject3).hasNext()) {
                Iterator localIterator = ((mobi.ifunny.studio.a.b.b) ((Iterator) localObject3).next()).b.iterator();
                while (localIterator.hasNext()) {
                    mobi.ifunny.studio.a.b.d locald = (mobi.ifunny.studio.a.b.d) localIterator.next();
                    if (locald.a == 2) {
                        ((StringBuilder) localObject2).append(((mobi.ifunny.studio.a.b.h) locald).e).append('\n');
                    }
                    if (locald.a == 3) {
                        localStringBuilder.append(((g) locald).e).append(',');
                    }
                }
            }
            IFunnyRestRequest.Content.addComics(this, paramString1, str, paramString2, localTypedByteArrayWithFilename, (TypedOutput) localObject1, ((StringBuilder) localObject2).toString(), localStringBuilder.toString(), paramRestHttpHandler);
            return;
        }
        t();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if ((v == null) || (w == null)) {
            finish();
            return;
        }
        this.y = getIntent().getStringExtra("arg.draft.id");
        this.t.setText(a(v));
        g().a(0, null, this);
    }

    public l<mobi.ifunny.util.a.d> onCreateLoader(int paramInt, Bundle paramBundle) {
        paramBundle = new mobi.ifunny.util.a.a(mobi.ifunny.util.h.a(this), false);
        return new mobi.ifunny.e.b(this, w, paramBundle);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131820564, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            v = null;
            w = null;
        }
    }

    public void onLoaderReset(l<mobi.ifunny.util.a.d> paraml) {
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        if (!e("task.save")) {
            paramMenuItem = "draft" + Math.abs(w.hashCode()) + ".jpg";
            new d(this, "task.save", w, paramMenuItem).execute(new Void[0]);
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/publish/PublishDraftActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */