package com.chenkang.decheng.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.tuckey.web.filters.urlrewrite.Conf;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import java.io.IOException;


public class UrlRewriteFilterConfig extends UrlRewriteFilter {

    private static final String URL_REWRITE = "classpath:/urlrewrite.xml";

    // Inject the Resource from the given location
    @Value(URL_REWRITE)
    private Resource resource;

    // Override the loadUrlRewriter method, and write your own implementation
    protected void loadUrlRewriter(FilterConfig filterConfig) throws ServletException {
        try {
            // Create a UrlRewrite Conf object with the injected resource
            Conf conf = new Conf(filterConfig.getServletContext(), resource.getInputStream(), resource.getFilename(),
                    "@@traceability@@");
            checkConf(conf);
        } catch (IOException ex) {
            throw new ServletException("Unable to load URL rewrite configuration file from " + URL_REWRITE, ex);
        }
    }
}