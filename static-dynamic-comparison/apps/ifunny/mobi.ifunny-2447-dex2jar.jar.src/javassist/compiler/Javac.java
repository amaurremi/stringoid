package javassist.compiler;

import javassist.CannotCompileException;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMember;
import javassist.CtMethod;
import javassist.CtPrimitiveType;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.Declarator;
import javassist.compiler.ast.FieldDecl;
import javassist.compiler.ast.MethodDecl;
import javassist.compiler.ast.Stmnt;
import javassist.compiler.ast.Symbol;

public class Javac {
    public static final String param0Name = "$0";
    public static final String proceedName = "$proceed";
    public static final String resultVarName = "$_";
    private Bytecode bytecode;
    JvstCodeGen gen;
    SymbolTable stable;

    public Javac(CtClass paramCtClass) {
        this(new Bytecode(paramCtClass.getClassFile2().getConstPool(), 0, 0), paramCtClass);
    }

    public Javac(Bytecode paramBytecode, CtClass paramCtClass) {
        this.gen = new JvstCodeGen(paramBytecode, paramCtClass, paramCtClass.getClassPool());
        this.stable = new SymbolTable();
        this.bytecode = paramBytecode;
    }

    private CtField compileField(FieldDecl paramFieldDecl) {
        Object localObject = paramFieldDecl.getDeclarator();
        localObject = new Javac.CtFieldWithInit(this.gen.resolver.lookupClass((Declarator) localObject), ((Declarator) localObject).getVariable().get(), this.gen.getThisClass());
        ((Javac.CtFieldWithInit) localObject).setModifiers(MemberResolver.getModifiers(paramFieldDecl.getModifiers()));
        if (paramFieldDecl.getInit() != null) {
            ((Javac.CtFieldWithInit) localObject).setInit(paramFieldDecl.getInit());
        }
        return (CtField) localObject;
    }

    private CtBehavior compileMethod(Parser paramParser, MethodDecl paramMethodDecl) {
        int i = MemberResolver.getModifiers(paramMethodDecl.getModifiers());
        CtClass[] arrayOfCtClass2 = this.gen.makeParamList(paramMethodDecl);
        CtClass[] arrayOfCtClass1 = this.gen.makeThrowsList(paramMethodDecl);
        recordParams(arrayOfCtClass2, Modifier.isStatic(i));
        paramParser = paramParser.parseMethod2(this.stable, paramMethodDecl);
        for (; ; ) {
            try {
                if (paramParser.isConstructor()) {
                    paramMethodDecl = new CtConstructor(arrayOfCtClass2, this.gen.getThisClass());
                    paramMethodDecl.setModifiers(i);
                    paramParser.accept(this.gen);
                    paramMethodDecl.getMethodInfo().setCodeAttribute(this.bytecode.toCodeAttribute());
                    paramMethodDecl.setExceptionTypes(arrayOfCtClass1);
                    return paramMethodDecl;
                }
                paramMethodDecl = paramParser.getReturn();
                CtClass localCtClass = this.gen.resolver.lookupClass(paramMethodDecl);
                recordReturnType(localCtClass, false);
                paramMethodDecl = new CtMethod(localCtClass, paramMethodDecl.getVariable().get(), arrayOfCtClass2, this.gen.getThisClass());
                paramMethodDecl.setModifiers(i);
                this.gen.setThisMethod(paramMethodDecl);
                paramParser.accept(this.gen);
                if (paramParser.getBody() != null) {
                    paramMethodDecl.getMethodInfo().setCodeAttribute(this.bytecode.toCodeAttribute());
                    paramMethodDecl.setExceptionTypes(arrayOfCtClass1);
                    return paramMethodDecl;
                }
            } catch (NotFoundException paramParser) {
                throw new CompileError(paramParser.toString());
            }
            paramMethodDecl.setModifiers(i | 0x400);
        }
    }

    private static void makeDefaultBody(Bytecode paramBytecode, CtClass paramCtClass) {
        int j;
        int i;
        if ((paramCtClass instanceof CtPrimitiveType)) {
            j = ((CtPrimitiveType) paramCtClass).getReturnOp();
            if (j == 175) {
                i = 14;
            }
        }
        for (; ; ) {
            if (i != 0) {
                paramBytecode.addOpcode(i);
            }
            paramBytecode.addOpcode(j);
            return;
            if (j == 174) {
                i = 11;
            } else if (j == 173) {
                i = 9;
            } else if (j == 177) {
                i = 0;
            } else {
                i = 3;
                continue;
                j = 176;
                i = 1;
            }
        }
    }

    public static ASTree parseExpr(String paramString, SymbolTable paramSymbolTable) {
        return new Parser(new Lex(paramString)).parseExpression(paramSymbolTable);
    }

    public CtMember compile(String paramString) {
        paramString = new Parser(new Lex(paramString));
        Object localObject = paramString.parseMember1(this.stable);
        try {
            if ((localObject instanceof FieldDecl)) {
                return compileField((FieldDecl) localObject);
            }
            paramString = compileMethod(paramString, (MethodDecl) localObject);
            localObject = paramString.getDeclaringClass();
            paramString.getMethodInfo2().rebuildStackMapIf6(((CtClass) localObject).getClassPool(), ((CtClass) localObject).getClassFile2());
            return paramString;
        } catch (BadBytecode paramString) {
            throw new CompileError(paramString.getMessage());
        } catch (CannotCompileException paramString) {
            throw new CompileError(paramString.getMessage());
        }
    }

    public Bytecode compileBody(CtBehavior paramCtBehavior, String paramString) {
        for (; ; ) {
            Object localObject;
            try {
                int i = paramCtBehavior.getModifiers();
                recordParams(paramCtBehavior.getParameterTypes(), Modifier.isStatic(i));
                if ((paramCtBehavior instanceof CtMethod)) {
                    this.gen.setThisMethod((CtMethod) paramCtBehavior);
                    localObject = ((CtMethod) paramCtBehavior).getReturnType();
                    recordReturnType((CtClass) localObject, false);
                    if (localObject != CtClass.voidType) {
                        break label202;
                    }
                    bool2 = true;
                    if (paramString == null) {
                        makeDefaultBody(this.bytecode, (CtClass) localObject);
                        return this.bytecode;
                    }
                } else {
                    localObject = CtClass.voidType;
                    continue;
                }
                paramString = new Parser(new Lex(paramString));
                localObject = paramString.parseStatement(new SymbolTable(this.stable));
                if (paramString.hasMore()) {
                    throw new CompileError("the method/constructor body must be surrounded by {}");
                }
            } catch (NotFoundException paramCtBehavior) {
                throw new CompileError(paramCtBehavior.toString());
            }
            boolean bool1;
            if ((paramCtBehavior instanceof CtConstructor)) {
                if (!((CtConstructor) paramCtBehavior).isClassInitializer()) {
                    bool1 = true;
                }
            }
            for (; ; ) {
                this.gen.atMethodBody((Stmnt) localObject, bool1, bool2);
                break;
                bool1 = false;
                continue;
                bool1 = false;
            }
            label202:
            boolean bool2 = false;
        }
    }

    public void compileExpr(String paramString) {
        compileExpr(parseExpr(paramString, this.stable));
    }

    public void compileExpr(ASTree paramASTree) {
        if (paramASTree != null) {
            this.gen.compileExpr(paramASTree);
        }
    }

    public void compileStmnt(String paramString) {
        paramString = new Parser(new Lex(paramString));
        SymbolTable localSymbolTable = new SymbolTable(this.stable);
        while (paramString.hasMore()) {
            Stmnt localStmnt = paramString.parseStatement(localSymbolTable);
            if (localStmnt != null) {
                localStmnt.accept(this.gen);
            }
        }
    }

    public Bytecode getBytecode() {
        return this.bytecode;
    }

    public boolean recordLocalVariables(CodeAttribute paramCodeAttribute, int paramInt) {
        int i = 0;
        paramCodeAttribute = (LocalVariableAttribute) paramCodeAttribute.getAttribute("LocalVariableTable");
        if (paramCodeAttribute == null) {
            return false;
        }
        int j = paramCodeAttribute.tableLength();
        while (i < j) {
            int k = paramCodeAttribute.startPc(i);
            int m = paramCodeAttribute.codeLength(i);
            if ((k <= paramInt) && (paramInt < k + m)) {
                this.gen.recordVariable(paramCodeAttribute.descriptor(i), paramCodeAttribute.variableName(i), paramCodeAttribute.index(i), this.stable);
            }
            i += 1;
        }
        return true;
    }

    public boolean recordParamNames(CodeAttribute paramCodeAttribute, int paramInt) {
        int i = 0;
        paramCodeAttribute = (LocalVariableAttribute) paramCodeAttribute.getAttribute("LocalVariableTable");
        if (paramCodeAttribute == null) {
            return false;
        }
        int j = paramCodeAttribute.tableLength();
        while (i < j) {
            int k = paramCodeAttribute.index(i);
            if (k < paramInt) {
                this.gen.recordVariable(paramCodeAttribute.descriptor(i), paramCodeAttribute.variableName(i), k, this.stable);
            }
            i += 1;
        }
        return true;
    }

    public int recordParams(String paramString, CtClass[] paramArrayOfCtClass, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
        return this.gen.recordParams(paramArrayOfCtClass, paramBoolean2, "$", "$args", "$$", paramBoolean1, paramInt, paramString, this.stable);
    }

    public int recordParams(CtClass[] paramArrayOfCtClass, boolean paramBoolean) {
        return this.gen.recordParams(paramArrayOfCtClass, paramBoolean, "$", "$args", "$$", this.stable);
    }

    public void recordProceed(String paramString1, String paramString2) {
        paramString1 = new Javac .1 (this, paramString2, new Parser(new Lex(paramString1)).parseExpression(this.stable))
        ;
        this.gen.setProceedHandler(paramString1, "$proceed");
    }

    public void recordProceed(ProceedHandler paramProceedHandler) {
        this.gen.setProceedHandler(paramProceedHandler, "$proceed");
    }

    public int recordReturnType(CtClass paramCtClass, boolean paramBoolean) {
        this.gen.recordType(paramCtClass);
        JvstCodeGen localJvstCodeGen = this.gen;
        if (paramBoolean) {
        }
        for (String str = "$_"; ; str = null) {
            return localJvstCodeGen.recordReturnType(paramCtClass, "$r", str, this.stable);
        }
    }

    public void recordSpecialProceed(String paramString1, String paramString2, String paramString3, String paramString4) {
        paramString1 = new Javac .3
        (this, new Parser(new Lex(paramString1)).parseExpression(this.stable), paramString2, paramString3, paramString4)
        ;
        this.gen.setProceedHandler(paramString1, "$proceed");
    }

    public void recordStaticProceed(String paramString1, String paramString2) {
        paramString1 = new Javac .2 (this, paramString1, paramString2);
        this.gen.setProceedHandler(paramString1, "$proceed");
    }

    public void recordType(CtClass paramCtClass) {
        this.gen.recordType(paramCtClass);
    }

    public int recordVariable(CtClass paramCtClass, String paramString) {
        return this.gen.recordVariable(paramCtClass, paramString, this.stable);
    }

    public void setMaxLocals(int paramInt) {
        this.gen.setMaxLocals(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/Javac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */