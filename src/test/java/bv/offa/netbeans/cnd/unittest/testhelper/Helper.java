/*
 * NBCndUnit - C/C++ unit tests for NetBeans.
 * Copyright (C) 2015-2017  offa
 *
 * This file is part of NBCndUnit.
 *
 * NBCndUnit is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * NBCndUnit is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with NBCndUnit.  If not, see <http://www.gnu.org/licenses/>.
 */

package bv.offa.netbeans.cnd.unittest.testhelper;

import bv.offa.netbeans.cnd.unittest.api.CndTestCase;
import bv.offa.netbeans.cnd.unittest.api.CndTestHandler;
import bv.offa.netbeans.cnd.unittest.api.CndTestSuite;
import bv.offa.netbeans.cnd.unittest.api.TestFramework;
import java.util.regex.Matcher;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import org.netbeans.modules.gsf.testrunner.api.TestSession;

public final class Helper
{
    private Helper()
    {
        /* Empty */
    }
    
    
    public static Matcher checkedMatch(CndTestHandler handler, String input)
    {
        Matcher m = handler.match(input);
        assertTrue(m.find());
        return m;
    }
    
        
    public static CndTestCase createCurrentTestCase(String suiteName, String caseName, 
                                                    TestFramework framework, TestSession session)
    {
        CndTestCase testCase = new CndTestCase(caseName, framework, session);
        testCase.setClassName(suiteName);
        when(session.getCurrentTestCase()).thenReturn(testCase);
        
        return testCase;
    }
    
    
    public static CndTestSuite createCurrentTestSuite(String suiteName, TestFramework framework, 
                                                        TestSession session)
    {
        CndTestSuite testSuite = new CndTestSuite(suiteName, framework);
        when(session.getCurrentSuite()).thenReturn(testSuite);
        
        return testSuite;
    }
    
    
}
