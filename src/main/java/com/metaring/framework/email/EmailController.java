/**
 *    Copyright 2019 MetaRing s.r.l.
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.metaring.framework.email;

import com.metaring.framework.SysKB;
import com.metaring.framework.exception.ManagedException;
import com.metaring.framework.functionality.UnmanagedException;

public interface EmailController {
    public static final String CFG_EMAIL = "email";
    public static final String CFG_SENDER = "sender";
    public static final String CFG_USERNAME = "mail.smtp.user";
    public static final String CFG_PASSWORD = "mail.smtp.password";
    public static final String CFG_TEST_ADDRESS = "testAddress";
    public static final String CFG_TEST = "test";

    void reinit(SysKB sysKB);

    void send(EmailMessageSeries emailMessageSeries) throws ManagedException, UnmanagedException;

    default void shutdown() {
    }
}
