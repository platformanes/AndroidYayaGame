package com.yaya.func;

import android.util.Log;
import android.widget.Toast;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.yayawanhorizontal.User;
import com.yayawanhorizontal.animation.YayawanStartAnimationCallback;
import com.yayawanhorizontal.callback.YayaWan;

/**
 * @author Rect
 * @version  Time：2013-11-21 
 */
public class YayaAnime implements FREFunction {
	private String TAG = "YayaAnime";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		starAnimation();
		//--------------------------------
		return result;
	}
	
	private void starAnimation() {
		// TODO Auto-generated method stub
		YayaWan.animation(_context.getActivity(),new YayawanStartAnimationCallback() {

			private static final long serialVersionUID = 8082863654145655537L;

			@Override
			public void onCancel()
			{
				callBack("error Cancel");
			}

			@Override
			public void onError(int arg0) {
				// TODO Auto-generated method stub
				callBack("error animation");
			}

			@Override
			public void onSuccess(User paramUser, int paramInt) {
				// TODO Auto-generated method stub
				callBack("start animation");
			}
		});
	}
	
	public void callBack(String status){
		Log.d(TAG, "-------status----:"+status);
		_context.dispatchStatusEventAsync(TAG,status);
	}
}
