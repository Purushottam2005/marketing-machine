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

import org.mule.util.StringUtils;

import com.sun.syndication.feed.synd.SyndEntry;

public class TwitterStatusComponent
{
    private static final String HASHTAG = "#mulesoft";
    private static final int HASHTAG_LENGTH = HASHTAG.length() + 1; // +1 for separating blank

    private static final int MAX_TWITTER_MESSAGE_LENGTH = 140;

    public String formatPayload(SyndEntry entry)
    {
        int maxTitleLength = MAX_TWITTER_MESSAGE_LENGTH - HASHTAG_LENGTH;

        String uri = entry.getUri();
        int uriLength = uri.length() + 1;   // +1 for separating blank
        maxTitleLength = maxTitleLength - uriLength;

        maxTitleLength = maxTitleLength - 1; // -1 for the blank between title an URI
        String title = entry.getTitle();
        title = StringUtils.abbreviate(title, maxTitleLength);

        StringBuilder buf = new StringBuilder(MAX_TWITTER_MESSAGE_LENGTH);
        buf.append(title);
        buf.append(" ");
        buf.append(uri);
        buf.append(" ");
        buf.append(HASHTAG);

        return buf.toString();
    }
}
