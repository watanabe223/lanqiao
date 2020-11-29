import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	int x=120;
	int y=100;//定义hero的x,y坐标
	int flag;

	//Image leftImg,rightImg,upImg,downImg;
	Image heroImg[][]=new Image[4][3];//重新声明hero的图片
	Image currentImg;
	public MainCanvas(){
		try{
			/*
			赋值给图片
			*/

		
		
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
					/*给hero的图片赋值（图片要重命名）
					左0，右1，,上2，下3
					*/
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			/*
			for(int i=0;i<3;i++){
				leftImg=Image.createImage("/sayo"+i+"2.png");
				rightImg=Image.createImage("/sayo"+i+"4.png");
				upImg=Image.createImage("/sayo"+i+"6.png");
				downImg=Image.createImage("/sayo"+i+"0.png");
				}

			img=Image.createImage("/sayo10.png");
			img1=Image.createImage("/sayo12.png");
			img2=Image.createImage("/sayo14.png");
			img3=Image.createImage("/sayo16.png");
			//让hero走路更逼真的图片下
			img4=Image.createImage("/sayo00.png");
			img5=Image.createImage("/sayo20.png");
			//左
			img6=Image.createImage("/sayo02.png");
			img7=Image.createImage("/sayo22.png");
			//上
			img8=Image.createImage("/sayo04.png");
			img9=Image.createImage("/sayo24.png");
			//右
			img10=Image.createImage("/sayo06.png");
			img11=Image.createImage("/sayo26.png");
			
			*/
			
			currentImg=heroImg[3][1];
			flag=0;
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(50,200,80);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		//让hero转左转
		if(action==LEFT){
			changePicAndDirection(0);

			/*if(leftFlag==0){
				currentImg=heroImg[0][0];
				leftFlag++;
			}
				else if(leftFlag==1){
					currentImg=heroImg[0][2];
					leftFlag--;
				}*/

			x-=5;
			System.out.println("向左转");
		}

		//向右转
		if(action==RIGHT){
			changePicAndDirection(1);
			/*if(rightFlag==0){
				currentImg=heroImg[1][0];
				rightFlag++;
			}
				else if(rightFlag==1){
					currentImg=heroImg[1][2];
					rightFlag--;
				}*/
			x+=5;
			System.out.println("向右转");
		}

		//向上转
		if(action==UP){
			changePicAndDirection(2);
			/*if(upFlag==0){
				currentImg=heroImg[2][0];
				upFlag++;
			}
				else if(upFlag==1){
					currentImg=heroImg[2][2];
					upFlag--;
				}*/
			y-=5;
			System.out.println("向上转");
		}

		//向下转
		if(action==DOWN){
			changePicAndDirection(3);
			/*if(downFlag==0){
				currentImg=heroImg[3][0];
				downFlag++;
			}
				else if(downFlag==1){
					currentImg=heroImg[3][2];
					downFlag--;
				}*/
			y+=5;
			System.out.println("向下转");
		}
	}
		void changePicAndDirection(int diretion){//自定义一个方法
		if (flag==0){
			currentImg=heroImg[diretion][0];
			flag++;
		}
		else if(flag==1){
			currentImg=heroImg[diretion][2];
			flag--;
			}
		repaint();
	}
}