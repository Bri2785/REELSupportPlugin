// 
// Decompiled by Procyon v0.5.30
// 

package com.unigrative.plugins.reelSupport.fbapi;

import com.unigrative.plugins.reelSupport.exception.FishbowlException;
import com.fbi.fbo.message.response.ResponseBase;
import com.fbi.fbo.message.request.RequestBase;
import com.fbi.fbo.impl.ApiCallType;

@FunctionalInterface
public interface ApiCaller
{
    ResponseBase call(final ApiCallType p0, final RequestBase p1) throws FishbowlException;
}
