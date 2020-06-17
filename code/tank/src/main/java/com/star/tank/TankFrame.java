package com.star.tank;


import com.star.tank.entity.BaseBullet;
import com.star.tank.entity.BaseExplode;
import com.star.tank.entity.BaseTank;
import com.star.tank.fire.BigTankFireStrategy;
import com.star.tank.fire.DefaultTankFireStrategy;
import com.star.tank.fire.ThreeTankFireStrategy;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {

    public static final int GAME_WIDTH = 1080;
    public static final int GAME_HEIGHT = 960;




    public TankFrame(){
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setLocation(200,20);
        setResizable(false);
        setTitle("坦克大战1");
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });




        addKeyListener(new KeyAdapter() {
            boolean bl = false;
            boolean br = false;
            boolean bu = false;
            boolean bd = false;
            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        bl = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        br = true;
                        break;
                    case KeyEvent.VK_UP:
                        bu = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        bd = true;
                        break;
                }

                setMainTankDir();

                checkMainTankMoving();


            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        bl = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        br = false;
                        break;
                    case KeyEvent.VK_UP:
                        bu = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        bd = false;
                        break;
                    case KeyEvent.VK_CONTROL:
                        GameModel.getInstance().getMyTank().fire(DefaultTankFireStrategy.getInstance());
                        break;
                    case KeyEvent.VK_1:
                        GameModel.getInstance().getMyTank().fire(ThreeTankFireStrategy.getInstance());
                        break;
                    case KeyEvent.VK_2:
                        GameModel.getInstance().getMyTank().fire(BigTankFireStrategy.getInstance());
                        break;
                }

                setMainTankDir();

                checkMainTankMoving();
            }

            private void checkMainTankMoving() {
                if(bl||br||bu||bd)
                    GameModel.getInstance().getMyTank().setMoving(true);
                else
                    GameModel.getInstance().getMyTank().setMoving(false);
            }

            private void setMainTankDir(){
                Dir myDir = null;
                if(bl)
                    myDir = Dir.LEFT;
                else if(br)
                    myDir = Dir.RIGHT;
                else if(bu)
                    myDir = Dir.UP;
                else if(bd)
                    myDir = Dir.DOWN;
                if(myDir != null)
                    GameModel.getInstance().getMyTank().setDir(myDir);
            }
        });

    }

    @Override
    public void paint(Graphics g) {
        GameModel.getInstance().paint(g);

    }

    private Image offscreenImage = null;

    @Override
    public void update(Graphics g) {
        if(offscreenImage == null)
            offscreenImage = createImage(GAME_WIDTH,GAME_HEIGHT);
        Graphics thisg = offscreenImage.getGraphics();
        Color c = thisg.getColor();
        thisg.setColor(Color.black);
        thisg.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        thisg.setColor(c);
        this.paint(thisg);
        g.drawImage(offscreenImage,0,0,null);
    }


}
