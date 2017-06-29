package com.mjiayou.trejava.temp.test.skintest;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.aijifu.cefubao.core.api.ComputeCallback;
import com.aijifu.cefubao.core.api.ComputeManager;
import com.aijifu.cefubao.core.api.ComputeRet;
import com.aijifu.cefubao.core.bean.LandmarkResult;
import com.aijifu.cefubao.core.bean.SkinData;
import com.aijifu.cefubao.core.util.ComUtils;
import com.aijifu.cefubao.core.util.GsonUtil;

public class SkinTestDemo {
	// public static final String DIR_IMG_PATH = "/Users/treason/Downloads/img/";
		public static final String DIR_IMG_PATH = "src/img/";

		private static BufferedImage mOriginImage;
		private static float mBrightness;
		private static int mAge;
		private static int mGender;
		private static LandmarkResult mLandmarkResult;

		public static void main(String[] a) {

			try {
				// //////////////////// 准备工作
				mOriginImage = ImageIO.read(SkinTestDemo.class.getResourceAsStream("/img/input_origin.jpg"));
				mBrightness = 1.8f;
				mAge = 20;
				mGender = 0;
				// landmark
				String landmarkString = "{\"result\":[{\"face_id\":\"6eb4900d045c9af732859764288869cd\",\"landmark\":{\"contour_chin\":{\"x\":51.223778,\"y\":81.702833},\"contour_left1\":{\"x\":25.440889,\"y\":51.097833},\"contour_left2\":{\"x\":25.96,\"y\":55.559167},\"contour_left3\":{\"x\":26.636444,\"y\":59.752},\"contour_left4\":{\"x\":28.528889,\"y\":64.231167},\"contour_left5\":{\"x\":29.837556,\"y\":68.188},\"contour_left6\":{\"x\":32.307778,\"y\":71.857333},\"contour_left7\":{\"x\":35.029111,\"y\":75.8265},\"contour_left8\":{\"x\":39.186,\"y\":78.967333},\"contour_left9\":{\"x\":43.948444,\"y\":81.240333},\"contour_right1\":{\"x\":77.638889,\"y\":50.1205},\"contour_right2\":{\"x\":77.444,\"y\":54.612167},\"contour_right3\":{\"x\":76.653111,\"y\":59.5275},\"contour_right4\":{\"x\":75.745111,\"y\":64.254667},\"contour_right5\":{\"x\":74.325333,\"y\":68.6455},\"contour_right6\":{\"x\":71.462222,\"y\":72.850833},\"contour_right7\":{\"x\":67.533556,\"y\":76.021833},\"contour_right8\":{\"x\":62.880222,\"y\":78.849667},\"contour_right9\":{\"x\":57.750444,\"y\":80.869333},\"left_eye_bottom\":{\"x\":37.186,\"y\":52.420667},\"left_eye_center\":{\"x\":37.184444,\"y\":50.984},\"left_eye_left_corner\":{\"x\":32.548889,\"y\":50.847833},\"left_eye_lower_left_quarter\":{\"x\":34.278667,\"y\":51.947167},\"left_eye_lower_right_quarter\":{\"x\":39.506667,\"y\":52.048833},\"left_eye_pupil\":{\"x\":38.173333,\"y\":50.826667},\"left_eye_right_corner\":{\"x\":42.806222,\"y\":51.806333},\"left_eye_top\":{\"x\":37.548,\"y\":49.5575},\"left_eye_upper_left_quarter\":{\"x\":34.668222,\"y\":49.893333},\"left_eye_upper_right_quarter\":{\"x\":39.919333,\"y\":50.0365},\"left_eyebrow_left_corner\":{\"x\":29.378667,\"y\":46.0495},\"left_eyebrow_lower_left_quarter\":{\"x\":32.624667,\"y\":45.031833},\"left_eyebrow_lower_middle\":{\"x\":36.301333,\"y\":44.870667},\"left_eyebrow_lower_right_quarter\":{\"x\":39.863333,\"y\":45.114833},\"left_eyebrow_right_corner\":{\"x\":43.896,\"y\":45.196667},\"left_eyebrow_upper_left_quarter\":{\"x\":31.737778,\"y\":43.026},\"left_eyebrow_upper_middle\":{\"x\":36.237111,\"y\":42.464333},\"left_eyebrow_upper_right_quarter\":{\"x\":39.996444,\"y\":42.892667},\"mouth_left_corner\":{\"x\":42.222222,\"y\":70.850167},\"mouth_lower_lip_bottom\":{\"x\":49.690667,\"y\":72.376167},\"mouth_lower_lip_left_contour1\":{\"x\":46.111333,\"y\":70.002},\"mouth_lower_lip_left_contour2\":{\"x\":44.309333,\"y\":71.642167},\"mouth_lower_lip_left_contour3\":{\"x\":46.846889,\"y\":72.206167},\"mouth_lower_lip_right_contour1\":{\"x\":53.817556,\"y\":69.7},\"mouth_lower_lip_right_contour2\":{\"x\":55.863556,\"y\":71.048833},\"mouth_lower_lip_right_contour3\":{\"x\":52.469556,\"y\":71.9765},\"mouth_lower_lip_top\":{\"x\":49.494,\"y\":69.627},\"mouth_right_corner\":{\"x\":58.239111,\"y\":69.888333},\"mouth_upper_lip_bottom\":{\"x\":49.721556,\"y\":69.226167},\"mouth_upper_lip_left_contour1\":{\"x\":47.369778,\"y\":67.2505},\"mouth_upper_lip_left_contour2\":{\"x\":44.290889,\"y\":68.961833},\"mouth_upper_lip_left_contour3\":{\"x\":46.390444,\"y\":69.513667},\"mouth_upper_lip_right_contour1\":{\"x\":51.465111,\"y\":66.897667},\"mouth_upper_lip_right_contour2\":{\"x\":55.440444,\"y\":68.133},\"mouth_upper_lip_right_contour3\":{\"x\":54.111556,\"y\":69.273167},\"mouth_upper_lip_top\":{\"x\":49.587556,\"y\":67.4295},\"nose_contour_left1\":{\"x\":46.007556,\"y\":51.225667},\"nose_contour_left2\":{\"x\":43.614,\"y\":58.714667},\"nose_contour_left3\":{\"x\":46.047778,\"y\":63.238667},\"nose_contour_lower_middle\":{\"x\":49.560444,\"y\":62.9835},\"nose_contour_right1\":{\"x\":52.150222,\"y\":50.9145},\"nose_contour_right2\":{\"x\":54.428889,\"y\":57.9385},\"nose_contour_right3\":{\"x\":53.495778,\"y\":63.196833},\"nose_left\":{\"x\":42.241333,\"y\":62.1615},\"nose_right\":{\"x\":56.952889,\"y\":61.9295},\"nose_tip\":{\"x\":48.401778,\"y\":58.9295},\"right_eye_bottom\":{\"x\":62.310222,\"y\":51.614},\"right_eye_center\":{\"x\":62.115778,\"y\":50.1485},\"right_eye_left_corner\":{\"x\":56.790444,\"y\":51.004667},\"right_eye_lower_left_quarter\":{\"x\":59.370444,\"y\":51.345833},\"right_eye_lower_right_quarter\":{\"x\":65.417778,\"y\":50.965667},\"right_eye_pupil\":{\"x\":62.044444,\"y\":50.000167},\"right_eye_right_corner\":{\"x\":66.835333,\"y\":50.103667},\"right_eye_top\":{\"x\":61.820667,\"y\":48.828},\"right_eye_upper_left_quarter\":{\"x\":59.184,\"y\":49.112},\"right_eye_upper_right_quarter\":{\"x\":64.591333,\"y\":49.025667},\"right_eyebrow_left_corner\":{\"x\":55.535556,\"y\":44.012667},\"right_eyebrow_lower_left_quarter\":{\"x\":60.335778,\"y\":44.088833},\"right_eyebrow_lower_middle\":{\"x\":64.408667,\"y\":43.612},\"right_eyebrow_lower_right_quarter\":{\"x\":68.303778,\"y\":43.607833},\"right_eyebrow_right_corner\":{\"x\":71.402,\"y\":44.678667},\"right_eyebrow_upper_left_quarter\":{\"x\":59.922667,\"y\":41.622667},\"right_eyebrow_upper_middle\":{\"x\":64.018,\"y\":40.797333},\"right_eyebrow_upper_right_quarter\":{\"x\":68.756889,\"y\":41.725833}}}],\"session_id\":\"30763ec7732147538bc9f7a66c4175ad\"}";
				System.out.println("landmarkString=" + landmarkString);
				mLandmarkResult = GsonUtil.get().fromJson(landmarkString, LandmarkResult.class);

				// //////////////////// 开始调用
				// 构建计算对象
				ComputeManager computeManager = new ComputeManager(mOriginImage, mBrightness, mLandmarkResult, mAge, mGender);
				// 设置回调
				computeManager.setComputeCallback(new ComputeCallback() {
					@Override
					public void onComplete(ComputeRet ret, SkinData data) {
						if (ret == ComputeRet.SUCCESSED) {
							// 保存图片
							ComUtils.savaImage(data.getFaceRight().getOrigin().getImg(), DIR_IMG_PATH, "output_face_right_origin.jpg");
							ComUtils.savaImage(data.getFaceRight().getColor().getImg(), DIR_IMG_PATH, "output_face_right_color.jpg");
							ComUtils.savaImage(data.getFaceRight().getMoisture().getImg(), DIR_IMG_PATH, "output_face_right_moisture.jpg");
							ComUtils.savaImage(data.getFaceRight().getUniformity().getImg(), DIR_IMG_PATH, "output_face_right_uniformity.jpg");
							ComUtils.savaImage(data.getFaceRight().getHoles().getImg(), DIR_IMG_PATH, "output_face_right_holes.jpg");
							ComUtils.savaImage(data.getFaceRight().getMicrogroove().getImg(), DIR_IMG_PATH, "output_face_right_microgroove.jpg");
							ComUtils.savaImage(data.getFaceRight().getStain().getImg(), DIR_IMG_PATH, "output_face_right_stain.jpg");
							System.out.println("\n图片保存成功");

							// 展示结果
							StringBuilder builder = new StringBuilder();
							builder.append("\n计算完成：");
							builder.append("\n总分：" + data.getTotleScore());
							builder.append("\n肌肤年龄：" + data.getSkinAge());
							builder.append("\n性别：" + data.getGender());
							builder.append("\n右面颊分数：" + data.getFaceRight().getOrigin().getScore());
							builder.append("\n左面颊分数：" + data.getFaceLeft().getOrigin().getScore());
							builder.append("\n额头分数：" + data.getHead().getOrigin().getScore());
							builder.append("\n下巴分数：" + data.getJaw().getOrigin().getScore());
							builder.append("\nT型区分数：" + data.getPartT().getOrigin().getScore());
							System.out.println(builder.toString());
						} else if (ret == ComputeRet.FAILED_FACE) {
							System.out.println("\n面部信息获取失败，建议重新拍照获取");
						} else if (ret == ComputeRet.FAILED_NETWORK) {
							System.out.println("\n网络异常");
						} else if (ret == ComputeRet.FAILED_OOM) {
							System.out.println("\n内存溢出");
						} else if (ret == ComputeRet.FAILED_DATA) {
							System.out.println("\n数据异常");
						}
					}

					@Override
					public void onProcess(int process, int processCount, String hint) {
						StringBuilder builder = new StringBuilder();
						builder.append("\n正在计算：");
						builder.append("\n步骤：" + process + "/" + processCount);
						builder.append("\n当前：" + hint);
						System.out.println(builder.toString());
					}
				});
				// 执行计算操作
				computeManager.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
