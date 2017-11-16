package com.tian.blog.util;

import com.sun.org.apache.bcel.internal.generic.SIPUSH;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GobangListener extends MouseAdapter implements GobangInterface {
    private Judge judge;
    private Gobang gobang;
    private Graphics2D graphics2D;
    private int x, y;
    private int num = 1;

    public GobangListener(Gobang gobang) {
        this.gobang = gobang;
        graphics2D = (Graphics2D) this.gobang.getGraphics();
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        // 取得坐标
        x = mouseEvent.getX();
        y = mouseEvent.getY();

        // 计算行列
        int row = (y - Y + Size / 2) / Size;
        int column = (x - X + Size / 2) / Size;
        if (row < Row && column < Coloum) {
            if (array[row][column] == 0) {
                // 确定在数组的位置
                x = X + column * Size - Size / 2;
                y = Y + row * Size - Size / 2;

                graphics2D.setColor(Color.BLACK);
                array[row][column] = num;
                graphics2D.fillOval(x, y, Size, Size);
                judge = new Judge(row, column);
                judge.judge();
            }
        }
    }

}
