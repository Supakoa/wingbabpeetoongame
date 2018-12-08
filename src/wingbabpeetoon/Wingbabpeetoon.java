/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wingbabpeetoon;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;

class panel extends JPanel implements KeyListener, ActionListener {

    URL sound;
    URL sound2;
    Clip clip;
    Clip clip2;
    AudioInputStream audioinput;
    AudioInputStream audioinput2;
    int bgx1, bgx2, bgx3,bgx4,bgxbox, way, bgy;
    int hu, hu1, sp, walk, walk1, x, x1, up, up1, bl, bl1, br, br1, upb, way1;
    int score, count;
    BufferedImage imagebg1,imagebg2,imagebg3,imagebg4;
    BufferedImage imagebox;
    BufferedImage l1, l2, l3;
    BufferedImage r1, r2, r3;
    BufferedImage bulletL, bulletR, bulletBL, bulletBR;
    BufferedImage botL1, botL2, botL3, botR1, botR2, botR3;
    BufferedImage n0, n1, n2, n3, n4, n5, n6, n7, n8, n9;
    Boolean jump;
    Boolean jumpl;
    Boolean jumpr;
    Boolean down;
    Boolean downn;
    Boolean l;
    Boolean r;
    Boolean u;
    Boolean bullet;
    Boolean b;
    Boolean bL;
    Boolean bR;
    Boolean point, point1;

    panel() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        Random rand = new Random();
        sound = new URL("file:///C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\stepstone.wav");
        sound2 = new URL("file:///C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\movement.wav");
        clip = AudioSystem.getClip();
        audioinput = AudioSystem.getAudioInputStream(sound);
        clip2 = AudioSystem.getClip();
        audioinput2 = AudioSystem.getAudioInputStream(sound2);
        clip.open(audioinput);
        clip2.open(audioinput2);
        this.imagebg1 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\kk.jpg"));
        this.imagebg2 = ImageIO.read(new File(""));
        this.imagebg3 = ImageIO.read(new File(""));
        this.imagebg4 = ImageIO.read(new File(""));
        this.imagebox = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\box.png"));
        
        this.l1 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\L1.png"));
        this.l2 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\L2.png"));
        this.l3 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\L3.png"));
        this.r1 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\R1.png"));
        this.r2 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\R2.png"));
        this.r3 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\R3.png"));
        
        this.n0 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\number\\0.png"));
        this.n1 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\number\\1.png"));
        this.n2 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\number\\2.png"));
        this.n3 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\number\\3.png"));
        this.n4 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\number\\4.png"));
        this.n5 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\number\\5.png"));
        this.n6 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\number\\6.png"));
        this.n7 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\number\\7.png"));
        this.n8 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\number\\8.png"));
        this.n9 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\number\\9.png"));
        
        this.bulletL = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\bullet.png"));
        this.bulletR = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\bullet.png"));
        this.bulletBL = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\bullet.png"));
        this.bulletBR = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\bullet.png"));
        
        
        this.botL1 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\ga.png"));
        this.botL2 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\ga.png"));
        this.botL3 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\ga.png"));
        this.botR1 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\ga.png"));
        this.botR2 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\ga.png"));
        this.botR3 = ImageIO.read(new File("C:\\Users\\user\\Desktop\\Gamejava-master\\Lab5As1\\ga.png"));
        new Timer(10, this).start();
        bgx1 = 0;
        bgx2 = 800;
        bgx3 = 300 + rand.nextInt(400);
        way = 0;
        sp = 5;
        bgy = 0;
        hu = 0;
        hu1 = 1;
        walk = 0;
        walk1 = 0;
        x = 100;
        x1 = 2000;
        bl = 0;
        br = 50;
        up = 400;
        up1 = 400;
        upb = 470;
        jump = false;
        jumpl = false;
        jumpr = false;
        down = false;
        downn = false;
        l = false;
        u = false;
        bullet = false;
        b = false;
        bL = false;
        bR = false;
        point = false;
        point1 = false;
        setFocusable(true);
        addKeyListener(this);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(this.imagebg1, bgx1, bgy, null);
        g.drawImage(this.imagebg2, bgx2, bgy, null);
        g.drawImage(this.imagebg3, bgx3, bgy, null);
        g.drawImage(this.imagebg4, bgx4, bgy, null);
        g.drawImage(this.imagebox, bgxbox - way, bgy + 450, 100, 100, null);

        if (hu == 1) {
            if ((walk / 3) % 3 == 0) {
                g.drawImage(this.l1, x, up, 100, 150, null);
            } else if ((walk / 3) % 3 == 1) {
                g.drawImage(this.l2, x, up, 100, 150, null);
            } else if ((walk / 3) % 3 == 2) {
                g.drawImage(this.l3, x, up, 100, 150, null);
            }
        } else if (hu == 2) {
            if ((walk / 3) % 3 == 0) {
                g.drawImage(this.r1, x, up, 100, 150, null);
            } else if ((walk / 3) % 3 == 1) {
                g.drawImage(this.r2, x, up, 100, 150, null);
            } else if ((walk / 3) % 3 == 2) {
                g.drawImage(this.r3, x, up, 100, 150, null);
            }
        } else {
            g.drawImage(this.r1, x, up, 100, 150, null);
        }
        if (hu1 == 1) {
            if ((walk1 / 10) % 3 == 0) {
                g.drawImage(this.botL1, x1 - way, up1, 100, 100, null);
            } else if ((walk1 / 10) % 3 == 1) {
                g.drawImage(this.botL2, x1 - way, up1, 100, 100, null);
            } else if ((walk1 / 10) % 3 == 2) {
                g.drawImage(this.botL3, x1 - way, up1, 100, 100, null);
            }
        } else if (hu1 == 2) {
            if ((walk1 / 10) % 3 == 0) {
                g.drawImage(this.botR1, x1 - way, up1, 100, 100, null);
            } else if ((walk1 / 10) % 3 == 1) {
                g.drawImage(this.botR2, x1 - way, up1, 100, 100, null);
            } else if ((walk1 / 10) % 3 == 2) {
                g.drawImage(this.botR3, x1 - way, up1, 100, 100, null);
            }
        } else if (hu1 == 3) {
            point = true;
            hu1 = 4;
            bL = false;
            bR = false;
            b = false;
            bullet = false;
            bl = 0;
            br = 50;           
            x1 = bgxbox - way + 50;
            
        } 
        if (score < 0) {
            score = 0;
        }
        if (score >= 100000) {
            score = 99999;
        }
        if ((score / 10) % 10 == 0) {
            g.drawImage(this.n0, 730, 30, null);
        } else if ((score / 10) % 10 == 1) {
            g.drawImage(this.n1, 730, 30, null);
        } else if ((score / 10) % 10 == 2) {
            g.drawImage(this.n2, 730, 30, null);
        } else if ((score / 10) % 10 == 3) {
            g.drawImage(this.n3, 730, 30, null);
        } else if ((score / 10) % 10 == 4) {
            g.drawImage(this.n4, 730, 30, null);
        } else if ((score / 10) % 10 == 5) {
            g.drawImage(this.n5, 730, 30, null);
        } else if ((score / 10) % 10 == 6) {
            g.drawImage(this.n6, 730, 30, null);
        } else if ((score / 10) % 10 == 7) {
            g.drawImage(this.n7, 730, 30, null);
        } else if ((score / 10) % 10 == 8) {
            g.drawImage(this.n8, 730, 30, null);
        } else if ((score / 10) % 10 == 9) {
            g.drawImage(this.n9, 730, 30, null);
        }
        if ((score / 100) % 10 == 0) {
            g.drawImage(this.n0, 697, 30, null);
        } else if ((score / 100) % 10 == 1) {
            g.drawImage(this.n1, 697, 30, null);
        } else if ((score / 100) % 10 == 2) {
            g.drawImage(this.n2, 697, 30, null);
        } else if ((score / 100) % 10 == 3) {
            g.drawImage(this.n3, 697, 30, null);
        } else if ((score / 100) % 10 == 4) {
            g.drawImage(this.n4, 697, 30, null);
        } else if ((score / 100) % 10 == 5) {
            g.drawImage(this.n5, 697, 30, null);
        } else if ((score / 100) % 10 == 6) {
            g.drawImage(this.n6, 697, 30, null);
        } else if ((score / 100) % 10 == 7) {
            g.drawImage(this.n7, 697, 30, null);
        } else if ((score / 100) % 10 == 8) {
            g.drawImage(this.n8, 697, 30, null);
        } else if ((score / 100) % 10 == 9) {
            g.drawImage(this.n9, 697, 30, null);
        }
        if ((score / 1000) % 10 == 0) {
            g.drawImage(this.n0, 664, 30, null);
        } else if ((score / 1000) % 10 == 1) {
            g.drawImage(this.n1, 664, 30, null);
        } else if ((score / 1000) % 10 == 2) {
            g.drawImage(this.n2, 664, 30, null);
        } else if ((score / 1000) % 10 == 3) {
            g.drawImage(this.n3, 664, 30, null);
        } else if ((score / 1000) % 10 == 4) {
            g.drawImage(this.n4, 664, 30, null);
        } else if ((score / 1000) % 10 == 5) {
            g.drawImage(this.n5, 664, 30, null);
        } else if ((score / 1000) % 10 == 6) {
            g.drawImage(this.n6, 664, 30, null);
        } else if ((score / 1000) % 10 == 7) {
            g.drawImage(this.n7, 664, 30, null);
        } else if ((score / 1000) % 10 == 8) {
            g.drawImage(this.n8, 664, 30, null);
        } else if ((score / 1000) % 10 == 9) {
            g.drawImage(this.n9, 664, 30, null);
        }
        if ((score / 10000) % 10 == 0) {
            g.drawImage(this.n0, 631, 30, null);
        } else if ((score / 10000) % 10 == 1) {
            g.drawImage(this.n1, 631, 30, null);
        } else if ((score / 10000) % 10 == 2) {
            g.drawImage(this.n2, 631, 30, null);
        } else if ((score / 10000) % 10 == 3) {
            g.drawImage(this.n3, 631, 30, null);
        } else if ((score / 10000) % 10 == 4) {
            g.drawImage(this.n4, 631, 30, null);
        } else if ((score / 10000) % 10 == 5) {
            g.drawImage(this.n5, 631, 30, null);
        } else if ((score / 10000) % 10 == 6) {
            g.drawImage(this.n6, 631, 30, null);
        } else if ((score / 10000) % 10 == 7) {
            g.drawImage(this.n7, 631, 30, null);
        } else if ((score / 10000) % 10 == 8) {
            g.drawImage(this.n8, 631, 30, null);
        } else if ((score / 10000) % 10 == 9) {
            g.drawImage(this.n9, 631, 30, null);
        }

        if (bR == true && hu == 2) {
            g.drawImage(this.bulletR, x + br, upb, 50, 30, null);
        }
        if (bL == true && hu == 1) {
            g.drawImage(this.bulletL, x + bl, upb, 50, 30, null);
        }
        if (hu1 == 1) {
            g.drawImage(this.bulletBL, (x1 - way) + bl1, up1 + 70, 50, 30, null);
        }
        if (hu1 == 2) {
            g.drawImage(this.bulletBR, (x1 - way) + br1, up1 + 70, 50, 30, null);
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();

        if (down == true || bullet == true) {

        } else {

            if (key == KeyEvent.VK_LEFT) {
                l = true;
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
                hu = 1;
                walk++;

                if (way + x + 80 >= bgxbox + 160 && way + x + 80 <= bgxbox + 165) {
                    //System.out.println(way + x + 80);

                    clip2.start();
                } else {
                    if (up == 300) {
                        down = true;
                    }
                    //System.out.println(bgx3);
                    clip2.setMicrosecondPosition(0);
                    clip2.stop();
                    way -= sp;
                    bgx1 += sp;
                    bgx2 += sp;
                    score++;
                    x -= 2;

                    if (x <= 0 && x >= -3) {

                        x = 10;
                    }
                    if (bgx1 >= 800) {
                        bgx1 = -800;
                    }
                    if (bgx2 >= 800) {
                        bgx2 = -800;
                    }

                }
            }
            if (key == KeyEvent.VK_RIGHT) {
                r = true;
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
                hu = 2;
                walk++;
                score++;
                if (way + x + 80 <= bgxbox && way + x + 80 >= bgxbox - 5) {

                    clip2.start();
                } else {
                    if (up == 300) {
                        down = true;
                    }
                    //System.out.println(way+x+80);
                    //System.out.println("bgx "+(bgx3+40));
                    //System.out.println(way + x + 80);
                    //System.out.println("bgx "+bgx3);
                    clip2.setMicrosecondPosition(0);
                    clip2.stop();

                    way += sp;
                    bgx1 -= sp;
                    bgx2 -= sp;
                    x += 2;
                    if (x >= 200) {
                        x = 200;
                    }
                    if (bgx1 <= -800) {
                        bgx1 = 800;
                    }
                    if (bgx2 <= -800) {
                        bgx2 = 800;
                    }

                }

            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int key = ke.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            walk = 0;
            clip.stop();
        }
        if (key == KeyEvent.VK_RIGHT) {
            walk = 0;
            clip.stop();
        }
        if (down == true) {

        } else {
            if (key == KeyEvent.VK_UP) {
                u = true;
            }
        }
        if (key == KeyEvent.VK_SPACE) {
            if (bullet == true) {

            } else {
                b = true;
                upb = up + 70;
            }
            //System.out.println("fire");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (hu == 2 && u == true) {
            jumpr = true;
        }
        if (hu == 1 && u == true) {
            jumpl = true;
        }

        if (jumpr == true) {
            score++;
            //System.out.println(way + x + 80);
            if (up <= 150) {
                jumpr = false;
                u = false;
                down = true;
            }
            if (way + x + 80 >= bgxbox && bgy >= 400) {
                jumpr = false;
                u = false;
                down = true;
            } else {
                up -= 5;
                bgx1 -= 5;
                bgx2 -= 5;
                way += 5;
                x += 2;
                if (x >= 200) {
                    x = 200;
                }
                if (bgx1 <= -800) {
                    bgx1 = 800;
                }
                if (bgx2 <= -800) {
                    bgx2 = 800;
                }
                if (way + x + 80 >= bgxbox && way + x + 80 <= bgxbox + 160) {
                    point = true;
                }
            }
        }
        if (jumpl == true) {
            if (up <= 150) {
                jumpl = false;
                u = false;
                down = true;
            } else {
                up -= 5;
                //System.out.println(bgx1);
                bgx1 += 5;
                bgx2 += 5;
                way -= 5;
                score++;
                x -= 2;

                if (x <= 10) {
                    x = 10;
                }
                if (bgx1 >= 800) {
                    bgx1 = -800;
                }
                if (bgx2 >= 800) {
                    bgx2 = -800;
                }
                if (way + x + 80 >= bgxbox && way + x + 80 <= bgxbox + 160) {
                    point = true;
                }
            }
        }

        if (down == true) {
            if (up >= 400) {

                down = false;
                l = false;
                r = false;

            } else {

                if (up == 300 && (way + x + 80 >= bgxbox && way + x + 80 <= bgxbox + 160)) {
                    down = false;
                    l = false;
                    r = false;

                } else if (way + x + 80 == bgxbox || way + x + 80 == bgxbox + 160) {
                    up += 5;

                } else {
                    //System.out.println("down " + up);
                    up += 5;

                }

            }
        }

        if (up == 400) {
            if (point == true) {
                score += 1000;
            }
            if (point1 == true) {
                score -= 100;
            }
            point = false;
            point1 = false;
        }
        if (hu == 1 && b == true) {
            bL = true;
        }
        if (bL == true) {
            if (x + bl <= 0 || x + bl >= bgxbox - way + 80 && x + bl <= bgxbox - way + 90 && up >= 300 || x + bl >= x1 - way && x + bl <= x1 - way + 50 && up >= 350) {
                bL = false;
                b = false;
                bullet = false;
                bl = 0;
            } else {
                bl -= 10;
                bullet = true;
            }
        }
        if (hu == 2 && b == true) {
            bR = true;

        }
        if (bR == true) {
            if (x + br >= 800 || x + br >= bgxbox - way - 30 && x + br <= bgxbox - way - 20 && up >= 300 || x + br >= x1 && x + br <= x + 10 || x + br >= x1 - way && x + br <= x1 - way + 100 && up >= 350) {
                bR = false;
                b = false;
                bullet = false;
                br = 50;
            } else {
                br += 10;
                bullet = true;
            }
        }
        if (hu1 == 1) {
            x1--;
            walk1++;
            if ((x1 - way) + bl1 <= 0 || (x1 - way) + bl1 >= bgxbox - way + 80 && (x1 - way) + bl1 <= bgxbox - way + 90) {
                bl1 = 0;
            } else if ((x1 - way) + bl1 >= x && (x1 - way) + bl1 <= x + 50) {
                point1 = true;
                bl1 = 0;
            } else {
                bl1 -= 10;
            }
            if (way + (x1 - way) + 80 >= bgxbox + 160 && way + (x1 - way) + 80 <= bgxbox + 165) {
                hu1 = 2;
            }
        }
        if (hu1 == 2) {
            walk1++;
            x1++;
            if ((x1 - way) + br1 >= 800) {
                br1 = 50;
            } else if ((x1 - way) + br1 >= x && (x1 - way) + br1 <= x + 50) {
                point1 = true;
                br1 = 50;
            } else {

                br1 += 10;
            }
        }
        if ((hu1 == 1 || hu1 == 2) && (bR == true || bL == true) && (x + br >= x1 - way && x + br <= x1 - way + 100 && up >= 350 || x + bl >= x1 - way && x + bl <= x1 - way + 50 && up >= 350)) {
            hu1 = 3;
        }
    }
}

class frame extends JFrame {

    frame() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        this.add(new panel());
        this.setTitle("GAME");
    }
}
public class Wingbabpeetoon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        frame f = new frame();
        f.setSize(800, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
}
