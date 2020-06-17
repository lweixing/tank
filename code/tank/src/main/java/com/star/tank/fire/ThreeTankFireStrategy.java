package com.star.tank.fire;

import com.star.tank.entity.BaseBullet;
import com.star.tank.entity.BaseTank;

public class ThreeTankFireStrategy implements FireStrategy<BaseTank> {

    private final static ThreeTankFireStrategy instance = new ThreeTankFireStrategy();
    private ThreeTankFireStrategy(){}
    public static ThreeTankFireStrategy getInstance(){return instance;}

    @Override
    public void fire(BaseTank t) {
        int bx = 0,by = 0;
        switch (t.getDir()) {
            case LEFT:
                bx = t.getX() - BaseBullet.BULLET_WIDTH;
                by = t.getY() + t.TANK_HEIGHT/2 - BaseBullet.BULLET_HEIGHT/2;
                break;
            case RIGHT:
                bx = t.getX() + t.TANK_WIDTH ;
                by = t.getY() + t.TANK_HEIGHT/2 - BaseBullet.BULLET_HEIGHT/2;
                break;
            case UP:
                bx = t.getX() + t.TANK_WIDTH/2 - BaseBullet.BULLET_WIDTH/2;
                by = t.getY() - BaseBullet.BULLET_HEIGHT;
                break;
            case DOWN:
                bx = t.getX() + t.TANK_WIDTH/2 - BaseBullet.BULLET_WIDTH/2;
                by = t.getY() + t.TANK_HEIGHT;
                break;
        }

        BaseBullet b = new BaseBullet(bx,by,t.getDir(),t.getGroup());
        BaseBullet b1 = new BaseBullet(bx-t.TANK_WIDTH,by,t.getDir(),t.getGroup());
        BaseBullet b2 = new BaseBullet(bx+t.TANK_WIDTH,by,t.getDir(),t.getGroup());
        BaseBullet b3 = new BaseBullet(bx,by-t.TANK_HEIGHT,t.getDir(),t.getGroup());
        BaseBullet b4 = new BaseBullet(bx,by+t.TANK_HEIGHT,t.getDir(),t.getGroup());
    }
}
