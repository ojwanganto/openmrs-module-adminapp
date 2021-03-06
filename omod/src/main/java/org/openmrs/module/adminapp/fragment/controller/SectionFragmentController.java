/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.adminapp.fragment.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.appframework.domain.Extension;
import org.openmrs.module.appframework.service.AppFrameworkService;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;

import java.util.ArrayList;
import java.util.List;

public class SectionFragmentController {

	protected Log log = LogFactory.getLog(getClass());

	public void controller(FragmentModel fragmentModel,
						   @SpringBean("appFrameworkService") AppFrameworkService appFrameworkService,
						   @FragmentParam("app") String app) {
		List<Extension> links = appFrameworkService.getExtensionsForCurrentUser("org.openmrs.adminapp.link");
		List<Extension> out = new ArrayList<Extension>();

		for (Extension link : links) {
			if (link.getBelongsTo().getId().contains(app))
				out.add(link);
		}

		fragmentModel.addAttribute("links", out);

//<openmrs:extensionPoint pointId="org.openmrs.admin.users.localHeader" type="html">
//<c:forEach items="${extension.links}" var="link">
//<li <c:if test="${fn:endsWith(pageContext.request.requestURI, link.key)}">class="active"</c:if> >
//<a href="${pageContext.request.contextPath}/${link.key}"><openmrs:message code="${link.value}"/></a>
//</li>
//</c:forEach>
//</openmrs:extensionPoint>

	}
}
