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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.metaring.framework.SysKB;
import com.metaring.framework.localization.LocaleEnumerator;

class SendMassiveTemplateEmailFunctionalityImpl extends SendMassiveTemplateEmailFunctionality {

    protected SendMassiveTemplateEmailFunctionalityImpl(SysKB sysKB) {
        super(sysKB);
    }

    @Override
    protected CompletableFuture<Void> preConditionCheck(MassiveTemplateEmail massiveTemplateEmail) throws Exception {
        return end;
    }

    @Override
    protected CompletableFuture<Void> call(MassiveTemplateEmail massiveTemplateEmail) throws Exception {
        CompletableFuture<Void> call = new CompletableFuture<>();
        CompletableFuture.runAsync(() -> {
            try {
                String templateName = massiveTemplateEmail.getTemplateName();
                HashMap<LocaleEnumerator, List<MassiveEmailElement>> map = new HashMap<>();
                MassiveTemplateEmailElementSeries massiveTemplateEmailElementSeries = massiveTemplateEmail.getElements();
                for (int i = 0; i < massiveTemplateEmailElementSeries.size(); ++i) {
                    MassiveTemplateEmailElement massiveTemplateEmailElement = massiveTemplateEmailElementSeries.get(i);
                    LocaleEnumerator locale = massiveTemplateEmailElement.getLanguage();
                    if (!map.containsKey(locale)) {
                        map.put(locale, new ArrayList<>());
                    }
                    MassiveEmailElementSeries massiveEmailElementSeries = massiveTemplateEmailElement.getRecipients();
                    for (int j = 0; j < massiveEmailElementSeries.size(); ++j) {
                        MassiveEmailElement massiveEmailElement = massiveEmailElementSeries.get(j);
                        ((List<MassiveEmailElement>) map.get(locale)).add(massiveEmailElement);
                    }
                }
                ArrayList<MassiveLocalizedEmail> massiveLocalizedEmails = new ArrayList<MassiveLocalizedEmail>();
                for (LocaleEnumerator locale : map.keySet()) {
                    List<MassiveEmailElement> list = map.get(locale);
                    MassiveEmailElement[] array = new MassiveEmailElement[list.size()];
                    array = list.toArray(array);
                    MassiveEmailElementSeries recipients = MassiveEmailElementSeries.create(array);
                    MassiveLocalizedEmailElement massiveLocalizedEmailElement = MassiveLocalizedEmailElement.create(templateName, recipients);
                    MassiveLocalizedEmailElementSeries massiveLocalizedEmailElementSeries = MassiveLocalizedEmailElementSeries.create(massiveLocalizedEmailElement);
                    MassiveLocalizedEmail massiveLocalizedEmail = MassiveLocalizedEmail.create(locale, massiveLocalizedEmailElementSeries);
                    massiveLocalizedEmails.add(massiveLocalizedEmail);
                }
                for (MassiveLocalizedEmail massiveLocalizedEmail : massiveLocalizedEmails) {
                    EmailFunctionalitiesManager.sendMassiveLocalizedEmail(massiveLocalizedEmail);
                }
                call.complete(null);
            }
            catch (Exception e) {
                call.completeExceptionally(e);
            }
        }, EXECUTOR);
        return call;
    }

    @Override
    protected CompletableFuture<Void> postConditionCheck(MassiveTemplateEmail massiveTemplateEmail) throws Exception {
        return end;
    }
}
