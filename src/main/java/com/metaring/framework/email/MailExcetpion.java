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

import com.metaring.framework.functionality.FunctionalitiesManager;
import com.metaring.framework.functionality.FunctionalityExecutionStepEnumerator;
import com.metaring.framework.functionality.UnmanagedException;
import com.metaring.framework.util.StringUtil;

public class MailExcetpion extends UnmanagedException {
    private static final long serialVersionUID = -2017831050075670327L;

    public MailExcetpion(String message) {
        super(FunctionalitiesManager.getStack((FunctionalityExecutionStepEnumerator) FunctionalityExecutionStepEnumerator.CALL), message);
    }

    protected MailExcetpion(String message, Throwable cause) {
        super(FunctionalitiesManager.getStack((FunctionalityExecutionStepEnumerator) FunctionalityExecutionStepEnumerator.CALL), message + "\n\n" + StringUtil.fromThrowableToString((Throwable) cause));
    }
}
