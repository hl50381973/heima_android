package com.itheima.junit.test;

import com.itheima.junit.Calc;

import android.test.AndroidTestCase;

public class CalcTest extends AndroidTestCase {
	
	public void addTest(){
		//1.创建一个Calc对象
			Calc calc = new Calc();
		//2.调用add方法
			int result = calc.add(8, 2);
		//3.验证测试结果 ,断言，判断结果   ;  expected :期望的值，actual：实际的值
			assertEquals(10, result);
		
	}

}
