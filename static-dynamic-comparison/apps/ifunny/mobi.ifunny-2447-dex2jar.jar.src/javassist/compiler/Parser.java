package javassist.compiler;

import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.ArrayInit;
import javassist.compiler.ast.AssignExpr;
import javassist.compiler.ast.BinExpr;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.CastExpr;
import javassist.compiler.ast.CondExpr;
import javassist.compiler.ast.Declarator;
import javassist.compiler.ast.DoubleConst;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.FieldDecl;
import javassist.compiler.ast.InstanceOfExpr;
import javassist.compiler.ast.IntConst;
import javassist.compiler.ast.Keyword;
import javassist.compiler.ast.Member;
import javassist.compiler.ast.MethodDecl;
import javassist.compiler.ast.NewExpr;
import javassist.compiler.ast.Pair;
import javassist.compiler.ast.Stmnt;
import javassist.compiler.ast.StringL;
import javassist.compiler.ast.Symbol;
import javassist.compiler.ast.Variable;

public final class Parser
        implements TokenId {
    private static final int[] binaryOpPrecedence = {0, 0, 0, 0, 1, 6, 0, 0, 0, 1, 2, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0};
    private Lex lex;

    public Parser(Lex paramLex) {
        this.lex = paramLex;
    }

    private ASTree binaryExpr2(SymbolTable paramSymbolTable, ASTree paramASTree, int paramInt) {
        int i = this.lex.get();
        if (i == 323) {
            return parseInstanceOf(paramSymbolTable, paramASTree);
        }
        int j;
        for (ASTree localASTree = parseUnaryExpr(paramSymbolTable); ; localASTree = binaryExpr2(paramSymbolTable, localASTree, j)) {
            j = getOpPrecedence(this.lex.lookAhead());
            if ((j == 0) || (paramInt <= j)) {
                break;
            }
        }
        return BinExpr.makeBin(i, paramASTree, localASTree);
    }

    private int getOpPrecedence(int paramInt) {
        if ((33 <= paramInt) && (paramInt <= 63)) {
            return binaryOpPrecedence[(paramInt - 33)];
        }
        if (paramInt == 94) {
            return 7;
        }
        if (paramInt == 124) {
            return 8;
        }
        if (paramInt == 369) {
            return 9;
        }
        if (paramInt == 368) {
            return 10;
        }
        if ((paramInt == 358) || (paramInt == 350)) {
            return 5;
        }
        if ((paramInt == 357) || (paramInt == 359) || (paramInt == 323)) {
            return 4;
        }
        if ((paramInt == 364) || (paramInt == 366) || (paramInt == 370)) {
            return 3;
        }
        return 0;
    }

    private static boolean isAssignOp(int paramInt) {
        return (paramInt == 61) || (paramInt == 351) || (paramInt == 352) || (paramInt == 353) || (paramInt == 354) || (paramInt == 355) || (paramInt == 356) || (paramInt == 360) || (paramInt == 361) || (paramInt == 365) || (paramInt == 367) || (paramInt == 371);
    }

    private static boolean isBuiltinType(int paramInt) {
        return (paramInt == 301) || (paramInt == 303) || (paramInt == 306) || (paramInt == 334) || (paramInt == 324) || (paramInt == 326) || (paramInt == 317) || (paramInt == 312);
    }

    private boolean nextIsBuiltinCast() {
        int i = 2;
        Lex localLex;
        int j;
        do {
            localLex = this.lex;
            j = i + 1;
            if (localLex.lookAhead(i) != 91) {
                break;
            }
            localLex = this.lex;
            i = j + 1;
        } while (localLex.lookAhead(j) == 93);
        return false;
        if (this.lex.lookAhead(j - 1) == 41) {
        }
        for (boolean bool = true; ; bool = false) {
            return bool;
        }
    }

    private boolean nextIsClassCast() {
        int i = nextIsClassType(1);
        if (i < 0) {
        }
        do {
            do {
                return false;
            } while (this.lex.lookAhead(i) != 41);
            i = this.lex.lookAhead(i + 1);
        }
        while ((i != 40) && (i != 412) && (i != 406) && (i != 400) && (i != 339) && (i != 336) && (i != 328) && (i != 410) && (i != 411) && (i != 403) && (i != 402) && (i != 401) && (i != 405) && (i != 404));
        return true;
    }

    private int nextIsClassType(int paramInt) {
        Lex localLex;
        int i;
        do {
            localLex = this.lex;
            i = paramInt + 1;
            paramInt = i;
            if (localLex.lookAhead(i) != 46) {
                break;
            }
            localLex = this.lex;
            i += 1;
            paramInt = i;
        } while (localLex.lookAhead(i) == 400);
        return -1;
        do {
            localLex = this.lex;
            i = paramInt + 1;
            if (localLex.lookAhead(paramInt) != 91) {
                break;
            }
            localLex = this.lex;
            paramInt = i + 1;
        } while (localLex.lookAhead(i) == 93);
        return -1;
        return i - 1;
    }

    private ASTList parseArgumentList(SymbolTable paramSymbolTable) {
        if (this.lex.get() != 40) {
            throw new CompileError("( is missing", this.lex);
        }
        Object localObject = null;
        ASTList localASTList = null;
        if (this.lex.lookAhead() != 41) {
            for (; ; ) {
                localASTList = ASTList.append(localASTList, parseExpression(paramSymbolTable));
                localObject = localASTList;
                if (this.lex.lookAhead() != 44) {
                    break;
                }
                this.lex.get();
            }
        }
        if (this.lex.get() != 41) {
            throw new CompileError(") is missing", this.lex);
        }
        return (ASTList) localObject;
    }

    private int parseArrayDimension() {
        int i = 0;
        while (this.lex.lookAhead() == 91) {
            i += 1;
            this.lex.get();
            if (this.lex.get() != 93) {
                throw new CompileError("] is missing", this.lex);
            }
        }
        return i;
    }

    private ASTree parseArrayIndex(SymbolTable paramSymbolTable) {
        this.lex.get();
        if (this.lex.lookAhead() == 93) {
            this.lex.get();
            paramSymbolTable = null;
        }
        do {
            return paramSymbolTable;
            paramSymbolTable = parseExpression(paramSymbolTable);
        } while (this.lex.get() == 93);
        throw new CompileError("] is missing", this.lex);
    }

    private ArrayInit parseArrayInitializer(SymbolTable paramSymbolTable) {
        this.lex.get();
        ArrayInit localArrayInit = new ArrayInit(parseExpression(paramSymbolTable));
        while (this.lex.lookAhead() == 44) {
            this.lex.get();
            ASTList.append(localArrayInit, parseExpression(paramSymbolTable));
        }
        if (this.lex.get() != 125) {
            throw new SyntaxError(this.lex);
        }
        return localArrayInit;
    }

    private ASTList parseArraySize(SymbolTable paramSymbolTable) {
        for (ASTList localASTList = null; this.lex.lookAhead() == 91; localASTList = ASTList.append(localASTList, parseArrayIndex(paramSymbolTable))) {
        }
        return localASTList;
    }

    private ASTree parseBinaryExpr(SymbolTable paramSymbolTable) {
        int i;
        for (ASTree localASTree = parseUnaryExpr(paramSymbolTable); ; localASTree = binaryExpr2(paramSymbolTable, localASTree, i)) {
            i = getOpPrecedence(this.lex.lookAhead());
            if (i == 0) {
                return localASTree;
            }
        }
    }

    private Stmnt parseBlock(SymbolTable paramSymbolTable) {
        if (this.lex.get() != 123) {
            throw new SyntaxError(this.lex);
        }
        Object localObject = null;
        SymbolTable localSymbolTable = new SymbolTable(paramSymbolTable);
        paramSymbolTable = (SymbolTable) localObject;
        while (this.lex.lookAhead() != 125) {
            localObject = parseStatement(localSymbolTable);
            if (localObject != null) {
                paramSymbolTable = (Stmnt) ASTList.concat(paramSymbolTable, new Stmnt(66, (ASTree) localObject));
            }
        }
        this.lex.get();
        localObject = paramSymbolTable;
        if (paramSymbolTable == null) {
            localObject = new Stmnt(66);
        }
        return (Stmnt) localObject;
    }

    private Stmnt parseBreak(SymbolTable paramSymbolTable) {
        return parseContinue(paramSymbolTable);
    }

    private ASTree parseCast(SymbolTable paramSymbolTable) {
        int i = this.lex.lookAhead(1);
        if ((isBuiltinType(i)) && (nextIsBuiltinCast())) {
            this.lex.get();
            this.lex.get();
            int j = parseArrayDimension();
            if (this.lex.get() != 41) {
                throw new CompileError(") is missing", this.lex);
            }
            return new CastExpr(i, j, parseUnaryExpr(paramSymbolTable));
        }
        if ((i == 400) && (nextIsClassCast())) {
            this.lex.get();
            ASTList localASTList = parseClassType(paramSymbolTable);
            i = parseArrayDimension();
            if (this.lex.get() != 41) {
                throw new CompileError(") is missing", this.lex);
            }
            return new CastExpr(localASTList, i, parseUnaryExpr(paramSymbolTable));
        }
        return parsePostfix(paramSymbolTable);
    }

    private ASTList parseClassType(SymbolTable paramSymbolTable) {
        paramSymbolTable = null;
        for (; ; ) {
            if (this.lex.get() != 400) {
                throw new SyntaxError(this.lex);
            }
            paramSymbolTable = ASTList.append(paramSymbolTable, new Symbol(this.lex.getString()));
            if (this.lex.lookAhead() != 46) {
                break;
            }
            this.lex.get();
        }
        return paramSymbolTable;
    }

    private ASTree parseConditionalExpr(SymbolTable paramSymbolTable) {
        ASTree localASTree1 = parseBinaryExpr(paramSymbolTable);
        if (this.lex.lookAhead() == 63) {
            this.lex.get();
            ASTree localASTree2 = parseExpression(paramSymbolTable);
            if (this.lex.get() != 58) {
                throw new CompileError(": is missing", this.lex);
            }
            return new CondExpr(localASTree1, localASTree2, parseExpression(paramSymbolTable));
        }
        return localASTree1;
    }

    private Stmnt parseContinue(SymbolTable paramSymbolTable) {
        paramSymbolTable = new Stmnt(this.lex.get());
        int j = this.lex.get();
        int i = j;
        if (j == 400) {
            paramSymbolTable.setLeft(new Symbol(this.lex.getString()));
            i = this.lex.get();
        }
        if (i != 59) {
            throw new CompileError("; is missing", this.lex);
        }
        return paramSymbolTable;
    }

    private Stmnt parseDeclarationOrExpression(SymbolTable paramSymbolTable, boolean paramBoolean) {
        for (int i = this.lex.lookAhead(); i == 315; i = this.lex.lookAhead()) {
            this.lex.get();
        }
        if (isBuiltinType(i)) {
            paramSymbolTable = parseDeclarators(paramSymbolTable, new Declarator(this.lex.get(), parseArrayDimension()));
        }
        for (; ; ) {
            return paramSymbolTable;
            if (i == 400) {
                i = nextIsClassType(0);
                if ((i >= 0) && (this.lex.lookAhead(i) == 400)) {
                    return parseDeclarators(paramSymbolTable, new Declarator(parseClassType(paramSymbolTable), parseArrayDimension()));
                }
            }
            if (paramBoolean) {
            }
            for (paramSymbolTable = parseExprList(paramSymbolTable); this.lex.get() != 59; paramSymbolTable = new Stmnt(69, parseExpression(paramSymbolTable))) {
                throw new CompileError("; is missing", this.lex);
            }
        }
    }

    private Declarator parseDeclarator(SymbolTable paramSymbolTable, Declarator paramDeclarator) {
        if ((this.lex.get() != 400) || (paramDeclarator.getType() == 344)) {
            throw new SyntaxError(this.lex);
        }
        String str = this.lex.getString();
        Symbol localSymbol = new Symbol(str);
        int i = parseArrayDimension();
        ASTree localASTree = null;
        if (this.lex.lookAhead() == 61) {
            this.lex.get();
            localASTree = parseInitializer(paramSymbolTable);
        }
        paramDeclarator = paramDeclarator.make(localSymbol, i, localASTree);
        paramSymbolTable.append(str, paramDeclarator);
        return paramDeclarator;
    }

    private Stmnt parseDeclarators(SymbolTable paramSymbolTable, Declarator paramDeclarator) {
        Object localObject = null;
        int i;
        do {
            localObject = (Stmnt) ASTList.concat((ASTList) localObject, new Stmnt(68, parseDeclarator(paramSymbolTable, paramDeclarator)));
            i = this.lex.get();
            if (i == 59) {
                return (Stmnt) localObject;
            }
        } while (i == 44);
        throw new CompileError("; is missing", this.lex);
    }

    private Stmnt parseDo(SymbolTable paramSymbolTable) {
        int i = this.lex.get();
        Stmnt localStmnt = parseStatement(paramSymbolTable);
        if ((this.lex.get() != 346) || (this.lex.get() != 40)) {
            throw new SyntaxError(this.lex);
        }
        paramSymbolTable = parseExpression(paramSymbolTable);
        if ((this.lex.get() != 41) || (this.lex.get() != 59)) {
            throw new SyntaxError(this.lex);
        }
        return new Stmnt(i, paramSymbolTable, localStmnt);
    }

    private ASTree parseDotClass(int paramInt1, int paramInt2) {
        if (paramInt2 > 0) {
            return Expr.make(46, new Symbol(CodeGen.toJvmTypeName(paramInt1, paramInt2)), new Member("class"));
        }
        String str;
        switch (paramInt1) {
            default:
                throw new CompileError("invalid builtin type: " + paramInt1);
            case 301:
                str = "java.lang.Boolean";
        }
        for (; ; ) {
            return Expr.make(35, new Symbol(str), new Member("TYPE"));
            str = "java.lang.Byte";
            continue;
            str = "java.lang.Character";
            continue;
            str = "java.lang.Short";
            continue;
            str = "java.lang.Integer";
            continue;
            str = "java.lang.Long";
            continue;
            str = "java.lang.Float";
            continue;
            str = "java.lang.Double";
            continue;
            str = "java.lang.Void";
        }
    }

    private ASTree parseDotClass(ASTree paramASTree, int paramInt) {
        String str = toClassName(paramASTree);
        paramASTree = str;
        if (paramInt > 0) {
            paramASTree = new StringBuffer();
            while (paramInt > 0) {
                paramASTree.append('[');
                paramInt -= 1;
            }
            paramASTree.append('L').append(str.replace('.', '/')).append(';');
            paramASTree = paramASTree.toString();
        }
        return Expr.make(46, new Symbol(paramASTree), new Member("class"));
    }

    private Stmnt parseExprList(SymbolTable paramSymbolTable) {
        Object localObject = null;
        for (; ; ) {
            localObject = (Stmnt) ASTList.concat((ASTList) localObject, new Stmnt(66, new Stmnt(69, parseExpression(paramSymbolTable))));
            if (this.lex.lookAhead() != 44) {
                break;
            }
            this.lex.get();
        }
        return (Stmnt) localObject;
    }

    private FieldDecl parseField(SymbolTable paramSymbolTable, ASTList paramASTList, Declarator paramDeclarator) {
        ASTree localASTree = null;
        if (this.lex.lookAhead() == 61) {
            this.lex.get();
            localASTree = parseExpression(paramSymbolTable);
        }
        int i = this.lex.get();
        if (i == 59) {
            return new FieldDecl(paramASTList, new ASTList(paramDeclarator, new ASTList(localASTree)));
        }
        if (i == 44) {
            throw new CompileError("only one field can be declared in one declaration", this.lex);
        }
        throw new SyntaxError(this.lex);
    }

    private Stmnt parseFor(SymbolTable paramSymbolTable) {
        Stmnt localStmnt = null;
        int i = this.lex.get();
        SymbolTable localSymbolTable = new SymbolTable(paramSymbolTable);
        if (this.lex.get() != 40) {
            throw new SyntaxError(this.lex);
        }
        if (this.lex.lookAhead() == 59) {
            this.lex.get();
            paramSymbolTable = null;
            if (this.lex.lookAhead() != 59) {
                break label118;
            }
        }
        label118:
        for (ASTree localASTree = null; ; localASTree = parseExpression(localSymbolTable)) {
            if (this.lex.get() == 59) {
                break label128;
            }
            throw new CompileError("; is missing", this.lex);
            paramSymbolTable = parseDeclarationOrExpression(localSymbolTable, true);
            break;
        }
        label128:
        if (this.lex.lookAhead() == 41) {
        }
        while (this.lex.get() != 41) {
            throw new CompileError(") is missing", this.lex);
            localStmnt = parseExprList(localSymbolTable);
        }
        return new Stmnt(i, paramSymbolTable, new ASTList(localASTree, new ASTList(localStmnt, parseStatement(localSymbolTable))));
    }

    private Declarator parseFormalParam(SymbolTable paramSymbolTable) {
        Declarator localDeclarator = parseFormalType(paramSymbolTable);
        if (this.lex.get() != 400) {
            throw new SyntaxError(this.lex);
        }
        String str = this.lex.getString();
        localDeclarator.setVariable(new Symbol(str));
        localDeclarator.addArrayDim(parseArrayDimension());
        paramSymbolTable.append(str, localDeclarator);
        return localDeclarator;
    }

    private Declarator parseFormalType(SymbolTable paramSymbolTable) {
        int i = this.lex.lookAhead();
        if ((isBuiltinType(i)) || (i == 344)) {
            this.lex.get();
            return new Declarator(i, parseArrayDimension());
        }
        return new Declarator(parseClassType(paramSymbolTable), parseArrayDimension());
    }

    private Stmnt parseIf(SymbolTable paramSymbolTable) {
        int i = this.lex.get();
        ASTree localASTree = parseParExpression(paramSymbolTable);
        Stmnt localStmnt = parseStatement(paramSymbolTable);
        if (this.lex.lookAhead() == 313) {
            this.lex.get();
        }
        for (paramSymbolTable = parseStatement(paramSymbolTable); ; paramSymbolTable = null) {
            return new Stmnt(i, localASTree, new ASTList(localStmnt, new ASTList(paramSymbolTable)));
        }
    }

    private ASTree parseInitializer(SymbolTable paramSymbolTable) {
        if (this.lex.lookAhead() == 123) {
            return parseArrayInitializer(paramSymbolTable);
        }
        return parseExpression(paramSymbolTable);
    }

    private ASTree parseInstanceOf(SymbolTable paramSymbolTable, ASTree paramASTree) {
        int i = this.lex.lookAhead();
        if (isBuiltinType(i)) {
            this.lex.get();
            return new InstanceOfExpr(i, parseArrayDimension(), paramASTree);
        }
        return new InstanceOfExpr(parseClassType(paramSymbolTable), parseArrayDimension(), paramASTree);
    }

    private ASTList parseMemberMods() {
        for (ASTList localASTList = null; ; localASTList = new ASTList(new Keyword(this.lex.get()), localASTList)) {
            int i = this.lex.lookAhead();
            if ((i != 300) && (i != 315) && (i != 332) && (i != 331) && (i != 330) && (i != 338) && (i != 335) && (i != 345) && (i != 342) && (i != 347)) {
                break;
            }
        }
        return localASTList;
    }

    private MethodDecl parseMethod1(SymbolTable paramSymbolTable, boolean paramBoolean, ASTList paramASTList, Declarator paramDeclarator) {
        if (this.lex.get() != 40) {
            throw new SyntaxError(this.lex);
        }
        ASTList localASTList1;
        if (this.lex.lookAhead() != 41) {
            localObject = null;
            int i;
            do {
                for (; ; ) {
                    localASTList1 = ASTList.append((ASTList) localObject, parseFormalParam(paramSymbolTable));
                    i = this.lex.lookAhead();
                    if (i != 44) {
                        break;
                    }
                    this.lex.get();
                    localObject = localASTList1;
                }
                localObject = localASTList1;
            } while (i != 41);
        }
        for (Object localObject = localASTList1; ; localObject = null) {
            this.lex.get();
            paramDeclarator.addArrayDim(parseArrayDimension());
            if ((paramBoolean) && (paramDeclarator.getArrayDim() > 0)) {
                throw new SyntaxError(this.lex);
            }
            if (this.lex.lookAhead() == 341) {
                this.lex.get();
                localASTList1 = null;
                for (; ; ) {
                    localASTList1 = ASTList.append(localASTList1, parseClassType(paramSymbolTable));
                    localASTList2 = localASTList1;
                    if (this.lex.lookAhead() != 44) {
                        break;
                    }
                    this.lex.get();
                }
            }
            ASTList localASTList2 = null;
            return new MethodDecl(paramASTList, new ASTList(paramDeclarator, ASTList.make((ASTree) localObject, localASTList2, null)));
        }
    }

    private ASTree parseMethodCall(SymbolTable paramSymbolTable, ASTree paramASTree) {
        int i;
        if ((paramASTree instanceof Keyword)) {
            i = ((Keyword) paramASTree).get();
            if ((i != 339) && (i != 336)) {
                throw new SyntaxError(this.lex);
            }
        } else {
            if (!(paramASTree instanceof Symbol)) {
                break label58;
            }
        }
        label58:
        do {
            do {
                return CallExpr.makeCall(paramASTree, parseArgumentList(paramSymbolTable));
            } while (!(paramASTree instanceof Expr));
            i = ((Expr) paramASTree).getOperator();
        } while ((i == 46) || (i == 35));
        throw new SyntaxError(this.lex);
    }

    private NewExpr parseNew(SymbolTable paramSymbolTable) {
        Object localObject = null;
        ASTList localASTList1 = null;
        int i = this.lex.lookAhead();
        ASTList localASTList2;
        if (isBuiltinType(i)) {
            this.lex.get();
            localASTList2 = parseArraySize(paramSymbolTable);
            localObject = localASTList1;
            if (this.lex.lookAhead() == 123) {
                localObject = parseArrayInitializer(paramSymbolTable);
            }
            return new NewExpr(i, localASTList2, (ArrayInit) localObject);
        }
        if (i == 400) {
            localASTList1 = parseClassType(paramSymbolTable);
            i = this.lex.lookAhead();
            if (i == 40) {
                return new NewExpr(localASTList1, parseArgumentList(paramSymbolTable));
            }
            if (i == 91) {
                localASTList2 = parseArraySize(paramSymbolTable);
                if (this.lex.lookAhead() == 123) {
                    localObject = parseArrayInitializer(paramSymbolTable);
                }
                return NewExpr.makeObjectArray(localASTList1, localASTList2, (ArrayInit) localObject);
            }
        }
        throw new SyntaxError(this.lex);
    }

    private ASTree parseParExpression(SymbolTable paramSymbolTable) {
        if (this.lex.get() != 40) {
            throw new SyntaxError(this.lex);
        }
        paramSymbolTable = parseExpression(paramSymbolTable);
        if (this.lex.get() != 41) {
            throw new SyntaxError(this.lex);
        }
        return paramSymbolTable;
    }

    private ASTree parsePostfix(SymbolTable paramSymbolTable) {
        int i = this.lex.lookAhead();
        Object localObject1;
        switch (i) {
            default:
                localObject1 = parsePrimaryExpr(paramSymbolTable);
        }
        for (; ; ) {
            Object localObject2;
            switch (this.lex.lookAhead()) {
                default:
                    return (ASTree) localObject1;
                this.lex.get();
                return new IntConst(this.lex.getLong(), i);
                this.lex.get();
                return new DoubleConst(this.lex.getDouble(), i);
                case 40:
                    localObject1 = parseMethodCall(paramSymbolTable, (ASTree) localObject1);
                    break;
                case 91:
                    if (this.lex.lookAhead(1) == 93) {
                        i = parseArrayDimension();
                        if ((this.lex.get() != 46) || (this.lex.get() != 307)) {
                            throw new SyntaxError(this.lex);
                        }
                        localObject1 = parseDotClass((ASTree) localObject1, i);
                    } else {
                        localObject2 = parseArrayIndex(paramSymbolTable);
                        if (localObject2 == null) {
                            throw new SyntaxError(this.lex);
                        }
                        localObject1 = Expr.make(65, (ASTree) localObject1, (ASTree) localObject2);
                    }
                    break;
                case 362:
                case 363:
                    localObject1 = Expr.make(this.lex.get(), null, (ASTree) localObject1);
                    break;
                case 46:
                    this.lex.get();
                    i = this.lex.get();
                    if (i == 307) {
                        localObject1 = parseDotClass((ASTree) localObject1, 0);
                    } else if (i == 400) {
                        localObject1 = Expr.make(46, (ASTree) localObject1, new Member(this.lex.getString()));
                    } else {
                        throw new CompileError("missing member name", this.lex);
                    }
                    break;
                case 35:
                    this.lex.get();
                    if (this.lex.get() != 400) {
                        throw new CompileError("missing static member name", this.lex);
                    }
                    localObject2 = this.lex.getString();
                    localObject1 = Expr.make(35, new Symbol(toClassName((ASTree) localObject1)), new Member((String) localObject2));
            }
        }
    }

    private ASTree parsePrimaryExpr(SymbolTable paramSymbolTable) {
        int i = this.lex.get();
        switch (i) {
            default:
                if ((isBuiltinType(i)) || (i == 344)) {
                    int j = parseArrayDimension();
                    if ((this.lex.get() == 46) && (this.lex.get() == 307)) {
                        paramSymbolTable = parseDotClass(i, j);
                    }
                }
                break;
            case 336:
            case 339:
            case 410:
            case 411:
            case 412:
            case 400:
            case 406:
            case 328:
            case 40:
                do {
                    return paramSymbolTable;
                    return new Keyword(i);
                    String str = this.lex.getString();
                    paramSymbolTable = paramSymbolTable.lookup(str);
                    if (paramSymbolTable == null) {
                        return new Member(str);
                    }
                    return new Variable(str, paramSymbolTable);
                    return new StringL(this.lex.getString());
                    return parseNew(paramSymbolTable);
                    paramSymbolTable = parseExpression(paramSymbolTable);
                } while (this.lex.get() == 41);
                throw new CompileError(") is missing", this.lex);
        }
        throw new SyntaxError(this.lex);
    }

    private Stmnt parseReturn(SymbolTable paramSymbolTable) {
        Stmnt localStmnt = new Stmnt(this.lex.get());
        if (this.lex.lookAhead() != 59) {
            localStmnt.setLeft(parseExpression(paramSymbolTable));
        }
        if (this.lex.get() != 59) {
            throw new CompileError("; is missing", this.lex);
        }
        return localStmnt;
    }

    private Stmnt parseStmntOrCase(SymbolTable paramSymbolTable) {
        int i = this.lex.lookAhead();
        if ((i != 304) && (i != 310)) {
            paramSymbolTable = parseStatement(paramSymbolTable);
        }
        for (; ; ) {
            return paramSymbolTable;
            this.lex.get();
            if (i == 304) {
            }
            for (paramSymbolTable = new Stmnt(i, parseExpression(paramSymbolTable)); this.lex.get() != 58; paramSymbolTable = new Stmnt(310)) {
                throw new CompileError(": is missing", this.lex);
            }
        }
    }

    private Stmnt parseSwitch(SymbolTable paramSymbolTable) {
        return new Stmnt(this.lex.get(), parseParExpression(paramSymbolTable), parseSwitchBlock(paramSymbolTable));
    }

    private Stmnt parseSwitchBlock(SymbolTable paramSymbolTable) {
        if (this.lex.get() != 123) {
            throw new SyntaxError(this.lex);
        }
        SymbolTable localSymbolTable = new SymbolTable(paramSymbolTable);
        Object localObject = parseStmntOrCase(localSymbolTable);
        if (localObject == null) {
            throw new CompileError("empty switch block", this.lex);
        }
        int i = ((Stmnt) localObject).getOperator();
        if ((i != 304) && (i != 310)) {
            throw new CompileError("no case or default in a switch block", this.lex);
        }
        paramSymbolTable = new Stmnt(66, (ASTree) localObject);
        Stmnt localStmnt;
        if (this.lex.lookAhead() != 125) {
            localStmnt = parseStmntOrCase(localSymbolTable);
            if (localStmnt == null) {
                break label207;
            }
            i = localStmnt.getOperator();
            if ((i == 304) || (i == 310)) {
                paramSymbolTable = (Stmnt) ASTList.concat(paramSymbolTable, new Stmnt(66, localStmnt));
                localObject = localStmnt;
            }
        }
        label207:
        for (; ; ) {
            break;
            localObject = (Stmnt) ASTList.concat((ASTList) localObject, new Stmnt(66, localStmnt));
            continue;
            this.lex.get();
            return paramSymbolTable;
        }
    }

    private Stmnt parseSynchronized(SymbolTable paramSymbolTable) {
        int i = this.lex.get();
        if (this.lex.get() != 40) {
            throw new SyntaxError(this.lex);
        }
        ASTree localASTree = parseExpression(paramSymbolTable);
        if (this.lex.get() != 41) {
            throw new SyntaxError(this.lex);
        }
        return new Stmnt(i, localASTree, parseBlock(paramSymbolTable));
    }

    private Stmnt parseThrow(SymbolTable paramSymbolTable) {
        int i = this.lex.get();
        paramSymbolTable = parseExpression(paramSymbolTable);
        if (this.lex.get() != 59) {
            throw new CompileError("; is missing", this.lex);
        }
        return new Stmnt(i, paramSymbolTable);
    }

    private Stmnt parseTry(SymbolTable paramSymbolTable) {
        Stmnt localStmnt1 = null;
        this.lex.get();
        Stmnt localStmnt2 = parseBlock(paramSymbolTable);
        SymbolTable localSymbolTable;
        Declarator localDeclarator;
        for (ASTList localASTList = null; this.lex.lookAhead() == 305; localASTList = ASTList.append(localASTList, new Pair(localDeclarator, parseBlock(localSymbolTable)))) {
            this.lex.get();
            if (this.lex.get() != 40) {
                throw new SyntaxError(this.lex);
            }
            localSymbolTable = new SymbolTable(paramSymbolTable);
            localDeclarator = parseFormalParam(localSymbolTable);
            if ((localDeclarator.getArrayDim() > 0) || (localDeclarator.getType() != 307)) {
                throw new SyntaxError(this.lex);
            }
            if (this.lex.get() != 41) {
                throw new SyntaxError(this.lex);
            }
        }
        if (this.lex.lookAhead() == 316) {
            this.lex.get();
            localStmnt1 = parseBlock(paramSymbolTable);
        }
        return Stmnt.make(343, localStmnt2, localASTList, localStmnt1);
    }

    private ASTree parseUnaryExpr(SymbolTable paramSymbolTable) {
        switch (this.lex.lookAhead()) {
            default:
                return parsePostfix(paramSymbolTable);
            case 33:
            case 43:
            case 45:
            case 126:
            case 362:
            case 363:
                int i = this.lex.get();
                int j;
                if (i == 45) {
                    j = this.lex.lookAhead();
                }
                switch (j) {
                    default:
                        return Expr.make(i, parseUnaryExpr(paramSymbolTable));
                    case 401:
                    case 402:
                    case 403:
                        this.lex.get();
                        return new IntConst(-this.lex.getLong(), j);
                }
                this.lex.get();
                return new DoubleConst(-this.lex.getDouble(), j);
        }
        return parseCast(paramSymbolTable);
    }

    private Stmnt parseWhile(SymbolTable paramSymbolTable) {
        return new Stmnt(this.lex.get(), parseParExpression(paramSymbolTable), parseStatement(paramSymbolTable));
    }

    private String toClassName(ASTree paramASTree) {
        StringBuffer localStringBuffer = new StringBuffer();
        toClassName(paramASTree, localStringBuffer);
        return localStringBuffer.toString();
    }

    private void toClassName(ASTree paramASTree, StringBuffer paramStringBuffer) {
        if ((paramASTree instanceof Symbol)) {
            paramStringBuffer.append(((Symbol) paramASTree).get());
            return;
        }
        if ((paramASTree instanceof Expr)) {
            paramASTree = (Expr) paramASTree;
            if (paramASTree.getOperator() == 46) {
                toClassName(paramASTree.oprand1(), paramStringBuffer);
                paramStringBuffer.append('.');
                toClassName(paramASTree.oprand2(), paramStringBuffer);
                return;
            }
        }
        throw new CompileError("bad static member access", this.lex);
    }

    public boolean hasMore() {
        return this.lex.lookAhead() >= 0;
    }

    public ASTree parseExpression(SymbolTable paramSymbolTable) {
        ASTree localASTree = parseConditionalExpr(paramSymbolTable);
        if (!isAssignOp(this.lex.lookAhead())) {
            return localASTree;
        }
        return AssignExpr.makeAssign(this.lex.get(), localASTree, parseExpression(paramSymbolTable));
    }

    public ASTList parseMember(SymbolTable paramSymbolTable) {
        ASTList localASTList = parseMember1(paramSymbolTable);
        Object localObject = localASTList;
        if ((localASTList instanceof MethodDecl)) {
            localObject = parseMethod2(paramSymbolTable, (MethodDecl) localASTList);
        }
        return (ASTList) localObject;
    }

    public ASTList parseMember1(SymbolTable paramSymbolTable) {
        boolean bool = true;
        ASTList localASTList = parseMemberMods();
        Declarator localDeclarator;
        if ((this.lex.lookAhead() == 400) && (this.lex.lookAhead(1) == 40)) {
            localDeclarator = new Declarator(344, 0);
        }
        while (this.lex.get() != 400) {
            throw new SyntaxError(this.lex);
            localDeclarator = parseFormalType(paramSymbolTable);
            bool = false;
        }
        if (bool) {
        }
        for (String str = "<init>"; ; str = this.lex.getString()) {
            localDeclarator.setVariable(new Symbol(str));
            if ((!bool) && (this.lex.lookAhead() != 40)) {
                break;
            }
            return parseMethod1(paramSymbolTable, bool, localASTList, localDeclarator);
        }
        return parseField(paramSymbolTable, localASTList, localDeclarator);
    }

    public MethodDecl parseMethod2(SymbolTable paramSymbolTable, MethodDecl paramMethodDecl) {
        Stmnt localStmnt = null;
        if (this.lex.lookAhead() == 59) {
            this.lex.get();
            paramSymbolTable = localStmnt;
        }
        for (; ; ) {
            paramMethodDecl.sublist(4).setHead(paramSymbolTable);
            return paramMethodDecl;
            localStmnt = parseBlock(paramSymbolTable);
            paramSymbolTable = localStmnt;
            if (localStmnt == null) {
                paramSymbolTable = new Stmnt(66);
            }
        }
    }

    public Stmnt parseStatement(SymbolTable paramSymbolTable) {
        int i = this.lex.lookAhead();
        if (i == 123) {
            return parseBlock(paramSymbolTable);
        }
        if (i == 59) {
            this.lex.get();
            return new Stmnt(66);
        }
        if ((i == 400) && (this.lex.lookAhead(1) == 58)) {
            this.lex.get();
            String str = this.lex.getString();
            this.lex.get();
            return Stmnt.make(76, new Symbol(str), parseStatement(paramSymbolTable));
        }
        if (i == 320) {
            return parseIf(paramSymbolTable);
        }
        if (i == 346) {
            return parseWhile(paramSymbolTable);
        }
        if (i == 311) {
            return parseDo(paramSymbolTable);
        }
        if (i == 318) {
            return parseFor(paramSymbolTable);
        }
        if (i == 343) {
            return parseTry(paramSymbolTable);
        }
        if (i == 337) {
            return parseSwitch(paramSymbolTable);
        }
        if (i == 338) {
            return parseSynchronized(paramSymbolTable);
        }
        if (i == 333) {
            return parseReturn(paramSymbolTable);
        }
        if (i == 340) {
            return parseThrow(paramSymbolTable);
        }
        if (i == 302) {
            return parseBreak(paramSymbolTable);
        }
        if (i == 309) {
            return parseContinue(paramSymbolTable);
        }
        return parseDeclarationOrExpression(paramSymbolTable, false);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/Parser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */