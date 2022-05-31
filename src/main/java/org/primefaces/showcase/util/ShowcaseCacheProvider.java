/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.primefaces.showcase.util;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import org.primefaces.cache.CacheProvider;
import org.primefaces.cache.EHCache3Provider;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class ShowcaseCacheProvider {
    private CacheProvider cacheProvider;

    @PostConstruct
    public void init() {
        cacheProvider = new EHCache3Provider();
    }

    public CacheProvider getCacheProvider() {
        return cacheProvider;
    }
}
