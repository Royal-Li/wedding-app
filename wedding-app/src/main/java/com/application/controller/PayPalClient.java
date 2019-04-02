package com.application.controller;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class PayPalClient {

  /**
   *Set up the PayPal Java SDK environment with PayPal access credentials.  
   *This sample uses SandboxEnvironment. In production, use ProductionEnvironment.
   */
	//lzs
//  private PayPalEnvironment environment = new PayPalEnvironment.Sandbox(
//    "ASf-4wc2rurFmAE_egC9QGcPolbay5O8fXsQPq9uCccRGVbFlOCZAedptUtMhp5acu5EUD-lMCPnBnsF",
//    "ENMLkwDsK_A36dqDIf84MfRx9sv6u72FRd3bvOALQB-iE3XUXDs5UbMwlW97eZN-LazlvdcenhQsKhxi");
  //jerry
  private PayPalEnvironment environment = new PayPalEnvironment.Sandbox(
		    "AT60U99yQIV56k8BFcgw0UbDgP5TEdrrUBUojJvPd6Aimd6aU_WEng78hFw34FPIiXgoKY1htlX6yWPc",
		    "EFjJZnkV1o9GJaY_fPj7hJXWZhg1s5PZZXaE20yK1bbPCCfHzBNwP-HtzlAb1kOucY0CkMJM_BD-dTmA");

  /**
   *PayPal HTTP client instance with environment that has access
   *credentials context. Use to invoke PayPal APIs.
   */
  PayPalHttpClient client = new PayPalHttpClient(environment);

  /**
   *Method to get client object
   *
   *@return PayPalHttpClient client
   */
  public PayPalHttpClient client() {
    return this.client;
  }
}