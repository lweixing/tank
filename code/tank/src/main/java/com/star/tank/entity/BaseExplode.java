package com.star.tank.entity;


import com.star.tank.GameModel;
import com.star.tank.ResourceMgr;
import com.star.tank.TankFrame;

import java.awt.*;

public class BaseExplode extends GameObject{

    public static final int EXPLOAD_WIDTH = 30;
    public static final int EXPLOAD_HEIGHT = 30;

    private int step = 0;



    public BaseExplode(int x, int y  ){
        super();
        this.x = x;
        this.y = y;
        GameModel.getInstance().addGameObject(this);
    }

    public void paint(Graphics g) {

        g.drawImage(ResourceMgr.getInstance().expLodes[step++],x,y,EXPLOAD_WIDTH,EXPLOAD_HEIGHT,null);
        if(step >= ResourceMgr.getInstance().expLodes.length){
            GameModel.getInstance().removeGameObject(this);
        }

    }



}
