package com.yaya.ane;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.yaya.func.YayaAnime;
import com.yaya.func.YayaExit;
import com.yaya.func.YayaInit;
import com.yaya.func.YayaLogin;
import com.yaya.func.YayaMember;
import com.yaya.func.YayaPay;

/**
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class YayaContext extends FREContext {
	/**
	 * INIT sdk
	 */
	public static final String YAYA_FUNCTION_INIT = "yaya_function_init";
	/**
	 * 登录Key
	 */
	public static final String YAYA_FUNCTION_LOGIN = "yaya_function_login";
	/**
	 * 付费Key
	 */
	public static final String YAYA_FUNCTION_PAY = "yaya_function_pay";
	/**
	 * 退出Key
	 */
	public static final String YAYA_FUNCTION_EXIT = "yaya_function_exit";
	
	public static final String YAYA_FUNCTION_MEMBER = "yaya_function_member";
	
	public static final String YAYA_FUNCTION_ANIME = "yaya_function_anime";
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		// TODO Auto-generated method stub
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
//	       //映射
		   map.put(YAYA_FUNCTION_INIT, new YayaInit());
	       map.put(YAYA_FUNCTION_LOGIN, new YayaLogin());
	       map.put(YAYA_FUNCTION_PAY, new YayaPay());
	       map.put(YAYA_FUNCTION_MEMBER, new YayaMember());
	       map.put(YAYA_FUNCTION_ANIME, new YayaAnime());
	       map.put(YAYA_FUNCTION_EXIT, new YayaExit());
	       return map;
	}

}
