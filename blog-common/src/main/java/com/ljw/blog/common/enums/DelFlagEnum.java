package com.ljw.blog.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DelFlagEnum
 * @Description TODO(删除标识)
 */
public enum DelFlagEnum {
	
	/**正常**/
	DEL_FLAG_NORMAL("正常","0"),
	
	/**删除**/
	DEL_FLAG_DELETE("删除","1"),
	
	/**审核**/
	DEL_FLAG_AUDIT("审核","2");
	
	/** 枚举值 */
	private String value;

	/** 描述 */
	private String desc;

	
	private DelFlagEnum(String desc, String value) {
		this.value = value;
		this.desc = desc;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}
	

	public static DelFlagEnum getEnum(String value) {
		DelFlagEnum resultEnum = null;
		DelFlagEnum[] enumAry = DelFlagEnum.values();
		for (int i = 0; i < enumAry.length; i++) {
			if (enumAry[i].getValue() == value) {
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}

	public static Map<String, Map<String, Object>> toMap() {
		DelFlagEnum[] ary = DelFlagEnum.values();
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
		for (int num = 0; num < ary.length; num++) {
			Map<String, Object> map = new HashMap<String, Object>();
			String key = String.valueOf(getEnum(ary[num].getValue()));
			map.put("value", ary[num].getValue());
			map.put("desc", ary[num].getDesc());
			enumMap.put(key, map);
		}
		return enumMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List toList() {
		DelFlagEnum[] ary = DelFlagEnum.values();
		List list = new ArrayList();
		for (int i = 0; i < ary.length; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("value", ary[i].toString());
			map.put("desc", ary[i].getDesc());
			list.add(map);
		}
		return list;
	}
	
}
