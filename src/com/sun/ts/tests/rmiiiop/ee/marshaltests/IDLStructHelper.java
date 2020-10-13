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
 * com/sun/ts/tests/rmiiiop/ee/marshaltests/IDLStructHelper.java Generated by
 * the IDL-to-Java compiler (portable), version "3.0" from idl.idl Monday,
 * February 26, 2001 10:51:35 AM EST
 */

abstract public class IDLStructHelper {
  private static String _id = "IDL:com/sun/ts/tests/rmiiiop/ee/marshaltests/IDLStruct:1.0";

  public static void insert(org.omg.CORBA.Any a,
      com.sun.ts.tests.rmiiiop.ee.marshaltests.IDLStruct that) {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
    a.type(type());
    write(out, that);
    a.read_value(out.create_input_stream(), type());
  }

  public static com.sun.ts.tests.rmiiiop.ee.marshaltests.IDLStruct extract(
      org.omg.CORBA.Any a) {
    return read(a.create_input_stream());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;

  private static boolean __active = false;

  synchronized public static org.omg.CORBA.TypeCode type() {
    if (__typeCode == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (__typeCode == null) {
          if (__active) {
            return org.omg.CORBA.ORB.init().create_recursive_tc(_id);
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember[1];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init()
              .get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
          _members0[0] = new org.omg.CORBA.StructMember("x", _tcOf_members0,
              null);
          __typeCode = org.omg.CORBA.ORB.init().create_struct_tc(
              com.sun.ts.tests.rmiiiop.ee.marshaltests.IDLStructHelper.id(),
              "IDLStruct", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id() {
    return _id;
  }

  public static com.sun.ts.tests.rmiiiop.ee.marshaltests.IDLStruct read(
      org.omg.CORBA.portable.InputStream istream) {
    com.sun.ts.tests.rmiiiop.ee.marshaltests.IDLStruct value = new com.sun.ts.tests.rmiiiop.ee.marshaltests.IDLStruct();
    value.x = istream.read_short();
    return value;
  }

  public static void write(org.omg.CORBA.portable.OutputStream ostream,
      com.sun.ts.tests.rmiiiop.ee.marshaltests.IDLStruct value) {
    ostream.write_short(value.x);
  }

}
