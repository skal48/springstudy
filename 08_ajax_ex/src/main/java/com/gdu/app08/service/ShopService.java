package com.gdu.app08.service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

public interface ShopService {

  public String get(String apiUrl, Map<String, String> requestHeaders);
  public HttpURLConnection connect(String apiUrl);
  public String readBody(InputStream body);
  
}
