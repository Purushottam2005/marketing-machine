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

import java.io.InputStream;

public class ResourceComponent
{
    public InputStream getResource(Object ignoredPayload)
    {
        return getClass().getClassLoader().getResourceAsStream("form.html");
    }
}
