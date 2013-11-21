package com.yaya.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 退出SDK 清理环境
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class YayaExit implements FREFunction {

	private String TAG = "YayaExit";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		// TODO Auto-generated method stub
		//--------------------------------
		
		callBack("success");
		//--------------------------------
		
		return result;
	}

	public void callBack(String status){
		Log.d(TAG, "-------status----:"+status);
		_context.dispatchStatusEventAsync(TAG,status);
	}

}
