package com.shoppingmall.vo;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.shoppingmall.task.NaverLoginApi;


public class NaverLoginVO {
	
	private final static String CLIENT_ID = "RcWig0reR6rRlMvYhXT5";
	private final static String CLIENT_SECRET = "3LAN0aAmpp";
	private final static String REDIRECT_URI = "http://localhost:9090/callback/test";
	private final static String SESSION_STATE = "oauth_state";
	
	/* ?îÑÎ°úÌïÑ Ï°∞Ìöå API URL */
	private final static String PROFILE_API_URL = "https://openapi.naver.com/v1/nid/me";

	public String getAuthorizationUrl(HttpSession session) {
		
		String state = generateRandomString();
		
		setSession(session, state);
		
		OAuth20Service oauthService = new ServiceBuilder().apiKey(CLIENT_ID).apiSecret(CLIENT_SECRET)
				.callback(REDIRECT_URI).state(state) 
				.build(NaverLoginApi.instance());
		return oauthService.getAuthorizationUrl();
	}

	/* ?Ñ§?ù¥Î≤ÑÏïÑ?ù¥?îîÎ°? Callback Ï≤òÎ¶¨ Î∞? AccessToken ?öç?ìù Method */
	public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException {
		/* Callback?úºÎ°? ?†Ñ?ã¨Î∞õÏ? ?Ñ∏?Ñ†Í≤?Ï¶ùÏö© ?Çú?àòÍ∞íÍ≥º ?Ñ∏?Öò?óê ???û•?êò?ñ¥?ûà?äî Í∞íÏù¥ ?ùºÏπòÌïò?äîÏß? ?ôï?ù∏ */
		String sessionState = getSession(session);
		if (StringUtils.pathEquals(sessionState, state)) {
			OAuth20Service oauthService = new ServiceBuilder().apiKey(CLIENT_ID).apiSecret(CLIENT_SECRET)
					.callback(REDIRECT_URI).state(state).build(NaverLoginApi.instance());
			/* Scribe?óê?Ñú ?†úÍ≥µÌïò?äî AccessToken ?öç?ìù Í∏∞Îä•?úºÎ°? ?Ñ§?ïÑÎ°? Access Token?ùÑ ?öç?ìù */
			OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
			return accessToken;
		}
		return null;
	}

	
	private String generateRandomString() {
		return UUID.randomUUID().toString();
	}

	/* http session?óê ?ç∞?ù¥?Ñ∞ ???û• */
	private void setSession(HttpSession session, String state) {
		session.setAttribute(SESSION_STATE, state);
	}

	/* http session?óê?Ñú ?ç∞?ù¥?Ñ∞ Í∞??†∏?ò§Í∏? */
	private String getSession(HttpSession session) {
		return (String) session.getAttribute(SESSION_STATE);
	}

	/* Access Token?ùÑ ?ù¥?ö©?ïò?ó¨ ?Ñ§?ù¥Î≤? ?Ç¨?ö©?ûê ?îÑÎ°úÌïÑ APIÎ•? ?ò∏Ï∂? */
	public String getUserProfile(OAuth2AccessToken oauthToken) throws IOException {
		OAuth20Service oauthService = new ServiceBuilder().apiKey(CLIENT_ID).apiSecret(CLIENT_SECRET)
				.callback(REDIRECT_URI).build(NaverLoginApi.instance());
		OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
		oauthService.signRequest(oauthToken, request);
		Response response = request.send();
		return response.getBody();
	}

}
