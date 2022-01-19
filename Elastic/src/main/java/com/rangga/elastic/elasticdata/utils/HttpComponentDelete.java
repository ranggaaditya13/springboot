package com.rangga.elastic.elasticdata.utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpComponentDelete {
	
	private String url;
	
	public HttpComponentDelete() {
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
public void sendToHttpDelete(String index) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		String request = "";
		
		url = "http://" + url + "/" + index;
		
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("DELETE");
            
            InputStream inn = new BufferedInputStream(con.getInputStream());
            
            inn.close();
            con.disconnect();
            
            System.out.println("Berhasil kirim request delete");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Gagal");
			e.printStackTrace();
			System.out.println("Error Caused By: " + e.toString());
		}
		
	}

}
