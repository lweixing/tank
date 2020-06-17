package com.star.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {

    private final static ResourceMgr instance = new ResourceMgr();
    private ResourceMgr(){
        try {
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.png"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.png"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.png"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.png"));

            goodtankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/goodtankL.png"));
            goodtankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/goodtankR.png"));
            goodtankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/goodtankU.png"));
            goodtankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/goodtankD.png"));

            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.png"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.png"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.png"));

            for(int i=0;i<7;i++){
                expLodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream(String.format("images/explode%s.png",i+1)));
            }
            int j = 7;
            for(int i=6;i>0;i--){
                expLodes[j++] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream(String.format("images/explode%s.png",i)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ResourceMgr getInstance(){
        return instance;
    }

    public BufferedImage tankL,tankR,tankU,tankD;
    public BufferedImage goodtankL,goodtankR,goodtankU,goodtankD;

    public BufferedImage bulletL,bulletR,bulletU,bulletD;

    public BufferedImage [] expLodes = new BufferedImage [13];

}
