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

<%@ page import="com.sun.ts.tests.jsp.common.util.JspTestUtil,
                 java.io.IOException" %>
<%@ page contentType="text/plain" %>

<%-- Begin test definitions --%>

<%!
    public void jspExceptionDefaultCtorTest(HttpServletRequest req,
                                            HttpServletResponse res,
                                            JspWriter out)
    throws ServletException, IOException {
        JspException je = new JspException();
        if (je != null) {
            out.println("Test PASSED");
        } else {
            out.println("Test FAILED.  No Exception created.");
        }
    }
%>

<%!
    public void jspExceptionMessageCtorTest(HttpServletRequest req,
                                            HttpServletResponse res,
                                            JspWriter out)
    throws ServletException, IOException {
        JspException je = new JspException("Exception Message");
        if (je != null) {
            String message = je.getMessage();
            if (message != null && message.equals("Exception Message")) {
                out.println("Test PASSED");
            } else {
                out.println("Test FAILED.  Expected a message of 'Exception Message'");
                out.println("Received: " + message);
            }
        } else {
            out.println("Test FAILED.  No Exception created.");
        }
    }
%>

<%!
    public void jspExceptionCauseCtorTest(HttpServletRequest req,
                                          HttpServletResponse res,
                                          JspWriter out)
    throws ServletException, IOException {
        JspException je = new JspException(new NullPointerException());
        if (je != null) {
            Throwable t = je.getRootCause();
            if (t != null && t instanceof NullPointerException) {
                out.println("Test PASSED");
            } else {
                out.println("Test FAILED.  Expected a Throwable of type NullPointerException");
                out.println("Received: " + t);
            }
        } else {
            out.println("Test FAILED.  No Exception created.");
        }
    }
%>

<%!
    public void jspExceptionCauseMessageCtorTest(HttpServletRequest req,
                                                 HttpServletResponse res,
                                                 JspWriter out)
    throws ServletException, IOException {
        JspException je = new JspException("Exception Message",
                                                      new ServletException());
        if (je != null) {
            String message = je.getMessage();
            if (message != null && message.equals("Exception Message")) {
                Throwable t = je.getRootCause();
                if (t != null && t instanceof ServletException) {
                    out.println("Test PASSED");
                } else {
                    out.println("Test FAILED.  Expected a Throwable of type ServletException");
                    out.println("Received: " + t);
                }
            } else {
                out.println("Test FAILED.  Expected a message of 'Exception Message'");
                out.println("Received: " + message);
            }
        } else {
            out.println("Test FAILED.  No Exception created.");
        }
    }
%>

<%!
    public void jspExceptionGetRootCauseTest(HttpServletRequest req,
                                             HttpServletResponse res,
                                             JspWriter out)
    throws ServletException, IOException {
        JspException je = new JspException(new ServletException());
        JspException je1 = new JspException("exception", new NullPointerException());

        Throwable t = je.getRootCause();
        Throwable t1 = je1.getRootCause();
        if (t != null) {
            if (t instanceof ServletException) {
                if (t1 != null) {
                    if (t1 instanceof NullPointerException) {
                        out.println("Test PASSED");
                    } else {
                        out.println("Test FAILED.  JspException.getRootCause returned unexpected" +
                            " exception: " + t.getClass().getName());
                        out.println("Expected: NullPointerException");
                    }
                } else {
                    out.println("Test FAILED.  JspException.getRootCause returned null.");
                }
            } else {
                out.println("Test FAILED.  JspException.getRootCause returned unexpected" +
                    " exception: " + t.getClass().getName());
                out.println("Expected: ServletException");
            }
        } else {
            out.println("Test FAILED.  JspException.getRootCause returned null.");
        }
    }
%>

<%-- Test invocation --%>

<% JspTestUtil.invokeTest(this, request, response, out); %>
