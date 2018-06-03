package cn.sharhe.mathPI.handle;

import cn.sharhe.mathPI.beans.Point;
import cn.sharhe.mathPI.fram.AlgoJFrame;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 处理点数据
 * 随机添加点并计算是否在圆内部
 * @Author: wugui
 * @Date 2018-6-3 15:05
 */
public class PointHandle {
    private List<Point> datas;
    private int x,y;    //圆心坐标
    private int r;      //半径
    private int minx,maxx;
    private int miny,maxy;
    private int insideConut; //圆内部的数据
    public PointHandle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.datas = new LinkedList<>();
        this.minx = x - r;
        this.miny = y - r;
        this.maxy = y + r;
        this.maxx = x + r;
    }

    /**
     * 添加一个点
     */
    public void add(){
        Random random = new Random();
        int x = random.nextInt(this.maxx - this.minx);
        x += minx;
        int y = random.nextInt(this.maxy - this.miny);
        y += miny;
        if((x-this.x) * (x-this.x) + (y - this.y) * (y - this.y) > this.r * this.r){
            Point p =new Point(x, y, false);
            datas.add(p);
        }else{
            Point p =new Point(x, y, true);
            datas.add(p);
            this.insideConut++;
        }
    }

    public List<Point> getDatas() {
        return datas;
    }

    /**
     * 计算当前pi值
     * @return
     */
    public double getPi(){
        return  4 * (double)this.insideConut / this.datas.size();
    }
}
