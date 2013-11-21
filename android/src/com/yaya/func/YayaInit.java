package com.yaya.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.yayawanhorizontal.User;
import com.yayawanhorizontal.callback.YayaWan;
import com.yayawanhorizontal.callback.YayaWanOtherAcountCallback;

/**
 * 初始化SDK
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class YayaInit implements FREFunction {

	private String TAG = "YayaInit";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		// TODO Auto-generated method stub
		//--------------------------------
		starOtherAcount();
		callBack("success");
		//--------------------------------
		
		return result;
	}

	private void starOtherAcount() {//�л��˻�
		Log.v("MyTag", "login starLoginddd");
		YayaWan.OtherAcount(_context.getActivity(), new YayaWanOtherAcountCallback() {

			private static final long serialVersionUID = 8082863654145655537L;

			@Override
			public void onSuccess(User user, int loginType) {
				// TODO login success
				YayaLogin.starLogin(_context);
				
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
	
	public void callBack(String status){
		Log.d(TAG, "-------status----:"+status);
		_context.dispatchStatusEventAsync(TAG,status);
	}

}
