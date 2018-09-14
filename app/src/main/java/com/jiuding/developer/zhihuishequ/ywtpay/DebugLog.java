package com.jiuding.developer.zhihuishequ.ywtpay;

import android.text.TextUtils;
import android.util.Log;

import com.jiuding.developer.zhihuishequ.BuildConfig;

/**
 * Created by macbookair on 2017/10/19.
 */

public class DebugLog {

    static String className;
    static String methodName;
    static int lineNumber;

    private DebugLog() {
		/* Protect from instantiations */
    }

    public static boolean isDebuggable() {
        return BuildConfig.DEBUG;
    }

    private static String createLog(String log) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        buffer.append(methodName);
        buffer.append(":");
        buffer.append(lineNumber);
        buffer.append("]");
        buffer.append(log);

        return buffer.toString();
    }

    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    public static void e(String message) {
        if (!isDebuggable())
            return;

        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        Log.e(className, createLog(message));
//		BuglyUtils.e(message);
    }

    public static void i(String message) {
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.i(className, createLog(message));
    }

    public static void d(String message) {
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.d(className, createLog(message));
    }

    public static void v(String message) {
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.v(className, createLog(message));
    }

    public static void w(String message) {
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.w(className, createLog(message));
    }

    public static void wtf(String message) {
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.wtf(className, createLog(message));
    }

    public static void subJsonLog(String json) {
        if(TextUtils.isEmpty(json)){
            return;
        }
        int maxLogSize = 4000;
        int length = json.length();
        DebugLog.e("length:" + length);
        for (int i = 0; i <= length / maxLogSize; i++) {
            int start = i * maxLogSize;
            int end = (i + 1) * maxLogSize;
            end = end > length ? length : end;
            String substring = json.substring(start, end);
            if (i == 0) {
                DebugLog.e(substring);
            } else {
                DebugLog.e("【拼接第" + i + "段#########】" + substring);
            }
        }
    }

}
