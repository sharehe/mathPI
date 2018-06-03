package cn.sharhe.mathPI.beans;

/**
 * 表示点的实体类
 * @Author: wugui
 * @Date 2018-6-3 14:50
 */
public class Point {
    private int x;
    private int y;
    private boolean isInside; //是否在圆内部
    public Point(int x, int y, boolean isInside) {
        this.x = x;
        this.y = y;
        this.isInside = isInside;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isInside() {
        return isInside;
    }
}
