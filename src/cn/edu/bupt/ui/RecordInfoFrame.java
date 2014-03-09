package cn.edu.bupt.ui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class RecordInfoFrame extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    /**
     * Create the frame.
     */
    public RecordInfoFrame() {
        setTitle("信息录入");
        setIconImage(Toolkit.getDefaultToolkit().getImage(RecordInfoFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 511, 311);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("身份证号：");
        label.setFont(new Font("宋体", Font.PLAIN, 12));
        label.setBounds(35, 21, 71, 15);
        contentPane.add(label);
        
        textField = new JTextField();
        textField.setFont(new Font("宋体", Font.PLAIN, 12));
        textField.setBounds(99, 18, 121, 21);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel label_1 = new JLabel("姓名：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 12));
        label_1.setBounds(60, 56, 36, 15);
        contentPane.add(label_1);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("宋体", Font.PLAIN, 12));
        textField_1.setColumns(10);
        textField_1.setBounds(99, 53, 93, 21);
        contentPane.add(textField_1);
        
        JButton btnNewButton = new JButton("检查");
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));
        btnNewButton.setBounds(230, 16, 71, 25);
        contentPane.add(btnNewButton);
        
        JLabel label_2 = new JLabel("性别：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 12));
        label_2.setBounds(60, 91, 36, 15);
        contentPane.add(label_2);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("男");
        rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 12));
        rdbtnNewRadioButton.setBounds(99, 87, 45, 23);
        contentPane.add(rdbtnNewRadioButton);
        
        JRadioButton radioButton = new JRadioButton("女");
        radioButton.setFont(new Font("宋体", Font.PLAIN, 12));
        radioButton.setBounds(147, 87, 45, 23);
        contentPane.add(radioButton);
        
        JLabel label_3 = new JLabel("年龄：");
        label_3.setFont(new Font("宋体", Font.PLAIN, 12));
        label_3.setBounds(60, 126, 36, 15);
        contentPane.add(label_3);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("宋体", Font.PLAIN, 12));
        textField_2.setColumns(10);
        textField_2.setBounds(99, 123, 93, 21);
        contentPane.add(textField_2);
        
        JLabel label_4 = new JLabel("民族：");
        label_4.setFont(new Font("宋体", Font.PLAIN, 12));
        label_4.setBounds(60, 161, 36, 15);
        contentPane.add(label_4);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("宋体", Font.PLAIN, 12));
        comboBox.setBounds(99, 157, 59, 23);
        contentPane.add(comboBox);
        
        JLabel label_5 = new JLabel("地址：");
        label_5.setFont(new Font("宋体", Font.PLAIN, 12));
        label_5.setBounds(60, 196, 36, 15);
        contentPane.add(label_5);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("宋体", Font.PLAIN, 12));
        textField_3.setColumns(10);
        textField_3.setBounds(99, 193, 202, 21);
        contentPane.add(textField_3);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBounds(336, 21, 121, 155);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 12));
        panel.add(lblNewLabel, BorderLayout.CENTER);
        
        JButton btnNewButton_1 = new JButton("选择头像");
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 12));
        btnNewButton_1.setBounds(350, 186, 95, 25);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("录入");
        btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 12));
        btnNewButton_2.setBounds(197, 239, 95, 25);
        contentPane.add(btnNewButton_2);
        setLocationRelativeTo(null);
    }
}
