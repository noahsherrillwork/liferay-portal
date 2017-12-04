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

import java.net.URL;

/**
 * @author William Newbury
 */
@ImplementationClassName(
	"com.liferay.user.associated.data.web.model.impl.UADAssetImpl"
)
@ProviderType
public interface UADAsset {

	public void autoAnonymize();

	public void delete();

	public void export();

	public UADAsset getChildUADAsset();

	public URL getEditURL();

	public UADAsset getParentUADAsset();

	public long getUserId();

	public void setChildUADAsset(UADAsset uadAsset);

	public void setParentUADAsset(UADAsset uadAsset);

}