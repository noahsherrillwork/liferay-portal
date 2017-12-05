/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.user.associated.data.web.service.registry;

import com.liferay.osgi.service.tracker.collections.map.ServiceReferenceMapper;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.user.associated.data.web.model.UADService;

import java.util.Collection;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
* @author William Newbury
*/
@Component(immediate = true, service = UADServiceRegistry.class)
public class UADServiceRegistry {

	public UADService getUADService(String key) {
		return _uadServiceTrackerMap.getService(key);
	}

	public Collection<UADService> getUADServices() {
		return _uadServiceTrackerMap.values();
	}

	public void notify(long userId) {
		System.out.println("############################ notify");

		for (UADService uadService : getUADServices()) {
			uadService.process(userId);
		}
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_uadServiceTrackerMap = ServiceTrackerMapFactory.openSingleValueMap(
			bundleContext, UADService.class, "(uad.service.key=*)",
			new UADServiceReferenceMapper());
	}

	private ServiceTrackerMap<String, UADService> _uadServiceTrackerMap;

	private class UADServiceReferenceMapper
		implements ServiceReferenceMapper<String, UADService> {

		@Override
		public void map(
			ServiceReference<UADService> serviceReference,
			Emitter<String> emitter) {

			String uadServiceKey = (String)serviceReference.getProperty(
				"uad.service.key");

			System.out.println("################## Heyo, registered");

			if (Validator.isNotNull(uadServiceKey)) {
				emitter.emit(uadServiceKey);
			}
		}

	}

}