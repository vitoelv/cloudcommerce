/**
* Author: Bob Chen
*/

package com.jcommerce.web;

import servletunit.struts.MockStrutsTestCase;

public class WelcomeActionTest extends MockStrutsTestCase {
    public WelcomeActionTest(String testName) {
        super(testName);
    }
    
    public void testExecute() {
        setRequestPathInfo("/dispatch");
        addRequestParameter("page", "home");
        actionPerform();
        verifyForward("home");
        verifyNoActionErrors();
    }
}
