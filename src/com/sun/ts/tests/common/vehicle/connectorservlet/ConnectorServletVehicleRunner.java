/*
 * Copyright (c) 2008, 2020 Oracle and/or its affiliates. All rights reserved.
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

package com.sun.ts.tests.common.vehicle.connectorservlet;

import com.sun.ts.lib.util.*;
import com.sun.ts.tests.common.vehicle.web.WebVehicleRunner;
import com.sun.javatest.Status;

/*
 *  This is the class that is different for each vehicle.
 *  This should lookup and invoke the vehicle in the container (if there is one).
 */
public class ConnectorServletVehicleRunner extends ConnectorVehicleRunner {
  protected Status run() {
    // run in a connectorservlet
    sTestStatus = runWebVehicleTest(sVehicle);

    TestUtil
        .logMsg("Test: returning from running in a connectorservlet vehicle");

    return sTestStatus;
  }// run
}
