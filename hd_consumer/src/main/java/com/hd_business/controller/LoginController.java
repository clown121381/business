package com.hd_business.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hd.common.cipher.Md5Utils;
import com.hd.common.utils.JsonUtils;
import com.hd.common.utils.TimeUtils;
import com.hd.entity.business.user.ResourcesTree;
import com.hd.entity.business.user.ResourcesTree.Attribute;
import com.hd_business.bean.SysResources;
import com.hd_business.bean.SysUserInfo;
import com.hd_business.service.LoginService;
import com.hd_business.service.SysResourcesService;

@Controller
@RequestMapping("/userLogin.do")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private SysResourcesService sysResourcesService;
	
	@RequestMapping(params="method=tologin")
	public String userLogin(){
		return "/system/login";
	}
	
	
	@RequestMapping(params="method=checkLogin")
	public void checkLoginController(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String authCode = request.getParameter("authCode");
		
		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
			HttpSession session = request.getSession();
			if(session.getAttribute("currentUser")!=null){
				out.write("true".getBytes());
			}
			if(authCode.equals(session.getAttribute("authCode"))){
				List<SysUserInfo> userList = loginService.checkUserInfo(username, Md5Utils.encrypt(password));
				if(!CollectionUtils.isEmpty(userList)){
					SysUserInfo currentUser = userList.get(0);
					if("Y".equals(currentUser.getStatus())){
						session.setAttribute("currentUser", currentUser);
						out.write("true".getBytes());
					}else{
						out.write("�û���ͣ��".getBytes("UTF-8"));
					}
				}else{
					out.write("��ǰ�û�������".getBytes("UTF-8"));
				}
			}else{
				out.write("��֤�����".getBytes("UTF-8"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping(params="method=doMain")
	public String doMain(HttpServletRequest request,HttpServletResponse reponse){
		//��ȡ��ǰ�û�
		HttpSession session = request.getSession();
		SysUserInfo currentUser = (SysUserInfo)session.getAttribute("currentUser");
		if(currentUser==null){
			return "/system/login";
		}
		
		String username = currentUser.getUserName();
		session.setAttribute("userName", username);
		//���㵱ǰ����
		String date = new SimpleDateFormat("yyyy��MM��dd��").format(new Date());
		session.setAttribute("newDate", date);
		//��������Ա�û�
		List<SysResources> resources = null;
		if("Y".equals(currentUser.getUserType())){
			resources = sysResourcesService.getAll();
		}else{
			resources = sysResourcesService.getResourcesByUserId(currentUser.getUserId());
		}
			if(resources!=null && resources.size()>0){
				List<ResourcesTree> resourcesTrees = new ArrayList<ResourcesTree>();
				for (SysResources resource : resources) {
					ResourcesTree tree = new ResourcesTree();
					BeanUtils.copyProperties(resource, tree);// ͬ�����ֶ�ֱ�Ӹ���
					tree.setId(resource.getResourcesCode());
					tree.setParentId(resource.getResourcesParent());
					tree.setText(resource.getResourcesName());
					Attribute attribute = new Attribute();
					tree.setAttributes(attribute);
					if(resource.getResourcesLink().startsWith("http")){
						attribute.setUrl(resource.getResourcesLink());
					}else{
						String contextPath = request.getContextPath();
						attribute.setUrl(contextPath+resource.getResourcesLink());
					}
					resourcesTrees.add(tree);
				}
				request.setAttribute("childResources", JsonUtils.toJson(resourcesTrees));
			request.setAttribute("userName",currentUser.getUserName());
			request.setAttribute("newDate",TimeUtils.convertDateToString(new Date(), TimeUtils.FORMAT8));
						
		}else{
			request.getSession().setAttribute("currentUser", null);
		}
		return "/system/main";
	}
	@RequestMapping(params = "method=logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if(session!=null){
			session.removeAttribute("hasUserInfo");
			session.removeAttribute("currentUser");
		}
		return "system/login";
	}
	
	@RequestMapping(params="method=getAuthCode")
	public void getAuthCodeController(HttpServletRequest request, HttpServletResponse response){
		int width = 60;
		int height = 20;
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�������
		Font font = new Font("Times New Roman", Font.PLAIN, 18);
		// �������塣
		g.setFont(font);
		// ���߿�
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, height - 1);
		// �������160�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽��
		g.setColor(Color.GRAY);

		// ����һ��������������ࡣ
		Random random = new Random();
		for (int i = 0; i < 160; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		StringBuffer authCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;
		// �������4λ���ֵ���֤�롣
		for (int i = 0; i < 4; i++) {
			// �õ������������֤�����֡�
			String rand = String.valueOf(random.nextInt(10));

			// �����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ��
			red = random.nextInt(110);
			green = random.nextInt(50);
			blue = random.nextInt(50);

			// �������������ɫ����֤����Ƶ�ͼ���С�
			g.setColor(new Color(red, green, blue));
			g.drawString(rand, 13 * i + 6, 16);

			// ���������ĸ�����������һ��
			authCode.append(rand);
		}

		// ����λ���ֵ���֤�뱣�浽Session�С�
		HttpSession session = request.getSession();

		// HttpSession session=getRequest().getSession();
		session.setAttribute("authCode", authCode.toString());

		// HttpServletResponse response = request.getHttpServletResponse();

		// ��ֹͼ�񻺴档
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		response.setContentType("image/jpeg");

		// ��ͼ�������Servlet������С�
		try {
			ServletOutputStream os = response.getOutputStream();
			ImageIO.write(buffImg, "jpeg", os);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
