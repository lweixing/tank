package com.star.tank.fire;

import com.star.tank.GameModel;
import com.star.tank.entity.BaseBullet;
import com.star.tank.entity.BaseTank;

public class DefaultTankFireStrategy implements FireStrategy<BaseTank> {
    private static final DefaultTankFireStrategy instance = new DefaultTankFireStrategy();
    private  DefaultTankFireStrategy(){}
    public static DefaultTankFireStrategy getInstance(){return instance;}

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

        BaseBullet b = new BaseBullet(bx,by,t.getDir(),t.getGroup() );
    }
}
