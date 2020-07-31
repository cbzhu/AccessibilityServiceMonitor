package com.fadi.forestautoget.service;

import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;

import com.fadi.forestautoget.util.Config;

import java.util.List;

public class CebbankAppMonitor  {

    public static void policy(AccessibilityNodeInfo nodeInfo, String packageName, String className) {
        // 抢单界面
        keepAppPraise(nodeInfo);
    }

    public static void keepAppPraise(AccessibilityNodeInfo nodeInfo) {
        if (nodeInfo != null) {
            List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByText("全部");

            if (list == null) {
                Log.d(Config.TAG, "enterForestUI finding no");
                return;
            } else {
                Log.d(Config.TAG, "enterForestUI finding yes");
            }

            for (AccessibilityNodeInfo item : list) {
                AccessibilityNodeInfo parent = item.getParent();
                if (null != parent && parent.isClickable()) {
                    parent.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                    Log.d(Config.TAG, "item = " + item.toString() + ", parent click = " + parent.toString());
                    break;
                }
            }
        }
    }
}
