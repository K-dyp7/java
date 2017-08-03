import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;  
import java.awt.Frame;
import java.awt.Image;  
import java.awt.Point;  
import java.awt.Toolkit;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
    import java.awt.event.MouseEvent;  
    import java.awt.event.MouseListener;  
import java.awt.event.WindowEvent;
    import java.util.Random;  
    import javax.swing.JFrame;
      
import javax.swing.*;
      
    public class HitMouse extends JFrame implements ActionListener,MouseListener{  
        boolean isOver=false;//���ñ�ǣ���Ϸ�Ƿ����  
        private String dir="./images/";//ͼƬĿ¼����ǰ������  
        private int gameTime=0;
        JLabel jlbMouse;//����  
        Timer timer;//ʱ�䶨ʱ��  
        Random random;//��������󣬼����ɵ����λ��  
        int delay=1100;//�ӳ�ʱ��  
        Toolkit tk;  
        Image image;  
        Cursor myCursor;  
        JLabel showNum,currentGrade,hitNum,gameTimeLabel;  
        int showNumber=0,hitNumber=0,currentGrades=1,time =0;
          
        public HitMouse(){  
            super("�����");  //��Ϸ������
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            this.setSize(449, 395);  //��Ϸ����ĳߴ�
            this.setLocationRelativeTo(null);//���ô�������Ļ����  
            setbackground();//���ñ���  
            this.getContentPane().setLayout(null);//���ÿ�ܲ���ģʽΪ��
            //�������Ϊ����ͼƬ  
            tk = Toolkit.getDefaultToolkit();  
            image = tk.createImage(dir+"chui1.png");  
            myCursor = tk.createCustomCursor(image, new Point(10,10), "xxx");  
            this.setCursor(myCursor);  
              
            setMessage();//����һЩ��ʾ��Ϣ  
            //�ڱ���ͼƬ�Ļ��������õ���ͼƬ  
            ImageIcon imageMouse = new ImageIcon(dir+"dishu.png");  
            jlbMouse = new JLabel(imageMouse);  
            jlbMouse.setSize(80,80);  
            this.getContentPane().add(jlbMouse);  
            jlbMouse.setVisible(false);  
            jlbMouse.addMouseListener(this);//���������  
            //��ʱ��  
            timer = new Timer(delay,this);  
            random = new Random();  
            timer.start();  
            
            addMenu();//��Ӳ˵�  
            this.setResizable(false);//���ô��ڴ�С���ܸı�  
            this.setVisible(true);  
        }  
          
        private void addMenu() {  
            JMenuBar menubar = new JMenuBar();  
            this.setJMenuBar(menubar);  
            JMenu game = new JMenu("��Ϸ");  
            JMenuItem jitemNew = new JMenuItem("����Ϸ");  
            jitemNew.setActionCommand("new");  
            jitemNew.addActionListener(this);  
            JMenuItem jitemPause = new JMenuItem("��ͣ");  
            jitemPause.setActionCommand("pause");  
            jitemPause.addActionListener(this);  
            JMenuItem jitemExit = new JMenuItem("�˳�");  
            jitemExit.setActionCommand("exit");  
            jitemExit.addActionListener(this);  
            game.add(jitemNew);  
            game.add(jitemPause);  
            //game.addSeparator();//�˵������÷ָ���  
            game.add(jitemExit);  
            menubar.add(game);  
        }  
          
        private void setbackground() {  
            ((JPanel)(this.getContentPane())).setOpaque(false);//���Ϊ true��������������߽��ڵ��������ء������������ܲ����Ʋ��ֻ��������أ��Ӷ�������ײ�����͸�ӳ�����   
            ImageIcon bgImage = new ImageIcon("images/beijing.jpg");  
            gameTimeLabel = new JLabel("��Ϸʱ�䣺" + gameTime);
            JLabel bgLabel = new JLabel(bgImage);  
            bgLabel.setBounds(0, 25, bgImage.getIconWidth(), bgImage.getIconHeight());  
            this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));//���ñ���ͼƬ�Ĳ�����  
              
        }  
          
        private void setMessage() {  
    		gameTimeLabel = new JLabel("��Ϸʱ�䣺" + gameTime);
        	
    		ImageIcon gameTimeLabelb = new ImageIcon(dir+"yiyongshijian.png");  
            JLabel timeLabel = new JLabel(gameTimeLabelb);  
            timeLabel.setBounds(8,20, 92, 80);  
            this.getContentPane().add(timeLabel);  
            gameTimeLabel = new JLabel("0");  
            gameTimeLabel.setBounds(110,20, 92, 80);  
            this.getContentPane().add(gameTimeLabel);  
    		
            ImageIcon showNumb = new ImageIcon(dir+"chuxiancishu.png");  
            JLabel showLabel = new JLabel(showNumb);  
            showLabel.setBounds(8, -20, 92, 80);  
            this.getContentPane().add(showLabel);  
            showNum = new JLabel("0");  
            showNum.setBounds(110, -20, 92, 80);  
            this.getContentPane().add(showNum);  
              
            ImageIcon hitNumb = new ImageIcon(dir+"dazhongcishu.png");  
            JLabel hitLabel = new JLabel(hitNumb);  
            hitLabel.setBounds(148,-20, 92, 80);  
            this.getContentPane().add(hitLabel);  
            hitNum = new JLabel("0");  
            hitNum.setBounds(251,-20, 92, 80);  
            this.getContentPane().add(hitNum);  
              
            ImageIcon grade = new ImageIcon(dir+"dangqiandengji.png");  
            JLabel gradeLabel = new JLabel(grade);  
            gradeLabel.setBounds(288,-20, 92, 80);  
            this.getContentPane().add(gradeLabel);  
            currentGrade = new JLabel("1");  
            currentGrade.setBounds(391,-20, 92, 80);  
            this.getContentPane().add(currentGrade);  
        }  
      
      
        public static void main(String[] args) {  
        	//String s=JOptionPane.showInputDialog("��׼����������Ϸ��ʼ");
        	JOptionPane.showMessageDialog(null,"��׼����������Ϸ��ʼ!");
            new HitMouse();  
        }  

        
        public void actionPerformed(ActionEvent e) {   
            //�Բ˵���ע���¼�����  
            if(e.getSource() instanceof JMenuItem){  
                menuItemFun(e);  
            }  
              
            int ran=random.nextInt(9);//�������һ��0~9��������9���������  
            ImageIcon imageMouse = new ImageIcon(dir+"dishu.png");//��֤ÿ��������ɵĵ���ͼƬ����Ϊû����ʱ��ͼƬ  
            jlbMouse.setIcon(imageMouse);  
            switch(ran){  
            case 0:jlbMouse.setLocation(55, 63);break;  
            case 1:jlbMouse.setLocation(321, 204);break;  
            case 2:jlbMouse.setLocation(184, 204);break;  
            case 3:jlbMouse.setLocation(47, 203);break;  
            case 4:jlbMouse.setLocation(297, 133);break;  
            case 5:jlbMouse.setLocation(161, 133);break;  
            case 6:jlbMouse.setLocation(21, 133);break;  
            case 7:jlbMouse.setLocation(310, 63);break;  
            case 8:jlbMouse.setLocation(185, 63);break;  
            }  
              
            jlbMouse.setVisible(true);  
              time++;
              gameTimeLabel.setText(""+time); 
            showNumber++;  
            showNum.setText(""+showNumber);  
              
            if( !gamePlan() ){//�ж���Ϸ�Ƿ����������ʾ��Ϸ����  
                timer.stop();  
            }  
              
        }  
        
     
        //�����˵����ܹ���  
        private void menuItemFun(ActionEvent e) {  
            if (e.getActionCommand().equalsIgnoreCase("new")) {//����Ϸ  
                timer.stop();  
                time=0;
                showNumber=0;  
                hitNumber=0;  
         
                currentGrades=1;  
                delay=1000;  
                isOver=false;  
                gameTimeLabel.setText(""+time); 
                showNum.setText(""+showNumber);  
                hitNum.setText(""+hitNumber);  
                currentGrade.setText(""+currentGrades);  
                timer = new Timer(delay,this);  
                timer.start();  
            }  
            if (e.getActionCommand().equalsIgnoreCase("exit")) {//�˳�  
                System.exit(EXIT_ON_CLOSE);  
            }  
              
            if (e.getActionCommand().equalsIgnoreCase("pause")) {//��ͣ  
                timer.stop();  
                JOptionPane.showMessageDialog(this, "�����밴��ȷ����");  
                timer.start();  
            }  
        }  
      
        private boolean gamePlan() {  
        	if(time>=30){
        		JOptionPane.showMessageDialog(this, "Game Over��30��ʱ�䵽��");  
        		JOptionPane.showMessageDialog(this, "��ĳɼ�Ϊ���ȼ�"+currentGrades+"����"+"�����"+(currentGrades*5+hitNumber)+"����"); 
                isOver=true;  
                new  whetherContinue();
                  return false; 
                
        	}
            if(showNumber-hitNumber > 8){  
                JOptionPane.showMessageDialog(this, "Game Over�����Ѿ�©��8�������ˣ�");  
                isOver=true;  
               
                new  whetherContinue();
                return false;  
            }  
            if(hitNumber > 5){  
                hitNumber=0;  
                showNumber=0;  
                currentGrades++;  
                if(delay>100){  
                    delay-=50;  
                }else if(delay>=500){  
                    delay=500;  
                }  
                timer.setDelay(delay); 
                gameTimeLabel.setText(""+time); 
                hitNum.setText(""+hitNumber);  
                showNum.setText(""+showNumber);  
                currentGrade.setText(""+currentGrades);  
            }  
            return true;
        }  
      
        public class whetherContinue extends JFrame{
        	 
            public  whetherContinue(){
            	 Object[] possibleValues = { "����", "�˳�" }; 
                 Object selectedValue = JOptionPane.showInputDialog(null, "�Ƿ������Ϸ��", " ", 
                 JOptionPane.INFORMATION_MESSAGE, null, 
                 possibleValues, possibleValues[0]);
                 
               if(((String) selectedValue).equals("����")){
                    	new HitMouse();
                    }
               
               if(((String) selectedValue).equals("�˳�")){
               	System.exit(0);
               }
              
            }
         
        }
       
        
        public void mouseClicked(MouseEvent e) {  
              
        }  
      
        public void mousePressed(MouseEvent e) {  
            if(isOver){  
                return ;  
            }  
            image = tk.createImage(dir+"chui2.png");  
            myCursor = tk.createCustomCursor(image, new Point(10,10), "xxx");  
            this.setCursor(myCursor);//��갴��ʱ�������ʾ����ȥ��ͼƬ��ģ���Ķ���  
            //������е�������󻻳ɱ����е�ͼƬ��ģ����󱻴�  
            if(e.getSource()==jlbMouse){  
                ImageIcon imageIconHit = new ImageIcon(dir+"datou.png");  
                jlbMouse.setIcon(imageIconHit);  
                jlbMouse.setVisible(true);  
            }  
              
            hitNumber++;  
            hitNum.setText(""+hitNumber);  
        }  
      
        public void mouseReleased(MouseEvent e) {  
            if(isOver){  
                return ;  
            }  
            //���������Ժ������ԭ��û����ʱ��ͼƬ  
            image = tk.createImage(dir+"chui1.png");  
            myCursor = tk.createCustomCursor(image, new Point(10,10), "xxx");  
            this.setCursor(myCursor);  
        }  
      
        public void mouseEntered(MouseEvent e) {  
              
        }  
      
        public void mouseExited(MouseEvent e) {  
              
        }  
      
      
    }  