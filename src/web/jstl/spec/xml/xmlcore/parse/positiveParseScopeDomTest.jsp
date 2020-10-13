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

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParseScopeDomTest">

   <!-- The scopeDom attribute specifies the scope into which
             varDom is exported.  If not specified, varDom is exported
             to the page scope by default. -->
   <x:parse doc="<test>xmltext</test>" varDom="riPageText"/>
   <x:parse doc="<test>xmltext</test>" varDom="rePageText" scopeDom="page"/>
   <x:parse doc="<test>xmltext</test>" varDom="reRequestText" scopeDom="request"/>
   <x:parse doc="<test>xmltext</test>" varDom="reSessionText" scopeDom="session"/>
   <x:parse doc="<test>xmltext</test>" varDom="reApplicationText" scopeDom="application"/>
   <tck:checkScope varName="riPageText"/>
   <tck:checkScope varName="rePageText"/>
   <tck:checkScope varName="reRequestText" inScope="request"/>
   <tck:checkScope varName="reSessionText" inScope="session"/>  
   <tck:checkScope varName="reApplicationText" inScope="application"/>
   <c:remove var="reApplicationText" scope="application"/> 
</tck:test>
