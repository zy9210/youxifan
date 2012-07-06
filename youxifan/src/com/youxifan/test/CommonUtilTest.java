package com.youxifan.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Test;

import com.youxifan.utils.CommonUtil;

public class CommonUtilTest {

	@Test
    public void testUniqueNum() {
        System.out.println(CommonUtil.uniqueNum());
        try {
			System.out.println(new Integer("-1"));
		} catch (Exception e) {
			// TODO: handle exception
			
		}
    }
}
