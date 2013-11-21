package com.yaya.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.yayawanhorizontal.User;
import com.yayawanhorizontal.callback.YayaWan;
import com.yayawanhorizontal.callback.YayaWanCallback;

/**
 * 执行登录
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class YayaLogin implements FREFunction {

	private static String TAG = "YayaLogin";
	private static FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null;  
		// TODO Auto-generated method stub
		//--------------------------------
		starLogin(_context);
		
		callBack("success");
		//--------------------------------
		
		return result;
	}

	public static void starLogin(FREContext ctx) {
		Log.v("MyTag", "login starLoginddd");
		YayaWan.login(ctx.getActivity(), new YayaWanCallback() {

			private static final long serialVersionUID = 8082863654145655537L;

			@Override
			public void onSuccess(User user, int loginType) {
				// TODO login success								
				Log.v("username", user.getUserName());				
				Log.v("uid", " " +user.getUid());				
				Log.v("token", " " +user.getToken());							
				
				String str = "login*"+user.getUserName()+"*"+user.getUid()+"*"+user.getToken();
				callBack(str);
			}

			@Override
			public void onError(int loginType) {
				callBack("login failure");
			}
			
			@Override
			public void onCancel()
			{
				callBack("login Cancel");
			}
		});
	}
	private  static void callBack(String status){
		Log.d(TAG, "-------status----:"+status);
		_context.dispatchStatusEventAsync(TAG,status);
	}
}
