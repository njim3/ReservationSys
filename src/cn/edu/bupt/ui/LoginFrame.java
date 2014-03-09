package cn.edu.bupt.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

import cn.edu.bupt.bll.LoginAction;
import cn.edu.bupt.dal.DBOper;
import cn.edu.bupt.model.Statics;
import cn.edu.bupt.model.UserInfo;
import cn.edu.bupt.util.SysTool;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class LoginFrame {

    private JFrame frame;
    private JTextField usernameTF;
    private JPasswordField passwordTF;
    private JTextField captchaTF;
    private JLabel captchaLbl;
    private String captchaStr;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // 连接数据库
                    DBOper.getInstance();
                    // 创建图片文件夹
                    SysTool.createImageFoler();
                    LoginFrame window = new LoginFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public LoginFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setType(Type.UTILITY);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
        frame.setResizable(false);
        frame.setTitle("登录");
        frame.setBounds(100, 100, 355, 267);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        
        JLabel lblNewLabel = new JLabel("订房系统");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblNewLabel.setBounds(130, 10, 86, 35);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel usernameLbl = new JLabel("用户名：");
        usernameLbl.setFont(new Font("宋体", Font.PLAIN, 15));
        usernameLbl.setBounds(67, 66, 60, 18);
        frame.getContentPane().add(usernameLbl);
        
        JLabel passwordLbl = new JLabel("密码：");
        passwordLbl.setFont(new Font("宋体", Font.PLAIN, 15));
        passwordLbl.setBounds(82, 106, 45, 18);
        frame.getContentPane().add(passwordLbl);
        
        usernameTF = new JTextField();
        usernameTF.setBounds(128, 64, 127, 21);
        frame.getContentPane().add(usernameTF);
        usernameTF.setColumns(10);
        
        passwordTF = new JPasswordField();
        passwordTF.setColumns(10);
        passwordTF.setBounds(128, 104, 127, 21);
        frame.getContentPane().add(passwordTF);
        
        JLabel captchaTextLbl = new JLabel("验证码：");
        captchaTextLbl.setFont(new Font("宋体", Font.PLAIN, 15));
        captchaTextLbl.setBounds(67, 146, 60, 18);
        frame.getContentPane().add(captchaTextLbl);
        
        captchaTF = new JTextField();
        captchaTF.setColumns(10);
        captchaTF.setBounds(128, 145, 66, 21);
        frame.getContentPane().add(captchaTF);
        
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBounds(204, 146, 36, 18);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        captchaLbl = new JLabel("1234");
        captchaLbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                adjustCaptchaNum();
            }
        });
        captchaLbl.setForeground(Color.RED);
        captchaLbl.setBounds(1, 0, 34, 18);
        panel.add(captchaLbl);
        captchaLbl.setFont(new Font("幼圆", Font.PLAIN, 15));
        
        JButton loginBtn = new JButton("登录");
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usernameTF.setText("admin");
                passwordTF.setText("admin");
                captchaTF.setText(captchaStr);
                
                JButton btn = (JButton)e.getSource();
                
                btn.setEnabled(false);
                
                String usernameStr = usernameTF.getText().trim();
                String passwordStr = new String(passwordTF.getPassword()).trim();
                String captchaTFStr = captchaTF.getText().trim();
                
                if (usernameStr.length() == 0 || passwordStr.length() == 0 ||
                        captchaTFStr.length() == 0) {
                    JOptionPane.showMessageDialog(null, "请将信息填写完整！", 
                            "提示", JOptionPane.WARNING_MESSAGE);
                    
                    btn.setEnabled(true);
                    
                    return ;
                }
                
                if (!captchaTFStr.equals(captchaStr)) {
                    JOptionPane.showMessageDialog(null, "验证码不正确！", 
                            "提示", JOptionPane.WARNING_MESSAGE);
                    
                    adjustCaptchaNum();
                    btn.setEnabled(true);
                    
                    return ;
                }
                
                UserInfo userInfo = new UserInfo(usernameStr, passwordStr);
                LoginAction loginAct = new LoginAction(userInfo);
                
                boolean loginRes = loginAct.login();
                if (!loginRes) {
                    JOptionPane.showMessageDialog(null, "用户名或密码不正确！", 
                            "提示", JOptionPane.WARNING_MESSAGE);
                    
                    adjustCaptchaNum();
                    btn.setEnabled(true);
                    
                    return ;
                }
                
                frame.dispose();
                
                MainFrame mainFrame = new MainFrame(userInfo);
                
                mainFrame.setVisible(true);
            }
        });
        loginBtn.setBounds(139, 186, 66, 25);
        frame.getContentPane().add(loginBtn);
        
        adjustCaptchaNum();
    }
    
    private void adjustCaptchaNum() {
        this.captchaStr = SysTool.generateRandomNum();
        
        this.captchaLbl.setText(captchaStr);
    }
}
