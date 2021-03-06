/*
 * Copyright (c) 2009-2012 David Grant
 * Copyright (c) 2010 ThruPoint Ltd
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jscep.transport.request;

import java.io.IOException;

import org.spongycastle.cms.CMSSignedData;
import org.spongycastle.util.encoders.Base64;

/**
 * The <tt>PkiOperationRequest</tt> class may represent a <tt>PKCSReq</tt>,
 * <tt>GetCertInitial</tt>, <tt>GetCert</tt> and <tt>GetCRL</tt> request.
 * 
 * @author David Grant
 */
public final class PkiOperationRequest extends Request {
    private final CMSSignedData msgData;

    /**
     * Creates a new instance of this class using the provided pkiMessage and
     * response handler.
     * 
     * @param msgData
     *            the pkiMessage to use.
     */
    public PkiOperationRequest(CMSSignedData msgData) {
	super(Operation.PKI_OPERATION);

	this.msgData = msgData;
    }

    /**
     * {@inheritDoc}
     */
    public String getMessage() {
	try {
		 return new String(Base64.encode(msgData.getEncoded()));
	} catch (IOException e) {
	    throw new RuntimeException(e);
	}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
	return msgData.toString();
    }
}
