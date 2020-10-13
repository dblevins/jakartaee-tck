/*
 * Copyright (c) 2007, 2020 Oracle and/or its affiliates. All rights reserved.
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

/*
 * $Id$
 */

package com.sun.ts.tests.rmiiiop.ee.marshaltests;

/**
 * com/sun/ts/tests/rmiiiop/ee/marshaltests/IDLStructHolder.java Generated by
 * the IDL-to-Java compiler (portable), version "3.0" from idl.idl Monday,
 * February 26, 2001 10:51:35 AM EST
 */

public final class IDLStructHolder
    implements org.omg.CORBA.portable.Streamable {
  public com.sun.ts.tests.rmiiiop.ee.marshaltests.IDLStruct value = null;

  public IDLStructHolder() {
  }

  public IDLStructHolder(
      com.sun.ts.tests.rmiiiop.ee.marshaltests.IDLStruct initialValue) {
    value = initialValue;
  }

  public void _read(org.omg.CORBA.portable.InputStream i) {
    value = com.sun.ts.tests.rmiiiop.ee.marshaltests.IDLStructHelper.read(i);
  }

  public void _write(org.omg.CORBA.portable.OutputStream o) {
    com.sun.ts.tests.rmiiiop.ee.marshaltests.IDLStructHelper.write(o, value);
  }

  public org.omg.CORBA.TypeCode _type() {
    return com.sun.ts.tests.rmiiiop.ee.marshaltests.IDLStructHelper.type();
  }

}
