package cn.sharhe.mathPI.fram;
import cn.sharhe.mathPI.beans.Point;
import cn.sharhe.mathPI.handle.PointHandle;
import cn.sharhe.mathPI.utils.AlgoVisHelper;

import javax.swing.*;
import java.awt.*;

/**
 * 展示窗口
 * @Author: wugui
 * @Date 2018-6-2 15:07
 */
public class AlgoJFrame extends JFrame {
    public static int canvasWidth;
    public static int canvasHeight;
    private PointHandle datas;
    /**
     * 自定义构造函数
     * @param title jFrame 标题
     * @param canvasWidth 面板长度
     * @param canvasHeight 面板高度
     */
    public AlgoJFrame(String title, int canvasWidth, int canvasHeight){
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        AlgoJPanl algoJPanl = new AlgoJPanl();
        this.setContentPane(algoJPanl);
        this.pack();
    }

    /**
     * 获得数据 并重画
     * @param datas
     */
    public void rePaint(PointHandle datas){
        this.datas = datas;
        repaint();
    }

    /**
     * 画板 小球运动的画板
     */
    private class AlgoJPanl extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);
            AlgoVisHelper.setColor(g2d, AlgoVisHelper.Red);
            AlgoVisHelper.drawText(g2d, "PI = "+datas.getPi(),canvasWidth/2,50);
            AlgoVisHelper.setStrokeWidth(g2d,3);
            AlgoVisHelper.strokeCircle(g2d,canvasWidth/2,canvasWidth/2+100,canvasWidth/2);
            AlgoVisHelper.strokeRectangle(g2d,0,100,canvasWidth,canvasWidth);
            // 绘制数据
            for (int i =0; i < datas.getDatas().size(); i++){
                if(datas.getDatas().get(i).isInside())
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Amber);
                else
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.LightBlue);
                AlgoVisHelper.fillCircle(g2d,datas.getDatas().get(i).getX(), datas.getDatas().get(i).getY(), 2);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
