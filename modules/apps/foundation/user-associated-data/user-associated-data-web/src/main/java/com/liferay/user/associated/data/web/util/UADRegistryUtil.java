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

import org.osgi.service.component.annotations.Component;

/**
 * @author William Newbury
 */
@Component(immediate = true, service = UADRegistryUtil.class)
public class UADRegistryUtil {

	public static void notify(long userId) {
		_UAD_REGISTRY.notify(userId);
	}

	public static void register(UADService uadService) {
		_UAD_REGISTRY.register(uadService);
	}

	public static void unregister(String name) {
		_UAD_REGISTRY.unregister(name);
	}

	private static final UADRegistry _UAD_REGISTRY = new UADRegistry();

}