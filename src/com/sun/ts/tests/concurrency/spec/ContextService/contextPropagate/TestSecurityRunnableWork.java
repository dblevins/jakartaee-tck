/*
 * Copyright (c) 2013, 2020 Oracle and/or its affiliates. All rights reserved.
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

package com.sun.ts.tests.concurrency.spec.ContextService.contextPropagate;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestSecurityRunnableWork extends BaseTestRunnableWork {

  @Override
  protected String work() {
    try {
      InitialContext ctx = new InitialContext();
      return ((LimitedInterface) ctx
          .lookup("java:app/ContextPropagate_ejb/LimitedBean")).doSomething();

    } catch (NamingException e) {
      throw new RuntimeException(e);
    }
  }
}
