package com.yaya.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.yayawanhorizontal.Order;
import com.yayawanhorizontal.User;
import com.yayawanhorizontal.callback.YayaWan;
import com.yayawanhorizontal.callback.YayaWanPaymentCallback;

/**
 * 执行付费
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class YayaPay implements FREFunction {

	private String TAG = "YayaPay";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		String order = null;
		int money = 1000;
		int ment = 0;
		String ext = "text#ddd#fff";
		// TODO Auto-generated method stub
		//--------------------------------
		try
		{
			order = arg1[0].getAsString();
			money = arg1[1].getAsInt();
			ment = arg1[2].getAsInt();
			ext  =arg1[3].getAsString();
			
			callBack("arg:"+order+"-"+money+"-"+ment+"-"+ext);
			
			Order _order = new Order(order, (long)money, ment, ext);
			starPay(_order);
		}
		catch (Exception e) {
			// TODO: handle exception
			callBack("YayaPay argv is err");
			return null;
		}
		callBack("success");
		//--------------------------------

		return result;
	}

	private void starPay(Order order) {

		Log.v("MyTag", "starPay starLoginddd");		
//		Order order = new Order("2011002345", (long)5000 , 0, "text#ddd#fff");
		YayaWan.payment(_context.getActivity(), order, new YayaWanPaymentCallback() {
			private static final long serialVersionUID = 5741482599550632651L;
			@Override
			public void onSuccess(User paramUser, Order paramOrder,int paramInt) {
				callBack("pay success");
			}

			@Override
			public void onError(int paramInt) {		
				callBack("pay failure");
			}

			@Override
			public void onCancel() {			
				callBack("pay Cancel");
			}
		});
	}

	public void callBack(String status){
		Log.d(TAG, "-------status----:"+status);
		_context.dispatchStatusEventAsync(TAG,status);
	}
}
