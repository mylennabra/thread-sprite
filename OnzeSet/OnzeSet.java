import java.awt.*;
import java.util.*;
import javax.swing.*;


public class OnzeSet extends JFrame{

    int xbomb = 700;

    int xx = 0;
    int yy = 0;


    int a = 0, x=30, aux=10; boolean exe = true;
    Image [] imagem = new Image[6];
    ImageIcon [] img = new ImageIcon[6];

    public OnzeSet() {
        img[0] = new ImageIcon("predios.png");
        imagem[0] = img[0].getImage();
        img[1] = new ImageIcon("plane.png");
        imagem[1] = img[1].getImage();
        img[2] = new ImageIcon("twint.png");
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
            g.drawImage(imagem[5],0, 0, getWidth(), getHeight(), this);     
            
            g.drawImage(imagem[2], 100, getHeight()-400, 240, 600, this);
            
            g.drawImage(imagem[1], xbomb-=aux, 100, 100, 100, this);
            g.drawImage(imagem[1], xbomb, 100, 100, 100, this);
            //g.drawImage(imagem[0], 0, getHeight()-200, getWidth(), 200, this);
            
            
            g.drawString("Km "+ x, getWidth()-200, 900);

        }else{
            g.setFont(new Font("Arial Black",1, 19));
            g.drawString("AS TWINS EXPLODIRAM!!!!", 300, 100);
            g.setFont(new Font("Arial",1, 12));
            g.drawString("11/09 ", 600, 150);
            g.drawImage(imagem[4],xbomb-120, 100, 140, 140, this);
            g.drawImage(imagem[4],xbomb-170, 160, 120, 120, this);
            aux=0;
        }
    }

    boolean collide() {
        int w1,h1,w2,h2,x1,y1,x2,y2;
        w1 = 100; h1 = 100; 
        x1 = xbomb+60; y1 = 100; 
        w2 = 240; h2 = 600; 
        x2 = 100; y2 = getHeight()-400; 
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
        OnzeSet d = new OnzeSet();
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
