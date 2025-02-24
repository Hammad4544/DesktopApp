package lawyer.s_office;

import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Ahmed Hammad
 */
public class Tools {

    public static void openform(JFrame f) {
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(2);
        try {
            Image img = ImageIO.read(Tools.class.getResource("icon.jpeg"));
            f.setIconImage(img);
            f.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void creatFileProject(String name, Object problem) {
        try {
            PrintWriter w = new PrintWriter(name + ".txt");

            w.println(problem);

            w.close();
            JOptionPane.showMessageDialog(null, "شكرا لاستخدام البرنامج");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public static void clearText(Container form) {
        for (Component c : form.getComponents()) {
            if (c instanceof JTextField) {
                JTextField txt = (JTextField) c;
                txt.setText("");
            } else if (c instanceof Container) {
                clearText((Container) c);
            }

        }

    }

}

class lowerDto {

    public Long code;
    public String lowerName;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getLowerName() {
        return lowerName;
    }

    public void setLowerName(String lowerName) {
        this.lowerName = lowerName;
    }

}

class lowerList {

    ArrayList<lowerDto> lowerList;

    public void newListOfData() {

        lowerList = new ArrayList<lowerDto>();
        lowerDto dto1 = new lowerDto();
        dto1.setCode(1L);
        dto1.setLowerName("احمد");
        lowerDto dto2 = new lowerDto();
        dto2.setCode(2L);
        dto2.setLowerName("ندى");
        lowerDto dto3 = new lowerDto();
        dto3.setCode(3L);
        dto3.setLowerName("يحيي");
        lowerList.add(dto1);
        lowerList.add(dto2);
        lowerList.add(dto3);
    }

    public Long searchByName(String name) {
        newListOfData();
        for (lowerDto lowerDto : lowerList) {
            if (lowerDto.getLowerName().contains(name)) {
                return lowerDto.getCode();
            }
        }
        return null;

    }

}

class Person {

    private String User_Name;
    private String Email;
    private String Adress;
    private String Phone;
    private String Password;

    public Person(String User_Name, String Email, String Adress, String Phone, String Password) {
        this.User_Name = User_Name;
        this.Email = Email;
        this.Adress = Adress;
        this.Phone = Phone;
        this.Password = Password;
        Tools.creatFileProject(User_Name, Email);

    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String User_Name) {
        this.User_Name = User_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}

class Lawer extends Person {

    private String Specialty;

    public Lawer(String Specialty, String User_Name, String Email, String Adress, String Phone, String Password) {
        super(User_Name, Email, Adress, Phone, Password);
        this.Specialty = Specialty;
    }

    public String getSpecialty() {
        return Specialty;
    }

    public void setSpecialty(String Specialty) {
        this.Specialty = Specialty;
    }

}
