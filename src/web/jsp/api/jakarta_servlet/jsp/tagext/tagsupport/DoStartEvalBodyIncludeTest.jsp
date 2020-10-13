<%--

    Copyright (c) 2003, 2020 Oracle and/or its affiliates. All rights reserved.

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

<%@ page contentType="text/plain" %>
<%@ taglib uri="http://java.sun.com/tck/jsp/tagsupport" prefix="tag"  %>

<tag:interaction doStartTag="EVAL_BODY_INCLUDE" doEndTag="EVAL_PAGE"
                 doAfterBody="SKIP_BODY" result="interaction">
    Test FAILED
</tag:interaction>
<%
    // body evaluation should have used the out for the page.
    // Flush the current out.
    out.clearBuffer();
%>

<jsp:useBean id="validate" scope="page"
             class="com.sun.ts.tests.jsp.common.util.MethodValidatorBean" />

<jsp:setProperty name="validate" property="context" value="<%= pageContext %>" />
<jsp:setProperty name="validate" property="name" value="interaction" />
<jsp:setProperty name="validate" property="methods"  value="doStartTag,doAfterBody,doEndTag" />

${validate.result}
