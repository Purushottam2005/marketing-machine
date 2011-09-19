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

import org.mule.tck.FunctionalTestCase;

public class VmToTwitterTestCase extends FunctionalTestCase
{
    @Override
    protected String getConfigResources()
    {
        return "mule-config.xml";
    }

    public void testStatusUpdate() throws Exception
    {
//        muleContext.getClient().dispatch("vm://in", "OMG I can even update my status via the twitter cloud connector", null);
        Thread.sleep(1000000);
    }
}
