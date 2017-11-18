package com.tian.blog.util.chess;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FiveChessFrame extends JFrame implements MouseListener, Runnable {
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    // 背景图片
    BufferedImage image = null;
    //保存棋子坐标
    int x = 0;
    int y = 0;

    // 保存之前下过的棋子的坐标
    // 其中数据：0：表示这个点没有棋子 1：表示黑子 2：表示白子
    int[][] allChess = new int[19][19];
    // 标识当前是黑棋还是白棋下下一步
    boolean isBlock = true;
    // 标识当前游戏是否可以继续
    boolean canPlay = true;
    // 保存显示的提示信息
    String message = "黑方先行";
    // 保存最多拥有多少时间
    int maxTime = 0;
    // 做倒计时的线程类
    Thread thread = new Thread(this);
    // 保存黑方和白方剩余的时间
    int blackTime = 0;
    int whiteTime = 0;
    // 保存双方剩余时间的提示信息
    String blackMessage = "无限制";
    String whiteMessage = "无限制";

    public FiveChessFrame() {
        this.setTitle("五子棋");
        this.setSize(500, 500);
        this.setLocation((width - 500) / 2, (height - 500) / 2);
        this.addMouseListener(this);
        this.setVisible(true);

        thread.start();
        thread.suspend();// 挂起

        // 刚打开的时候刷新屏幕，防止开始游戏时无法显示问题
        this.repaint();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            image = ImageIO.read(new File("src/main/java/com/tian/blog/util/res/five.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void paint(Graphics g) {
        //双缓存技术 防止屏幕闪烁 但不知道为什么，使用双缓存技术以后，效果特不好，所以没用，如果使用的话，下面的 g 改为 g2 就可以了
        g.drawImage(image, 0, 20, this);
        g.setFont(new Font("黑体", Font.BOLD, 20));
        g.drawString("游戏信息：" + message, 120, 60);
        g.setFont(new Font("宋体", 0, 14));
        g.drawString("黑方时间：" + blackMessage, 30, 470);
        g.drawString("白方时间：" + whiteMessage, 260, 470);

        // 绘制棋盘
        for (int i = 0; i < 19; i++) {
            g.drawLine(10, 70 + 20 * i, 370, 70 + 20 * i);
            g.drawLine(10 + 20 * i, 70, 10 + 20 * i, 430);
        }

        //标注小圆点
        g.fillOval(68, 128, 4, 4);
        g.fillOval(308, 128, 4, 4);
        g.fillOval(308, 368, 4, 4);
        g.fillOval(68, 368, 4, 4);
        g.fillOval(188, 128, 4, 4);
        g.fillOval(68, 248, 4, 4);
        g.fillOval(188, 368, 4, 4);
        g.fillOval(188, 248, 4, 4);
        g.fillOval(308, 248, 4, 4);

        // 输出数组中所有数值
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (allChess[i][j] == 1) {
                    // 黑子
                    int tempX = i * 20 + 10;
                    int tempY = j * 20 + 70;
                    g.fillOval(tempX - 7, tempY - 7, 14, 14);
                }
                if (allChess[i][j] == 2) {
                    int tempX = i * 20 + 10;
                    int tempY = j * 20 + 70;
                    g.setColor(Color.WHITE);
                    g.fillOval(tempX - 7, tempY-7, 14, 14);
                    g.setColor(Color.BLACK);
                    g.fillOval(tempX - 7, tempY - 7, 14, 14);
                }
            }
        }
    }

    /**
     * 判断赢家
     * @return
     */
    public boolean checkWinner(){
        boolean flag = false;
        // 保存共有多少相同颜色棋子相连
        int count = 1;
        // 判断横向 特点：allChess[x][y]中y值相同
        int color = allChess[x][y];
        // 判断横向
        count = this.checkCount(1, 0, color);
        if (count >= 5) {
            flag = true;
        }else {
            // 纵向
            count = this.checkCount(0, 1, color);
            if (count >= 5) {
                flag = true;
            } else {
                // 判断左下右上
                count = this.checkCount(1, -1, color);
                if (count>=5) {
                    flag = true;
                } else {
                    // 判断左上右下
                    count = this.checkCount(1, 1, color);
                    if (count >= 5) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    // 判断棋子连接数量
    private int checkCount(int xChange, int yChange, int color) {
        int count = 0;
        int tempX = xChange;
        int tempY = yChange;
        while (x + xChange >= 0 && x + xChange <= 18 && y + yChange >= 0
                && y + yChange <= 18
                && color == allChess[x + xChange][y + yChange]) {
            count++;
            if (xChange != 0) {
                xChange++;
            }
            if (yChange != 0) {
                if (yChange > 0) {
                    yChange++;
                }else {
                    yChange--;
                }
            }
        }
        xChange = tempX;
        yChange = tempY;

        while (x - xChange >= 0 && x - xChange <= 18 && y - yChange >=0
                && y - yChange <= 18
                && color == allChess[x - xChange][y - yChange]) {
            count++;
            if (xChange != 0) {
                xChange++;
            }

            if (yChange != 0) {
                if (yChange > 0) {
                    yChange++;
                }else {
                    yChange--;
                }
            }
        }

        return count;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (canPlay) {
            x = e.getX();
            y = e.getY();
            if (x >= 10 && x <= 370 && y >= 70 && y <=430) {
                x = (x - 10) / 20;
                y = (y - 70) / 20;
                if (allChess[x][y] == 0){

                }
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {

    }
}
