package com.ratel.common.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.Executor;

public class ExceptionUtils {

    public static String errInfo(Exception ex) {
        try (StringWriter sw = new StringWriter()) {
            try (PrintWriter pw = new PrintWriter(sw)) {
                ex.printStackTrace(pw);
                pw.flush();
                sw.flush();
                return pw.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

}
