package cn.edu.bupt.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import cn.edu.bupt.bll.RecordInfoAction;
import cn.edu.bupt.bll.RecordReserveAction;
import cn.edu.bupt.model.ReserveInfo;
import cn.edu.bupt.model.RoomInfo;
import cn.edu.bupt.model.Statics;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        checkCusidBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cusIdStr = cusIdTF.getText().trim();
                
                boolean res = checkCusId(cusIdStr);
                
                if (res)
                    JOptionPane.showMessageDialog(null, "身份证号通过检查！", "检查", 
                            JOptionPane.INFORMATION_MESSAGE);
            }
        });
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
        roomDespTA.setLineWrap(true);
        roomDespTA.setEditable(false);
        roomDespTA.setFont(new Font("宋体", Font.PLAIN, 13));
        roomDespTA.setBounds(125, 121, 216, 105);
        contentPane.add(roomDespTA);
        
        JButton checkInBtn = new JButton("入住");
        checkInBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cusIdStr = cusIdTF.getText().trim();
                
                boolean res = checkCusId(cusIdStr);
                
                if (!res)
                    return ;
                
                int roomType = checkInTypeCB.getSelectedIndex();
                int roomId = Integer.parseInt(roomIdLbl.getText().trim());
                
                // 首先插入数据，然后再更新room表
                ReserveInfo reserveInfo = new ReserveInfo(cusIdStr, roomId, 
                        roomType);
                
                RecordReserveAction act = new RecordReserveAction(reserveInfo);
                
                res = act.recordInfo();
                
                if (!res) {
                    JOptionPane.showMessageDialog(null, "录入失败！", "警告", 
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "录入成功！", "提示", 
                            JOptionPane.INFORMATION_MESSAGE);
                    
                    dispose();
                }
                
            }
        });
        checkInBtn.setBounds(163, 250, 70, 25);
        contentPane.add(checkInBtn);
        this.setLocationRelativeTo(null);
        
        this.refreshView();
    }
    
    private void refreshView() {
        roomIdLbl.setText(roomInfo.getRoomId());
        roomDespTA.setText(roomInfo.getRoomDescription());
    }
    
    private boolean checkCusId(String aIdStr) {
        if (aIdStr.length() == 0) {
            JOptionPane.showMessageDialog(null, "身份证号不能为空！", "提示", 
                    JOptionPane.WARNING_MESSAGE);
            
            return false;
        }
        
        if (!aIdStr.matches("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))" +
                "(([0|1|2]\\d)|3[0-1])\\d{4}$")) {
            JOptionPane.showMessageDialog(null, "身份证号格式不对！", "提示", 
                    JOptionPane.WARNING_MESSAGE);
            
            return false;
        }
        
        // 查询数据库
        RecordInfoAction act = new RecordInfoAction();
        
        boolean res = act.searchIdFromDB(aIdStr);
        
        if (!res) {
            JOptionPane.showMessageDialog(null, "数据库中没有该身份证号！请先录入！", "警告", 
                    JOptionPane.ERROR_MESSAGE);
            
            return false;
        } else {
            // 查询该customer是否已经订房
            boolean resCheckInRoom = act.isIdCheckInRoom(aIdStr);
            
            if (resCheckInRoom) {
                JOptionPane.showMessageDialog(null, "该身份证号已开房间！", "警告", 
                        JOptionPane.ERROR_MESSAGE);
                
                return false;
            }
        }
        
        return true;
    }
}
