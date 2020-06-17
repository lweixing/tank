package com.star.tank.collider;

import com.star.tank.entity.GameObject;

public interface Collider {
    public void collide(GameObject go1,GameObject go2);
}
