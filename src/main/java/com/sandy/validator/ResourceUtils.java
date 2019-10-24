package com.sandy.validator;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;

import java.io.IOException;

public class ResourceUtils {
    private static final String PKGBASE;

    static {
        final String pkgName = ResourceUtils.class.getPackage().getName();
        PKGBASE = '/' + pkgName.replace(".", "/");
    }

    private ResourceUtils()
    {
    }

    /**
     * Load one resource from the current package as a {@link JsonNode}
     *
     * @param name name of the resource (<b>MUST</b> start with {@code /}
     * @return a JSON document
     * @throws IOException resource not found
     */
    public static JsonNode loadResource(final String name)
            throws IOException
    {
        return JsonLoader.fromResource(PKGBASE + name);
    }
}

