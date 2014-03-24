package com.fivehundredpx.api;

import android.util.Log;

import com.fivehundredpx.api.auth.AccessToken;
import com.kiumiu.ca.api500px.RESTTransport;
import com.kiumiu.ca.api500px.photo.photoInterface;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

/**
 * 500px API main class. This is where you should start everything. It is recommended to use getInstance method to create PxApi instance to guarantee 
 * a new instance of PxApi will be instantiated.
 */
public class PxApi {
    private static final String TAG = "ApiHelper";
    private static String HOST = "https://api.500px.com/v1";

    private AccessToken accessToken;
    private String consumerKey;
    private String consumerSecret;
    private RESTTransport transport;

    /**
     * Constructor for PxApi creation with access token
     * @param accessToken Access token obtained from 500px server.
     * @param consumerKey Your consumer key for 500px.
     * @param consumerSecret Your consumer secret for 500px.
     */
    public PxApi(AccessToken accessToken, String consumerKey,
            String consumerSecret) {
        super();
        this.accessToken = accessToken;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
    }

    /**
     * Constructor for PxApi creation without access token. A new instance of PxApi will be created every time this method is called.
     * @param consumerKey Your consumer key for 500px.
     * @param consumerSecret Your consumer secret for 500px.
     */
    public PxApi(String consumerKey, String consumerSecret) {
        super();
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
    }
    
    /**
     * Method for PxApi creation in convenience with accessToken. A new instance of PxApi will be created every time this method is called.
     * @param accessToken Access token obtained from 500px server.
     * @param consumerKey Your consumer key for 500px.
     * @param consumerSecret Your consumer secret for 500px.
     */
    public static PxApi getInstance(AccessToken accessToken, String consumerKey,
            String consumerSecret) {
    	return new PxApi(accessToken, consumerKey, consumerSecret);
    }
    
    /**
     * Method for PxApi creation in convenience without accessToken
     * @param consumerKey Your consumer key for 500px.
     * @param consumerSecret Your consumer secret for 500px.
     */
    public static PxApi getInstance(String consumerKey, String consumerSecret) {
    	return new PxApi(consumerKey, consumerSecret);
    }
 
    public photoInterface getPhotoInterface() {
    	if(accessToken != null)
    		return new photoInterface(accessToken, consumerKey, consumerKey);
    	else
    		return new photoInterface(consumerKey, consumerKey);
    }

}
