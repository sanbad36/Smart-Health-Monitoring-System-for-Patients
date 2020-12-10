package com.arduino;
import java.net.*; 
public class SendSMS
{
	public static void SMS(String id, String mob)
	{
		System.out.println("Calling SMS");
		try {
			String apikey = "v5Ksds3Ue0qUPtEVmWEpAA";
			String senderid = "SMSTST";
			String channel = "2";
			String DCS = "0";
			String flashsms = "0";
			String mobile = mob;
			String message = "Patient/Bed/Kit No. "+id+" is at risk..!!";
			String route = "1";
			System.out.println("Mobile : "+mobile);
			System.out.println("Message : "+message);
			 
			String requestUrl = "https://www.smsgatewayhub.com/api/mt/SendSMS?" + "APIKey=" + URLEncoder.encode(apikey, "UTF-8") + "&senderid=" + URLEncoder.encode(senderid, "UTF-8") + "&channel=" + URLEncoder.encode(channel, "UTF-8") + "&DCS=" + URLEncoder.encode(DCS, "UTF-8") + "&flashsms=" + URLEncoder.encode(flashsms, "UTF-8") + "&number=" + URLEncoder.encode(mobile, "UTF-8") + "&text=" + URLEncoder.encode(message, "UTF-8") + "&route=" + URLEncoder.encode(route, "UTF-8");
			System.out.println("Requesting URL");
			URL url = new URL(requestUrl);
			HttpURLConnection uc = (HttpURLConnection)url.openConnection();
			System.out.println("Getting response");
			System.out.println(uc.getResponseMessage());
			System.out.println("SMS Send");
			uc.disconnect();
			 
			} catch(Exception ex) {
			System.out.println(ex.getMessage());
			}
	}
}
