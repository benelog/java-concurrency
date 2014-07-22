/*
 * @(#)StopThread.java $version 2011. 11. 16.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ej2.item66.broken;

import java.util.concurrent.TimeUnit;

/**
 * @author benelog
 */
public class StopThread {
    private static Boolean stopRequested = Boolean.FALSE;

    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (stopRequested.equals(Boolean.FALSE))
                    i++;
            }
            
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = Boolean.TRUE;
    }
}