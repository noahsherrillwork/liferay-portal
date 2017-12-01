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

package com.liferay.user.associated.data.web.util;

import com.liferay.user.associated.data.web.model.UADService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author William Newbury
 */
public class UADRegistry {

	public UADRegistry() {
		_uadServices = new ArrayList<>();
	}

	public void notify(long userId) {
		for (UADService uadService : _uadServices) {
			uadService.process(userId);
		}
	}

	public void register(UADService uadService) {
		_uadServices.add(uadService);
	}

	public void unregister(String name) {
		for (UADService uadService : _uadServices) {
			if (name.equals(uadService.getName())) {
				_uadServices.remove(uadService);
			}
		}
	}

	private final List<UADService> _uadServices;

}