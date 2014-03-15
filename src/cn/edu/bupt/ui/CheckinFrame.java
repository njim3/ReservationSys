package cn.edu.bupt.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import cn.edu.bupt.model.RoomInfo;

public class CheckinFrame extends JFrame {

    private JPanel contentPane;
    private JTextField cusIdTF;
    private JComboBox checkInTypeCB;
    private JLabel roomIdLbl;
    private JTextArea roomDespTA;
    
    private RoomInfo roomInfo;

    /**
     * Create the application.
     */
    public CheckinFrame(RoomInfo aInfo) {
        this.roomInfo = aInfo;
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(CheckinFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
        setTitle("入住");
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 429, 333);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("身份证号：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
        lblNewLabel.setBounds(45, 21, 70, 18);
        contentPane.add(lblNewLabel);
        
        cusIdTF = new JTextField();
        cusIdTF.setFont(new Font("宋体", Font.PLAIN, 12));
        cusIdTF.setBounds(125, 19, 108, 21);
        contentPane.add(cusIdTF);
        cusIdTF.setColumns(10);
        
        JLabel label = new JLabel("入住类型：");
        label.setFont(new Font("宋体", Font.PLAIN, 14));
        label.setBounds(45, 57, 70, 18);
        contentPane.add(label);
        
        checkInTypeCB = new JComboBox();
        checkInTypeCB.setFont(new Font("宋体", Font.PLAIN, 12));
        checkInTypeCB.setModel(new DefaultComboBoxModel(new String[] {"时租", "日租"}));
        checkInTypeCB.setBounds(125, 53, 61, 23);
        contentPane.add(checkInTypeCB);
        
        JButton checkCusidBtn = new JButton("检查");
        checkCusidBtn.setBounds(249, 17, 70, 25);
        contentPane.add(checkCusidBtn);
        
        JLabel label_1 = new JLabel("房间号：");
        label_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_1.setFont(new Font("宋体", Font.PLAIN, 14));
        label_1.setBounds(45, 91, 70, 18);
        contentPane.add(label_1);
        
        roomIdLbl = new JLabel("101");
        roomIdLbl.setFont(new Font("宋体", Font.PLAIN, 14));
        roomIdLbl.setBounds(125, 90, 70, 18);
        contentPane.add(roomIdLbl);
        
        JLabel label_3 = new JLabel("房间介绍：");
        label_3.setFont(new Font("宋体", Font.PLAIN, 14));
        label_3.setBounds(45, 119, 70, 18);
        contentPane.add(label_3);
        
        roomDespTA = new JTextArea();
        roomDespTA.setWrapStyleWord(true);
        roomDespTA.setEditable(false);
        roomDespTA.setFont(new Font("宋体", Font.PLAIN, 13));
        roomDespTA.setBounds(125, 121, 216, 105);
        contentPane.add(roomDespTA);
        
        JButton checkInBtn = new JButton("入住");
        checkInBtn.setBounds(163, 250, 70, 25);
        contentPane.add(checkInBtn);
        this.setLocationRelativeTo(null);
        
        this.refreshView();
    }
    
    private void refreshView() {
        roomIdLbl.setText(roomInfo.getRoomId());
        roomDespTA.setText(roomInfo.getRoomDescription());
    }
}
