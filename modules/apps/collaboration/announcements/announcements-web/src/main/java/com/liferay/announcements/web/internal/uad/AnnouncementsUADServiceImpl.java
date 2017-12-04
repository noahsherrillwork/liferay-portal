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

package com.liferay.announcements.web.internal.uad;

import com.liferay.user.associated.data.web.model.UADAsset;
import com.liferay.user.associated.data.web.model.impl.UADServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author William Newbury
 */
public class AnnouncementsUADServiceImpl extends UADServiceImpl {

	public AnnouncementsUADServiceImpl(String name) {
		super(name);
	}

	@Override
	public void process(long userId) {
		List<UADAsset> announcementsUADAssets = new ArrayList<UADAsset>();

		uadAssets = announcementsUADAssets;
	}

}