package com.CBRCount.ResourceList;

import java.util.HashMap;
import java.util.Map;

public class GetRequest {

	private static Map<String, String> RESOURCE = new HashMap<String, String>();

	static {
		//RESOURCE.put("OwnerAdddess", "/TGMSAdminRest/v1/cbrcount?ownerAddress=QA:EDI011211");
		RESOURCE.put("OwnerAdddess", "/TGMSAdminRest/v1/cbrcount?ownerAddress=QA:ACC16505");
		RESOURCE.put("OwnerUserId", "/TGMSAdminRest/v1/cbrcount?ownerUserID=AAC96783");
		RESOURCE.put("PartnerAddress", "/TGMSAdminRest/v1/cbrcount?partnerAddress=11:IWFAICHCNHUB");
		RESOURCE.put("PartnerUserId", "/TGMSAdminRest/v1/cbrcount?partnerUserID=AAD80799");
		RESOURCE.put("Invalid Direction",
				"TGMSAdminRest/v1/cbrcount?partnerAddress=11:IWFAICHCNHUB&ownerDirection=abc");
		RESOURCE.put("Invalid OwnerAddress", "/TGMSAdminRest/v1/cbrcount?ownerAddress=11:IWFAICH@@CNHUBQQ");
		RESOURCE.put("Invalid PartnerAddress", "/TGMSAdminRest/v1/cbrcount?partnerAddress=11:IWFAICHCNHUBQQ");
		RESOURCE.put("Valid_Owner_Invalid_Partner",
				"/TGMSAdminRest/v1/cbrcount?ownerAddress=QA:EDI041211&partnerAddress=QA:EDI01121111");
		RESOURCE.put("Invalid_Owner_PartnerAddresses",
				"/TGMSAdminRest/v1/cbrcount?partnerAddress=11:IWFAICHCNHUBQQ&ownerAddress=QA:EDI011211AA");
		RESOURCE.put("Partner_MaxCharAddress","/TGMSAdminRest/v1/cbrcount?partnerAddress=QA:EDIADDRESS_MAXIMUMCHARACTERCHECK");
        RESOURCE.put("OwnerAdress_SpecialCharacters","/TGMSAdminRest/v1/cbrcount?ownerAddress=$%#$##@1234&partnerAddress=QA:EDIADDRESS_MAXIMUMCHARACTERCHECK");
        RESOURCE.put("Invalid Owner_UserId","/TGMSAdminRest/v1/cbrcount?ownerUserID=AAC967831");
        RESOURCE.put("Invalid_Partner_UserId","/TGMSAdminRest/v1/cbrcount?ownerAddress=11:IWFAICHCNHUB&partnerAddress=21:IWFAICHCNHUB&partnerUserID=1453df45f4");
        RESOURCE.put("Valid_OwnerAndPartnerID_Invalid_OwnerAddress","/TGMSAdminRest/v1/cbrcount?ownerAddress=QA:EDI041211AAA&partnerAddress=QA:EDI011211"
        		+ "&ownerUserID=AAC96785&partnerUserID=AAC96783&ownerDirection=BOTH");
        		
	}

	public static String getResource(String key) {
		return RESOURCE.get(key);
	}

}
//QA:ACC16505