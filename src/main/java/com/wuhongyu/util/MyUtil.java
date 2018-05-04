package com.wuhongyu.util;

import com.github.pagehelper.PageInfo;
import com.wuhongyu.common.MyCommon;
import com.wuhongyu.entity.MyPage;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

/**
 * 我的封装用的是真的好呀 ,,,哈哈哈哈哈哈
 * @author Administrator
 *
 */
public class MyUtil {
	
	//得到一个有url的page
	public static <T> MyPage<T> getPage(List<T> tList,HttpServletRequest request) {
		MyPage<T> page = new MyPage<T>(new PageInfo<T>(tList));
		String url = MyUtil.getUrl(request);
		page.setUrl(url);
		return page;
	}
	
	//截取url字符串,把pageNum干掉
	public static String getUrl(HttpServletRequest request) {
		String servletPath = request.getServletPath();
		String contextPath = request.getContextPath();
		String queryString = request.getQueryString();
		System.out.println(queryString);
		if(MyUtil.notEmpty(queryString)) {
			if(queryString.indexOf("&pageNum")>0){
				int indexOf = queryString.indexOf("&pageNum");
				queryString = queryString.substring(0,indexOf);
			}
			return contextPath+servletPath+"?"+queryString;
		}else {
			return contextPath+servletPath+"?1=1";
		}
		
	}

	//判断非空字符串
	public static boolean notEmpty(String string) {
		if(string !=null && !"".equals(string.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	// MD5加密
		public static String encryptMD5(String str) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] byteArray = md.digest(str.getBytes());
				BigInteger bi = new BigInteger(1, byteArray);
				return bi.toString(16);
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException();
			}
		}

		// 分页
		public static Integer getCurrentPage(Integer currentPage) {
			if (currentPage == null || currentPage <= 0) {
				currentPage = 1;
			}
			return currentPage;
		}


	public static void deleteNullPic(String oldpicName) {
		File oldFile = new File(MyCommon.FILEPATH + oldpicName);
		if(oldFile.isFile()){
			oldFile.delete();
		}
	}

	public static String updatePic(MultipartFile oldpic, String oldpicName) {
		String originalFilename = oldpic.getOriginalFilename();
		if (oldpic != null && originalFilename != null && originalFilename.length() > 0) {
			// 删掉之前的照片
			MyUtil.deleteNullPic(oldpicName);
			// 新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			// 新图片
			File newFile = new File(MyCommon.FILEPATH + newFileName);
			try {
				oldpic.transferTo(newFile);
			} catch (Exception e) {

			}
			return newFileName;
		} else {
			return null;
		}
	}

	public static String addNewPic(MultipartFile oldpic) {
		String originalFilename = oldpic.getOriginalFilename();
		if (oldpic != null && originalFilename != null && originalFilename.length() > 0) {
			// 新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			// 新图片
			File newFile = new File(MyCommon.FILEPATH + newFileName);
			try {
				oldpic.transferTo(newFile);
			} catch (Exception e) {

			}
			return newFileName;
		} else {
			return null;
		}
	}
}
