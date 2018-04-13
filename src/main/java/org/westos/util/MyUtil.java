package org.westos.util;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;
import org.westos.common.MyCommon;

public class MyUtil {
	public static final String pic_path = MyCommon.COMMON_LOCALPICPATH;

	public static void deleteNullPic(String oldpicName) {
		File oldFile = new File(pic_path + oldpicName);
		oldFile.delete();
	}

	public static String updatePic(MultipartFile oldpic, String oldpicName) {
		String originalFilename = oldpic.getOriginalFilename();
		if (oldpic != null && originalFilename != null && originalFilename.length() > 0) {
			// 删掉之前的照片
			MyUtil.deleteNullPic(oldpicName);
			// 新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			// 新图片
			File newFile = new File(pic_path + newFileName);
			try {
				oldpic.transferTo(newFile);
			} catch (Exception e) {

			}
			return newFileName;
		} else {
			return MyCommon.COMMON_PIC;
		}
	}

	public static String addNewPic(MultipartFile oldpic) {
		String originalFilename = oldpic.getOriginalFilename();
		if (oldpic != null && originalFilename != null && originalFilename.length() > 0) {
			// 新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			// 新图片
			File newFile = new File(pic_path + newFileName);
			try {
				oldpic.transferTo(newFile);
			} catch (Exception e) {

			}
			return newFileName;
		} else {
			return MyCommon.COMMON_NOPIC;
		}
	}
}
