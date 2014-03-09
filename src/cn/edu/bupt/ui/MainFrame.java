package cn.edu.bupt.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import cn.edu.bupt.model.Statics;
import cn.edu.bupt.model.UserInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {

    private JPanel contentPane;
    private UserInfo userInfo;      // 为后期扩展做准备
    private JLabel dateLbl;
    private JLayeredPane contentLayeredPane;
    private JPanel welcomePanel;
    private JPanel searchRoomPanel;
    private JPanel checkoutPanel;
    private JPanel searchCheckinPanel;
    private List<JPanel> panelList = new ArrayList<JPanel>();
    private JTextField srRoomIdTF;
    private JComboBox srRoomTypeCB;
    private JTable searchRoomResTable;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTable searchCheckinResTable;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTable checkoutResTable;
    
    public MainFrame(UserInfo aUser) {
        this.userInfo = aUser;
        
        initialize();
    }

    /**
     * Create the frame.
     */
    private void initialize() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
        setResizable(false);
        setTitle("主界面 - 订房");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 544, 432);
        contentPane = new JPanel();
        contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 536, 21);
        contentPane.add(menuBar);
        
        JMenu mnNewMenu = new JMenu("选房");
        mnNewMenu.setFont(new Font("宋体", Font.PLAIN, 12));
        menuBar.add(mnNewMenu);
        
        JMenuItem menuItem = new JMenuItem("查询房间");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bringPanelToFront(e.getActionCommand());
            }
        });
        menuItem.setFont(new Font("宋体", Font.PLAIN, 12));
        mnNewMenu.add(menuItem);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("录入信息");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RecordInfoFrame recordInfoFrame = new RecordInfoFrame();
                
                recordInfoFrame.setVisible(true);
            }
        });
        mntmNewMenuItem.setFont(new Font("宋体", Font.PLAIN, 12));
        mnNewMenu.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("查询入住");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bringPanelToFront(e.getActionCommand());
            }
        });
        mntmNewMenuItem_2.setFont(new Font("宋体", Font.PLAIN, 12));
        mnNewMenu.add(mntmNewMenuItem_2);
        
        JMenu mnNewMenu_1 = new JMenu("退房");
        mnNewMenu_1.setFont(new Font("宋体", Font.PLAIN, 12));
        menuBar.add(mnNewMenu_1);
        
        JMenuItem menuItem_1 = new JMenuItem("退房结账");
        menuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bringPanelToFront(e.getActionCommand());
            }
        });
        menuItem_1.setFont(new Font("宋体", Font.PLAIN, 12));
        mnNewMenu_1.add(menuItem_1);
        
        JMenu mnNewMenu_2 = new JMenu("关于");
        mnNewMenu_2.setFont(new Font("宋体", Font.PLAIN, 12));
        menuBar.add(mnNewMenu_2);
        
        JMenuItem menuItem_2 = new JMenuItem("欢迎界面");
        menuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bringPanelToFront(e.getActionCommand());
            }
        });
        menuItem_2.setFont(new Font("宋体", Font.PLAIN, 12));
        mnNewMenu_2.add(menuItem_2);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("关于软件");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "订房系统 V1.0", "关于", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        mntmNewMenuItem_1.setFont(new Font("宋体", Font.PLAIN, 12));
        mnNewMenu_2.add(mntmNewMenuItem_1);
        
        JLabel lblNewLabel = new JLabel("管理员，您好！");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 31, 115, 21);
        contentPane.add(lblNewLabel);
        
        dateLbl = new JLabel("");
        dateLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        dateLbl.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        dateLbl.setBounds(296, 31, 232, 21);
        contentPane.add(dateLbl);
        
        contentLayeredPane = new JLayeredPane();
        contentLayeredPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        contentLayeredPane.setBounds(10, 62, 518, 335);
        contentPane.add(contentLayeredPane);
        
        welcomePanel = new JPanel();
        contentLayeredPane.setLayer(welcomePanel, 3);
        welcomePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        welcomePanel.setBounds(0, 0, 518, 335);
        contentLayeredPane.add(welcomePanel);
        panelList.add(welcomePanel);
        
        JLabel backgroundLbl = new JLabel("");
        backgroundLbl.setBounds(1, 1, 516, 333);
        String backgroundImageFilePath = Statics.PORTRAIT_FOLDER +
                Statics.BG_NAME;
        System.out.println(backgroundImageFilePath);
        welcomePanel.setLayout(null);
        backgroundLbl.setIcon(new ImageIcon(backgroundImageFilePath));
        welcomePanel.add(backgroundLbl);
        
        searchRoomPanel = new JPanel();
        searchRoomPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        contentLayeredPane.setLayer(searchRoomPanel, 2);
        searchRoomPanel.setBounds(0, 0, 518, 335);
        contentLayeredPane.add(searchRoomPanel);
        searchRoomPanel.setLayout(null);
        panelList.add(searchRoomPanel);
        
        JLabel lblNewLabel_1 = new JLabel("查询房间");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(22, 22, 73, 15);
        searchRoomPanel.add(lblNewLabel_1);
        
        JLabel label_2 = new JLabel("房间号：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 12));
        label_2.setBounds(66, 50, 54, 15);
        searchRoomPanel.add(label_2);
        
        srRoomIdTF = new JTextField();
        srRoomIdTF.setBounds(134, 47, 100, 21);
        searchRoomPanel.add(srRoomIdTF);
        srRoomIdTF.setColumns(10);
        
        JLabel label_3 = new JLabel("查询类型：");
        label_3.setFont(new Font("宋体", Font.PLAIN, 12));
        label_3.setBounds(54, 80, 73, 21);
        searchRoomPanel.add(label_3);
        
        srRoomTypeCB = new JComboBox();
        srRoomTypeCB.setModel(new DefaultComboBoxModel(new String[] {"全部", "已入住", "未入住"}));
        srRoomTypeCB.setFont(new Font("宋体", Font.PLAIN, 12));
        srRoomTypeCB.setBounds(134, 78, 54, 23);
        searchRoomPanel.add(srRoomTypeCB);
        
        JButton srSearchBtn = new JButton("查询");
        srSearchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        srSearchBtn.setFont(new Font("宋体", Font.PLAIN, 12));
        srSearchBtn.setBounds(272, 50, 67, 51);
        searchRoomPanel.add(srSearchBtn);
        
        JLabel label_4 = new JLabel("结果显示");
        label_4.setFont(new Font("宋体", Font.PLAIN, 14));
        label_4.setBounds(22, 120, 73, 15);
        searchRoomPanel.add(label_4);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 145, 498, 180);
        searchRoomPanel.add(scrollPane);
        
        searchRoomResTable = new JTable();
        searchRoomResTable.setFont(new Font("宋体", Font.PLAIN, 12));
        searchRoomResTable.setFillsViewportHeight(true);
        scrollPane.setViewportView(searchRoomResTable);
        
        searchCheckinPanel = new JPanel();
        contentLayeredPane.setLayer(searchCheckinPanel, 1);
        searchCheckinPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        searchCheckinPanel.setBounds(0, 0, 518, 335);
        contentLayeredPane.add(searchCheckinPanel);
        panelList.add(searchCheckinPanel);
        searchCheckinPanel.setLayout(null);
        
        JLabel label_1 = new JLabel("查询入住");
        label_1.setBounds(22, 22, 56, 16);
        label_1.setFont(new Font("宋体", Font.PLAIN, 14));
        searchCheckinPanel.add(label_1);
        
        JLabel label_5 = new JLabel("姓名：");
        label_5.setFont(new Font("宋体", Font.PLAIN, 12));
        label_5.setBounds(177, 55, 47, 15);
        searchCheckinPanel.add(label_5);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("宋体", Font.PLAIN, 12));
        textField_1.setBounds(217, 52, 102, 21);
        searchCheckinPanel.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel label_6 = new JLabel("房号：");
        label_6.setFont(new Font("宋体", Font.PLAIN, 12));
        label_6.setBounds(61, 55, 47, 15);
        searchCheckinPanel.add(label_6);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("宋体", Font.PLAIN, 12));
        textField_2.setColumns(10);
        textField_2.setBounds(101, 52, 66, 21);
        searchCheckinPanel.add(textField_2);
        
        JLabel label_7 = new JLabel("查询类型：");
        label_7.setFont(new Font("宋体", Font.PLAIN, 12));
        label_7.setBounds(38, 86, 66, 20);
        searchCheckinPanel.add(label_7);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"全部", "已入住", "未入住"}));
        comboBox_1.setFont(new Font("宋体", Font.PLAIN, 12));
        comboBox_1.setBounds(101, 83, 66, 23);
        searchCheckinPanel.add(comboBox_1);
        
        JLabel label_8 = new JLabel("时间：");
        label_8.setFont(new Font("宋体", Font.PLAIN, 12));
        label_8.setBounds(177, 86, 47, 20);
        searchCheckinPanel.add(label_8);
        
        JLabel label_9 = new JLabel("结果显示");
        label_9.setFont(new Font("宋体", Font.PLAIN, 14));
        label_9.setBounds(22, 120, 73, 15);
        searchCheckinPanel.add(label_9);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 145, 498, 180);
        searchCheckinPanel.add(scrollPane_1);
        
        searchCheckinResTable = new JTable();
        searchCheckinResTable.setFont(new Font("宋体", Font.PLAIN, 12));
        searchCheckinResTable.setFillsViewportHeight(true);
        scrollPane_1.setViewportView(searchCheckinResTable);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.setBounds(217, 83, 102, 23);
        searchCheckinPanel.add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 12));
        panel.add(lblNewLabel_2, BorderLayout.CENTER);
        
        JButton btnNewButton_1 = new JButton("选择");
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 12));
        btnNewButton_1.setBounds(335, 83, 66, 25);
        searchCheckinPanel.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("查询");
        btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 12));
        btnNewButton_2.setBounds(421, 50, 66, 56);
        searchCheckinPanel.add(btnNewButton_2);
        
        checkoutPanel = new JPanel();
        contentLayeredPane.setLayer(checkoutPanel, 0);
        checkoutPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        checkoutPanel.setBounds(0, 0, 518, 335);
        contentLayeredPane.add(checkoutPanel);
        checkoutPanel.setLayout(null);
        panelList.add(checkoutPanel);
        
        JLabel label = new JLabel("退房结账");
        label.setFont(new Font("宋体", Font.PLAIN, 14));
        label.setBounds(22, 22, 73, 15);
        checkoutPanel.add(label);
        
        JLabel label_10 = new JLabel("姓名：");
        label_10.setFont(new Font("宋体", Font.PLAIN, 12));
        label_10.setBounds(177, 55, 47, 15);
        checkoutPanel.add(label_10);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("宋体", Font.PLAIN, 12));
        textField_3.setColumns(10);
        textField_3.setBounds(217, 52, 102, 21);
        checkoutPanel.add(textField_3);
        
        JLabel label_11 = new JLabel("房号：");
        label_11.setFont(new Font("宋体", Font.PLAIN, 12));
        label_11.setBounds(61, 55, 47, 15);
        checkoutPanel.add(label_11);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("宋体", Font.PLAIN, 12));
        textField_4.setColumns(10);
        textField_4.setBounds(101, 52, 66, 21);
        checkoutPanel.add(textField_4);
        
        JLabel label_12 = new JLabel("时间：");
        label_12.setFont(new Font("宋体", Font.PLAIN, 12));
        label_12.setBounds(61, 90, 47, 20);
        checkoutPanel.add(label_12);
        
        JLabel label_13 = new JLabel("结果显示");
        label_13.setFont(new Font("宋体", Font.PLAIN, 14));
        label_13.setBounds(22, 120, 73, 15);
        checkoutPanel.add(label_13);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(10, 145, 498, 180);
        checkoutPanel.add(scrollPane_2);
        
        checkoutResTable = new JTable();
        checkoutResTable.setFont(new Font("宋体", Font.PLAIN, 12));
        checkoutResTable.setFillsViewportHeight(true);
        scrollPane_2.setViewportView(checkoutResTable);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(101, 87, 102, 23);
        checkoutPanel.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 12));
        panel_1.add(lblNewLabel_3, BorderLayout.CENTER);
        
        JButton button = new JButton("选择");
        button.setFont(new Font("宋体", Font.PLAIN, 12));
        button.setBounds(217, 85, 66, 25);
        checkoutPanel.add(button);
        
        JButton button_1 = new JButton("查询");
        button_1.setFont(new Font("宋体", Font.PLAIN, 12));
        button_1.setBounds(345, 54, 66, 56);
        checkoutPanel.add(button_1);
        this.setLocationRelativeTo(null);
        
        this.configureTimeDis();
        this.adjustLayeredPanel(0);
    }
    
    private void bringPanelToFront(String str) {
        if (str == null || str.length() == 0)
            return ;
        
        switch (str) {
        case "欢迎界面": {
            
            this.contentLayeredPane.setLayer(welcomePanel, Statics.getCount());
            this.adjustLayeredPanel(0);
        }
            break;
        case "查询房间": {
            
            this.contentLayeredPane.setLayer(searchRoomPanel, Statics.getCount());
            this.adjustLayeredPanel(1);
        }
            break;
        case "查询入住": {
            
            this.contentLayeredPane.setLayer(searchCheckinPanel, Statics.getCount());
            this.adjustLayeredPanel(2);
        }
            break;
        case "退房结账": {
            
            this.contentLayeredPane.setLayer(checkoutPanel, Statics.getCount());
            this.adjustLayeredPanel(3);
        }
            break;
        default:
            break;
        }
    }
    
    private void adjustLayeredPanel(int layer) {
        if (layer < 0 || layer >= panelList.size())
            return ;
        
        for (int i = 0; i < panelList.size(); ++i) {
            JPanel panel = panelList.get(i);
            
            panel.setVisible((i == layer) ? true : false);
        }
    }
    
    private void configureTimeDis() {
        Timer timer = new Timer();
        
        timer.scheduleAtFixedRate(new JLabelTimerTask(), new Date(), 
                Statics.ONE_SECOND);
    }
    
    protected class JLabelTimerTask extends TimerTask {  
        SimpleDateFormat dateFormatter = new SimpleDateFormat(  
                Statics.DEFAULT_TIME_FORMAT);
  
        @Override  
        public void run() {  
            String time = dateFormatter.format(Calendar.getInstance().getTime());  
            dateLbl.setText("今天是：" + time);
        }
    }
}
