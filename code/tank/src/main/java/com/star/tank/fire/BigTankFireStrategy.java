package com.star.tank.fire;

import com.star.tank.GameModel;
import com.star.tank.entity.BaseBullet;
import com.star.tank.entity.BaseTank;

public class BigTankFireStrategy implements FireStrategy<BaseTank> {
    private static final BigTankFireStrategy instance = new BigTankFireStrategy();
    private BigTankFireStrategy(){}
    public static BigTankFireStrategy getInstance(){return instance;}

    @Override
    public void fire(BaseTank t) {
        int bx = 0,by = 0;
        int width = 50;
        int height = 50;
        switch (t.getDir()) {
            case LEFT:
                bx = t.getX() - width;
                by = t.getY() + t.TANK_HEIGHT/2 - height/2;
                break;
            case RIGHT:
                bx = t.getX() + t.TANK_WIDTH ;
                by = t.getY() + t.TANK_HEIGHT/2 - height/2;
                break;
            case UP:
                bx = t.getX() + t.TANK_WIDTH/2 - width/2;
                by = t.getY() - height;
                break;
            case DOWN:
                bx = t.getX() + t.TANK_WIDTH/2 - width/2;
                by = t.getY() + t.TANK_HEIGHT;
                break;
        }

        BaseBullet b = new BaseBullet(bx,by,t.getDir(),t.getGroup());
        b.setHeight(height);
        b.setWidth(width);
    }
}
