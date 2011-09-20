/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule;

import org.mule.util.IOUtils;
import org.mule.util.PropertiesUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceComponent
{
    public String getResource(Object ignoredPayload) throws IOException
    {
        String httpPort = httpServerPortFromProperties();
        String template = loadFormTemplate();
        return template.replaceAll("@@http.server.port@@", httpPort);
    }

    private String httpServerPortFromProperties() throws IOException
    {
        Properties properties = PropertiesUtils.loadProperties("marketing-machine.properties", getClass());
        return properties.getProperty("http.server.port");
    }

    private String loadFormTemplate()
    {
        InputStream input = getClass().getClassLoader().getResourceAsStream("form.html");
        return IOUtils.toString(input);
    }
}
