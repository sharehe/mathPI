package cn.sharhe.mathPI.controller;
import cn.sharhe.mathPI.fram.AlgoJFrame;
import cn.sharhe.mathPI.handle.PointHandle;
import cn.sharhe.mathPI.utils.AlgoVisHelper;

import java.awt.*;
import java.util.Random;

/**
 * 圆形数据控制
 * @Author: wugui
 * @Date 2018-6-2 20:02
 */
public class CircleController {
    private AlgoJFrame algoJFrame;
    private PointHandle pointHandle;
    private int count;
    private int width;
    private int height;
    /**
     * @param count 测试数据个数
     * @param width 窗口宽度
     * @param height 窗口高度
     */
    public CircleController(int count, int width, int height) {
        this.count = count;
        this.width = width;
        this.height = height;
        this.pointHandle = new PointHandle(width/2,width/2+100,width/2);
    }

    /**
     * 保证 height>=width+100
     * @param args
     */
    public static void main(String[] args) {

        CircleController a = new CircleController(5000, 600,700);
        a.start();
    }

    /**
     * 启动
     */
    public void start(){
        EventQueue.invokeLater(()->{
            algoJFrame = new AlgoJFrame("豆豆" ,width,height);
            new Thread(()->{
                run();
            }).start();
            algoJFrame.setVisible(true);
        });
    }
    /**
     * 控制动画
     */
    private void run(){
            while (true) {
                this.pointHandle.add();
                this.algoJFrame.rePaint(this.pointHandle);
                AlgoVisHelper.pause(10);
            }
    }
    }



