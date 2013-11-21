package com.yaya.func;

import android.util.Log;
import android.widget.Toast;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.yayawanhorizontal.User;
import com.yayawanhorizontal.callback.YayaWan;
import com.yayawanhorizontal.callback.YayaWanCallback;

/**
 * @author Rect
 * @version  Time：2013-11-20 
 */
public class YayaMember implements FREFunction {
	private String TAG = "YayaMember";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		_context = context;
		FREObject result = null; 
		// TODO Auto-generated method stub
		starMember();
		callBack("finish");
		return result;
	}
	private void starMember() {
		// TODO Auto-generated method stub
		YayaWan.member(_context.getActivity(), new YayaWanCallback() {
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
	
	public void callBack(String status){
		Log.d(TAG, "-------status----:"+status);
		_context.dispatchStatusEventAsync(TAG,status);
	}

}
