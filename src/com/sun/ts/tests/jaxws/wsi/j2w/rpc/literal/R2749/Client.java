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

package com.sun.ts.tests.jaxws.wsi.j2w.rpc.literal.R2749;

import java.util.Properties;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.javatest.Status;
import com.sun.ts.tests.jaxws.sharedclients.ClientFactory;
import com.sun.ts.tests.jaxws.sharedclients.SOAPClient;
import com.sun.ts.tests.jaxws.sharedclients.rpclitclient.*;
import com.sun.ts.tests.jaxws.wsi.constants.DescriptionConstants;
import com.sun.ts.tests.jaxws.wsi.constants.SOAPConstants;
import com.sun.ts.tests.jaxws.wsi.utils.DescriptionUtils;

import com.sun.ts.lib.harness.*;

public class Client extends ServiceEETest
    implements DescriptionConstants, SOAPConstants {
  /**
   * The client.
   */
  private SOAPClient client;

  static J2WRLShared service = null;

  /**
   * Test entry point.
   * 
   * @param args
   *          the command-line arguments.
   */
  public static void main(String[] args) {
    Client test = new Client();
    Status status = test.run(args, System.out, System.err);
    status.exit();
  }

  /**
   * @class.testArgs: -ap jaxws-url-props.dat
   * @class.setup_props: webServerHost; webServerPort; platform.mode;
   *
   * @param args
   * @param properties
   *
   * @throws Fault
   */
  public void setup(String[] args, Properties properties) throws Fault {
    client = ClientFactory.getClient(J2WRLSharedClient.class, properties, this,
        service);
    logMsg("setup ok");
  }

  public void cleanup() {
    logMsg("cleanup");
  }

  /**
   * @testName: testPartsAttributes
   *
   * @assertion_ids: WSI:SPEC:R2749
   *
   * @test_Strategy: Retrieve the WSDL, generated by the Java-to-WSDL tool, and
   *                 examine the wsdl:binding elements, ensuring that the input
   *                 and output elements' header and headerfault elements have
   *                 the part attributes and that they're NMTOKENs.
   *
   * @throws Fault
   */
  public void testPartsAttributes() throws Fault {
    Document document = client.getDocument();
    Element[] bindings = DescriptionUtils.getBindings(document);
    for (int i = 0; i < bindings.length; i++) {
      verifyBinding(bindings[i]);
    }
  }

  protected void verifyBinding(Element binding) throws Fault {
    Element[] operations = DescriptionUtils.getChildElements(binding,
        WSDL_NAMESPACE_URI, WSDL_OPERATION_LOCAL_NAME);
    for (int i = 0; i < operations.length; i++) {
      verifyOperation(operations[i]);
    }
  }

  protected void verifyOperation(Element operation) throws Fault {
    Element[] children = DescriptionUtils.getChildElements(operation,
        WSDL_NAMESPACE_URI, null);
    for (int i = 0; i < children.length; i++) {
      String localName = children[i].getLocalName();
      if ((localName.equals(WSDL_INPUT_LOCAL_NAME))
          || (localName.equals(WSDL_OUTPUT_LOCAL_NAME))) {
        verifyInputOutputFault(children[i]);
      }
    }
  }

  protected void verifyInputOutputFault(Element element) throws Fault {
    Element[] children = DescriptionUtils.getChildElements(element,
        SOAP_NAMESPACE_URI, null);
    for (int i = 0; i < children.length; i++) {
      String localName = children[i].getLocalName();
      if ((localName.equals(SOAP_HEADER_LOCAL_NAME))
          || (localName.equals(SOAP_HEADERFAULT_LOCAL_NAME))) {
        verifyPartAttribute(children[i]);
      }
    }
  }

  protected void verifyPartAttribute(Element element) throws Fault {
    String localName = element.getLocalName();
    Attr attr = element.getAttributeNode(SOAP_PARTS_ATTR);
    if (attr != null) {
      throw new Fault("Disallowed attribute 'parts' found on element '"
          + localName + "' (BP-R2749)");
    }
  }
}
