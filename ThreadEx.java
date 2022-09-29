import java.awt.*;
import java.util.*;
import javax.swing.*;


public class ThreadEx extends JFrame{

    int xbomb = getWidth();
    int ybomb = 0;
    int floor = 0;
    int clouds = 400;

    int xx = 0;
    int yy = 0;


    int a = 0, x=30, aux=10; boolean exe = true;
    Image [] imagem = new Image[6];
    ImageIcon [] img = new ImageIcon[6];

    public ThreadEx() {
        img[0] = new ImageIcon("floor2.png");
        imagem[0] = img[0].getImage();
        img[1] = new ImageIcon("bomb.png");
        imagem[1] = img[1].getImage();
        img[2] = new ImageIcon("car.png");
        imagem[2] = img[2].getImage();
        img[3] = new ImageIcon("cloud.png");
        imagem[3] = img[3].getImage();
        img[4] = new ImageIcon("explosion.png");
        imagem[4] = img[4].getImage();
        img[5] = new ImageIcon("background.jpg");
        imagem[5] = img[5].getImage();


        // for(int i=0; i<=3; i++){
        // }


        setSize(700,400); // Define tamanho do frame
        setVisible(true); // Torna o frame visivel
        setTitle("aaa"); // Definindo título pra janela 
        setLocationRelativeTo(null); // Definindo a posição da janela no centro da tela 
        setResizable(false); // Bloqueado maximização e customização de tamanho
        setVisible(true);

        showNotify();
    }

    public void showNotify(){
        exe = true;
        new Thread(t).start();
    }
           
    public void hideNotify(){
        exe = false;
        t = null;
    }      

    public void paint(Graphics g){
        
        if(collide()==false){
            g.setColor(Color.cyan);
            g.drawImage(imagem[5],0, 0, getWidth(), getHeight(), this);     
            g.drawImage(imagem[0], floor-=aux, getHeight()-150, getWidth()*80, 175, null);
            g.drawImage(imagem[1], 400, ybomb+=aux, 40, 40, this);
            g.drawImage(imagem[2], x+=aux, getHeight()-100, 170, 80, this);
            g.drawImage(imagem[2], x+1, getHeight()-100, 170, 80, this);
                        
            
            g.drawString("Km "+ x, getWidth()-200, 900);

        }else{
            g.setFont(new Font("Arial Black",1, 19));
            g.drawString("GAME OVER SEU CARRO EXPLODIU!!!!", 100, 100);
            g.setFont(new Font("Arial",1, 12));
            g.drawString("Explodiu no Km "+ x, 100, 150);
            g.drawImage(imagem[4],350, ybomb-30, 130, 130, this);
            aux=0;
        }
    }

    boolean collide() {
        int w1,h1,w2,h2,x1,y1,x2,y2;
        w1 = 40; h1 = 40; 
        x1 = 400; y1 = ybomb-20; 
        w2 = 170; h2 = 80; 
        x2 = x; y2 = getHeight()-100; 
        if (((x1+w1)>x2) && ((y1+h1)>y2) && ((x2+w2)>x1) && ((y2+h2)>y1)) {
            return true;
        } else {
            return false;
        }
    }

    public Runnable t = new Runnable() {
        public void run() {
            runtherandom();
        }
    };


    public void runtherandom(){
        while(exe){
            while (!(yy>(getHeight()-80))){
                xx+=1;
                trycatch();
            }
        }
    }

    public void trycatch(){
        try{
            Thread.sleep(80);
        }catch(Exception e){Thread.currentThread().interrupt();}
        repaint();
    }
        

    public static void main(String [] args){
        ThreadEx d = new ThreadEx();
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}