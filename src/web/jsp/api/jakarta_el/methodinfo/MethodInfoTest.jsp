<%--

    Copyright (c) 2005, 2020 Oracle and/or its affiliates. All rights reserved.

    This program and the accompanying materials are made available under the
    terms of the Eclipse Public License v. 2.0, which is available at
    http://www.eclipse.org/legal/epl-2.0.

    This Source Code may also be made available under the following Secondary
    Licenses when the conditions for such availability set forth in the
    Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
    version 2 with the GNU Classpath Exception, which is available at
    https://www.gnu.org/software/classpath/license.html.

    SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0

--%>

<%@ taglib prefix="test" uri="/WEB-INF/methodinfo.tld" %>

<jsp:useBean id="vect" class="java.util.Vector"/>
begin
  <test:MethodInfoTag methExpr="#{vect.add}" />
  vect is ${vect}
  <test:set var="result" value='${(vect == "[latest member]") ? "Test PASSED" : "Test FAILED in jsp page"}' />
  result is ${result}
end
