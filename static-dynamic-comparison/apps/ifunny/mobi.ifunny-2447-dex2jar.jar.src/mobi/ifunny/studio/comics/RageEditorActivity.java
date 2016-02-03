package mobi.ifunny.studio.comics;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mobi.ifunny.d;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.studio.comics.a.c;
import mobi.ifunny.studio.publish.PublishDraftActivity;
import mobi.ifunny.util.aa;
import mobi.ifunny.util.l;
import mobi.ifunny.view.ScrollViewEx;

public class RageEditorActivity
        extends mobi.ifunny.l.a
        implements View.OnClickListener, View.OnLongClickListener {
    private static final String A = an.class.getSimpleName();
    public static mobi.ifunny.studio.a.a o;
    public static mobi.ifunny.studio.comics.a.a p;
    private static final String q = RageEditorActivity.class.getSimpleName();
    private static final String z = ao.class.getSimpleName();
    private String r;
    private mobi.ifunny.studio.a.b.a s;
    private ScrollViewEx t;
    private LinearLayout u;
    private int v;
    private MenuItem w;
    private int x = -1;
    private mobi.ifunny.studio.comics.a.a y;

    private void D() {
        int k = this.u.getChildCount();
        boolean bool1;
        int i;
        label30:
        Object localObject;
        boolean bool2;
        if ((this.s == null) || (this.s.a)) {
            bool1 = true;
            i = 0;
            if (i >= k) {
                return;
            }
            localObject = c(i);
            if (i != k - 1) {
                break label175;
            }
            bool2 = true;
            label52:
            a((View) localObject, bool1, bool2);
            if ((this.s != null) && (!((mobi.ifunny.studio.a.b.b) this.s.b.get(i)).a())) {
                break label181;
            }
            j = 0;
            label93:
            ((View) localObject).findViewById(2131493273).setVisibility(j);
            localObject = (TextView) ((View) localObject).findViewById(2131493274);
            ((TextView) localObject).setVisibility(j);
            if ((i == 0) && (j == 0)) {
                if ((this.s != null) && (this.s.b.size() != 1)) {
                    break label187;
                }
            }
        }
        label175:
        label181:
        label187:
        for (int j = 2131690016; ; j = 2131689999) {
            ((TextView) localObject).setText(j);
            i += 1;
            break label30;
            bool1 = false;
            break;
            bool2 = false;
            break label52;
            j = 8;
            break label93;
        }
    }

    private void E() {
        if (this.w != null) {
            if ((this.s == null) || (this.s.b())) {
                break label38;
            }
        }
        label38:
        for (boolean bool = true; ; bool = false) {
            this.w.setEnabled(bool);
            return;
        }
    }

    private Map<mobi.ifunny.studio.a.b.b, Bitmap> F() {
        HashMap localHashMap = new HashMap();
        List localList = this.s.b;
        int i = 0;
        if (i < localList.size()) {
            mobi.ifunny.studio.a.b.b localb = (mobi.ifunny.studio.a.b.b) localList.get(i);
            Drawable localDrawable = d(i).getDrawable();
            if (localDrawable == null) {
            }
            for (; ; ) {
                i += 1;
                break;
                if ((localDrawable instanceof BitmapDrawable)) {
                    localHashMap.put(localb, ((BitmapDrawable) localDrawable).getBitmap());
                }
            }
        }
        return localHashMap;
    }

    private void G() {
        Toast.makeText(this, 2131690015, 0).show();
    }

    private void H() {
        if (this.x == -1) {
        }
        do {
            return;
            int i = 1;
            try {
                mobi.ifunny.studio.a.b.b localb = aa.b(l.a(this, "comics.frame.msgpack"));
                boolean bool = a(this.x, localb);
                i = bool;
            } catch (IOException localIOException) {
                for (; ; ) {
                }
            }
        } while (i == 0);
        this.x = -1;
        l.c(this, "comics.frame.msgpack");
    }

    private void a(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener) {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setTitle(paramInt1);
        localBuilder.setMessage(paramInt2);
        localBuilder.setPositiveButton(2131689686, paramOnClickListener);
        localBuilder.setNegativeButton(2131689676, paramOnClickListener);
        localBuilder.create().show();
    }

    private void a(int paramInt, boolean paramBoolean) {
        ViewGroup localViewGroup = (ViewGroup) getLayoutInflater().inflate(2130903154, this.u, false);
        ((LinearLayout.LayoutParams) localViewGroup.getLayoutParams()).height = this.v;
        if (!paramBoolean) {
            localViewGroup.setOnClickListener(this);
            localViewGroup.setOnLongClickListener(this);
        }
        localViewGroup.findViewById(2131493276).setBackgroundDrawable(new mobi.ifunny.view.drawable.a());
        Drawable localDrawable = localViewGroup.findViewById(2131493275).getBackground();
        localDrawable.setAlpha(255);
        localDrawable.clearColorFilter();
        localDrawable.setDither(false);
        this.u.addView(localViewGroup);
    }

    private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2) {
        int i = 4;
        if (paramBoolean1) {
            paramView.findViewById(2131493275).setVisibility(0);
            paramView.findViewById(2131493276).setVisibility(4);
            return;
        }
        paramView.findViewById(2131493275).setVisibility(4);
        paramView = paramView.findViewById(2131493276);
        if (paramBoolean2) {
        }
        for (; ; ) {
            paramView.setVisibility(i);
            return;
            i = 0;
        }
    }

    private void a(mobi.ifunny.studio.a.b.a parama) {
        this.s = parama;
        this.u.removeAllViews();
        int j = this.s.b.size();
        int i = 0;
        while (i < j) {
            a(i, false);
            i += 1;
        }
    }

    private boolean a(int paramInt, mobi.ifunny.studio.a.b.b paramb) {
        if (this.s == null) {
        }
        while (this.s.b.size() <= paramInt) {
            return false;
        }
        d.c(q, "update frame at" + paramInt);
        this.s.b.set(paramInt, paramb);
        ao.a(this, this.s, paramInt);
        return true;
    }

    private int b(View paramView) {
        return this.u.indexOfChild(paramView);
    }

    private void b(int paramInt) {
        int i = this.s.b.size();
        if ((paramInt >= 0) && (paramInt < i)) {
            if (((mobi.ifunny.studio.a.b.b) this.s.b.get(paramInt)).a()) {
                b(paramInt, true);
                return;
            }
            a(2131690014, 2131689980, new ae(this, paramInt));
            return;
        }
        d.b(q, "Nothing to remove");
    }

    private void b(int paramInt, mobi.ifunny.studio.a.b.b paramb) {
        this.y.a(new c(paramb));
        a(paramInt, new mobi.ifunny.studio.a.b.b());
    }

    private void b(int paramInt, boolean paramBoolean) {
        this.s.b.remove(paramInt);
        this.u.removeViewAt(paramInt);
        if (paramBoolean) {
            ao.b(this, this.s);
        }
    }

    private View c(int paramInt) {
        return this.u.getChildAt(paramInt);
    }

    private void c(int paramInt, mobi.ifunny.studio.a.b.b paramb) {
        this.y.a(new c(paramb));
    }

    private ImageView d(int paramInt) {
        return (ImageView) c(paramInt).findViewById(2131493272);
    }

    private void d(int paramInt, mobi.ifunny.studio.a.b.b paramb) {
        a(paramInt, paramb);
    }

    private void e(int paramInt, mobi.ifunny.studio.a.b.b paramb) {
        a(2131689988, 2131689990, new ag(this, paramInt, paramb));
    }

    private void t() {
        this.s = new mobi.ifunny.studio.a.b.a();
        this.u.removeAllViews();
        v();
    }

    private void u() {
        a(2131689979, 2131689978, new ad(this));
    }

    private void v() {
        mobi.ifunny.studio.a.b.b localb = new mobi.ifunny.studio.a.b.b();
        this.s.b.add(localb);
        a(this.s.b.size() - 1, false);
        ao.b(this, this.s);
    }

    private void w() {
        List localList = this.s.b;
        while ((!localList.isEmpty()) && (((mobi.ifunny.studio.a.b.b) localList.get(0)).a())) {
            b(0, false);
        }
        while (!localList.isEmpty()) {
            int i = localList.size() - 1;
            if (!((mobi.ifunny.studio.a.b.b) localList.get(i)).a()) {
                break;
            }
            b(i, false);
        }
    }

    protected void a() {
        super.a();
        this.r = getIntent().getStringExtra("intent.draft.id");
        if (o == null) {
            mobi.ifunny.h localh = mobi.ifunny.h.a();
            if (localh.a("pref.rage_editor_autoload_failed", false)) {
                p();
                return;
            }
            localh.b("pref.rage_editor_autoload_failed", true);
            ao.a(this);
            return;
        }
        if (TextUtils.equals(o.a.a, "comics")) {
            ao.a(this, (mobi.ifunny.studio.a.b.a) o.b);
            o = null;
            return;
        }
        finish();
    }

    protected void a(ap paramap) {
        switch (ah.b[paramap.ordinal()]) {
            default:
                return;
            case 1:
                t();
                return;
        }
        finish();
    }

    protected void a(ap paramap, Throwable paramThrowable) {
        d.c(q, "rageLoaderOnFailure", paramThrowable);
        switch (ah.b[paramap.ordinal()]) {
            default:
                return;
            case 1:
                t();
                return;
        }
        finish();
    }

    protected void a(ap paramap, mobi.ifunny.studio.a.b.a parama, SparseArray<Bitmap> paramSparseArray, IFunny paramIFunny) {
        switch (ah.b[paramap.ordinal()]) {
        }
        while (paramSparseArray != null) {
            int i = 0;
            for (; ; ) {
                if (i < paramSparseArray.size()) {
                    int j = paramSparseArray.keyAt(i);
                    paramap = (Bitmap) paramSparseArray.valueAt(i);
                    d.b(q, "Update bitmap for frame " + j);
                    d(j).setImageBitmap(paramap);
                    i += 1;
                    continue;
                    a(parama);
                    H();
                    break;
                    if (paramIFunny == null) {
                        d.e(q, z + " CLEAN uploaded content is null");
                    }
                    finish();
                    return;
                }
            }
        }
        D();
        E();
    }

    protected void a(byte[] paramArrayOfByte, mobi.ifunny.studio.a.a parama) {
        PublishDraftActivity.v = parama;
        PublishDraftActivity.w = paramArrayOfByte;
        paramArrayOfByte = new Intent(this, PublishDraftActivity.class);
        paramArrayOfByte.putExtra("arg.draft.id", this.r);
        startActivityForResult(paramArrayOfByte, 1);
    }

    protected void b(boolean paramBoolean) {
        if (this.s.a != paramBoolean) {
            this.s.a = paramBoolean;
            ao.b(this, this.s);
        }
    }

    protected void n() {
        q localq = f();
        if ((g) localq.a("dialog.progress") == null) {
            mobi.ifunny.fragment.h.a(this, new String[]{z, A, "task.content.add_update_comics"}).a(localq, "dialog.progress");
            localq.b();
        }
    }

    protected void o() {
        g localg = (g) f().a("dialog.progress");
        if (localg != null) {
            localg.a();
        }
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        switch (paramInt1) {
        }
        for (; ; ) {
            super.onActivityResult(paramInt1, paramInt2, paramIntent);
            return;
            if (paramInt2 == -1) {
                if (this.x == -1) {
                    d.e(q, "REQUEST_FRAME_EDITOR RESULT_OK but editIndex undefined");
                }
            } else {
                this.x = -1;
                continue;
                if (paramInt2 == -1) {
                    finish();
                }
            }
        }
    }

    public void onBackPressed() {
        p = null;
        super.onBackPressed();
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                this.x = b(paramView);
                if (this.x != -1) {
                    paramView = (mobi.ifunny.studio.a.b.b) this.s.b.get(this.x);
                }
                break;
        }
        try {
            l.a(this, "comics.frame.msgpack", aa.a(paramView));
            startActivityForResult(new Intent(this, FrameEditorActivity.class), 0);
            return;
        } catch (IOException paramView) {
        }
        if (this.s.b.size() < 10) {
            v();
            this.t.a(130);
            return;
        }
        G();
        return;
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903153);
        if (p == null) {
            p = new mobi.ifunny.studio.comics.a.a();
        }
        this.t = ((ScrollViewEx) findViewById(2131493269));
        this.u = ((LinearLayout) this.t.findViewById(2131493270));
        Display localDisplay = getWindowManager().getDefaultDisplay();
        Point localPoint;
        if (Build.VERSION.SDK_INT >= 13) {
            localPoint = new Point();
            localDisplay.getSize(localPoint);
        }
        for (int i = localPoint.x; ; i = localDisplay.getWidth()) {
            this.v = (i * 480 / 640);
            d.b(q, "Detected viewHeight " + this.v);
            a(0, true);
            D();
            if (paramBundle != null) {
                this.x = paramBundle.getInt("state.edit_tag");
            }
            this.y = new mobi.ifunny.studio.comics.a.a();
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131820565, paramMenu);
        this.w = paramMenu.findItem(2131493085);
        return super.onCreateOptionsMenu(paramMenu);
    }

    protected void onDestroy() {
        if (!isChangingConfigurations()) {
            l.c(getApplicationContext(), "comics.clipboard.msgpack");
            l.c(getApplicationContext(), "comics.frame.msgpack");
        }
        super.onDestroy();
    }

    public boolean onLongClick(View paramView) {
        int i = b(paramView);
        boolean bool;
        ArrayList localArrayList;
        int j;
        if (i >= 0) {
            paramView = (mobi.ifunny.studio.a.b.b) this.s.b.get(i);
            bool = paramView.a();
            localArrayList = new ArrayList();
            localObject = new ArrayList();
            if (this.s.b.size() > 1) {
                localArrayList.add(am.a);
                ((ArrayList) localObject).add(getString(2131689987));
            }
            if (!bool) {
                localArrayList.add(am.b);
                ((ArrayList) localObject).add(getString(2131689983));
                localArrayList.add(am.c);
                ((ArrayList) localObject).add(getString(2131689982));
            }
            if ((this.y.b()) && ((this.y.a() instanceof c))) {
                localArrayList.add(am.d);
                ((ArrayList) localObject).add(getString(2131689988));
            }
            j = ((ArrayList) localObject).size();
            if (j != 0) {
            }
        } else {
            return false;
        }
        CharSequence[] arrayOfCharSequence = new CharSequence[j];
        ((ArrayList) localObject).toArray(arrayOfCharSequence);
        Object localObject = new AlertDialog.Builder(this);
        ((AlertDialog.Builder) localObject).setItems(arrayOfCharSequence, new af(this, localArrayList, i, paramView, bool));
        ((AlertDialog.Builder) localObject).create().show();
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
            case 2131493389:
                u();
                return true;
            case 2131493408:
                if ((this.s == null) || (this.s.a())) {
                    Toast.makeText(this, 2131690010, 0).show();
                    return true;
                }
                q();
                return true;
        }
        if ((this.s == null) || (this.s.a())) {
            Toast.makeText(this, 2131690010, 0).show();
            return true;
        }
        if (this.s.b()) {
            Toast.makeText(this, 2131690011, 0).show();
            return true;
        }
        w();
        paramMenuItem = F();
        new an(this, A, this.s, paramMenuItem).execute(new Void[0]);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu paramMenu) {
        E();
        return super.onPrepareOptionsMenu(paramMenu);
    }

    protected void onRestoreInstanceState(Bundle paramBundle) {
        super.onRestoreInstanceState(paramBundle);
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putInt("state.edit_tag", this.x);
    }

    protected void p() {
        q localq = f();
        if ((g) localq.a("dialog.autoload") == null) {
            new ai().a(localq, "dialog.autoload");
        }
    }

    protected void q() {
        q localq = f();
        if ((g) localq.a("dialog.border") == null) {
            new ak().a(localq, "dialog.border");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/RageEditorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */