package com.rangga.elastic.elasticdata.utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpComponentPost {
	
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void sendToHttpPost(String request, String path) {
		
		url = "http://" + url + "/" + path;
		
		System.out.println(url);
		
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
			con.setDoOutput(true);
			con.setDoInput(true);
            con.setRequestMethod("POST");
            
            OutputStream os = con.getOutputStream();
            os.write(request.getBytes("UTF-8"));
            os.close();
            
            InputStream inn = new BufferedInputStream(con.getInputStream());
            
            inn.close();
            con.disconnect();
            
            System.out.println("Berhasil kirim request post");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Gagal");
			e.printStackTrace();
			System.out.println("Error Caused By: " + e.toString());
		}
		
	}

}
