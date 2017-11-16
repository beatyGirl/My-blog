package com.tian.blog.util;

import com.sun.javafx.css.StyleableProperty;

import javax.swing.*;
import java.awt.*;

public class Judge implements GobangInterface {
    private JFrame jFrame;
    private int x, y;
    private int count;

    public Judge(int x, int y) {
        this.x = x;
        this.y = y;
        count = 1;
        jFrame = new JFrame();
        jFrame.setTitle("结果");
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setSize(450, 300);
    }

    public void judge() {
        count = 1;
        // 竖向检查
        for (int i = x + 1; i < Coloum; i++) {
            if (array[i][y] != 0) {
                if ((array[x][y] % 2) == (array[i][y] % 2)) {
                    count++;
                } else break;
            } else break;
        }
        for (int i = x - 1; i >= 0; i--) {
            if (array[i][y] != 0) {
                if ((array[x][y] % 2) == (array[i][y] % 2)) {
                    count++;
                } else break;
            } else break;
        }

        if (count >= 5) {
            if (array[x][y] % 2 == 0) {
                JLabel jLabel = new JLabel("黑棋胜！！！");
                jLabel.setPreferredSize(new Dimension(400, 250));
                jLabel.setFont(new Font("楷体", 1, 50));
                jFrame.add(jLabel);
                jFrame.setVisible(true);
            } else {
                JLabel jLabel = new JLabel("白棋胜！！！");
                jLabel.setPreferredSize(new Dimension(400, 250));
                jLabel.setFont(new Font("楷体", 1, 50));
                jFrame.add(jLabel);
                jFrame.setVisible(true);
            }
            return;
        }
        count = 1;

        // 横向检查
        for (int i = y + 1; i < Row; i++) {
            if (array[x][i] != 0) {
                if ((array[x][y] % 2) == (array[x][i] % 2)) {
                    count++;
                } else break;
            } else break;
        }

        for (int i = y - 1; i >= 0; i++) {
            if (array[x][i] != 0) {
                if ((array[x][y] % 2) == (array[x][i] % 2)) {
                    count++;
                } else break;
            } else break;
        }

        if (count >= 5) {
            if (array[x][y] % 2 != 0) {
                JLabel jLabel = new JLabel("黑棋胜！！！");
                jLabel.setPreferredSize(new Dimension(400, 250));
                jLabel.setFont(new Font("楷体", 1, 30));
                jFrame.add(jLabel);
                jFrame.setVisible(true);
            } else {
                JLabel jLabel = new JLabel("白棋胜！！！");
                jLabel.setPreferredSize(new Dimension(400, 250));
                jLabel.setFont(new Font("楷体", 1, 30));
                jFrame.add(jLabel);
                jFrame.setVisible(true);
            }
            return;
        }

        count = 1;
        // 斜向检查 (从左上角到右下角)
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (array[i][j] != 0) {
                if ((array[x][y] % 2) == (array[i][j] % 2)) {
                    count++;
                } else break;
            } else break;
        }

        for (int i = x + 1, j = y + 1; i <= Coloum && j <= Row; i++, j++) {
            if (array[i][j] != 0) {
                if ((array[x][y] % 2) == (array[i][j] % 2)) {
                    count++;
                } else break;
            } else break;
        }

        if (count >= 5) {
            if (array[x][y] % 2 != 0) {
                JLabel jLabel = new JLabel("黑棋胜！！！");
                jLabel.setPreferredSize(new Dimension(400, 250));
                jLabel.setFont(new Font("楷体", 1, 30));
                jFrame.add(jLabel);
                jFrame.setVisible(true);
            } else {
                JLabel jLabel = new JLabel("白棋胜！！！");
                jLabel.setPreferredSize(new Dimension(400, 250));
                jLabel.setFont(new Font("楷体", 1, 30));
                jFrame.add(jLabel);
                jFrame.setVisible(true);
            }
            return;
        }

        count = 1;
        //斜向检查（从左下角到右上角）
        for (int i = x - 1, j = y + 1; i >= 0 && j < Row; i--, j++) {
            if (array[i][j] != 0) {
                if ((array[x][y] % 2) == (array[i][j] % 2)) {
                    count++;
                }else break;
            }else break;
        }

        for (int i = x + 1, j = y - 1; i < Coloum && j >=0; i++, j--) {
            if (array[i][j] != 0){
                if ((array[x][y] % 2) == (array[i][j] % 2)) {
                    count++;
                }else break;
            }else break;
        }

        if (count >= 5) {
            if (array[x][y] % 2 != 0) {
                JLabel jLabel = new JLabel("黑棋胜！！！");
                jLabel.setPreferredSize(new Dimension(400, 250));
                jLabel.setFont(new Font("楷体", 1, 30));
                jFrame.add(jLabel);
                jFrame.setVisible(true);
            }else {
                JLabel jLabel = new JLabel("白棋胜！！！");
                jLabel.setPreferredSize(new Dimension(400, 250));
                jLabel.setFont(new Font("楷体", 1, 30));
                jFrame.add(jLabel);
                jFrame.setVisible(true);
            }
            return;
        }
    }


}
