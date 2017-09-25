package com.zhibeiyou.util.web;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 邮件发送工具类
 * 
 * @author wwd
 * @date   2016-8-28
 *
 */
public class EmailUtil {
	/**
	 * 邮件发送
	 * @author wwd
	 * @date   2016-8-28
	 * 
	 * @param smtp			smtp服务器
	 * @param from			发送者
	 * @param to			接收者
	 * @param copyto		抄送人	
	 * @param subject		邮件主题
	 * @param content		邮件内容
	 * @param username		用户名
	 * @param password		密码
	 * @return
	 */
	public static boolean send(String smtp, String from, String to,
			String copyto, String subject, String content, String username,
			String password) {
		MailInfo mail = new MailInfo(smtp);
		mail.setNeedAuth(true); // 验证
		if (!mail.setSubject(subject))
			return false;
		if (!mail.setBody(content))
			return false;
		if (!mail.setTo(to))
			return false;
		if (!mail.setCopyTo(copyto))
			return false;
		if (!mail.setFrom(from))
			return false;
		mail.setNamePass(username, password);
		if (!mail.send())
			return false;
		return true;
	}
	
//	public static void main(String[] args){
//		EmailUtil.send("smtp.126.com", "ugiant2011@126.com", "476189462@qq.com", "", "测试	", "好的", "ugiant2011@126.com", "ugiant@2011");
//	}
	
	static class MailInfo{
		private MimeMessage mimeMsg;
		private Session session;
		private Properties props;
		private String username;
		private String password;
		private Multipart mp;
		
		public MailInfo(String smtp) {
			setSmtpHost(smtp);
			createMimeMessage();
		}
		
		/**
		 * 设置smtp服务器
		 * @author wwd
		 * @date   2016-8-28
		 *
		 * @param hostName
		 */
		public void setSmtpHost(String hostName) {
			System.out.println("设置系统属性：mail.smtp.host=" + hostName);
			if (props == null) {
				props = System.getProperties();
			}
			props.put("mail.smtp.host", hostName);
		}
		
		/**
		 * 创建mime邮件对象
		 * @author wwd
		 * @date   2016-8-28
		 *
		 * @return
		 */
		public boolean createMimeMessage() {
			try {
				System.out.println("准备获取邮件会话对象！");
				session = Session.getDefaultInstance(props, null);
			} catch (Exception e) {
				System.out.println("获取邮件会话错误！" + e);
				return false;
			}
			System.out.println("准备创建MIME邮件对象！");
			try {
				mimeMsg = new MimeMessage(session);
				mp = new MimeMultipart();

				return true;
			} catch (Exception e) {
				System.out.println("创建MIME邮件对象失败！" + e);
				return false;
			}
		}
		
		/**
		 * 定义邮件主题
		 * @author wwd
		 * @date   2016-8-28
		 *
		 * @param mailSubject
		 * @return
		 */
		public boolean setSubject(String mailSubject) {
			System.out.println("定义邮件主题！");
			try {
				mimeMsg.setSubject(mailSubject);
				return true;
			} catch (Exception e) {
				System.err.println("定义邮件主题发生错误！");
				return false;
			}
		}

		/**
		 * 定义邮件正文
		 * @author wwd
		 * @date   2016-8-28
		 *
		 * @param mailBody
		 * @return
		 */
		public boolean setBody(String mailBody) {
			try {
				BodyPart bp = new MimeBodyPart();
				bp.setContent("" + mailBody, "text/html;charset=GBK");
				mp.addBodyPart(bp);
				return true;
			} catch (Exception e) {
				System.err.println("定义邮件正文时发生错误！" + e);
				return false;
			}
		}

		/**
		 * 设置发信人
		 * @author wwd
		 * @date   2016-8-28
		 *
		 * @param from
		 * @return
		 */
		public boolean setFrom(String from) {
			System.out.println("设置发信人！");
			try {
				mimeMsg.setFrom(new InternetAddress(from)); // 发信人
				return true;
			} catch (Exception e) {
				return false;
			}
		}

		/**
		 * 定义收信人
		 * @author wwd
		 * @date   2016-8-28
		 *
		 * @param to
		 * @return
		 */
		public boolean setTo(String to) {
			if (to == null)
				return false;
			System.out.println("定义收信人！");
			try {
				mimeMsg.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(to));
				return true;
			} catch (Exception e) {
				return false;
			}
		}

		/**
		 * 定义抄送人
		 * @author wwd
		 * @date   2016-8-28
		 *
		 * @param copyto
		 * @return
		 */
		public boolean setCopyTo(String copyto) {
			if (copyto == null)
				return false;
			try {
				mimeMsg.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(copyto));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		/**
		 * 定义SMTP是否需要验证
		 * @author wwd
		 * @date   2016-8-28
		 *
		 * @param need
		 */
		public void setNeedAuth(boolean need) {
			System.out.println("设置smtp身份认证：mail.smtp.auth = " + need);
			if (props == null)
				props = System.getProperties();
			if (need) {
				props.put("mail.smtp.auth", "true");
			} else {
				props.put("mail.smtp.auth", "false");
			}
		}
		/**
		 * 设置用户名密码
		 * @author wwd
		 * @date   2016-8-28
		 *
		 * @param name
		 * @param pass
		 */
		public void setNamePass(String name, String pass) {
			username = name;
			password = pass;
		}
		
		/**
		 * 邮件发送
		 * @author wwd
		 * @date   2016-8-28
		 *
		 * @return
		 */
		public boolean send() {
			try {
				mimeMsg.setContent(mp);
				mimeMsg.saveChanges();
				System.out.println("邮件发送中....");
				Session mailSession = Session.getInstance(props, null);
				Transport transport = mailSession.getTransport("smtp");
				transport.connect((String) props.get("mail.smtp.host"), username,
						password);
				transport.sendMessage(mimeMsg,
						mimeMsg.getRecipients(Message.RecipientType.TO));
				System.out.println("发送成功！");
				transport.close();
				return true;
			} catch (Exception e) {
				System.err.println("邮件失败！" + e);
				return false;
			}
		}
	}
}
