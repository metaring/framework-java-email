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

import com.cedarsoftware.util.io.JsonWriter;

import com.metaring.framework.Core;
import com.metaring.framework.functionality.FunctionalityExecutionResult;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.type.Email;
import com.metaring.framework.type.series.EmailSeries;

public class BugReportMail {
    private static final String CFG_SUPPORT_TEAM = "supportTeam";
    private static final String SUPPORT_TEAM_MEMBER_NAME = "Support Team";
    private static final String SUPPORT_TEAM_MEMBER_SURNAME = "Member";

    public static final void send(Long callingEnvironmentId, String sourceIp, String jsonPayload, FunctionalityExecutionResult result, String exception) {
        try {
            EmailHelper.send(EmailMessage.create(EmailHelper.DEFAULT_EMAIL_SENDER, getSupportTeamEmailContacts(), null, null, getBugReportEmailSubject(callingEnvironmentId), EmailTypeEnumerator.HTML, getBugReportEmailMessage(callingEnvironmentId, sourceIp, jsonPayload, result, exception)));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final EmailContactSeries getSupportTeamEmailContacts() {
        if (!Core.SYSKB.hasProperty(EmailController.CFG_EMAIL)) {
            return null;
        }
        DataRepresentation emailConfiguration = Core.SYSKB.get(EmailController.CFG_EMAIL);
        if (!emailConfiguration.hasProperty(CFG_SUPPORT_TEAM)) {
            return null;
        }

        EmailSeries emailSeries = emailConfiguration.getEmailSeries(CFG_SUPPORT_TEAM);
        ArrayList<EmailContact> contacts = new ArrayList<EmailContact>();
        for (Email email : emailSeries) {
            contacts.add(EmailContact.create(SUPPORT_TEAM_MEMBER_NAME, SUPPORT_TEAM_MEMBER_SURNAME, email));
        }
        return EmailContactSeries.create(contacts.toArray(new EmailContact[contacts.size()]));
    }

    private static final String getBugReportEmailSubject(Long id) {
        return Core.SYSKB.getSystemName() + " - Error during RPC with id " + id;
    }

    private static final String getBugReportEmailMessage(Long callingEnvironmentId, String sourceIp, String jsonPayload, FunctionalityExecutionResult result, String exception) {
        StringBuilder sb = new StringBuilder();
        sb.append("The RPC with id <span style=\"background-color: lightgrey; font-family: monospace;\"><b>");
        sb.append(callingEnvironmentId);
        sb.append("</b></span> by IP <span style=\"background-color: lightgrey; font-family: monospace;\"><b>");
        sb.append(sourceIp);
        sb.append("</b></span>,");
        sb.append("\n<br/>\n<br/>\n");
        sb.append("Wich made the <span style=\"background-color: lightgrey; font-family: monospace; color: darkgreen;\"><b>REQUEST</b></span>:");
        sb.append("\n<br/>\n<br/>\n<br/>\n");
        sb.append("<div style=\"background-color: lightgrey; font-family: monospace; font-size: 18px;\">");
        sb.append(jsonPayload);
        sb.append("</div>");
        sb.append("\n<br/>\n<br/>\n");
        sb.append("That produced the <span style=\"background-color: lightgrey; font-family: monospace; color: darkblue;\"><b>RESULT</b></span>:");
        sb.append("\n<br/>\n<br/>\n<br/>\n");
        sb.append("<div style=\"background-color: lightgrey; font-family: monospace; font-size: 18px;\">");
        sb.append(JsonWriter.formatJson(result.toJson()).replace("\n", "<br/>").replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;").replace(" ", "&nbsp;"));
        sb.append("</div>");
        sb.append("\n<br/>\n<br/>\n");
        sb.append("Throwed the <span style=\"background-color: lightgrey; font-family: monospace; color: darkred;\"><b>ERROR</b></span>:");
        sb.append("\n<br/>\n<br/>\n<br/>\n");
        sb.append("<div style=\"background-color: lightgrey; font-family: monospace; font-size: 18px;\">");
        sb.append(exception.replace("\n", "<br/>").replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;").replace(" ", "&nbsp;"));
        sb.append("</div>");
        return sb.toString();
    }
}
