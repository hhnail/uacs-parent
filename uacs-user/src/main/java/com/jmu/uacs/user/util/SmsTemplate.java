package com.jmu.uacs.user.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jmu.uacs.vo.response.AppResponse;

@Component
public class SmsTemplate {

	@Value("${sms.host}") // 读取application.properties配置文件中的值，自动装配赋值
	String host;

	@Value("${sms.path}")
	String path;

	@Value("${sms.method}")
	String method;

	@Value("${sms.appcode}")
	String appcode;// 你自己的AppCode

	public AppResponse<String> sendSms(Map<String, String> querys) {
		// host、path、method等提取为成员变量，通过配置文件读入
		Map<String, String> headers = new HashMap<String, String>();// 最后在header中的格式(中间是英文空格)为Authorization:APPCODE
		headers.put("Authorization", "APPCODE " + appcode);

		/*
		 * 这些内容后面传进来，而非写死 
		 * Map<String, String> querys = new HashMap<String, String>();
		 * querys.put("mobile", "18030290509"); querys.put("param", "code:2333");// 验证码
		 * querys.put("tpl_id", "TP1711063");// 短信模板
		 */
		Map<String, String> bodys = new HashMap<String, String>();
		try {
			HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
			System.out.println(response.toString());
			return AppResponse.ok(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return AppResponse.fail(null);
		}
	}
}
