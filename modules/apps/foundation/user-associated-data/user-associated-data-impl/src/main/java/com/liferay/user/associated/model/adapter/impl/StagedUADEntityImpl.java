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

package com.liferay.user.associated.data.model.adapter.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLink;
import com.liferay.asset.kernel.model.adapter.StagedAssetLink;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.user.associated.data.model.adapter.StagedUADEntity;
import com.liferay.user.associated.data.entity.UADEntity;

import java.io.Serializable;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.util.Date;
import java.util.Map;

/**
 * @author Noah Sherrill
 */
public class StagedUADEntityImpl implements StagedUADEntity {

	public StagedUADEntityImpl(UADEntity uadEntity) {
		_uadEntity = uadEntity;
	}

	@Override
	public Object clone() {
		StagedUADEntityImpl stagedUADEntityImpl = new StagedUADEntityImpl(_uadEntity);

		stagedUADEntityImpl._companyId = this._companyId;
		stagedUADEntityImpl._createDate = this._createDate.clone();
		stagedUADEntityImpl._modifiedDate = this._modifiedDate.clone();
		stagedUADEntityImpl._uuid = this._uuid;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(StagedUADEntity.class);
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public void setCreateDate(Date date) {
		_createDate = date.clone();
	}

	@Override
	public void setModifiedDate(Date date) {
		_modifiedDate = date.clone()
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	@Override
	public String getUADEntityId() {
		return _uadEntity.getUADEntityId();
	}

	@Override
	public String getUADRegistryKey() {
		return _uadEntity.getUADRegistryKey();
	}

	@Override
	public long getUserId() {
		return _uadEntity.getUserId();
	}

	protected void populateUuid() {
	}

	private Date _createDate = new Date();
	private Date _modifiedDate = new Date();
	private String _uuid = PortalUUIDUtil.generate();
	private final UADEntity _uadEntity;
	private long _companyId;
}
