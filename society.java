import java.sql.*;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.ResultSet;
import java.awt.FlowLayout;
import static javax.swing.GroupLayout.Alignment.*;
import java.awt.BorderLayout;
import javax.swing.border.*;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
class MP extends JFrame
{
    Statement sta;
    String Sql;
    ResultSet rs ;
    Container c;
    Container c1;
    JLabel lb1,lb2,lb3,lb4;
    TextField txt1;
    TextField password;
    JButton b1,b2,b3,b4,b5;
    JPasswordField pp;
    String ss;
    JComboBox cb1;
    MP()
    {
        c=getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(244, 236, 247 ));
        //c.setBounds(80,60,2000,1000);
        //c.setSize(650, 500);
        lb1 = new JLabel("User ID :");
        lb1.setFont(new Font("Comic Sans MS", 1, 14));
        lb1.setBounds(190,172,100,35);
        lb2 = new JLabel("Password :");
        lb2.setFont(new Font("Comic Sans MS", 1, 14));
        lb2.setBounds(185,212,100,35);
        lb4 = new JLabel("Housing Society Management System");
        lb4.setFont(new Font("Comic Sans MS", 1, 20)); // NOI18N3
        lb4.setBounds(100,40,600,40);
        txt1 = new TextField(15);
        txt1.setBounds(289,172,135,28);
        pp = new JPasswordField(15);
        pp.setEchoChar('*');
        pp.setBounds(290,212,135,28);
        b1 =  new JButton("Login");
        b1.setFont(new Font("Comic Sans MS", 1, 12));
        b1.setBounds(235,275,100,30);
        b2 =  new JButton("Register");
        b2.setFont(new Font("Comic Sans MS", 1, 12));
        b2.setBounds(235,325,100,30);
        cb1 = new JComboBox();
        cb1.setFont(new Font("Comic Sans MS", 1, 12)); // NOI18N
        cb1.setModel(new DefaultComboBoxModel<>(new String[] { "Resident", "Committee" }));
        //cb1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        cb1.setBounds(235,110,100,30);
        c.add(lb4);
        c.add(cb1);
        c.add(lb1);
        c.add(txt1);
        c.add(lb2);
        c.add(pp);
        c.add(b1);
        c.add(b2);
        //L1 a = new L1();
        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                String s1 = txt1.getText();
                String s2 = pp.getText();

                ss = cb1.getSelectedItem().toString(); //combo box
                if((s1.equals("138"))&&(s2.equals("Hello")))
                {
                    dispose(); //close the frame
                    resident o = new resident();
                    o.setSize(750, 684);
                    o.setLocationRelativeTo(null);
                }
                else if((s1.equals("147"))&&(s2.equals("ABCD")))
                {
                    dispose();
                    committee c = new committee();
                    c.setSize(850, 684);
                    c.setLocationRelativeTo(null);
                }
                else
                {
//                    lb3 = new JLabel("Incorrect ID or Password");
//                    c.add(lb3);
//                    setVisible(true);
                    JOptionPane.showMessageDialog(c,"Invalid ID or Password. Try Again !");
                }
        
        }               
    });
        
        b2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                newmember nm = new newmember();
                nm.setSize(600, 584);
                nm.setLocationRelativeTo(null);
            }
        });
//        b1.addActionListener(a);
        //b2.addActionListener(a);
    }
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        MP mm = new MP();
        //mm.setSize(245,250);
        mm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mm.setSize(571, 484);
        mm.setLocationRelativeTo(null);
        mm.setVisible(true);
    }
}
// for residents
class resident extends JFrame
{
    Container c;
    Container c1;
    JTextField txt1,txt2;
    JLabel lb1,lb2,lb3;
    JButton b1,b2,b3,b4,b5,b6;
    String ss;
    JComboBox cb1;
    resident()
    {
        setSize(400,250);
        setVisible(true);
//        dispose();
//                    o.b3.addActionListener(b);
        MP mp = new MP();
        c=getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(244, 236, 247 ));
        b3 =  new JButton("Helpers");
        b3.setFont(new Font("Comic Sans MS", 1, 15));
        b3.setBounds(150,40,100,40);
        b4 =  new JButton("Committee");
        b4.setFont(new Font("Comic Sans MS", 1, 15));
        b4.setBounds(300,40,160,40);
        b5 =  new JButton("Complain");
        b5.setFont(new Font("Comic Sans MS", 1, 15));
        b5.setBounds(500,40,160,40);
        b6 = new JButton("Logout");
        b6.setFont(new Font("Comic Sans MS", 1, 15));
        b6.setBounds(510,590,160,40);
        c.add(b3);
        c.add(b4);
        c.add(b5);
        c.add(b6);
        action_listener al = new action_listener();
        b3.addActionListener(al);
        b4.addActionListener(al);
        b5.addActionListener(al);
        b6.addActionListener(new ActionListener() //logout
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //MP mmr = new MP();
                dispose();
                MP mmr = new MP();
                mmr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mmr.setSize(571, 484);
                mmr.setLocationRelativeTo(null);
                mmr.setVisible(true);
            }
        });
    }
    public class action_listener implements ActionListener
    {
        JTable table1,table2,table3;
        JTable prevtable = null;
        @Override
        public void actionPerformed(ActionEvent k)
        {
            if(k.getSource()==b3)
            {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=master", "sa", 
                    "#Mahakali1972");

                    if(conn!=null)
                        System.out.println("Database Successfully connected");
                    Statement sta = conn.createStatement();
                    String s1 = "Select fname,lname,Age,address,contact_d from Workers";
                    ResultSet rs = sta.executeQuery(s1);
                    int i =1;
                    Object rowData[][] = {{"Sr No.","Fname", "Lname","Age","Address","Contact"}};
                    Object columnNames[] = {i,"fname", "lname","Age","address","contact_d"};
                    DefaultTableModel mTableModel = new DefaultTableModel(rowData, columnNames);
                    table1 = new JTable(mTableModel);
                    Object[] rows;
                    while(rs.next())
                    {
                        rows = new Object[]{i, rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
                        mTableModel.addRow(rows);
                        i++;
                    }
                    table1.setBounds(50,180,650,207);
                    c.add(table1);
                    prevtable=table1;
                    setVisible(true);
                }
                catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException f)
                {
                    f.printStackTrace();
                }
            }
            else if(k.getSource()==b4)
            {
                try {
                    prevtable.setVisible(false);
                    table1.setVisible(false);
                    //c.remove(table1);
                    setVisible(true);
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=master", "sa", 
                    "#Mahakali1972");

                    if (conn != null)
                        System.out.println("Database Successfully connected");
                    Statement sta = conn.createStatement();
                    String s1 = "Select mem_fname,m_lname,member_type,contact from Committee";
                    ResultSet rs = sta.executeQuery(s1);
                    int j=1;
                    Object rowData[][] = {{"Sr No.","Fname", "Lname","Position","Contact"}};
                    Object columnNames[] = {j,"mem_fname", "m_lname","member_type","contact"};
                    DefaultTableModel mTableModel = new DefaultTableModel(rowData, columnNames);
                    table2 = new JTable(mTableModel);
                    Object[] rows;
                    while (rs.next())
                    {
                        rows = new Object[]{j, rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)};
                        mTableModel.addRow(rows);
                        j++;
                    }
                    table2.setBounds(50,180,650,67);
                    c.add(table2);
                    prevtable = table2;
                    setVisible(true);
                }
                catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException f) {
                    f.printStackTrace();
                }
            }
            else if(k.getSource()==b5)
            {
                dispose();
                Comp cp = new Comp();
                cp.setSize(571, 500);
                cp.setLocationRelativeTo(null);
            }
        }
    }

}
// for committee members
class committee extends JFrame
{
    Container c;
    JTextField txt1, txt2;
    JLabel lb1, lb2, lb3, lb4;
    JButton b6, b7, b8, b9, b10,b11;
    String ss;
    JComboBox cb1;
    JTable table1,table2,table3,table4,table5;

    committee()
    {
        setSize(500,400);
        setVisible(true);
//        dispose();
//                    o.b3.addActionListener(b);
        MP mp = new MP();
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(244, 236, 247 ));
        b6 = new JButton("Helpers");
        b6.setFont(new Font("Comic Sans MS", 1, 15));
        b6.setBounds(40,40,120,40);
        b7 = new JButton("Committee");
        b7.setFont(new Font("Comic Sans MS", 1, 15));
        b7.setBounds(200,40,120,40);
        b8 = new JButton("Complain");
        b8.setFont(new Font("Comic Sans MS", 1, 15));
        b8.setBounds(360,40,120,40);
        b9 = new JButton("Tenant");
        b9.setFont(new Font("Comic Sans MS", 1, 15));
        b9.setBounds(520,40,120,40);
        b10 = new JButton("Owners");
        b10.setFont(new Font("Comic Sans MS", 1, 15));
        b10.setBounds(680,40,120,40);
        b11 = new JButton("Logout");
        b11.setFont(new Font("Comic Sans MS", 1, 15));
        b11.setBounds(680,600,120,40);
        c.add(b6);
        c.add(b7);
        c.add(b8);
        c.add(b9);
        c.add(b10);
        c.add(b11);
        committee.action_listener al = new committee.action_listener();
        b6.addActionListener(al);
        b7.addActionListener(al);
        b8.addActionListener(al);
        b9.addActionListener(al);
        b10.addActionListener(al);
        b11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                MP m1 = new MP();
                m1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m1.setSize(571, 484);
                m1.setLocationRelativeTo(null);
                m1.setVisible(true);
            }
        });
    }

    public class action_listener implements ActionListener
    {
        
        @Override
        public void actionPerformed(ActionEvent k)
        {
            JTable prevTable=null;
            //final DefaultListModel<String> l1 = new DefaultListModel<>();
            if (k.getSource()==b6)
            {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=master", "sa",
                    "#Mahakali1972");

                    if (conn != null){
                        System.out.println("Database Successfully connected");
                    Statement sta = conn.createStatement();
                   String s1 = "select *from CommiteeV where WID is NOT NULL";
                    //String s2 = "Select * from Works_for";
                     int i =1;
                    ResultSet rs1 = sta.executeQuery(s1);
                    Object rowData[][] = {{"Sr No","WID", "Fname", "Lname","Age","Address","Contact","FlatNum","BName"}};
                    Object columnNames[] = {i,"helperC1.WID", "helperC1.fname", "helperC1.lname","helperC1.Age","helperC1.address","helperC1.contact_d","House.flatnum","House.Bname"};
                    DefaultTableModel mTableModel = new DefaultTableModel(rowData, columnNames);
                   
                    table1 = new JTable(mTableModel);
                    Object[] rows;
                    while (rs1.next())
                    {
                        rows = new Object[]{i,rs1.getString(1), rs1.getString(2), rs1.getString(3),rs1.getString(4),rs1.getString(5),rs1.getString(6),rs1.getString(7),rs1.getString(8)};
                   mTableModel.addRow(rows);
                        i++;
                        //l1.addElement(rs.getString("WID")+" "+rs.getString("fname")+" "+rs.getString("lname")+"        "+rs.getString("Age")+" "+rs.getString("address")+" "+rs.getString("contact_d"));
                    }
                   
                    /*while(rs2.next())
                    {
                        rows = new Object[]{rs2.getString(1)};
                        mTableModel.addRow(rows);
                    }*/
                    //JList<String> list1 = new JList<>(l1);
                    //c.add(list1);
                    table1.setBounds(80,180,650,195);
                    c.add(table1);
                    //prevTable = table1;
                    table1.setVisible(true);
                }
            }
                catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException f)
                {
                    f.printStackTrace();
                }
            }
            else if(k.getSource()==b7)
            {
                try {
                     table1.setVisible(false);
                    //c.remove(table1);
                    setVisible(true);
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=master", "sa",
                    "#Mahakali1972");

                    if (conn != null){
                        System.out.println("Database Successfully connected");
                    Statement sta = conn.createStatement();

                    int j=1;
                    Object rowData[][] = {{"Sr No.","Fname", "Lname","Position","Contact"}};
                    Object columnNames[] = {j,"mem_fname", "m_lname","member_type","contact"};
                    DefaultTableModel mTableModel = new DefaultTableModel(rowData, columnNames);
                    table2 = new JTable(mTableModel);
                    Object[] rows;
                     String s1 = "Select mem_fname,m_lname,member_type,contact from Committee";
                    ResultSet rs = sta.executeQuery(s1);
                    while (rs.next())
                    {
                        rows = new Object[]{j, rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)};
                        mTableModel.addRow(rows);
                        j++;
                    }
                
                    table2.setBounds(100,180,650,67);
                    c.add(table2);
                    //prevTable=table2;
                    table2.setVisible(true);
                }
            }catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException f) {
                    f.printStackTrace();
                }
            }
            else if(k.getSource()==b8)
            {
                try {
                   
                 
                    table2.setVisible(false);
                    //c.remove(table1);
                    setVisible(true);
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=master", "sa", 
                    "#Mahakali1972");

                    if (conn != null){
                        System.out.println("Database Successfully connected");
                    Statement sta = conn.createStatement();
                    String s1 = "Select * from  Complaint";
                    int f=1;
                    Object rowData[][] = {{"Sr No.","Comp_ID", "Subject","Description","Date","Owner_Id"}};
                    Object columnNames[] = {f,"mem_fname", "m_lname","member_type","contact","date"};
                    DefaultTableModel mTableModel = new DefaultTableModel(rowData, columnNames);
                    table3 = new JTable(mTableModel);
                    Object[] rows;
                    int w=1;
                    ResultSet rs = sta.executeQuery(s1);
                    while (rs.next())
                    {
                        rows = new Object[]{w, rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
                        mTableModel.addRow(rows);
                        w++;
                    }
                    table3.setBounds(100,180,650,100);
                    c.add(table3);
                    
                    table3.setVisible(true);
                }
            }catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException f) {
                    f.printStackTrace();
                }
            }
            else if(k.getSource()==b9)
            {
                try {
                   
                    table3.setVisible(false);
                    //c.remove(table1);
                    setVisible(true);
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=master", "sa", 
                    "#Mahakali1972");

                    if (conn != null){
                        System.out.println("Database Successfully connected");
                    Statement sta = conn.createStatement();
                    String s1 = "select * from Ten3 where type = 'Rent'";
                    ResultSet rs = sta.executeQuery(s1);
                    int l=1;
                    Object rowData[][] = {{"Sr No.","Bname", "FloorNum","FlatNum","BHK","Type","ID","Hnum","Owner_Fname","Owner_Lname","Owner_Contact"}};
                    Object columnNames[] = {l,"Bname", "floornum","flatnum","BHK","type","ID","Hnum","fname","lname","contact_no"};
                    DefaultTableModel mTableModel = new DefaultTableModel(rowData, columnNames);
                    table4 = new JTable(mTableModel);
                    Object[] rows;
                    while (rs.next())
                    {
                        rows = new Object[]{l, rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)};
                        mTableModel.addRow(rows);
                        l++;
                    }
                    table4.setBounds(20,180,800,310);
                    c.add(table4);
                    table4.setVisible(true);
                } 
            }catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException f) {
                    f.printStackTrace();
                }
            }
            else if(k.getSource()==b10)
            {
                try {
                    //prevTable.setVisible(false);
                    table4.setVisible(false);
                    //c.remove(table1);
                    setVisible(true);
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=master", "sa", 
                    "#Mahakali1972");

                    if (conn != null){
                        System.out.println("Database Successfully connected");
                    Statement sta = conn.createStatement();
                    String s1 = "select top 10 * from Owner1";
                    ResultSet rs = sta.executeQuery(s1);
                    int m=1;
                    Object rowData[][] = {{"Sr No.","ID", "Fname","Lname","Age","Date of birth","Sex","Bname","FlatNum","BHK","Contact"}};
                    Object columnNames[] = {m,"ID", "fname","lname","age","DOB","sex","Bname","flatnum","BHK","contact_no"};
                    DefaultTableModel mTableModel = new DefaultTableModel(rowData, columnNames);
                    table5 = new JTable(mTableModel);
                    Object[] rows;
                    while (rs.next())
                    {
                        rows = new Object[]{m, rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)};
                        mTableModel.addRow(rows);
                        m++;
                    }
                    table5.setBounds(20,180,800,340);
                    c.add(table5);
                    //prevTable = table5;
                    table5.setVisible(true);
                } 
                }catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException f) {
                    f.printStackTrace();
                }
            }
        }

    }
}
// for new registration
class newmember extends JFrame
{
    Container c;
    JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8;
    JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9;
    JButton b1,b2;
    newmember()
    {
        c=getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(253, 237, 236));
        lb1 = new JLabel(" First name:");
        lb1.setFont(new Font("Comic Sans MS", 1, 19));
        lb1.setBounds(160,100,150,35);
        lb2 = new JLabel("Last name:");
        lb2.setFont(new Font("Comic Sans MS", 1, 19));
        lb2.setBounds(172,145,150,35);
        lb3 = new JLabel("Age:");
        lb3.setFont(new Font("Comic Sans MS", 1, 19));
        lb3.setBounds(229,185,150,35);
        lb4 = new JLabel("Date of Birth:");
        lb4.setFont(new Font("Comic Sans MS", 1, 19));
        lb4.setBounds(140,225,150,35);
        lb5 = new JLabel("Gender:");
        lb5.setFont(new Font("Comic Sans MS", 1, 19));
        lb5.setBounds(198,265,150,35);
        lb6 = new JLabel(" Contact No:");
        lb6.setFont(new Font("Comic Sans MS", 1, 19));
        lb6.setBounds(147,305,150,35);
        lb7 = new JLabel("Buldg name:");
        lb7.setFont(new Font("Comic Sans MS", 1, 19));
        lb7.setBounds(155,345,150,35);
        lb8 = new JLabel("Floor No:");
        lb8.setFont(new Font("Comic Sans MS", 1, 19));
        lb8.setBounds(174,385,150,35);
        lb9 = new JLabel("Fill in the details.");
        lb9.setFont(new Font("Comic Sans MS", 1, 20)); // NOI18N3
        lb9.setBounds(200,20,600,40);
        txt1 = new JTextField(10);
        txt1.setBounds(285,105,130,25);
        txt2 = new JTextField(10);
        txt2.setBounds(285,152,130,25);
        txt3 = new JTextField(10);
        txt3.setBounds(285,194,130,25);
        txt4 = new JTextField(10);
        txt4.setBounds(285,235,130,25);
        txt5 = new JTextField(10);
        txt5.setBounds(285,275,130,25);
        txt6 = new JTextField(10);
        txt6.setBounds(285,315,130,25);
        txt7 = new JTextField(10);
        txt7.setBounds(285,350,130,25);
        txt8 = new JTextField(10);
        txt8.setBounds(285,390,130,25);
        b1 = new JButton("Register");
        b1.setFont(new Font("Comic Sans MS", 1, 12));
        b1.setBounds(300,450,100,30);
        b2 = new JButton("Back");
        b2.setFont(new Font("Comic Sans MS", 1, 15));
        b2.setBounds(450,500,100,30);
        c.add(lb9);
        c.add(lb1);
        c.add(txt1);
        c.add(lb2);
        c.add(txt2);
        c.add(lb3);
        c.add(txt3);
        c.add(lb4);
        c.add(txt4);
        c.add(lb5);
        c.add(txt5);
        c.add(lb6);
        c.add(txt6);
        c.add(lb7);
        c.add(txt7);
        c.add(lb8);
        c.add(txt8);
        c.add(b1);
        c.add(b2);
        setVisible(true);
        b2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                MP mm = new MP();
                mm.setSize(600, 584);
                mm.setLocationRelativeTo(null);
                mm.setVisible(true);
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String t1  = txt1.getText();
                String t2 = txt2.getText();
                String t3 = txt3.getText();
                String t4 = txt4.getText();
                String t5 = txt5.getText();
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=master", "sa", 
                    "#Mahakali1972");

                    if (conn != null)
                        System.out.println("Database Successfully connected");
                    Statement sta = conn.createStatement();
                    String s1 = "insert into Owner values(?,?,?,?,?)";
                    PreparedStatement p1 = conn.prepareStatement(s1);
                    p1.setNString(1,t1);
                    p1.setNString(2,t2);
                    p1.setNString(3,t3);
                    p1.setNString(4,t4);
                    p1.setNString(5,t5);
                    int r = p1.executeUpdate();
                    if(r==1)
                    {
                        JOptionPane.showMessageDialog(c,"Successfully Registered ");
                    }
                } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException f) {
                    f.printStackTrace();
                }
            }
        });
    }
}
class Connect
{

    Connect() throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=master", "sa", "#Mahakali1972");

            if(conn!=null)
                System.out.println("Database Successfully connected");
            Statement sta = conn.createStatement();
        }
        catch (SQLException | InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
}
//for complaints
class Comp extends JFrame
{
    Container c;
    JTextField txt1,txt2,txt3,txt4;
    JLabel lb1,lb2,lb3,lb4,lb5;
    JButton b1,b2;
    Comp()
    {
        c=getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(253, 237, 236));
        lb1 = new JLabel("ID : ");
        lb1.setFont(new Font("Comic Sans MS", 1, 19));
        lb1.setBounds(190,80,90,35);
        lb2 = new JLabel("Date :");
        lb2.setFont(new Font("Comic Sans MS", 1, 19));
        lb2.setBounds(168,120,90,35);
        lb3 = new JLabel("Subject :");
        lb3.setFont(new Font("Comic Sans MS", 1, 19));
        lb3.setBounds(141,160,90,35);
        lb4 = new JLabel("Description :");
        lb4.setFont(new Font("Comic Sans MS", 1, 19));
        lb4.setBounds(106,200,125,35);
        lb5 = new JLabel("Fill in the details.");
        lb5.setFont(new Font("Comic Sans MS", 1, 20)); // NOI18N3
        lb5.setBounds(200,20,600,40);
        b1 = new JButton("Submit");
        b1.setFont(new Font("Comic Sans MS", 1, 12));
        b1.setBounds(235,275,100,30);
        b2 = new JButton("Back");
        b2.setFont(new Font("Comic Sans MS", 1, 15));
        b2.setBounds(400,400,100,30);
        txt1 = new JTextField(10);
        txt1.setBounds(250,85,130,25);
        txt2 = new JTextField(10);
        txt2.setBounds(250,130,130,25);
        txt3 = new JTextField(10);
        txt3.setBounds(250,170,130,25);
        txt4 = new JTextField(10);
        txt4.setBounds(250,208,130,25);
        c.add(lb5);
        c.add(lb1);
        c.add(txt1);
        c.add(lb2);
        c.add(txt2);
        c.add(lb3);
        c.add(txt3);
        c.add(lb4);
        c.add(txt4);
        c.add(b1);
        c.add(b2);
        setVisible(true);
        b2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                resident o = new resident();
                o.setSize(750, 684);
                o.setLocationRelativeTo(null);
            }
        });
        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String t1 = txt1.getText(); //ID
                    String t2 = txt2.getText();  //DATE 
                    String t3 = txt3.getText(); //subject
                    String t4 = txt4.getText(); //Description
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=master","sa",
                    "#Mahakali1972");
                    
                    if (conn != null){
                        System.out.println("Database Successfully connected");
                    Statement sta = conn.createStatement();
                    String s1 = "insert into Complaint values(?,?,?,?)";
                    PreparedStatement p1 = conn.prepareStatement(s1);
                    p1.setNString(1,t3);
                    p1.setNString(2,t4);
                    p1.setNString(3,t1);
                    p1.setNString(4,String.valueOf(t2));
                    int r = p1.executeUpdate();
                    if(r==1)
                    {
                        JOptionPane.showMessageDialog(c,"Complaint Registered");
                    }
                } 
            }
            catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException f) {
                    f.printStackTrace();
                }
            }
});
}
}

/*class lolo
{
    public static void main(String args[])
    {
        app aa = new app();
    }
}
class app {
    app() {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=master","sa","#Mahakali1972";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT *from Employee";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}*/

