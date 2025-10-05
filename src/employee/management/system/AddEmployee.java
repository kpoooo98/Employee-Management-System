package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    Random ran  = new Random();

    int number = ran.nextInt(999999);
    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation;
   JLabel tempid;
    JDateChooser tdob;
    JButton add, back;

    JComboBox Boxeducation;

    AddEmployee() {

        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setFont(new Font("Serif", Font.BOLD, 16));
        heading.setBounds(320,30,500,25);
        add(heading);


        JLabel name = new JLabel("Name");
        name.setBounds(50, 150,150,30);
        name.setFont(new Font("Serif", Font.BOLD, 16));
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel fname = new JLabel("Name");
        fname.setBounds(50, 150,150,30);
        fname.setFont(new Font("Serif", Font.BOLD, 16));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(200, 150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50, 200,150,30);
        dob.setFont(new Font("Serif", Font.BOLD, 16));
        add(dob);

tdob = new JDateChooser();
tdob.setBackground(new Color(177,252,197));
tdob.setBounds(200, 200,150,30);
add(tdob);

        JLabel salary = new JLabel("salary");
        salary.setBounds(400 , 200,150,30);
        salary.setFont(new Font("Serif", Font.BOLD, 16));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250,150,30);
        address.setFont(new Font("Serif", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel phone = new JLabel("Phone");
        name.setBounds(400, 250,150,30);
        name.setFont(new Font("Serif", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);


        JLabel email = new JLabel("Email");
        email.setBounds(50, 300,150,30);
        email.setFont(new Font("Serif", Font.BOLD, 16));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);

        JLabel education = new JLabel("Highest Eduaction");
        education.setBounds(400, 300,150,30);
        education.setFont(new Font("Serif", Font.BOLD, 16));
        add(education);

String items[] = {"BBA", "B.Tech", "BCA", "BA", "BSC", "B.COM", "MCA", "MA", "Mtech"};
Boxeducation = new JComboBox(items);
Boxeducation.setBackground(new Color(177,252,197));
Boxeducation.setBounds(600, 300,150,30);
add(Boxeducation);

        JLabel aadhar = new JLabel("Aadhar number");
        aadhar.setBounds(400, 350,150,30);
        aadhar.setFont(new Font("Serif", Font.BOLD, 16));
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(600, 350,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        JLabel empid = new JLabel("Employee ID");
        email.setBounds(50, 400,150,30);
        email.setFont(new Font("Serif", Font.BOLD, 16));
        add(empid);

        tempid = new JLabel(""+number);
        tempid.setBounds(200, 400,150,30);
tempid.setFont(new Font("Serif", Font.BOLD, 20));
tempid.setForeground(Color.RED);
        add(tempid);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 300,150,30);
        designation.setFont(new Font("Serif", Font.BOLD, 16));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(600, 350,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        add = new JButton("ADD");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.RED);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.RED);
        add(back);


setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == add) {
            String name = tname.getText();
            String address = taddress.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String email = temail.getText();
            String phone = tphone.getText();
            String education = (String) Boxeducation.getSelectedItem();
            String designation = tdesignation.getText();
            String empid = tempid.getText();
            String aadhar = taadhar.getText();

            try {
                Conn c = new Conn();
                String query = "Insert into employee values('"+name+"', '" + fname + "', '" + dob + "','" + salary + "','" + education + "','" + designation + "','" + empid + "','" +address+ "','"+phone+ "','" +email+ "','"+aadhar+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Added");
                setVisible(false);
                new Main_class();
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new Main_class();

        }
    }
        public static void main(String[] args){
                new AddEmployee();
    }
}