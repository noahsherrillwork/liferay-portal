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

package com.liferay.user.associated.data.web.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;

import java.util.List;

/**
 * @author William Newbury
 */
@ImplementationClassName(
	"com.liferay.user.associated.data.web.model.impl.UADAssetImpl"
)
@ProviderType
public interface UADService {

	public void autoAnonymizeAll(long userId);

	public long count(long userId);

	public void deleteAll(long userId);

	public void exportAll(long userId);

	public String getName();

	public List<UADAsset> getUADAssets(long userId);

	public void process(long userId);

}