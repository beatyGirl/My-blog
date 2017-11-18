package com.tian.blog.util.chess;

import javax.swing.*;
import java.awt.*;

public class Gobang extends JFrame implements GobangInterface {

    public void gobang() {
        // 设置版面
        JFrame jFrame = new JFrame();
        jFrame.setTitle("五子棋");
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setSize(850, 700);
        // 设置布局
        jFrame.setLayout(new BorderLayout());

        jFrame.add(this, BorderLayout.CENTER);
        // 在Jfinal组件上画棋子
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.DARK_GRAY);
        jPanel.setPreferredSize(new Dimension(150, 0));
        jFrame.add(jPanel, BorderLayout.EAST);

        jFrame.setVisible(true);

        GobangListener gobangLisener = new GobangListener(this);
        this.addMouseLisener(gobangLisener);
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        // 画出整个棋盘
        for (int i=0; i < Row; i++) {// 行
            graphics2D.drawLine(X, Y + i * Size, X + Size * (Coloum - 1), Y + i * Size);
        }

        for (int i = 0; i < Coloum; i++) {// 列
            graphics2D.drawLine(X + i * Size, Y, X + Size * i, Y + Size * (Row - 1));
        }

        // 画出棋子
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j< array[i].length; j++) {
                if (array[i][j] != 0) {
                    if (array[i][j] % 2 != 0) {
                        graphics2D.setColor(Color.BLACK);
                    }else {
                        graphics2D.setColor(Color.WHITE);
                    }

                    int x = Y + j * Size - Size / 2;
                    int y = X + i * Size - Size / 2;
                    graphics2D.fillOval(x, y, Size, Size);
                }
            }
        }
    }

    public void addMouseLisener(GobangListener gobangListener){
        gobangListener.mouseReleased(null);
    }

}
