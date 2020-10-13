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

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveBundleBasenameNullEmptyTest">

    <!-- If basename is null or empty, the resource bundle is
             treated as non-existent, causing any message key lookups
             to fail with "???<keyname>???" -->
    <fmt:bundle basename='<%= null %>'>
        <fmt:message key="nullval"/>
    </fmt:bundle>
    <fmt:bundle basename="">
        <fmt:message key="emptyval"/>
    </fmt:bundle>
</tck:test>
