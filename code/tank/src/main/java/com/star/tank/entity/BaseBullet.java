package com.star.tank.entity;


import com.star.tank.*;

import java.awt.*;

public class BaseBullet extends GameObject{
    private static final int SPEED = 10;
    private Dir dir;
    private Group group = null;

    private boolean living = true;

    public static final int BULLET_WIDTH = 5;
    public static final int BULLET_HEIGHT = 5;

    private int width;
    private int height;

    public BaseBullet(int x, int y , Dir dir, Group group ){
        super();
        this.x = x;
        this.y = y;
        width = BULLET_WIDTH;
        height = BULLET_HEIGHT;
        this.dir = dir;
        this.group = group;
        rect = new Rectangle(x,y,width,height);
        GameModel.getInstance().addGameObject(this);
    }

    public void paint(Graphics g) {

        if(!living)
            GameModel.getInstance().removeGameObject(this);

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.getInstance().bulletL,x,y,width,height,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.getInstance().bulletR,x,y,width,height,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.getInstance().bulletU,x,y,width,height,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.getInstance().bulletD,x,y,width,height,null);
                break;
        }

        this.move();

    }

    public void move(){
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        rect.x = x;
        rect.y = y;
        if(x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT) living = false;
    }

    public void die() {
        living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        this.rect.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        this.rect.height = height;
    }

}
