package rl.lexer;

import rl.lexer.recognizer.*;

import java.util.Arrays;

public class RecognizerRegistry {
    public static Recognizer[] recognizers = new Recognizer[0];

    static {
        loadRecognizers();
    }

    static private void loadRecognizers() {
        register(new NumberRecognizer());
        register(new VarRecognizer());
        register(new IDRecognizer());
        register(new CloseBraceRecognizer());
        register(new CloseBracketRecognizer());
        register(new CloseParenthesesRecognizer());
        register(new ColonRecognizer());
        register(new CommaRecognizer());
        register(new OpenBraceRecognizer());
        register(new OpenBracketRecognizer());
        register(new OpenParenthesesRecognizer());
        register(new OperationRecognizer());
        register(new PeriodRecognizer());
        register(new SemicolonRecognizer());
        register(new AssignRecognizer());
    }

    static protected void register(Recognizer recognizer) {
        recognizers = Arrays.copyOf(recognizers, recognizers.length + 1);
        recognizers[recognizers.length - 1] = recognizer;
    }

    static public Recognizer[] getRecognizers() {
        return recognizers;
    }
}
