package com.youxifan.test;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.util.Assert;
import org.springframework.web.util.HtmlUtils;

public class SpringToolsTest {

	public static void main(String[] args) {

/*
 * 
		断言方法 说明 
		notNull(Object object) 当 object 不为 null 时抛出异常，notNull(Object object, String message) 方法允许您通过 message 定制异常信息。
 		isNull(Object object)/isNull(Object object, String message)，它要求入参一定是 null； 
		isTrue(boolean expression) / isTrue(boolean expression, String message) 当 expression 不为 true 抛出异常； 
		notEmpty(Collection collection) / notEmpty(Collection collection, String message) 当集合未包含元素时抛出异常。
		notEmpty(Map map) / notEmpty(Map map, String message) 和 
		notEmpty(Object[] array, String message) / notEmpty(Object[] array, String message) 分别对 Map 和 Object[] 类型的入参进行判断； 
		hasLength(String text) / hasLength(String text, String message) 当 text 为 null 或长度为 0 时抛出异常； 
		hasText(String text) / hasText(String text, String message) text 不能为 null 且必须至少包含一个非空格的字符，否则抛出异常； 
		isInstanceOf(Class clazz, Object obj) / isInstanceOf(Class type, Object obj, String message) 如果 obj 不能被正确造型为 clazz 指定的类将抛出异常； 
		isAssignable(Class superType, Class subType) / isAssignable(Class superType, Class subType, String message) subType 必须可以按类型匹配于 superType，否则将抛出异常； 

*/		
		String specialStr = "&lt;div id=&quot;testDiv&quot;&gt;test1;test2&lt;/div&gt;"; 
		//common-lang  包里的
		
		String str0 = StringEscapeUtils.escapeHtml4(specialStr);
		System.out.println(str0);
		
		// spring 包里的
		
		String str1 = HtmlUtils.htmlEscape(specialStr);// ①转换为HTML转义字符表示 
		System.out.println(str1); 

		String str2 = HtmlUtils.htmlEscapeDecimal(specialStr);// ②转换为数据转义表示 
		System.out.println(str2); 

		String str3 = HtmlUtils.htmlEscapeHex(specialStr);// ③转换为十六进制数据转义表示 
		System.out.println(str3); 

		//④下面对转义后字符串进行反向操作 
		System.out.println(str1); 
		System.out.println(str2); 
		System.out.println(str3); 
		
		System.out.println(HtmlUtils.htmlUnescape(str1)); 
		System.out.println(HtmlUtils.htmlUnescape(str2)); 
		System.out.println(HtmlUtils.htmlUnescape(str3)); 
		
		
		String file = "";
		Assert.hasText(file,"file入参不是有效的文件地址");
	}
}
