package com.JavatoJsonObject;

import java.util.List;

public class Cbrvo {

	private String doctype;

	List<CBRparamOption> cbrparamOption;

	private String triggeringNode;

	private String serviceEndPoint;

	private String additionalMetaData;

	private String receiveraddress;

	private String eventType;

	private String senderaddress;

	private String processingOrder;

	private String timeOut;

	public String getAdditionalMetaData() {
		return additionalMetaData;
	}

	public List<CBRparamOption> getCbrparamOption() {
		return cbrparamOption;
	}

	public String getDoctype() {
		return doctype;
	}

	public String getEventType() {
		return eventType;
	}

	public String getProcessingOrder() {
		return processingOrder;
	}

	public String getReceiveraddress() {
		return receiveraddress;
	}

	public String getSenderaddress() {
		return senderaddress;
	}

	public String getServiceEndPoint() {
		return serviceEndPoint;
	}

	public String getTimeOut() {
		return timeOut;
	}

	public String getTriggeringNode() {
		return triggeringNode;
	}

	public void setAdditionalMetaData(final String additionalMetaData) {
		this.additionalMetaData = additionalMetaData;
	}

	public void setCbrparamOption(final List<CBRparamOption> cbrparamOption) {
		this.cbrparamOption = cbrparamOption;
	}

	public void setDoctype(final String doctype) {
		this.doctype = doctype;
	}

	public void setEventType(final String eventType) {
		this.eventType = eventType;
	}

	public void setProcessingOrder(final String processingOrder) {
		this.processingOrder = processingOrder;
	}

	public void setReceiveraddress(final String receiveraddress) {
		this.receiveraddress = receiveraddress;
	}

	public void setSenderaddress(final String senderaddress) {
		this.senderaddress = senderaddress;
	}

	public void setServiceEndPoint(final String serviceEndPoint) {
		this.serviceEndPoint = serviceEndPoint;
	}

	public void setTimeOut(final String timeOut) {
		this.timeOut = timeOut;
	}

	public void setTriggeringNode(final String triggeringNode) {
		this.triggeringNode = triggeringNode;
	}

	@Override
	public String toString() {
		return "Cbrvo [doctype=" + doctype + ", cbrparamOption=" + cbrparamOption + ", triggeringNode=" + triggeringNode
				+ ", serviceEndPoint=" + serviceEndPoint + ", additionalMetaData=" + additionalMetaData
				+ ", receiveraddress=" + receiveraddress + ", eventType=" + eventType + ", senderaddress="
				+ senderaddress + ", processingOrder=" + processingOrder + ", timeOut=" + timeOut + "]";
	}

}
