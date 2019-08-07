package com.JavatoJsonObject;

public class CBRparamOption {

	private final String paramKey;

	private final String paramVal;

	public CBRparamOption(final String paramKey, final String paramVal) {

		this.paramKey = paramKey;
		this.paramVal = paramVal;
	}

	// public String getParamKey() {
	// return paramKey;
	// }
	//
	// public String getParamVal() {
	// return paramVal;
	// }
	//
	// public void setParamKey(final String paramKey) {
	// this.paramKey = paramKey;
	// }
	//
	// public void setParamVal(final String paramVal) {
	// this.paramVal = paramVal;
	// }

	@Override
	public String toString() {
		return "ClassPojo [paramKey = " + paramKey + ", paramVal = " + paramVal + "]";
	}

}
