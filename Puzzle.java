import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Random;


public class Puzzle extends JFrame {
    JButton[][] buttons = new JButton[3][3];
    int count = 0;

    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();

    }

    public Puzzle() {
        setSize(400, 400);
        setTitle("华容道游戏  作者：刘雪桥");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        File file = new File("buttons.bak");
        if (file.exists()) {

            if (JOptionPane.showConfirmDialog(null, "您需要恢复之前的游戏进度吗？", "询问", JOptionPane.YES_NO_OPTION) == 0) {
                createButtonsByFile();
            } else {
                createTestButtons();
            }
            file.delete();
        } else {

            createTestButtons();
        }


        //随机生成按钮
        //createButtons();

        //生成测试用的按钮组
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "您需要保存未完成给的游戏吗？", "询问", JOptionPane.YES_NO_OPTION) == 0) {
                    String num = "";
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            num += buttons[i][j].getText();
                        }
                    }

                    int i = 10;
                    FileOutputStream fos = null;
                    try {
                        fos = new FileOutputStream("buttons.bak");
                        fos.write(num.getBytes());
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } finally {
                        try {
                            if (fos != null) {
                                fos.close();
                            }
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
        setVisible(true);
    }

    private void createButtonsByFile() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("buttons.bak");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    buttons[i][j] = new JButton((char) fis.read() + "");
                    buttons[i][j].addActionListener(e -> btnClick(e));
                    if(buttons[i][j].getText().equals("9")){
                    buttons[i][j].setVisible(false);}


                    add(buttons[i][j]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



    public void createTestButtons() {
        int num = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton(num + "");
                buttons[i][j].addActionListener(e -> btnClick(e));
                add(buttons[i][j]);
                num++;
            }
        }
        buttons[0][1].setText("9");
        buttons[0][1].setVisible(false);
        buttons[2][2].setText("2");
    }

    JButton button = null;

    private void btnClick(ActionEvent e) {
        button = (JButton) e.getSource();
        if (button == buttons[0][0]) {
            if (buttons[0][1].getText().equals("9")) {
                replace(buttons[0][1]);
            } else if (buttons[1][0].getText().equals("9")) {
                replace(buttons[1][0]);
            }
        } else if (button == buttons[0][1]) {
            if (buttons[0][0].getText().equals("9")) {
                replace(buttons[0][0]);
            } else if (buttons[0][2].getText().equals("9")) {
                replace(buttons[0][2]);
            } else if (buttons[1][1].getText().equals("9")) {
                replace(buttons[1][1]);
            }
        } else if (button == buttons[0][2]) {
            if (buttons[0][1].getText().equals("9")) {
                replace(buttons[0][1]);
            } else if (buttons[1][2].getText().equals("9")) {
                replace(buttons[1][2]);
            }
        } else if (button == buttons[1][0]) {
            if (buttons[0][0].getText().equals("9")) {
                replace(buttons[0][0]);
            } else if (buttons[1][1].getText().equals("9")) {
                replace(buttons[1][1]);
            } else if (buttons[2][0].getText().equals("9")) {
                replace(buttons[2][0]);
            }
        } else if (button == buttons[1][1]) {
            if (buttons[1][0].getText().equals("9")) {
                replace(buttons[1][0]);
            } else if (buttons[0][1].getText().equals("9")) {
                replace(buttons[0][1]);
            } else if (buttons[1][2].getText().equals("9")) {
                replace(buttons[1][2]);
            } else if (buttons[2][1].getText().equals("9")) {
                replace(buttons[2][1]);
            }
        } else if (button == buttons[1][2]) {
            if (buttons[0][2].getText().equals("9")) {
                replace(buttons[0][2]);
            } else if (buttons[1][1].getText().equals("9")) {
                replace(buttons[1][1]);
            } else if (buttons[2][2].getText().equals("9")) {
                replace(buttons[2][2]);
            }
        } else if (button == buttons[2][0]) {
            if (buttons[1][0].getText().equals("9")) {
                replace(buttons[1][0]);
            } else if (buttons[2][1].getText().equals("9")) {
                replace(buttons[2][1]);
            }
        } else if (button == buttons[2][1]) {
            if (buttons[2][0].getText().equals("9")) {
                replace(buttons[2][0]);
            } else if (buttons[1][1].getText().equals("9")) {
                replace(buttons[1][1]);
            } else if (buttons[2][2].getText().equals("9")) {
                replace(buttons[2][2]);
            }
        } else if (button == buttons[2][2]) {
            if (buttons[2][1].getText().equals("9")) {
                replace(buttons[2][1]);
            } else if (buttons[1][2].getText().equals("9")) {
                replace(buttons[1][2]);
            }
        }
        if (buttons[0][0].getText().equals("1") && buttons[0][1].getText().equals("2") && buttons[0][2].getText().equals("3")
                && buttons[1][0].getText().equals("4") && buttons[1][1].getText().equals("5") && buttons[1][2].getText().equals("6")
                && buttons[2][0].getText().equals("7") && buttons[2][1].getText().equals("8")) {
            JOptionPane.showMessageDialog(this, "游戏成功，您共用了" + count + "步。");
            System.exit(0);
        }
    }

    public void replace(JButton btn9) {

        count++;
        btn9.setText(button.getText());
        btn9.setVisible(true);
        button.setText("9");
        button.setVisible(false);
    }


}