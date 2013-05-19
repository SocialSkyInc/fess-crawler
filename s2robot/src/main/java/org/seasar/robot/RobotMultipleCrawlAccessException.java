/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.robot;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author shinsuke
 * 
 */
public class RobotMultipleCrawlAccessException extends
        RobotCrawlAccessException {

    private static final long serialVersionUID = 1L;

    private final Throwable[] throwables;

    /**
     * @param message
     */
    public RobotMultipleCrawlAccessException(String message,
            final Throwable[] throwables) {
        super(message);
        this.throwables = throwables;
    }

    @Override
    public void printStackTrace(final PrintStream s) {
        super.printStackTrace(s);

        int count = 1;
        for (final Throwable t : throwables) {
            s.println("Caused " + count + ":");
            t.printStackTrace(s);
            count++;
        }
    }

    @Override
    public void printStackTrace(final PrintWriter s) {
        super.printStackTrace(s);

        int count = 1;
        for (final Throwable t : throwables) {
            s.println("Caused " + count + ":");
            t.printStackTrace(s);
            count++;
        }
    }
}
