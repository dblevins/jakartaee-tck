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

/*
 * @(#)DefaultSimpleTag.java 1.1 10/31/02
 */

package com.sun.ts.tests.jsp.api.jakarta_servlet.jsp.tagext.simpletagsupport;

import jakarta.servlet.jsp.tagext.SimpleTagSupport;

/**
 * This will validate that the default behavior of SimpleTagSupport is to do
 * nothing. This will be validated by having the SimpleTag surround another tag
 * instance. If the default behavior is correct, the nested tag will not be
 * invoked.
 */
public class DefaultSimpleTag extends SimpleTagSupport {

  /**
   * Default constructor.
   */
  public DefaultSimpleTag() {
    super();
  }

}
