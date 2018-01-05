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

package com.liferay.user.associated.data.display;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.user.associated.data.entity.UADEntity;

import java.util.List;
import java.util.Map;

/**
 * @author William Newbury
 */
public abstract class BaseUADEntityDisplay implements UADEntityDisplay {

	@Override
	public abstract String getEditURL(UADEntity uadEntity);

	@Override
	public String getEntityNonAnonymizableFields(UADEntity uadEntity) {
		List<String> entityTypeNonAnonymizableFieldsList =
			getEntityTypeNonAnonymizableFieldsList();

		Map<String, Object> nonAnonymizableFieldsMap =
			uadEntity.getEntityNonAnonymizableFields(
				entityTypeNonAnonymizableFieldsList);

		if (nonAnonymizableFieldsMap == null) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(
			(nonAnonymizableFieldsMap.size() * 4) - 1);

		for (Map.Entry<String, Object> entry :
				nonAnonymizableFieldsMap.entrySet()) {

			sb.append(entry.getKey());
			sb.append(StringPool.COLON);
			sb.append(entry.getValue().toString());
			sb.append(StringPool.COMMA);
		}

		sb.setIndex(sb.index() - 1);

		return sb.toString();
	}

	@Override
	public abstract String getEntityTypeDescription();

	@Override
	public abstract String getEntityTypeName();

	@Override
	public String getEntityTypeNonAnonymizableFields() {
		List<String> entityTypeNonAnonymizableFieldsList =
			getEntityTypeNonAnonymizableFieldsList();

		StringBundler sb = new StringBundler(
			(entityTypeNonAnonymizableFieldsList.size() * 2) - 1);

		for (String field : entityTypeNonAnonymizableFieldsList) {
			sb.append(field);
			sb.append(StringPool.COMMA);
		}

		sb.setIndex(sb.index() - 1);

		return sb.toString();
	}

	@Override
	public abstract List<String> getEntityTypeNonAnonymizableFieldsList();

}