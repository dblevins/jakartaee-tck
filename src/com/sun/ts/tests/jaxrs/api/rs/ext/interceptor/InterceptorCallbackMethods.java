/*
 * Copyright (c) 2012, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.ts.tests.jaxrs.api.rs.ext.interceptor;

import java.io.IOException;

/**
 * Every InterceptorContext has different way to get header OPERATION, proceed,
 * or write an entity to a response. Therefore, TemplateInterceptorBody is given
 * the implementation of this interface so that it can abstractly call these
 * methods no matter the given context.
 * 
 * It is passed as an argument to the only call-able method
 * {@link TemplateInterceptorBody#executeMethod()}
 */
public interface InterceptorCallbackMethods {
  void writeEntity(String entity);

  Object proceed() throws IOException;

  String getHeaderString();
}
