package com.aplicaciones13.factory;

import com.aplicaciones13.tools.Bundles;

/**
 *
 * @author omargo33@hotmail.com
 * @created 2022-07-05
 */
public class BundleFactory {
    /**
     *
     * @param bundlePath
     * @return
     */
    public static Bundles createBundle(String bundlePath) {
        Bundles bundles = new Bundles();
        bundles.setBundle(bundlePath);
        return bundles;
    }
}