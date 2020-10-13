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
 */

/*
 * $Id$
 */

package com.sun.ts.tests.jws.common;

public class Parameters {

  private String implementationClass;

  private String wsdlUrl;

  private String portOperationName;

  private String serviceUrl;

  public String getImplementationClass() {
    return implementationClass;
  }

  public void setImplementationClass(String implClass) {
    this.implementationClass = implClass;
  }

  public String getWsdlUrl() {
    return wsdlUrl;
  }

  public void setWsdlUrl(String wsdlUrl) {
    this.wsdlUrl = wsdlUrl;
  }

  public String getPortOperationName() {
    return portOperationName;
  }

  public void setPortOperationName(String portOperationName) {
    this.portOperationName = portOperationName;
  }

  public String getServiceUrl() {
    return serviceUrl;
  }

  public void setServiceUrl(String serviceUrl) {
    this.serviceUrl = serviceUrl;
  }

  public String toString() {
    return "Impl Class:" + implementationClass + " WSDL:" + wsdlUrl
        + " Port Operation:" + portOperationName + " Service URL:" + serviceUrl;
  }

}
