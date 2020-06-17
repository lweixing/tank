package com.star.tank.entity;

import com.star.tank.GameModel;

import java.awt.*;

public class BaseWall extends GameObject{
    private int width;
    private int height;
    public BaseWall(int x, int y, int width,int height){
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rect = new Rectangle(x,y,width,height);
        GameModel.getInstance().addGameObject(this);
    }

    @Override
    public void paint(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(Color.orange);
        g.fillRect(x,y,width,height);
        g.setColor(oldColor);
    }


}
