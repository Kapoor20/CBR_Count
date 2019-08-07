package com.CBRCount.Utilities;

import java.util.HashMap;
import java.util.Map;

public class DBQueryList {

	private static Map<String, String> RESOURCE = new HashMap<String, String>();

	static {
		//RESOURCE.put("OwnerAdddess", "select count(*) as count from TP_Data_Routing_Detail where SENDERADDRREF='3752177' or RECEIVERADDRREF='3752177'");
		RESOURCE.put("OwnerAdddess", "select count(*) as count from TP_Data_Routing_Detail where SENDERADDRREF='3731315' or RECEIVERADDRREF='3731315'");
		RESOURCE.put("OwnerUserId", "select count(*) as count from TP_Data_Routing_Detail where Receiveruserno='10110783' or Senderuserno='10110783'");
		RESOURCE.put("PartnerAddress","select count(*) as count from TP_Data_Routing_Detail WHERE receiveraddrref=2305045 or senderaddrref=2305045");
		RESOURCE.put("PartnerUserId", "select count(*) as count from TP_Data_Routing_Detail WHERE SENDERUSERNO=12042799 or RECEIVERUSERNO=12042799");
        RESOURCE.put("Partner_MaxCharAddress","select count(*) as count from TP_Data_Routing_Detail WHERE receiveraddrref=3755162 or senderaddrref=3755162");
        
	}

	public static String getQuery(String key) {
		return RESOURCE.get(key);
	}

}
//select count(*) as count from TP_Data_Routing_Detail where SENDERADDRREF='3752213' or RECEIVERADDRREF='3752213'
//3731315