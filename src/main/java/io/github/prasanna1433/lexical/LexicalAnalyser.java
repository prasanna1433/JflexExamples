package io.github.prasanna1433.lexical;

import io.github.prasanna1433.grammar.*;
import java.io.*;

public class LexicalAnalyser {
    public static void main(String[] argv) {
        String dirName = null;
        try {
            for (int i = 0; i < argv.length; i++) {
                if (argv[i].equals("-dir")) {
                    i++;
                    if (i >= argv.length)
                        throw new Error("Missing directory name");
                    dirName = argv[i];
                } else {
                    throw new Error(
                            "Usage: java LexicalAnalyser -dir directory");
                }
            }
            if (dirName == null)
                throw new Error("Directory not specified");
            FileInputStream fileInputStream = new FileInputStream(
                    new File(dirName, "simple.html"));
            Reader reader = new InputStreamReader(fileInputStream, "UTF8");

            Sentence lexer = new Sentence(reader);
            lexer.yylex();
        } catch (Exception exception) {
            System.err.println("Exception in Main " + exception.toString());
            exception.printStackTrace();
        }
    }
}
