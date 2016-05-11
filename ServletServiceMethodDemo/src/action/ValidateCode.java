package action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="validateCode",value="/validateCode")
public class ValidateCode extends HttpServlet {
    public ValidateCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-type", "image/jpeg; charset=UTF-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -1);
		OutputStream outputStream = response.getOutputStream();
		BufferedImage image = new BufferedImage(83, 35, BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		Color color=g.getColor();
		g.fillRect(0, 0, 83, 35);
		char[]ch="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		int length=ch.length;
		Random random=new Random();
		Font[] font=new Font[5];
		font[0]=new Font("Ravie", Font.PLAIN, 24);	//24Ϊ�����ϸ
		font[1]=new Font("Autique Olive Compact", Font.PLAIN, 24);
		font[2]=new Font("Forte", Font.PLAIN, 24);
		font[3]=new Font("Wide Latin", Font.PLAIN, 24);
		font[4]=new Font("Gill Sans Ultra Bold", Font.PLAIN, 24);
		Font nowFont=font[random.nextInt(5)];
		for(int i=0;i<4;i++)
		{
			//�����������ʽ
			g.setFont(nowFont);
			String rand=new Character(ch[random.nextInt(length)]).toString();
			g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			g.drawString(rand, 20*i+6, 25);
		}
		//������
		for(int i=0;i<100;i++)	//100Ϊ�����ߵ�����
		{
			int x1=random.nextInt(83);
			int y1=random.nextInt(35);
			g.drawOval(x1, y1, 1, 3);	//1,3Ϊ�����ߵĳ���
		}
		g.setColor(color);
		g.dispose();
		ImageIO.write(image, "JPEG", outputStream);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
