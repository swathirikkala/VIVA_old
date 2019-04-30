package com.viva.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viva.dao.Response;
import com.viva.dao.UserDao;

public class ServiceUtil {

	public static <DTO, DAO> void callService(HttpServletRequest request, HttpServletResponse response, Class<DTO> dto,  Class<DAO> dao, String methodName) throws ServletException, IOException{
		try {
			System.out.println("....................... "+methodName+" Service Got Called.......................");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String json = "";
			if (bufferedReader != null) {
				json = bufferedReader.readLine();
			}
			System.out.println(methodName+" request JSON : " + json);
			DTO requestObject = JSONUtil.mapper.readValue(json, dto);
			String className = requestObject.getClass().getName();
			System.out.println("Request Object Class name :: " + className);
			Method method = dao.getDeclaredMethod(methodName, new Class[] {dto});
			Object obj = dao.newInstance();
			
			Response serviceResponse = (Response) method.invoke(obj, new Object[] {requestObject});
			System.out.println("serviceResponse  ::: " + serviceResponse);
			response.setContentType("application/json");
			JSONUtil.mapper.writeValue(response.getOutputStream(), serviceResponse);


		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
