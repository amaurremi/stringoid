package mobi.ifunny.comments;

import mobi.ifunny.rest.content.Comment;

public class i {
    private boolean a;
    private boolean b;
    private boolean c;
    private int d;
    private int e;

    public i(Comment paramComment, boolean paramBoolean) {
        this.a = paramComment.is_smiled;
        this.b = paramComment.is_unsmiled;
        this.d = paramComment.num_smiles;
        this.e = paramComment.num_unsmiles;
        this.c = paramBoolean;
    }

    private void e(Comment paramComment) {
        paramComment.num_smiles += 1;
        paramComment.is_smiled = true;
        if (this.b) {
            paramComment.num_unsmiles -= 1;
            paramComment.is_unsmiled = false;
        }
    }

    private void f(Comment paramComment) {
        paramComment.num_smiles = this.d;
        if (this.b) {
            paramComment.num_unsmiles = this.e;
        }
        paramComment.is_smiled = true;
        paramComment.is_unsmiled = false;
    }

    private void g(Comment paramComment) {
        paramComment.num_smiles -= 1;
        paramComment.is_smiled = false;
    }

    private void h(Comment paramComment) {
        paramComment.is_smiled = false;
        paramComment.num_smiles = this.d;
    }

    private void i(Comment paramComment) {
        paramComment.num_unsmiles += 1;
        paramComment.is_unsmiled = true;
        if (this.a) {
            paramComment.num_smiles -= 1;
            paramComment.is_smiled = false;
        }
    }

    private void j(Comment paramComment) {
        paramComment.num_unsmiles = this.e;
        if (this.a) {
            paramComment.num_smiles = this.d;
        }
        paramComment.is_smiled = false;
        paramComment.is_unsmiled = true;
    }

    private void k(Comment paramComment) {
        paramComment.num_unsmiles -= 1;
        paramComment.is_unsmiled = false;
    }

    private void l(Comment paramComment) {
        paramComment.is_unsmiled = false;
        paramComment.num_unsmiles = this.e;
    }

    public void a(Comment paramComment) {
        if (this.c) {
            e(paramComment);
            return;
        }
        g(paramComment);
    }

    public void b(Comment paramComment) {
        if (this.c) {
            f(paramComment);
            return;
        }
        h(paramComment);
    }

    public void c(Comment paramComment) {
        if (this.c) {
            i(paramComment);
            return;
        }
        k(paramComment);
    }

    public void d(Comment paramComment) {
        if (this.c) {
            j(paramComment);
            return;
        }
        l(paramComment);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */