package cn.edu.bupt.ui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

import cn.edu.bupt.bll.RecordInfoAction;
import cn.edu.bupt.model.CustomerInfo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class RecordInfoFrame extends JFrame {

    private JPanel contentPane;
    private JTextField idTF;
    private JTextField nameTF;
    private JRadioButton maleRB;
    private JRadioButton femaleRB;
    private JTextField ageTF;
    private JComboBox nationCB;
    private JTextField addressTF;
    private JLabel portraitLbl;
    
    private String portraitStr;
    
    public static void main(String[] args) {
        RecordInfoFrame frame = new RecordInfoFrame();
        
        frame.setVisible(true);
    }

    /**
     * Create the frame.
     */
    public RecordInfoFrame() {
        setTitle("信息录入");
        setIconImage(Toolkit.getDefaultToolkit().getImage(RecordInfoFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 511, 346);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("身份证号：");
        label.setFont(new Font("宋体", Font.PLAIN, 12));
        label.setBounds(35, 21, 71, 15);
        contentPane.add(label);
        
        idTF = new JTextField();
        idTF.setFont(new Font("宋体", Font.PLAIN, 12));
        idTF.setBounds(99, 18, 121, 21);
        contentPane.add(idTF);
        idTF.setColumns(10);
        
        JLabel label_1 = new JLabel("姓名：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 12));
        label_1.setBounds(60, 56, 36, 15);
        contentPane.add(label_1);
        
        nameTF = new JTextField();
        nameTF.setFont(new Font("宋体", Font.PLAIN, 12));
        nameTF.setColumns(10);
        nameTF.setBounds(99, 53, 93, 21);
        contentPane.add(nameTF);
        
        JButton checkIdBtn = new JButton("检查");
        checkIdBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton)e.getSource();
                
                btn.setEnabled(false);
                
                String idStr = idTF.getText().trim();
                
                if (idStr.length() == 0) {
                    JOptionPane.showMessageDialog(null, "身份证号不能为空！", 
                            "警告", JOptionPane.WARNING_MESSAGE);
                    
                    btn.setEnabled(true);
                    
                    return ;
                }
                
                int idRes = checkId(idStr);
                
                switch (idRes) {
                case 0:
                {
                    JOptionPane.showMessageDialog(null, "身份证号格式不正确！", 
                            "警告", JOptionPane.WARNING_MESSAGE);
                    
                    btn.setEnabled(true);
                    
                    return ;
                }
                case 2:
                {
                    JOptionPane.showMessageDialog(null, "数据库中已有该身份证号！", 
                            "警告", JOptionPane.ERROR_MESSAGE);
                    
                    btn.setEnabled(true);
                    
                    return ;
                }
                default:
                    break;
                }
                
                JOptionPane.showMessageDialog(null, "身份证号验证通过", 
                        "提示", JOptionPane.INFORMATION_MESSAGE);
                
                btn.setEnabled(true);
            }
        });
        checkIdBtn.setFont(new Font("宋体", Font.PLAIN, 12));
        checkIdBtn.setBounds(230, 16, 71, 25);
        contentPane.add(checkIdBtn);
        
        JLabel label_2 = new JLabel("性别：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 12));
        label_2.setBounds(60, 91, 36, 15);
        contentPane.add(label_2);
        
        ButtonGroup btnGroup = new ButtonGroup();
        
        maleRB = new JRadioButton("男");
        maleRB.setSelected(true);
        maleRB.setFont(new Font("宋体", Font.PLAIN, 12));
        maleRB.setBounds(99, 87, 45, 23);
        contentPane.add(maleRB);
        btnGroup.add(maleRB);
        
        femaleRB = new JRadioButton("女");
        femaleRB.setFont(new Font("宋体", Font.PLAIN, 12));
        femaleRB.setBounds(147, 87, 45, 23);
        contentPane.add(femaleRB);
        btnGroup.add(femaleRB);
        
        JLabel label_3 = new JLabel("年龄：");
        label_3.setFont(new Font("宋体", Font.PLAIN, 12));
        label_3.setBounds(60, 126, 36, 15);
        contentPane.add(label_3);
        
        ageTF = new JTextField();
        ageTF.setFont(new Font("宋体", Font.PLAIN, 12));
        ageTF.setColumns(10);
        ageTF.setBounds(99, 123, 93, 21);
        contentPane.add(ageTF);
        
        JLabel label_4 = new JLabel("民族：");
        label_4.setFont(new Font("宋体", Font.PLAIN, 12));
        label_4.setBounds(60, 161, 36, 15);
        contentPane.add(label_4);
        
        nationCB = new JComboBox();
        nationCB.setModel(new DefaultComboBoxModel(new String[] {"汉族", "蒙古族", "满族", "朝鲜族", "赫哲族", "达斡尔族", "鄂温克族", "鄂伦春族", "回族", "东乡族", "土族", "撒拉族", "保安族", "裕固族", "维吾尔族", "哈萨克族", "柯尔克孜族", "锡伯族", "塔吉克族", "乌孜别克族", "俄罗斯族", "塔塔尔族", "藏族", "门巴族", "珞巴族", "羌族", "彝族", "白族", "哈尼族", "傣族", "僳僳族", "佤族", "拉祜族", "纳西族", "景颇族", "布朗族", "阿昌族", "普米族", "怒族", "德昂族", "独龙族", "基诺族", "苗族", "布依族", "侗族", "水族", "仡佬族", "壮族", "瑶族", "仫佬族", "毛南族", "京族", "土家族", "黎族", "畲族", "高山族"}));
        nationCB.setFont(new Font("宋体", Font.PLAIN, 12));
        nationCB.setBounds(99, 157, 59, 23);
        contentPane.add(nationCB);
        
        JLabel label_5 = new JLabel("地址：");
        label_5.setFont(new Font("宋体", Font.PLAIN, 12));
        label_5.setBounds(60, 196, 36, 15);
        contentPane.add(label_5);
        
        addressTF = new JTextField();
        addressTF.setFont(new Font("宋体", Font.PLAIN, 12));
        addressTF.setColumns(10);
        addressTF.setBounds(99, 193, 202, 21);
        contentPane.add(addressTF);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBounds(336, 21, 121, 155);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        
        portraitLbl = new JLabel("无预览");
        portraitLbl.setHorizontalAlignment(SwingConstants.CENTER);
        portraitLbl.setFont(new Font("宋体", Font.PLAIN, 12));
        panel.add(portraitLbl, BorderLayout.CENTER);
        
        JButton selectPortraitBtn = new JButton("选择头像");
        selectPortraitBtn.setFont(new Font("宋体", Font.PLAIN, 12));
        selectPortraitBtn.setBounds(350, 186, 95, 25);
        contentPane.add(selectPortraitBtn);
        
        JButton recordBtn = new JButton("录入");
        recordBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton)e.getSource();
                
                btn.setEnabled(false);
                
                String idStr = idTF.getText().trim();
                
                if (idStr.length() == 0) {
                    JOptionPane.showMessageDialog(null, "身份证号不能为空！", 
                            "警告", JOptionPane.WARNING_MESSAGE);
                    
                    btn.setEnabled(true);
                    
                    return ;
                }
                
                int idRes = checkId(idStr);
                
                switch (idRes) {
                case 0:
                {
                    JOptionPane.showMessageDialog(null, "身份证号格式不正确！", 
                            "警告", JOptionPane.WARNING_MESSAGE);
                    
                    btn.setEnabled(true);
                    
                    return ;
                }
                case 2:
                {
                    JOptionPane.showMessageDialog(null, "数据库中已有该身份证号！", 
                            "警告", JOptionPane.ERROR_MESSAGE);
                    
                    btn.setEnabled(true);
                    
                    return ;
                }
                default:
                    break;
                }
                
                String nameStr = nameTF.getText().trim();
                
                if (nameStr.length() == 0) {
                    JOptionPane.showMessageDialog(null, "姓名不能为空！", 
                            "警告", JOptionPane.WARNING_MESSAGE);
                    
                    btn.setEnabled(true);
                    
                    return ;
                }
                
                int sex = (maleRB.isSelected()) ? 1 : 0;
                String ageStr = ageTF.getText().trim();
                
                if (ageStr.length() == 0) {
                    JOptionPane.showMessageDialog(null, "年龄不能为空！", 
                            "警告", JOptionPane.WARNING_MESSAGE);
                    
                    btn.setEnabled(true);
                    
                    return ;
                }
                
                if (!checkAge(ageStr)) {
                    JOptionPane.showMessageDialog(null, "年龄格式不对！", 
                            "警告", JOptionPane.WARNING_MESSAGE);
                    
                    btn.setEnabled(true);
                    
                    return ;
                }
                
                String nationStr = (String) nationCB.getSelectedItem();
                String addressStr = addressTF.getText().trim();
                
                CustomerInfo cusInfo = new CustomerInfo(idStr, nameStr, sex, ageStr,
                        nationStr, addressStr, portraitStr);
                RecordInfoAction act = new RecordInfoAction(cusInfo);
                
                boolean res = act.record();
                
                if (res) {
                    JOptionPane.showMessageDialog(null, "录入成功！", 
                            "提示", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "录入失败！", 
                            "警告", JOptionPane.ERROR_MESSAGE);
                }
                
                btn.setEnabled(true);
            }
        });
        recordBtn.setFont(new Font("宋体", Font.PLAIN, 12));
        recordBtn.setBounds(198, 264, 95, 25);
        contentPane.add(recordBtn);
        
        JLabel label_6 = new JLabel("*");
        label_6.setForeground(Color.RED);
        label_6.setFont(new Font("宋体", Font.PLAIN, 12));
        label_6.setBounds(25, 21, 21, 15);
        contentPane.add(label_6);
        
        JLabel label_7 = new JLabel("*");
        label_7.setForeground(Color.RED);
        label_7.setFont(new Font("宋体", Font.PLAIN, 12));
        label_7.setBounds(48, 56, 21, 15);
        contentPane.add(label_7);
        
        JLabel label_8 = new JLabel("*");
        label_8.setForeground(Color.RED);
        label_8.setFont(new Font("宋体", Font.PLAIN, 12));
        label_8.setBounds(48, 91, 21, 15);
        contentPane.add(label_8);
        
        JLabel label_9 = new JLabel("*");
        label_9.setForeground(Color.RED);
        label_9.setFont(new Font("宋体", Font.PLAIN, 12));
        label_9.setBounds(48, 126, 21, 15);
        contentPane.add(label_9);
        
        JLabel label_10 = new JLabel("*");
        label_10.setForeground(Color.RED);
        label_10.setFont(new Font("宋体", Font.PLAIN, 12));
        label_10.setBounds(48, 161, 21, 15);
        contentPane.add(label_10);
        
        JLabel label_11 = new JLabel("（以上带   的为必填项）");
        label_11.setFont(new Font("宋体", Font.PLAIN, 12));
        label_11.setBounds(99, 232, 138, 15);
        contentPane.add(label_11);
        
        JLabel label_12 = new JLabel("*");
        label_12.setForeground(Color.RED);
        label_12.setFont(new Font("宋体", Font.PLAIN, 12));
        label_12.setBounds(153, 232, 21, 15);
        contentPane.add(label_12);
        setLocationRelativeTo(null);
    }
    
    private int checkId(String aIdStr) {
        if (aIdStr == null)
            return 0;
        
        if (aIdStr.matches("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))" +
        		"(([0|1|2]\\d)|3[0-1])\\d{4}$")) {
            if ((new RecordInfoAction()).searchIdFromDB(aIdStr))
                return 2;
            
            return 1;
        }
        
        return 0;
    }
    
    private boolean checkAge(String aAgeStr) {
        if (aAgeStr == null)
            return false;
        
        if (aAgeStr.matches("^[1][8,9]{1}$|^[2-9]\\d{1}$"))
            return true;
        
        return false;
    }
}
